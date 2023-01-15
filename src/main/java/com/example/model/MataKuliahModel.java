package com.example.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahModel
{
    private int idMataKuliah;
	private int idProdi;
	private String nama;
	private int sks;
	private String deskripsi;
	private int isWajib;
	private int prasyaratMinSks;
	private int prasyaratMinSemester;
	private List<MataKuliahModel> prasyarat;
}
