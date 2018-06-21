package com.demo.dao;

import java.util.List;

import com.demo.dao.entity.TblPhieuChi;

public interface PhieuChiDao {

	public List<TblPhieuChi> getAll();
	
	public void AddPhieuChi(TblPhieuChi phieuChi);
	
	public TblPhieuChi getPhieuChi(int id);

	public List<TblPhieuChi> getAllByTrangThai(int trangThai);
	
	public void ChuyenTrangThaiPhieuChi(TblPhieuChi phieuChi);
	
}
