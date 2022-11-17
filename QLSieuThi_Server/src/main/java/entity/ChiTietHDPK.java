package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
public class ChiTietHDPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8841167962151832842L;
	private String maHoaDon;
	private String maSP;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
		result = prime * result + ((maSP == null) ? 0 : maSP.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHDPK other = (ChiTietHDPK) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		if (maSP == null) {
			if (other.maSP != null)
				return false;
		} else if (!maSP.equals(other.maSP))
			return false;
		return true;
	}
	
	public ChiTietHDPK() {
	}
	
	
}
