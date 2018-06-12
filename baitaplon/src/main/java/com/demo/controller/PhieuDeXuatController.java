package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.repository.TblPhieuChiDTO;
import com.demo.repository.TblPhieuDeXuatDTO;
import com.demo.service.PhieuDeXuatService;

@Controller
@RequestMapping(value="/admin")
public class PhieuDeXuatController {

	@Autowired
	PhieuDeXuatService phieuDeXuatService;
	
	
	@GetMapping(value="/danh-sach-phieu-de-xuat")
	public String danhSachPhieuChi(ModelMap map){
		
		List<TblPhieuDeXuatDTO> phieuDeXuatDTOs = phieuDeXuatService.getAll();
		map.addAttribute("phieuDeXuatDTOs", phieuDeXuatDTOs);
		map.addAttribute("status", "4");
		return "admin/listPhieuDeXuat";
	}
	
	@GetMapping(value="/chuyen-trang-thai-phieu-de-xuat")
	public String chuyenTrangThaiPhieuChi(ModelMap map,
			@RequestParam(name="trangThai", required=true) int trangThai,
			@RequestParam(name="id", required=true) int id){
		
		TblPhieuDeXuatDTO phieuDeXuatDTO = phieuDeXuatService.getPhieuDeXuatDTO(id);
		phieuDeXuatDTO.setTrangThai(trangThai);
		phieuDeXuatService.ChuyenTrangThai(phieuDeXuatDTO);
		
		return "redirect:/admin/danh-sach-phieu-de-xuat";
	}
	
	@PostMapping(value="/loc-theo-trang-thai-phieu-de-xuat")
	public String loctheotrangthai(ModelMap map,
			@RequestParam(name="trangThai", required=true) int trangThai){
		if(trangThai == 4){
			return "redirect:/admin/danh-sach-phieu-de-xuat";
		}else{
			List<TblPhieuDeXuatDTO> phieuDeXuatDTOs = phieuDeXuatService.getAllByTrangThai(trangThai);
			map.addAttribute("phieuDeXuatDTOs", phieuDeXuatDTOs);
			
			map.addAttribute("status", trangThai);
			
			return "admin/listPhieuDeXuat";
		}
	}
	
}
