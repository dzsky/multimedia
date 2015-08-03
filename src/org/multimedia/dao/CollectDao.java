package org.multimedia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.multimedia.domain.CollectDomain;


public class CollectDao {
	public static int insert(String userId, String resourceId, Date collectTime, String resourceName) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("insert into collect "
					+ "values(?,?,?,?);");
			ppdstmt.setString(1, userId);
			ppdstmt.setString(2, resourceId);
			ppdstmt.setDate(3, collectTime);
			ppdstmt.setString(4, resourceName);
			
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
	
	public static List<CollectDomain> select(String userId) {
		try {
			List<CollectDomain> list = new ArrayList<>();
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from collect "
					+ "where user_id=?;");
			ppdstmt.setString(1, userId);
			
			ResultSet rs = ppdstmt.executeQuery();
			while(rs.next()) {
				CollectDomain collectDomain = new CollectDomain(rs.getString("user_id")
						,rs.getString("resource_id"), rs.getDate("collect_time"), rs.getString("resource_name"));
				list.add(collectDomain);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void deleteResource(String resourceId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("delete from collect "
					+ "where resource_id=?;");
			ppdstmt.setString(1, resourceId);
			ppdstmt.executeUpdate();
			ppdstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(String resourceId, String userId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("delete from collect "
					+ "where resource_id=? and user_id=?;");
			ppdstmt.setString(1, resourceId);
			ppdstmt.setString(2, userId);
			ppdstmt.executeUpdate();
			ppdstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int select(String resourceId, String userId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from collect "
					+ "where user_id=? and resource_id=?;");
			ppdstmt.setString(1, userId);
			ppdstmt.setString(2, resourceId);
			
			
			int count = 0;
			ResultSet rs = ppdstmt.executeQuery();
			while(rs.next()) {
				count ++;
			}
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
}


