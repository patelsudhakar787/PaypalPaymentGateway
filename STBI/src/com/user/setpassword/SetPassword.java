package com.user.setpassword;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.Dao;

//@WebServlet("/SetPassword")
public class SetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
//create object
		Connection con;
		PreparedStatement pst;
    
public void init(ServletConfig config) throws ServletException
		{
			try {
				con = Dao.getConnection();
	    		}
			catch (ClassNotFoundException | IOException | SQLException e) 
		    	{
			e.printStackTrace();
		    	}
		}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			try
				{
					//get values
					String email=request.getParameter("email");
					String password=request.getParameter("Password");
				    String query="update user set password=? where emailid=?";//update password according to email id. 
				    pst=con.prepareStatement(query);
				    pst.setString(1,password);
				    pst.setString(2,email);
				    int i=pst.executeUpdate();//update successfully
				    out.println("<html><body style=background-color:#F0FFF0>");
				    out.println("<script type=\"text/javascript\">");
			        out.println("alert('You Set Your Password Suessfully..')");
			        out.println("document.location.href = 'begin-login.jsp';\n");
			        out.println("</script>");
			        out.println("</body></html>");
				}
		   catch(Exception e)
				{
			   out.println(e);
				}
		
		}
	}
