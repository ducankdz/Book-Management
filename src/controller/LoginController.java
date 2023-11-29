package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.LoginView;
import view.SignupView;

public class LoginController implements ActionListener{
	public LoginView login;
	public SignupView signup;
	public int cnt =0;
	public LoginController(LoginView login) {
		this.login = login;
	}
	public LoginController(SignupView signup) {
		this.signup = signup;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("Đăng nhập")) {
			this.login.dangNhap();
			cnt++;
			if(cnt==5) {
				try {
					JOptionPane.showMessageDialog(this.login, "Bạn đã đăng nhập sai quá nhiều lần. "
							+ "Vui lòng đợi 10s!");
					Thread.sleep(10000);
					cnt=0;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(src.equals("Tạo tài khoản")) {
			this.login.dangKy();
		}
	}

}
