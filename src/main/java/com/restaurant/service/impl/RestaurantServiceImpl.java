package com.restaurant.service.impl;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.constants.Constants;
import com.restaurant.dto.StoreDto;
import com.restaurant.form.RestaurantForm;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	
	@Autowired
	RestaurantRepository repository;
	
	public boolean init(@ModelAttribute RestaurantForm form) throws Exception {
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
		
		for(StoreDto dto : storeDtoList) {
			dto.setStoreContent(dto.getStoreContent().replace("\r\n", "<br />"));
		}
		form.setRestaurantDtoList(storeDtoList);
		return false;
	}

	@Transactional
	public boolean insertRestaurant(RestaurantForm restaurantForm) throws Exception {
		// TODO Auto-generated method stub
		int cnt = repository.insertRestaurant(restaurantForm);
		if(cnt == 0) {
			return true;
		}
		
		MultipartFile file = restaurantForm.getStoreImgFile();
		String filePath = Constants.FILE_SAVE_PATH + restaurantForm.getStoreDto().getStoreImage();
		
		file.transferTo(new File(filePath));
		
		return false;
	}

	@Transactional
	public boolean deleteRestaurant(String id) throws Exception {
		int cnt = repository.deleteRestaurant(id);
		if(cnt != 1) {
			throw new RuntimeException("削除エラーです。");
		}
		return false;
	}
	
	public boolean editRestaurantInit(RestaurantForm form) throws Exception{
		StoreDto dto = repository.getStoreByPK(form.getId());
		form.setStoreDto(dto);
		return false;
	}
	
	@Transactional
	public boolean editRestaurant(RestaurantForm form) throws Exception{
		int cnt = repository.updateStoreByPk(form);
		if(cnt == 0) {
			throw new RuntimeException("更新に失敗しましｋた。");
		}
		return false;
	}
}
