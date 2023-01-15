package com.example.service;


import java.util.Date;
import java.util.List;

import com.example.model.KehadiranDosenModel;

public interface KehadiranDosenService {

	List<KehadiranDosenModel> selectAllKehadiran(int nik, String role);
	
	void updateKehadiran (KehadiranDosenModel kehadiran );
	KehadiranDosenModel getKehadiran(String nik, Date tanggal, int jadwal );
	void updateSebenarnya(KehadiranDosenModel hadir);
}
