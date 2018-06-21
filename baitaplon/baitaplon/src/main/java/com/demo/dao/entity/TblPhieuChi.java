package com.demo.dao.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_phieu_chi database table.
 * 
 */
@Entity
@Table(name="tbl_phieu_chi")
@NamedQuery(name="TblPhieuChi.findAll", query="SELECT t FROM TblPhieuChi t")
public class TblPhieuChi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="dia_chi")
	private String diaChi;

	@Column(name="giam_doc")
	private String giamDoc;

	@Column(name="hinh_anh")
	private String hinhAnh;

	@Lob
	@Column(name="ly_do_chi")
	private String lyDoChi;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_lap_phieu")
	private Date ngayLapPhieu;

	@Column(name="nguoi_lap_phieu")
	private String nguoiLapPhieu;

	@Column(name="nguoi_nhan_tien")
	private String nguoiNhanTien;

	@Column(name="so_tien")
	private double soTien;

	@Column(name="trang_thai")
	private int trangThai;

	public TblPhieuChi() {
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