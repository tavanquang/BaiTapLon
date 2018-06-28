package com.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		ByteArrayInputStream inputstream =  phieuDeXuatService.inphieu(f, arrayOutputStream, deXuatDTO);

		String filename = "phieudexuat.pdf";
		InputStreamResource resource = new InputStreamResource(inputstream);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "inline;filename=" + filename);
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		ResponseEntity<InputStreamResource> response = new ResponseEntity<>(resource, headers, HttpStatus.OK);
		
		return response;
		
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "phieudexuat.pdf")
//				.contentType(MediaType.APPLICATION_PDF).contentLength(arrayOutputStream.size()).body(resource);

	}

	@GetMapping("/phieuchi")
	public ResponseEntity<InputStreamResource> InPhieuChi(@RequestParam(name = "id", required = true) int id)
			throws IOException, DocumentException {

		LOGGER.info("da di vao ham");

		ByteArrayInputStream inputstream = null;
		ByteArrayOutputStream arrayOutputStream = null;

		TblPhieuChiDTO deChiDTO = phieuChiService.getPhieuChiDTO(id);
		LOGGER.info(deChiDTO.toString());

		ClassLoader classLoader = getClass().getClassLoader();
		File f = new File(classLoader.getResource("inphieuchi/phieuchi.html").getFile());
		arrayOutputStream = new ByteArrayOutputStream();
		inputstream = phieuChiService.inphieu(f, arrayOutputStream, deChiDTO);

		InputStreamResource resource = new InputStreamResource(inputstream);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "chieuchi.pdf")
				.contentType(MediaType.APPLICATION_PDF).contentLength(arrayOutputStream.size()).body(resource);

	}

}
