package com.springboot_tiles.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ZConnection {
	public static final String FAILURE = "Communication Link Failure.";
	public static final String CONNTIMEOUT = "Connection time Out.";
	
	public static void closeResultSet(ResultSet rst) throws SQLException{
		if(rst != null) {
			rst.close();
		}
	}
	public static void closePrepareStatment(PreparedStatement pst) throws SQLException{
		if(pst != null) {
			pst.close();
		}
	}
	public static void closeConnection(Connection conn) throws SQLException{
		if (conn != null) {
			conn.close();
	    }
	}
	public static void executeBatchPrepareStatement(PreparedStatement pst) throws SQLException{
		if(pst != null) {
			pst.executeBatch();
		}
	}
	public static void beginTransaction(Connection conn) throws SQLException{
		conn.setAutoCommit(false);
	}
	public static void commitTransaction(Connection conn) throws SQLException{
		conn.commit();
		conn.setAutoCommit(true);
	}
}
