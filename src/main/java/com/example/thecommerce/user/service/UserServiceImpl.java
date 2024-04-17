package com.example.thecommerce.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.thecommerce.user.dto.RequestUser;
import com.example.thecommerce.user.dto.ResponseUser;
import com.example.thecommerce.user.entity.User;
import com.example.thecommerce.user.enums.UserSort;
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

	@Override
	public List<ResponseUser> selectListUser(RequestUser.SearchData searchParam) {
		logger.debug("########USER_Search:page:{} pageSize:{} sort{}",searchParam.getPage(),searchParam.getPageSize(),searchParam.getSort());
		Sort pageSort = getPageSort(
			searchParam.getSort() == null || searchParam.getSort().isEmpty()? UserSort.CREATED_ASC: UserSort.valueOf(searchParam.getSort()));
		Pageable pageable = PageRequest.of(searchParam.getPage(), searchParam.getPageSize(), pageSort);
		Slice<User> userList = userRepository.findSliceBy(pageable);
		return  userList.stream().map(User::toDto).collect(Collectors.toList());
	}
	private Sort getPageSort(UserSort sortParam) {
		switch (sortParam) {
			case CREATED_ASC :
				return Sort.by("createdAt").ascending();
			case NAMEKOR_ASC :
				return Sort.by("nameKor").ascending();
		};
		//default
		return Sort.by("createdAt").ascending();
	}
}
