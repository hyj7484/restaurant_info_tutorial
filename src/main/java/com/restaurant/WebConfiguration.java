package com.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.restaurant.constants.Constants;
import com.restaurant.interceptor.LoginInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
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
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(String.format("file:///%s", Constants.FILE_SAVE_PATH).replace("\\", "/"));
    }

}
