package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.formdev.flatlaf.FlatLightLaf;
//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.toedter.calendar.JDateChooser;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import dao.BanHangDao;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import dao.TaiKhoanDao;

public class FrmBanHang extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTim;
	private JButton btnTim;
	private static DefaultTableModel modelSanPham;
	private static JTable tableSanPham;
	private JTextField txtMaKhachHang;
	private JCheckBox chkNam;
	private JTextField txtSoLuong;
	private JButton btnCong;
	private DefaultTableModel modelGioHang;
	private JTable tableGioHang;
	private JTextField txtTongTien;
	private JButton btnHuy;
	private JButton btnThanhToan;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblSDT;
	private JLabel lblEmail;
	private JLabel lblDiaChi;
	private JLabel lblSoLuong;
	private JTextField txtTenKhachHang;
	private JLabel lblGioiTinh;
	private JComboBox<String> cmbGioiTinh;
	private JLabel lblTongTien;
	private JDateChooser txtNgaySinh;
	private JLabel lblNgaySinh;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private static JComboBox<String> cmbDanhSachSdt;
	private static JComboBox<String> cmbTim;
	private JButton btnTimKHCu;
	private JLabel lblGioHang;
	private JPanel pTitle1;
	private JLabel lblTitle;
	private JLabel lblTitle1;
	private JButton btnTaoGioHang;
	private JButton btnTru;
	private Date ngayLapHoaDon;
	private static JComboBox<String> cmbChon;
	private static JComboBox<String> cmbGioHang;
	public static String maHDMoiDat = "";
	public static String maKHDatGioHang = "";
	private static SanPhamDao sanpham_dao;
	private static KhachHangDao khachhang_dao;
	private static HoaDonDao hoadon_dao;
	private NhanVienDao nhanvien_dao;
	private ChiTietHoaDonDao cthd_dao;
	private BanHangDao banhang_dao;

	public JPanel createPanelBanHang() throws RemoteException {
		FlatLightLaf.setup();
		// TODO Auto-generated constructor stub
		setTitle("FrmBanHang");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel p = new JPanel();

		Box b = Box.createHorizontalBox();
		Box b1 = Box.createVerticalBox();
		Box b2 = Box.createVerticalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createVerticalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		Box b7 = Box.createHorizontalBox();
		Box b8 = Box.createHorizontalBox();
		Box b9 = Box.createHorizontalBox();
		Box b10 = Box.createHorizontalBox();
		Box b11 = Box.createHorizontalBox();
		Box b12 = Box.createHorizontalBox();
		Box b13 = Box.createHorizontalBox();
		Box b14 = Box.createHorizontalBox();
		Box b15 = Box.createHorizontalBox();
		Box b16 = Box.createHorizontalBox();
		Box b17 = Box.createHorizontalBox();

		String[] tim = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Hàng", "Nhà Cung Cấp", "Đơn Giá", "Số Lượng Tồn" };
		cmbChon = new JComboBox<String>(tim);
		b3.add(cmbChon);
		b3.add(Box.createHorizontalStrut(10));
		cmbTim = new JComboBox<String>();
		cmbTim.setEditable(true);
		AutoCompleteDecorator.decorate(cmbTim);
		cmbTim.setMaximumRowCount(10);
		cmbChon.setSize(20, cmbTim.getPreferredSize().height);
		b3.add(cmbTim);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(btnTim = new JButton("TÌM HÀNG", new ImageIcon("image/timhanghoa.png")));
		btnTim.setBackground(new Color(0, 148, 224));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFocusPainted(false);

		b3.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "TÌM SẢN PHẨM	: "));

		String[] colHeader = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Hàng", "Nhà Cung Cấp", "Đơn Giá", "Số Lượng Tồn" };
		modelSanPham = new DefaultTableModel(colHeader, 0);
		tableSanPham = new JTable(modelSanPham) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				Color color1 = new Color(219, 243, 255);
				Color color2 = Color.WHITE;
				if (!c.getBackground().equals(getSelectionBackground())) {
					Color coleur = (row % 2 == 0 ? color1 : color2);
					c.setBackground(coleur);
					coleur = null;
				}
				return c;
			}
		};
		tableSanPham.setGridColor(getBackground());
		tableSanPham.setRowHeight(tableSanPham.getRowHeight() + 20);
		tableSanPham.setSelectionBackground(new Color(255, 255, 128));
		tableSanPham.setSelectionForeground(Color.BLACK);
		JTableHeader tableHeader = tableSanPham.getTableHeader();
		tableHeader.setBackground(new Color(0, 148, 224));
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setPreferredSize(new Dimension(WIDTH, 30));
		JScrollPane tblscroll = new JScrollPane(tableSanPham);
		tableSanPham.setPreferredScrollableViewportSize(new Dimension(650, 580));
		b1.add(b3);
		b1.add(tblscroll);
		tblscroll.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DANH SÁCH SẢN PHẨM: "));

		b.add(lblTitle = new JLabel("THÔNG TIN KHÁCH HÀNG"));
		b5.add(lblMa = new JLabel("Mã Khách Hàng:"));
		b5.add(Box.createHorizontalStrut(10));
		b5.add(txtMaKhachHang = new JTextField());
		b6.add(lblTen = new JLabel("Tên Khách Hàng:"));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(txtTenKhachHang = new JTextField());
		b14.add(lblNgaySinh = new JLabel("Ngày Sinh:"));
		b14.add(Box.createHorizontalStrut(10));
		b14.add(txtNgaySinh = new JDateChooser());
		txtNgaySinh.setDateFormatString("yyyy-MM-dd");
		txtNgaySinh.setDate(new Date(1999 - 1900, 1 - 1, 1));
		b15.add(lblCMND = new JLabel("CMND:"));
		b15.add(Box.createHorizontalStrut(10));
		b15.add(txtCMND = new JTextField());
		String[] gioitinh = { "Nam", "Nữ" };
		cmbGioiTinh = new JComboBox<String>(gioitinh);
		b13.add(lblGioiTinh = new JLabel("Giới Tính:"));
		b13.add(Box.createHorizontalStrut(10));
		b13.add(cmbGioiTinh);
		b7.add(lblSDT = new JLabel("SDT:"));
		b7.add(Box.createHorizontalStrut(10));
		cmbDanhSachSdt = new JComboBox<String>();
		cmbDanhSachSdt.setEditable(true);
		AutoCompleteDecorator.decorate(cmbDanhSachSdt);
		cmbDanhSachSdt.setMaximumRowCount(10);
		b7.add(cmbDanhSachSdt);
		btnTimKHCu = new JButton("TÌM SDT", new ImageIcon("image/timkiem.png"));
		btnTimKHCu.setBackground(new Color(0, 148, 224));
		btnTimKHCu.setForeground(Color.WHITE);
		btnTimKHCu.setFocusPainted(false);
		b7.add(Box.createHorizontalStrut(300));
		b7.add(btnTimKHCu);
		b8.add(lblEmail = new JLabel("Email:"));
		b8.add(Box.createHorizontalStrut(10));
		b8.add(txtEmail = new JTextField());
		b9.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		b9.add(Box.createHorizontalStrut(10));
		b9.add(txtDiaChi = new JTextField());

		b17.add(pTitle1 = new JPanel());
		pTitle1.add(lblTitle1 = new JLabel("GIỎ HÀNG"));
		b16.add(lblGioHang = new JLabel("Giỏ Hàng Của:"));
		b16.add(Box.createHorizontalStrut(10));
		cmbGioHang = new JComboBox<String>();
		cmbGioHang.setEditable(true);
		AutoCompleteDecorator.decorate(cmbGioHang);
		cmbGioHang.setMaximumRowCount(10);
		b16.add(cmbGioHang);
		b11.add(lblSoLuong = new JLabel("Số Lượng:"));
		b11.add(Box.createHorizontalStrut(10));
		b11.add(txtSoLuong = new JTextField());
		b11.add(Box.createHorizontalStrut(200));

		b4.add(b);
		b4.add(b7);
		b4.add(b5);
		b4.add(b6);
		b4.add(b14);
		b4.add(b15);
		b4.add(b13);
		b4.add(b8);
		b4.add(b9);
		b4.add(b17);
		b4.add(b16);
		b4.add(b11);
		
		String[] colHeader1 = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Hàng", "Nhà Cung Cấp", "Đơn Giá", "Số Lượng",
				"Thành Tiền" };
		modelGioHang = new DefaultTableModel(colHeader1, 0);
		tableGioHang = new JTable(modelGioHang) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				Color color1 = new Color(219, 243, 255);
				Color color2 = Color.WHITE;
				if (!c.getBackground().equals(getSelectionBackground())) {
					Color coleur = (row % 2 == 0 ? color1 : color2);
					c.setBackground(coleur);
					coleur = null;
				}
				return c;
			}
		};
		tableGioHang.setGridColor(getBackground());
		tableGioHang.setRowHeight(tableGioHang.getRowHeight() + 30);
		tableGioHang.setSelectionBackground(new Color(255, 255, 128));
		tableGioHang.setSelectionForeground(Color.BLACK);
		JTableHeader tableHeader1 = tableGioHang.getTableHeader();
		tableHeader1.setBackground(new Color(0, 148, 224));
		tableHeader1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableHeader1.setForeground(Color.WHITE);
		tableHeader1.setPreferredSize(new Dimension(WIDTH, 30));
		tableSanPham.setRowHeight(tableSanPham.getRowHeight() + 20);

		tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(165);

		JScrollPane tblscroll1 = new JScrollPane(tableGioHang);
		tblscroll1.setBorder(javax.swing.BorderFactory.createTitledBorder("GIỎ HÀNG: "));
		tableGioHang.setPreferredScrollableViewportSize(new Dimension(500, 105));
		b10.add(lblTongTien = new JLabel("Tổng Tiền:"));
		b10.add(txtTongTien = new JTextField());
		b12.add(btnThanhToan = new JButton("THANH TOÁN", new ImageIcon("image/thanhtoan.png")));
		btnThanhToan.setBackground(new Color(0, 148, 224));
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFocusPainted(false);
		b12.add(Box.createHorizontalStrut(10));
		b12.add(btnHuy = new JButton("LÀM MỚI", new ImageIcon("image/lammoi.png")));
		btnHuy.setBackground(new Color(0, 148, 224));
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFocusPainted(false);
		b2.add(b4);
		b11.add(Box.createHorizontalStrut(10));
		b11.add(btnCong = new JButton("THÊM", new ImageIcon("image/them.png")));
		btnCong.setBackground(new Color(0, 148, 224));
		btnCong.setForeground(Color.WHITE);
		btnCong.setFocusPainted(false);
		b11.add(Box.createHorizontalStrut(5));
		b11.add(btnTru = new JButton("XÓA", new ImageIcon("image/xoa.png")));
		btnTru.setBackground(new Color(0, 148, 224));
		btnTru.setForeground(Color.WHITE);
		btnTru.setFocusPainted(false);
		b9.add(Box.createHorizontalStrut(10));
		b9.add(btnTaoGioHang = new JButton("TẠO GIỎ HÀNG", new ImageIcon("image/them.png")));
		btnTaoGioHang.setBackground(new Color(0, 148, 224));
		btnTaoGioHang.setForeground(Color.WHITE);
		btnTaoGioHang.setFocusPainted(false);
		b2.add(tblscroll1);
		b2.add(b10);
		JPanel p1 = new JPanel();
