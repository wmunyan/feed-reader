package org.hbr.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Introspected
class Person {
    String name;

    @JacksonXmlCData
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String bio;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String uri;

    @JacksonXmlProperty(localName = "twitter-handle")
    @JsonProperty("twitter-handle")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String twitter;
}
