package com.restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.form.LoginForm;
import com.restaurant.repository.LoginRepository;
import com.restaurant.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository repository;
	
	@Override
	public boolean login(LoginForm form) throws Exception {
		
		return true;
	}
	

}
