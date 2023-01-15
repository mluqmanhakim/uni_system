package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.GajiModel;
import com.example.model.StafModel;
import com.example.model.StudentModel;

@Mapper
public interface GajiMapper {	
	@Select("select * from gaji where id_prodi = #{idProdi}")
	@Results(value = {
			@Result(property="idGaji", column="id_gaji"),
			@Result(property="role", column="role"),
			@Result(property="nominal", column="nominal"),
			@Result(property="idProdi", column="id_prodi")
	})
		List<GajiModel> viewStandarGaji (@Param("idProdi") int idProdi);

	@Update("UPDATE gaji SET nominal=#{nominal} WHERE id_gaji=#{idGaji}")

	void updateGaji(GajiModel gaji);

	@Select("select * from gaji where id_gaji = #{idGaji}")
	@Results(value = {
			@Result(property="idGaji", column="id_gaji"),
			@Result(property="role", column="role"),
			@Result(property="nominal", column="nominal"),
			@Result(property="idProdi", column="id_prodi")
	})
	GajiModel selectGaji (@Param("idGaji") int idGaji);
}
