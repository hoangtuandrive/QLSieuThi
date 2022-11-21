package App;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.NhanVienDao;
import entity.NhanVien;

public class test {
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		NhanVienDao nvDao = (NhanVienDao) Naming.lookup("rmi://192.168.1.109:9999/NhanVien");

		NhanVien nv = nvDao.getNhanVienById("12345");
		System.out.println(nv);
	}
}
