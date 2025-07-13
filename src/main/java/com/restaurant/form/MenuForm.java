package com.restaurant.form;

import java.util.List;

import com.restaurant.dto.MenuDto;

import lombok.Data;

@Data
public class MenuForm {
	private List<MenuDto> menuDtoList;
	
	private MenuDto menuDto;
}
