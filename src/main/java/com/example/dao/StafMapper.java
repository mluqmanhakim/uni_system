package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.JadwalModel;
import com.example.model.KehadiranDosenModel;
import com.example.model.StafModel;

@Mapper
public interface StafMapper {
	@Select("select staf.nama, staf.nik, staf.role, staf.id_prodi from staf where staf.id_prodi = #{idProdi} AND staf.flag=1")
	@Results(value = { @Result(property = "nama", column = "nama"), @Result(property = "nik", column = "nik"),
			@Result(property = "role", column = "role"), @Result(property = "idProdi", column = "id_prodi") })
	List<StafModel> selectAllStaf(@Param("idProdi") int idProdi);

	@Select("select gaji.nominal ,staf.nama, staf.nik, staf.role, staf.id_prodi from staf, gaji where staf.id_prodi = #{idProdi} AND staf.flag=1 AND staf.role = gaji.role AND staf.id_prodi = gaji.id_prodi")
	@Results(value = { @Result(property = "nama", column = "nama"), @Result(property = "nik", column = "nik"),
			@Result(property = "role", column = "role"), @Result(property = "gajiStandar.nominal", column = "nominal"),

			@Result(property = "idProdi", column = "id_prodi") })
	List<StafModel> selectAllStafWithGaji(@Param("idProdi") int idProdi);

	@Select("select staf.nama, staf.nik, staf.role, staf.id_prodi from staf where staf.id_prodi = #{idProdi} AND staf.flag=1 AND staf.role = 'Dosen'")
	@Results(value = { @Result(property = "nama", column = "nama"), @Result(property = "nik", column = "nik"),
			@Result(property = "role", column = "role"),

			@Result(property = "idProdi", column = "id_prodi") })
	List<StafModel> selectHanyaDosen(@Param("idProdi") int idProdi);

	@Select("select gaji.nominal ,staf.nama, staf.nik, staf.role, staf.id_prodi from staf, gaji where staf.nik = #{nik} AND staf.flag=1 AND staf.role = gaji.role AND staf.id_prodi = gaji.id_prodi")
	@Results(value = { @Result(property = "nama", column = "nama"), @Result(property = "nik", column = "nik"),
			@Result(property = "idProdi", column = "id_prodi"),
			@Result(property = "gajiStandar.nominal", column = "nominal"),
			@Result(property = "role", column = "role") })

	StafModel selectStaf(@Param("nik") String nik);

	@Select("select id_jadwal, kehadiran_dosen.tanggal from  kehadiran_dosen  where nik = #{nik} AND is_hadir =1")
	@Results(value = { @Result(property = "tanggal", column = "tanggal"),
			@Result(property = "jadwal", column = "id_jadwal", javaType = JadwalModel.class, many = @Many(select = "selectJadwal")) })

	List<KehadiranDosenModel> selectKehadiran(@Param("nik") String nik);

	@Select("select banyak_sks from  jadwal_kuliah where id_jadwal = #{idJadwal}")
	@Results(value = { @Result(property = "sks", column = "banyak_sks") })

	JadwalModel selectJadwal(@Param("idJadwal") int id_jadwal);

	@Select("select * from staf LEFT join kelas on staf.nik = kelas.nik where kelas.id_kelas= #{idKelas} AND staf.flag=1")
	@Results(value = { @Result(property = "nama", column = "nama"), @Result(property = "nik", column = "nik"),
			@Result(property = "idProdi", column = "id_prodi") })
	StafModel selectStafDenganIdKelas(@Param("idKelas") int idKelas);

	@Update("UPDATE staf SET nama=#{nama}, id_prodi=#{idProdi}, role=#{role} WHERE nik=#{nik}")
	void updateStaf(StafModel staf);

	@Insert("INSERT INTO staf (nik, id_prodi, nama, role, flag) VALUES (#{nik}, #{idProdi}, #{nama}, #{role}, #{flag})")
	void addStaf(StafModel staf);

	@Select("select id_jadwal, kehadiran_dosen.tanggal from  kehadiran_dosen  where nik = #{nik} AND is_hadir =1 AND MONTH(tanggal) = #{bulan} AND YEAR(tanggal) =#{tahun}")
	@Results(value = { @Result(property = "tanggal", column = "tanggal"),
			@Result(property = "jadwal", column = "id_jadwal", javaType = JadwalModel.class, many = @Many(select = "selectJadwal")) })

	List<KehadiranDosenModel> selectKehadiranDenganBatasWaktu(@Param("nik") String nik, @Param("bulan") int bulan,
			@Param("tahun") int tahun);

	@Update("UPDATE staf SET flag=0 WHERE nik=#{nik}")
	void deleteStaf(String nik);

	@Select("select prodi.id_prodi from  prodi  LEFT JOIN fakultas on prodi.id_fakultas = fakultas.id_fakultas LEFT JOIN univ ON fakultas.id_univ=univ.id_univ where univ.id_univ = #{idUniv}")

	List<Integer> selectAllProdi(@Param("idUniv") int idUniv); 
	
	
	@Select("select prodi.id_prodi from  prodi  LEFT JOIN fakultas on prodi.id_fakultas = fakultas.id_fakultas  where fakultas.id_fakultas  = #{idFakultas}")

	List<Integer> selectAllProdiDiFakultas(@Param("idFakultas") int idFakultas); 

	
	@Select("select univ.id_univ from  prodi  LEFT JOIN fakultas on prodi.id_fakultas = fakultas.id_fakultas LEFT JOIN univ ON fakultas.id_univ=univ.id_univ where prodi.id_prodi = #{idProdi}")

	int selectUniv(@Param("idProdi") int idProdi); 
		
	
	@Select("select prodi.id_fakultas from  prodi  where prodi.id_prodi = #{idProdi}")

	int selectFakultas(@Param("idProdi") int idProdi);
	
	
	@Select("select nama_fakultas from  fakultas  where fakultas.id_fakultas = #{idFakultas}")

	String selectNamaFakultas(@Param("idFakultas") int idFakultas);
	

	@Select("select nama_univ from  univ  where univ.id_univ = #{idUniv}")

	String selectNamaUniv(@Param("idUniv") int idUniv);
	

	@Select("select nama_prodi from  prodi  where prodi.id_prodi = #{idProdi}")

	String selectNamaProdi(@Param("idProdi") int idProdi);
	
	
	
}
