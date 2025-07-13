package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.restaurant.constants.ConstantsPath;
import com.restaurant.form.MenuForm;
import com.restaurant.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {
	
	@Autowired
	MenuService service;
	
	@GetMapping("/menu/{id:\\d+}")
	public String init(@ModelAttribute MenuForm menuForm, @PathVariable("id") int id, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		menuForm.setPermission((int)session.getAttribute("permission"));
		menuForm.setStoreId(id);
		service.init(menuForm);
		return ConstantsPath.MENU;
	}
	
	@GetMapping("/menu/new/{storeId:\\d+}")
	public String insertMenuInit(@ModelAttribute MenuForm menuForm, @PathVariable("storeId") int storeId, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		menuForm.setPermission((int)session.getAttribute("permission"));
		menuForm.setStoreId(storeId);
		service.insertMenuInit(menuForm);
		return ConstantsPath.ADDMENU;
	}

	@PostMapping("/menu/new/{storeId:\\d+}")
	public String insertMenu(@ModelAttribute MenuForm menuForm, @PathVariable("storeId") int storeId, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		menuForm.setPermission((int)session.getAttribute("permission"));
		menuForm.setStoreId(storeId);
		service.insertMenu(menuForm);
		return ConstantsPath.REDIRECT_MENU + storeId;
	}
	
	@GetMapping("/menu/delete/{storeId:\\d+}/{menuId:\\d+}")
	public String deleteMenu(@ModelAttribute MenuForm menuForm, @PathVariable("storeId") int storeId, @PathVariable("menuId") int menuId) throws Exception{
		menuForm.setMenuId(menuId);
		service.deleteMenu(menuForm);
		return ConstantsPath.REDIRECT_MENU+storeId;
	}
}
