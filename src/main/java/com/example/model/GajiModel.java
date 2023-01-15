package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GajiModel {
	private int nominal;
	private String role;
	private int idGaji;
	private int idProdi;

}