package com.demo.repository;

import java.util.ArrayList;
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
	private int trangThai;

	private String yKienLanhDao;
	private String tongTienFormat;
	
	
	public List<TblNoiDungDeXuatDTO> tblNoiDungDeXuat;
	
	
	
	public TblPhieuDeXuatDTO() {
		tblNoiDungDeXuat = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDeXuatNgayMua() {
		return deXuatNgayMua;
	}
	public void setDeXuatNgayMua(Date deXuatNgayMua) {
		this.deXuatNgayMua = deXuatNgayMua;
	}
	public String getGiamDoc() {
		return giamDoc;
	}
	public void setGiamDoc(String giamDoc) {
		this.giamDoc = giamDoc;
	}
	public String getKinhGui() {
		return kinhGui;
	}
	public void setKinhGui(String kinhGui) {
		this.kinhGui = kinhGui;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayDeXuat() {
		return ngayDeXuat;
	}
	public void setNgayDeXuat(Date ngayDeXuat) {
		this.ngayDeXuat = ngayDeXuat;
	}
	public Date getNgayHoanThanh() {
		return ngayHoanThanh;
	}
	public void setNgayHoanThanh(Date ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}
	public String getNguoiDeNghi() {
		return nguoiDeNghi;
	}
	public void setNguoiDeNghi(String nguoiDeNghi) {
		this.nguoiDeNghi = nguoiDeNghi;
	}
	public String getNguoiKeToan() {
		return nguoiKeToan;
	}
	public void setNguoiKeToan(String nguoiKeToan) {
		this.nguoiKeToan = nguoiKeToan;
	}
	public String getNoiDungDeXuat() {
		return noiDungDeXuat;
	}
	public void setNoiDungDeXuat(String noiDungDeXuat) {
		this.noiDungDeXuat = noiDungDeXuat;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getyKienLanhDao() {
		return yKienLanhDao;
	}
	public void setyKienLanhDao(String yKienLanhDao) {
		this.yKienLanhDao = yKienLanhDao;
	}
	public String getTongTienFormat() {
		return tongTienFormat;
	}
	public void setTongTienFormat(String tongTienFormat) {
		this.tongTienFormat = tongTienFormat;
	}
	public List<TblNoiDungDeXuatDTO> getTblNoiDungDeXuat() {
		return tblNoiDungDeXuat;
	}
	public void setTblNoiDungDeXuat(List<TblNoiDungDeXuatDTO> tblNoiDungDeXuat) {
		this.tblNoiDungDeXuat = tblNoiDungDeXuat;
	}
	@Override
	public String toString() {
		return "TblPhieuDeXuatDTO [id=" + id + ", deXuatNgayMua=" + deXuatNgayMua + ", giamDoc=" + giamDoc
				+ ", kinhGui=" + kinhGui + ", ngayBatDau=" + ngayBatDau + ", ngayDeXuat=" + ngayDeXuat
				+ ", ngayHoanThanh=" + ngayHoanThanh + ", nguoiDeNghi=" + nguoiDeNghi + ", nguoiKeToan=" + nguoiKeToan
				+ ", noiDungDeXuat=" + noiDungDeXuat + ", tongTien=" + tongTien + ", trangThai=" + trangThai
				+ ", yKienLanhDao=" + yKienLanhDao + ", tongTienFormat=" + tongTienFormat + "]";
	}
	
	
	

	

}