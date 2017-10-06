package com.user.mentor.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;

/**
 * Servlet implementation class UserChatMentor
 */
//@WebServlet("/UserChatMentor")
public class UserChatMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement pst,pst1;
    String query,query1;
    ResultSet rs;

public void init(ServletConfig config) throws ServletException
          {
          try
          {
           con = Dao.getConnection();//call getconnection metho of dao class
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
	  try
	  {
		  HttpSession session=request.getSession();
		  long mentorid=(Long)session.getAttribute("mentorid");
		  long ideaid=Long.parseLong(request.getParameter("ideaid")); 
		  long chatid=1;
		 String description=request.getParameter("description");
		 
		 query="select max(chatId) from usermentorchat"; //get max id of user database
	        pst=con.prepareStatement(query);
	        rs=pst.executeQuery();
	        int dbchatid=0;
	        while(rs.next())
	        {
	        	dbchatid=rs.getInt(1);
	        }
	        if(dbchatid==0)
	        	{
	        	chatid=dbchatid+chatid;
	        	}
	        else
	        {
     		chatid=dbchatid+1;
	        } 
		
	query1="insert into usermentorchat values(?,?,?,?)";
	pst1=con.prepareStatement(query1);
	pst1.setLong(1,chatid);
	pst1.setLong(2,ideaid);
	pst1.setLong(3,mentorid);
	pst1.setString(4,description);
	
	int i=pst1.executeUpdate();
	     if(i>0)
	     	{
		     out.println("<html><body style=background-color:#FFFFFF>");
	         out.println("<script type=\"text/javascript\">");
	         out.println("alert('Message send')");
	         out.println("document.location.href = 'mentor-dashboard.jsp';\n");
	         out.println("</script>");
	         out.println("</body></html>");
	     	}
	       }
	  catch(Exception e)
	  {
		  out.println(e);
	  }
     }
    }
