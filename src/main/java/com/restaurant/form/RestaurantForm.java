package com.restaurant.form;

import java.util.List;

import com.restaurant.dto.StoreDto;

import lombok.Data;

@Data
public class RestaurantForm {
	
	
	private List<StoreDto> restaurantDtoList; 
	
	private int permission;
	
	private String adminId;
	
	
	private boolean empty;
}
