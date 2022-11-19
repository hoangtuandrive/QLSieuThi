package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import entity.NhanVien;

public interface NhanVienDao extends Remote {
	public boolean addNhanVien(NhanVien nv) throws RemoteException;
	public  NhanVien getNhanVienById(String ma) throws RemoteException;
	public boolean updateNV(NhanVien nv) throws RemoteException;
	public List<NhanVien> getTatCaNhanVien() throws RemoteException;
	public boolean delete(String id) throws RemoteException;
	public boolean setNullTK(NhanVien nv) throws RemoteException;
	public SortedSet<String> getTatCaMaNhanVien() throws RemoteException;
	public SortedSet<String> getTatCaTenNhanVien() throws RemoteException;
	public SortedSet<Boolean> getTatCaGioiTinhNhanVien() throws RemoteException;
	public SortedSet<String> getTatCaSDTNhanVien() throws RemoteException;
	public SortedSet<String> getTatCaChucVuNhanVien() throws RemoteException;
	public SortedSet<Double> getTatCaLuongNhanVien() throws RemoteException;
	public SortedSet<String> getTatCaCMNDNhanVien() throws RemoteException;
	public SortedSet<Date> getTatCaNgaySinhNhanVien() throws RemoteException;
	public SortedSet<String> getTatCaDiaChiNhanVien() throws RemoteException;
	public SortedSet<String> getTatCaEmailNhanVien() throws RemoteException;
	public SortedSet<Boolean> getTatCaTrangThaiNhanVien() throws RemoteException;	
	public List<NhanVien> getTatCaNhanVienKhiAdd() throws RemoteException;
}
