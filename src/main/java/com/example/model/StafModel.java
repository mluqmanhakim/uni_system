package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StafModel {
	private String nama;
	private String nik;
	private int idProdi;
	private String role;
	private int flag;
	private List<KehadiranDosenModel>kehadiran ;
	private GajiModel gajiStandar;
	private List<GajiPerBulanModel> gaji;


}