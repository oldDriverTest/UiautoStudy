package com.uiauto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private Connection conn = null;
/*构造方法，根据配置进行数据库的链接
 * **/
	public DatabaseConnection() {
		try {
			Class.forName(HelpUtil.getBaseinfo("dbdriver"));
			this.conn=DriverManager.getConnection(HelpUtil.getBaseinfo("dburl"), HelpUtil.getBaseinfo("dbuser"),
												  HelpUtil.getBaseinfo("dbpassword"));
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
