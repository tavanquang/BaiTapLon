package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public String home(){
		return "client/home";
	}
	
	@GetMapping(value="/them-phieu-chi")
	public String themPhieuChi(){
		return "client/themPhieuChi";
	}
	
	@GetMapping(value="/them-phieu-de-xuat")
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
