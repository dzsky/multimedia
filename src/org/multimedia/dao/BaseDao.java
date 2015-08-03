package org.multimedia.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



public class BaseDao {
	public Object getSingle(String sql, Class clazz, Object params[]) 
		throws SQLException {
		Connection conn = DBManager.getConn();
		QueryRunner runner = new QueryRunner();
		Object object = runner.query(conn, sql, new BeanHandler<Object>(clazz), params);
		DbUtils.close(conn);
		return object;
	}
	
	public List getList(String sql, Class clazz, Object params[])
			throws SQLException {
		Connection conn = DBManager.getConn();
		QueryRunner runner = new QueryRunner();
		List list = (List) runner.query(conn, sql, new BeanListHandler<Object>(clazz),
				params);
		DbUtils.close(conn);
		return list;
	}
	
	public int update(String sql, Object params[]) throws SQLException {
		Connection conn = DBManager.getConn();
		QueryRunner runner = new QueryRunner();
		int count = runner.update(conn, sql, params);
		DbUtils.close(conn);
		return count;
	}
	
	public boolean insert(String sql, Object params[]) throws SQLException {
		Connection conn = DBManager.getConn();
		QueryRunner runner = new QueryRunner();
		int count = runner.update(conn, sql,  params);
		DbUtils.close(conn);
		return (count != 0);
	}
}
