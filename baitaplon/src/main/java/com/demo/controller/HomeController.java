package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public String home(){
		return "client/home";
	}
	
	@GetMapping(value="/login")
	public String login(ModelMap map,
			@RequestParam(name="e", required=false) String error){
		
		map.addAttribute("e", error);
		
		return "admin/login";
	}
	
}
