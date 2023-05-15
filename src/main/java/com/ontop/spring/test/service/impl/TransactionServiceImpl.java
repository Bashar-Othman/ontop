package com.ontop.spring.test.service.impl;

 
import com.ontop.spring.test.model.User;
import com.ontop.spring.test.model.UserTransaction;
import com.ontop.spring.test.model.request.WalletTransactionRequest;
import com.ontop.spring.test.model.response.BalanceResponse;
import com.ontop.spring.test.model.response.TransactionResponse;
import com.ontop.spring.test.repository.UserRepository;
import com.ontop.spring.test.service.TransactionService;
import com.ontop.spring.test.service.UserTransactionService;
import com.squadio.model.UserTransactionModel;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
/**
 *
 * @author BasharOthman
 */
@RequiredArgsConstructor
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final UserRepository userRepository;
    private final UserTransactionService userTransactionService;

    @Override
    public TransactionResponse sendMoney(WalletTransactionRequest paymentRequest) {

        User user = userRepository.findByUserId(paymentRequest.getUserId());
        BigDecimal amountCalculationVal = walletAmountOperator(user.getWalletAmount(), paymentRequest.getAmount());
        user.setWalletAmount(amountCalculationVal);
        userRepository.save(user);

        return generatePaymentResponse(user);

    }

    private BigDecimal walletAmountOperator(BigDecimal currentAmount, BigDecimal requestAmount) {

        return currentAmount.add(requestAmount);

    }

    private TransactionResponse generatePaymentResponse(User user) {

        TransactionResponse paymentResponse = new TransactionResponse();
        paymentResponse.setAmount(user.getWalletAmount());
        paymentResponse.setUserId(user.getUserId());

        paymentResponse.setWalletTransactionId(Long.MAX_VALUE);
        return paymentResponse;
    }

    private Long generateTransactionId(UserTransactionModel userTransactionModel) {

        UserTransaction userTr = userTransactionService.createUserTransaction(userTransactionModel);
        return userTr.getTransactionId();
    }

    @Override
    public BalanceResponse userBalance(String userId) {

        User user = userRepository.findByUserId(Long.parseLong(userId));

        return generateBalanceResponse(user);

    }

    private BalanceResponse generateBalanceResponse(User user) {

        BalanceResponse balanceResponse = new BalanceResponse();

        balanceResponse.setBalance(user.getWalletAmount());
        balanceResponse.setUserId(user.getUserId());

        return balanceResponse;

    }

}
