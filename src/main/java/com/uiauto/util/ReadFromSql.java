package com.uiauto.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ReadFromSql {

	public  Map<String, String> getLocator(String name)
	{
		Map<String, String> map=new HashMap<String, String>();
		DatabaseConnection dbc=new DatabaseConnection();
		Connection conn=dbc.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			String sql="select type,locate from object where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			boolean flag=true;//用來判断究竟输入的name是否查到了数据
			while(rs.next())
			{
				String type=rs.getString(1);
				String locate=rs.getString(2);
				
				map.put("type", type);
				map.put("value", locate);
				flag=false;
			}
			
			if(flag)
			{
				System.out.println("输入的名称"+name+"有误或者数据库不存在输入的名称，请检查......");
			} 
		}
		
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		dbc.close();
		return map;
	}
}
