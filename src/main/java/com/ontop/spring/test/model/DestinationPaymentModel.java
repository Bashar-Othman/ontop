package com.ontop.spring.test.model;

import com.ontop.spring.test.model.AccountPaymentModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DestinationPaymentModel {

    @JsonProperty("name")
    public String name;

    @JsonProperty("account")
    public AccountPaymentModel account;
}
