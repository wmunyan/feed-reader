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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
    "title", "id", "href", "updated", "published", "summary", "styles", "authors", "seriesLabel",
    "featureImageUri", "featureImageTitle", "categories", "content"
})
@JsonIgnoreProperties({"links"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Introspected
@Serdeable
class Entry implements Serializable {
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
