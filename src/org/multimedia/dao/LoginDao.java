package org.multimedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.multimedia.domain.LoginDomain;

public class LoginDao {
	public static int select(LoginDomain loginDomain) {
		try {
			Connection conn = DBManager.getConn();
			PreparedStatement ppdstmt = conn.prepareStatement("select * from login "
					+ "where user_email=? and user_pwd=?;");
			ppdstmt.setString(1, loginDomain.getUserEmail());
			ppdstmt.setString(2, loginDomain.getUserPwd());
			
			ResultSet rs = ppdstmt.executeQuery();
			rs.last();
			int count = rs.getRow();
			//rs.beforeFirst();
			
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
