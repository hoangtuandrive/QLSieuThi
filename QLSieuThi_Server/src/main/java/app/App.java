package app;

import java.util.Date;

import dao.TestDao;
import entity.NhanVien;
import entity.TaiKhoan;

public class App {

	public static void main(String[] args) {
				TestDao test=new TestDao();
				TaiKhoan t=new TaiKhoan("123", "123");
				NhanVien nv=new NhanVien("1234", "Long", true, "2345", "324", 140.0, "124", new Date(), "342sz", "523", true);
				nv.setTaiKhoan(t);
				test.AddStudent(nv);
				//test.AddTk(nv);

	}	

}
