package dao;


import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.MyEmFactory;

public class TaiKhoanDao {
	private EntityManager em;
	public TaiKhoanDao() {
		em= MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();		
	}
}
