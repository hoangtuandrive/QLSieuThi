package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TaiKhoan;

public interface TaiKhoanDao extends Remote{

	public boolean Delete(String id) throws RemoteException;
	public List<TaiKhoan> GetAllTaiKhoan() throws RemoteException;
}
