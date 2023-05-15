package com.ontop.spring.test.service.impl;

import com.ontop.spring.test.exception.OnTopBeneficiaryNotFoundException;
import com.ontop.spring.test.model.Beneficiary;
import com.ontop.spring.test.model.BeneficiaryTransaction;
import com.ontop.spring.test.model.request.BeneficiaryRequest;
import com.ontop.spring.test.model.request.PaymentInfoModel;
import com.ontop.spring.test.model.request.PaymentRequest;
import com.ontop.spring.test.model.request.RequestPaymentInfoModel;
import com.ontop.spring.test.model.response.PaymentResponse;
import com.ontop.spring.test.repository.BeneficiaryRepo;
import com.ontop.spring.test.repository.BeneficiaryTransactionRepo;
import com.ontop.spring.test.service.BeneficiaryService;
import com.ontop.spring.test.service.PaymentService;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author BasharOthman
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final BeneficiaryService beneficiaryService;
    private final ModelMapper modelMapper;

    private final BeneficiaryRepo beneficiaryRepo;
    private final BeneficiaryTransactionRepo beneficiaryTransactionRepo;

    @Override
    public PaymentResponse sendMoney(PaymentRequest paymentRequest) {

        String accountNumber = paymentRequest.getDestinationPaymentModel().getAccount().getAccountNumber();
        Beneficiary beneficiary = beneficiaryRepo.findByAccountNumber(accountNumber);
        System.out.println("Beneficiary Account Number : " + beneficiary+" , accountNumber req "+accountNumber);
        if (beneficiary == null) {
            // beneficiary = createBeneficiaryFirstTime(beneficiaryRequest);
            throw new OnTopBeneficiaryNotFoundException("Beneficiary's Account Number Not found");
        }
        BeneficiaryTransaction beneficiaryTransaction = createBeneficiaryTransaction(beneficiary, paymentRequest);
        System.out.println("beneficiaryTransaction ::: "+beneficiaryTransaction);
        beneficiaryTransactionRepo.save(beneficiaryTransaction);
        beneficiary.setAmount(beneficiaryTransaction.getAmount().add(beneficiary.getAmount()));
        beneficiaryRepo.save(beneficiary);
        return generateBeneficiaryResponse(beneficiaryTransaction);
    }


    private BeneficiaryTransaction createBeneficiaryTransaction(Beneficiary beneficiary, PaymentRequest paymentRequest) {

        BeneficiaryTransaction beneficiaryTransaction = new BeneficiaryTransaction();
        beneficiaryTransaction.setId("" + beneficiaryTransactionRepo.count());
        beneficiaryTransaction.setAccountNumber(beneficiary);
        beneficiaryTransaction.setStatus("COMPLETED");
        beneficiaryTransaction.setDate(new Timestamp(System.currentTimeMillis()));

        beneficiaryTransaction.setAmount(calculateFee(paymentRequest.getAmount()));

        return beneficiaryTransaction;

    }

    private BigDecimal calculateFee(BigDecimal amount) {

        // f//loat fee = amount.floatValue() - (10 / 100);
        // BigDecimal res = amount.subtract(new BigDecimal(fee));
        // System.out.println(res);
        return amount;

    }

    private PaymentResponse generateBeneficiaryResponse(BeneficiaryTransaction beneficiaryTransaction) {
        PaymentResponse paymentResponse = new PaymentResponse();

        PaymentInfoModel pyi = new PaymentInfoModel();
        pyi.setAmount(beneficiaryTransaction.getAmount());
        pyi.setId("" + new Random(System.currentTimeMillis()).nextLong());
        paymentResponse.setPaymentInfor(pyi);

        RequestPaymentInfoModel requestPaymentInfoModel = new RequestPaymentInfoModel();
        requestPaymentInfoModel.setStatus("complteted");

        paymentResponse.setRequestPaymentInfoModel(requestPaymentInfoModel);

        return paymentResponse;

    }

}
