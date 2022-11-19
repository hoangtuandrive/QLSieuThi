package app;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.NhanVienDao;
import impI_Tuan.NhanVienImpI;


public class ServerApp {
	public static void main(String[] args) throws NamingException, RemoteException {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		String IP = "rmi://192.168.1.109:9999/";
		try {
			LocateRegistry.createRegistry(9999);

			NhanVienDao nhanVienDao =  new NhanVienImpI();
		
			Naming.bind(IP+"nhanVienDao", nhanVienDao);
			

			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Hashtable<String, String> env  = new Hashtable<String, String>();
//		env.put("java.security.policy", "policy/policy.policy");
//		Context context = new InitialContext(env);
//		LocateRegistry.createRegistry(9999);
//		
//		NhanVienDao nhanvien_dao = new NhanVienImpI(); // Remote Object
//		
//		context.bind("rmi://192.168.1.109:9999/NhanVien", nhanvien_dao);
//		
//		System.out.println("Ready...");
//		System.out.println(nhanvien_dao.getTatCaNhanVien());
	}
}
