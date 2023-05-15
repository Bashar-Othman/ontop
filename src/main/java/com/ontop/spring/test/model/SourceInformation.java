package com.ontop.spring.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SourceInformation {

    @JsonProperty("name")
    public String name;
}
