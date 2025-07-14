package com.restaurant;

import java.io.File;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurant.constants.Constants;

@SpringBootApplication
//@MapperScan("com.restaurant.repository")
public class RestaurantInfoApplication {

	public static void main(String[] args) {
		createImagesFolder();
		
		SpringApplication.run(RestaurantInfoApplication.class, args);
	}
	
	private static void createImagesFolder() {
		File file = new File(Constants.FILE_SAVE_PATH);
		if(!file.exists()) {
			file.mkdir();
		}
	}

}
