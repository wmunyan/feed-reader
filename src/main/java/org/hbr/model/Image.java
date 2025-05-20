package org.hbr.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
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
class Image implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    String sizes;

    @JacksonXmlProperty(isAttribute = true)
    String srcset;

    @JacksonXmlText
    String value;
}
