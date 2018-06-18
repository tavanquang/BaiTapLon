package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.repository.TblPhieuChiDTO;
import com.demo.repository.TblPhieuDeXuatDTO;
import com.demo.service.PhieuChiService;
import com.demo.service.PhieuDeXuatService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	PhieuChiService phieuChiService;
	
	@Autowired
	PhieuDeXuatService phieuDeXuatService;
	
	@GetMapping(value="/")
	public String home(){
		return "client/home";
	}
	
	@GetMapping(value="/phieu-chi")
	public String themPhieuChi(Model map) { 
		map.addAttribute("phieuChiDTO", new TblPhieuChiDTO());
		return "client/themPhieuChi";
	}
	
	@GetMapping(value="/phieu-de-xuat")
	public String themphieudeXuat(){
		return "client/themPhieuDeXuat";
	}
	@PostMapping("/them-phieu-chi")
	public String ThemPhieuChi(ModelMap map, @ModelAttribute(name= "phieuChiDTO") TblPhieuChiDTO phieuChiDTO ) {
		 phieuChiService.AddPhieuChiDTO(phieuChiDTO);
		 return "redirect:/client/them-phieu-chi";
	}
	@PostMapping("/them-phieu-de-xuat")
	public String ThemPhieuDeXuat(ModelMap map, @ModelAttribute(name= "phieuDeXuatDTO") TblPhieuDeXuatDTO phieuDeXuatDTO ) {
		 phieuDeXuatService.AddPhieuDeXuatDTO(phieuDeXuatDTO);
		 return "redirect:/client/them-phieu-de-xuat";
	}
	@GetMapping(value="/login")
	public String login(ModelMap map,
			@RequestParam(name="e", required=false) String error){
		
		map.addAttribute("e", error);
		
		return "admin/login";
	}
	
}
