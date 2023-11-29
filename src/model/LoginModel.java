package model;

import java.util.ArrayList;

import dao.UserDAO;

public class LoginModel {
	public ArrayList<User> dsUser;

	
	public LoginModel() {
		dsUser = UserDAO.getInstance().selectAll();
	}

	public LoginModel(ArrayList<User> dsUser) {
		this.dsUser = dsUser;
	}

	public ArrayList<User> getDsUser() {
		return dsUser;
	}

	public void setDsUser(ArrayList<User> dsUser) {
		this.dsUser = dsUser;
	}
	
	public void insert(User u) {
		this.dsUser.add(u);
	}
	
	public void update(User u) {
		for(User i : dsUser) {
			if(i.getUsername().equals(u.getUsername())) {
				i.setPassword(u.getPassword());
			}
		}
	}
	
	public void delete(User u) {
		try {
			for(User i : dsUser) {
				if(i.getUsername().equals(u.getUsername())) {
					this.dsUser.remove(i);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean kiemTraTonTai(User user) {
		for(User i : dsUser) {
			if(i.getUsername().equals(user.getUsername())) {
				return true;
			}
		}
		return false;
	}
	public boolean kiemTraMatKhau(User user) {
		for(User i : dsUser) {
			if(i.getUsername().equals(user.getUsername()) && i.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "QLSLogin [dsUser=" + dsUser + "]";
	}
	
}
