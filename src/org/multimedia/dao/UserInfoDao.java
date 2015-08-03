package org.multimedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.multimedia.domain.UserInfoDomain;

public class UserInfoDao {
	public static int insert(UserInfoDomain userInfoDomain) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("insert into user_info"
				+ " values(?,?,?,?,?);");
			ppdstmt.setString(1, userInfoDomain.getUserId());
			ppdstmt.setString(2, userInfoDomain.getUserPwd());
			ppdstmt.setString(3, userInfoDomain.getUserName());
			ppdstmt.setString(4, userInfoDomain.getUserEmail());
			ppdstmt.setInt(5, userInfoDomain.getActivate());
			
			int count = ppdstmt.executeUpdate();
			ppdstmt.close();
			conn.close();
			return count;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int selectLogin(String email, String password) {
		try{
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from user_info "
					+ "where user_email=? and user_pwd=?");
			
			ppdstmt.setString(1, email);
			ppdstmt.setString(2, password);
			
			ResultSet rs = ppdstmt.executeQuery();
			rs.last();
			int count = rs.getRow();  //rs.beforeFirst();
		
			rs.close();
			ppdstmt.close();
			conn.close();
			return count;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String selectUserId(String email) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from user_info "
					+ "where user_email=?;");
			ppdstmt.setString(1, email);
			
			ResultSet rs = ppdstmt.executeQuery();
			while(rs.next()) {
				String userId = rs.getString("user_id");
				rs.close();
				ppdstmt.close();
				conn.close();
				return userId;
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String selectUserName(String userId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from user_info "
					+ "where user_id=?;");
			ppdstmt.setString(1, userId);
			
			ResultSet rs = ppdstmt.executeQuery();
			while(rs.next()) {
				String userName = rs.getString("user_name");
				rs.close();
				ppdstmt.close();
				conn.close();
				return userName;
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void updatePwd(String email, String pwd) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("update user_info set user_pwd=? where user_email=?;");
			ppdstmt.setString(1, pwd);
			ppdstmt.setString(2, email);
			ppdstmt.executeUpdate();
			ppdstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static int updateName(String email, String username) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("update user_info set user_name=? where user_email=?;");
			ppdstmt.setString(1, username);
			ppdstmt.setString(2, email);
			int count = ppdstmt.executeUpdate();
			ppdstmt.close();
			conn.close();
			return count;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int selectEmail(String email) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from user_info "
					+ "where user_email=?;");
			ppdstmt.setString(1, email);
			
			ResultSet rs = ppdstmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				count++;
				rs.close();
				ppdstmt.close();
				conn.close();
				return count;
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
