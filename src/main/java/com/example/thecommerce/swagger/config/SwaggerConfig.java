package com.example.thecommerce.swagger.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	info = @Info(title = "더커머스 API",
		description = "알맞는 명세서를 선택하세요.",
		version = "v1"))
@Configuration
public class SwaggerConfig {
	@Value("${domain.name}")
	private String domainName;

	@Bean
	public GroupedOpenApi MemberGroup() {
		return GroupedOpenApi.builder()
			.group("사용자API")
			.packagesToScan("com.example.thecommerce.user.controller")
			.build();
	}




}