package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhieuChiController {

	@GetMapping(value="/them-phieu-chi")
	public String themPhieuChi(){
		return "client/themPhieuChi";
	}
	
}
