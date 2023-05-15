package com.ontop.spring.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountPaymentModel {

    @JsonProperty("accountNumber")
    public String accountNumber;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("routingNumber")
    public String routingNumber;
}
