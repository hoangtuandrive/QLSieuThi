package app;

import java.rmi.RemoteException;
import java.util.Date;

import dao.NhanVienDao;
import entity.NhanVien;
import entity.TaiKhoan;
import impI.NhanVienImpI;
import impI.TaiKhoanImpI;

public class App {

	public static void main(String[] args) throws RemoteException {
				NhanVienDao nhanVienDao=new NhanVienImpI();
//				NhanVienImpI nhanVienDao=new NhanVienImpI();
				TaiKhoan t=new TaiKhoan("123", "123");
				NhanVien nv=new NhanVien("12345", "Long A", true, "23	45", "324", 140.0, "124", new Date(), "342sz", "523", true, t);
				t.setMaNV(nv);
			
				//nhanVienDao.addNhanVien(nv);
				//System.out.println(nhanVienDao.getNhanVienById("12345"));
				//nhanVienDao.updateNV(nv);
//				nhanVienDao.delete("12345");
	}	

}
