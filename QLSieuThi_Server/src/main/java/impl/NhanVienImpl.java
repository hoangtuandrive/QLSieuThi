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
import dao.NhanVienDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import util.MyEmFactory;

public class NhanVienImpl extends UnicastRemoteObject implements NhanVienDao {

	private static final long serialVersionUID = 6858116339844383030L;
	// private static final long serialVersionUID = -1731791771568468903L;
	private EntityManager em;

	public NhanVienImpl() throws RemoteException {
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
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateNV(NhanVien nv) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(nv);
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
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	@Override
	public List<NhanVien> getTatCaNhanVienKhiAdd() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public boolean setNullTK(NhanVien nv) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "update NhanVien set taiKhoan=null where maNV=?1";
			em.createNativeQuery(sql).setParameter(1, nv.getMaNV()).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public SortedSet<String> getTatCaMaNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getMaNV()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaTenNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getTenNV()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Boolean> getTatCaGioiTinhNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			List<Boolean> listBool = new ArrayList<>();
			list.forEach((obj) -> listBool.add(obj.getGioiTinh()));
			SortedSet<Boolean> uniqueList = new TreeSet<Boolean>(listBool);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaSDTNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
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
	public SortedSet<String> getTatCaChucVuNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getChucVu()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Double> getTatCaLuongNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			List<Double> listDouble = new ArrayList<>();
			list.forEach((obj) -> listDouble.add(obj.getLuong()));
			SortedSet<Double> uniqueList = new TreeSet<Double>(listDouble);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaCMNDNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
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
	public SortedSet<Date> getTatCaNgaySinhNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
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
	public SortedSet<String> getTatCaDiaChiNhanVien() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<NhanVien> list=new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
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
	public SortedSet<String> getTatCaEmailNhanVien() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<NhanVien> list=new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
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

	@Override
	public SortedSet<Boolean> getTatCaTrangThaiNhanVien() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<NhanVien> list=new ArrayList<NhanVien>();
		try {
			tr.begin();
			String sql = "select * from NhanVien";
			em.clear();
			list = em.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			List<Boolean> listBool = new ArrayList<>();
			list.forEach((obj) -> listBool.add(obj.getTrangThai()));
			SortedSet<Boolean> uniqueList = new TreeSet<Boolean>(listBool);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

}
