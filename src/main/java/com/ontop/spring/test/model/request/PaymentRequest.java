package com.ontop.spring.test.model.request;

import com.ontop.spring.test.model.DestinationPaymentModel;
import com.ontop.spring.test.model.SourcePaymentModel;
import com.fasterxml.jackson.annotation.JsonProperty;
 import java.math.BigDecimal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author BasharOthman
 */
@Data
public class PaymentRequest {

    @JsonProperty("source")
    private SourcePaymentModel sourceModel;

    @JsonProperty("destination")
    private DestinationPaymentModel destinationPaymentModel;
    @JsonProperty("amount")
    private BigDecimal amount;

}
