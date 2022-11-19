package impI_Tuan;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;

import util.MyEmFactory;

public class TaiKhoanImpI extends UnicastRemoteObject implements TaiKhoanDao{
	private EntityManager em;
	public TaiKhoanImpI() throws RemoteException{
		em= MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();		
	}

	@Override
	public boolean Delete(String id) throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			String sql="delete TaiKhoan where tenDN = '"+id+"'";
			em.createNativeQuery(sql).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
	@Override
	public List<TaiKhoan> GetAllTaiKhoan() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<TaiKhoan> list=new ArrayList<TaiKhoan>();
		try {
			tr.begin();
			String sql = "select * from TaiKhoan";
			em.clear();
			list=em.createNativeQuery(sql, TaiKhoan.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
