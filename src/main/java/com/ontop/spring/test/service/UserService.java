package com.ontop.spring.test.service;

import com.ontop.spring.test.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BasharOthman
 */
@Service
public interface UserService {

    public List<User> readAll();

    public Optional<User> userInfoByName(String userName);

    public User userByUserID(Long userId);

}
