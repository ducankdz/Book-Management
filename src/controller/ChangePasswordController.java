package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ChangePasswordView;

public class ChangePasswordController implements ActionListener{
	public ChangePasswordView cp;
	

	public ChangePasswordController(ChangePasswordView cp) {
		this.cp = cp;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Huỷ")) {
			this.cp.huy();
		}
		else if(src.equals("Đổi mật khẩu")) {
			this.cp.doiMatKhau();
		}
		
	}

}
