package com.example.thecommerce.user.controller;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thecommerce.user.dto.RequestUser;
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
	public ResponseEntity<?>postUser(@RequestBody RequestUser.InputData reqUser){
		logger.info("#######PostUserStart########");
		if(!reqUser.isValidation()){
			//Bad Request
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		userService.insertUser(reqUser);
		logger.info("#######PostUserend########");
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

}
