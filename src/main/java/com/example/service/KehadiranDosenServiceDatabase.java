
package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.dao.KehadiranDosenMapper;
import com.example.model.KehadiranDosenModel;
import com.example.model.StafModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class KehadiranDosenServiceDatabase implements KehadiranDosenService
{
    @Autowired
    private KehadiranDosenMapper kehadiranDosen;

	@Override
	public List<KehadiranDosenModel> selectAllKehadiran(int nik, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateKehadiran(KehadiranDosenModel kehadiran) {
		// TODO Auto-generated method stub
		System.out.println(kehadiran.getNik());
		System.out.println(kehadiran.getTanggal());
		System.out.println(kehadiran.getJadwal().getIdJadwal());
		System.out.println(kehadiran.getIsHadir());
		kehadiranDosen.updateKehadiran(kehadiran );
	}

	@Override
	public KehadiranDosenModel getKehadiran(String nik, Date tanggal, int jadwal) {
		// TODO Auto-generated method stub
		return kehadiranDosen.getKehadiran(nik, tanggal, jadwal);
	}

	@Override
	public void updateSebenarnya(KehadiranDosenModel hadir) {
		// TODO Auto-generated method stub
		kehadiranDosen.updateSebenarnya(hadir);
	}

	

}
