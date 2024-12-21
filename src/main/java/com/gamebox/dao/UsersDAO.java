package com.gamebox.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamebox.dto.UsersDTO;
import com.gamebox.util.DBConnectionUtil;

public class UsersDAO {
	private DBConnectionUtil dbUtil = DBConnectionUtil.getInstance();
	
	// C. 회원가입
	public boolean insertUser (UsersDTO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dbUtil.getConnection();
			String sql = "INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, EMAIL, PROFILE_IMAGE) "
					+ "VALUES (SEQ_USER_ID.NEXTVAL, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getProfileImage());
			return pstmt.executeUpdate() > 0;	//성공적으로 추가되면 true 반환
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnectionUtil.close(null, pstmt, con);
		}
	}
		
		
	// R. 회원 정보 조회
	public UsersDTO getUserById (int userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dbUtil.getConnection();
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				UsersDTO user = new UsersDTO();
				user.setUserId(rs.getInt("USER_ID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setProfileImage(rs.getString("PROFIEL_IMAGE"));
				user.setCreatedAt(rs.getTimestamp("CREATED_AT"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pstmt, con);
		}
		return null;
	}
	
	
	// U. 회원 정보 수정
	public boolean updateUser(UsersDTO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dbUtil.getConnection();
			String sql = "UPDATE USERS SET USERNAME = ?, PASSWORD = ?, "
					+ "EMAIL = ?, PROFILE_IMAGE = ? WHERE USER_ID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getProfileImage());
			pstmt.setInt(5, user.getUserId());
			return pstmt.executeUpdate() > 0;	// 수정 성공하면 true 반환
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnectionUtil.close(null, pstmt, con);
		}
	}

	
	// D. 회원 정보 삭제
	public boolean deleteUser (int userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dbUtil.getConnection();
			String sql = "DELETE FROM USERS WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			return pstmt.executeUpdate() > 0; // 삭제 완료하면 true 반환
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnectionUtil.close(null, pstmt, con);
		}
	}
	
	
	// 모든 사용자 정보 조회
	public List<UsersDTO> getAllUsers() {
	    List<UsersDTO> usersList = new ArrayList<>();
	    String sql = "SELECT * FROM USERS";

	    try (Connection con = dbUtil.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            UsersDTO user = new UsersDTO();
	            user.setUserId(rs.getInt("USER_ID"));
	            user.setUsername(rs.getString("USERNAME"));
	            user.setEmail(rs.getString("EMAIL"));
	            user.setPassword(rs.getString("PASSWORD")); // Optional
	            user.setProfileImage(rs.getString("PROFILE_IMAGE"));
	            user.setCreatedAt(rs.getTimestamp("CREATED_AT"));
	            usersList.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return usersList;
	}

}
