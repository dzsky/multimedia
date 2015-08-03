package org.multimedia.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.multimedia.domain.LastIdDomain;

import java.sql.*;

public class LastIdDao {
	
	public static LastIdDomain getSingle(int number) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from lastid"
				+ " where uorr=?;");
			ppdstmt.setInt(1, number);
			
			ResultSet rs = ppdstmt.executeQuery();
			while(rs.next()) {
				return new LastIdDomain(rs.getInt("uorr"), rs.getInt("num"));
			}
			
			rs.close();
			ppdstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return new LastIdDomain(-1, -1);
	}
	
	public static void update(int uorr, int num) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("update lastid set num=?"
					+ " where uorr=?;");
			ppdstmt.setInt(1, num);
			ppdstmt.setInt(2, uorr);
			ppdstmt.executeUpdate();
			
			ppdstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
