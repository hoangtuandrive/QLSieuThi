package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import org.hibernate.annotations.QueryHints;

import dao.NhanVienDao;
import dao.SanPhamDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import entity.TaiKhoan;

import util.MyEmFactory;

public class SanPhamImpl extends UnicastRemoteObject implements SanPhamDao{
	private EntityManager em;
	public SanPhamImpl() throws RemoteException {
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
			tr.rollback();
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
			tr.rollback();
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
			tr.rollback();
		}		
		return false;
	}

	@Override
	public SortedSet<String> getTatCaMaSanPham() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<SanPham> list=new ArrayList<SanPham>();
		try {
			tr.begin();
			String sql = "select * from SanPham";
			em.clear();
			list = em.createNativeQuery(sql, SanPham.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getMaSP()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaTenSanPham() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<SanPham> list=new ArrayList<SanPham>();
		try {
			tr.begin();
			String sql = "select * from SanPham";
			em.clear();
			list = em.createNativeQuery(sql, SanPham.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getTenSP()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaNhaCungCapSanPham() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<SanPham> list=new ArrayList<SanPham>();
		try {
			tr.begin();
			String sql = "select * from SanPham";
			em.clear();
			list = em.createNativeQuery(sql, SanPham.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getNhaCungCap()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaLoaiHangSanPham() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<SanPham> list=new ArrayList<SanPham>();
		try {
			tr.begin();
			String sql = "select * from SanPham";
			em.clear();
			list = em.createNativeQuery(sql, SanPham.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getLoaiHang()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Double> getTatCaDonGiaSanPham() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<SanPham> list=new ArrayList<SanPham>();
		try {
			tr.begin();
			String sql = "select * from SanPham";
			em.clear();
			list = em.createNativeQuery(sql, SanPham.class).getResultList();
			tr.commit();
			List<Double> listDouble = new ArrayList<>();
			list.forEach((obj) -> listDouble.add(obj.getDonGia()));
			SortedSet<Double> uniqueList = new TreeSet<Double>(listDouble);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Integer> getTatCaSoLuongTonSanPham() throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		List<SanPham> list=new ArrayList<SanPham>();
		try {
			tr.begin();
			String sql = "select * from SanPham";
			em.clear();
			list = em.createNativeQuery(sql, SanPham.class).getResultList();
			tr.commit();
			List<Integer> listInt = new ArrayList<>();
			list.forEach((obj) -> listInt.add(obj.getSoLuong()));
			SortedSet<Integer> uniqueList = new TreeSet<Integer>(listInt);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SanPham getSanPhamByMa(String ma) throws RemoteException {
		em.clear();
		return em.createQuery("select sp from SanPham sp where sp.maSP = :x", SanPham.class).setParameter("x", ma)
				.getSingleResult();
	}

}
