package impI_Tuan;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;

import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;

import util.MyEmFactory;

public class TaiKhoanImpI extends UnicastRemoteObject implements TaiKhoanDao{
	private EntityManager em;
	public TaiKhoanImpI() throws RemoteException{
		em= MyEmFactory.getIntance().getEntityManagerFactory().createEntityManager();		
	}
	@Override
	public boolean AddTaiKhoan(TaiKhoan tk) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
