package com.restaurant.form;

import lombok.Data;

@Data
public class LoginForm {
	// ユーザーID
	private String id;
	// パスワード
	private String password;
	// ユーザー名
	private String userName;
	// ユーザー権限
	private int permission;
	//　エラー内容 
	private String[] loginErrors;
	// エラーチェック
	private boolean error;
}
