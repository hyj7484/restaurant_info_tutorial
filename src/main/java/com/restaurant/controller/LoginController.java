package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.constants.ConstantsPath;
import com.restaurant.form.LoginForm;
import com.restaurant.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@GetMapping("/login")
	public String init(@ModelAttribute LoginForm loginForm, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null) {
			return ConstantsPath.REDIRECT_RESTAURANT;
		}
		model.addAttribute(loginForm);
		return ConstantsPath.LOGIN;
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody @ModelAttribute LoginForm loginForm, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if(service.login(loginForm)) {
			loginForm.setError(true);
			return ConstantsPath.LOGIN;
		}
		session.setAttribute("id", loginForm.getId());
		session.setAttribute("userName", loginForm.getUserName());
		session.setAttribute("permission", loginForm.getPermission());
		
		return ConstantsPath.REDIRECT_RESTAURANT;
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute LoginForm loginForm, Model model) {
		model.addAttribute(model);
		return ConstantsPath.REGISTER;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody @ModelAttribute LoginForm loginForm, HttpServletRequest request, Model model) throws Exception {
		if(service.register(loginForm)) {
			return register(loginForm, model);
		}
		
		return init(loginForm, request, model);
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return ConstantsPath.REDIRECT_LOGIN;
	}

}
