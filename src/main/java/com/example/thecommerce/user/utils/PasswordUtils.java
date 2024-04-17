package com.example.thecommerce.user.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public  class PasswordUtils {

	public  String hashPassword(String plainPassword){
		return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
	}
}
