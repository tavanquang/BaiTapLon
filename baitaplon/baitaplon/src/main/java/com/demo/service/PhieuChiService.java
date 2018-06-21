package com.demo.service;

import java.util.List;

import com.demo.repository.TblPhieuChiDTO;

public interface PhieuChiService {

	public List<TblPhieuChiDTO> getAll();

	public void AddPhieuChiDTO(TblPhieuChiDTO phieuChiDTO);

	public TblPhieuChiDTO getPhieuChiDTO(int id);

	public void ChuyenTrangThai(TblPhieuChiDTO phieuChiDTO);

	public List<TblPhieuChiDTO> getAllByTrangThai(int trangThai);

}
