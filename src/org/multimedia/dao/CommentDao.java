package org.multimedia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.multimedia.domain.CommentDomain;
public class CommentDao {
	public static int insert(String resourceId, String userId, String comment, Timestamp commentTime) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("insert into comment "
					+ "values(?,?,?,?)");
			ppdstmt.setString(1, resourceId);
			ppdstmt.setString(2, userId);
			ppdstmt.setString(3, comment);
			ppdstmt.setTimestamp(4,  new java.sql.Timestamp(new java.util.Date().getTime()));
			
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
	
	public static List<CommentDomain> select(String resourceId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from comment"
					+ " where resource_id=?");
			ppdstmt.setString(1, resourceId);
			ResultSet rs = ppdstmt.executeQuery();
			
			List<CommentDomain> list = new ArrayList<>();
			while(rs.next()) {
				CommentDomain commentDomain = new CommentDomain();
				commentDomain.setComment(rs.getString("comment"));
				commentDomain.setResourceId(rs.getString("resource_id"));
				commentDomain.setUserId(rs.getString("user_id"));
				commentDomain.setCommentTime(rs.getTimestamp("comment_time"));
				
				list.add(commentDomain);
			}
			
			rs.close();
			ppdstmt.close();
			conn.close();
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<CommentDomain> selectMy(String userId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from comment"
					+ " where user_id=?");
			ppdstmt.setString(1, userId);
			ResultSet rs = ppdstmt.executeQuery();
			
			List<CommentDomain> list = new ArrayList<>();
			while(rs.next()) {
				CommentDomain commentDomain = new CommentDomain();
				commentDomain.setComment(rs.getString("comment"));
				commentDomain.setResourceId(rs.getString("resource_id"));
				commentDomain.setUserId(rs.getString("user_id"));
				commentDomain.setCommentTime(rs.getTimestamp("comment_time"));
				
				list.add(commentDomain);
			}
			
			rs.close();
			ppdstmt.close();
			conn.close();
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int delete(String resourceId, String userId, String comment) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("delete from comment where resource_id=? and user_id=? "
					+ "and comment=?;");
			ppdstmt.setString(1, resourceId);
			ppdstmt.setString(2, userId);
			ppdstmt.setString(3, comment);
			
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
}



