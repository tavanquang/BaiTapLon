package com.demo.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.PhieuChiDao;
import com.demo.dao.entity.TblPhieuChi;
import com.demo.repository.TblPhieuChiDTO;
import com.demo.service.PhieuChiService;


@Transactional
@Service
public class PhieuChiServiceImpl implements PhieuChiService{

	@Autowired
	PhieuChiDao phieuChiDao;

	@Override
	public List<TblPhieuChiDTO> getAll() {

		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale); 
		
		List<TblPhieuChiDTO> phieuChiDTOs = new ArrayList<TblPhieuChiDTO>();
		List<TblPhieuChi> phieuChis = phieuChiDao.getAll();
		for(TblPhieuChi phieuChi : phieuChis){
			
			TblPhieuChiDTO phieuChiDTO = new TblPhieuChiDTO();
			
			phieuChiDTO.setId(phieuChi.getId());
			phieuChiDTO.setNguoiNhanTien(phieuChi.getNguoiNhanTien());
			phieuChiDTO.setDiaChi(phieuChi.getDiaChi());
			
			phieuChiDTO.setLyDoChi(phieuChi.getLyDoChi());
			phieuChiDTO.setSoTien(phieuChi.getSoTien());
			phieuChiDTO.setSoTienFormat(format.format(phieuChi.getSoTien()));
			
			phieuChiDTO.setHinhAnh(phieuChi.getHinhAnh());
			phieuChiDTO.setNgayLapPhieu(phieuChi.getNgayLapPhieu());
			phieuChiDTO.setGiamDoc(phieuChi.getGiamDoc());
			phieuChiDTO.setNguoiLapPhieu(phieuChi.getNguoiLapPhieu());
			
			phieuChiDTO.setTrangThai(phieuChi.getTrangThai());
			
			phieuChiDTOs.add(phieuChiDTO);
		}
		
		return phieuChiDTOs;
	}

	@Override
	public void AddPhieuChiDTO(TblPhieuChiDTO phieuChiDTO) {
		
		TblPhieuChi phieuChi = new TblPhieuChi();
		
		phieuChi.setId(phieuChiDTO.getId());
		phieuChi.setNguoiNhanTien(phieuChiDTO.getNguoiNhanTien());
		phieuChi.setDiaChi(phieuChiDTO.getDiaChi());
		
		phieuChi.setLyDoChi(phieuChiDTO.getLyDoChi());
		phieuChi.setSoTien(phieuChiDTO.getSoTien());
		
		phieuChi.setHinhAnh(phieuChiDTO.getHinhAnh());
		phieuChi.setNgayLapPhieu(new Date());
		phieuChi.setNguoiLapPhieu(phieuChiDTO.getNguoiLapPhieu());
		phieuChi.setGiamDoc(phieuChiDTO.getGiamDoc());
		
		
		phieuChi.setTrangThai(0);
		
		/*
		 * 0. dang xet duyet
		 * 1. da xet duyet
		 * 2. da chi
		 */
		
		phieuChiDao.AddPhieuChi(phieuChi);
	}


	@Override
	public TblPhieuChiDTO getPhieuChiDTO(int id) {
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale); 
		
		TblPhieuChi phieuChi = phieuChiDao.getPhieuChi(id);
		
		TblPhieuChiDTO phieuChiDTO = new TblPhieuChiDTO();
		
		phieuChiDTO.setId(phieuChi.getId());
		phieuChiDTO.setNguoiNhanTien(phieuChi.getNguoiNhanTien());
		phieuChiDTO.setDiaChi(phieuChi.getDiaChi());
		
		phieuChiDTO.setLyDoChi(phieuChi.getLyDoChi());
		phieuChiDTO.setSoTien(phieuChi.getSoTien());
		phieuChiDTO.setSoTienFormat(format.format(phieuChi.getSoTien()));
		
		phieuChiDTO.setHinhAnh(phieuChi.getHinhAnh());
		phieuChiDTO.setNgayLapPhieu(phieuChi.getNgayLapPhieu());
		phieuChiDTO.setGiamDoc(phieuChi.getGiamDoc());
		phieuChiDTO.setNguoiLapPhieu(phieuChi.getNguoiLapPhieu());
		
		phieuChiDTO.setTrangThai(phieuChi.getTrangThai());
		
		return phieuChiDTO;
	}

	@Override
	public void ChuyenTrangThai(TblPhieuChiDTO phieuChiDTO) {
		// TODO Auto-generated method stub
		TblPhieuChi phieuChi = phieuChiDao.getPhieuChi(phieuChiDTO.getId());
		if(phieuChi != null){
			phieuChi.setTrangThai(phieuChiDTO.getTrangThai());
		}
	}

	@Override
	public List<TblPhieuChiDTO> getAllByTrangThai(int trangThai) {
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale); 
		
		List<TblPhieuChiDTO> phieuChiDTOs = new ArrayList<TblPhieuChiDTO>();
		List<TblPhieuChi> phieuChis = phieuChiDao.getAllByTrangThai(trangThai);
		for(TblPhieuChi phieuChi : phieuChis){
			
			TblPhieuChiDTO phieuChiDTO = new TblPhieuChiDTO();
			
			phieuChiDTO.setId(phieuChi.getId());
			phieuChiDTO.setNguoiNhanTien(phieuChi.getNguoiNhanTien());
			phieuChiDTO.setDiaChi(phieuChi.getDiaChi());
			
			phieuChiDTO.setLyDoChi(phieuChi.getLyDoChi());
			phieuChiDTO.setSoTien(phieuChi.getSoTien());
			phieuChiDTO.setSoTienFormat(format.format(phieuChi.getSoTien()));
			
			phieuChiDTO.setHinhAnh(phieuChi.getHinhAnh());
			phieuChiDTO.setNgayLapPhieu(phieuChi.getNgayLapPhieu());
			phieuChiDTO.setGiamDoc(phieuChi.getGiamDoc());
			phieuChiDTO.setNguoiLapPhieu(phieuChi.getNguoiLapPhieu());
			
			phieuChiDTO.setTrangThai(phieuChi.getTrangThai());
			
			phieuChiDTOs.add(phieuChiDTO);
		}
		
		return phieuChiDTOs;
	}
	
	
}
