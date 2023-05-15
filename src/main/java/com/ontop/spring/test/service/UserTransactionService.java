package com.ontop.spring.test.service;

import com.ontop.spring.test.model.UserTransaction;
import com.squadio.model.UserTransactionModel;
import org.springframework.stereotype.Service;

/**
 *
 * @author BasharOthman
 */
@Service
public interface UserTransactionService {

    UserTransaction createUserTransaction(UserTransactionModel userTransactionModel);
}
