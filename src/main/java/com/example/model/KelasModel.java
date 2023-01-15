package com.example.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KelasModel
{
    @NotNull
    private Integer idKelas;

    @NotNull
    private Integer idTerm;
    
    @NotNull
    private Integer idMatkul;
    
    @NotNull
    private String namaKelas;
    
    private TermModel term;
    private MataKuliahModel mataKuliah;
    private List<JadwalModel> listJadwal;
    private StafModel dosen;
}
