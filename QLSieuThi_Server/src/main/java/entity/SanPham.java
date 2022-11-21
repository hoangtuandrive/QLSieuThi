package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class SanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2549705138957681271L;
	@Id
	@Column(columnDefinition = "nchar(20)")
	private String maSP;
	@Column(columnDefinition = "nchar(100)")
	private String tenSP;
	@Column(columnDefinition = "nchar(100)")
	private String loaiHang;
	@Column(columnDefinition = "nchar(100)")
	private String nhaCungCap;
	@Column(columnDefinition = "money")
	private double donGia;
	private int soLuong;

	@OneToMany(mappedBy = "maSP")
	private List<ChiTietHoaDon> cthd;

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getLoaiHang() {
		return loaiHang;
	}

	public void setLoaiHang(String loaiHang) {
		this.loaiHang = loaiHang;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public List<ChiTietHoaDon> getCthd() {
		return cthd;
	}

	public void setCthd(List<ChiTietHoaDon> cthd) {
		this.cthd = cthd;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", loaiHang=" + loaiHang + ", nhaCungCap=" + nhaCungCap
				+ ", donGia=" + donGia + ", soLuong=" + soLuong + "]";
	}

	public SanPham(String maSP, String tenSP, String loaiHang, String nhaCungCap, double donGia, int soLuong) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loaiHang = loaiHang;
		this.nhaCungCap = nhaCungCap;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	
	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
