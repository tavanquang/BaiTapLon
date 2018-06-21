package com.demo.dao.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_phieu_de_xuat database table.
 * 
 */
@Entity
@Table(name="tbl_phieu_de_xuat")
@NamedQuery(name="TblPhieuDeXuat.findAll", query="SELECT t FROM TblPhieuDeXuat t")
public class TblPhieuDeXuat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="de_xuat_ngay_mua")
	private Date deXuatNgayMua;

	@Column(name="giam_doc")
	private String giamDoc;

	@Column(name="kinh_gui")
	private String kinhGui;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_bat_dau")
	private Date ngayBatDau;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_de_xuat")
	private Date ngayDeXuat;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_hoan_thanh")
	private Date ngayHoanThanh;

	@Column(name="nguoi_de_nghi")
	private String nguoiDeNghi;

	@Column(name="nguoi_ke_toan")
	private String nguoiKeToan;

	@Column(name="noi_dung_de_xuat")
	private String noiDungDeXuat;

	@Column(name="tong_tien")
	private double tongTien;

	@Column(name="trang_thai")
	private int trangThai;

	@Lob
	@Column(name="y_kien_lanh_dao")
	private String yKienLanhDao;

	//bi-directional many-to-one association to TblNoiDungDeXuat
	@OneToMany(mappedBy="tblPhieuDeXuat")
	private List<TblNoiDungDeXuat> tblNoiDungDeXuats;
	
	
	
	

	public TblPhieuDeXuat() {
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

	public List<TblNoiDungDeXuat> getTblNoiDungDeXuats() {
		return this.tblNoiDungDeXuats;
	}

	public void setTblNoiDungDeXuats(List<TblNoiDungDeXuat> tblNoiDungDeXuats) {
		this.tblNoiDungDeXuats = tblNoiDungDeXuats;
	}

	public TblNoiDungDeXuat addTblNoiDungDeXuat(TblNoiDungDeXuat tblNoiDungDeXuat) {
		getTblNoiDungDeXuats().add(tblNoiDungDeXuat);
		tblNoiDungDeXuat.setTblPhieuDeXuat(this);

		return tblNoiDungDeXuat;
	}

	public TblNoiDungDeXuat removeTblNoiDungDeXuat(TblNoiDungDeXuat tblNoiDungDeXuat) {
		getTblNoiDungDeXuats().remove(tblNoiDungDeXuat);
		tblNoiDungDeXuat.setTblPhieuDeXuat(null);

		return tblNoiDungDeXuat;
	}

	@Override
	public String toString() {
		return "TblPhieuDeXuat [id=" + id + ", deXuatNgayMua=" + deXuatNgayMua + ", giamDoc=" + giamDoc + ", kinhGui="
				+ kinhGui + ", ngayBatDau=" + ngayBatDau + ", ngayDeXuat=" + ngayDeXuat + ", ngayHoanThanh="
				+ ngayHoanThanh + ", nguoiDeNghi=" + nguoiDeNghi + ", nguoiKeToan=" + nguoiKeToan + ", noiDungDeXuat="
				+ noiDungDeXuat + ", tongTien=" + tongTien + ", trangThai=" + trangThai + ", yKienLanhDao="
				+ yKienLanhDao + ", tblNoiDungDeXuats=" + tblNoiDungDeXuats + "]";
	}
	

}