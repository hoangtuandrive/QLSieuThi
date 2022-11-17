package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


@Entity
public class TaiKhoan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7299490460395928304L;
	@Id

	private String tenDN;
	@OneToOne
	@MapsId
	@JoinColumn(name = "tenDN", columnDefinition = "nchar(20)")
	private NhanVien maNV;
	@Column(columnDefinition = "nchar(30)")
	private String matKhau;

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenDN=" + tenDN + ", maNV=" + maNV + ", matKhau=" + matKhau + "]";
	}

	public TaiKhoan(String tenDN, String matKhau) {
		super();
		this.tenDN = tenDN;
		this.matKhau = matKhau;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

}
