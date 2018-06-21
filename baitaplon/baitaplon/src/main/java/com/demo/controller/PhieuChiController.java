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
import com.demo.service.PhieuChiService;

@Controller
@RequestMapping(value="/admin")
public class PhieuChiController {

	@Autowired
	PhieuChiService phieuChiService;
	
	@GetMapping(value="")
	public String index(){
		return "admin/index";
	}
	
	@GetMapping(value="/chi-tiet-phieu-chi")
	public String trangChiTiet(ModelMap map,@RequestParam(name="id", required=true) int id) {
		TblPhieuChiDTO phieuChiDTO = phieuChiService.getPhieuChiDTO(id);
		map.addAttribute("phieuChiDTO", phieuChiDTO);
		return "admin/ChitietPhieuChi";
	}
	@GetMapping(value="/thong-tin-phieu-chi")
	public String chiTietPhieuChi(ModelMap map) {
		return "redirect:/admin/thong-tin-phieu-chi";
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
	
	@GetMapping("/danh-sach-phieu-chi")
	public String index(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("phieuChiDTOList", null);
		
		if(model.asMap().get("success") != null)
			redirect.addFlashAttribute("success",model.asMap().get("success").toString());
		return "redirect:/admin/danh-sach-phieu-chi/page/1";
	}
	@GetMapping("/danh-sach-phieu-chi/page/{pageNumber}")
	public String showPage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("phieuChiDTOList");
		int pagesize = 2;
		List<TblPhieuChiDTO> phieuChiDTOs = phieuChiService.getAll();
		System.out.println(phieuChiDTOs.size());
		if (pages == null) {
			pages = new PagedListHolder<>(phieuChiDTOs);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("phieuChiDTOList", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - phieuChiDTOs.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/admin/danh-sach-phieu-chi/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("phieuChiDTOs", pages);

		return "admin/listPhieuChi";
	}
	//loc
	@GetMapping("/loc-danh-sach-phieu-chi")
	public String locPage1(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("phieuChiDTOList", null);
		
		if(model.asMap().get("success") != null)
			redirect.addFlashAttribute("success",model.asMap().get("success").toString());
		return "redirect:/admin/loc-danh-sach-phieu-chi/page/1";
	}
	@GetMapping("/loc-danh-sach-phieu-chi/page/{pageNumber}")
	public String loc(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model, @RequestParam(name="trangThai", required=true) int trangThai) {
		List<TblPhieuChiDTO> phieuChiDTO = phieuChiService.getAllByTrangThai(trangThai);
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("phieuChiDTO");
		int pagesize = 2;
		
		System.out.println(phieuChiDTO.size());
		if (pages == null) {
			pages = new PagedListHolder<>(phieuChiDTO);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("phieuChiDTOs", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - phieuChiDTO.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/admin/loc-danh-sach-phieu-chi/page/";
		
		model.addAttribute("trangThai", trangThai);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("phieuChiDTO", pages);

		return "admin/locPhieuChi";
	}
}
