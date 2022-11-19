package App;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.NhanVienDao;
import entity.NhanVien;


public class test {
public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
	NhanVienDao studentDao = (NhanVienDao) Naming.lookup("rmi://192.168.1.109:9999/NhanVien");
	
	NhanVien student = studentDao.getNhanVienById("12345");
	System.out.println(student);
	
//	studentDao.addStudent(new Student("19493061", "Tran Hoang Long", "male", new Date(1997 - 1900, Calendar.MAY, 12)));
}
}
