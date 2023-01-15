package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.GajiModel;
import com.example.model.StafModel;
import com.example.service.GajiService;
import com.example.service.UserLoginService;

@Controller
public class GajiController {
	@Autowired
	GajiService gajiService;

	@Autowired
	UserLoginService userService;

	
	@RequestMapping("/gaji/view")
	public String viewStandarGaji(Model model) {
		int idProdi = userService.selectUserLogin().getIdProdi();
		
		List<GajiModel> gaji = gajiService.viewStandarGaji(idProdi);

		model.addAttribute("gaji", gaji);

		return "gajistandar";
	}
	
	@RequestMapping("/gaji/update/{idGaji}")
	public String editGaji(Model model, @PathVariable(value = "idGaji") int idGaji) {
		GajiModel gaji = gajiService.selectGaji(idGaji);
		model.addAttribute("gaji", gaji);
		return "editgaji";
		
	}
	
	@RequestMapping("/gaji/update")
	public String updateGaji(Model model, @RequestParam(value = "idGaji", required = false) int idGaji,
			@RequestParam(value = "nominal", required = false) int nominal){
		GajiModel gaji = gajiService.selectGaji(idGaji);
		gaji.setNominal(nominal);
		gajiService.updateGaji(gaji);
		return "redirect:/gaji/view";
		
	}
	
	
}