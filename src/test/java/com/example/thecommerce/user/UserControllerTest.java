package com.example.thecommerce.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.thecommerce.ThecommerceApplication;
import com.example.thecommerce.user.dto.RequestUser;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest(classes = ThecommerceApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("local")
class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;


	private final ObjectMapper objectMapper=new ObjectMapper();

	RequestUser.InputData inputData = new RequestUser.InputData("leeseokwoon", "password12#", "LEESEOKWOON", "이석운",
		"01057145507", "leeseokwoon@naver.com");

	@DisplayName("회원가입 성공테스트")
	@Test
	public void userJoin() throws Exception{
		String json = objectMapper.writeValueAsString(inputData);
		MvcResult result = mockMvc.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isCreated())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.CREATED.value(),result.getResponse().getStatus());
	}
	@DisplayName("회원가입 유효성 실패(userId)테스트")
	@Test
	public void userJoinValidationUserId() throws Exception{
		inputData.setUserId(null);
		String json = objectMapper.writeValueAsString(inputData);
		MvcResult result = mockMvc.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isBadRequest())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),result.getResponse().getStatus());
	}
	@DisplayName("회원가입 유효성 실패(nickname)테스트")
	@Test
	public void userJoinValidationNickName() throws Exception{
		inputData.setNickname(null);
		String json = objectMapper.writeValueAsString(inputData);
		MvcResult result = mockMvc.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isBadRequest())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),result.getResponse().getStatus());
	}

	@DisplayName("회원가입 유효성 실패(userId)테스트")
	@Test
	public void userJoinValidationPassword() throws Exception{
		inputData.setPassword(null);
		String json = objectMapper.writeValueAsString(inputData);
		MvcResult result = mockMvc.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isBadRequest())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),result.getResponse().getStatus());
	}
	@DisplayName("회원가입 유효성 실패(email)테스트")
	@Test
	public void userJoinValidationEmail() throws Exception{
		inputData.setEmail("3242");
		String json = objectMapper.writeValueAsString(inputData);
		MvcResult result = mockMvc.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isBadRequest())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),result.getResponse().getStatus());
	}

}