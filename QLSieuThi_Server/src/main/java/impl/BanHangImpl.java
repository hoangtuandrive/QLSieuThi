package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import dao.BanHangDao;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import util.MyEmFactory;

public class BanHangImpl extends UnicastRemoteObject implements BanHangDao {
	private EntityManager em;

	public BanHangImpl() throws RemoteException {
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public String getMaKhachHangCuoi() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		KhachHang kh = new KhachHang();
		try {
			tr.begin();
			String sql = "select Top 1 * from KhachHang order by maKH Desc";
			em.clear();
			kh = (KhachHang) em.createNativeQuery(sql, KhachHang.class).getSingleResult();
			tr.commit();
			return kh.getMaKH();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public String getMaHoaDonCuoi() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		HoaDon hd = new HoaDon();
		try {
			tr.begin();
			String sql = "select top 1 * from HoaDon order by maHD desc";
			em.clear();
			hd = (HoaDon) em.createNativeQuery(sql, HoaDon.class).getSingleResult();
			tr.commit();
			return hd.getMaHD();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public boolean createGioHang(HoaDon hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(hd);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateTrangThai(String id, boolean gioHang) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "update KhachHang set gioHang = ?1 where maKH = ?2";
			em.createNativeQuery(sql, KhachHang.class).setParameter(1, gioHang).setParameter(2, id).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<KhachHang> getKhachHangTheoGioHang(boolean gioHang) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			tr.begin();
			em.clear();
			String sql = "select * from KhachHang where gioHang = ?1";
			list = em.createNativeQuery(sql, KhachHang.class).setParameter(1, gioHang).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	// public boolean update(String maHD, String maNV, Date ngayLapHoaDon, double tongTien) throws RemoteException {
	@Override
	public boolean update(HoaDon hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
//			String sql = "update HoaDon\r\n" + "set maNV=?2,ngayLapHoaDon=?3,tongTienThanhToan=?4\r\n"
//					+ "where maHD=?1";
//			em.createNativeQuery(sql, HoaDon.class).setParameter(1, maHD).setParameter(2, maNV)
//					.setParameter(3, ngayLapHoaDon).setParameter(4, tongTien).executeUpdate();
			em.merge(hd);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean delete(HoaDon hd) throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			String sql="delete from HoaDon where maHD=?1";
			em.createNativeQuery(sql, HoaDon.class).setParameter(1, hd.getMaHD()).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return false;
	}
}
