package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User>{
	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO login(username,password,hoTen,email,sdt) "
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getHoTen());
			pst.setString(4, t.getEmail());
			pst.setString(5, t.getSdt());
			
			ketQua = pst.executeUpdate();
			System.out.println("Bạn đã thực thi "+ sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE login SET"
					+ " password = ? "
					+ ", hoTen = ?"
					+ ", email = ?"
					+ ", sdt = ?"
					+ " WHERE username = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getHoTen());
			pst.setString(3, t.getEmail());
			pst.setString(4, t.getSdt());
			pst.setString(5,t.getUsername());
			
			ketQua = pst.executeUpdate();
			System.out.println("Bạn đã thực thi "+ sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "DELETE FROM login"
					+ " WHERE username = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t.getUsername());
			
			ketQua = pst.executeUpdate();
			System.out.println("Bạn đã thực thi "+ sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * from login";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				User u = new User(username, password,hoTen,email,sdt);
				ketQua.add(u);
			}
			System.out.println("Bạn đã thực thi "+ sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public User selectByID(String id) {
		User ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * from login WHERE username = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				ketQua = new User(username, password,hoTen,email,sdt);
			}
			System.out.println("Bạn đã thực thi "+ sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
