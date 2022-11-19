package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.KhachHangDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import entity.TaiKhoan;
import util.MyEmFactory;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangDao {
	private EntityManager em;
	public KhachHangImpl() throws RemoteException {
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
			tr.rollback();
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
			tr.rollback();
		}		
		return false;
	}

	@Override
	public boolean huyGioHang(String sdt, boolean gioHang) throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			String sql="update KhachHang set gioHang=?2 where SDT=?1";
			em.createNativeQuery(sql).setParameter(1, sdt).setParameter(2, gioHang).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return false;
	}

	@Override
	public SortedSet<String> getTatCaSDTKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getSDT()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public boolean updateGioHang(KhachHang kh) throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			String sql="update KhachHang set gioHang=?1 where maKH = ?2";
			em.createNativeQuery(sql).setParameter(1, kh.isGioHang()).setParameter(2, kh.getMaKH()).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return false;
	}

	@Override
	public SortedSet<String> getTatCaMaKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getMaKH()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaTenKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getTenKH()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Boolean> getTatCaGioiTinhKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<Boolean> listBool = new ArrayList<>();
			list.forEach((obj) -> listBool.add(obj.isGioiTinh()));
			SortedSet<Boolean> uniqueList = new TreeSet<Boolean>(listBool);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaSDTKhachHangCMB() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getSDT()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaCMNDKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getCMND()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Date> getTatCaNgaySinhKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<Date> listDate = new ArrayList<>();
			list.forEach((obj) -> listDate.add(obj.getNgaySinh()));
			SortedSet<Date> uniqueList = new TreeSet<Date>(listDate);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaDiaChiKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getDiaChi()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaEmailKhachHang() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<KhachHang> list=new ArrayList<KhachHang>();
		try {
			tr.begin();
			String sql = "select * from KhachHang";
			em.clear();
			list = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getEmail()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}



}
