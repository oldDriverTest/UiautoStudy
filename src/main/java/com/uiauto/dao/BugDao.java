package com.uiauto.dao;

import java.util.List;

import com.uiauto.vo.Addbug;

public interface BugDao {
 
	public List<Addbug> getAddbugdata(); //读取添加bug界面的基本测试数据
	public boolean insertBugdata(); //添加信息
	public boolean returnDefault(); //数据初始化
}
 