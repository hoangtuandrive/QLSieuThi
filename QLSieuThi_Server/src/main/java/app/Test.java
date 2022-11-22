package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("QLSieuThi_Server");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
