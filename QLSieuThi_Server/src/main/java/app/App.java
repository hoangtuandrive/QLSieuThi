package app;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.internal.build.AllowSysOut;

import dao.BanHangDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import impl.BanHangImpl;
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
		SanPhamDao sanPhamDao = new SanPhamImpl();
		SortedSet<String> list = new TreeSet<>();
		list = sanPhamDao.getTatCaTenSanPham();
//		List<String> list = new ArrayList<>();
//		list = sanPhamDao.getTatCaTenSanPham();

		list.forEach(System.out::println);
		
		
	}

}
