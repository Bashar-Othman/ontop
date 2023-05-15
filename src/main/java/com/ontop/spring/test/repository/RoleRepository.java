package com.ontop.spring.test.repository;

import com.ontop.spring.test.model.ERole;
import com.ontop.spring.test.model.Role;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
