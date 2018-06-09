package com.uiauto.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uiauto.dao.BugDao;
import com.uiauto.util.DatabaseConnection;
import com.uiauto.util.DataUtil;
import com.uiauto.util.HelpUtil;
import com.uiauto.vo.Addbug;

public class BugDaoImpl implements BugDao {

	/**@author huluxia
	 * @version 1.0
	 * 获取addbuginformation表中的数据，用来新增bug
	 * 
	 * **/
	public List<Addbug> getAddbugdata() {
		// TODO Auto-generated method stub
		List<Addbug> list=new ArrayList<Addbug>();
		DatabaseConnection dbc=null;
		Connection coo=null;
		dbc=new DatabaseConnection();
		coo=dbc.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			String sql="select * from addbuginformation where run=1";
			ps=coo.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Addbug addbug=new Addbug();
				addbug.setProduct(rs.getString(2));
				addbug.setBugtitle(rs.getString(3));
				addbug.setErrolevel(rs.getString(4));
				addbug.setRepetestep(rs.getString(5));
				addbug.setExpextresult(rs.getString(6));
				list.add(addbug);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbc.close();
		}
		return list;
	}

	/**@author huluxia
	 * 此方法用来往addbuginformation表中的bugtitle字段插入数据，因为业务中
	 * bug标题不允许重复，所以这里要生成随机的bugtitle  详见类datautil
	 * ***/
	public boolean insertBugdata() {
		// TODO Auto-generated method stub
		boolean flag=false;
		int count = 0;
		DatabaseConnection dbc=null;
		Connection conn=null;
		dbc=new DatabaseConnection();
		conn=dbc.getConnection();
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rs=null;
		try
		{
			String sql="select count(*) from addbuginformation";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			for(int i=0;i<count;i++)
			{
				String random;
				String sql1="update addbuginformation set bugtitle=?,expextresult=? where id=?";
				ps1=conn.prepareStatement(sql1);
				random=DataUtil.randomNumber();
				ps1.setString(1,HelpUtil.getBaseinfo("bugtitle")+random);
				ps1.setString(2,HelpUtil.getBaseinfo("bugtitle")+random);
				ps1.setInt(3, i+1);
				ps1.executeUpdate();
			}
			flag=true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbc.close();
		}
		return flag;
	}
 
	
    /** @author huluxia
     *  此方法用来初始化addbuginformation表中的bugtitle字段，把他默认设置为空，
     * 
     * ***/
	public boolean returnDefault() {
		// TODO Auto-generated method stub
		boolean flag=false;
		DatabaseConnection dbc=null;
		Connection conn=null;
		dbc=new DatabaseConnection();
		conn=dbc.getConnection();
		PreparedStatement ps=null;
		try
		{
				String sql1="update addbuginformation set bugtitle=null,expextresult=null";
				ps=conn.prepareStatement(sql1);
				ps.executeUpdate();
			    flag=true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbc.close();
		}
		return flag;
	}

	public static void main(String[] args) {
		BugDaoImpl bdi=new BugDaoImpl();
		bdi.returnDefault();	
	}
 
}
