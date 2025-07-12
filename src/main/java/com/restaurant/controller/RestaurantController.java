package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
			return "redirect:/login";
		};
		
//		model.addAttribute(restaurantForm);
		return "restaurant";
	}
}
