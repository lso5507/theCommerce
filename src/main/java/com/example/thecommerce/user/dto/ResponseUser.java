package com.example.thecommerce.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.thecommerce.user.entity.User;

public class ResponseUser {
	private String userId;
	//닉네임
	private String nickname;
	//이름(한글)
	private String nameKor;
	//전화번호
	private String phoneNumber;
	//이메일주소
	private String email;

	public String getUserId() {
		return userId;
	}



	public String getNickname() {
		return nickname;
	}

	public String getNameKor() {
		return nameKor;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public ResponseUser(String userId, String nickname, String nameKor, String phoneNumber,
		String email) {
		this.userId = userId;
		this.nickname = nickname;
		this.nameKor = nameKor;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}
