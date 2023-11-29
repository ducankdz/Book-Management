package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.SignupController;
import dao.UserDAO;
import encode.Encode;
import model.LoginModel;
import model.QLSModel;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class SignupView extends JFrame {

	private static final long serialVersionUID = 1L;
	public LoginModel mdl = new LoginModel();
	public LoginView login;
	public JPanel contentPane;
	public JTextField usernameField;
	public JPasswordField passwordField;
	public JPasswordField passwordField1;
	public JRadioButton hidePasswordCheckbox;
	public JButton btnSignUp;
	public char pw;
	public char pw_again;
	public JButton btnLogIn;
	public JLabel lblHVTn;
	public JTextField hoVaTenField;
	public JTextField emailField;
	public JTextField sdtField;
	
	public SignupView() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 549);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		SignupController lis = new SignupController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(29, 230, 130, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		usernameField.setColumns(10);
		usernameField.setBounds(188, 224, 210, 35);
		contentPane.add(usernameField);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMtKhu.setBounds(29, 289, 139, 27);
		contentPane.add(lblMtKhu);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passwordField.setBounds(188, 285, 210, 35);
		contentPane.add(passwordField);
		
		passwordField1 = new JPasswordField();
		passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passwordField1.setBounds(188, 346, 210, 35);
		contentPane.add(passwordField1);
		
		JLabel lblNhpLiMk = new JLabel("Nhập lại MK");
		lblNhpLiMk.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNhpLiMk.setBounds(29, 350, 139, 27);
		contentPane.add(lblNhpLiMk);
		
		hidePasswordCheckbox = new JRadioButton("Hiện mật khẩu");
		hidePasswordCheckbox.setBackground(Color.white);
		hidePasswordCheckbox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hidePasswordCheckbox.setBounds(269, 392, 129, 23);
		contentPane.add(hidePasswordCheckbox);
		
		pw = passwordField.getEchoChar();
		pw_again = passwordField1.getEchoChar();
		hidePasswordCheckbox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	passwordField.setEchoChar((char) 0);
		        	passwordField1.setEchoChar((char) 0);
		        } else {
		        	passwordField.setEchoChar(pw);
		        	passwordField1.setEchoChar(pw_again);
		        }
		    }
		});
		
		btnSignUp = new JButton("Đăng ký");
		btnSignUp.setBackground(new Color(230, 111, 171));
		btnSignUp.setForeground(Color.white);
		btnSignUp.addActionListener(lis);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSignUp.setBounds(217, 434, 170, 54);
		contentPane.add(btnSignUp);
		
		btnLogIn = new JButton("Đăng nhập");
		btnLogIn.setBackground(new Color(109, 111, 199));
		btnLogIn.setForeground(Color.white);
		btnLogIn.addActionListener(lis);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLogIn.setBounds(29, 434, 170, 54);
		contentPane.add(btnLogIn);
		
		lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHVTn.setBounds(29, 48, 130, 23);
		contentPane.add(lblHVTn);
		
		hoVaTenField = new JTextField();
		hoVaTenField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		hoVaTenField.setColumns(10);
		hoVaTenField.setBounds(188, 42, 210, 35);
		contentPane.add(hoVaTenField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(29, 104, 130, 23);
		contentPane.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		emailField.setColumns(10);
		emailField.setBounds(188, 98, 210, 35);
		contentPane.add(emailField);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSt.setBounds(29, 167, 130, 23);
		contentPane.add(lblSt);
		
		sdtField = new JTextField();
		sdtField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		sdtField.setColumns(10);
		sdtField.setBounds(188, 161, 210, 35);
		contentPane.add(sdtField);
		
		setVisible(true);
	}

	public void dangKy() {
		String username = this.usernameField.getText();
		int username_len = username.length();
		String password = this.passwordField.getText();
		int password_len = password.length();
		password = Encode.toSHA1(password);
		String password1 = this.passwordField1.getText();
		int password1_len = password1.length();
		password1 = Encode.toSHA1(password1);
		String hoTen = this.hoVaTenField.getText();
		String email = this.emailField.getText();
		String sdt = this.sdtField.getText();
		User u = new User(username, password,hoTen,email,sdt);
		if(hoTen.length()<1 || email.length()<1 || sdt.length()<1 || username_len == 0 || password_len == 0 || password1_len == 0) {
			JOptionPane.showMessageDialog(this, "Không được để trống thông tin!");
		}
		else if(!password.equals(password1)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không chính xác!");
		}
		else if(!this.mdl.kiemTraTonTai(u)) {
				this.mdl.insert(u);
				UserDAO.getInstance().insert(u);
				JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
				this.setVisible(false);
				login = new LoginView();
		}
		else {
			JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại!");
		}
	
	}
	public void dangNhap() {
		login = new LoginView();
		this.setVisible(false);
	}
}
