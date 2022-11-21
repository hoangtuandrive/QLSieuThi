package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class HoaDon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5308517803703136616L;
	@Id
	@Column(columnDefinition = "nchar(20)", name="maHD", nullable=false)
	private String maHD;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maNV")
	private NhanVien maNV;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maKH")
	private KhachHang maKH;
	private Date ngayLapHoaDon;
	@Column(name = "tongTienThanhToan",columnDefinition = "money")
	private double tongTien;
	
	@OneToMany(mappedBy = "maHoaDon")
	private List<ChiTietHoaDon> cthd;

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public List<ChiTietHoaDon> getCthd() {
		return cthd;
	}

	public void setCthd(List<ChiTietHoaDon> cthd) {
		this.cthd = cthd;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maNV=" + maNV + ", maKH=" + maKH + ", ngayLapHoaDon=" + ngayLapHoaDon
				+ ", tongTien=" + tongTien + ", cthd=" + cthd + "]";
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double tinhTongTien() {
		double tongTien = 0;
		for (ChiTietHoaDon ct : cthd) {
			tongTien += ct.getThanhTien();
		}
		return tongTien;
	}
	
	public HoaDon(String maHD, NhanVien maNV, KhachHang maKH, Date ngayLapHoaDon) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	
	public HoaDon(String maHD, NhanVien maNV, KhachHang maKH, Date ngayLapHoaDon, List<ChiTietHoaDon> chiTietHoaDon) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.cthd = chiTietHoaDon;
		this.tongTien = tinhTongTien();
	}
	
	public HoaDon(String maHD) {
		this.maHD = maHD;
	}
	
	public HoaDon(String maHD, KhachHang maKH) {
		this.maHD = maHD;
		this.maKH = maKH;
	}
	public HoaDon(String maHD, Date ngayLapHoaDon, double tongTien) {
		super();
		this.maHD = maHD;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tongTien = tongTien;
	}
}
