package com.restaurant.repository;

import java.util.List;

import com.restaurant.dto.StoreDto;

public interface RestaurantRepository {
	
	
	public List<StoreDto> getStoreAll();
	
	public List<StoreDto> getStoreByAdminId(String adminId);

}
