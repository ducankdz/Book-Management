package test;

import java.util.ArrayList;

import dao.UserDAO;
import model.User;

public class TestUserDAO {
	public static void main(String[] args) {
		ArrayList<User> lst = UserDAO.getInstance().selectAll();
		for(User u : lst) System.out.println(u);
	}
}
