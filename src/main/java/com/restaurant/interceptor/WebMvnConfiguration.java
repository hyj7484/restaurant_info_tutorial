package com.restaurant.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvnConfiguration implements WebMvcConfigurer {
	
	@Autowired
	LoginInterceptor loginInterceptor;
	
	private static final String[] EXCLUIDE_PATH = {
			"/login",
			"/register"
	};
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.excludePathPatterns(EXCLUIDE_PATH)	// interceptor対象外パス
		.addPathPatterns("/**"); // interceptor対象パス
	}
	

}
