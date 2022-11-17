package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.TaiKhoan;

public interface TaiKhoanDao extends Remote{
	public boolean AddTaiKhoan(TaiKhoan tk) throws RemoteException;
}
