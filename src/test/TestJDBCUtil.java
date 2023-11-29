package test;

import java.sql.Connection;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		Connection con = JDBCUtil.getConnection();
		System.out.println(con);
	}
}
