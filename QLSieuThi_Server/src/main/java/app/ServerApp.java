package app;

import java.rmi.Naming;

import java.rmi.registry.LocateRegistry;

import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import dao.TaiKhoanDao;
import entity.SanPham;
import impI.KhachHangImpI;
import impI.NhanVienImpI;
import impI.SanPhamImpI;
import impI.TaiKhoanImpI;

public class ServerApp {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		String IP = "rmi://192.168.1.109:9999/";
		try {
			LocateRegistry.createRegistry(9999);

			NhanVienDao nhanVienDao = new NhanVienImpI();
			KhachHangDao khdao = new KhachHangImpI();
			TaiKhoanDao tkdao = new TaiKhoanImpI();
			SanPhamDao spdao = new SanPhamImpI();

			Naming.bind(IP + "nhanVienDao", nhanVienDao);
			Naming.bind(IP + "khachHangDao", khdao);
			Naming.bind(IP + "taiKhoanDao", tkdao);
			Naming.bind(IP + "sanPhamDao", spdao);

			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Hashtable<String, String> env = new Hashtable<String, String>();
		// env.put("java.security.policy", "policy/policy.policy");
		// Context context = new InitialContext(env);
		// LocateRegistry.createRegistry(9999);
		//
		// NhanVienDao nhanvien_dao = new NhanVienImpI(); // Remote Object
		//
		// context.bind("rmi://192.168.1.35:9999/nhanVienDao", nhanvien_dao);
		//
		// System.out.println("Ready...");
		// System.out.println(nhanvien_dao.getTatCaNhanVien());
	}
}
