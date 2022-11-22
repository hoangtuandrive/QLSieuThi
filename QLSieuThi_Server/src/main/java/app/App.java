package app;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.internal.build.AllowSysOut;

import dao.BanHangDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import impl.BanHangImpl;
import impl.HoaDonImpl;
import impl.KhachHangImpl;
import impl.NhanVienImpl;
import impl.SanPhamImpl;

public class App {

	public static void main(String[] args) throws RemoteException {
//		NhanVienDao nhanVienDao = new NhanVienImpl();
//		TaiKhoan t = new TaiKhoan("123", "123");
//		NhanVien nv = new NhanVien("NV350", "Long C", true, "23	45", "324", 140.0, "124", new Date(), "342sz", "523",
//				true, t);
//		t.setMaNV(nv);
//		System.out.println(nhanVienDao.updateNV(nv));
//
//		System.out.println(nhanVienDao.getNhanVienById("NV350"));
//		
//		BanHangDao banHangDao = new BanHangImpl();
//		System.out.println(banHangDao.getMaKhachHangCuoi());
//		SanPhamDao sanPhamDao = new SanPhamImpl();
//		SortedSet<String> list = new TreeSet<>();
//		list = sanPhamDao.getTatCaTenSanPham();
//		List<String> list = new ArrayList<>();
//		list = sanPhamDao.getTatCaTenSanPham();

//		list.forEach(System.out::println);
		
		HoaDonDao hoadon_dao = new HoaDonImpl();
		KhachHangDao khachhang_dao = new KhachHangImpl();
		NhanVienDao nhanvien_dao = new NhanVienImpl();
//		NhanVien nv = nhanvien_dao.getNhanVienById("NV1001");
//		System.out.println(nv.toString());
		
//		List<String> list = hoadon_dao.getTatCaTenNhanVien();
//		list.forEach(System.out::println);
		
//		List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
//		for (HoaDon hd : listHD) {
////			if (hd.getMaKH().getSDT().equals("0929471420")) {
//				String maHD = hd.getMaHD();
//				System.out.println(maHD);
////				break;
//		//	}
//		}
		

//		List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
//		List<HoaDon> list= new ArrayList<HoaDon>();
//		Iterator<HoaDon[]> itr = listHD.iterator();
//		while(itr.hasNext()) {
//			Object[] line = itr.next();
////			System.out.println("Here:" + String.valueOf(line[1]));
//			HoaDon hd = new HoaDon();
//			hd.setMaHD(String.valueOf(line[0]));
////			NhanVien nv = (NhanVien) new NhanVien(line[1].);
//			hd.setMaNV((NhanVien) line[1]);
////			System.out.println(nv.getMaNV());
//			System.out.println(hd.getMaNV().getMaNV());
//			list.add(hd);
//		}
	}

}
