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
public class Category {
    @JacksonXmlProperty(isAttribute = true)
    String term;
    @JacksonXmlProperty(isAttribute = true)
    String scheme;
    @JacksonXmlProperty(isAttribute = true)
    String label;
}
