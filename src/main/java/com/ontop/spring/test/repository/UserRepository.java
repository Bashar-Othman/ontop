package com.ontop.spring.test.repository;

import com.ontop.spring.test.model.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
  Optional<User> findByUsername(String username);
  
  User findByUserId(Long userId);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
