package com.example.service;

import java.util.List;

import com.example.model.GajiModel;
import com.example.model.StafModel;

public interface GajiService {
	GajiModel selectGaji(int idGaji);
	GajiModel hitungGaji(StafModel staf);
	List<GajiModel> viewStandarGaji(int idProdi);
	void updateGaji(GajiModel gaji);
	

}
