package com.example.thecommerce.user.service;

import org.springframework.data.domain.Page;

import com.example.thecommerce.user.dto.RequestUser;

public interface UserService {
	public void insertUser(RequestUser.InputData user);
}
