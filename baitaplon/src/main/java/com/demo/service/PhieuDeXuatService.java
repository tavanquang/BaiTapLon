package com.demo.service;

import java.util.List;

import com.demo.repository.TblPhieuDeXuatDTO;

public interface PhieuDeXuatService {

	public List<TblPhieuDeXuatDTO> getAll();

	public void AddPhieuDeXuatDTO(TblPhieuDeXuatDTO phieuDeXuatDTO);

	public TblPhieuDeXuatDTO getPhieuDeXuatDTO(int id);

	public void ChuyenTrangThai(TblPhieuDeXuatDTO phieuDeXuatDTO);
}
