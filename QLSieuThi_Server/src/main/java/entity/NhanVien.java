package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8452382776766015338L;
	@Id
	@Column(columnDefinition = "nvarchar(20)")
	private String maNV;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenNV;
	private Boolean gioiTinh;
	@Column(columnDefinition = "nchar(10)")
	private String SDT;
	@Column(columnDefinition = "nchar(30)")
	private String chucVu;
	private double luong;
	@Column(columnDefinition = "nchar(50)")
	private String CMND;
	private Date ngaySinh;
	@Column(columnDefinition = "nchar(50)")
	private String diaChi;
	@Column(columnDefinition = "nchar(50)")
	private String email;
	private Boolean trangThai;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "maNV")
	private List<HoaDon> dshd;
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
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

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV.trim() + ", tenNV=" + tenNV.trim() + ", gioiTinh=" + gioiTinh + ", SDT=" + SDT.trim() + ", chucVu="
				+ chucVu.trim() + ", luong=" + luong + ", CMND=" + CMND.trim() + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi.trim()
				+ ", email=" + email.trim() + ", trangThai=" + trangThai + ", taiKhoan + [userName= " + taiKhoan.getTenDN().trim() + "password= " + taiKhoan.getMatKhau().trim() + "]";
	}

	


	
	

	public NhanVien(String maNV, String tenNV, Boolean gioiTinh, String sDT, String chucVu, double luong, String cMND,
			Date ngaySinh, String diaChi, String email, Boolean trangThai, TaiKhoan taiKhoan) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		SDT = sDT;
		this.chucVu = chucVu;
		this.luong = luong;
		CMND = cMND;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.trangThai = trangThai;
		this.taiKhoan = taiKhoan;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
