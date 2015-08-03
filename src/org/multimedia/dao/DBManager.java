package org.multimedia.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBManager {
	private static String url = "jdbc:mysql://localhost:3306/multimedia";
	private static String username = "root";
	private static String password = "123456";
	
    public static Connection getConn(){  
    	Connection conn = null;
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection(url, username, password);	
    	}
    	catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return conn;
    }
}

