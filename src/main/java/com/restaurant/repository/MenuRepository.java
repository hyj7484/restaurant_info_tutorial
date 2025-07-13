package com.restaurant.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.restaurant.dto.MenuDto;
import com.restaurant.dto.StoreDto;
import com.restaurant.form.MenuForm;

@Mapper
public interface MenuRepository {
	
	public List<MenuDto> getMenuByStoreId(int storeId);
	
	public StoreDto getStoreNameByStoreId(int storeId);
	
	public MenuDto getMenuByPK(int menuId);
	
	public int insertMenu(MenuForm menuForm);
	
	public int deleteMenu(int id);


}