//		p1.setLayout(new BorderLayout());
		JPanel p2 = new JPanel();
		p2.add(b12);
		b2.add(p2);
		p1.add(b1);
		p1.add(b2);
		p.add(p1, BorderLayout.CENTER);

		lblMa.setPreferredSize(lblTen.getPreferredSize());
		lblSDT.setPreferredSize(lblTen.getPreferredSize());
		lblEmail.setPreferredSize(lblTen.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		lblSoLuong.setPreferredSize(lblTen.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTen.getPreferredSize());
		lblTongTien.setPreferredSize(lblTen.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblTen.getPreferredSize());
		lblCMND.setPreferredSize(lblTen.getPreferredSize());
		lblGioHang.setPreferredSize(lblTen.getPreferredSize());
		cmbDanhSachSdt.setPreferredSize(lblTen.getPreferredSize());

		b.setBorder(new EmptyBorder(new Insets(10, 10, 0, 10)));
		b3.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b5.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b6.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b7.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b8.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b9.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b10.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b11.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b12.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b13.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b14.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b15.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b16.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b17.setBorder(new EmptyBorder(new Insets(10, 10, 0, 10)));

		btnThanhToan.setBounds(36, 330, 79, 13);
		btnHuy.setBounds(131, 330, 79, 13);
		txtMaKhachHang.setEditable(false);

		cmbChon.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbDanhSachSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKHCu.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMaKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaoGioHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGioHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitle1.setFont(new Font("Tahoma", Font.BOLD, 16));
		cmbGioHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTru.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 12));

		tableGioHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableGioHang.setDefaultEditor(Object.class, null);
		tableGioHang.getTableHeader().setReorderingAllowed(false);
		tableSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSanPham.setDefaultEditor(Object.class, null);
		tableSanPham.getTableHeader().setReorderingAllowed(false);

		txtTongTien.setBorder(null);
		txtTongTien.setBackground(null);
		txtTongTien.setText(null);
		
		try {
			nhanvien_dao = (NhanVienDao) Naming.lookup(FrmDangNhap.IP + "nhanVienDao");
			sanpham_dao = (SanPhamDao) Naming.lookup(FrmDangNhap.IP + "sanPhamDao");
			cthd_dao = (ChiTietHoaDonDao) Naming.lookup(FrmDangNhap.IP + "chiTietHoaDonDao");
			hoadon_dao = (HoaDonDao) Naming.lookup(FrmDangNhap.IP + "hoaDonDao");
			khachhang_dao = (KhachHangDao) Naming.lookup(FrmDangNhap.IP + "khachHangDao");
			banhang_dao = (BanHangDao) Naming.lookup(FrmDangNhap.IP + "banHangDao");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		btnTimKHCu.addActionListener(this);
		btnTaoGioHang.addActionListener(this);
		btnCong.addActionListener(this);
		btnTru.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnTim.addActionListener(this);
		btnHuy.addActionListener(this);
		cmbGioHang.addActionListener(this);
		cmbChon.addActionListener(this);
		btnTaoGioHang.setEnabled(false);
		txtTongTien.setEditable(false);

		docDuLieuDatabaseVaoTableSanPham();
		docDuLieuVaoCmbSDT();
		docDuLieuVaoCmbGioHang();
		docMaSanPhamVaoCmbTim();

		return p;
	}
	
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		new FrmDangNhap().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		try {
			if (o.equals(btnTimKHCu)) {
				String sdtCheck = cmbDanhSachSdt.getSelectedItem().toString();
				if (sdtCheck.trim().length() > 0) {
					if (!(sdtCheck.matches(
							"^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$"))) {
						JOptionPane.showMessageDialog(this, "Số điện thoại không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				txtMaKhachHang.setText(maHDMoiDat);
				if (cmbDanhSachSdt.getItemCount() > 0 && cmbDanhSachSdt.getSelectedIndex() != -1) {
					String sdt = cmbDanhSachSdt.getSelectedItem().toString().trim();
					SortedSet<String> list = khachhang_dao.getTatCaSDTKhachHang();
			
//					List<KhachHang> listKHTrungSDT = new ArrayList<KhachHang>();
//
//					for (KhachHang khachHang : list) {
//						if (khachHang.getSDT().trim().equals(sdt.trim())) {
//							listKHTrungSDT.add(khachHang);
//						}
//					}

					if (list.contains(sdt)) {
						KhachHang kh = khachhang_dao.getKhachHangBySdt(sdt);
						JOptionPane.showMessageDialog(this, "Đây là khách hàng cũ. Welcome back!!!");
						txtTenKhachHang.setText(kh.getTenKH().trim());
						txtCMND.setText(kh.getCMND().trim());
						cmbGioiTinh.setSelectedItem(kh.isGioiTinh() == true ? "Nam" : "Nữ");
						txtNgaySinh.setDate(kh.getNgaySinh());
						txtEmail.setText(kh.getEmail().trim());
						txtDiaChi.setText(kh.getDiaChi().trim());
						txtMaKhachHang.setText(kh.getMaKH().trim());
						btnTaoGioHang.setEnabled(true);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Đây là khách hàng mới. Welcome to our store!!!");
					String maKH;
					List<KhachHang> listKH = khachhang_dao.getTatCaKhachHang();
					if (listKH.size() == 0)
						maKH = "KH1001";
					else {
						String maKHCuoi = listKH.get(listKH.size() - 1).getMaKH().trim();
						int layMaSo = Integer.parseInt(maKHCuoi.substring(2, maKHCuoi.length()));
						maKH = "KH" + (layMaSo + 1);
					}
					txtMaKhachHang.setText(maKH);
					btnTaoGioHang.setEnabled(true);
				}
			}

			if (o.equals(btnTaoGioHang)) {
				// Gán rỗng cho các biến tạm
				if (!maHDMoiDat.equals("")) {
					maHDMoiDat = "";
					maKHDatGioHang = "";
				}
				// Kiểm tra thông tin khách hàng
				if (validInputKhachHang()) {
					// Lấy thông tin khách hàng
					String tenKH = txtTenKhachHang.getText().trim();
					String cmnd = txtCMND.getText().trim();
					String sdt = cmbDanhSachSdt.getSelectedItem().toString();
					Date ngaySinh = txtNgaySinh.getDate();
					String maKH = txtMaKhachHang.getText().trim();
					String email = txtEmail.getText().trim();
					String diaChi = txtDiaChi.getText().trim();
					String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
					java.sql.Date date = new java.sql.Date(ngaySinh.getYear(), ngaySinh.getMonth(), ngaySinh.getDate());

					// Kiểm tra có phải khách hàng cũ
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
					List<KhachHang> listKH = khachhang_dao.getTatCaKhachHang();
					int flag = 0;
					for (KhachHang khachHang : listKH) {
						if (khachHang.getTenKH().trim().equals(tenKH) && khachHang.getCMND().trim().equals(cmnd)
								&& khachHang.getSDT().trim().equals(sdt)
								&& df.format(khachHang.getNgaySinh()).equals(df.format(ngaySinh))
								&& khachHang.isGioiTinh() == (cmbGioiTinh.getSelectedItem() == "Nam" ? true : false)) {
							flag = 1;
							maKHDatGioHang = khachHang.getMaKH().trim();
							break;
						}
					}

					// Thêm nếu là khách hàng mới
					if (flag == 0) {
						maKHDatGioHang = maKH;
						KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh == "Nam" ? true : false, sdt, cmnd, date,
								diaChi, email, true);
//						khachhang_dao.createGioHang(kh);
						khachhang_dao.create(kh);
						JOptionPane.showMessageDialog(this,
								"Thêm khách hàng mới vào trong hệ thống thành công. Welcome!");

						docDuLieuVaoCmbSDT();
						cmbDanhSachSdt.setSelectedIndex(cmbDanhSachSdt.getItemCount() - 1);
					}
					// Tạo lại giỏ hàng
					else {
						KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh == "Nam" ? true : false, sdt, cmnd, date,
								diaChi, email, true);
						khachhang_dao.updateGioHang(kh);
					}
					// Thêm hóa đơn mới
					String maHD;
					List<HoaDon> listHD = hoadon_dao.getTatCaHoaDon();

					if (listHD.size() == 0)
						maHD = "HD1001";
					else {
						String maHDCuoi = listHD.get(listHD.size() - 1).getMaHD().trim();
						int layMaSo = Integer.parseInt(maHDCuoi.substring(2, maHDCuoi.length()));
						maHD = "HD" + (layMaSo + 1);
					}

					HoaDon hd = new HoaDon(maHD, new KhachHang(maKHDatGioHang));

					if (banhang_dao.createGioHang(hd)) {
						maHDMoiDat = hd.getMaHD();
						JOptionPane.showMessageDialog(this, "Tạo giỏ hàng thành công. Time to order!");
					}
					// Cập nhật lại cơ sở dữ liệu và các giao diện liên quan

					docDuLieuVaoCmbGioHang();
					cmbGioHang.setSelectedIndex(cmbGioHang.getItemCount() - 1);

					FrmKhachHang.xoaHetDL();
					FrmKhachHang.docDuLieuDatabaseVaoTable();
					btnTaoGioHang.setEnabled(false);
				}
			}
			if (o.equals(cmbGioHang)) {

//				docDuLieuVaoCmbGioHang();
//				cmbGioHang.setSelectedIndex(cmbGioHang.getItemCount() - 1);
				// ko chắc
				cmbGioHangXuongTable();
			}
			if (o.equals(btnCong)) {
				if (!validInputSoLuong())
					return;
				else {
					int row = tableSanPham.getSelectedRow();
					// Kiểm tra chọn giỏ hàng và sản phẩm cần đặt chưa
					Object giaTriCmb = cmbGioHang.getSelectedItem();
					if (giaTriCmb == null || giaTriCmb.toString().trim().equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng chọn giỏ hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (row != -1 && giaTriCmb != null && !giaTriCmb.toString().trim().equals("")) {
						int soLuongCong = Integer.parseInt(txtSoLuong.getText());
						int soLuongHienTai = Integer.parseInt(modelSanPham.getValueAt(row, 5).toString().trim());
						if (soLuongHienTai < soLuongCong) {
							JOptionPane.showMessageDialog(this, "Không đủ số lượng để đặt", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							// Lấy hóa đơn từ sdt
							String temp = giaTriCmb.toString().trim();
							String sdtTrongCbo = temp.replaceAll("[^0-9]", "").trim();
							HoaDon hoadon = new HoaDon();

							List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
							for (HoaDon hd : listHD) {
								KhachHang kh = khachhang_dao.getKhachHangByMa(hd.getMaKH().getMaKH());
								if(kh.getSDT().equals(sdtTrongCbo.trim())) {
									hoadon = hd;
									break;
								}
							}
							// Lấy sản phẩm từ mã sản phẩm
							String maSP = modelSanPham.getValueAt(row, 0).toString().trim();
							SanPham sanpham = new SanPham();

							List<SanPham> listSP = sanpham_dao.getTatCaSanPham();
							for (SanPham sp : listSP) {
								if (sp.getMaSP().trim().equals(maSP)) {
									sanpham = sp;
									break;
								}
							}
							String giaStr = tableSanPham.getValueAt(row, 4).toString().trim();
							String[] gia = giaStr.split(",");
							String giaTien = "";
							for (int i = 0; i < gia.length; i++) {
								giaTien += gia[i];
							}
							ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon, sanpham, soLuongCong,
									Double.parseDouble(giaTien));
							DecimalFormat df = new DecimalFormat("#,##0");
							int flag = 0;
							int soLuongCu = 0;
							int hangCanSua = 0;
							int rowTableGH = tableGioHang.getRowCount();
							// ktra sản phẩm này có trong giỏ hàng chưa
							for (int i = 0; i < rowTableGH; i++) {
								if (maSP.trim().equals(modelGioHang.getValueAt(i, 0).toString().trim())) {
									flag = 1; // có
									soLuongCu = Integer.parseInt(modelGioHang.getValueAt(i, 5).toString());
									hangCanSua = i;
									break;
								}
							}
							if (flag == 1) {
								ChiTietHoaDon cthdDaco = new ChiTietHoaDon(hoadon, sanpham, soLuongCong + soLuongCu,
										Double.parseDouble(giaTien));
								cthd_dao.updateSoLuong(cthdDaco);
								modelGioHang.setValueAt(soLuongCong + soLuongCu, hangCanSua, 5);
								modelGioHang.setValueAt(df.format(cthdDaco.getThanhTien()), hangCanSua, 6);
							} else {
								cthd_dao.update(cthd);
								modelGioHang.addRow(new Object[] { cthd.getMaSP().getMaSP().trim(),
										cthd.getMaSP().getTenSP().trim(), cthd.getMaSP().getLoaiHang().trim(),
										cthd.getMaSP().getNhaCungCap().trim(), df.format(cthd.getMaSP().getDonGia()),
										cthd.getSoLuong(), df.format(cthd.getThanhTien()) });
							}
							// Set lại bảng danh sách sản phẩm
							sanpham.setSoLuong(soLuongHienTai - soLuongCong);
							sanpham_dao.update(sanpham);
							tableSanPham.setValueAt(soLuongHienTai - soLuongCong, row, 5);
							cmbGioHangXuongTable();
						}
					} else
						JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
				}
			}
			if (o.equals(btnTru)) {
				if (!validInputSoLuong())
					return;
				else {
					int row = tableGioHang.getSelectedRow();
					// Kiểm tra chọn giỏ hàng và sản phẩm cần đặt chưa
					Object giaTriCmb = cmbGioHang.getSelectedItem();
					if (giaTriCmb == null || giaTriCmb.toString().trim().equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng chọn giỏ hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (row != -1 && giaTriCmb != null && !giaTriCmb.toString().trim().equals("")) {
						int soLuongTru = Integer.parseInt(txtSoLuong.getText());

						// Lấy hóa đơn từ sdt
						String temp = giaTriCmb.toString().trim();
						String sdtTrongCbo = temp.replaceAll("[^0-9]", "").trim();
						HoaDon hoadon = new HoaDon();

						List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
						for (HoaDon hd : listHD) {
							KhachHang kh = khachhang_dao.getKhachHangByMa(hd.getMaKH().getMaKH());
							if(kh.getSDT().equals(sdtTrongCbo.trim())) {
								hoadon = hd;
								break;
							}
						}
						// Lấy sản phẩm từ mã sản phẩm
						String maSP = modelGioHang.getValueAt(row, 0).toString().trim();
						SanPham sanpham = new SanPham();

						List<SanPham> listSP = sanpham_dao.getTatCaSanPham();
						for (SanPham sp : listSP) {
							if (sp.getMaSP().trim().equals(maSP)) {
								sanpham = sp;
								break;
							}
						}
						int soLuongHienTai = Integer.parseInt(tableGioHang.getValueAt(row, 5).toString());
						if (soLuongTru > soLuongHienTai) {
							JOptionPane.showMessageDialog(this,
									"Lỗi: Số lượng hủy không được nhiều hơn số lượng đã đặt", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						String giaStr = tableGioHang.getValueAt(row, 4).toString().trim();
						String[] gia = giaStr.split(",");
						String giaTien = "";
						for (int i = 0; i < gia.length; i++) {
							giaTien += gia[i];
						}
						ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon, sanpham, soLuongHienTai - soLuongTru,
								Double.parseDouble(giaTien));
						 cthd_dao.updateSoLuong(cthd); 

						DecimalFormat df = new DecimalFormat("#,##0");
						modelGioHang.setValueAt(soLuongHienTai - soLuongTru, row, 5);
						modelGioHang.setValueAt(df.format(cthd.getThanhTien()), row, 6);

						// Set lại bảng danh sách sản phẩm
						int soLuongSP_hientai = sanpham.getSoLuong();
						sanpham.setSoLuong(soLuongSP_hientai + soLuongTru);
						sanpham_dao.update(sanpham);
						xoaHetDLSanPham();
						docDuLieuDatabaseVaoTableSanPham();

						// Ktra soluong = 0 thì xóa sản phẩm khỏi giỏ hàng
						int soLuongMoi = Integer.parseInt(tableGioHang.getValueAt(row, 5).toString());
						if (soLuongMoi < 1) {
							cthd_dao.delete(sanpham.getMaSP(), hoadon.getMaHD());
							modelGioHang.removeRow(row);
							JOptionPane.showMessageDialog(this, "Xóa sản phẩm " + " khỏi giỏ hàng thành công!");
						}
						// Xóa giỏ hàng
						if (modelGioHang.getRowCount() == 0) {
							if (khachhang_dao.huyGioHang(sdtTrongCbo, false)) {
								if (banhang_dao.delete(hoadon)) {
									JOptionPane.showMessageDialog(this, "Xóa giỏ hàng thành công :((");
									cmbGioHang.removeAllItems();
									docDuLieuVaoCmbGioHang();
								} else
									JOptionPane.showMessageDialog(this, "Xóa giỏ hàng không thành công", "Lỗi",
											JOptionPane.ERROR_MESSAGE);
							} else
								JOptionPane.showMessageDialog(this, "Xóa giỏ hàng không thành công", "Lỗi",
										JOptionPane.ERROR_MESSAGE);

						}
					} else
						JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trong giỏ hàng", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					cmbGioHangXuongTable();
				}
			}
			if (o.equals(btnThanhToan)) {
				Object giaTriCmb = cmbGioHang.getSelectedItem();
				if (giaTriCmb == null || giaTriCmb.toString().trim().equals("") || modelGioHang.getRowCount() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn giỏ hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (giaTriCmb != null && !giaTriCmb.toString().trim().equals("") || modelGioHang.getRowCount() != 0) {
					// Lấy hóa đơn từ sdt
					String temp = giaTriCmb.toString().trim();
					String sdtTrongCbo = temp.replaceAll("[^0-9]", "").trim();
					HoaDon hd = new HoaDon();

					List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
					for (HoaDon hd1 : listHD) {
						KhachHang kh = khachhang_dao.getKhachHangByMa(hd1.getMaKH().getMaKH().trim());
						if(kh.getSDT().trim().equals(sdtTrongCbo.trim())) {
							hd = hd1;
							hd.setMaKH(hd1.getMaKH());
							break;
						}
					}

//					HoaDon hoadon = hoadon_dao.getHoaDonChuaTinhTienDeThanhToan(hoadon_sdt.getMaKH().getMaKH());
//					System.out.println(hoadon_sdt);
					// Get các null
//					NhanVien nv = hoadon_dao.getNhanVienSuDung(FrmDangNhap.getTaiKhoan());
//					String maNV = nv.getMaNV();
//					String maHD = hoadon.getMaHD();
					
					NhanVien nv = nhanvien_dao.getNhanVienById(FrmDangNhap.getTaiKhoan());

					Calendar calendar = Calendar.getInstance();
					Date date = calendar.getTime();
					hd.setNgayLapHoaDon(date);
					hd.setMaHD(hd.getMaHD());

					double tongTien = 0;
					List<ChiTietHoaDon> list = cthd_dao.getCTHDTheoMaHDLenTable(hd.getMaHD());
					for (ChiTietHoaDon cthd : list) {
						tongTien+=cthd.getThanhTien();
					}
					hd.setTongTien(tongTien);
					hd.setMaNV(nv);
//					if (banhang_dao.update(maHD, maNV, date, tongTien) == true) {
					if (banhang_dao.update(hd) == true) {
						JOptionPane.showMessageDialog(this, "Thanh toán thành công. Very good!");
						khachhang_dao.huyGioHang(sdtTrongCbo, false);

						cmbGioHang.removeAllItems();
						docDuLieuVaoCmbGioHang();
						xoaThongTinTrenTextField();
						FrmHoaDon.docDuLieuDatabaseVaoTable();
						KhachHang kh = khachhang_dao.getKhachHangByMa(hd.getMaKH().getMaKH());
						new FrmChiTietHoaDon(kh.getTenKH(), nv.getTenNV(), hd.getMaHD(), date)
								.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(this, "Thanh toán không thành công");
					}
				}

				else {
					JOptionPane.showMessageDialog(this, "Thanh toán không thành công");
				}

			}
			if (o.equals(cmbChon)) {
				if (cmbChon.getSelectedIndex() == 0) {
					docMaSanPhamVaoCmbTim();
				} else if (cmbChon.getSelectedIndex() == 1) {
					docTenSanPhamVaoCmbTim();
				} else if (cmbChon.getSelectedIndex() == 2) {
					docLoaiHangSanPhamVaoCmbTim();
				} else if (cmbChon.getSelectedIndex() == 3) {
					docNhaCungCapSanPhamVaoCmbTim();
				} else if (cmbChon.getSelectedIndex() == 4) {
					docDonGiaSanPhamVaoCmbTim();
				} else if (cmbChon.getSelectedIndex() == 5) {
					docSoLuongTonSanPhamVaoCmbTim();
				}
			}
			if (o.equals(btnTim)) {
				DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
				model.setRowCount(0);
				DecimalFormat df = new DecimalFormat("#,##0");
				if (cmbTim.getSelectedIndex() == 0) {
					docDuLieuDatabaseVaoTableSanPham();
				} else if (cmbChon.getSelectedIndex() == 0) {
					String tim = cmbTim.getSelectedItem().toString().trim();
					List<SanPham> list = sanpham_dao.getTatCaSanPham();
					for (SanPham lk : list) {
						if (lk.getMaSP().trim().equals(tim.trim())) {
							modelSanPham
									.addRow(new Object[] { lk.getMaSP().trim(), lk.getTenSP().trim(), lk.getLoaiHang().trim(),
											lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
						}
					}
				}
				if (cmbChon.getSelectedIndex() == 1) {
					String tim = cmbTim.getSelectedItem().toString().trim();
					List<SanPham> list = sanpham_dao.getTatCaSanPham();
					for (SanPham lk : list) {
						if (lk.getTenSP().trim().equals(tim.trim())) {
							modelSanPham
									.addRow(new Object[] { lk.getMaSP().trim(), lk.getTenSP().trim(), lk.getLoaiHang().trim(),
											lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
						}
					}
				}
				if (cmbChon.getSelectedIndex() == 2) {
					String tim = cmbTim.getSelectedItem().toString().trim();
					List<SanPham> list = sanpham_dao.getTatCaSanPham();
					for (SanPham lk : list) {
						if (lk.getLoaiHang().trim().equals(tim.trim())) {
							modelSanPham
									.addRow(new Object[] { lk.getMaSP().trim(), lk.getTenSP().trim(), lk.getLoaiHang().trim(),
											lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
						}
					}
				}
				if (cmbChon.getSelectedIndex() == 3) {
					String tim = cmbTim.getSelectedItem().toString().trim();
					List<SanPham> list = sanpham_dao.getTatCaSanPham();
					for (SanPham lk : list) {
						if (lk.getNhaCungCap().trim().equals(tim.trim())) {
							modelSanPham
									.addRow(new Object[] { lk.getMaSP().trim(), lk.getTenSP().trim(), lk.getLoaiHang().trim(),
											lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
						}
					}
				}
				if (cmbChon.getSelectedIndex() == 4) {
					String tim = cmbTim.getSelectedItem().toString().trim();
					double d = Double.parseDouble(tim.replaceAll(",", "").trim());
					List<SanPham> list = sanpham_dao.getTatCaSanPham();
					for (SanPham lk : list) {
						if (lk.getDonGia() == d) {
							modelSanPham
									.addRow(new Object[] { lk.getMaSP().trim(), lk.getTenSP().trim(), lk.getLoaiHang().trim(),
											lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
						}
					}
				}
				if (cmbChon.getSelectedIndex() == 5) {
					String tim = cmbTim.getSelectedItem().toString().trim();
					int d = Integer.parseInt(tim.trim());
					List<SanPham> list = sanpham_dao.getTatCaSanPham();
					for (SanPham lk : list) {
						if (lk.getSoLuong() == d) {
							modelSanPham
									.addRow(new Object[] { lk.getMaSP().trim(), lk.getTenSP().trim(), lk.getLoaiHang().trim(),
											lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
						}
					}
				}
			}
			if (o.equals(btnHuy)) {
				xoaThongTinTrenTextField();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	public static void docDuLieuDatabaseVaoTableSanPham() throws RemoteException {
		List<SanPham> listSP = new ArrayList<SanPham>();
		listSP = sanpham_dao.getTatCaSanPham();
		DecimalFormat df = new DecimalFormat("#,##0");
		for (SanPham sp : listSP) {
			modelSanPham.addRow(new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
					sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
		}
	}

	public static void xoaHetDLSanPham() {
		DefaultTableModel dm = (DefaultTableModel) tableSanPham.getModel();
		dm.setRowCount(0);
	}

	public static void docDuLieuVaoCmbSDT() throws RemoteException {
		cmbDanhSachSdt.removeAllItems();
		SortedSet<String> listSDT = khachhang_dao.getTatCaSDTKhachHang();
		cmbDanhSachSdt.addItem("");
		for (String s : listSDT) {
			cmbDanhSachSdt.addItem(s.trim());
		}
	}

	private void docDuLieuVaoCmbGioHang() throws RemoteException {
		cmbGioHang.removeAllItems();
		List<KhachHang> list = banhang_dao.getKhachHangTheoGioHang(true);
		cmbGioHang.addItem("");
		for (KhachHang kh : list) {
			cmbGioHang.addItem(kh.getTenKH().trim() + ", " + kh.getSDT().trim());
		}
	}

	public static void docMaSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sanpham_dao.getTatCaMaSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docTenSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sanpham_dao.getTatCaTenSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docNhaCungCapSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sanpham_dao.getTatCaNhaCungCapSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docLoaiHangSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sanpham_dao.getTatCaLoaiHangSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docDonGiaSanPhamVaoCmbTim() throws RemoteException {
		DecimalFormat df = new DecimalFormat("#,##0");
		cmbTim.removeAllItems();
		SortedSet<Double> list = sanpham_dao.getTatCaDonGiaSanPham();
		cmbTim.addItem("");
		for (Double s : list) {
			cmbTim.addItem(df.format(s));
		}
	}

	public static void docSoLuongTonSanPhamVaoCmbTim() throws RemoteException {
		DecimalFormat df = new DecimalFormat("#");
		cmbTim.removeAllItems();
		SortedSet<Integer> list = sanpham_dao.getTatCaSoLuongTonSanPham();
		cmbTim.addItem("");
		for (Integer s : list) {
			cmbTim.addItem(df.format(s));
		}
	}

	public void xoaThongTinTrenTextField() {
		txtCMND.setText("");
		txtTenKhachHang.setText("");
		txtSoLuong.setText("");
		txtDiaChi.setText("");
		txtMaKhachHang.setText("");
		txtNgaySinh.setDate(new Date(1999 - 1900, 1 - 1, 1));
		txtEmail.setText("");
		cmbGioHang.setSelectedIndex(-1);
		cmbDanhSachSdt.setSelectedIndex(-1);
		cmbGioiTinh.setSelectedIndex(0);
	}

	public void cmbGioHangXuongTable() throws RemoteException {
		Object giaTriCbo = cmbGioHang.getSelectedItem();
		if (giaTriCbo == null || giaTriCbo.toString().trim().equals("")) {

		} else {
			String temp = giaTriCbo.toString().trim();

			String sdtTrongCbo = temp.replaceAll("[^0-9]", "");
			if (giaTriCbo == null || giaTriCbo.toString().trim().equals("")) {
				xoaHetDLGioHang();
			} else {
				if (sdtTrongCbo.trim().equals("")) {

				} else {
					xoaHetDLGioHang();
					// Tìm mã hóa đơn
					String maHD = null;
					List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
					for (HoaDon hd : listHD) {
						KhachHang kh = khachhang_dao.getKhachHangByMa(hd.getMaKH().getMaKH());
						if(kh.getSDT().equals(sdtTrongCbo.trim())) {
							maHD = hd.getMaHD();
							break;
						}
					}
					// Hiện lên bảng và txt
					Double tongTien = 0.0;
					DecimalFormat df = new DecimalFormat("#,##0");
					List<ChiTietHoaDon> listHDSP = cthd_dao.getCTHDTheoMaHDLenTable(maHD);
					for (ChiTietHoaDon cthd : listHDSP) {
						SanPham sp = sanpham_dao.getSanPhamByMa(cthd.getMaSP().getMaSP());
//						modelGioHang.addRow(new Object[] { cthd.getMaSP().getMaSP().trim(),
//								cthd.getMaSP().getTenSP().trim(), cthd.getMaSP().getLoaiHang().trim(),
//								cthd.getMaSP().getNhaCungCap().trim(), df.format(cthd.getMaSP().getDonGia()),
//								cthd.getSoLuong(), df.format(cthd.getThanhTien()) });
//						tongTien += cthd.getThanhTien();
						modelGioHang.addRow(new Object[] { sp.getMaSP().trim(),
								sp.getTenSP().trim(), sp.getLoaiHang().trim(),
								sp.getNhaCungCap().trim(), df.format(sp.getDonGia()),
								cthd.getSoLuong(), df.format(cthd.getThanhTien()) });
						tongTien += cthd.getThanhTien();
					}
					if (tongTien == 0)
						txtTongTien.setText("0.0 VNĐ");
					else
						txtTongTien.setText(df.format(tongTien) + " VNĐ");
				}
				// Điền textfield
				List<KhachHang> list = khachhang_dao.getTatCaKhachHang();

				List<KhachHang> listKHTrungSDT = new ArrayList<KhachHang>();

				for (KhachHang khachHang : list) {
					if (khachHang.getSDT().trim().equals(sdtTrongCbo.trim())) {
						listKHTrungSDT.add(khachHang);
					}
				}

				if (listKHTrungSDT.size() == 1) {
					KhachHang kh = listKHTrungSDT.get(0);
					txtTenKhachHang.setText(kh.getTenKH().trim());
					txtCMND.setText(kh.getCMND().trim());
					cmbGioiTinh.setSelectedItem(kh.isGioiTinh() == true ? "Nam" : "Nữ");
					txtNgaySinh.setDate(kh.getNgaySinh());
					txtEmail.setText(kh.getEmail().trim());
					txtDiaChi.setText(kh.getDiaChi().trim());
					txtMaKhachHang.setText(kh.getMaKH().trim());
					btnTaoGioHang.setEnabled(true);
				}
			}
		}
	}

	private void xoaHetDLGioHang() {
		DefaultTableModel dm = (DefaultTableModel) tableGioHang.getModel();
		dm.setRowCount(0);
	}

	private boolean validInputSoLuong() {
		String soLuong = txtSoLuong.getText();
		if (soLuong.trim().length() > 0) {
			try {
				int x = Integer.parseInt(soLuong);
				if (x <= 0) {
					JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error: Số lượng phải nhập số", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtSoLuong.requestFocus();
			return false;
		}
		return true;
	}

	private boolean validInputKhachHang() {
		// TODO Auto-generated method stub
		String maKH = txtMaKhachHang.getText();
		String tenKH = txtTenKhachHang.getText();
		String sdt = cmbDanhSachSdt.getSelectedItem().toString();
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String cmnd = txtCMND.getText();

		if (tenKH.trim().length() > 0) {
			if (!(tenKH.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)0-9]+"))) {
				JOptionPane.showMessageDialog(this, "Tên khách hàng phải là ký tự chữ", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (sdt.trim().length() > 0) {
			if (!(sdt.matches(
					"^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (cmnd.trim().length() > 0) {
			if (!(cmnd.matches("\\d{9}"))) {
				JOptionPane.showMessageDialog(this, "CMND không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "CMND không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (email.trim().length() > 0) {
			if (!(email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$"))) {
				JOptionPane.showMessageDialog(this, "Email không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Email không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (diaChi.trim().length() > 0) {
			if (!(diaChi.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
