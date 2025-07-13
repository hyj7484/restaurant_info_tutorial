package com.restaurant.service;

import com.restaurant.form.RestaurantForm;

public interface RestaurantService {
	public boolean init(RestaurantForm form) throws Exception;
	
	public boolean insertRestaurant(RestaurantForm restaurantForm) throws Exception;
	
	public boolean deleteRestaurant(String id) throws Exception;
	
	public boolean editRestaurantInit(RestaurantForm restaurantForm) throws Exception;
	
	public boolean editRestaurant(RestaurantForm restaurantForm) throws Exception;

}
