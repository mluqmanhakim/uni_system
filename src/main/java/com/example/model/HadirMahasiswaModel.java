package com.example.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HadirMahasiswaModel
{
    @NotNull
    private Integer idJadwal;

    @NotNull
    private Date tanggal;
    
    @NotNull
    private String npm;
    
    @NotNull
    private boolean isHadir;
    
}
