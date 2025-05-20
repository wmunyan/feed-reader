package org.hbr.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Serdeable
@Introspected
class Link implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    String href;

    @JacksonXmlProperty(isAttribute = true)
    String rel;

    @JacksonXmlProperty(isAttribute = true)
    String type;
}