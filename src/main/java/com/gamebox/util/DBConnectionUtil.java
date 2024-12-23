package com.gamebox.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionUtil {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "rmarn";
	private static final String PASSWORD = "1234";
	
	// Singleton Instance
	private static DBConnectionUtil instance;
	
	public DBConnectionUtil() {
		try {
			// JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Singleton Instance 가져오기
	public static DBConnectionUtil getInstance() {
		if (instance == null) {
			instance = new DBConnectionUtil();
		}
		return instance;
	}
	
	// DB 연결 객체 반환
    public Connection getConnection() throws SQLException {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("DB 연결 성공: " + con);
            return con;
        } catch (SQLException e) {
            System.err.println("DB 연결 실패: " + e.getMessage());
            throw e;
        }
    }
	
	// 자원 종료 메서드(단일 방식)
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con !=null ) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





