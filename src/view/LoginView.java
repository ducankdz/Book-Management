package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import encode.Encode;
import model.LoginModel;
import model.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	public LoginModel mdl = new LoginModel();
	public SignupView signup;
	public JPanel contentPane;
	public JTextField usernameField;
	public JPasswordField passwordField;
	public JButton btnLogIn;
	public JButton btnSignUp;
	
	public LoginView() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		LoginController lis = new LoginController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(39, 241, 139, 27);
		contentPane.add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		usernameField.setBounds(195, 237, 193, 35);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMtKhu.setBounds(39, 298, 139, 27);
		contentPane.add(lblMtKhu);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passwordField.setBounds(195, 294, 193, 35);
		contentPane.add(passwordField);
		
		btnLogIn = new JButton("Đăng nhập");
		btnLogIn.setBackground(new Color(109, 111, 199));
		btnLogIn.setForeground(Color.white);
		btnLogIn.addActionListener(lis);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogIn.setBounds(221, 377, 167, 54);
		contentPane.add(btnLogIn);
		
		JRadioButton hidePasswordCheckbox = new JRadioButton("Hiện mật khẩu");
		hidePasswordCheckbox.setBackground(Color.white);
		hidePasswordCheckbox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hidePasswordCheckbox.setBounds(259, 336, 129, 23);
		contentPane.add(hidePasswordCheckbox);
		
		btnSignUp = new JButton("Tạo tài khoản");
		
		btnSignUp.setBackground(new Color(230, 111, 171));
		btnSignUp.setForeground(Color.white);
		btnSignUp.addActionListener(lis);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignUp.setBounds(41, 377, 167, 54);
		contentPane.add(btnSignUp);
		ImageIcon img = new ImageIcon("D:\\Java Swing\\QLS3\\images\\book3.png");
		JLabel labelImg = new JLabel("",img,JLabel.CENTER);
		
		labelImg.setBounds(141, 0, 150, 150);
		contentPane.add(labelImg);
		
		JLabel lblNewLabel_1 = new JLabel("APP QUẢN LÝ SÁCH");
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(100, 152, 238, 35);
		contentPane.add(lblNewLabel_1);
		char c = passwordField.getEchoChar();
		hidePasswordCheckbox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	passwordField.setEchoChar((char) 0);
		        } else {
		        	passwordField.setEchoChar(c);
		        }
		    }
		});
		
		setVisible(true);
	}

	public void dangNhap() {
		String username = this.usernameField.getText();
		String password = this.passwordField.getText();
		password = Encode.toSHA1(password);
		boolean ktra = false;
		User user = null;
		for(User i : this.mdl.getDsUser()) {
			if(i.getUsername().equals(username) && i.getPassword().equals(password)) {
				user = i;
				ktra = true;
			}
		}
		if(username.length()<1 || password.length()<1) {
			JOptionPane.showMessageDialog(this, "Tên đăng nhập và mật khẩu không được để trống!");
		}
		else if(!ktra) {
			JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!");
		}
		else {
//			JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
			setVisible(false);
			QLSView view =  new QLSView(user);
		}
	}

	public void dangKy() {
		signup = new SignupView();
		this.setVisible(false);
		
	}
}
