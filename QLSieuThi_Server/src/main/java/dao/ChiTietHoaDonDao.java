package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDon;

public interface ChiTietHoaDonDao extends Remote {
	public List<ChiTietHoaDon> getTatCaHoaDonLK() throws RemoteException;
	public boolean create(ChiTietHoaDon cthd) throws RemoteException;
	public boolean delete(String maSanPham,String maHoaDon) throws RemoteException;
	public boolean updateSoLuong(ChiTietHoaDon cthd) throws RemoteException;
	public List<ChiTietHoaDon> getCTHDTheoMaHDLenTable(String maHoaDon) throws RemoteException;
}
