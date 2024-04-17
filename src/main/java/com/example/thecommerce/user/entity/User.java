package com.example.thecommerce.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.thecommerce.user.dto.RequestUser;

@Entity(name = "TB_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	//회원id
	private String userId;
	@Column(nullable = false)
	//비밀번호
	private String password;
	//닉네임
	@Column(nullable = false)
	private String nickname;
	//이름(한글)
	@Column
	private String nameKor;
	@Column
	//전화번호
	private String phoneNumber;
	@Column
	//이메일주소
	private String email;

	public User(String userId, String password, String nickname, String nameKor, String phoneNumber, String email) {
		this.userId = userId;
		this.password = password;
		this.nickname = nickname;
		this.nameKor = nameKor;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public User() {

	}

	public static User toEntity(RequestUser.InputData inputData){
		return new User(
			inputData.getUserId(),
			inputData.getPassword(),
			inputData.getNickname(),
			inputData.getNameKor(),
			inputData.getPhoneNumber(),
			inputData.getEmail()
		);
	}


}
