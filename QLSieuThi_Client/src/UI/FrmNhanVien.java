package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;

import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;

public class FrmNhanVien extends javax.swing.JFrame implements ActionListener, MouseListener {
	private Boolean isQuanLy;
	private JComboBox<String> cmbChon;
	private static JComboBox<String> cmbTim;
	private JButton btnTim;
	private static NhanVienDao nhanvien_dao;
	private TaiKhoanDao tk_dao;

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	public JPanel createPanelNhanVien() throws RemoteException {
		FlatLightLaf.setup();
		pntblNhanVien = new javax.swing.JScrollPane();
		tableNhanVien = new javax.swing.JTable();
		pnlTimKiem = new javax.swing.JPanel();
		pnThongTin = new javax.swing.JPanel();
		lblmaNhanVien = new java.awt.Label();
		txtMaNhanVien = new javax.swing.JTextField();
		lblTen = new java.awt.Label();
		txtTen = new javax.swing.JTextField();
		lblNgaySinh = new java.awt.Label();
		txtNgaySinh = new JDateChooser();
		lblCMND = new java.awt.Label();
		txtCMND = new javax.swing.JTextField();
		lblGioiTinh = new java.awt.Label();
		cmbGioiTinh = new javax.swing.JComboBox<String>();
		lblSDT = new java.awt.Label();
		txtSDT = new javax.swing.JTextField();
		lblChucVu = new java.awt.Label();
		cmbChucVu = new javax.swing.JComboBox<String>();
		lblLuong = new java.awt.Label();
		txtLuong = new javax.swing.JTextField();
		lblEmail = new java.awt.Label();
		txtEmail = new javax.swing.JTextField();
		lblDiaChi = new java.awt.Label();
		txtDiaChi = new javax.swing.JTextField();
		lblTrangThai = new java.awt.Label();
		txtTrangThai = new javax.swing.JTextField();
		pnChucNang = new javax.swing.JPanel();
		btnThem = new javax.swing.JButton();
		btnSua = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();

		pnThongTin.setBackground(new Color(219, 243, 255));
		pnChucNang.setBackground(new Color(219, 243, 255));
		btnThem.setBackground(new Color(0, 148, 224));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFocusPainted(false);
		btnSua.setBackground(new Color(0, 148, 224));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFocusPainted(false);
		btnXoa.setBackground(new Color(0, 148, 224));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFocusPainted(false);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		String[] header = { "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "CMND", "Giới Tính", "SDT", "Chức Vụ",
				"Email", "Địa Chỉ", "Lương", "Trạng thái" };
		modelNhanVien = new javax.swing.table.DefaultTableModel(header, 0);
		tableNhanVien = new JTable(modelNhanVien) {
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
		tableNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableNhanVien.setGridColor(getBackground());
		tableNhanVien.setRowHeight(tableNhanVien.getRowHeight() + 20);
		tableNhanVien.setSelectionBackground(new Color(255, 255, 128));
		tableNhanVien.setSelectionForeground(Color.BLACK);
		JTableHeader tableHeader = tableNhanVien.getTableHeader();
		tableHeader.setBackground(new Color(0, 148, 224));
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setPreferredSize(new Dimension(WIDTH, 30));
		pntblNhanVien.add(new JScrollPane(tableNhanVien));

		pntblNhanVien.setViewportView(tableNhanVien);
		tableNhanVien.getColumnModel().getSelectionModel()
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		pnThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết:"));
		pnThongTin.setToolTipText("Info of selected table object");

		lblmaNhanVien.setText("Mã nhân viên:");
		lblTen.setText("Tên nhân viên:");
		lblNgaySinh.setText("Ngày sinh:");
		lblCMND.setText("CMND:");
		lblGioiTinh.setText("Giới tính:");
		lblSDT.setText("SDT:");
		lblChucVu.setText("Chức vụ:");
		lblEmail.setText("Email:");
		lblDiaChi.setText("Địa chỉ:");
		lblLuong.setText("Lương:");
		lblTrangThai.setText("Trạng Thái:");

		txtNgaySinh.setDateFormatString("yyyy-MM-dd");
		txtNgaySinh.setDate(new Date(1999 - 1900, 1 - 1, 1));

		String[] gioitinh = { "Nam", "Nữ" };
		cmbGioiTinh = new JComboBox<String>(gioitinh);

		String[] chucvu = { "Nhân Viên", "Quản Lý" };
		cmbChucVu = new JComboBox<String>(chucvu);

		javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
		pnThongTin.setLayout(pnThongTinLayout);
		pnThongTinLayout.setHorizontalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblCMND, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblmaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnThongTinLayout.createSequentialGroup().addComponent(txtMaNhanVien,
										javax.swing.GroupLayout.PREFERRED_SIZE, 169,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(cmbChucVu, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cmbGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtCMND, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		pnThongTinLayout.setVerticalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup().addContainerGap().addGroup(pnThongTinLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblmaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCMND, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cmbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(28, Short.MAX_VALUE)));

		pnChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng:"));

		btnThem.setText("THÊM");
		btnSua.setText("SỬA");
		btnXoa.setText("CHO NGHỈ VIỆC");

		javax.swing.GroupLayout pnChucNangLayout = new javax.swing.GroupLayout(pnChucNang);
		pnChucNang.setLayout(pnChucNangLayout);
		pnChucNangLayout.setHorizontalGroup(pnChucNangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChucNangLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnThem)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnSua)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnXoa)
						.addGap(48, 48, 48)));
		pnChucNangLayout.setVerticalGroup(pnChucNangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnChucNangLayout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThem).addComponent(btnSua).addComponent(btnXoa))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		Box b = Box.createHorizontalBox();
		String[] tim = { "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "SDT", "Chức Vụ", "Lương", "CMND", "Ngày Sinh",
				"Địa Chỉ", "Email", "Trạng thái" };
		cmbChon = new JComboBox<String>(tim);
		cmbTim = new JComboBox<String>();
		cmbTim.setEditable(true);
		AutoCompleteDecorator.decorate(cmbTim);
		cmbTim.setMaximumRowCount(10);
		cmbChon.setSize(20, cmbTim.getPreferredSize().height);
		btnTim = new JButton("TÌM KIẾM", new ImageIcon("image/timkiem.png"));
		btnTim.setBackground(new Color(0, 148, 224));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFocusPainted(false);

		b.add(cmbChon);
		b.add(Box.createHorizontalStrut(10));
		b.add(cmbTim);
		b.add(Box.createHorizontalStrut(10));
		b.add(btnTim);
		b.add(Box.createHorizontalStrut(30));
		pnlTimKiem.add(b);

		JPanel panel = new JPanel();
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		panel.add(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(pntblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
								.addComponent(pnlTimKiem))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(pnChucNang,
										javax.swing.GroupLayout.PREFERRED_SIZE, 300,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(pntblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 720,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();

		 txtMaNhanVien.setEditable(false);
		 txtTrangThai.setEditable(false);

		tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(110);

		pntblNhanVien.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DANH SÁCH NHÂN VIÊN: "));
		lblmaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbChon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));

		// if (!isQuanLy) {
		// btnThem.setEnabled(false);
		// btnSua.setEnabled(false);
		// btnXoa.setEnabled(false);
		// }

		tableNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableNhanVien.setDefaultEditor(Object.class, null);
		tableNhanVien.getTableHeader().setReorderingAllowed(false);

		try {
			nhanvien_dao = (NhanVienDao) Naming.lookup(FrmDangNhap.IP + "nhanVienDao");
			tk_dao = (TaiKhoanDao) Naming.lookup(FrmDangNhap.IP + "taiKhoanDao");
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
		
		String xacDinhDangNhap = FrmDangNhap.getTaiKhoan();
		if (xacDinhDangNhap.substring(0, 2).equals("QL"))
			isQuanLy = true;
		else
			isQuanLy = false;
		
		if (!isQuanLy) {
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
		}

		docDuLieuDatabaseVaoTable();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		docMaNhanVienVaoCmbTim();
		cmbChon.addActionListener(this);
		cmbTim.addActionListener(this);
		btnTim.addActionListener(this);
		return panel;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXoa;
	private java.awt.Label lblCMND;
	private java.awt.Label lblChucVu;
	private java.awt.Label lblGioiTinh;
	private java.awt.Label lblNgaySinh;
	private java.awt.Label lblSDT;
	private java.awt.Label lblTen;
	private java.awt.Label lblEmail;
	private java.awt.Label lblDiaChi;
	private java.awt.Label lblLuong;
	private java.awt.Label lblmaNhanVien;
	private java.awt.Label lblTrangThai;
	private javax.swing.JPanel pnChucNang;
	private javax.swing.JPanel pnThongTin;
	private javax.swing.JScrollPane pntblNhanVien;
	private static javax.swing.JTable tableNhanVien;
	private javax.swing.JTextField txtCMND;
	private JComboBox<String> cmbChucVu;
	private JComboBox<String> cmbGioiTinh;
	private javax.swing.JTextField txtMaNhanVien;
	private JDateChooser txtNgaySinh;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtTen;
	private javax.swing.JTextField txtLuong;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtTrangThai;
	private JPanel pnlTimKiem;
	private static DefaultTableModel modelNhanVien;

	private void emptyTextField() {
		txtMaNhanVien.setText(null);
		txtTen.setText(null);
		txtNgaySinh.setDate(null);
		txtCMND.setText(null);
		cmbGioiTinh.setSelectedIndex(0);
		txtSDT.setText(null);
		cmbChucVu.setSelectedIndex(0);
		txtEmail.setText(null);
		txtDiaChi.setText(null);
		txtLuong.setText(null);
	}

	public void docDuLieuDatabaseVaoTable() throws RemoteException {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		List<NhanVien> listNV = new ArrayList<NhanVien>();
		try {
			listNV = nhanvien_dao.getTatCaNhanVien();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DecimalFormat df = new DecimalFormat("#,##0");
		for (NhanVien nv : listNV) {
			modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
					format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
					nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
					df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
		}

	}

	public static void xoaHetDL() {
		DefaultTableModel dm = (DefaultTableModel) tableNhanVien.getModel();
		dm.setRowCount(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNhanVien.getSelectedRow();
		txtMaNhanVien.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtTen.setText(modelNhanVien.getValueAt(row, 1).toString());
		String dateString = modelNhanVien.getValueAt(row, 2).toString();
		String[] a = dateString.split("-");
		 txtNgaySinh
		 .setDate(new Date(Integer.parseInt(a[0]) - 1900, Integer.parseInt(a[1]) - 1,
		 Integer.parseInt(a[2])));

		txtCMND.setText(modelNhanVien.getValueAt(row, 3).toString());
		cmbGioiTinh.setSelectedItem(FrmNhanVien.modelNhanVien.getValueAt(row, 4).toString().trim());
		txtSDT.setText(modelNhanVien.getValueAt(row, 5).toString());
		cmbChucVu.setSelectedItem(FrmNhanVien.modelNhanVien.getValueAt(row, 6).toString().trim());
		txtEmail.setText(modelNhanVien.getValueAt(row, 7).toString());
		txtDiaChi.setText(modelNhanVien.getValueAt(row, 8).toString());
		String luong[] = modelNhanVien.getValueAt(row, 9).toString().split(",");
		String tienLuong = "";
		for (int i = 0; i < luong.length; i++)
			tienLuong += luong[i];
		txtLuong.setText(tienLuong);
		txtTrangThai.setText(modelNhanVien.getValueAt(row, 10).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (!validInput()) {
				return;
			} else {
				String maNV="";
				List<NhanVien> listNV = new ArrayList<NhanVien>();
				try {
					listNV = nhanvien_dao.getTatCaNhanVien();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				if (listNV.size() == 0)
//					maNV = "NV1001";
//				else {
//					String maNVCuoi = listNV.get(listNV.size() - 1).getMaNV().trim();
//					int layMaSo = Integer.parseInt(maNVCuoi.substring(2, maNVCuoi.length()));
//					maNV = "NV" + (layMaSo + 1);
//				}
				String tenNV = txtTen.getText();
				String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
				String CMND = txtCMND.getText();
				String SDT = txtSDT.getText();
				String chucVu = cmbChucVu.getSelectedItem().toString();
				String diaChi = txtDiaChi.getText();
				String email = txtEmail.getText();
				double luong = Double.parseDouble(txtLuong.getText());
				Date ngaySinh = txtNgaySinh.getDate();
				java.sql.Date date = new java.sql.Date(ngaySinh.getYear(), ngaySinh.getMonth(), ngaySinh.getDate());

				if (chucVu.equals("Nhân Viên") || chucVu.equals("Quản Lý")) {
					if (chucVu.equals("Nhân Viên"))
						if (listNV.size() == 0)
							maNV = "NV1001";
						else {
							String maNVCuoi = listNV.get(listNV.size()-1).getMaNV().trim();
							int layMaSo = Integer.parseInt(maNVCuoi.substring(2, maNVCuoi.length()));
							System.out.println(maNVCuoi.substring(2,maNVCuoi.length()));
							maNV = "NV" + (layMaSo + 1);
							try {
								SortedSet<String> listMa = nhanvien_dao.getTatCaMaNhanVien();
								if(listMa.contains(maNV)) {
									System.out.println("check");
									maNV = "NV" + (layMaSo + 2);
								}
							} catch (RemoteException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
						}
					else if (listNV.size() == 0)
						maNV = "QL1001";
					else {
						String maNVCuoi = listNV.get(listNV.size() - 1).getMaNV().trim();
						int layMaSo = Integer.parseInt(maNVCuoi.substring(2, maNVCuoi.length()));
						maNV = "QL" + (layMaSo + 1);
						try {
							SortedSet<String> listMa = nhanvien_dao.getTatCaMaNhanVien();
							if(listMa.contains(maNV)) {
								System.out.println("check");
								maNV = "QL" + (layMaSo + 2);
							}
						} catch (RemoteException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
					}
					System.out.println(maNV);
					TaiKhoan tk = new TaiKhoan(maNV, "123");
					NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh == "Nam" ? true : false, SDT, chucVu, luong, CMND,
							date, diaChi, email, true, tk);
					tk.setMaNV(nv);

					try {
						nhanvien_dao.addNhanVien(nv);
						JOptionPane.showMessageDialog(null, "Thành Công");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Thất Bại");
					}
					try {
						tk_dao.create(tk);
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					xoaHetDL();
					try {
						docDuLieuDatabaseVaoTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				tableNhanVien.getSelectionModel().clearSelection();
				emptyTextField();
			}
		}
		if (o.equals(btnSua)) {
			String maNV = txtMaNhanVien.getText();
			String tenNV = txtTen.getText();
			String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
			String CMND = txtCMND.getText();
			String SDT = txtSDT.getText();
			String chucVu = cmbChucVu.getSelectedItem().toString();
			String diaChi = txtDiaChi.getText();
			String email = txtEmail.getText();
			double luong = Double.parseDouble(txtLuong.getText());
			Date ngaySinh = txtNgaySinh.getDate();
			java.sql.Date date = new java.sql.Date(ngaySinh.getYear(), ngaySinh.getMonth(), ngaySinh.getDate());
			Boolean trangThai = null;
			if (txtTrangThai.getText().equalsIgnoreCase("Đã nghỉ việc")) {
				trangThai = false;
			} else
				trangThai = true;
			if (!validInput()) {
				return;
			} else {
				TaiKhoan tk = new TaiKhoan(maNV, "123");
				NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh == "Nam" ? true : false, SDT, chucVu, luong, CMND,
						date, diaChi, email, trangThai, tk);
				tk.setMaNV(nv);
				try {
					nhanvien_dao.updateNV(nv);

					JOptionPane.showMessageDialog(null, "Thanh Cong");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "That Bai");
				}

				xoaHetDL();
				try {
					docDuLieuDatabaseVaoTable();

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				tableNhanVien.getSelectionModel().clearSelection();
			}

		}
		if (o.equals(btnXoa)) {
			int r = tableNhanVien.getSelectedRow();
			String maNV = modelNhanVien.getValueAt(r, 0).toString();
			List<NhanVien> listNV = new ArrayList<NhanVien>();
			try {
				listNV = nhanvien_dao.getTatCaNhanVien();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String tenTaiKhoan = "";
			for (NhanVien nv : listNV) {
				if (nv.getMaNV().equalsIgnoreCase(maNV)) {
					tenTaiKhoan = nv.getTaiKhoan().getTenDN();
					break;
				}
			}
			try {
				nhanvien_dao.delete(maNV);
				tk_dao.delete(maNV);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			xoaHetDL();
			try {
				docDuLieuDatabaseVaoTable();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (o.equals(cmbChon)) {
			if (cmbChon.getSelectedIndex() == 0) {
				try {
					docMaNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 1) {
				try {
					docTenNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 2) {
				try {
					docGioiTinhNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 3) {
				try {
					docSDTNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 4) {
				try {
					docChucVuNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 5) {
				try {
					docLuongNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 6) {
				try {
					docCMNDNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 7) {
				try {
					docNgaySinhNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 8) {
				try {
					docDiaChiNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 9) {
				try {
					docEmailNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 10) {
				try {
					docTrangThaiNhanVienVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (o.equals(btnTim)) {
			DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
			model.setRowCount(0);
			DecimalFormat df = new DecimalFormat("#,##0");
			if (cmbTim.getSelectedIndex() == 0) {
				try {
					docDuLieuDatabaseVaoTable();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 0) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getMaNV().trim().equals(tim.trim())) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 1) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getTenNV().trim().equals(tim.trim())) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 2) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				Boolean b = null;
				if (tim == "Nam") {
					b = true;
				} else if (tim == "Nữ") {
					b = false;
				}
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getGioiTinh().equals(b)) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			} else if (cmbChon.getSelectedIndex() == 3) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getSDT().trim().equals(tim.trim())) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (cmbChon.getSelectedIndex() == 4) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getChucVu().trim().equals(tim.trim())) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (cmbChon.getSelectedIndex() == 5) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				double d = Double.parseDouble(tim.replaceAll(",", "").trim());
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getLuong() == d) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (cmbChon.getSelectedIndex() == 6) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getCMND().trim().equals(tim.trim())) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (cmbChon.getSelectedIndex() == 7) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				String[] a = tim.split("-");
				Date d = new Date(Integer.parseInt(a[0]) - 1900, Integer.parseInt(a[1]) - 1, Integer.parseInt(a[2]));
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getNgaySinh().compareTo(d)==0) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (cmbChon.getSelectedIndex() == 8) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getDiaChi().trim().equals(tim.trim())) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (cmbChon.getSelectedIndex() == 9) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getEmail().trim().equals(tim.trim())) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			} else if (cmbChon.getSelectedIndex() == 10) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				Boolean b = null;
				if (tim == "Đang làm") {
					b = true;
				} else if (tim == "Đã nghỉ việc") {
					b = false;
				}
				List<NhanVien> list;
				try {
					list = nhanvien_dao.getTatCaNhanVien();
					for (NhanVien nv : list) {
						if (nv.getTrangThai().equals(b)) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							modelNhanVien.addRow(new Object[] { nv.getMaNV().trim(), nv.getTenNV().trim(),
									format1.format(nv.getNgaySinh()), nv.getCMND().trim(), nv.getGioiTinh() == true ? "Nam" : "Nữ",
									nv.getSDT().trim(), nv.getChucVu().trim(), nv.getEmail().trim(), nv.getDiaChi().trim(),
									df.format(nv.getLuong()), nv.getTrangThai() ? "Đang làm" : "Đã nghỉ việc" });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		}
	}

	// End of variables declaration//GEN-END:variables
	private boolean validInput() {
		// TODO Auto-generated method stub
		String ma = txtMaNhanVien.getText();
		String ten = txtTen.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String cmnd = txtCMND.getText();

		if (ten.trim().length() > 0) {
			if (!(ten.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)0-9]+"))) {
				JOptionPane.showMessageDialog(this, "Tên nhân viên phải là ký tự chữ", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

	public static void docMaNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = nhanvien_dao.getTatCaMaNhanVien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docTenNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = nhanvien_dao.getTatCaTenNhanVien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docGioiTinhNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<Boolean> list = nhanvien_dao.getTatCaGioiTinhNhanVien();
		cmbTim.addItem("");
		for (Boolean s : list) {
			cmbTim.addItem(s == true ? "Nam" : "Nữ");
		}
	}

	public static void docSDTNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = nhanvien_dao.getTatCaSDTNhanVien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docChucVuNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = nhanvien_dao.getTatCaChucVuNhanVien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docLuongNhanVienVaoCmbTim() throws RemoteException {
		DecimalFormat df = new DecimalFormat("#,##0");
		cmbTim.removeAllItems();
		SortedSet<Double> list = nhanvien_dao.getTatCaLuongNhanVien();
		cmbTim.addItem("");
		for (Double s : list) {
			cmbTim.addItem(df.format(s));
		}
	}

	public static void docCMNDNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = nhanvien_dao.getTatCaCMNDNhanVien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docNgaySinhNhanVienVaoCmbTim() throws RemoteException {
		SimpleDateFormat date = new SimpleDateFormat("yyy-MM-dd");
		cmbTim.removeAllItems();
		SortedSet<Date> list = nhanvien_dao.getTatCaNgaySinhNhanVien();
		cmbTim.addItem("");
		for (Date s : list) {
			cmbTim.addItem(date.format(s));
		}
	}

	public static void docDiaChiNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = nhanvien_dao.getTatCaDiaChiNhanVien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docEmailNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = nhanvien_dao.getTatCaEmailNhanVien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docTrangThaiNhanVienVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<Boolean> list = nhanvien_dao.getTatCaTrangThaiNhanVien();
		cmbTim.addItem("");
		for (Boolean s : list) {
			cmbTim.addItem(s == true ? "Đang làm" : "Đã nghỉ việc");
		}
	}
}
