package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.repository.TblPhieuChiDTO;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public String home(){
		return "client/home";
	}
	

	
	@GetMapping(value="/admin/them-phieu-de-xuat")
	public String themphieudeXuat(){
		return "client/themPhieuDeXuat";
	}
	
	@GetMapping(value="/login")
	public String login(ModelMap map,
			@RequestParam(name="e", required=false) String error){
		
		map.addAttribute("e", error);
		
		return "admin/login";
	}
	
}
