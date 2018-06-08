package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.repository.TblPhieuDeXuatDTO;
import com.demo.service.PhieuDeXuatService;

@Controller
@RequestMapping(value="/admin")
public class PhieuDeXuatController {

	@Autowired
	PhieuDeXuatService phieuDeXuatService;
	
	@GetMapping(value="/chuyen-trang-thai")
	public String chuyenTrangThai(){
		return "admin/chuyenTrangThai";
	}
	
	@GetMapping(value="/danh-sach-phieu-de-xuat")
	public String danhSachPhieuChi(ModelMap map){
		
		List<TblPhieuDeXuatDTO> phieuDeXuatDTOs = phieuDeXuatService.getAll();
		map.addAttribute("phieuDeXuatDTOs", phieuDeXuatDTOs);
		
		return "admin/listPhieuDeXuat";
	}
	
}
