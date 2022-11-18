package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6118684023998305124L;
	@Id
	@Column(columnDefinition = "nchar(30)")
	private String maKH;
	@Column(columnDefinition = "nchar(100)")
	private String tenKH;
	private boolean gioiTinh;
	@Column(columnDefinition = "nchar(10)")
	private String SDT;
	@Column(columnDefinition = "nchar(50)")
	private String CMND;
	private Date ngaySinh;
	@Column(columnDefinition = "nchar(100)")
	private String diaChi;
	@Column(columnDefinition = "nchar(100)")
	private String email;
	private boolean gioHang;
	
	@OneToMany(mappedBy = "maKH")
	private List<HoaDon> dshd;

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGioHang() {
		return gioHang;
	}

	public void setGioHang(boolean gioHang) {
		this.gioHang = gioHang;
	}

	public List<HoaDon> getDshd() {
		return dshd;
	}

	public void setDshd(List<HoaDon> dshd) {
		this.dshd = dshd;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", SDT=" + SDT + ", CMND="
				+ CMND + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", email=" + email + ", gioHang=" + gioHang
				+ ", dshd=" + dshd + "]";
	}

	

	public KhachHang(String maKH, String tenKH, boolean gioiTinh, String sDT, String cMND, Date ngaySinh, String diaChi,
			String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		SDT = sDT;
		CMND = cMND;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
	}

	public KhachHang(String maKH, String tenKH ,String sDT) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		SDT = sDT;
	}
	
	public KhachHang(String maKH, String sDT) {
		super();
		this.maKH = maKH;
		SDT = sDT;
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
