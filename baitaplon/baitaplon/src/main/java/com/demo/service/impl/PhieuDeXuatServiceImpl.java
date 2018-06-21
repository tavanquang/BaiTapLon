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

	@Autowired
	NoiDungDeXuatServiceImpl noiDungService;
	
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
			
			
			phieuDeXuatDTO.setTrangThai(phieuDeXuat.getTrangThai());
			
			
			
			
			phieuDeXuatDTO.setTongTien(phieuDeXuat.getTongTien());
			
			phieuDeXuatDTOs.add(phieuDeXuatDTO);
		
		}
		
		return phieuDeXuatDTOs;
	}


	@Override
	public void AddPhieuDeXuatDTO(TblPhieuDeXuatDTO phieuDeXuatDTO ) {
		// TODO Auto-generated method stub
		TblPhieuDeXuat phieuDeXuat = new TblPhieuDeXuat();
		
		phieuDeXuat.setId(phieuDeXuatDTO.getId());
		phieuDeXuat.setKinhGui(phieuDeXuatDTO.getKinhGui());
		phieuDeXuat.setNguoiDeNghi(phieuDeXuatDTO.getNguoiDeNghi());
		
		phieuDeXuat.setNgayBatDau(phieuDeXuatDTO.getNgayBatDau());
		phieuDeXuat.setNgayHoanThanh(phieuDeXuatDTO.getNgayHoanThanh());
		phieuDeXuat.setNoiDungDeXuat(phieuDeXuatDTO.getNoiDungDeXuat());
		
		phieuDeXuat.setYKienLanhDao(phieuDeXuatDTO.getyKienLanhDao());
		phieuDeXuat.setNgayDeXuat(new Date());
		phieuDeXuat.setNguoiKeToan(phieuDeXuatDTO.getNguoiKeToan());
		
		phieuDeXuat.setGiamDoc(phieuDeXuatDTO.getGiamDoc());
		phieuDeXuat.setDeXuatNgayMua(phieuDeXuatDTO.getDeXuatNgayMua());
		
		List<TblNoiDungDeXuatDTO> deXuats = phieuDeXuatDTO.getTblNoiDungDeXuat();
		
		
		double tt = 0;
		for(int i = 0; i < deXuats.size(); i++ ){
			
			int soLuong = deXuats.get(i).getSoLuong();
			double donGia = deXuats.get(i).getDonGia();
			
			double thanhtien = soLuong* donGia;
			
			deXuats.get(i).setThanhTien(thanhtien);
			
			tt += thanhtien;
		}
		
		
		phieuDeXuat.setTongTien(tt);
		phieuDeXuat.setTrangThai(0);
	
		
		
		
		 
		 		
		 TblPhieuDeXuat deXuat= phieuDeXuatDao.AddPhieuDeXuat(phieuDeXuat);
		 
		for (TblNoiDungDeXuatDTO tblNoiDungDeXuatDTO : deXuats) {
			
			tblNoiDungDeXuatDTO.setIdPhieuDeXuat(deXuat.getId());
			noiDungService.AddNoiDungDeXuatDTO(tblNoiDungDeXuatDTO);
			
//			noiDungDeXuatDao.AddNoiDungDeXuat(dungDeXuat);
		}
		
	
		 
		
		

		
		
	
		
		
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
		
		phieuDeXuatDTO.setTongTien(phieuDeXuat.getTongTien());
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
		
		phieuDeXuatDTO.setTblNoiDungDeXuat(noiDungDeXuatDTOs);
		
		return phieuDeXuatDTO;
	}

	@Override
	public void ChuyenTrangThai(TblPhieuDeXuatDTO phieuDeXuatDTO) {
		
		TblPhieuDeXuat phieuDeXuat = phieuDeXuatDao.getPhieuDeXuat(phieuDeXuatDTO.getId());
		
		if(phieuDeXuat != null){
			
			phieuDeXuat.setTrangThai(phieuDeXuatDTO.getTrangThai());
		}
	}

	@Override
	public List<TblPhieuDeXuatDTO> getAllByTrangThai(int trangThai) {
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale); 
		
		List<TblPhieuDeXuatDTO> phieuDeXuatDTOs = new ArrayList<TblPhieuDeXuatDTO>();
		List<TblPhieuDeXuat> phieuDeXuats = phieuDeXuatDao.getAllByTrangThai(trangThai);
		for(TblPhieuDeXuat phieuDeXuat : phieuDeXuats){
			
			TblPhieuDeXuatDTO phieuDeXuatDTO = new TblPhieuDeXuatDTO();
			
			phieuDeXuatDTO.setId(phieuDeXuat.getId());
			phieuDeXuatDTO.setNguoiDeNghi(phieuDeXuat.getNguoiDeNghi());
			phieuDeXuatDTO.setNoiDungDeXuat(phieuDeXuat.getNoiDungDeXuat());
			
			phieuDeXuatDTO.setNgayDeXuat(phieuDeXuat.getNgayDeXuat());
			phieuDeXuatDTO.setTongTien(phieuDeXuat.getTongTien());
			
			phieuDeXuatDTO.setNguoiKeToan(phieuDeXuat.getNguoiKeToan());
			phieuDeXuatDTO.setTrangThai(phieuDeXuat.getTrangThai());
			
			phieuDeXuatDTOs.add(phieuDeXuatDTO);
		}
		
		return phieuDeXuatDTOs;
	}
	
	
}
