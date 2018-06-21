package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.repository.TblNoiDungDeXuatDTO;
import com.demo.repository.TblPhieuChiDTO;
import com.demo.repository.TblPhieuDeXuatDTO;
import com.demo.service.NoiDungDeXuatService;
import com.demo.service.PhieuChiService;
import com.demo.service.PhieuDeXuatService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
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
	
	@GetMapping(value="/phieu-chi")
	public String themPhieuChi(Model map) { 
		
		ArrayList<TblNoiDungDeXuatDTO> deXuatDTOs = new ArrayList<>();
		
		map.addAttribute("phieuChiDTO", new TblPhieuChiDTO());
		return "client/themPhieuChi";
	}
	
	@GetMapping(value="/phieu-de-xuat")
	public String themphieudeXuat(Model map){
		List<TblNoiDungDeXuatDTO> deXuatDTOs = new ArrayList<>();
		TblPhieuDeXuatDTO deXuatDTO = new TblPhieuDeXuatDTO();
		deXuatDTO.setTblNoiDungDeXuat(deXuatDTOs);
		map.addAttribute("phieuDeXuat", deXuatDTO);
		return "client/themPhieuDeXuat";
	}
	@PostMapping("/them-phieu-chi")
	public String ThemPhieuChi(ModelMap map, @ModelAttribute(name= "phieuChiDTO") TblPhieuChiDTO phieuChiDTO ) {
		 phieuChiService.AddPhieuChiDTO(phieuChiDTO);
		 return "redirect:/phieu-chi";
	}
	
	
	@PostMapping("/them-phieu-de-xuat")
	public String ThemPhieuDeXuat(ModelMap map, @ModelAttribute(name="phieuDeXuat")TblPhieuDeXuatDTO phieuDeXuatDTO, BindingResult bindingResult ){
			
		if(bindingResult.hasErrors()){
			
			LOGGER.info(bindingResult.getFieldError().getField());
			LOGGER.info(bindingResult.getFieldValue(bindingResult.getFieldError().getField()).toString());
			
			map.addAttribute("e","error");

			 return "client/themPhieuDeXuat";
		}
		
		LOGGER.info(phieuDeXuatDTO.toString());
		
		for(int i =0;i<phieuDeXuatDTO.getTblNoiDungDeXuat().size();i++){
			
			LOGGER.info(phieuDeXuatDTO.getTblNoiDungDeXuat().get(i).toString());
			
		}
		
		
		phieuDeXuatService.AddPhieuDeXuatDTO(phieuDeXuatDTO);
	
		
		map.addAttribute("e","thanhcong");
		 
		 
		return "client/themPhieuDeXuat";
	}
	
	
	
	@GetMapping(value="/login")
	public String login(ModelMap map,
			@RequestParam(name="e", required=false) String error){
		
		map.addAttribute("e", error);
		
		return "admin/login";
	}
	
}
