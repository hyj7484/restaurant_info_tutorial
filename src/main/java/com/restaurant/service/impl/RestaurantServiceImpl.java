package com.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.StoreDto;
import com.restaurant.form.RestaurantForm;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	
	@Autowired
	RestaurantRepository repository;
	
	public boolean init(RestaurantForm form) throws Exception {
		List<StoreDto> storeDtoList = null;
		switch(form.getPermission()) {
		case 1 :
			storeDtoList = repository.getStoreByAdminId(form.getAdminId());
			break;
		case 2 :
			storeDtoList = repository.getStoreAll();
			break;
		default :
			return true;
		}
		
		form.setRestaurantDtoList(storeDtoList);
		return false;
	}


}
