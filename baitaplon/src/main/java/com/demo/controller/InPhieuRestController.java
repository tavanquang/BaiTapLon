package com.demo.controller;

import static org.assertj.core.api.Assertions.in;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
public class InPhieuRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	FileOut fout;
	@Autowired
	PhieuDeXuatService phieuDeXuatService;

	@Autowired
	PhieuChiService phieuChiService;

	@GetMapping("/phieudexuat")
	public ResponseEntity<InputStreamResource> InPhieuDeXuat(@RequestParam(name = "id", required = true) int id)
			throws IOException, DocumentException {

		LOGGER.info("da di vao ham");

		TblPhieuDeXuatDTO deXuatDTO = phieuDeXuatService.getPhieuDeXuatDTO(id);
		LOGGER.info(deXuatDTO.toString());

		ClassLoader classLoader = getClass().getClassLoader();
		File f = new File(classLoader.getResource("inphieudexuat/phieudexuat.html").getFile());
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ByteArrayInputStream inputstream = phieuDeXuatService.inphieu(f, arrayOutputStream, deXuatDTO);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "filename=" + "phieudexuat.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentLength(arrayOutputStream.size());
		ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
				new InputStreamResource(inputstream), headers, HttpStatus.OK);

		return response;
	}

	@GetMapping("/phieuchi")
	public ResponseEntity<InputStreamResource> InPhieuChi(@RequestParam(name = "id", required = true) int id)
			throws IOException, DocumentException {

		LOGGER.info("da di vao ham");

		TblPhieuChiDTO deChiDTO = phieuChiService.getPhieuChiDTO(id);
		LOGGER.info(deChiDTO.toString());

		ClassLoader classLoader = getClass().getClassLoader();
		File f = new File(classLoader.getResource("inphieuchi/phieuchi.html").getFile());
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ByteArrayInputStream inputstream = phieuChiService.inphieu(f, arrayOutputStream, deChiDTO);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "filename=" + "phieuchi.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentLength(arrayOutputStream.size());
		ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
				new InputStreamResource(inputstream), headers, HttpStatus.OK);

		return response;
	}

}
