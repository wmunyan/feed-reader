package org.hbr.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
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
class Image {
    @JacksonXmlProperty(isAttribute = true)
    String sizes;

    @JacksonXmlProperty(isAttribute = true)
    String srcset;

    @JacksonXmlText
    String value;
}
