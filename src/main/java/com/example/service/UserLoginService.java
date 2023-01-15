package com.example.service;
import java.util.List;

import com.example.model.UserModel;

public interface UserLoginService
{
	UserModel selectUserLogin();
	
	UserModel cekUser(String username);
	
	void addUser(UserModel user);
}