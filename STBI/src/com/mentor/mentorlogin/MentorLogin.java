package com.mentor.mentorlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;

/**
 * Servlet implementation class Mentorlogin
 */
//@WebServlet("/MentorLogin")
public class MentorLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	RequestDispatcher rd;
	private String ismobile=null;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		ismobile=request.getParameter("is_Mobile");
		if(ismobile.equals("1"))
		{
			ismobile="0";
		}
			try
		       	{ 
				
				HttpSession session=request.getSession(); //create a session to pass user email id 
				//to use request dispatacher to include a meassage when email and password wrong
				String mentoremail=request.getParameter("email");  //to get a value from user email
				String password=request.getParameter("password"); //to get a password from user.
				MentorloginPojo log=new MentorloginPojo(); //call pojo class
				log.setEmail(mentoremail); //set email
				log.setPassword(password); //set password
					if(MentorloginDao.checkUser(log.getEmail(),log.getPassword()) ) //call LoginDao method that contain email and password code
						{
						//if email and password true then below code execute
						//  webres.data = "success";
						// webres.result= true;
						session.setAttribute("mentoremail",mentoremail);
						rd= request.getRequestDispatcher("/mentor-dashboard.jsp");
						rd.forward(request, response);
						}
					else
						{
						//if email and password false then below code execute
						//  webres.data = "unsuccessful";
						//   webres.result= false;
		        	    out.println("<html><body style=background-color:#F0FFF0>");
		        	    out.println("<script type=\"text/javascript\">");
		    	        out.println("alert('Wrong Username And Password Or Your Registration is in Approved Stage....')");
		    	        //out.println("document.location.href = 'mentor-login.jsp';\n");
		    	        out.println("</script>");
		    	        out.println("</body></html>");
		    	        } 
					// String res = gson.toJson(webres);//use gson for mobile app.
					//  out.write(res);
		       	}
		         	catch(Exception e)
							{
		         		out.println(e);
							}
			}
@Override
public void destroy() {
Dao.cleanUp(con, pst, rs);
}
	}
