package app;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.KhachHangDao;
import dao.NhanVienDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import impI_Tuan.NhanVienImpI;

public class App {

	public static void main(String[] args) throws RemoteException {
		NhanVienDao nhanVienDao = new NhanVienImpI();

		TaiKhoan t = new TaiKhoan("123", "123");
		NhanVien nv = new NhanVien("NV350", "Long C", true, "23	45", "324", 140.0, "124", new Date(), "342sz", "523",
				true, t);
		t.setMaNV(nv);
		System.out.println(nhanVienDao.updateNV(nv));

		System.out.println(nhanVienDao.getNhanVienById("NV350"));

	}

}
