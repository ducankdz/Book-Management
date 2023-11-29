package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SignupView;

public class SignupController implements ActionListener{
	private SignupView signup;
	

	public SignupController(SignupView signup) {
		this.signup = signup;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("Đăng ký")) {
			this.signup.dangKy();
		}
		else if (src.equals("Đăng nhập")) {
			this.signup.dangNhap();
		}
	}

}
