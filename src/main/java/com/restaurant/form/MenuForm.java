package com.restaurant.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.restaurant.dto.MenuDto;
import com.restaurant.dto.StoreDto;

import lombok.Data;

@Data
public class MenuForm {
	private List<MenuDto> menuDtoList;
	
	private MenuDto menuDto;
	
	private StoreDto storeDto;
	
	private int StoreId;
	
	private int menuId;
	
	private int permission;
	
	private MultipartFile menuImgFile;
	
	public void setMenuImgFile(MultipartFile menuImgFile){
		this.menuImgFile = menuImgFile;
		this.menuDto.setMenuImage(menuImgFile.getOriginalFilename());
	}

}
