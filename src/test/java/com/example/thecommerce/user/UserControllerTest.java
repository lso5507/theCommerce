package com.example.thecommerce.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.thecommerce.ThecommerceApplication;
import com.example.thecommerce.user.dto.RequestUser;
import com.example.thecommerce.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest(classes = ThecommerceApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("local")
class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private UserService userService;


	private final ObjectMapper objectMapper=new ObjectMapper();

	List<RequestUser.InputData> requestList;
	@BeforeEach
	public void beforeEach(){

		requestList= Arrays.asList(
			new RequestUser.InputData("leeseokwoon", "password12#", "LEESEOKWOON", "이석운",
				"01057145507", "leeseokwoon@naver.com"),
			new RequestUser.InputData("HonggilDong", "password12#", "HonggilDong", "홍길동",
				"01051234507", "HonggilDong@naver.com"),
			new RequestUser.InputData("Dooly", "password12#", "Dooly", "둘리",
				"01054444444", "Dooly@naver.com"),
			new RequestUser.InputData("Docheol", "password12#", "Docheol", "곽두철",
				"01055545554", "Docheol@naver.com")

		);
	}

	@DisplayName("회원가입 성공테스트")
	@Test
	public void userJoin() throws Exception{
		String json = objectMapper.writeValueAsString(requestList.get(0));
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
		requestList.get(0).setUserId(null);
		String json = objectMapper.writeValueAsString(requestList.get(0));
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
		requestList.get(0).setNickname(null);
		String json = objectMapper.writeValueAsString(requestList.get(0));
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
		requestList.get(0).setPassword(null);
		String json = objectMapper.writeValueAsString(requestList.get(0));
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
		requestList.get(0).setEmail("3242");
		String json = objectMapper.writeValueAsString(requestList.get(0));
		MvcResult result = mockMvc.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isBadRequest())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),result.getResponse().getStatus());
	}
	@DisplayName("유저목록 조회 테스트(생성날짜 오름차순)")
	@Test
	public void userSearchCreatedAsc() throws Exception {
		requestList.forEach(item->userService.insertUser(item));
		MultiValueMap<String, String> requestParam = new LinkedMultiValueMap<>();
		requestParam.set("page","0");
		requestParam.set("pageSize","10");
		requestParam.set("sort","CREATED_ASC");

		MvcResult result = mockMvc.perform(get("/api/user/list")
				.contentType(MediaType.APPLICATION_JSON)
				.params(requestParam))
			.andExpect(status().isOk())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
	}
	@DisplayName("유저목록 조회 테스트(이름 오름차순)")
	@Test
	public void userSearchNameKorAsc() throws Exception {
		requestList.forEach(item->userService.insertUser(item));
		MultiValueMap<String, String> requestParam = new LinkedMultiValueMap<>();
		requestParam.set("page","0");
		requestParam.set("pageSize","10");
		requestParam.set("sort","NAMEKOR_ASC");

		MvcResult result = mockMvc.perform(get("/api/user/list")
				.contentType(MediaType.APPLICATION_JSON)
				.params(requestParam))
			.andExpect(status().isOk())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
	}
	@DisplayName("유저목록 조회 테스트 page&&pageSize Is null")
	@Test
	public void userSearchPageAndPageSizeIsNull() throws Exception {
		requestList.forEach(item->userService.insertUser(item));
		MultiValueMap<String, String> requestParam = new LinkedMultiValueMap<>();
		requestParam.set("page",null);
		requestParam.set("pageSize",null);
		requestParam.set("sort","CREATED_ASC");

		MvcResult result = mockMvc.perform(get("/api/user/list")
				.contentType(MediaType.APPLICATION_JSON)
				.params(requestParam))
			.andExpect(status().isOk())
			.andReturn();
		// check the result
		Assertions.assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
	}
	@DisplayName("유저 수정")
	@Test
	public void userModify()throws Exception{
		userService.insertUser(requestList.get(0));
		requestList.get(0).setNickname("modifiedName");
		String json = objectMapper.writeValueAsString(requestList.get(0));
		MvcResult result = mockMvc.perform(post("/api/user/"+requestList.get(0).getUserId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isOk())
			.andReturn();
		Map responseUpdateData = objectMapper.readValue(result.getResponse().getContentAsString(), Map.class);
		Assertions.assertEquals(requestList.get(0).getNickname(),responseUpdateData.get("nickname"));
		// check the result
		// 실제 업데이트 처리가 되었는지 detail 조회로 테스트
		MvcResult modifiedResult = mockMvc.perform(get("/api/user/"+requestList.get(0).getUserId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isOk())
			.andReturn();
		Map responseSelectData = objectMapper.readValue(result.getResponse().getContentAsString(), Map.class);
		Assertions.assertEquals(requestList.get(0).getNickname(),responseSelectData.get("nickname"));
		Assertions.assertEquals(HttpStatus.OK.value(),modifiedResult.getResponse().getStatus());
	}
	@DisplayName("유저 수정(패스워드변경)")
	@Test
	public void userModifyPassword()throws Exception{
		userService.insertUser(requestList.get(0));
		requestList.get(0).setPassword("qwer1234@");
		String json = objectMapper.writeValueAsString(requestList.get(0));
		MvcResult result = mockMvc.perform(post("/api/user/"+requestList.get(0).getUserId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andExpect(status().isOk())
			.andReturn();
		Map responseUpdateData = objectMapper.readValue(result.getResponse().getContentAsString(), Map.class);
		Assertions.assertEquals(requestList.get(0).getNickname(),responseUpdateData.get("nickname"));

	}
}