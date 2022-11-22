package app;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.BanHangDao;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import dao.TaiKhoanDao;
import entity.SanPham;
import impl.BanHangImpl;
import impl.ChiTietHoaDonImpl;
import impl.HoaDonImpl;
import impl.KhachHangImpl;
import impl.NhanVienImpl;
import impl.SanPhamImpl;
import impl.TaiKhoanImpl;

public class ServerApp {
	public static void main(String[] args) throws RemoteException, NamingException {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		String IP = "rmi://192.168.1.35:9999/";
		try {
			LocateRegistry.createRegistry(9999);

			NhanVienDao nhanVienDao = new NhanVienImpl();
			KhachHangDao khdao = new KhachHangImpl();
			TaiKhoanDao tkdao = new TaiKhoanImpl();
			SanPhamDao spdao = new SanPhamImpl();
			BanHangDao banHangDao = new BanHangImpl();
			ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonImpl();
			HoaDonDao hoaDonDao = new HoaDonImpl();

			Naming.bind(IP + "nhanVienDao", nhanVienDao);
			Naming.bind(IP + "khachHangDao", khdao);
			Naming.bind(IP + "taiKhoanDao", tkdao);
			Naming.bind(IP + "sanPhamDao", spdao);
			Naming.bind(IP + "banHangDao", banHangDao);
			Naming.bind(IP + "chiTietHoaDonDao", chiTietHoaDonDao);
			Naming.bind(IP + "hoaDonDao", hoaDonDao);

			System.out.println("Server is running!");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 Hashtable<String, String> env = new Hashtable<String, String>();
//		 env.put("java.security.policy", "policy/policy.policy");
//		 Context context = new InitialContext(env);
//		 LocateRegistry.createRegistry(9999);
//		
//		 NhanVienDao nhanvien_dao = new NhanVienImpl(); // Remote Object
//		
//		 context.bind("rmi://192.168.1.109:9999/nhanVienDao", nhanvien_dao);
//		
//		 System.out.println("Ready...");
//		 System.out.println(nhanvien_dao.getTatCaNhanVien());
	}
}
