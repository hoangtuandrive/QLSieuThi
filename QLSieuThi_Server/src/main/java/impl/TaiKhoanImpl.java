package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.SanPham;
import entity.TaiKhoan;

import util.MyEmFactory;

public class TaiKhoanImpl extends UnicastRemoteObject implements TaiKhoanDao {
	private EntityManager em;

	public TaiKhoanImpl() throws RemoteException {
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public boolean delete(String id) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "delete TaiKhoan where tenDN = '" + id + "'";
			em.createNativeQuery(sql).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<TaiKhoan> getAllTaiKhoan() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			tr.begin();
			String sql = "select * from TaiKhoan";
			em.clear();
			list = em.createNativeQuery(sql, TaiKhoan.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public boolean create(TaiKhoan tk) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateDoiMatKhau(TaiKhoan taikhoan, String matKhauMoi) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "update TaiKhoan set matKhau=?2 where taiKhoan=?1";
			em.createNativeQuery(sql).setParameter(1, taikhoan.getTenDN()).setParameter(2, matKhauMoi).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateTenDangNhap(TaiKhoan taikhoan, String tenMoi) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "update TaiKhoan set tenDN=?1 where tenDN=?2";
			em.createNativeQuery(sql).setParameter(1, tenMoi).setParameter(2, taikhoan.getTenDN()).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
}
