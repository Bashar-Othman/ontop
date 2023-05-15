package com.ontop.spring.test.model.request;

import com.ontop.spring.test.validation.AmountConstraint;
 import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author BasharOthman
 */
@Data
@RequiredArgsConstructor
public class BeneficiaryRequest {

    @NotNull(message = " First Name must be Not Null")
    private String firstName;

    @NotNull(message = " Last Name must be Not Null")
    private String lastName;

    @NotNull(message = " Routing Number   must be Not Null")
    private Long routingNumber;

    @NotNull(message = "National ID  must be Not Null")
    private String nationalIdentificationNumber;

    @NotNull(message = "Account Number be Not Null")
    private String accountNumber;

    @AmountConstraint
    private BigDecimal amount;
}
