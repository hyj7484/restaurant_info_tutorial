package com.restaurant.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.constants.Constants;
import com.restaurant.dto.MenuDto;
import com.restaurant.dto.StoreDto;
import com.restaurant.form.MenuForm;
import com.restaurant.repository.MenuRepository;
import com.restaurant.service.MenuService;


@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepository repository;
	
	public void init(MenuForm form) throws Exception {
		List<MenuDto> menuDtoList = repository.getMenuByStoreId(form.getStoreId());
		StoreDto storeDto = repository.getStoreNameByStoreId(form.getStoreId());
		
		for (MenuDto dto : menuDtoList) {
			dto.setContent(dto.getContent().replace("\r\n", "<br />"));
		}
		form.setMenuDtoList(menuDtoList);
		form.setStoreDto(storeDto);
	}
	
	public void insertMenuInit(MenuForm form) throws Exception{
		StoreDto storeDto = repository.getStoreNameByStoreId(form.getStoreId());
		
		form.setStoreDto(storeDto);
	}
	
	public void insertMenu(MenuForm form) throws Exception{
		saveFile(form);
		int cnt = repository.insertMenu(form);
		if(cnt == 0) {
			throw new Exception("メニュー登録に失敗しました。");
		}
	}
	
	public void deleteMenu(MenuForm form) throws Exception{
		MenuDto dto = repository.getMenuByPK(form.getMenuId());
		String filePath = Constants.FILE_SAVE_PATH + dto.getMenuImage();
		File imgFile = new File(filePath);
		if(imgFile.exists()) {
			imgFile.delete();
		}
		
		int cnt = repository.deleteMenu(form.getMenuId());
		if (cnt != 1) {
			throw new RuntimeException("削除エラーです。");
		}
	}

	private boolean saveFile(MenuForm form) throws IllegalStateException, IOException {
		MultipartFile file = form.getMenuImgFile();
		if (!file.getOriginalFilename().isEmpty()) {

			String imgFileName = form.getMenuDto().getMenuImage();
			int lastIndex = imgFileName.lastIndexOf(".");
			imgFileName = imgFileName.substring(0, lastIndex);
			String filePath = Constants.FILE_SAVE_PATH + imgFileName;
			File imgFile = new File(filePath + ".jpg");
			int index = 0;
			do {
				if (imgFile.exists()) {
					String filePathChange = String.format("%s_%d", filePath, index);
					imgFile = new File(filePathChange + ".jpg");
					form.getMenuDto().setMenuImage(String.format("%s_%d.jpg", imgFileName, index));
					index++;
				} else {
					break;
				}
			} while (true);
			file.transferTo(imgFile);
		}

		return true;
	}
}
