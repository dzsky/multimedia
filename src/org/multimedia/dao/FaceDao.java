package org.multimedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FaceDao {
	public static int setFace(String userId, String path) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("insert into face values(?,?);");
			ppdstmt.setString(2, path);
			ppdstmt.setString(1, userId);
			
			int count = ppdstmt.executeUpdate();
			return count;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String selectPath(String userId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from face where user_id=?;");
	
			ppdstmt.setString(1, userId);
			
			ResultSet rs = ppdstmt.executeQuery();
			String path = "";
			while(rs.next()) {
				path = rs.getString("path");
				rs.close();
				ppdstmt.close();
				conn.close();
			}
			return path;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
