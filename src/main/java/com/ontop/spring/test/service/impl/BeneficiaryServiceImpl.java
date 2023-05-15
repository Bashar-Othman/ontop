package com.ontop.spring.test.service.impl;

 
import com.ontop.spring.test.model.Beneficiary;
import com.ontop.spring.test.model.BeneficiaryTransaction;
import com.ontop.spring.test.model.request.BeneficiaryRequest;
import com.ontop.spring.test.model.request.PaymentInfoModel;
import com.ontop.spring.test.model.request.RequestPaymentInfoModel;
import com.ontop.spring.test.model.response.BeneficiaryResponse;
import com.ontop.spring.test.model.response.PaymentResponse;
import com.ontop.spring.test.repository.BeneficiaryRepo;
import com.ontop.spring.test.repository.BeneficiaryTransactionRepo;
import com.ontop.spring.test.service.BeneficiaryService;
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
@RequiredArgsConstructor
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

    private final BeneficiaryRepo beneficiaryRepo;
    private final BeneficiaryTransactionRepo beneficiaryTransactionRepo;

    private final ModelMapper modelMapper;

    @Override
    public BeneficiaryResponse createBeneficiary(BeneficiaryRequest beneficiaryRequest) {

        Beneficiary beneficiary = modelMapper.map(beneficiaryRequest, Beneficiary.class);
        beneficiary.setId(""+beneficiaryRepo.count()+1);
        beneficiaryRepo.save(beneficiary);

        return new BeneficiaryResponse();

    }

    @Override
    public PaymentResponse sendMoney(BeneficiaryRequest beneficiaryRequest) {

        String accountNumber = beneficiaryRequest.getAccountNumber();
        Beneficiary beneficiary = beneficiaryRepo.findByAccountNumber(accountNumber);

        if (beneficiary == null) {
            beneficiary = createBeneficiaryFirstTime(beneficiaryRequest);
        }
        BeneficiaryTransaction beneficiaryTransaction = createBeneficiaryTransaction(beneficiary);
        beneficiaryTransactionRepo.save(beneficiaryTransaction);

        return generateBeneficiaryResponse(beneficiaryTransaction);

    }

    @Override
    public BeneficiaryResponse updateBeneficiary(BeneficiaryRequest beneficiaryRequest) {

        return new BeneficiaryResponse();

    }

    private Beneficiary createBeneficiaryFirstTime(BeneficiaryRequest beneficiaryRequest) {

        Beneficiary beneficiary = modelMapper.map(beneficiaryRequest, Beneficiary.class);
        beneficiary.setId("" + beneficiaryRepo.count() + 1);
        beneficiaryRepo.save(beneficiary);

        return beneficiary;

    }

    private BeneficiaryTransaction createBeneficiaryTransaction(Beneficiary beneficiary) {

        BeneficiaryTransaction beneficiaryTransaction = new BeneficiaryTransaction();
        beneficiaryTransaction.setId("" + beneficiaryTransactionRepo.count());
        beneficiaryTransaction.setAccountNumber(beneficiary);
        beneficiaryTransaction.setStatus("COMPLETED");
        beneficiaryTransaction.setDate(new Timestamp(System.currentTimeMillis()));

        beneficiaryTransaction.setAmount(calculateFee(beneficiaryTransaction.getAmount()));

        return beneficiaryTransaction;

    }

    private BigDecimal calculateFee(BigDecimal amount) {

        float fee = amount.floatValue() - (10 / 100);
        return amount.subtract(new BigDecimal(fee));

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
