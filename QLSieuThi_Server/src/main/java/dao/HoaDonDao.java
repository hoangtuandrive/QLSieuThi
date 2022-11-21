package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.NhanVien;

public interface HoaDonDao extends Remote {
	public List<HoaDon> getTatCaHoaDon() throws RemoteException;
	public List<HoaDon> getTatCaHoaDonChuaTinhTien() throws RemoteException;
	public NhanVien getNhanVienSuDung(String tenDN) throws RemoteException;
	public HoaDon getHoaDonChuaTinhTienDeThanhToan(String maKH_thanhtoan) throws RemoteException;
	public List<HoaDon> getTatCaHoaDonDaThanhToan() throws RemoteException;
	public List<ChiTietHoaDon> getCTHDtheoMaHD(String maHoaDon) throws RemoteException;
	public HoaDon getHoaDonTheoMaHD(String maHoaDon) throws RemoteException;
	public SortedSet<String> getTatCaTenKhachHang() throws RemoteException;
	public SortedSet<String> getTatCaMaHoaDon() throws RemoteException;
	public SortedSet<String> getTatCaTenNhanVien() throws RemoteException;
	public SortedSet<Date> getTatCaNgayLapHoaDon() throws RemoteException;
	public SortedSet<Double> getTongTienThanhToan() throws RemoteException;
}
