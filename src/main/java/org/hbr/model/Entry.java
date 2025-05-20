package org.hbr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.KebabCaseStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
    "title", "id", "href", "contentType", "subjects", "updated", "published", "summary", "styles",
    "authors", "seriesLabel", "featureImageUri", "featureImageTitle", "content"
})
@JsonIgnoreProperties({"links", "categories"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Introspected
@Serdeable
class Entry implements Serializable {
    @JacksonXmlProperty(localName = "title")
    @JsonProperty("t")
    String title;

    String id;

    @JacksonXmlProperty(localName = "link")
    @JacksonXmlElementWrapper(useWrapping = false, localName = "link")
    List<Link> links;

    @JsonProperty("href")
    String getHref() {
        if (Objects.isNull(links) || links.isEmpty()) {
            return null;
        }
        return links.get(0).getHref();
    }

    @JsonProperty("contentType")
    String getContentType() {
        if (Objects.isNull(categories) || categories.isEmpty()) {
            return "";
        }
        for (int i = 0; i < categories.size(); i++) {
            Category c = categories.get(i);
            System.out.println(c.scheme);
            if (c.scheme.contentEquals("http://hbr.org/categorization/contentType")) {
                return c.label;
            }
        }
        return null;
    }

    @JsonProperty("subjects")
    List<String> getSubjects() {
        if (Objects.isNull(categories) || categories.isEmpty()) {
            return Collections.emptyList();
        }
        return categories.stream()
            .filter(c -> c.scheme.equals("http://hbr.org/categorization/hbp-subject"))
            .map(Category::getLabel)
            .toList();
    }

    String updated;

    String published;

    @JacksonXmlCData
    String summary;

    @JacksonXmlCData
    String styles;

    @JacksonXmlProperty(localName = "author")
    @JacksonXmlElementWrapper(useWrapping = false, localName = "author")
    List<Person> authors;

    @JacksonXmlProperty(localName = "series-label")
    @JacksonXmlCData
    @JsonProperty("series-label")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String seriesLabel;

    @JacksonXmlProperty(localName = "feature-image-uri")
    @JsonProperty("feature-image-uri")
    Image featureImageUri;

    @JacksonXmlProperty(localName = "feature-image-title")
    @JsonProperty("feature-image-title")
    String featureImageTitle;

    @JacksonXmlProperty(localName = "category")
    @JacksonXmlElementWrapper(useWrapping = false, localName = "category")
    List<Category> categories;

    @JacksonXmlCData
    String content;
}
