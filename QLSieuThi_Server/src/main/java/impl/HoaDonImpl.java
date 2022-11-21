package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import dao.HoaDonDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import util.MyEmFactory;

public class HoaDonImpl extends UnicastRemoteObject implements HoaDonDao {
	private EntityManager em;

	public HoaDonImpl() throws RemoteException {
		em = MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();
	}

	@Override
	public List<HoaDon> getTatCaHoaDon() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon";
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Transactional
	@Override
	public List<HoaDon> getTatCaHoaDonChuaTinhTien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon where tongTienThanhToan=0"; 
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public NhanVien getNhanVienSuDung(String tenDN) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "select hd.maHD,hd.maNV,hd.maKH,hd.ngayLapHoaDon,kh.SDT,kh.tenKH\r\n"
					+ "from HoaDon hd join KhachHang kh on hd.maKH = kh.maKH\r\n" + " where tongTienThanhToan=0";
			em.clear();
			NhanVien nv = (NhanVien) em.createNativeQuery(sql, NhanVien.class).getSingleResult();
			tr.commit();
			return nv;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	
	@Override
	public HoaDon getHoaDonChuaTinhTienDeThanhToan(String maKH_thanhtoan) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		HoaDon hd = new HoaDon();
		try {
			tr.begin();
//			String sql = "select hd.maHD, hd.maNV, hd.maKH, hd.ngayLapHoaDon, kh.SDT, cthd.maHD, sp.maSP, sp.tenSP, "
//					+ "sp.loaiHang, sp.nhaCungCap, cthd.soLuong, cthd.giaTien, kh.tenKH \r\n"
//					+ "from HoaDon hd left join ChiTietHoaDon cthd on hd.maHD = cthd.maHD \r\n"
//					+ "left join SanPham sp on cthd.maSP = sp.maSP \r\n" + "join KhachHang kh on hd.maKH = kh.maKH \r\n"
//					+ "where tongTienThanhToan=0 and hd.maKH = ?";
			String sql = "select HoaDon from HoaDon where tongTienThanhToan=0 and hd.maKH = ?1"; 
			em.clear();
			hd = (HoaDon) em.createNativeQuery(sql, HoaDon.class).setParameter(1, maKH_thanhtoan).getSingleResult();
			tr.commit();
			return hd;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<HoaDon> getTatCaHoaDonDaThanhToan() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon where tongTienThanhToan>0";
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<ChiTietHoaDon> getCTHDtheoMaHD(String maHoaDon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			tr.begin();
			String sql = "select sp.maSP,sp.tenSP,sp.loaiHang,sp.nhaCungCap,ct.soLuong,sp.donGia,ct.thanhTien,ct.maHD\r\n"
					+ "from ChiTietHoaDon ct join SanPham sp on ct.maSP = sp.maSP\r\n" + " where ct.maHD = ?!";
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

	@Override
	public HoaDon getHoaDonTheoMaHD(String maHoaDon) throws RemoteException {
		em.clear();
		return em.createQuery("select hd from HoaDon hd where hd.maHD = :x", HoaDon.class).setParameter("x", maHoaDon)
				.getSingleResult();
	}

	@Override
	public SortedSet<String> getTatCaTenKhachHang() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon where tongTienThanhToan>0";
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			List<KhachHang> listKhachHang = new ArrayList<>();
			list.forEach((obj) -> listKhachHang.add(obj.getMaKH()));
			List<String> listString = new ArrayList<>();
			listKhachHang.forEach((obj) -> listString.add(obj.getTenKH()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<String> getTatCaMaHoaDon() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon where tongTienThanhToan>0";
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			List<String> listString = new ArrayList<>();
			list.forEach((obj) -> listString.add(obj.getMaHD()));
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
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon where tongTienThanhToan>0";
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			List<NhanVien> listNhanVien = new ArrayList<>();
			list.forEach((obj) -> listNhanVien.add(obj.getMaNV()));
			List<String> listString = new ArrayList<>();
			listNhanVien.forEach((obj) -> listString.add(obj.getTenNV()));
			SortedSet<String> uniqueList = new TreeSet<String>(listString);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Date> getTatCaNgayLapHoaDon() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon where tongTienThanhToan>0";
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			List<Date> listDate = new ArrayList<>();
			list.forEach((obj) -> listDate.add(obj.getNgayLapHoaDon()));
			SortedSet<Date> uniqueList = new TreeSet<Date>(listDate);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public SortedSet<Double> getTongTienThanhToan() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select * from HoaDon where tongTienThanhToan>0";
			em.clear();
			list = em.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			List<Double> listDouble = new ArrayList<>();
			list.forEach((obj) -> listDouble.add(obj.getTongTien()));
			SortedSet<Double> uniqueList = new TreeSet<Double>(listDouble);
			return uniqueList;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}
