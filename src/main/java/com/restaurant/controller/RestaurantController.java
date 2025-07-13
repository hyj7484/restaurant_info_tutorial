package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.restaurant.constants.ConstantsPath;
import com.restaurant.form.RestaurantForm;
import com.restaurant.service.RestaurantService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantService service;
	
	@GetMapping("/restaurant")
	public String init(@ModelAttribute RestaurantForm restaurantForm, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		restaurantForm.setPermission((int)session.getAttribute("permission"));
		restaurantForm.setAdminId((String)session.getAttribute("id"));
		if(service.init(restaurantForm)) {
			return ConstantsPath.REDIRECT_LOGIN;
		};
		
		return ConstantsPath.RESTAURANT;
	}
	
	@GetMapping("/restaurant/new")
	public String newRestaurant(@ModelAttribute RestaurantForm restaurantForm, Model model) {
		return ConstantsPath.ADDRESTAURANT;
		
	}
	
	@PostMapping("/restaurant/new")
	public String newRestaurantInsert(@ModelAttribute RestaurantForm restaurantForm, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		restaurantForm.setAdminId((String)session.getAttribute("id"));
		
		if(service.insertRestaurant(restaurantForm)) {
			return newRestaurant(restaurantForm, model);
		}
		
		return ConstantsPath.REDIRECT_RESTAURANT;
	}
	
	@GetMapping("/restaurant/delete/{id}")
	public String deleteReastaurant(@PathVariable("id") String id) throws Exception {
		service.deleteRestaurant(id);
		return ConstantsPath.REDIRECT_RESTAURANT;
	}
	
	@GetMapping("/restaurant/edit/{id:\\d+}")
	public String editRestaurantInit(@ModelAttribute RestaurantForm restaurantForm, @PathVariable("id")int id, Model model) throws Exception {
		restaurantForm.setId(id);
		service.editRestaurantInit(restaurantForm);
		return ConstantsPath.EDITRESTAURANT;
	}
	
	
	@PostMapping("/restaurant/edit/{id:\\d+}")
	public String editRestaurant(@ModelAttribute RestaurantForm restaurantForm, @PathVariable("id")int id, Model model) throws Exception {
		restaurantForm.setId(id);
		service.editRestaurant(restaurantForm);
		return ConstantsPath.REDIRECT_RESTAURANT;
	}
}
