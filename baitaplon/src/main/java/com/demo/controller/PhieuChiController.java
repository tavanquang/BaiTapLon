package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping(value="/chi-tiet-phieu-chi")
	public String chiTietPC() {
		return "admin/ChiTietPhieuChi";
	}
	@GetMapping(value="/danh-sach-phieu-chi")
	public String danhSachPhieuChi(ModelMap map){
		
		List<TblPhieuChiDTO> phieuChiDTOs = phieuChiService.getAll();
		map.addAttribute("phieuChiDTOs", phieuChiDTOs);
		map.addAttribute("status", "4");
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
	
	
	@GetMapping(value="/them-phieu-chi")
	public String themPhieuChi(ModelMap map){
		
		TblPhieuChiDTO phieuChiDTO = new TblPhieuChiDTO();
		map.addAttribute("phieuChiDTO", phieuChiDTO);
		 
		return "client/themPhieuChi";
	}
	
	@PostMapping(value="/them-phieu-chi")
	public String themPhieuChi(ModelMap map,
			@ModelAttribute(name="phieuChiDTO")TblPhieuChiDTO phieuChiDTO){
		
		phieuChiService.AddPhieuChiDTO(phieuChiDTO);
		map.addAttribute("msg", "1");
		return "redirect:/admin//them-phieu-chi";
	}
	
	
	@PostMapping(value="/loc-theo-trang-thai-phieu-chi")
	public String loctheotrangthai(ModelMap map,
			@RequestParam(name="trangThai", required=true) int trangThai){
		if(trangThai == 4){
			return "redirect:/admin/danh-sach-phieu-chi";
		}else{
		
		List<TblPhieuChiDTO> phieuChiDTOs = phieuChiService.getAllByTrangThai(trangThai);
		
		map.addAttribute("phieuChiDTOs", phieuChiDTOs);
		map.addAttribute("status", trangThai);
		return "admin/listPhieuChi";
		}
	}
	
	
	
	
	
}
