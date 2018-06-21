package com.demo.dao;

import java.util.List;

import com.demo.dao.entity.TblNoiDungDeXuat;
import com.demo.dao.entity.TblPhieuDeXuat;

public interface NoiDungDeXuatDao {

	public List<TblNoiDungDeXuat> getAllByIdPhieu(TblPhieuDeXuat phieuDeXuat);
	
	public void AddNoiDungDeXuat(TblNoiDungDeXuat noiDungDeXuat);

}
