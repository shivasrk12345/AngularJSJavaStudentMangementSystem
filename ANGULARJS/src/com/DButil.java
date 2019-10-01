package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DButil {
	private static final String drivername="oracle.jdbc.driver.OracleDriver";
	//private static final String url="jdbc:oracle:thin:@intvmoradb04:1521:ORAJAVADB";
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username="system";
	private static final String password="admin";

	
	
	public static Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName(drivername);
			try {
				con=DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	public static void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void closeStatement(PreparedStatement ps)
	{
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
