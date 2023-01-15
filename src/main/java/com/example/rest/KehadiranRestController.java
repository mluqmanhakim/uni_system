package com.example.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.KehadiranDosenModel;
import com.example.model.StafModel;
import com.example.service.KehadiranDosenService;

@RestController
@RequestMapping("/rest")
public class KehadiranRestController {
	@Autowired
	KehadiranDosenService kehadiranService;

	// update tapi sebenarnya add
	@RequestMapping(value = "/updateStaf/", method = RequestMethod.PUT)
	public void updateStaf(@RequestBody List<KehadiranDosenModel> kumpulanKehadiran) {

		for (int i = 0; i < kumpulanKehadiran.size(); i++) {

			kehadiranService.updateKehadiran(kumpulanKehadiran.get(i));
		}
	}

	@RequestMapping("/getKehadiranModel/{nik}/{tanggalString}/{jadwal}")
	public KehadiranDosenModel getKehadiranModel(@PathVariable(value = "nik") String nik,
			@PathVariable(value = "tanggalString") String tanggalString, @PathVariable(value = "jadwal") int jadwal) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date tanggal = formatter.parse(tanggalString);
		
		KehadiranDosenModel hadir = kehadiranService.getKehadiran(nik, tanggal, jadwal);
		System.out.println(hadir);
		if (hadir == null) {

			return null;
		} else {
			return hadir;

		}
	}

	@RequestMapping(value = "/updateSebenarnya/", method = RequestMethod.PUT)
	public void update(KehadiranDosenModel hadir )  {
		
		
		
		kehadiranService.updateSebenarnya(hadir);

		
	}

}
