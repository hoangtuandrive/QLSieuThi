package entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@IdClass(ChiTietHDPK.class)
public class ChiTietHoaDon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2663768720982157146L;
	@Id
	@ManyToOne
	@JoinColumn(name = "maHD",columnDefinition = "nchar(20)")
	private HoaDon maHoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name = "maSP",columnDefinition = "nchar(20)")
	private SanPham maSP;
	private int soLuong;
	private double giaTien;
	@Column(columnDefinition = "money")
	private double thanhTien;
	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public SanPham getMaSP() {
		return maSP;
	}
	public void setMaSP(SanPham maSP) {
		this.maSP = maSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maSP=" + maSP + ", soLuong=" + soLuong + ", giaTien="
				+ giaTien + ", thanhTien=" + thanhTien + "]";
	}
	public ChiTietHoaDon(HoaDon maHoaDon, SanPham maSP, int soLuong, double giaTien, double thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.giaTien = giaTien;
		this.thanhTien = thanhTien;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
