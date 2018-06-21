package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.NoiDungDeXuatDao;
import com.demo.dao.PhieuDeXuatDao;
import com.demo.dao.entity.TblNoiDungDeXuat;
import com.demo.repository.TblNoiDungDeXuatDTO;
import com.demo.service.NoiDungDeXuatService;

@Service
@Transactional
public class NoiDungDeXuatServiceImpl implements NoiDungDeXuatService{

	@Autowired
	NoiDungDeXuatDao noiDungDeXuatDao;
	
	@Autowired
	PhieuDeXuatDao phieuDeXuatDao;
	
	
	@Override
	public void AddNoiDungDeXuatDTO(TblNoiDungDeXuatDTO noiDungDeXuatDTO) {
		// TODO Auto-generated method stub
		TblNoiDungDeXuat noiDungDeXuat = new TblNoiDungDeXuat();
		
		noiDungDeXuat.setId(noiDungDeXuatDTO.getId());
		noiDungDeXuat.setNoiDungDeXuat(noiDungDeXuatDTO.getNoiDungDeXuat());
		noiDungDeXuat.setSoNgay(noiDungDeXuatDTO.getSoNgay());
		
		noiDungDeXuat.setSoLuong(noiDungDeXuatDTO.getSoLuong());
		noiDungDeXuat.setDonGia(noiDungDeXuatDTO.getDonGia());
		noiDungDeXuat.setThanhTien(noiDungDeXuatDTO.getThanhTien());
		
		noiDungDeXuat.setGhiChu(noiDungDeXuatDTO.getGhiChu());
		noiDungDeXuat.setTblPhieuDeXuat(phieuDeXuatDao.getPhieuDeXuat(noiDungDeXuatDTO.getIdPhieuDeXuat()));
		
		noiDungDeXuatDao.AddNoiDungDeXuat(noiDungDeXuat);
	}


}
