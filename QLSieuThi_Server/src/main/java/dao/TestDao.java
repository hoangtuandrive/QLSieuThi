package dao;


import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.MyEmFactory;

public class TestDao {
	private EntityManager em;
	public TestDao() {
		em= MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();
		
	}
	public boolean AddStudent(NhanVien nv) {
		EntityTransaction tr=em.getTransaction();
		
		try {
			tr.begin();
			
			em.persist(nv);
			System.out.println(nv.getTaiKhoan());
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			// TODO: handle exception
		}
		return false;
	}
	public boolean AddTk(NhanVien nv) {
		EntityTransaction tr=em.getTransaction();
		
		try {
			tr.begin();
			String sql="INSERT INTO [dbo].[TaiKhoan]\r\n"
					+ "           ([tenDN]\r\n"
					+ "           ,[matKhau])\r\n"
					+ "     VALUES\r\n"
					+ "           (?1,?2)\r\n";
					
			em.createNativeQuery(sql).setParameter(1, nv.getMaNV())
			.setParameter(2, nv.getTaiKhoan().getMatKhau()).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			// TODO: handle exception
		}
		return false;
	}
}
