package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import entity.KhachHang;

public interface KhachHangDao extends Remote {
	public List<KhachHang> getTatCaKhachHang() throws RemoteException;
	public boolean create(KhachHang kh) throws RemoteException;
	public boolean update(KhachHang kh) throws RemoteException;
	public boolean huyGioHang(String sdt, boolean gioHang) throws RemoteException;
	public SortedSet<String> getTatCaSDTKhachHang() throws RemoteException;
	public boolean updateGioHang(KhachHang kh) throws RemoteException;
	public SortedSet<String> getTatCaMaKhachHang() throws RemoteException;
	public SortedSet<String> getTatCaTenKhachHang() throws RemoteException;
	public SortedSet<Boolean> getTatCaGioiTinhKhachHang() throws RemoteException;
	public SortedSet<String> getTatCaSDTKhachHangCMB() throws RemoteException;
	public SortedSet<String> getTatCaCMNDKhachHang() throws RemoteException;
	public SortedSet<Date> getTatCaNgaySinhKhachHang() throws RemoteException;
	public SortedSet<String> getTatCaDiaChiKhachHang() throws RemoteException;
	public SortedSet<String> getTatCaEmailKhachHang() throws RemoteException;
}
