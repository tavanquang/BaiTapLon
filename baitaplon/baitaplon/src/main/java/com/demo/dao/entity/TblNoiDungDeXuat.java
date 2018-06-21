package com.demo.dao.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_noi_dung_de_xuat database table.
 * 
 */
@Entity
@Table(name="tbl_noi_dung_de_xuat")
@NamedQuery(name="TblNoiDungDeXuat.findAll", query="SELECT t FROM TblNoiDungDeXuat t")
public class TblNoiDungDeXuat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="don_gia")
	private double donGia;

	@Column(name="ghi_chu")
	private String ghiChu;

	@Lob
	@Column(name="noi_dung_de_xuat")
	private String noiDungDeXuat;

	@Column(name="so_luong")
	private int soLuong;

	@Column(name="so_ngay")
	private int soNgay;

	@Column(name="thanh_tien")
	private double thanhTien;

	//bi-directional many-to-one association to TblPhieuDeXuat
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_phieu_de_xuat")
	private TblPhieuDeXuat tblPhieuDeXuat;

	public TblNoiDungDeXuat() {
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

	public TblPhieuDeXuat getTblPhieuDeXuat() {
		return this.tblPhieuDeXuat;
	}

	public void setTblPhieuDeXuat(TblPhieuDeXuat tblPhieuDeXuat) {
		this.tblPhieuDeXuat = tblPhieuDeXuat;
	}

}