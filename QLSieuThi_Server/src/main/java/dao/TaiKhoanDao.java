package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TaiKhoan;

public interface TaiKhoanDao extends Remote{
	public boolean create(TaiKhoan tk) throws RemoteException;
	public boolean delete(String id) throws RemoteException;
	public List<TaiKhoan> getAllTaiKhoan() throws RemoteException;
	public boolean updateDoiMatKhau(TaiKhoan taikhoan, String matKhauMoi) throws RemoteException;
	public boolean updateTenDangNhap(TaiKhoan taikhoan, String tenMoi) throws RemoteException;
}
