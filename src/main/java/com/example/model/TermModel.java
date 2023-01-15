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
public class TermModel
{
	private Integer idTerm;
	
    @NotNull
    private String tahun;

    @NotNull
    private Integer semester;
    
    @NotNull
    private Date tanggalMulai;
    
    @NotNull
    private Date tanggalSelesai;
    
    @NotNull
    private boolean flag;
}
