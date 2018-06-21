package com.demo.repository;

public class TblNoiDungDeXuatDTO {

	private int id;

	private double donGia;

	private String ghiChu;

	private String noiDungDeXuat;

	private int soLuong;

	private int soNgay;

	private double thanhTien;
	
	private String thanhTienFormat;
	
	private int idPhieuDeXuat;

	public String getThanhTienFormat() {
		return thanhTienFormat;
	}

	public void setThanhTienFormat(String thanhTienFormat) {
		this.thanhTienFormat = thanhTienFormat;
	}



	public int getIdPhieuDeXuat() {
		return idPhieuDeXuat;
	}

	public void setIdPhieuDeXuat(int idPhieuDeXuat) {
		this.idPhieuDeXuat = idPhieuDeXuat;
	}

	public TblNoiDungDeXuatDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDonGia() {
		return this.donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getNoiDungDeXuat() {
		return this.noiDungDeXuat;
	}

	public void setNoiDungDeXuat(String noiDungDeXuat) {
		this.noiDungDeXuat = noiDungDeXuat;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getSoNgay() {
		return this.soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	public double getThanhTien() {
		return this.thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "TblNoiDungDeXuatDTO [id=" + id + ", donGia=" + donGia + ", ghiChu=" + ghiChu + ", noiDungDeXuat="
				+ noiDungDeXuat + ", soLuong=" + soLuong + ", soNgay=" + soNgay + ", thanhTien=" + thanhTien
				+ ", thanhTienFormat=" + thanhTienFormat + ", idPhieuDeXuat=" + idPhieuDeXuat + "]";
	}
	
	

}