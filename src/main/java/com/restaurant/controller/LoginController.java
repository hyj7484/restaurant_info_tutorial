package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String init(@ModelAttribute LoginForm loginForm, Model model) {
		model.addAttribute(loginForm);
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody @ModelAttribute LoginForm loginForm, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if(service.login(loginForm)) {
			loginForm.setError(true);
			return "login";
		}
		session.setAttribute("id", loginForm.getId());
		session.setAttribute("userName", loginForm.getUserName());
		session.setAttribute("permission", loginForm.getPermission());
		
		return "redirect:/restaurant";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute LoginForm loginForm, Model model) {
		model.addAttribute(model);
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody @ModelAttribute LoginForm loginForm, HttpServletRequest request, Model model) throws Exception {
		if(service.register(loginForm)) {
			return register(loginForm, model);
		}
		
		return init(loginForm, model);
	}

}
