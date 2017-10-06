package com.mentor.mentorlogin;

import java.sql.*;

import com.dao.Dao;

public class MentorloginDao
{
public static boolean checkUser(String email,String password)  //call a static checkUser mentod with three urgument 
		{
      	boolean st =false;  //bydefault st is false
      	Connection con;//create connection object
      	PreparedStatement pst; //create preparedstatement object
      	ResultSet rs;// create resultset object
      		try{
      			con=Dao.getConnection();//access dao class that contain database connection data.
      			pst =con.prepareStatement("select emailid,password,registrationstatus from mentor where emailid=? and password=?");//fire a query
      			pst.setString(1, email);//set email
      			pst.setString(2, password);//set password
      			rs =pst.executeQuery();//execute query
      			String dbusername="",dbpassword="",dbregistrationstatus="";//write variable and stored table data.
      				while(rs.next())
      				{
      					dbusername=rs.getString(1);
      					dbpassword= rs.getString(2);
      					dbregistrationstatus=rs.getString(3);
      						if(dbusername.equals(email) && dbpassword.equals(password) && dbregistrationstatus.equals("Approved"))//check three conditions.
      							{
      							st=true; //if resultset true then go to next page
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
