package com.ontop.spring.test.model.request;

import lombok.Data;


@Data
public class PaymentModel{
    public SourcePaymentModel source;
    public DestinationPaymentModel destination;
    public int amount;
}
