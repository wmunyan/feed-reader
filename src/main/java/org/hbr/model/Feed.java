package org.hbr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder(value = { "id", "title", "links", "updated", "number-of-entries", "entries" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Introspected
@Serdeable
@JacksonXmlRootElement(localName = "feed")
public class Feed implements Serializable {
    @JacksonXmlProperty(localName = "title")
    @JsonProperty("title")
    String title;

    @JacksonXmlProperty(localName = "id")
    @JsonProperty("id")
    String id;

    @JacksonXmlProperty(localName = "link")
    @JacksonXmlElementWrapper(useWrapping = false, localName = "link")
    List<Link> links;

    @JacksonXmlProperty(localName = "updated")
    @JsonProperty("updated")
    String updated;

    @JsonProperty("number-of-entries")
    int getNumberOfEntries() {
        return entries.size();
    }

    @JacksonXmlProperty(localName = "entry")
    @JacksonXmlElementWrapper(useWrapping = false, localName = "entry")
    List<Entry> entries;
}
