package com.restaurant.dto;

import lombok.Data;

@Data
public class StoreDto {
	int id;
	String storeName;
	String businessTimeStart;
	String businessTimeEnd;
	String storeContent;
	String adminId;
	String address;
	String phone;
	String storeImage;
}
