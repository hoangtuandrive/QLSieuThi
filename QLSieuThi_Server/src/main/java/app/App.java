package app;

import java.rmi.RemoteException;
import java.util.Date;

import dao.KhachHangDao;
import dao.NhanVienDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import impI.KhachHangImpI;
import impI.NhanVienImpI;
import impI.TaiKhoanImpI;

public class App {

	public static void main(String[] args) throws RemoteException {
				NhanVienDao nhanVienDao=new NhanVienImpI();
//				NhanVienImpI nhanVienDao=new NhanVienImpI();
				TaiKhoan t=new TaiKhoan("123", "123");
				NhanVien nv=new NhanVien("12345", "Long A", true, "23	45", "324", 140.0, "124", new Date(), "342sz", "523", true, t);
				t.setMaNV(nv);
			
				nhanVienDao.addNhanVien(nv);
				//System.out.println(nhanVienDao.getNhanVienById("12345"));
//				nhanVienDao.updateNV(nv);
//				nhanVienDao.delete("12345");
				KhachHangDao khdao=new KhachHangImpI();
				KhachHang kh=new KhachHang("123", "Long", false, "123", "zs", new Date(), "234z", "234");
				//khdao.create(kh);
//				System.out.println(khdao.getTatCaKhachHang());
//				khdao.update(kh);
	}	

}
