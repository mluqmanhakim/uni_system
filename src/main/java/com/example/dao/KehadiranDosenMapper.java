package com.example.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.KehadiranDosenModel;
import com.example.model.StafModel;


@Mapper
public interface KehadiranDosenMapper {




	@Select("select staf.nama, staf.nik, staf.role, staf.id_prodi" + " from staf where staf.id_prodi = #{idProdi} AND staf.flag=1 ")
	@Results(value = { 
			@Result(property = "nama", column = "nama"),
			@Result(property = "nik", column = "nik"),
			@Result(property = "idProdi", column = "id_prodi")
	})
	
	List<StafModel> selectAllStaf(@Param("idProdi") int idProdi);


	@Insert("INSERT INTO kehadiran_dosen (nik, tanggal, is_hadir, id_jadwal) VALUES (#{nik}, #{tanggal}, #{isHadir}, #{jadwal.idJadwal})")
	void updateKehadiran(KehadiranDosenModel kehadiran);
	

	@Select("select is_hadir" + " from kehadiran_dosen where nik = #{nik} AND tanggal=#{tanggal} AND id_jadwal = #{jadwal}")
	@Results(value = { 
			@Result(property = "isHadir", column = "is_hadir"),
			
	})
	
	KehadiranDosenModel getKehadiran(@Param("nik")String nik, @Param("tanggal") Date tanggal, @Param("jadwal") int jadwal);

	
	
	
	@Update("UPDATE kehadiran_dosen SET is_hadir=#{isHadir} where nik = #{nik} AND tanggal=#{tanggal} AND id_jadwal = #{jadwal.idJadwal}")
	void updateSebenarnya(KehadiranDosenModel hadir);

	
		
	
}
