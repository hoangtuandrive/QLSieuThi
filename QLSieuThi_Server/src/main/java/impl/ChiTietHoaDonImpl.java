package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.ChiTietHoaDonDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import util.MyEmFactory;

public class ChiTietHoaDonImpl extends UnicastRemoteObject implements ChiTietHoaDonDao {
	private EntityManager em;

	public ChiTietHoaDonImpl() throws RemoteException {
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<ChiTietHoaDon> getTatCaHoaDonLK() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			tr.begin();
			String sql = "Select * from ChiTietHoaDon";
			em.clear();
			list = em.createNativeQuery(sql, ChiTietHoaDon.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public boolean create(ChiTietHoaDon cthd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(cthd);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean delete(String maSP, String maHoaDon) throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			String sql="delete ChiTietHoaDon where maSP = ?1 and maHD = ?2";
			em.createNativeQuery(sql, ChiTietHoaDon.class).setParameter(1, maSP).setParameter(2, maHoaDon).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return false;
	}

	@Override
	public boolean updateSoLuong(ChiTietHoaDon cthd) throws RemoteException {
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			String sql="update ChiTietHoaDon set soLuong=?1, thanhTien=?2 where maHD=?3 and maSP=?4";
			em.createNativeQuery(sql, HoaDon.class).setParameter(1, cthd.getSoLuong()).setParameter(2, cthd.getThanhTien())
			.setParameter(3, cthd.getMaHoaDon()).setParameter(4, cthd.getMaSP()).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}		
		return false;
	}

	@Override
	public List<ChiTietHoaDon> getCTHDTheoMaHDLenTable(String maHoaDon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			tr.begin();
			String sql = "select sp.maSP,sp.tenSP,sp.loaiHang,sp.nhaCungCap,ct.soLuong,sp.donGia,ct.thanhTien,ct.maHD\r\n" + 
					"from ChiTietHoaDon ct join SanPham sp on ct.maSP = sp.maSP\r\n" + 
					" where ct.maHD = ?1";
			em.clear();
			list = em.createNativeQuery(sql, ChiTietHoaDon.class).setParameter(1, maHoaDon).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}
