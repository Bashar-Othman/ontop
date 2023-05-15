/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test.service.impl;

 
import com.ontop.spring.test.model.User;
import com.ontop.spring.test.repository.UserRepository;
import com.ontop.spring.test.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BasharOthman
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public List<User> readAll() {

        return userRepo.findAll();

    }

    public Optional<User> userInfoByName(String userName) {

        Optional<User> users = userRepo.findByUsername(userName);

        return users;

    }

    public User userByUserID(Long userId) {

        User users = userRepo.findByUserId(userId);

        return users;

    }
}
