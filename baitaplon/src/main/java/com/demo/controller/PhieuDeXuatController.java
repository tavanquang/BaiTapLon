package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhieuDeXuatController {

	@GetMapping(value="/them-phieu-de-xuat")
	public String themphieudeXuat(){
		return "client/themPhieuDeXuat";
	}
	
	@GetMapping(value="/chuyen-trang-thai")
	public String home(){
		return "admin/chuyenTrangThai";
	}
	
}
