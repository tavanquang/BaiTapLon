package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.TblNoiDungDeXuatDTO;
import com.demo.model.TblPhieuChiDTO;
import com.demo.model.TblPhieuDeXuatDTO;
import com.demo.service.NoiDungDeXuatService;
import com.demo.service.PhieuChiService;
import com.demo.service.PhieuDeXuatService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	PhieuChiService phieuChiService;
	
	@Autowired
	PhieuDeXuatService phieuDeXuatService;
	
	@Autowired
	NoiDungDeXuatService noiDungDeXuatService;
	
	@GetMapping(value="/")
	public String home(){
		return "client/home";
	}
	@GetMapping(value="/home")
	public String home2(){
		return "client/home2";
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
		 return "redirect:/phieu-chi";
	}
	@PostMapping("/them-phieu-de-xuat")
	public String ThemPhieuDeXuat(ModelMap map,
			@ModelAttribute(name= "phieuDeXuatDTO") TblPhieuDeXuatDTO phieuDeXuatDTO,
			@ModelAttribute(name= "noiDungDeXuatDTO") List<TblNoiDungDeXuatDTO> noiDungDeXuatDTO) {
		 phieuDeXuatService.AddPhieuDeXuatDTO(phieuDeXuatDTO);
		 ((TblNoiDungDeXuatDTO) noiDungDeXuatDTO).setIdPhieuDeXuat(phieuDeXuatDTO.getId());
		 noiDungDeXuatService.AddNoiDungDeXuatDTO((TblNoiDungDeXuatDTO) noiDungDeXuatDTO);
		 return "redirect:/phieu-de-xuat";
	}
	@GetMapping(value="/login")
	public String login(ModelMap map,
			@RequestParam(name="e", required=false) String error){
		
		map.addAttribute("e", error);
		
		return "admin/login";
	}
	
}
