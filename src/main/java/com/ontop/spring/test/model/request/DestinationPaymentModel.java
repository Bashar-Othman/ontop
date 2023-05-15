package com.ontop.spring.test.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ontop.spring.test.model.AccountPaymentModel;
import lombok.Data;

@Data
public class DestinationPaymentModel {

    @JsonProperty("name")
    public String name;

    @JsonProperty("account")
    public AccountPaymentModel account;
}
