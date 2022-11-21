/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.formdev.flatlaf.FlatLightLaf;

import dao.SanPhamDao;


import entity.SanPham;

/**
 *
 * @author ACER
 */
public class FrmSanPham extends javax.swing.JFrame implements ActionListener, MouseListener {

	private JComboBox<String> cmbChon;
	private static JComboBox<String> cmbTim;
	private JButton btnTim;
	private static SanPhamDao sp_dao;

	public JPanel createPanelSanPham() throws RemoteException {
		FlatLightLaf.setup();
		pntblHangHoa = new javax.swing.JScrollPane();
		tableHangHoa = new javax.swing.JTable();
		pnlTimKiem = new javax.swing.JPanel();
		pnThongTin = new javax.swing.JPanel();
		lblMaHangHoa = new java.awt.Label();
		txtMaHangHoa = new javax.swing.JTextField();
		lblTenHangHoa = new java.awt.Label();
		txtTenHangHoa = new javax.swing.JTextField();
		lblLoaiHang = new java.awt.Label();
		txtLoaiHang = new javax.swing.JTextField();
		lblNhaCungCap = new java.awt.Label();
		txtNhaCungCap = new javax.swing.JTextField();
		lblDonGia = new java.awt.Label();
		txtDonGia = new javax.swing.JTextField();
		lblSoLuong = new java.awt.Label();
		txtSoLuong = new javax.swing.JTextField();

		pnChucNang = new javax.swing.JPanel();
		btnThem = new javax.swing.JButton();
		btnSua = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		String[] header = { " Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Hàng", "Nhà Cung Cấp", "Đơn Giá", "Số Lượng Tồn" };
		modelSanPham = new javax.swing.table.DefaultTableModel(header, 0);
		tableHangHoa = new JTable(modelSanPham) {
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
		tableHangHoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableHangHoa.setGridColor(getBackground());
		tableHangHoa.setRowHeight(tableHangHoa.getRowHeight() + 20);
		tableHangHoa.setSelectionBackground(new Color(255, 255, 128));
		tableHangHoa.setSelectionForeground(Color.BLACK);
		JTableHeader tableHeader = tableHangHoa.getTableHeader();
		tableHeader.setBackground(new Color(0, 148, 224));
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setPreferredSize(new Dimension(WIDTH, 30));
		tableHangHoa.setColumnSelectionAllowed(false);
		tableHangHoa.setName("tblThongTinNhanVien"); // NOI18N
		pntblHangHoa.setViewportView(tableHangHoa);
		tableHangHoa.getColumnModel().getSelectionModel()
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		pnThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết:"));
		pnThongTin.setToolTipText("Info of selected table object");

		lblMaHangHoa.setText("Mã Sản Phẩm:");

		lblTenHangHoa.setText("Tên Sản Phẩm:");

		lblLoaiHang.setText("Loại hàng");

		lblNhaCungCap.setText("Nhà cung cấp");

		lblDonGia.setText("Đơn giá");

		lblSoLuong.setText("Số lượng");

		javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
		pnThongTin.setLayout(pnThongTinLayout);
		pnThongTinLayout.setHorizontalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnThongTinLayout.createSequentialGroup().addComponent(txtMaHangHoa,
										javax.swing.GroupLayout.PREFERRED_SIZE, 169,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTenHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtLoaiHang, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		pnThongTinLayout.setVerticalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup().addContainerGap().addGroup(pnThongTinLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtMaHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtTenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(28, Short.MAX_VALUE)));

		pnChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng:"));

		btnThem.setText("THÊM");
		btnSua.setText("SỬA");
		btnXoa.setText("XÓA");

		btnThem.setBackground(new Color(0, 148, 224));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFocusPainted(false);
		btnSua.setBackground(new Color(0, 148, 224));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFocusPainted(false);
		btnXoa.setBackground(new Color(0, 148, 224));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFocusPainted(false);

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
				.addGroup(pnChucNangLayout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThem).addComponent(btnSua).addComponent(btnXoa))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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

		Box b = Box.createHorizontalBox();
		String[] tim = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Hàng", "Nhà Cung Cấp", "Đơn Giá", "Số Lượng Tồn" };
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
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pntblHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
								.addComponent(pnlTimKiem))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout
										.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
										.addComponent(pnChucNang, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(pntblHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 670,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(2, 2, 2))
						.addGroup(layout.createSequentialGroup().addGap(14, 14, 14)
								.addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnChucNang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 27, Short.MAX_VALUE)))
						.addContainerGap()));

		pack();

		pntblHangHoa.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DANH SÁCH SẢN PHẨM: "));
		lblMaHangHoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMaHangHoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenHangHoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTenHangHoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLoaiHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDonGia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbChon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		tableHangHoa.setFont(new Font("Tahoma", Font.PLAIN, 14));

		tableHangHoa.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableHangHoa.getColumnModel().getColumn(1).setPreferredWidth(165);

		txtMaHangHoa.setEditable(false);

		tableHangHoa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHangHoa.setDefaultEditor(Object.class, null);
		tableHangHoa.getTableHeader().setReorderingAllowed(false);

		try {
			sp_dao = (SanPhamDao) Naming.lookup(FrmDangNhap.IP + "sanPhamDao");

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

		docDuLieuDatabaseVaoTable();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		tableHangHoa.addMouseListener(this);

		docMaSanPhamVaoCmbTim();
		cmbChon.addActionListener(this);
		cmbTim.addActionListener(this);
		btnTim.addActionListener(this);

		return panel;
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrmDangNhap().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXoa;
	private java.awt.Label lblDonGia;
	private java.awt.Label lblNhaCungCap;
	private java.awt.Label lblSoLuong;
	private java.awt.Label lblTenHangHoa;
	private java.awt.Label lblLoaiHang;
	private java.awt.Label lblMaHangHoa;
	private javax.swing.JPanel pnChucNang;
	private javax.swing.JPanel pnThongTin;
	private javax.swing.JScrollPane pntblHangHoa;
	private static javax.swing.JTable tableHangHoa;
	private javax.swing.JTextField txtDonGia;
	private javax.swing.JTextField txtNhaCungCap;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtTenHangHoa;
	private javax.swing.JTextField txtLoaiHang;
	private JPanel pnlTimKiem;
	private javax.swing.JTextField txtMaHangHoa;
	private static DefaultTableModel modelSanPham;

	// End of variables declaration//GEN-END:variables

	public static void xoaHetDL() {
		DefaultTableModel dm = (DefaultTableModel) tableHangHoa.getModel();
		dm.setRowCount(0);
	}

	private boolean validInput() {
		String tenLk = txtTenHangHoa.getText();
		String loaiHang = txtLoaiHang.getText();
		String nhaCC = txtNhaCungCap.getText();
		String gialk = txtDonGia.getText();
		String soLuong = txtSoLuong.getText();
		if (tenLk.trim().length() > 0) {
			if (!(tenLk.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Tên Sản Phẩm không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên Sản Phẩm không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (loaiHang.trim().length() > 0) {
			if (!(tenLk.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Tên loại hàng không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên loại hàng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (nhaCC.trim().length() > 0) {
			if (!(tenLk.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Tên nhà cung cấp không chứa ký tự đặc biệt", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên cung cấp không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (gialk.trim().length() > 0) {
			try {
				double x = Double.parseDouble(gialk);
				if (x <= 0) {
					JOptionPane.showMessageDialog(this, "Giá Sản Phẩm phải lớn hơn 0", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error: Giá Sản Phẩm phải nhập số", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Giá Sản Phẩm không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
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
			JOptionPane.showMessageDialog(this, "Số lượng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public void docDuLieuDatabaseVaoTable() throws RemoteException {
		List<SanPham> listsp = new ArrayList<SanPham>();
		listsp = sp_dao.getTatCaSanPham();
//		DecimalFormat df = new DecimalFormat("#,##0.0");
		DecimalFormat df = new DecimalFormat("#,##0");
		for (SanPham sp : listsp) {
			modelSanPham.addRow(new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
					sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableHangHoa.getSelectedRow();
		txtMaHangHoa.setText(modelSanPham.getValueAt(row, 0).toString());
		txtTenHangHoa.setText(modelSanPham.getValueAt(row, 1).toString());
		txtLoaiHang.setText(modelSanPham.getValueAt(row, 2).toString());
		txtNhaCungCap.setText(modelSanPham.getValueAt(row, 3).toString());
		String tien[] = modelSanPham.getValueAt(row, 4).toString().split(",");
		String donGia = "";
		for (int i = 0; i < tien.length; i++)
			donGia += tien[i];
		txtDonGia.setText(donGia);
		txtSoLuong.setText(modelSanPham.getValueAt(row, 5).toString());

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
				String masp;
				List<SanPham> listsp = null;
				try {
					listsp = sp_dao.getTatCaSanPham();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (listsp.size() == 0)
					masp = "SP1001";
				else {
					String maspcu = listsp.get(listsp.size() - 1).getMaSP().trim();
					int layMaSo = Integer.parseInt(maspcu.substring(2, maspcu.length()));
					masp = "SP" + (layMaSo + 1);
				}
				String tensp = txtTenHangHoa.getText();
				String loaiHang = txtLoaiHang.getText();
				String nhaCungCap = txtNhaCungCap.getText();
				int soLuong = Integer.parseInt(txtSoLuong.getText());
				double donGia = Double.parseDouble(txtDonGia.getText());

				SanPham sp = new SanPham(masp, tensp, loaiHang, nhaCungCap, donGia, soLuong);

				try {
					sp_dao.create(sp);
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
			tableHangHoa.getSelectionModel().clearSelection();
			emptyTextField();

			// FrmBanHang.xoaHetDLSanPham();
			// FrmBanHang.docDuLieuDatabaseVaoTableSanPham();
		}
		if (o.equals(btnSua)) {
			String masp = txtMaHangHoa.getText();
			String tensp = txtTenHangHoa.getText();
			String loaiHang = txtLoaiHang.getText();
			String nhaCungCap = txtNhaCungCap.getText();
			int soLuong = Integer.parseInt(txtSoLuong.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			if (!validInput()) {
				return;
			} else {

				SanPham sp = new SanPham(masp, tensp, loaiHang, nhaCungCap, donGia, soLuong);

				try {
					sp_dao.update(sp);
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
				tableHangHoa.getSelectionModel().clearSelection();
				// FrmBanHang.xoaHetDLSanPham();
				// FrmBanHang.docDuLieuDatabaseVaoTableSanPham();
			}
		}
		if (o.equals(btnXoa)) {
			String masp = txtMaHangHoa.getText();
			SanPham sp = new SanPham(masp);

			try {
				sp_dao.delete(sp);
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
			tableHangHoa.getSelectionModel().clearSelection();
			// FrmBanHang.xoaHetDLSanPham();
			// FrmBanHang.docDuLieuDatabaseVaoTableSanPham();
		}
		if (o.equals(cmbChon)) {
			if (cmbChon.getSelectedIndex() == 0) {
				try {
					docMaSanPhamVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 1) {
				try {
					docTenSanPhamVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 2) {
				try {
					docLoaiHangSanPhamVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 3) {
				try {
					docNhaCungCapSanPhamVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 4) {
				try {
					docDonGiaSanPhamVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cmbChon.getSelectedIndex() == 5) {
				try {
					docSoLuongTonSanPhamVaoCmbTim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (o.equals(btnTim)) {
			DefaultTableModel model = (DefaultTableModel) tableHangHoa.getModel();
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
				List<SanPham> list;
				try {
					list = sp_dao.getTatCaSanPham();
					for (SanPham sp : list) {
						if (sp.getMaSP().trim().equals(tim.trim())) {
							modelSanPham.addRow(
									new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
											sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (cmbChon.getSelectedIndex() == 1) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<SanPham> list;
				try {
					list = sp_dao.getTatCaSanPham();
					for (SanPham sp : list) {
						if (sp.getTenSP().trim().equals(tim.trim())) {
							modelSanPham.addRow(
									new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
											sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (cmbChon.getSelectedIndex() == 2) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<SanPham> list;
				try {
					list = sp_dao.getTatCaSanPham();
					for (SanPham sp : list) {
						if (sp.getLoaiHang().trim().equals(tim.trim())) {
							modelSanPham.addRow(
									new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
											sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (cmbChon.getSelectedIndex() == 3) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<SanPham> list;
				try {
					list = sp_dao.getTatCaSanPham();
					for (SanPham sp : list) {
						if (sp.getNhaCungCap().trim().equals(tim.trim())) {
							modelSanPham.addRow(
									new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
											sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (cmbChon.getSelectedIndex() == 4) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				double d = Double.parseDouble(tim.replaceAll(",", "").trim());
				List<SanPham> list;
				try {
					list = sp_dao.getTatCaSanPham();
					for (SanPham sp : list) {
						if (sp.getDonGia() == d) {
							modelSanPham.addRow(
									new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
											sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (cmbChon.getSelectedIndex() == 5) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				int d = Integer.parseInt(tim.trim());
				List<SanPham> list;
				try {
					list = sp_dao.getTatCaSanPham();
					for (SanPham sp : list) {
						if (sp.getSoLuong() == d) {
							modelSanPham.addRow(
									new Object[] { sp.getMaSP().trim(), sp.getTenSP().trim(), sp.getLoaiHang().trim(),
											sp.getNhaCungCap().trim(), df.format(sp.getDonGia()), sp.getSoLuong() });
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	private void emptyTextField() {
		txtMaHangHoa.setText(null);
		txtTenHangHoa.setText(null);
		txtDonGia.setText(null);
		txtSoLuong.setText(null);
		txtNhaCungCap.setText(null);
		txtLoaiHang.setText(null);
	}

	public static void docMaSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sp_dao.getTatCaMaSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docTenSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sp_dao.getTatCaTenSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docNhaCungCapSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sp_dao.getTatCaNhaCungCapSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docLoaiHangSanPhamVaoCmbTim() throws RemoteException {
		cmbTim.removeAllItems();
		SortedSet<String> list = sp_dao.getTatCaLoaiHangSanPham();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docDonGiaSanPhamVaoCmbTim() throws RemoteException {
		DecimalFormat df = new DecimalFormat("#,##0");
		cmbTim.removeAllItems();
		SortedSet<Double> list = sp_dao.getTatCaDonGiaSanPham();
		cmbTim.addItem("");
		for (Double s : list) {
			cmbTim.addItem(df.format(s));
		}
	}

	public static void docSoLuongTonSanPhamVaoCmbTim() throws RemoteException {
		DecimalFormat df = new DecimalFormat("#");
		cmbTim.removeAllItems();
		SortedSet<Integer> list = sp_dao.getTatCaSoLuongTonSanPham();
		cmbTim.addItem("");
		for (Integer s : list) {
			cmbTim.addItem(df.format(s));
		}
	}
}
