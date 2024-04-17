package com.example.thecommerce.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import com.example.thecommerce.user.dto.RequestUser;
import com.example.thecommerce.user.dto.ResponseUser;

public interface UserService {
	public void insertUser(RequestUser.InputData user);
	public List<ResponseUser> selectListUser(RequestUser.SearchData searchParam);
}
