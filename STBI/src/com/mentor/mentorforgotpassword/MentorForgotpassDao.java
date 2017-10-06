package com.mentor.mentorforgotpassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.Dao;

public class MentorForgotpassDao 
{
public static boolean checkUser(String email) 
 		{
		boolean st =false;
		Connection con;
		PreparedStatement pst;
			try
				{
				con=Dao.getConnection();
				PreparedStatement ps =con.prepareStatement("select * from mentor where emailid=? ");
				ps.setString(1, email);
				ResultSet rs =ps.executeQuery();
				String dbpass="";
				st = rs.next();
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return st;                 
 		}   
	}
