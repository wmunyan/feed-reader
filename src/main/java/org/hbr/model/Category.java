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
public class Category implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    String term;
    @JacksonXmlProperty(isAttribute = true)
    String scheme;
    @JacksonXmlProperty(isAttribute = true)
    String label;
}
