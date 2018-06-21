package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.repository.TblPhieuChiDTO;
import com.demo.repository.TblPhieuDeXuatDTO;
import com.demo.service.PhieuDeXuatService;

@Controller
@RequestMapping(value="/admin")
public class PhieuDeXuatController {

	@Autowired
	PhieuDeXuatService phieuDeXuatService;
	
	@GetMapping(value="/chi-tiet-phieu-de-xuat")
	public String chiTietPDX() {
		return "admin/ChiTietPhieuDeXuat";
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
	@GetMapping("/danh-sach-phieu-de-xuat")
	public String index(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("phieuDeXuatDTOList", null);
		
		if(model.asMap().get("success") != null)
			redirect.addFlashAttribute("success",model.asMap().get("success").toString());
		return "redirect:/admin/danh-sach-phieu-de-xuat/page/1";
	}
	@GetMapping("/danh-sach-phieu-de-xuat/page/{pageNumber}")
	public String showPage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("phieuDeXuatDTOList");
		int pagesize = 2;
		List<TblPhieuDeXuatDTO> phieuDeXuatDTOs = phieuDeXuatService.getAll();
		System.out.println(phieuDeXuatDTOs.size());
		if (pages == null) {
			pages = new PagedListHolder<>(phieuDeXuatDTOs);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("phieuDeXuatDTOList", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - phieuDeXuatDTOs.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/admin/danh-sach-phieu-de-xuat/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("phieuDeXuatDTOs", pages);

		return "admin/listPhieuDeXuat";
	}
	//loc
	@GetMapping("/loc-danh-sach-phieu-de-xuat")
	public String locPage1(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("phieuDeXuatDTOList", null);
		
		if(model.asMap().get("success") != null)
			redirect.addFlashAttribute("success",model.asMap().get("success").toString());
		return "redirect:/admin/loc-danh-sach-phieu-de-xuat/page/1";
	}
	@GetMapping("/loc-danh-sach-phieu-de-xuat/page/{pageNumber}")
	public String loc(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model, @RequestParam(name="trangThai", required=true) int trangThai) {
		List<TblPhieuDeXuatDTO> phieuDeXuatDTO = phieuDeXuatService.getAllByTrangThai(trangThai);
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("phieuDeXuatDTO");
		int pagesize = 2;
		
		System.out.println(phieuDeXuatDTO.size());
		if (pages == null) {
			pages = new PagedListHolder<>(phieuDeXuatDTO);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("phieuDeXuatDTOs", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - phieuDeXuatDTO.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/admin/loc-danh-sach-phieu-de-xuat/page/";
		
		model.addAttribute("trangThai", trangThai);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("phieuDeXuatDTO", pages);

		return "admin/locPhieuDeXuat";
	}
	
}
