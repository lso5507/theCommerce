package com.example.thecommerce.user.dto;

import org.springframework.util.Assert;


public class RequestUser {

	/**
	 * 유저 생성,유저 수정 DTO
	 * @Required(userId,password,nickname)
	 */

	public static class InputData{
		public InputData(String userId, String password, String nickname, String nameKor, String phoneNumber,
			String email) {
			this.userId = userId;
			this.password = password;
			this.nickname = nickname;
			this.nameKor = nameKor;
			this.phoneNumber = phoneNumber;
			this.email = email;
		}

		//회원id
		private String userId;
		//비밀번호
		private String password;
		//닉네임
		private String nickname;
		//이름(한글)
		private String nameKor;
		//전화번호
		private String phoneNumber;
		//이메일주소
		private String email;
		//유효성검사
		private boolean isValidation=true;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			if(password==null)this.isValidation=false;
			this.password = password;
		}

		public String getNickname() {
			return nickname;
		}

		public boolean isValidation() {
			return isValidation;
		}

		public void setNickname(String nickname) {
			if(nickname==null)this.isValidation=false;
			this.nickname = nickname;
		}

		public String getNameKor() {
			return nameKor;
		}

		public void setNameKor(String nameKor) {
			this.nameKor = nameKor;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

}
