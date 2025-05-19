package org.hbr.model;

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
class Link {
    @JacksonXmlProperty(isAttribute = true)
    String href;

    @JacksonXmlProperty(isAttribute = true)
    String rel;

    @JacksonXmlProperty(isAttribute = true)
    String type;
}