package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach>{
	public static SachDAO getInstance() {
		return new SachDAO();
	}
	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO quanlysach(maSach,tenSach,tacGia,theLoai,nhaXuatBan,namXuatBan,giaSach,tinhTrang)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaSach());
			pst.setString(2, t.getTenSach());
			pst.setString(3, t.getTacGia());
			pst.setString(4, t.getTheLoai());
			pst.setString(5, t.getNhaXuatBan());
			pst.setInt(6, t.getNamXuatBan());
			pst.setDouble(7, t.getGia());
			pst.setBoolean(8, t.isTinhTrang());
			
			ketQua = pst.executeUpdate();
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Sach t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE quanlysach SET"
					+ " tenSach = ?"
					+ ", tacGia = ?"
					+ ", theLoai = ?"
					+ ", nhaXuatBan = ?"
					+ ", namXuatBan = ?"
					+ ", giaSach = ?"
					+ ", tinhTrang = ?"
					+ " WHERE maSach = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getTenSach());
			pst.setString(2, t.getTacGia());
			pst.setString(3, t.getTheLoai());
			pst.setString(4, t.getNhaXuatBan());
			pst.setInt(5, t.getNamXuatBan());
			pst.setDouble(6, t.getGia());
			pst.setBoolean(7, t.isTinhTrang());
			pst.setString(8, t.getMaSach());
			
			ketQua = pst.executeUpdate();
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(Sach t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "DELETE FROM quanlysach"
					+ " WHERE maSach = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaSach());
			
			ketQua = pst.executeUpdate();
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * from quanlysach";
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String tacGia = rs.getString("tacGia");
				String theLoai = rs.getString("theLoai");
				String nhaXuatBan = rs.getString("nhaXuatBan");
				int namXuatBan = rs.getInt("namXuatBan");
				double giaSach = rs.getDouble("giaSach");
				boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				Sach s = new Sach(maSach,tenSach,tacGia,theLoai,nhaXuatBan,namXuatBan,giaSach,tinhTrang);
				ketQua.add(s);
			}
			System.out.println("Bạn đã thực thi: "+ sql);
		
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Sach selectByID(String id) {
		Sach ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * from quanlysach WHERE maSach = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String tacGia = rs.getString("tacGia");
				String theLoai = rs.getString("theLoai");
				String nhaXuatBan = rs.getString("nhaXuatBan");
				int namXuatBan = rs.getInt("namXuatBan");
				double giaSach = rs.getDouble("giaSach");
				boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				ketQua = new Sach(maSach,tenSach,tacGia,theLoai,nhaXuatBan,namXuatBan,giaSach,tinhTrang);
			}
			System.out.println("Bạn đã thực thi: "+ sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
