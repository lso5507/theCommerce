package com.example.thecommerce.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thecommerce.user.dto.RequestUser;
import com.example.thecommerce.user.entity.User;
import com.example.thecommerce.user.repository.UserRepository;
import com.example.thecommerce.user.utils.PasswordUtils;

@Service
public class UserServiceImpl implements UserService{
	Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordUtils passwordUtils;
	@Override
	public void insertUser(RequestUser.InputData userDto) {
		logger.debug("########USER_SAVE:userId:{}",userDto.getUserId());
		userDto.setPassword(passwordUtils.hashPassword(userDto.getPassword()));
		userRepository.save(User.toEntity(userDto));
	}
}
