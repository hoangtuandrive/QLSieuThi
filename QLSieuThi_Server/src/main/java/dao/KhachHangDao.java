package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;

public interface KhachHangDao extends Remote {
	public List<KhachHang> getTatCaKhachHang() throws RemoteException;
	public boolean create(KhachHang kh) throws RemoteException;
	public boolean update(KhachHang kh) throws RemoteException;

}
