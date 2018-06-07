package com.demo.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.NoiDungDeXuatDao;
import com.demo.dao.PhieuDeXuatDao;
import com.demo.dao.entity.TblNoiDungDeXuat;
import com.demo.dao.entity.TblPhieuDeXuat;
import com.demo.repository.TblNoiDungDeXuatDTO;
import com.demo.repository.TblPhieuDeXuatDTO;
import com.demo.service.PhieuDeXuatService;

@Service
@Transactional
public class PhieuDeXuatServiceImpl implements PhieuDeXuatService{

	@Autowired
	PhieuDeXuatDao phieuDeXuatDao;
	
	@Autowired
	NoiDungDeXuatDao noiDungDeXuatDao;

	@Override
	public List<TblPhieuDeXuatDTO> getAll() {
		
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		
		List<TblPhieuDeXuatDTO> phieuDeXuatDTOs = new ArrayList<TblPhieuDeXuatDTO>();
		List<TblPhieuDeXuat> phieuDeXuats = phieuDeXuatDao.getAll();
		
		 
		
		for(TblPhieuDeXuat phieuDeXuat : phieuDeXuats){
		
			TblPhieuDeXuatDTO phieuDeXuatDTO = new TblPhieuDeXuatDTO();
			
			phieuDeXuatDTO.setId(phieuDeXuat.getId());
			phieuDeXuatDTO.setKinhGui(phieuDeXuat.getKinhGui());
			phieuDeXuatDTO.setNguoiDeNghi(phieuDeXuat.getNguoiDeNghi());
			
			phieuDeXuatDTO.setNgayBatDau(phieuDeXuat.getNgayBatDau());
			phieuDeXuatDTO.setNgayHoanThanh(phieuDeXuat.getNgayHoanThanh());
			phieuDeXuatDTO.setNoiDungDeXuat(phieuDeXuat.getNoiDungDeXuat());
			
			phieuDeXuatDTO.setyKienLanhDao(phieuDeXuat.getYKienLanhDao());
			phieuDeXuatDTO.setNgayDeXuat(phieuDeXuat.getNgayDeXuat());
			phieuDeXuatDTO.setNguoiKeToan(phieuDeXuat.getNguoiKeToan());
			
			phieuDeXuatDTO.setGiamDoc(phieuDeXuat.getGiamDoc());
			phieuDeXuatDTO.setDeXuatNgayMua(phieuDeXuat.getDeXuatNgayMua());
			phieuDeXuatDTO.setGhiChu(phieuDeXuat.getGhiChu());
			
			phieuDeXuatDTO.setTongTien(phieuDeXuat.getTongTien());
			phieuDeXuatDTO.setTongTienFormat(format.format(phieuDeXuat.getTongTien()));
			phieuDeXuatDTO.setTrangThai(phieuDeXuat.getTrangThai());
			
			phieuDeXuatDTOs.add(phieuDeXuatDTO);
		
		}
		
		return phieuDeXuatDTOs;
	}

	@Override
	public void AddPhieuDeXuatDTO(TblPhieuDeXuatDTO phieuDeXuatDTO) {
		// TODO Auto-generated method stub
		TblPhieuDeXuat phieuDeXuat = new TblPhieuDeXuat();
		
		phieuDeXuat.setId(phieuDeXuatDTO.getId());
		phieuDeXuat.setKinhGui(phieuDeXuatDTO.getKinhGui());
		phieuDeXuat.setNguoiDeNghi(phieuDeXuatDTO.getNguoiDeNghi());
		
		phieuDeXuat.setNgayBatDau(phieuDeXuatDTO.getNgayBatDau());
		phieuDeXuat.setNgayHoanThanh(phieuDeXuatDTO.getNgayHoanThanh());
		phieuDeXuat.setNoiDungDeXuat(phieuDeXuatDTO.getNoiDungDeXuat());
		
		phieuDeXuat.setYKienLanhDao(phieuDeXuatDTO.getYKienLanhDao());
		phieuDeXuat.setNgayDeXuat(new Date());
		phieuDeXuat.setNguoiKeToan(phieuDeXuatDTO.getNguoiKeToan());
		
		phieuDeXuat.setGiamDoc(phieuDeXuatDTO.getGiamDoc());
		phieuDeXuat.setDeXuatNgayMua(phieuDeXuatDTO.getDeXuatNgayMua());
		phieuDeXuat.setGhiChu(phieuDeXuatDTO.getGhiChu());
		
		phieuDeXuat.setTongTien(phieuDeXuatDTO.getTongTien());
		phieuDeXuat.setTrangThai(0);
		
		/*
		 * 0. dang xet duyet
		 * 1. da xet duyet
		 * 2. da chi
		 */
		phieuDeXuatDao.AddPhieuDeXuat(phieuDeXuat);
		
	}

