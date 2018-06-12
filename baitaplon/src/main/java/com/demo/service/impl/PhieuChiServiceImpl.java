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
			phieuChiDTO.setVietBangChu(phieuChi.getVietBangChu());
			
			phieuChiDTO.setKemTheo(phieuChi.getKemTheo());
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
		phieuChi.setVietBangChu(chuyenSoThanhChu(phieuChiDTO.getSoTien()));
		
		phieuChi.setKemTheo(phieuChiDTO.getKemTheo());
		phieuChi.setNgayLapPhieu(new Date());
		phieuChi.setGiamDoc(phieuChiDTO.getGiamDoc());
		phieuChi.setNguoiLapPhieu(phieuChiDTO.getNguoiLapPhieu());
		
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
		phieuChiDTO.setVietBangChu(phieuChi.getVietBangChu());
		
		phieuChiDTO.setKemTheo(phieuChi.getKemTheo());
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
			phieuChiDTO.setVietBangChu(phieuChi.getVietBangChu());
			
			phieuChiDTO.setKemTheo(phieuChi.getKemTheo());
			phieuChiDTO.setNgayLapPhieu(phieuChi.getNgayLapPhieu());
			phieuChiDTO.setGiamDoc(phieuChi.getGiamDoc());
			phieuChiDTO.setNguoiLapPhieu(phieuChi.getNguoiLapPhieu());
			
			phieuChiDTO.setTrangThai(phieuChi.getTrangThai());
			
			phieuChiDTOs.add(phieuChiDTO);
		}
		
		return phieuChiDTOs;
	}
	
	
	public static String chuyenSoThanhChu(double input) {
		input = (int) input;
		String result = "";
		String str_000_000_000 = "";
		String str_00_000_000 = "";
		String str_0_000_000 = "";
		String str_000_000 = "";
		String str_00_000 = "";
		String str_0_000 = "";
		String str_000 = "";
		String str_00 = "";
		String str_0 = "";
		
		int digit_000_000_000 = 0;
		int digit_00_000_000 = 0;
		int digit_0_000_000 = 0;
		int digit_000_000 = 0;
		int digit_00_000 = 0;
		int digit_0_000 = 0;
		int digit_000 = 0;
		int digit_00 = 0;
		
		int DIGIT_00_000_000 = 0;
		int DIGIT_0_000_000 = 0;
		int DIGIT_000_000 = 0;
		int DIGIT_00_000 = 0;
		int DIGIT_0_000 = 0;
		int DIGIT_000 = 0;
		int DIGIT_00 = 0;
		int DIGIT_0 = 0;
		
		
		String[] dictionary	= {"không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
		
		boolean flag = false;
		
		if(!flag){
			
			if(input > 99999999){
				flag = true;
				digit_000_000_000 = (int) (input / 100000000);
				DIGIT_00_000_000 = (int) (input % 100000000);
				str_000_000_000 = dictionary[digit_000_000_000] + " trăm ";
				if(DIGIT_00_000_000 == 0){
					str_00_000_000 = " triệu";
				}
				
				if(DIGIT_00_000_000 > 9999999){
					digit_00_000_000 = DIGIT_00_000_000 / 10000000;
					DIGIT_0_000_000 = DIGIT_00_000_000 % 10000000;
					str_00_000_000 = dictionary[digit_00_000_000] + " mươi ";
					if(DIGIT_0_000_000 == 0){
						str_00_000_000 = dictionary[digit_00_000_000] + " mươi triệu đồng";
					}
				}
				
				if(DIGIT_0_000_000 > 999999){
					digit_0_000_000 = DIGIT_0_000_000 / 1000000;
					DIGIT_000_000 = DIGIT_0_000_000 % 1000000;
					str_0_000_000 = dictionary[digit_0_000_000] + " triệu ";
				}
				
				if(DIGIT_000_000 == 0){
					str_0_000_000 = "";
				}
				
				if(digit_0_000_000 != 0){
					str_0_000_000 = dictionary[digit_0_000_000] + " triệu đồng";
				}
				
				
				if(DIGIT_000_000 > 99999){
					digit_000_000 = DIGIT_000_000 / 100000;
					DIGIT_00_000 = DIGIT_000_000 % 100000;
					str_000_000 = dictionary[digit_000_000] + " trăm ";
				}
				
				if(DIGIT_00_000 > 9999){
					digit_00_000 = DIGIT_00_000 / 10000;
					DIGIT_0_000 = DIGIT_00_000 % 10000;
					str_00_000 = dictionary[digit_00_000] + " mươi ";
					if(DIGIT_0_000 == 0){
						str_00_000 = dictionary[digit_00_000] + " mươi ngàn ";
					}
				}
				
				if(DIGIT_0_000 > 999){
					digit_0_000 = DIGIT_0_000 / 1000;
					DIGIT_000 = DIGIT_0_000 % 1000;
					str_0_000 = dictionary[digit_0_000] + " ngàn ";
					if(DIGIT_0_000 == 0){
						str_0_000 = " ngàn";
					}
				}
				
				if(DIGIT_000 > 99){
					digit_000 = DIGIT_000 / 100;
					DIGIT_00 = DIGIT_000 % 100;
					str_000 = dictionary[digit_000] + " trăm ";
					if(DIGIT_000 == 0){
						str_000 = "";
					}
				}
				
				if(DIGIT_00 > 9){
					digit_00 = DIGIT_00 / 10;
					DIGIT_0 = DIGIT_00 % 10;
					str_00 = dictionary[digit_00] + " mươi ";
					if(DIGIT_00 == 0){
						str_00 = "";
					}
				}
				
				if(DIGIT_0 > 0){
					str_0 = dictionary[DIGIT_0] + " đồng ";
				}  
					
			}
			
		}
		
		if(!flag){
		
			if(input > 9999999){
				flag = true;
				digit_00_000_000 = (int) (input / 10000000);
				DIGIT_0_000_000 = (int) (input % 10000000);
				str_00_000_000 = dictionary[digit_00_000_000] + " mươi ";
				
				if(DIGIT_0_000_000 == 0){
					str_0_000_000 = "triệu đồng";
				}
				
				if(digit_00_000_000 == 1){
					str_00_000_000 = "mười ";
				}
				
				if(DIGIT_0_000_000 > 999999){
					digit_0_000_000 = DIGIT_0_000_000 / 1000000;
					DIGIT_000_000 = DIGIT_0_000_000 % 1000000;
					str_0_000_000 = dictionary[digit_0_000_000] + " triệu";
				}
				
				if(DIGIT_000_000 == 0){
					str_0_000_000 = dictionary[digit_0_000_000] + " triệu đồng";
				}
				
				
				if(DIGIT_000_000 > 99999){
					digit_000_000 = DIGIT_000_000 / 100000;
					DIGIT_00_000 = DIGIT_000_000 % 100000;
					str_000_000 = dictionary[digit_000_000] + " trăm ";
				}
				
				if(DIGIT_00_000 > 9999){
					digit_00_000 = DIGIT_00_000 / 10000;
					DIGIT_0_000 = DIGIT_00_000 % 10000;
					str_00_000 = dictionary[digit_00_000] + " mươi ";
					if(DIGIT_0_000 == 0){
						str_00_000 = dictionary[digit_00_000] + " mươi ngàn ";
					}
				}
				
				if(DIGIT_0_000 > 999){
					digit_0_000 = DIGIT_0_000 / 1000;
					DIGIT_000 = DIGIT_0_000 % 1000;
					str_0_000 = dictionary[digit_0_000] + " ngàn ";
					if(DIGIT_0_000 == 0){
						str_0_000 = " ngàn";
					}
				}
				
				if(DIGIT_000 > 99){
					digit_000 = DIGIT_000 / 100;
					DIGIT_00 = DIGIT_000 % 100;
					str_000 = dictionary[digit_000] + " trăm ";
					if(DIGIT_000 == 0){
						str_000 = "";
					}
				}
				
				if(DIGIT_00 > 9){
					digit_00 = DIGIT_00 / 10;
					DIGIT_0 = DIGIT_00 % 10;
					str_00 = dictionary[digit_00] + " mươi ";
					if(DIGIT_00 == 0){
						str_00 = "";
					}
				}
				
				if(DIGIT_0 > 0){
					str_0 = dictionary[DIGIT_0] + " đồng ";
				}  
			}	
		}
		
		if(!flag){
			
			if(input > 999999){
				flag = true;
				digit_0_000_000 = (int) (input / 1000000);
				DIGIT_000_000 = (int) (input % 1000000);
				str_0_000_000 = dictionary[digit_0_000_000] + " triệu ";
				
				if(DIGIT_000_000 == 0){
					str_0_000_000 = dictionary[digit_0_000_000] + " triệu đồng";
				}

				if(DIGIT_000_000 > 99999){
					digit_000_000 = DIGIT_000_000 / 100000;
					DIGIT_00_000 = DIGIT_000_000 % 100000;
					str_000_000 = dictionary[digit_000_000] + " trăm ";
				}
				

				if(DIGIT_00_000 == 0){
					str_000_000 = dictionary[digit_000_000] + " trăm ngàn đồng";
				}
				
				if(DIGIT_00_000 > 9999){
					digit_00_000 = DIGIT_00_000 / 10000;
					DIGIT_0_000 = DIGIT_00_000 % 10000;
					str_00_000 = dictionary[digit_00_000] + " mươi ";
					if(DIGIT_0_000 == 0){
						str_00_000 = dictionary[digit_00_000] + " mươi ngàn ";
					}
				}
				
				if(DIGIT_000_000 == 0 && DIGIT_00_000 == 0){
					str_000_000 = "";
				}
				
				if(DIGIT_0_000 > 999){
					digit_0_000 = DIGIT_0_000 / 1000;
					DIGIT_000 = DIGIT_0_000 % 1000;
					str_0_000 = dictionary[digit_0_000] + " ngàn ";
					if(DIGIT_0_000 == 0){
						str_0_000 = " ngàn";
					}
				}
				
				if(DIGIT_000 > 99){
					digit_000 = DIGIT_000 / 100;
					DIGIT_00 = DIGIT_000 % 100;
					str_000 = dictionary[digit_000] + " trăm ";
					if(DIGIT_000 == 0){
						str_000 = "";
					}
				}
				
				if(DIGIT_00 > 9){
					digit_00 = DIGIT_00 / 10;
					DIGIT_0 = DIGIT_00 % 10;
					str_00 = dictionary[digit_00] + " mươi ";
					if(DIGIT_00 == 0){
						str_00 = "";
					}
				}
				
				if(DIGIT_0 > 0){
					str_0 = dictionary[DIGIT_0] + " đồng ";
				}  
			}
		}
		

		if(!flag){
		// 150000
			if(input > 99999){
				flag = true;
				digit_000_000 = (int) (input / 100000);
				DIGIT_00_000 = (int) (input % 100000);
				str_000_000 = dictionary[digit_000_000] + " trăm ";
				
				if(DIGIT_00_000 == 0){
					str_000_000 = dictionary[digit_000_000] + " trăm ngàn";
				}
				
				if(DIGIT_00_000 > 9999){
					digit_00_000 = DIGIT_00_000 / 10000;
					DIGIT_0_000 = DIGIT_00_000 % 10000;
					str_00_000 = dictionary[digit_00_000] + " mươi ";
					if(DIGIT_0_000 == 0){
						str_00_000 = dictionary[digit_00_000] + " mươi ngàn ";
					}
				}
				
				if(DIGIT_0_000 > 999){
					digit_0_000 = DIGIT_0_000 / 1000;
					DIGIT_000 = DIGIT_0_000 % 1000;
					str_0_000 = dictionary[digit_0_000] + " ngàn ";
					if(DIGIT_0_000 == 0){
						str_0_000 = " ngàn";
					}
				}
				
				if(DIGIT_000 > 99){
					digit_000 = DIGIT_000 / 100;
					DIGIT_00 = DIGIT_000 % 100;
					str_000 = dictionary[digit_000] + " trăm ";
					if(DIGIT_000 == 0){
						str_000 = "";
					}
				}
				
				if(DIGIT_00 > 9){
					digit_00 = DIGIT_00 / 10;
					DIGIT_0 = DIGIT_00 % 10;
					str_00 = dictionary[digit_00] + " mươi ";
					if(DIGIT_00 == 0){
						str_00 = "";
					}
				}
				
				if(DIGIT_0 > 0){
					str_0 = dictionary[DIGIT_0] + " đồng ";
				}  
			}
		}
		
		result = str_000_000_000 + str_00_000_000 + str_0_000_000
				+ str_000_000 + str_00_000+ str_0_000
				+ str_000+ str_00+ str_0;
		
		
		return result;
}

	
}
