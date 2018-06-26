package com.demo.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.repository.TblPhieuChiDTO;
import com.demo.repository.TblPhieuDeXuatDTO;
import com.demo.service.FileOut;
import com.demo.service.PhieuChiService;
import com.demo.service.PhieuDeXuatService;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping(value = "/api")
public class api {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	FileOut fout;
	@Autowired
	PhieuDeXuatService phieuDeXuatService;
	
	@Autowired
	PhieuChiService phieuChiService;

	@GetMapping("/{tenphieu}")
	public ResponseEntity<InputStreamResource> downloadFile1(
			@PathVariable(name = "tenphieu", required = true) String tenphieu,
			@RequestParam(name = "id", required = true) int id) throws IOException, DocumentException {

		LOGGER.info("da di vao ham");

		if (tenphieu.equals("phieudexuat")) {
			TblPhieuDeXuatDTO deXuatDTO = phieuDeXuatService.getPhieuDeXuatDTO(id);
			LOGGER.info(deXuatDTO.toString());

			ClassLoader classLoader = getClass().getClassLoader();
			File f = new File(classLoader.getResource("inphieudexuat/demo.html").getFile());

			File outHtml = new File(classLoader.getResource("inphieudexuat/outHtml.html").getFile());

			File Out = new File(classLoader.getResource("inphieudexuat/outpdf.pdf").getFile());

			InputStreamResource resource = new InputStreamResource(
					phieuDeXuatService.inphieu(f, outHtml, Out, deXuatDTO));

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + Out.getName())
					.contentType(MediaType.APPLICATION_PDF).contentLength(Out.length()).body(resource);
		}
		else if(tenphieu.equals("phieuchi")) {
			TblPhieuChiDTO deChiDTO = phieuChiService.getPhieuChiDTO(id);
			LOGGER.info(deChiDTO.toString());

			ClassLoader classLoader = getClass().getClassLoader();
			File f = new File(classLoader.getResource("inphieuchi/demo.html").getFile());

			File outHtml = new File(classLoader.getResource("inphieuchi/outHtml.html").getFile());

			File Out = new File(classLoader.getResource("inphieuchi/outpdf.pdf").getFile());

			InputStreamResource resource = new InputStreamResource(
					phieuChiService.inphieu(f, outHtml, Out, deChiDTO));

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + Out.getName())
					.contentType(MediaType.APPLICATION_PDF).contentLength(Out.length()).body(resource);
		}
		return null;
		
	
	

	}
}
