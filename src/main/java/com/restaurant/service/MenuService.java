package com.restaurant.service;

import com.restaurant.form.MenuForm;

public interface MenuService {
	public void init(MenuForm form) throws Exception;
	
	public void insertMenuInit(MenuForm form) throws Exception;

	public void insertMenu(MenuForm form) throws Exception;
	
	public void deleteMenu(MenuForm form) throws Exception;
}
