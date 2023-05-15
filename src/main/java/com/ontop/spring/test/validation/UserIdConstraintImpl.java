package com.ontop.spring.test.validation;

import com.ontop.spring.test.exception.OnTopGeneralException;
import com.ontop.spring.test.exception.OnTopUserNotFoundException;
import com.ontop.spring.test.model.User;
import com.ontop.spring.test.service.UserService;
 
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author BasharOthman
 */
@Component
@RequiredArgsConstructor
public class UserIdConstraintImpl implements ConstraintValidator<UserIdConstraint, Long> {

    private final UserService userService;

    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {

        User user = userService.userByUserID(userId);
        if (userId != null && userId == 500) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("something bad happened").addConstraintViolation();

            throw new OnTopGeneralException("something bad happened");
        } else if (user == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("User ID " + userId + " Not Found ").addConstraintViolation();

            throw new OnTopUserNotFoundException("User ID " + userId + " Not Found ");

        }
        return userId != null && (userId > 0);
    }
}
