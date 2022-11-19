package impI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.NhanVienDao;
import dao.SanPhamDao;
import entity.NhanVien;
import entity.SanPham;
import entity.TaiKhoan;
import util.MyEmFactory;

public class SanPhamImpI extends UnicastRemoteObject implements SanPhamDao{
	private EntityManager em;
	public SanPhamImpI() throws RemoteException {
		super();
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<SanPham> getTatCaSanPham() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<SanPham> list=new ArrayList<SanPham>();
		try {
			tr.begin();
			String sql = "select * from SanPham";
			em.clear();
			list=em.createNativeQuery(sql, SanPham.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	
	@Override
	public boolean create(SanPham sp) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(sp);
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
	public boolean delete(SanPham sp) throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			String sql="delete SanPham where maSP = '"+sp.getMaSP()+"'";
			em.createNativeQuery(sql).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public boolean update(SanPham sp) throws RemoteException {
		
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.merge(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

}
