package com.example.thecommerce.user.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thecommerce.user.dto.RequestUser;
import com.example.thecommerce.user.dto.ResponseUser;
import com.example.thecommerce.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 사용자 기능을 위한 Controller
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * 사용자 생성
	 * @param reqUser
	 * @return
	 */
	@PostMapping("/join")
	public ResponseEntity<?>postUser(@Validated  @RequestBody RequestUser.InputData reqUser){
		logger.info("#######PostUserStart########");
		userService.insertUser(reqUser);
		logger.info("#######PostUserend########");
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	/**
	 * 사용자 목록 조회
	 * @param reqUser
	 * @return
	 */
	@GetMapping("/list")
	public ResponseEntity<?>selectListUser(@Validated  @ModelAttribute RequestUser.SearchData reqUser){
		logger.info("#######SelectListUserStart########");
		List<ResponseUser> responseUsers = userService.selectListUser(reqUser);
		logger.info("#######SelectListUserend########");
		return ResponseEntity.status(HttpStatus.OK).body(responseUsers);

	}
	/**
	 * 사용자  조회
	 * @param reqUser
	 * @return
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<?>selectUser(@PathVariable String userId){
		logger.info("#######SelectListUserStart########");
		ResponseUser responseUsers = userService.selectUser(userId);
		logger.info("#######SelectListUserend########");
		return ResponseEntity.status(HttpStatus.OK).body(responseUsers);

	}
	/**
	 * 사용자 정보 수정
	 */
	@PostMapping("/{userId}")
	public ResponseEntity<?>updateUser(@PathVariable String userId,@Validated @RequestBody  RequestUser.UpdateData reqUser){
		logger.info("#######UpdateUserStart########");
		ResponseUser responseUser = userService.updateUser(reqUser, userId);
		logger.info("#######UpdateUserEnd########");
		return ResponseEntity.status(HttpStatus.OK).body(responseUser);
	}

}
