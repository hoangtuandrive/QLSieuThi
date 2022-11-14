package app;

import java.util.Date;

import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;

public class App {

	public static void main(String[] args) {
				NhanVienDao nhanVienDao=new NhanVienDao();
				TaiKhoan t=new TaiKhoan("123", "123");
				NhanVien nv=new NhanVien("12345", "Long", true, "23	45", "324", 140.0, "124", new Date(), "342sz", "523", true, t);
				t.setMaNV(nv);
				nhanVienDao.addNhanVien(nv);
				System.out.println(nhanVienDao.getNhanVienById("12345"));

	}	

}
