package com.demo.repository;

import java.util.Date;
import java.util.List;

public class TblPhieuDeXuatDTO {

	private int id;

	private Date deXuatNgayMua;

	private String giamDoc;

	private String kinhGui;

	private Date ngayBatDau;

	private Date ngayDeXuat;

	private Date ngayHoanThanh;

	private String nguoiDeNghi;

	private String nguoiKeToan;

	private String noiDungDeXuat;

	private double tongTien;
	
	private String tongTienFormat;

	public String getTongTienFormat() {
		return tongTienFormat;
	}

	public void setTongTienFormat(String tongTienFormat) {
		this.tongTienFormat = tongTienFormat;
	}

	public String getyKienLanhDao() {
		return yKienLanhDao;
	}

	public void setyKienLanhDao(String yKienLanhDao) {
		this.yKienLanhDao = yKienLanhDao;
	}

	private int trangThai;

	private String yKienLanhDao;

	private List<TblNoiDungDeXuatDTO> tblNoiDungDeXuats;

	public TblPhieuDeXuatDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDeXuatNgayMua() {
		return this.deXuatNgayMua;
	}

	public void setDeXuatNgayMua(Date deXuatNgayMua) {
		this.deXuatNgayMua = deXuatNgayMua;
	}


	public String getGiamDoc() {
		return this.giamDoc;
	}

	public void setGiamDoc(String giamDoc) {
		this.giamDoc = giamDoc;
	}

	public String getKinhGui() {
		return this.kinhGui;
	}

	public void setKinhGui(String kinhGui) {
		this.kinhGui = kinhGui;
	}

	public Date getNgayBatDau() {
		return this.ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayDeXuat() {
		return this.ngayDeXuat;
	}

	public void setNgayDeXuat(Date ngayDeXuat) {
		this.ngayDeXuat = ngayDeXuat;
	}

	public Date getNgayHoanThanh() {
		return this.ngayHoanThanh;
	}

	public void setNgayHoanThanh(Date ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public String getNguoiDeNghi() {
		return this.nguoiDeNghi;
	}

	public void setNguoiDeNghi(String nguoiDeNghi) {
		this.nguoiDeNghi = nguoiDeNghi;
	}

	public String getNguoiKeToan() {
		return this.nguoiKeToan;
	}

	public void setNguoiKeToan(String nguoiKeToan) {
		this.nguoiKeToan = nguoiKeToan;
	}

	public String getNoiDungDeXuat() {
		return this.noiDungDeXuat;
	}

	public void setNoiDungDeXuat(String noiDungDeXuat) {
		this.noiDungDeXuat = noiDungDeXuat;
	}

	public double getTongTien() {
		return this.tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getYKienLanhDao() {
		return this.yKienLanhDao;
	}

	public void setYKienLanhDao(String yKienLanhDao) {
		this.yKienLanhDao = yKienLanhDao;
	}

	public List<TblNoiDungDeXuatDTO> getTblNoiDungDeXuats() {
		return this.tblNoiDungDeXuats;
	}

	public void setTblNoiDungDeXuats(List<TblNoiDungDeXuatDTO> tblNoiDungDeXuats) {
		this.tblNoiDungDeXuats = tblNoiDungDeXuats;
	}

}