package com.demo.repository;

import java.util.Date;

public class TblPhieuChiDTO{

	private int id;

	private String diaChi;

	private String giamDoc;

	private String hinhAnh;

	private String lyDoChi;

	private Date ngayLapPhieu;

	private String nguoiLapPhieu;

	private String nguoiNhanTien;

	private double soTien;
	
	private String soTienFormat;
	
	private int trangThai;


	public TblPhieuChiDTO() {
	}
	
	public String getSoTienFormat() {
		return soTienFormat;
	}

	public void setSoTienFormat(String soTienFormat) {
		this.soTienFormat = soTienFormat;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGiamDoc() {
		return this.giamDoc;
	}

	public void setGiamDoc(String giamDoc) {
		this.giamDoc = giamDoc;
	}

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getLyDoChi() {
		return this.lyDoChi;
	}

	public void setLyDoChi(String lyDoChi) {
		this.lyDoChi = lyDoChi;
	}

	public Date getNgayLapPhieu() {
		return this.ngayLapPhieu;
	}

	public void setNgayLapPhieu(Date ngayLapPhieu) {
		this.ngayLapPhieu = ngayLapPhieu;
	}

	public String getNguoiLapPhieu() {
		return this.nguoiLapPhieu;
	}

	public void setNguoiLapPhieu(String nguoiLapPhieu) {
		this.nguoiLapPhieu = nguoiLapPhieu;
	}

	public String getNguoiNhanTien() {
		return this.nguoiNhanTien;
	}

	public void setNguoiNhanTien(String nguoiNhanTien) {
		this.nguoiNhanTien = nguoiNhanTien;
	}

	public double getSoTien() {
		return this.soTien;
	}

	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}