package com.signify.internshipproject.webappservice.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.signify.internshipproject.webappservice.db.DBManager;
import com.signify.internshipproject.webappservice.db.PropertyManager;

	public class DBManager{
		
	private static String username=null;
	private static String pwd=null;
	private static String connURL=null;
	private static String dname=null;
	
	static Connection con=null;

	public static Connection getCon(){
	try{
		PropertyManager property=PropertyManager.INSTANCE;
		Values val=Values.USERNAME;
		username=property.getValue(val.getValue());
		Values val1=Values.PASSWORD;
		pwd=property.getValue(val1.getValue());
		Values val2=Values.CONNURL;
		connURL=property.getValue(val2.getValue());
		Values val3=Values.DNAME;
		dname=property.getValue(val3.getValue());
		Class.forName(dname);
		con=DriverManager.getConnection(connURL,username,pwd);
	
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	return con;
	}
	}



