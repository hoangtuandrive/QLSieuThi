package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

public class FrmNhanVien extends javax.swing.JFrame {
	private Boolean isQuanLy;
	private JComboBox<String> cmbChon;
	private static JComboBox<String> cmbTim;
	private JButton btnTim;

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	public JPanel createPanelNhanVien() {
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
		btnTim = new JButton("TÌM KIẾM",new ImageIcon("image/timkiem.png"));
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

//		txtMaNhanVien.setEditable(false);
//		txtTrangThai.setEditable(false);

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

//		if (!isQuanLy) {
//			btnThem.setEnabled(false);
//			btnSua.setEnabled(false);
//			btnXoa.setEnabled(false);
//		}

		tableNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableNhanVien.setDefaultEditor(Object.class, null);
		tableNhanVien.getTableHeader().setReorderingAllowed(false);


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

	// End of variables declaration//GEN-END:variables


}