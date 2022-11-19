package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.SanPham;




public interface SanPhamDao extends Remote {
	public List<SanPham> getTatCaSanPham() throws RemoteException;
	public boolean create(SanPham sp) throws RemoteException;
	public boolean delete(SanPham sp)throws RemoteException;
	public boolean update(SanPham sp) throws RemoteException;
}
