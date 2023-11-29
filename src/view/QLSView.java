package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.QLSController;
import dao.SachDAO;
import model.QLSModel;
import model.Sach;
import model.User;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class QLSView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public QLSModel model;
	public LoginView login;
	public JTextField textField_maSach_timKiem;
	public JTextField textField_tenSach_timKiem;
	public JTable table;
	public JTextField textField_nhaXuatBan;
	public JTextField textField_maSach;
	public JTextField textField_tenSach;
	public JTextField textField_tacGia;
	public JTextField textField_giaSach;
	public ButtonGroup btn_tinhTrang;
	public JRadioButton rdbtnCon;
	public JRadioButton rdbtnHet;
	public JComboBox comboBox_namXuatBan;
	public JComboBox comboBox_theLoai;
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnCapNhat;
	public JButton btnLuu;
	public JButton btnHuyBo;
	public JButton btnTim;
	public JButton btnHuy;
	public JMenuItem menuOpen;
	public JMenuItem menuSave;
	public JMenuItem menuExit;
	public JMenuItem menuAboutMe;
	public JMenu mnNewMenu_2;
	public JMenuItem menuLogout;
	public JSeparator separator_2;
	public JLabel lblNewLabel_7;
	public JLabel lblNewLabel_8;
	public JLabel labelTaiKhoan;
	public JLabel labelHoTen;
	public JLabel lblNewLabel_9;
	public JLabel lblNewLabel_10;
	public JSeparator separator_3;
	public JSeparator separator_4;
	public JLabel labelEmail;
	public JLabel labelSDT;
	public User u;
	public JPanel panel;
	public JScrollPane scrollPane;

	public QLSView(User user) {
		setTitle("Quản lý sách");
		this.model = new QLSModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1117, 920);
		setResizable(false);
		setLocationRelativeTo(null);
		QLSController ac = new QLSController(this);
		u = user;
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		menuOpen = new JMenuItem("Open",KeyEvent.VK_O);
		menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		menuOpen.addActionListener(ac);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(menuOpen);
		
		menuSave = new JMenuItem("Save",KeyEvent.VK_S);
		menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		menuSave.addActionListener(ac);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(menuSave);
		
		menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(ac);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(menuExit);
		
		mnNewMenu_2 = new JMenu("Account");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		menuLogout = new JMenuItem("Log out");
		menuLogout.addActionListener(ac);
		menuLogout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_2.add(menuLogout);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(ac);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_1.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 85, 725, 2);
		contentPane.add(separator);
		
		JLabel lable_maSach_timKiem = new JLabel("Mã sách");
		lable_maSach_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lable_maSach_timKiem.setBounds(36, 32, 84, 25);
		contentPane.add(lable_maSach_timKiem);
		
		textField_maSach_timKiem = new JTextField();
		textField_maSach_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_maSach_timKiem.setBounds(122, 26, 147, 37);
		contentPane.add(textField_maSach_timKiem);
		textField_maSach_timKiem.setColumns(10);
		
		JLabel lbael_tenSach_timKiem = new JLabel("Tên sách");
		lbael_tenSach_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbael_tenSach_timKiem.setBounds(279, 32, 84, 25);
		contentPane.add(lbael_tenSach_timKiem);
		
		textField_tenSach_timKiem = new JTextField();
		textField_tenSach_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_tenSach_timKiem.setColumns(10);
		textField_tenSach_timKiem.setBounds(371, 26, 153, 37);
		contentPane.add(textField_tenSach_timKiem);
		
		btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(103, 119, 204));
		btnTim.setForeground(Color.white);
		btnTim.addActionListener(ac);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(534, 26, 89, 37);
		contentPane.add(btnTim);
		
		JLabel lblDanhSchTh = new JLabel("Danh sách sách");
		lblDanhSchTh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchTh.setBounds(36, 100, 147, 25);
		contentPane.add(lblDanhSchTh);
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Ariral",Font.BOLD,16));
		header.setBackground(new Color(0, 160, 213));
		header.setForeground(Color.white);
		table.setRowHeight(30);
		table.setBackground(new Color(230, 244, 253));
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "N\u0103m xu\u1EA5t b\u1EA3n", "Th\u1EC3 lo\u1EA1i", "T\u00ECnh tr\u1EA1ng", "Gi\u00E1 s\u00E1ch"
			}
		));
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(36, 136, 725, 245);
		contentPane.add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 406, 725, 2);
		contentPane.add(separator_1);
		
		JLabel lblThngTinSch = new JLabel("Thông tin sách");
		lblThngTinSch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinSch.setBounds(36, 431, 147, 25);
		contentPane.add(lblThngTinSch);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 487, 84, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên sách");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(36, 559, 84, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tác giả");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(36, 632, 84, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nhà xuất bản");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(399, 487, 125, 25);
		contentPane.add(lblNewLabel_4);
		
		textField_nhaXuatBan = new JTextField();
		textField_nhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_nhaXuatBan.setColumns(10);
		textField_nhaXuatBan.setBounds(534, 481, 227, 37);
		contentPane.add(textField_nhaXuatBan);
		
		JLabel lblNewLabel_5 = new JLabel("Năm xuất bản");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(399, 559, 125, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Thể loại");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(399, 632, 84, 25);
		contentPane.add(lblNewLabel_6);
		
		textField_maSach = new JTextField();
		textField_maSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_maSach.setColumns(10);
		textField_maSach.setBounds(122, 487, 227, 37);
		contentPane.add(textField_maSach);
		
		textField_tenSach = new JTextField();
		textField_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_tenSach.setColumns(10);
		textField_tenSach.setBounds(122, 559, 227, 37);
		contentPane.add(textField_tenSach);
		
		textField_tacGia = new JTextField();
		textField_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_tacGia.setColumns(10);
		textField_tacGia.setBounds(122, 626, 227, 37);
		contentPane.add(textField_tacGia);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tình trạng");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(36, 699, 102, 25);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Giá sách");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(399, 699, 84, 25);
		contentPane.add(lblNewLabel_3_2);
		
		textField_giaSach = new JTextField();
		textField_giaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_giaSach.setColumns(10);
		textField_giaSach.setBounds(537, 693, 227, 37);
		contentPane.add(textField_giaSach);
		
		rdbtnCon = new JRadioButton("Còn");
		rdbtnCon.setBackground(Color.white);
		rdbtnCon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnCon.setBounds(167, 701, 74, 23);
		contentPane.add(rdbtnCon);
		
		rdbtnHet = new JRadioButton("Hết");
		rdbtnHet.setBackground(new Color(255, 255, 255));
		
		rdbtnHet.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnHet.setBounds(251, 701, 74, 23);
		contentPane.add(rdbtnHet);
		
		btn_tinhTrang = new ButtonGroup();
		btn_tinhTrang.add(rdbtnCon);
		btn_tinhTrang.add(rdbtnHet);
		
		String[] nam = new String[] {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992",
				"1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008",
				"2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
		
		comboBox_namXuatBan = new JComboBox();
		comboBox_namXuatBan.setBackground(new Color(255, 255, 255));
		comboBox_namXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_namXuatBan.addItem("");
		for(String i : nam) {
			comboBox_namXuatBan.addItem(i);
		}
		comboBox_namXuatBan.setBounds(534, 553, 227, 37);
		contentPane.add(comboBox_namXuatBan);
		
		String[] ds_theLoai = new String[] {
				"Giáo trình",
				"Chính trị - pháp luật",
				"Khoa học",
				"Văn học nghệ thuật",
				"Lịch sử",
				"Truyện, tiểu thuyết",
				"Tâm lý",
				"Thiếu nhi",
				"Kinh tế"
		};	
		
		comboBox_theLoai = new JComboBox();
		comboBox_theLoai.setBackground(new Color(255,255,255));
		comboBox_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_theLoai.addItem("");
		for(String i : ds_theLoai) {
			comboBox_theLoai.addItem(i);
		}
		comboBox_theLoai.setBounds(534, 626, 227, 37);
		contentPane.add(comboBox_theLoai);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(36, 755, 725, 2);
		contentPane.add(separator_1_1);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(65, 55, 158));
		btnThem.setForeground(Color.white);
		btnThem.addActionListener(ac);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThem.setBounds(36, 779, 125, 46);
		contentPane.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setBackground(new Color(65, 55, 158));
		btnXoa.setForeground(Color.white);
		btnXoa.addActionListener(ac);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnXoa.setBounds(185, 779, 125, 46);
		contentPane.add(btnXoa);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(new Color(65, 55, 158));
		btnCapNhat.setForeground(Color.white);
		btnCapNhat.addActionListener(ac);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCapNhat.setBounds(339, 779, 125, 46);
		contentPane.add(btnCapNhat);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBackground(new Color(65, 55, 158));
		btnLuu.setForeground(Color.white);
		btnLuu.addActionListener(ac);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLuu.setBounds(489, 779, 125, 46);
		contentPane.add(btnLuu);
		
		btnHuyBo = new JButton("Huỷ bỏ");
		btnHuyBo.setBackground(new Color(65, 55, 158));
		btnHuyBo.setForeground(Color.white);
		btnHuyBo.addActionListener(ac);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnHuyBo.setBounds(636, 779, 125, 46);
		contentPane.add(btnHuyBo);
		
		btnHuy = new JButton("Tải lại DL");
		btnHuy.setBackground(new Color(103, 119, 204));
		btnHuy.setForeground(Color.white);
		btnHuy.addActionListener(ac);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuy.setBounds(633, 27, 125, 37);
		contentPane.add(btnHuy);
		
		ImageIcon imgIcon = new ImageIcon("images\\profile1.png");
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBounds(802, 214, 261, 2);
		contentPane.add(separator_2);
		
		lblNewLabel_7 = new JLabel("Tài khoản");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(802, 183, 84, 25);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Họ và tên");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(802, 221, 84, 25);
		contentPane.add(lblNewLabel_8);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(56, 150, 238));
		btnDangXuat.setForeground(Color.white);
		btnDangXuat.addActionListener(ac);
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDangXuat.setBounds(820, 348, 227, 37);
		contentPane.add(btnDangXuat);
		
		labelTaiKhoan = new JLabel(user.getUsername());
		labelTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTaiKhoan.setBounds(910, 183, 153, 25);
		contentPane.add(labelTaiKhoan);
		
		labelHoTen = new JLabel(user.getHoTen());
		labelHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelHoTen.setBounds(910, 221, 139, 25);
		contentPane.add(labelHoTen);
		
		lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(802, 259, 84, 25);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("SĐT");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(802, 297, 84, 25);
		contentPane.add(lblNewLabel_10);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(802, 252, 261, 2);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(802, 290, 261, 2);
		contentPane.add(separator_4);
		
		labelEmail = new JLabel(user.getEmail());
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmail.setBounds(910, 259, 153, 25);
		contentPane.add(labelEmail);
		
		labelSDT = new JLabel(user.getSdt());
		labelSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSDT.setBounds(910, 297, 153, 25);
		contentPane.add(labelSDT);
		
		JButton btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.setBackground(new Color(56, 150, 238));
		btnDoiMK.setForeground(Color.white);
		btnDoiMK.addActionListener(ac);
		btnDoiMK.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDoiMK.setBounds(820, 400, 227, 37);
		contentPane.add(btnDoiMK);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(785, 32, 295, 425);
		contentPane.add(panel);
		JLabel labelAvatar = new JLabel("",imgIcon,JLabel.CENTER);
		panel.add(labelAvatar);
		LineBorder line = new LineBorder(Color.blue,2,true);
		
		for(Sach sach : this.model.getDsSach()) {
			this.themSachVaoTable(sach);
		}
		
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_maSach.setText("");
		textField_tenSach.setText("");
		textField_tacGia.setText("");
		textField_nhaXuatBan.setText("");
		textField_giaSach.setText("");
		comboBox_namXuatBan.setSelectedIndex(-1);
		comboBox_theLoai.setSelectedIndex(-1);
		btn_tinhTrang.clearSelection();
	}
	
	public void themSachVaoTable(Sach sach) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.addRow(new Object[] {
				sach.getMaSach(),
				sach.getTenSach(),
				sach.getTacGia(),
				sach.getNhaXuatBan(),
				sach.getNamXuatBan(),
				sach.getTheLoai(),
				sach.isTinhTrang()==true?"Còn":"Hết",
				sach.getGia()
		});
	}

	public void capNhatHoacThemSach(Sach sach) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(sach)) {
			this.model.insert(sach);
			SachDAO.getInstance().insert(sach);
			themSachVaoTable(sach);
		}
		else {
			this.model.update(sach);
			SachDAO.getInstance().update(sach);
			int soDong = dtm.getRowCount();
			for(int i=0;i<soDong;i++) {
				String ma = dtm.getValueAt(i, 0)+"";
				if(ma.equals(sach.getMaSach())) {
					dtm.setValueAt(sach.getTenSach()+"", i, 1);
					dtm.setValueAt(sach.getTacGia()+"", i, 2);
					dtm.setValueAt(sach.getNhaXuatBan()+"", i, 3);
					dtm.setValueAt(sach.getNamXuatBan()+"", i, 4);
					dtm.setValueAt(sach.getTheLoai()+"", i, 5);
					dtm.setValueAt(sach.isTinhTrang()==true?"Còn":"Hết", i, 6);
					dtm.setValueAt(sach.getGia()+"", i, 7);
				}
			}
		}
		
	}
	public Sach getSachDaChon() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String maSach = dtm.getValueAt(row, 0)+"";
		String tenSach = dtm.getValueAt(row, 1)+"";
		String tacGia = dtm.getValueAt(row, 2)+"";
		String nhaXuatBan = dtm.getValueAt(row, 3)+"";
		int namXuatBan = Integer.valueOf(dtm.getValueAt(row, 4)+"");
		String theLoai = dtm.getValueAt(row, 5)+"";
		String textTinhTrang = dtm.getValueAt(row, 6)+"";
		boolean tinhTrang = textTinhTrang.equals("Còn");
		double giaSach = Double.valueOf(dtm.getValueAt(row, 7)+"");
		Sach sach = new Sach(maSach,tenSach,tacGia,theLoai,nhaXuatBan,namXuatBan,giaSach,tinhTrang);
		return sach;
	}
	public void hienTHiThongTinDaChon() {
		Sach sach = getSachDaChon();
		
		this.textField_maSach.setText(sach.getMaSach());
		this.textField_tenSach.setText(sach.getTenSach());
		this.textField_nhaXuatBan.setText(sach.getNhaXuatBan());
		this.textField_tacGia.setText(sach.getTacGia());
		this.textField_giaSach.setText(sach.getGia()+"");
		this.comboBox_namXuatBan.setSelectedItem(sach.getNamXuatBan()+"");
		this.comboBox_theLoai.setSelectedItem(sach.getTheLoai());
		if(sach.isTinhTrang()==true) {
			this.rdbtnCon.setSelected(true);
		}
		else if(sach.isTinhTrang()==false) {
			this.rdbtnHet.setSelected(true);
		}
	}

	public void thucHienXoa() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá không?");
		if(luaChon == JOptionPane.YES_OPTION) {
			this.xoaForm();
			Sach sach = getSachDaChon();
			this.model.delete(sach);
			SachDAO.getInstance().delete(sach);
			try {
				dtm.removeRow(row);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void thucHienThem() {
		String maSach = this.textField_maSach.getText();
		String tenSach = this.textField_tenSach.getText();
		String tacGia = this.textField_tacGia.getText();
		String nhaXuatBan = this.textField_nhaXuatBan.getText();
		double giaSach = Double.valueOf(this.textField_giaSach.getText());
		int namXuatBan = Integer.valueOf(this.comboBox_namXuatBan.getSelectedItem()+"");
		String theLoai = this.comboBox_theLoai.getSelectedItem()+"";
		boolean tinhTrang = true;
		if(this.rdbtnCon.isSelected()) {
			tinhTrang = true;
		}
		else if(this.rdbtnHet.isSelected()) {
			tinhTrang = false;
		}
		Sach sach = new Sach(maSach,tenSach,tacGia,theLoai,nhaXuatBan,namXuatBan,giaSach,tinhTrang);
		this.capNhatHoacThemSach(sach);
	}

	public void thucHienTim() {
		this.thucHienTaiLaiDuLieu();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		int soLuongDong = dtm.getRowCount();
		String maSach = this.textField_maSach_timKiem.getText().toLowerCase();
		String tenSach = this.textField_tenSach_timKiem.getText().toLowerCase();
		Set<String> idCuaSachCanXoa = new TreeSet<String>();
		if(maSach.length()>0) {
			for(int i=0;i<soLuongDong;i++) {
				String id = (dtm.getValueAt(i, 0)+"");
				if(!id.toLowerCase().contains(maSach)) {
					idCuaSachCanXoa.add(id);
				}
			}
		}
		if(tenSach.length()>0) {
			for(int i=0;i<soLuongDong;i++) {
				String ten = (dtm.getValueAt(i,1)+"");
				String id = dtm.getValueAt(i, 0)+"";
				if(!ten.toLowerCase().contains(tenSach)) {
					idCuaSachCanXoa.add(id);
				}
			}
		}
		for(String idCanXoa : idCuaSachCanXoa) {
			soLuongDong = dtm.getRowCount();
			for(int i=0;i<soLuongDong;i++) {
				String id = dtm.getValueAt(i, 0)+"";
				if(id.equals(idCanXoa)) {
					try {
						dtm.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			int soLuongDong = dtm.getRowCount();
			if(soLuongDong==0) break;
			else {
				try {
					dtm.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Collections.sort(this.model.getDsSach());
		for(Sach sach : this.model.getDsSach()) {
			this.themSachVaoTable(sach);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "APP QUẢN LÝ SÁCH\n"
				+ "Nhóm thực hiện: 2.12\n"
				+ "Thành viên:\n"
				+ "		Hoàng Việt Anh – B21DCAT025\n"
				+ "		Trần Đức Anh – B21DCCN160\n"
				+ "		Trần Duy Hưng – B21DCAT101");
	}

	public void thucHienThoat() {
		int luaChon = JOptionPane.showConfirmDialog(
				this, 
				"Bạn có chắc chắn muốn thoát khỏi chương trình?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Sach sach : this.model.getDsSach()) {
				oos.writeObject(sach);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienSave() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}
		else {
			JFileChooser fc = new JFileChooser();
			int retVal = fc.showSaveDialog(this);
			if(retVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}
	
	public void openFile(File file) {
		ArrayList<Sach> lst = new ArrayList<Sach>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Sach sach = null;
			while((sach = (Sach) ois.readObject()) != null) {
				lst.add(sach);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.model.setDsSach(lst);
	}
	
	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(this);
		if(retVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
	}

	public void logOut() {
		int luaChon = JOptionPane.showConfirmDialog(
				this, 
				"Bạn có chắc chắn muốn đăng xuất?",
				"Log Out",
				JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			this.setVisible(false);
			new LoginView();
		}
	}

	public void changePassword() {
		new ChangePasswordView(u);
	}
}
