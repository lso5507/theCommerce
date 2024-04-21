package com.example.thecommerce.user.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "실패에 대한 응답 값")
public class ErrorResponse {
	@Schema(title = "String 배열형태의 에러메시지들입니다.")
	private final List<String> message;
	@Schema(title = "HTTP 상태값")
	private final Integer code;

	public List<String> getMessage() {
		return message;
	}

	public Integer getCode() {
		return code;
	}


	public ErrorResponse(List<String> message, Integer code) {
		this.message = message;
		this.code = code;
	}
}
