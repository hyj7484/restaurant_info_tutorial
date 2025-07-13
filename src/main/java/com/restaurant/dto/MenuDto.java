package com.restaurant.dto;

import lombok.Data;

@Data
public class MenuDto {
	private int id;
	private int storeId;
	private String menu;
	private int price;
	private String content;
}
