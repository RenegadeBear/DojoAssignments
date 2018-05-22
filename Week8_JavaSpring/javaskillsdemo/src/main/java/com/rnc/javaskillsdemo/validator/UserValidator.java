package com.rnc.javaskillsdemo.validator;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rnc.javaskillsdemo.models.User;
import com.rnc.javaskillsdemo.services.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    UserService userService;
	
    //    1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }
        
    	User existing = userService.findByUsername(user.getUsername());

		if (existing != null){
			errors.rejectValue("username", "Exists");
		}

    }
    

    
}
