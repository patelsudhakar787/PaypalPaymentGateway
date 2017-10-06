package com.user.personal.userinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.Dao;

public class CheckUserMobile
{
public static boolean checkUser(String mobile) 
    {
		boolean st =false;//by default st is false
		//create objects
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
			try{
				con=Dao.getConnection(); //call dao class
				pst =con.prepareStatement("select mobilenumber from user where mobilenumber=?");//get email from user table
				pst.setString(1, mobile);
				rs =pst.executeQuery();
				String dbmobile="";
				while(rs.next())
				{
					dbmobile=rs.getString(1);
					if(dbmobile.equals(mobile)) //match user email with database email
						{
						st=true;   //user email match database email then resultset true. 
						}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return st;
    	}
	}
