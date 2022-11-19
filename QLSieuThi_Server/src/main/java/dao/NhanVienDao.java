package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienDao extends Remote {
	public boolean addNhanVien(NhanVien nv) throws RemoteException;
	public  NhanVien getNhanVienById(String ma) throws RemoteException;
	public boolean updateNV(NhanVien nv) throws RemoteException;
	public List<NhanVien> getTatCaNhanVien() throws RemoteException;
	public boolean delete(String id) throws RemoteException;
	
}
