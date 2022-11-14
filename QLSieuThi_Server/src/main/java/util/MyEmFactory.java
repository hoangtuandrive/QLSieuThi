package util;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEmFactory {
	private static MyEmFactory intance;
	private EntityManagerFactory en;
	
	private MyEmFactory() {
		en= Persistence.createEntityManagerFactory("QLSieuThi_Server");
	}
	public synchronized static MyEmFactory getIntance() {
		if(intance==null)
			intance=new MyEmFactory();
		return intance;
	}
	public EntityManagerFactory getEntityManagerFactory() {
		return en;
	}
}
