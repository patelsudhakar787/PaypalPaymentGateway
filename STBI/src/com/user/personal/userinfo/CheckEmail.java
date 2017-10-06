package com.user.personal.userinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.Dao;

public class CheckEmail 
{
public static boolean checkUser(String email) 
    	{
		boolean st =false;//by default st is false
		//create objects
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		try{
			con=Dao.getConnection(); //call dao class
			pst =con.prepareStatement("select emailid from user where emailid=?");//get email from user table
			pst.setString(1, email);
			rs =pst.executeQuery();
			String dbusername="";
			while(rs.next())
			{
				dbusername=rs.getString(1);
				if(dbusername.equals(email)) //match user email with database email
				{
					st=true;   //user email match database email then resultset true. 
				}
			}
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
		return st;            
    	}
	}
