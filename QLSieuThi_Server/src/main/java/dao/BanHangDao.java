package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import entity.HoaDon;
import entity.KhachHang;

public interface BanHangDao extends Remote {
	public String getMaKhachHangCuoi() throws RemoteException;
	public String getMaHoaDonCuoi() throws RemoteException;
	public boolean createGioHang(HoaDon hd) throws RemoteException;
	public boolean updateTrangThai(String id, boolean gioHang) throws RemoteException;
	public List<KhachHang> getKhachHangTheoGioHang(boolean gioHang) throws RemoteException;
	public boolean update(HoaDon hd) throws RemoteException;
	public boolean delete (HoaDon hd) throws RemoteException;
}
