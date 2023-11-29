package test;

import model.LoginModel;
import model.User;

public class TestQLSLogin {
	public static void main(String[] args) {
		LoginModel log = new LoginModel();
		for(User i : log.getDsUser()) {
			System.out.println(i);
		}
	}
}
