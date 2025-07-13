package com.restaurant.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.restaurant.dto.StoreDto;
import com.restaurant.form.RestaurantForm;

@Mapper
public interface RestaurantRepository {
	
	
	public List<StoreDto> getStoreAll();
	
	public List<StoreDto> getStoreByAdminId(String adminId);
	
	public int insertRestaurant(RestaurantForm restaurantForm);
	
	public int deleteRestaurant(int id);
	
	public StoreDto getStoreByPK(@Param("id") int id);
	
	public int updateStoreByPk(RestaurantForm restaurantForm);

}
