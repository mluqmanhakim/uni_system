package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.StafModel;
import com.example.model.UserModel;
import com.example.service.StafService;
import com.example.service.UserLoginService;

@Controller
public class StafController {
	@Autowired
	StafService stafService;
	
	@Autowired
	UserLoginService userService;

	@RequestMapping("/")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
    	String username = auth.getName();
		model.addAttribute("username", username);
		return "home";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
    	String username = auth.getName();
		model.addAttribute("username", username);
		return "home";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/user/add/submit", method = RequestMethod.POST)
	public String updateSubmit(Model model, @RequestParam(value = "username") String username,
			@RequestParam(value = "idProdi") int idProdi, @RequestParam(value = "password") String password) {
		UserModel thisUser = new UserModel(username, idProdi, password);
		System.out.println(thisUser.getUsername()+" LOL");
		if (userService.cekUser(username) == null) {
			userService.addUser(thisUser);
			return "login";
		} else {
			return "register";
		}
	}

	@RequestMapping("/about")
	public String about(Model model) {
		
		return "about";
	}

	@RequestMapping("/staf/viewall")
	public String listStaf(Model model) {
		//contoh ngambil yang login sekarang
		int idProdi = userService.selectUserLogin().getIdProdi();
		
		
		List<StafModel> staf = stafService.selectAllStaf(idProdi);
		String namaProdi = stafService.selectNamaProdi(idProdi);
		model.addAttribute("staf", staf);
		model.addAttribute("namaProdi", namaProdi);
		
		return "liststaf";
	}
	
	@RequestMapping("/staf/viewallluniv")
	public String listStafUniv(Model model) {
		//contoh ngambil yang login sekarang
		int idProdi = userService.selectUserLogin().getIdProdi();
		
		List<StafModel>staf = new ArrayList<StafModel>();
		List<Integer> prodi= stafService.selectAllProdi(idProdi);
		String namaUniv = stafService.selectNamaUniv(idProdi);
		//System.out.println(namaUniv);
		List<StafModel>stafTemp;
		for(int i = 0 ; i < prodi.size() ; i ++){
			
			stafTemp = stafService.selectAllStaf(prodi.get(i));
			
			staf.addAll(stafTemp);
			
		}
	

		model.addAttribute("staf", staf);
		model.addAttribute("namaUniv", namaUniv);

		return "liststafuniv";
	}
	
	@RequestMapping("/staf/viewalllfakultas")
	public String listStafFakultas(Model model) {
		//contoh ngambil yang login sekarang
		int idProdi = userService.selectUserLogin().getIdProdi();
		
		List<StafModel>staf = new ArrayList<StafModel>();
		List<Integer> prodi= stafService.selectAllProdiDiFakultas(idProdi);
		List<StafModel>stafTemp;
		String namaFakultas= stafService.selectFakultas(idProdi);
		for(int i = 0 ; i < prodi.size() ; i ++){
			
			stafTemp = stafService.selectAllStaf(prodi.get(i));
			
			staf.addAll(stafTemp);
			
		}
	

		model.addAttribute("staf", staf);
		model.addAttribute("namaFakultas", namaFakultas);


		return "liststaffakultas";
	}
	
	

	@RequestMapping("/staf/view/{nik}")
	public String viewStaf(Model model, @PathVariable(value = "nik") String nik) {
		StafModel staf = stafService.selectStaf(nik);
	
		if (staf != null) {
			model.addAttribute("staf", staf);
			return "viewstaf";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}

		
	}

	@RequestMapping("/staf/add")
	public String add() {
		return "addstaf";
	}

	@RequestMapping(value = "/staf/add/submit", method = RequestMethod.POST)
	public String addSubmit(Model model, @RequestParam(value = "nik", required = false) String nik,
			@RequestParam(value = "idProdi", required = false) String idProdi,
			@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "role", required = false) String role) {
		int flag = 1;
		int id = Integer.parseInt(idProdi);
		StafModel staf = new StafModel(nama, nik, id, role, flag, null, null, null);
		stafService.addStaf(staf);

		staf = stafService.selectStaf(nik);
		model.addAttribute("staf", staf);
	
		return "viewstaf";
	}

	@RequestMapping("staf/update/{nik}")
	public String update(Model model, @PathVariable(value = "nik") String nik) {
		
		//contoh ngambil yang login sekarang
			//	int idProdi = userService.selectUserLogin().getIdProdi();
				
		StafModel staf = stafService.selectStaf(nik);
		

		if (staf != null) {
			model.addAttribute("staf", staf);
			return "updatestaf";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}

	}

	@RequestMapping(value = "staf/update/submit/{nik}", method = RequestMethod.POST)
	public String updateSubmit(Model model, @RequestParam(value = "nik", required = false) String nik,
			@RequestParam(value = "idProdi", required = false) String idProdi,
			@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "role", required = false) String role) {
		
		int flag = 1;
		int id = Integer.parseInt(idProdi);
		StafModel staf = new StafModel(nama, nik, id, role, flag, null, null, null);
		stafService.updateStaf(staf);
		StafModel stafBaru = stafService.selectStaf(nik);
		model.addAttribute("staf", stafBaru);
		return "viewstaf";
	}

	@RequestMapping("/staf/viewGaji")
	public String viewGajiAllStaf(Model model) {

		//contoh ngambil yang login sekarang
				int idProdi = userService.selectUserLogin().getIdProdi();
				
		Date date = new Date();

		List<StafModel> staf = stafService.selectAllStafWithGaji(idProdi, date.getMonth(), date.getYear());

		model.addAttribute("staf", staf);
		
		return "listStafWithGaji";
	}

	
	

	@RequestMapping("/staf/viewGajiParameter")
	public String viewGaji(Model model, @RequestParam(value = "bulan", required = false) int bulan,
			@RequestParam(value = "tahun", required = false) int tahun) {
		int idProdi = userService.selectUserLogin().getIdProdi();
		List<StafModel> staf = stafService.selectAllStafWithGaji(idProdi, bulan, tahun);

		model.addAttribute("staf", staf);
		model.addAttribute("idProdi", idProdi);
		return "listStafWithGaji";
	}
	@RequestMapping("staf/delete/{nik}")
	public String delete(Model model, @PathVariable(value = "nik") String nik) {
		
		//contoh ngambil yang login sekarang
				//int idProdiLogin = userService.selectUserLogin().getIdProdi();
		int idProdi = userService.selectUserLogin().getIdProdi();
		StafModel staf = stafService.selectStaf(nik);
		
		 stafService.deleteStaf(nik);
		
		 model.addAttribute("staf", staf);
		 model.addAttribute("idProdi", idProdi);	
			
		 return "deleteStaf";
	}
	
	
}


