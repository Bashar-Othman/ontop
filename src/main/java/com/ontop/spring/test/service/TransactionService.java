package com.ontop.spring.test.service;

import com.ontop.spring.test.model.request.WalletTransactionRequest;
import com.ontop.spring.test.model.response.BalanceResponse;
import com.ontop.spring.test.model.response.TransactionResponse;

import org.springframework.stereotype.Service;

/**
 *
 * @author BasharOthman
 */
@Service
public interface TransactionService {

    TransactionResponse sendMoney(WalletTransactionRequest paymentRequest);

    BalanceResponse userBalance(String userId);

}
