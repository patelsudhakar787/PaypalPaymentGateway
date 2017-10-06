package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;

/**
 * Servlet implementation class Matchemail
 */
//@WebServlet("/MatchEmail")
public class MatchEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
					//create object 
					Connection con;
					PreparedStatement pst;
					ResultSet rs;
	Dao dao = new Dao();//call dao class
	public void init(ServletConfig config) throws ServletException
            {
             try {
			con = Dao.getConnection();//call dao class getconnection 
		         }
            catch (ClassNotFoundException | IOException | SQLException e)
                 {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      	     }
	            }
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	      {
    	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    //get email id value
		String email=request.getParameter("email");
		      if(email.contains("@")&&email.contains("."))//validation of email
		        {  
		         try 
		            {  
					     pst=con.prepareStatement("select * from user  where emailid=?");  
				         pst.setString(1,email);  
				         rs=pst.executeQuery(); 
				         
				         //store database data
				         String dbemail="";
	             if(rs.next())
		             {  
			             out.print("<strong style=color:red> Email ID Already Exist!</strong>");  	
			        }
	               else
	                {  
			            out.print("<strong style=color:green> Email Available </strong>");
	            	} 
		           }
		  catch(Exception e)
		        {
			   out.print(e);
			    }  
		       }
		  else
		    {  
		   ///out.print("<strong style=color:red> Invalid email! </strong>");  
		  }  		
	     }
       @Override
       public void destroy() {
           Dao.cleanUp(con, pst, rs);
             }
	        }
