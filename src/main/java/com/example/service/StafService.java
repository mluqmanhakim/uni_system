package com.example.service;

import java.util.List;

import com.example.model.StafModel;

public interface StafService
{
	StafModel selectStaf( String nik);
	StafModel selectStafDenganIdKelas(int idKelas);
	void addStaf(StafModel staf);
	void updateStaf(StafModel staf);
	List<StafModel> selectAllStaf(int idProdi);
	List<StafModel> selectAllStafWithGaji(int idProdi, int bulan, int tahun);
	List<StafModel> selectHanyaDosen(int idProdi);
	void deleteStaf(String nik);
	
	List<Integer> selectAllProdi (int idProdi);

	List<Integer> selectAllProdiDiFakultas (int idProdi);
	
	
	String selectNamaUniv(int idProdi);
	String selectFakultas(int idProdi);

	String selectNamaProdi(int idProdi);
}
