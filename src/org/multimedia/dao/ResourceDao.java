package org.multimedia.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.multimedia.domain.ResourceDomain;


public class ResourceDao {
	public static int insert(ResourceDomain resourceDomain) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdst = conn.prepareStatement("insert into resource "
					+ "values(?,?,?,?,?,?,?,?,?);");
			
			ppdst.setString(1, resourceDomain.getResourceId());
			ppdst.setString(2, resourceDomain.getUserId());
			ppdst.setString(3, resourceDomain.getResourceName());
			ppdst.setString(4, resourceDomain.getResourceList());
			ppdst.setInt(5, resourceDomain.getResourceView());
			ppdst.setString(6, resourceDomain.getMessageRetrieval());
			ppdst.setInt(7, resourceDomain.getResourceClassify());
			ppdst.setTimestamp(8, resourceDomain.getResourceUploadTime());
			ppdst.setInt(9, resourceDomain.getResourceDownloadNumber());
			
			int count = ppdst.executeUpdate();
			ppdst.close();
			conn.close();
			return count;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static List<ResourceDomain> selectUpload(String userId) {
		
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource "
					+ "where user_id=?;");
			
			ppdstmt.setString(1, userId);
			
			ResultSet rs = ppdstmt.executeQuery();
			
			List<ResourceDomain> resourceDomain = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resource = new ResourceDomain();
				resource.setResourceId(rs.getString("resource_id"));
				resource.setResourceName(rs.getString("resource_name"));
				resource.setResourceUploadTime(rs.getTimestamp("resource_uploadtime"));
				resource.setResourceClassify(rs.getInt("resource_classify"));
				resource.setResourceList(rs.getString("resource_list"));
				resourceDomain.add(resource);
			}
			
			rs.close();
			ppdstmt.close();
			conn.close();
			return resourceDomain;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String selectResourcePath(String resouceId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource where resource_id=?;");
			ppdstmt.setString(1, resouceId);
			
			ResultSet rs = ppdstmt.executeQuery();
			while(rs.next()) {
				return rs.getString("resource_list");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void deleteFile(String resourceId) {
		File file = new File(selectResourcePath(resourceId));
		if(file.exists() && file.isFile()) 
			file.delete();
	}
	
	public static void delete(String resourceId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("delete from resource where resource_id=?;");
			
			ppdstmt.setString(1, resourceId);
			ppdstmt.executeUpdate();
			
			ppdstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResourceDomain selectView(String resourceId) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource where resource_id=?;");
			ppdstmt.setString(1, resourceId);
			
			ResultSet rs = ppdstmt.executeQuery();
			while(rs.next()) {
				ResourceDomain resourceDomain =  new ResourceDomain(rs.getString("resource_id"),
																	rs.getString("user_id"),
																	rs.getString("resource_name"),
																	rs.getString("resource_list"),
										  							rs.getInt("resource_view"),
										  							rs.getString("message_retrieval"),
										  							rs.getInt("resource_classify"),
										  							rs.getTimestamp("resource_uploadtime"),
										  							rs.getInt("resource_downloadnumber"));
				rs.close();
				ppdstmt.close();
				conn.close();
				return resourceDomain;
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<ResourceDomain> selectLimit() {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource limit 10");
			ResultSet rs = ppdstmt.executeQuery();
			
			List<ResourceDomain> list = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resourceDomain =  new ResourceDomain(rs.getString("resource_id"),
																	rs.getString("user_id"),
																	rs.getString("resource_name"),
																	rs.getString("resource_list"),
																	rs.getInt("resource_view"),
																	rs.getString("message_retrieval"),
																	rs.getInt("resource_classify"),
																	rs.getTimestamp("resource_uploadtime"),
																	rs.getInt("resource_downloadnumber"));
				list.add(resourceDomain);
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
	
	public static List<ResourceDomain> selectDownload() {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource order by resource_downloadnumber desc"
                           + " limit 10;");
			ResultSet rs = ppdstmt.executeQuery();
			
			List<ResourceDomain> list = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resourceDomain =  new ResourceDomain(rs.getString("resource_id"),
																	rs.getString("user_id"),
																	rs.getString("resource_name"),
																	rs.getString("resource_list"),
																	rs.getInt("resource_view"),
																	rs.getString("message_retrieval"),
																	rs.getInt("resource_classify"),
																	rs.getTimestamp("resource_uploadtime"),
																	rs.getInt("resource_downloadnumber"));
				list.add(resourceDomain);
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
	
	public static List<ResourceDomain> selectDownloadClassify(int classify) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource where resource_classify=?"
					+ " order by resource_downloadnumber desc limit 4;");
			ppdstmt.setInt(1, classify);
			ResultSet rs = ppdstmt.executeQuery();
			
			List<ResourceDomain> list = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resourceDomain =  new ResourceDomain(rs.getString("resource_id"),
																	rs.getString("user_id"),
																	rs.getString("resource_name"),
																	rs.getString("resource_list"),
																	rs.getInt("resource_view"),
																	rs.getString("message_retrieval"),
																	rs.getInt("resource_classify"),
																	rs.getTimestamp("resource_uploadtime"),
																	rs.getInt("resource_downloadnumber"));
				list.add(resourceDomain);
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
	
	public static List<ResourceDomain> selectNewClassify(int classify) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource where resource_classify=?"
					+ " order by resource_uploadtime desc limit 4;");
			ppdstmt.setInt(1, classify);
			ResultSet rs = ppdstmt.executeQuery();
			
			List<ResourceDomain> list = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resourceDomain =  new ResourceDomain(rs.getString("resource_id"),
																	rs.getString("user_id"),
																	rs.getString("resource_name"),
																	rs.getString("resource_list"),
																	rs.getInt("resource_view"),
																	rs.getString("message_retrieval"),
																	rs.getInt("resource_classify"),
																	rs.getTimestamp("resource_uploadtime"),
																	rs.getInt("resource_downloadnumber"));
				list.add(resourceDomain);
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
	
	public static void addDownloadNumber(String inputPath) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("update resource set resource_downloadnumber=resource_downloadnumber+1" + 
					" where resource_list=?;");
			ppdstmt.setString(1, inputPath);
			ppdstmt.executeUpdate();
			ppdstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<ResourceDomain> select(int classify, String method) {
		try {
			Connection conn = DBManager.getConn();
			String sql = "";
			if(method.equals("hot"))
				sql = "select * from resource where resource_classify=? order by resource_downloadnumber desc";
			else
				sql = "select * from resource where resource_classify=? order by resource_uploadtime desc";
			PreparedStatement ppdstmt = conn.prepareStatement(sql);
			ppdstmt.setInt(1, classify);
			ResultSet rs = ppdstmt.executeQuery();
			
			List<ResourceDomain> list = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resourceDomain =  new ResourceDomain(rs.getString("resource_id"),
																	rs.getString("user_id"),
																	rs.getString("resource_name"),
																	rs.getString("resource_list"),
																	rs.getInt("resource_view"),
																	rs.getString("message_retrieval"),
																	rs.getInt("resource_classify"),
																	rs.getTimestamp("resource_uploadtime"),
																	rs.getInt("resource_downloadnumber"));
				list.add(resourceDomain);
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
	
	public static List<ResourceDomain> retrievalResource(String retrieval, int i)
	{
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = null;
			if(i==0)
			{
				ppdstmt = conn.prepareStatement("select * from resource where resource_name like '%"+retrieval+"%' or resource_list like '%"+retrieval+"%';");
			//PreparedStatement ppdstmt = conn.prepareStatement("select * from resource;");
				//ppdstmt.setString(1, retrieval);
			}
			else if(i==1)
			{
				ppdstmt = conn.prepareStatement("select * from resource where resource_classify=1 and resource_name like '%"+retrieval+"%' or resource_list like '%"+retrieval+"%';");
			}
			else if(i==2)
			{
				ppdstmt = conn.prepareStatement("select * from resource where resource_classify=2 and resource_name like '%"+retrieval+"%' or resource_list like '%"+retrieval+"%';");
			}
			else if(i==3)
			{
				ppdstmt = conn.prepareStatement("select * from resource where resource_classify=3 and resource_name like '%"+retrieval+"%' or resource_list like '%"+retrieval+"%';");
			}
			else
			{
				ppdstmt = conn.prepareStatement("select * from resource where resource_classify=4 and resource_name like '%"+retrieval+"%' or resource_list like '%"+retrieval+"%';");
			}
			//ppdstmt.setString(1, retrieval);
			ResultSet rs = ppdstmt.executeQuery();
				
			List<ResourceDomain> resources = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resource= new ResourceDomain();
				//String resourceName=rs.getString("resource_name");				
				//if(resourceName.indexOf(retrieval,0)>0)
				//{
				resource.setResourceId(rs.getString("resource_id"));
				resource.setUserId(rs.getString("user_id"));
				resource.setResourceName(rs.getString("resource_name"));
				resource.setResourceView(rs.getInt("resource_view"));				
				resource.setResourceClassify(rs.getInt("resource_classify"));
				resource.setResourceUploadTime(rs.getTimestamp("resource_uploadtime"));
				resource.setResourceDownloadNumber(rs.getInt("resource_downloadnumber"));
				resources.add(resource);
				//}
			}
			rs.close();
			ppdstmt.close();
			conn.close();
			return resources;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	public static List<ResourceDomain> select()
	{
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from resource;");
				
			ResultSet rs = ppdstmt.executeQuery();
				
			List<ResourceDomain> resources = new ArrayList<>();
			while(rs.next()) {
				ResourceDomain resource= new ResourceDomain();
				resource.setResourceId(rs.getString("resource_id"));
				resource.setUserId(rs.getString("user_id"));
				resource.setResourceName(rs.getString("resource_name"));
				resource.setResourceView(rs.getInt("resource_view"));				
				resource.setResourceClassify(rs.getInt("resource_classify"));
				resource.setResourceUploadTime(rs.getTimestamp("resource_uploadtime"));
				resource.setResourceDownloadNumber(rs.getInt("resource_downloadnumber"));
				resources.add(resource);
			}
			rs.close();
			ppdstmt.close();
			conn.close();
			return resources;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
}


