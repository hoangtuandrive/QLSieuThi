package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;


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
	@JoinColumn(name = "tenDN", columnDefinition = "nvarchar(20)")
	private NhanVien maNV;
	@Column(columnDefinition = "nvarchar(30)")
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
