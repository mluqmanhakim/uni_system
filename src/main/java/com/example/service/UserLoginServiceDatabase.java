package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.UserLoginMapper;
import com.example.dao.UserMapper;
import com.example.model.UserModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserLoginServiceDatabase implements UserLoginService
{
	@Autowired
    private UserMapper userMapper;
	
	@Autowired
    private UserLoginMapper userLoginMapper;


	@Override
	public UserModel selectUserLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
    	String username = auth.getName();
    
    	return userMapper.selectUser (username);
	}


	@Override
	public UserModel cekUser(String username) {
		//System.out.println(username +" rohmat");
		return userMapper.selectUser(username);
	}


	@Override
	public void addUser(UserModel user) {
		user.setPassword(Encrypt(user.getPassword()));
		userLoginMapper.addUser(user);
	}
    
	public String Encrypt(String password){
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
    	return hashedPassword;	
    }

}
