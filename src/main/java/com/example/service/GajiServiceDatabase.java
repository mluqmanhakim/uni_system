package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.GajiMapper;
import com.example.model.GajiModel;
import com.example.model.StafModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GajiServiceDatabase implements GajiService {

@Autowired
private GajiMapper gajiMapper;

	@Override
	public GajiModel selectGaji(int idGaji) {
		return gajiMapper.selectGaji(idGaji);
	}

	@Override
	public GajiModel hitungGaji(StafModel staf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GajiModel> viewStandarGaji(int idProdi) {
		return gajiMapper.viewStandarGaji(idProdi);
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGaji(GajiModel gaji) {
		log.info("gaji " + gaji.getNominal() + " updated");
		gajiMapper.updateGaji(gaji);
	}
}
