package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.repository.TblPhieuChiDTO;
import com.demo.service.PhieuChiService;

@Controller
@RequestMapping(value="/admin")
public class PhieuChiController {

	@Autowired
	PhieuChiService phieuChiService;
	
	@GetMapping(value="/")
	public String index(){
		return "admin/index";
	}
	
	@GetMapping(value="/danh-sach-phieu-chi")
	public String danhSachPhieuChi(ModelMap map){
		
		List<TblPhieuChiDTO> phieuChiDTOs = phieuChiService.getAll();
		map.addAttribute("phieuChiDTOs", phieuChiDTOs);
		
		return "admin/listPhieuChi";
	}
	
	@GetMapping(value="/chuyen-trang-thai-phieu-chi")
	public String chuyenTrangThaiPhieuChi(ModelMap map,
			@RequestParam(name="trangThai", required=true) int trangThai,
			@RequestParam(name="id", required=true) int id){
		
		TblPhieuChiDTO phieuChiDTO = phieuChiService.getPhieuChiDTO(id);
		phieuChiDTO.setTrangThai(trangThai);
		phieuChiService.ChuyenTrangThai(phieuChiDTO);
		
		return "redirect:/admin/danh-sach-phieu-chi";
	}
}
