package com.uiauto.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.uiauto.vo.Addbug;

public class Test {

	public static void ok(){
		BugDaoImpl bdi=new BugDaoImpl();
		List<Addbug> list=new ArrayList<Addbug>();
		list=bdi.getAddbugdata();
		for(Addbug addbug:list)
		{
			System.out.println(addbug.getProduct()+" "+addbug.getBugtitle()
			+addbug.getErrolevel()+" "+addbug.getRepetestep()
					);
		}
	}
	
	public static void main(String[] args) {
		BugDaoImpl bdi=new BugDaoImpl();
		List<Addbug> list=new ArrayList<Addbug>();
		list=bdi.getAddbugdata();
		Iterator<Addbug> iter=list.iterator();
		while(iter.hasNext())
		{
			Addbug addbug=iter.next();
			System.out.println(addbug.getProduct()+" "+addbug.getBugtitle()
						       +" "+addbug.getErrolevel()+" "+addbug.getRepetestep()
					);
		}
	}
}
