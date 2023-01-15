package com.example.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KehadiranDosenModel {

	private Date tanggal;

	private JadwalModel jadwal;
	
	private int isHadir;
	
	private int nik;
	
}