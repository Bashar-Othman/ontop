package com.ontop.spring.test.repository;

import com.ontop.spring.test.model.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BasharOthman
 */
@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransaction, String> {

}
