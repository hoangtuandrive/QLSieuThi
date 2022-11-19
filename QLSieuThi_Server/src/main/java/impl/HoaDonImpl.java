package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

	@Override
	public List<HoaDon> getTatCaHoaDonChuaTinhTien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String sql = "select hd.maHD,hd.maNV,hd.maKH,hd.ngayLapHoaDon,kh.SDT,kh.tenKH\r\n"
					+ "from HoaDon hd join KhachHang kh on hd.maKH = kh.maKH\r\n" + " where tongTienThanhToan is NULL";
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
					+ "from HoaDon hd join KhachHang kh on hd.maKH = kh.maKH\r\n" + " where tongTienThanhToan is NULL";
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
			String sql = "select hd.maHD, hd.maNV, hd.maKH, hd.ngayLapHoaDon, kh.SDT, cthd.maHD, sp.maSP, sp.tenSP, "
					+ "sp.loaiHang, sp.nhaCungCap, cthd.soLuong, cthd.giaTien, kh.tenKH \r\n"
					+ "from HoaDon hd left join ChiTietHoaDon cthd on hd.maHD = cthd.maHD \r\n"
					+ "left join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH \r\n" + "where tongTienThanhToan is NULL and hd.maKH = ?";
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
			String sql = "select hd.maHD,hd.maKH,k.SDT,k.tenKH,hd.maNV,nv.tenNV,hd.ngayLapHoaDon,hd.tongTienThanhToan\r\n"
					+ "from HoaDon hd \r\n" + "join KhachHang k on hd.maKH = k.maKH\r\n"
					+ "join NhanVien nv on nv.maNV = hd.maNV\r\n" + "where tongTienThanhToan is not NULL";
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
		EntityTransaction tr = em.getTransaction();
		HoaDon hd = new HoaDon();
		try {
			tr.begin();
			String sql = "select hd.maHD,hd.maKH,k.SDT,k.tenKH,hd.maNV,nv.tenNV,hd.ngayLapHoaDon\r\n"
					+ "from HoaDon hd \r\n" + "join KhachHang k on hd.maKH = k.maKH\r\n"
					+ "join NhanVien nv on nv.maNV = hd.maNV\r\n" + "where maHD = ?1";
			em.clear();
			hd = (HoaDon) em.createNativeQuery(sql, HoaDon.class).setParameter(1, maHoaDon).getSingleResult();
			tr.commit();
			return hd;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<String> getTatCaTenKhachHang() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
//		List<KhachHang> listKH = new ArrayList<KhachHang>();
		List<String> list = new ArrayList<String>();
		try {
			tr.begin();
			String sql = "select distinct kh.tenKH from HoaDon hd join KhachHang kh on hd.maKH=kh.maKH where hd.tongTienThanhToan is NOT NULL";
			em.clear();
			list = em.createNativeQuery(sql).getResultList();
			tr.commit();

//			List<String> list = new ArrayList<>(listKH.size());
//			for (KhachHang kh : listKH) {
//			    list.add(kh.getMaKH());
//			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<String> getTatCaMaHoaDon() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<String> list = new ArrayList<String>();
		try {
			tr.begin();
			String sql = "select distinct maHD from HoaDon where tongTienThanhToan is NOT NULL";
			em.clear();
			list = em.createNativeQuery(sql).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<String> getTatCaTenNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<String> list = new ArrayList<String>();
		try {
			tr.begin();
			String sql = "select distinct nv.tenNV from HoaDon hd join NhanVien nv where hd.maNV=kh.maNV where hd.tongTienThanhToan is NOT NULL";
			em.clear();
			list = em.createNativeQuery(sql).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<Date> getTatCaNgayLapHoaDon() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<Date> list = new ArrayList<Date>();
		try {
			tr.begin();
			String sql = "select distinct ngayLapHoaDon from HoaDon where tongTienThanhToan is NOT NULL";
			em.clear();
			list = em.createNativeQuery(sql).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<Double> getTatCaLuongNhanVien() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		List<Double> list = new ArrayList<Double>();
		try {
			tr.begin();
			String sql = "select distinct tongTienThanhToan from HoaDon where tongTienThanhToan is NOT NULL";
			em.clear();
			list = em.createNativeQuery(sql).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}
