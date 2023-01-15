package com.example.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.UserModel;


@Mapper
public interface UserMapper
{
    @Select("select username, id_prodi from user where username = #{username}")
    @Results(value = {
        @Result(property="username", column="username"),
        @Result(property="idProdi", column="id_prodi")
    })
    UserModel selectUser (@Param("username") String username);
}
