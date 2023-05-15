package com.ontop.spring.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SourcePaymentModel {

    @JsonProperty("type")
    public String type;

    @JsonProperty("sourceInformation")
    public SourceInformation sourceInformation;

    @JsonProperty("account")
    public AccountPaymentModel account;
}
