package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.repository.TblPhieuChiDTO;
import com.demo.service.PhieuChiService;
import com.demo.service.impl.PhieuChiServiceImpl;

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
	@GetMapping(value="/loc-theo-trang-thai-PC")
	public String danhSachTheoTrangThai(ModelMap map, @RequestParam(name="trangThai", required=true) int trangThai) {
		List<TblPhieuChiDTO> phieuChiDTOs = phieuChiService.getAllByTrangThai(trangThai);
		map.addAttribute("phieuChiDTOs", phieuChiDTOs);
		return "admin/listPhieuChi";
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
