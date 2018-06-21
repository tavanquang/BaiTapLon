package com.demo.dao;

import java.util.List;

import com.demo.dao.entity.TblPhieuDeXuat;
import com.demo.repository.TblNoiDungDeXuatDTO;

public interface PhieuDeXuatDao {

	public List<TblPhieuDeXuat> getAll();

	public TblPhieuDeXuat AddPhieuDeXuat(TblPhieuDeXuat phieuDeXuat);

	public void ChuyenTrangThaiPhieuDeXuat(TblPhieuDeXuat phieuDeXuat);
	
	public List<TblPhieuDeXuat> getAllByTrangThai(int trangThai);

	public TblPhieuDeXuat getPhieuDeXuat(int id);

}
