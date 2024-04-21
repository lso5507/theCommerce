package com.example.thecommerce.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.util.Assert;

import net.bytebuddy.implementation.bind.annotation.Default;

import io.swagger.v3.oas.annotations.media.Schema;

public class RequestUser {

	/**
	 * 유저 생성,
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
		@NotBlank(message="유저아이디는 필수 입력값입니다.")
		@Schema(description = "유저ID")
		private String userId;
		//비밀번호
		@NotBlank(message="비밀번호는 필수 입력값입나디.")
		@Size(min = 8,message = "비밀번호의 최소 자릿수는 8 입니다.")
		@Schema(description = "비밀번호")
		private String password;
		@NotBlank(message="닉네임은 필수 입력값입니다.")
		@Schema(description = "닉네임")
		//닉네임
		private String nickname;
		//이름(한글)
		@Schema(description = "사용자명(한글)")
		private String nameKor;
		//전화번호
		@Schema(description = "휴대폰번호")
		private String phoneNumber;
		//이메일주소
		@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
		@Schema(description = "이메일주소",example = "lso5507@gmail.com")
		private String email;

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
			this.password = password;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
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

	/**
	 * 유저수정 DTO
	 */
	public static class UpdateData{
		public UpdateData(String userId, String password, String nickname, String nameKor, String phoneNumber,
			String email) {
			this.userId = userId;
			this.password = password;
			this.nickname = nickname;
			this.nameKor = nameKor;
			this.phoneNumber = phoneNumber;
			this.email = email;
		}

		//회원id
		@Schema(description = "회원ID")
		private String userId;
		//비밀번호
		@Schema(description = "비밀번호")
		private String password;
		//닉네임
		@Schema(description = "닉네임")
		private String nickname;
		//이름(한글)
		@Schema(description = "사용자이름(한글명)")
		private String nameKor;
		//전화번호
		@Schema(description = "휴대폰번호")
		private String phoneNumber;
		//이메일주소
		@Schema(description = "이메일주소",example = "lso5507@gmail.com")
		@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
		private String email;

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
			this.password = password;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
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
	public static class SearchData{
		@Schema(description = "페이지번호",defaultValue = "0")
		private Integer page;
		@Schema(description = "페이지크기",defaultValue = "10")
		private Integer pageSize;
		@Schema(description = "정렬순위",defaultValue = "CREATED_ASC")
		private String sort;

		public SearchData(Integer page, Integer pageSize, String sort) {
			this.page = page;
			this.pageSize = pageSize;
			this.sort = sort;
		}

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			if(pageSize==null) this.pageSize=10;
			else this.pageSize = pageSize;

		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			if(page==null) this.page=0;
			else this.page = page;
		}
	}
}
