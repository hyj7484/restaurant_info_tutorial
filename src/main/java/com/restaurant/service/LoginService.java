package com.restaurant.service;

import com.restaurant.form.LoginForm;

public interface LoginService {
	public boolean login(LoginForm loginForm) throws Exception;
	
	public boolean register(LoginForm form) throws Exception;
}
