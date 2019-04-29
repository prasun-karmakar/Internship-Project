package com.signify.internship.project.db;
import java.sql.Connection;
import java.sql.DriverManager;
import com.signify.internship.project.db.PropertyManager;
import com.signify.internship.project.db.DBManager;

	public class DBManager{
		
	private static String username=null;
	private static String pwd=null;
	private static String connURL=null;
	private static String dname=null;
	
	static Connection con=null;

	public static Connection getCon(){
	try{
		PropertyManager property=PropertyManager.INSTANCE;
		username=property.getValue("username");
		pwd=property.getValue("password");
		connURL=property.getValue("connURL");
		dname=property.getValue("dname");
		
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

