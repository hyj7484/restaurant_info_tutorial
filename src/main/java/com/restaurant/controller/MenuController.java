package com.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.restaurant.form.MenuForm;

@Controller
public class MenuController {
	
	@GetMapping("/menu/{id}")
	public String init(@ModelAttribute MenuForm menuForm, @PathVariable("id") String id, Model model) {
		
		return "";
	}

}
