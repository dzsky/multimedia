package org.multimedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.multimedia.domain.AuditDomain;
import org.multimedia.domain.ResourceDomain;

public class CheckDao {
	//查询待审核记录
	public static List<AuditDomain> selectCheck()
	{
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from audit;");
				
			ResultSet rs = ppdstmt.executeQuery();
				
			List<AuditDomain> duditDomain = new ArrayList<>();
			while(rs.next()) {
				AuditDomain audit= new AuditDomain();
				audit.setResourceId(rs.getString("resource_id"));
				audit.setUploadTime(rs.getDate("upload_time"));
				audit.setUserId(rs.getString("user_id"));				
				audit.setResourceName(rs.getString("resource_name"));
				audit.setResourceClassify(rs.getInt("resource_classify"));
				duditDomain.add(audit);
			}
			rs.close();
			ppdstmt.close();
			conn.close();
			return duditDomain;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	//更新
	public static List<AuditDomain> selectUpload()
	{
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from audit; ");
			
			ResultSet rs = ppdstmt.executeQuery();
			
			List<AuditDomain> duditDomain = new ArrayList<>();
			while(rs.next()) {
				AuditDomain audit= new AuditDomain();
				audit.setResourceId(rs.getString("resource_id"));
				audit.setUploadTime(rs.getDate("upload_time"));
				audit.setUserId(rs.getString("user_id"));				
				audit.setResourceName(rs.getString("resource_name"));
				audit.setResourceClassify(rs.getInt("resource_classify"));
				duditDomain.add(audit);
			}
			
			rs.close();
			ppdstmt.close();
			conn.close();
			return duditDomain;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
		
		//删除审核通过的记录
		public static void delete(String resourceId)
		{
			try {
				Connection conn = DBManager.getConn();
				PreparedStatement ppdstmt = conn.prepareStatement("delete from audit where resource_id=?;");
				
				ppdstmt.setString(1, resourceId);
				ppdstmt.executeUpdate();
				
				ppdstmt.close();
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
