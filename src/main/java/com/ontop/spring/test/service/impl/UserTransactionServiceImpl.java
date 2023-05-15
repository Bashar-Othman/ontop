package com.ontop.spring.test.service.impl;

 
import com.ontop.spring.test.model.UserTransaction;
import com.ontop.spring.test.service.UserTransactionService;
import com.squadio.model.UserTransactionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BasharOthman
 */
@Service
@Transactional
public class UserTransactionServiceImpl implements UserTransactionService {

    @Override
    public UserTransaction createUserTransaction(UserTransactionModel userTransactionModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
