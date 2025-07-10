package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.form.LoginForm;
import com.restaurant.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@GetMapping("/login")
	public String init(@ModelAttribute LoginForm loginForm) {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody @ModelAttribute LoginForm loginForm, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if(service.login(loginForm)) {
			return "login";
		}
		session.setAttribute("id", loginForm.getId());
		session.setAttribute("userName", loginForm.getUserName());
		session.setAttribute("permission", loginForm.getPermission());
		
		return "redirect:/restaurant";
	}

}
