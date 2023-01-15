package com.example.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JadwalModel {

	@NotNull
    private Integer idJadwal;

    @NotNull
    private KelasModel kelas;
    
    @NotNull
    private String hari;
    
    @NotNull
    private String ruang;
    
    @NotNull
    private String jam;
    
    @NotNull
    private Integer sks;
    
    private List<HadirMahasiswaModel> listKehadiranMahasiswa;
	
	
}