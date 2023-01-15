package com.example.dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.model.UserModel;


@Mapper
public interface UserLoginMapper
{
    
    
    @Insert("INSERT INTO `user`(`id_prodi`, `username`, `password`, `role`, `flag`) VALUES (#{idProdi},#{username},#{password},'ROLE_ADMIN',1)")
	void addUser(UserModel user);
}
