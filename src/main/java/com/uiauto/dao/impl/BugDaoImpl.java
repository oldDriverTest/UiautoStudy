package com.uiauto.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uiauto.dao.BugDao;
import com.uiauto.util.DatabaseConnection;
import com.uiauto.vo.Addbug;

public class BugDaoImpl implements BugDao {

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
			String sql="select * from addbuginformation";
			ps=coo.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Addbug addbug=new Addbug();
				addbug.setProduct(rs.getString(2));
				addbug.setBugtitle(rs.getString(3));
				addbug.setErrolevel(rs.getString(4));
				addbug.setRepetestep(rs.getString(5));
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

	
	public boolean insertBugdata(Addbug addbug) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean returnDefault() {
		// TODO Auto-generated method stub
		return false;
	}

}
