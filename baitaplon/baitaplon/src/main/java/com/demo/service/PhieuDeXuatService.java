package com.demo.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.dao.entity.TblPhieuDeXuat;
import com.demo.repository.TblNoiDungDeXuatDTO;
import com.demo.repository.TblPhieuDeXuatDTO;

public interface PhieuDeXuatService {

	public List<TblPhieuDeXuatDTO> getAll();

	public void AddPhieuDeXuatDTO(TblPhieuDeXuatDTO phieuDeXuatDTO);

	public TblPhieuDeXuatDTO getPhieuDeXuatDTO(int id);

	public void ChuyenTrangThai(TblPhieuDeXuatDTO phieuDeXuatDTO);
	
	public List<TblPhieuDeXuatDTO> getAllByTrangThai(int trangThai);
}
