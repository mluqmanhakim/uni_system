package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StafModel;
import com.example.service.StafService;

@RestController
@RequestMapping("/rest")
public class StafRestController {
	@Autowired
	StafService stafService;

	@RequestMapping("/staf/all/{idProdi}")
	public List<StafModel> viewAll(@PathVariable(value = "idProdi") int idProdi) {	
		List<StafModel> allStaf = stafService.selectAllStaf(idProdi);
		return allStaf;
	}
	@RequestMapping("/staf/getStaf/{idKelas}")
	public StafModel viewAStaf(@PathVariable(value = "idKelas") int idKelas) {	
		StafModel staf = stafService.selectStafDenganIdKelas(idKelas);
		return staf;
	}
	@RequestMapping("/staf/view/{nik}")
	public StafModel viewAStafNik(@PathVariable(value = "nik") String nik) {	
		StafModel staf = stafService.selectStaf(nik);
		return staf;
	}
	

	
	@RequestMapping("/dosen/all/{idProdi}")
	public List<StafModel> viewAllDosen(@PathVariable(value = "idProdi") int idProdi) {	
		List<StafModel> allDosen = stafService.selectHanyaDosen(idProdi);
		return allDosen;
	}

}