	@Override
	public TblPhieuDeXuatDTO getPhieuDeXuatDTO(int id) {
		// TODO Auto-generated method stub
		TblPhieuDeXuat phieuDeXuat = phieuDeXuatDao.getPhieuDeXuat(id);
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale); 
		
		TblPhieuDeXuatDTO phieuDeXuatDTO = new TblPhieuDeXuatDTO();
		
		phieuDeXuatDTO.setId(phieuDeXuat.getId());
		phieuDeXuatDTO.setKinhGui(phieuDeXuat.getKinhGui());
		phieuDeXuatDTO.setNguoiDeNghi(phieuDeXuat.getNguoiDeNghi());
		
		phieuDeXuatDTO.setNgayBatDau(phieuDeXuat.getNgayBatDau());
		phieuDeXuatDTO.setNgayHoanThanh(phieuDeXuat.getNgayHoanThanh());
		phieuDeXuatDTO.setNoiDungDeXuat(phieuDeXuat.getNoiDungDeXuat());
		
		phieuDeXuatDTO.setyKienLanhDao(phieuDeXuat.getYKienLanhDao());
		phieuDeXuatDTO.setNgayDeXuat(phieuDeXuat.getNgayDeXuat());
		phieuDeXuatDTO.setNguoiKeToan(phieuDeXuat.getNguoiKeToan());
		
		phieuDeXuatDTO.setGiamDoc(phieuDeXuat.getGiamDoc());
		phieuDeXuatDTO.setDeXuatNgayMua(phieuDeXuat.getDeXuatNgayMua());
		phieuDeXuatDTO.setGhiChu(phieuDeXuat.getGhiChu());
		
		phieuDeXuatDTO.setTongTien(phieuDeXuat.getTongTien());
		phieuDeXuatDTO.setTongTienFormat(format.format(phieuDeXuat.getTongTien()));
		phieuDeXuatDTO.setTrangThai(phieuDeXuat.getTrangThai());
		
		
		List<TblNoiDungDeXuatDTO> noiDungDeXuatDTOs = new ArrayList<TblNoiDungDeXuatDTO>();
		List<TblNoiDungDeXuat> noiDungDeXuats = noiDungDeXuatDao.getAllByIdPhieu(phieuDeXuatDao.getPhieuDeXuat(id));
		
		for(TblNoiDungDeXuat noiDungDeXuat : noiDungDeXuats){
			
			TblNoiDungDeXuatDTO noiDungDeXuatDTO = new TblNoiDungDeXuatDTO();
			
			noiDungDeXuatDTO.setId(noiDungDeXuat.getId());
			noiDungDeXuatDTO.setNoiDungDeXuat(noiDungDeXuat.getNoiDungDeXuat());
			noiDungDeXuatDTO.setSoNgay(noiDungDeXuat.getSoNgay());
			
			noiDungDeXuatDTO.setSoLuong(noiDungDeXuat.getSoLuong());
			noiDungDeXuatDTO.setDonGia(noiDungDeXuat.getDonGia());
			noiDungDeXuatDTO.setThanhTien(noiDungDeXuat.getThanhTien());
			noiDungDeXuatDTO.setThanhTienFormat(format.format(noiDungDeXuat.getThanhTien()));
			
			noiDungDeXuatDTO.setGhiChu(noiDungDeXuat.getGhiChu());
			noiDungDeXuatDTO.setIdPhieuDeXuat(noiDungDeXuat.getTblPhieuDeXuat().getId());
		
			noiDungDeXuatDTOs.add(noiDungDeXuatDTO);
		}
		
		phieuDeXuatDTO.setTblNoiDungDeXuats(noiDungDeXuatDTOs);
		
		return phieuDeXuatDTO;
	}

	@Override
	public void ChuyenTrangThai(TblPhieuDeXuatDTO phieuDeXuatDTO) {
		
		TblPhieuDeXuat phieuDeXuat = phieuDeXuatDao.getPhieuDeXuat(phieuDeXuatDTO.getId());
		
		if(phieuDeXuat != null){
			
			phieuDeXuat.setTrangThai(phieuDeXuatDTO.getTrangThai());
		}
	}
	
	
}
