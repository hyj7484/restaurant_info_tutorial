package com.restaurant.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.restaurant.dto.StoreDto;

import lombok.Data;

@Data
public class RestaurantForm {
	
	
	private List<StoreDto> restaurantDtoList;
	
	private StoreDto storeDto;
	
	private int permission;
	
	private String adminId;
	
	private boolean empty;
	
	private MultipartFile storeImgFile;
	
	private int id;
	
	public void setStoreImgFile(MultipartFile storeImgFile){
		this.storeImgFile = storeImgFile;
		this.storeDto.setStoreImage(storeImgFile.getOriginalFilename());
	}
}
