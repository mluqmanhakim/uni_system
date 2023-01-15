package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GajiPerBulanModel {
		
	
	private int tahun;
	private String bulan;

	private int nominal;

}