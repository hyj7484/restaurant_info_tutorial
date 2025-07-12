package com.restaurant.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.restaurant.dto.UserDto;
import com.restaurant.form.LoginForm;

@Mapper
public interface LoginRepository {
	public UserDto getUserByIdAndPassword(LoginForm loginForm);
	
	public int getUserCountById(@Param("id")String id);
	
	public int insertUser(LoginForm loginForm);
	

}
