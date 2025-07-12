package com.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.UserDto;
import com.restaurant.form.LoginForm;
import com.restaurant.repository.LoginRepository;
import com.restaurant.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository repository;
	
	public boolean login(LoginForm form) throws Exception {
		UserDto userDto = repository.getUserByIdAndPassword(form);
		if(userDto == null) {
			form.setError(true);
			return true;
		}
		
		form.setPermission(userDto.getPermission());
		form.setUserName(userDto.getUserName());
		return false;
	}
	
	public boolean register(LoginForm form) throws Exception {
		int userCnt = repository.getUserCountById(form.getId());
		if(userCnt != 0) {
			form.setError(true);
			return true;
		}
		int cnt = repository.insertUser(form);
		if(cnt == 0) {
			form.setError(true);
			return true;
		}
		return false;
	}
	

}
