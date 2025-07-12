package com.restaurant.dto;

import lombok.Data;

@Data
public class UserDto {
	private String id;
	private String password;
	private String userName;
	private int permission;

}
