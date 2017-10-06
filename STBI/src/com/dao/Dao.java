package com.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class Dao
{
static Connection con;
public static Connection getConnection() throws IOException,SQLException,ClassNotFoundException  //create getConnection method 
		{
			try 
			{
				//create string that contain database driver and database coonection path
				String dbClassName="com.mysql.jdbc.Driver";
				String connect="jdbc:mysql://127.0.0.1/stbi1?autoReconnect=true";
				Class.forName(dbClassName);//pass dbclassname string
				Properties p=new Properties();//create properties class of util pacakage
				p.put("user", "root");
				p.put("password", "root");
				con=DriverManager.getConnection(connect,p);  
			} 
		    catch (Exception e)
			{
		    	System.out.println(e);
		    }
				return con;
		}
public static Connection cleanUp(Connection con, PreparedStatement pst, ResultSet rs)//a method which can close and clean up the connection
	       {
		try
			{
				if(con!=null)
			{
					con.close();
			}
				if(pst!=null)
			{
					pst.close();
			}
				if(rs!=null)
			{
					rs.close();
			}
		     }
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return con;
	       }
}
	  
