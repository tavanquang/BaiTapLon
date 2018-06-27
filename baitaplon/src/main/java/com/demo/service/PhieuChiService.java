package com.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import com.demo.repository.TblPhieuChiDTO;
import com.demo.repository.TblPhieuDeXuatDTO;

public interface PhieuChiService {

	public List<TblPhieuChiDTO> getAll();

	public void AddPhieuChiDTO(TblPhieuChiDTO phieuChiDTO);

	public TblPhieuChiDTO getPhieuChiDTO(int id);

	public void ChuyenTrangThai(TblPhieuChiDTO phieuChiDTO);

	public List<TblPhieuChiDTO> getAllByTrangThai(int trangThai);
	
	public ByteArrayInputStream inphieu(File fileInHtml,ByteArrayOutputStream outputStream,  TblPhieuChiDTO deChiDTO);

}
