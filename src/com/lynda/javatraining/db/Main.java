package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {	
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";	
	public static void main(String args[]) throws SQLException {
		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT stateId, stateName FROM states");
				) {								
			rs.last();
			System.out.println("Number of rows: "+rs.getRow());
		}catch(SQLException e){
			DBUtil.processException(e);
		}
	}
}
