package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import entity.SanPham;




public interface SanPhamDao extends Remote {
	public List<SanPham> getTatCaSanPham() throws RemoteException;
	public boolean create(SanPham sp) throws RemoteException;
	public boolean delete(SanPham sp)throws RemoteException;
	public boolean update(SanPham sp) throws RemoteException;
	public SortedSet<String> getTatCaMaSanPham() throws RemoteException;
	public SortedSet<String> getTatCaTenSanPham() throws RemoteException;
	public SortedSet<String> getTatCaNhaCungCapSanPham() throws RemoteException;
	public SortedSet<String> getTatCaLoaiHangSanPham() throws RemoteException;
	public SortedSet<Double> getTatCaDonGiaSanPham() throws RemoteException;
	public SortedSet<Integer> getTatCaSoLuongTonSanPham() throws RemoteException;
	public SanPham getSanPhamByMa(String ma) throws RemoteException;
}
