package impI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.KhachHangDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import util.MyEmFactory;

public class KhachHangImpI extends UnicastRemoteObject implements KhachHangDao {
	private EntityManager em;
	public KhachHangImpI() throws RemoteException {
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<KhachHang> getTatCaKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			em.clear();
			String sql = "select * from KhachHang";
			list=em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean create(KhachHang kh) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(kh);
			
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
	public boolean update(KhachHang kh) throws RemoteException {
		
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();			
			em.merge(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}



}
