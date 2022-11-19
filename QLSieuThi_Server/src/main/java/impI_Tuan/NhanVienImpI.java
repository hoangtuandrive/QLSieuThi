package impI_Tuan;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import dao.NhanVienDao;
import entity.NhanVien;
import entity.TaiKhoan;
import util.MyEmFactory;

public class NhanVienImpI extends UnicastRemoteObject implements NhanVienDao {

	private static final long serialVersionUID = 6858116339844383030L;
	// private static final long serialVersionUID = -1731791771568468903L;
	private EntityManager em;

	public NhanVienImpI() throws RemoteException {
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();

	}

	@Override
	public boolean addNhanVien(NhanVien nv) throws RemoteException {
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

	@Override
	public NhanVien getNhanVienById(String ma) throws RemoteException {
		em.clear();
		return em.createQuery("select nv from NhanVien nv where nv.maNV = :x", NhanVien.class).setParameter("x", ma)
				.getSingleResult();
	}

	@Override
	public boolean delete(String id) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "update NhanVien set trangThai = 0 where maNV = '" + id + "'";
			em.createNativeQuery(sql).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateNV(NhanVien nv) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			// nv.setTaiKhoan(em.find(NhanVien.class, nv.getMaNV()).getTaiKhoan());
			em.merge(nv);

			// NhanVien nv1 = em.find(NhanVien.class, nv.getMaNV());
			// nv1.setTenNV(nv.getTenNV());

			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<NhanVien> getTatCaNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			em.clear();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
