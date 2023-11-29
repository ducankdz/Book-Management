package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ChangePasswordController;
import dao.UserDAO;
import encode.Encode;
import model.LoginModel;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JButton;

public class ChangePasswordView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPasswordField oldPasswordField;
	public JPasswordField newPasswordField;
	public JPasswordField newPasswordField1;
	public char oldpw;
	public char newpw;
	public char newpw_again;
	public JRadioButton hidePasswordCheckbox;
	public JButton btnHuy;
	public JButton btnDoiMK;
	public User u;
	public LoginModel mdl = new LoginModel();
	
	
	public ChangePasswordView(User user) {
		setTitle("Change Password");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		u = user;
		ChangePasswordController ac = new ChangePasswordController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ");
		lblMtKhuC.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMtKhuC.setBounds(20, 31, 139, 27);
		contentPane.add(lblMtKhuC);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		oldPasswordField.setBounds(193, 27, 210, 35);
		contentPane.add(oldPasswordField);
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMtKhuMi.setBounds(20, 89, 139, 27);
		contentPane.add(lblMtKhuMi);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại MK mới");
		lblNhpLiMt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNhpLiMt.setBounds(20, 146, 139, 27);
		contentPane.add(lblNhpLiMt);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		newPasswordField.setBounds(193, 85, 210, 35);
		contentPane.add(newPasswordField);
		
		newPasswordField1 = new JPasswordField();
		newPasswordField1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		newPasswordField1.setBounds(193, 142, 210, 35);
		contentPane.add(newPasswordField1);
		
		hidePasswordCheckbox = new JRadioButton("Hiện mật khẩu");
		hidePasswordCheckbox.setBackground(Color.white);
		hidePasswordCheckbox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hidePasswordCheckbox.setBounds(274, 184, 129, 23);
		contentPane.add(hidePasswordCheckbox);
		
		oldpw = oldPasswordField.getEchoChar();
		newpw = oldPasswordField.getEchoChar();
		newpw_again = newPasswordField1.getEchoChar();
		hidePasswordCheckbox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	oldPasswordField.setEchoChar((char) 0);
		        	newPasswordField.setEchoChar((char) 0);
		        	newPasswordField1.setEchoChar((char) 0);
		        } else {
		        	oldPasswordField.setEchoChar(oldpw);
		        	oldPasswordField.setEchoChar(newpw);
		        	oldPasswordField.setEchoChar(newpw_again);
		        }
		    }
		});
		
		btnHuy = new JButton("Huỷ");
		btnHuy.addActionListener(ac);
		btnHuy.setBackground(Color.gray);
		btnHuy.setForeground(Color.white);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuy.setBounds(292, 229, 111, 35);
		contentPane.add(btnHuy);
		
		btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.addActionListener(ac);
		btnDoiMK.setBackground(new Color(0,191,255));
		btnDoiMK.setForeground(Color.white);
		btnDoiMK.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDoiMK.setBounds(127, 229, 155, 35);
		contentPane.add(btnDoiMK);
		
		this.setVisible(true);
	}

	public void huy() {
		this.setVisible(false);
	}

	public void doiMatKhau() {
		String username = u.getUsername();
		String pw = u.getPassword();
		String hoTen = u.getHoTen();
		String email = u.getEmail();
		String sdt = u.getSdt();
		
		String oldPW = this.oldPasswordField.getText();
		String mkCu = oldPW;
		oldPW = Encode.toSHA1(oldPW);
		String newPW = this.newPasswordField.getText();
		String mkMoi = newPW;
		newPW = Encode.toSHA1(newPW);
		String newPW1 = this.newPasswordField1.getText();
		String mkMoi1 = newPW1;
		newPW1 = Encode.toSHA1(newPW1);
		
		System.out.println(pw);
		System.out.println(oldPW);
		if(mkCu.length()<1 || mkMoi.length()<1 || mkMoi1.length()<1) {
			JOptionPane.showMessageDialog(this, "Không được để trống thông tin!");
		}
		else if(!pw.equals(oldPW)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng!");
		}
		else if(!newPW.equals(newPW1)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không chính xác!");
		}
		else {
			User us = new User(username, newPW1, hoTen, email, sdt);
			this.mdl.update(us);
			UserDAO.getInstance().update(us);
			JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu thành công!");
			this.setVisible(false);
		}
	}
}
