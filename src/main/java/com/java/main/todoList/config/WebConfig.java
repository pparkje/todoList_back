package com.java.main.todoList.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**")				// 모든경로
		.allowedOrigins("http://localhost:3000")	// 프론트단 주소
		.allowedMethods("*");						// 모든 method : get,post 등등
	}
}
