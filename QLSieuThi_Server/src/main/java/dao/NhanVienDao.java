package dao;

import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import util.MyEmFactory;

public class NhanVienDao {
	private EntityManager em;

	public NhanVienDao() {
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();

	}

	public boolean addNhanVien(NhanVien nv) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(nv);
			TaiKhoan tk = nv.getTaiKhoan();
			em.persist(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			// TODO: handle exception
		}
		return false;
	}

	public NhanVien getNhanVienById(String ma) {
		return em.createQuery("select nv from NhanVien nv where nv.maNV = :x", NhanVien.class).setParameter("x", ma)
				.getSingleResult();
	}

}
