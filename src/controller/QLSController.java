package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import model.Sach;
import view.QLSView;

public class QLSController implements ActionListener{
	public QLSView view;
	
	public QLSController(QLSView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		try {
			if(src.equals("Thêm")) {
				this.view.xoaForm();
			}
			else if(src.equals("Lưu")) {
				this.view.thucHienThem();
			}
			else if(src.equals("Cập nhật")) {
				this.view.hienTHiThongTinDaChon();
			}
			else if(src.equals("Xoá")) {
				this.view.thucHienXoa();
			}
			else if(src.equals("Huỷ bỏ")) {
				this.view.xoaForm();
			}
			else if(src.equals("Tìm")) {
				this.view.thucHienTim();
			}
			else if(src.equals("Tải lại DL")) {
				this.view.thucHienTaiLaiDuLieu();
			}
			else if(src.equals("About me")) {
				this.view.hienThiAbout();
			}
			else if(src.equals("Exit")) {
				this.view.thucHienThoat();
			}
			else if(src.equals("Save")) {
				this.view.thucHienSave();
			}
			else if(src.equals("Open")) {
				this.view.thucHienOpen();
			}
			else if(src.equals("Log out")) {
				this.view.logOut();
			}
			else if(src.equals("Đăng xuất")) {
				this.view.logOut();
			}
			else if(src.equals("Đổi mật khẩu")) {
				this.view.changePassword();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
