package com.uiauto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String dbdriver = "com.mysql.jdbc.Driver";
	private static final String dburl = "jdbc:mysql://localhost:3306/uiauto";
	private static final String dbuser = "root";
	private static final String dbpassword = "070312";
	private Connection conn = null;
/*构造方法，根据配置进行数据库的链接
 * **/
	public DatabaseConnection() {
		try {
			Class.forName(dbdriver);
			this.conn=DriverManager.getConnection(dburl, dbuser, dbpassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
	
	public void close() {
		if(this.conn!=null)
		{
			try {
				this.conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	} 

}
