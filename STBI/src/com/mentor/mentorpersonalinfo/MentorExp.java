package com.mentor.mentorpersonalinfo;

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
 * Servlet implementation class Mentorexp
 */
//@WebServlet("/MentorExp")
public class MentorExp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//create object of connection,preparedstatement and resultset
    Connection con;
    String message = null;  // message will be sent back to client
    PreparedStatement ps,pst;
    ResultSet rs;
    //call dao class
public void init(ServletConfig config) throws ServletException
	{
		try {
			con = Dao.getConnection();  //call dao.getconnection method
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
				HttpSession session=request.getSession();
				long mentorid=(Long)session.getAttribute("mentorid");
				long mentorexpid=001;
				String designation=request.getParameter("designation");
				String companyname=request.getParameter("company");
				String location=request.getParameter("location");
				String fromdate=request.getParameter("fromdate");
				String todate=request.getParameter("todate");
				String descripton=request.getParameter("description");
				String query="select max(mentorexpId) from mentorexperience";
				pst=con.prepareStatement(query);
				rs=pst.executeQuery();
				long dbmentorexpid=0;
				while(rs.next())
					{
					dbmentorexpid=rs.getLong(1);
					}
					if(dbmentorexpid==0)
						{
						mentorexpid=dbmentorexpid+mentorexpid;	
						}
					else
					{
						mentorexpid=dbmentorexpid+1;
					}
					String query1="insert into mentorexperience values(?,?,?,?,?,?,?,?)";
					ps=con.prepareStatement(query1);
					ps.setLong(1,mentorexpid);
					ps.setString(2,designation);
					ps.setString(3,companyname);
					ps.setString(4,location);
					ps.setString(5,fromdate);
					ps.setString(6,todate);
					ps.setString(7,descripton);
					ps.setLong(8,mentorid);
					int i=ps.executeUpdate();
					if(i>0)
					{
						out.println("<html><body style=background-color:#F0FFF0>");
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Experience details inserted successfully')");
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
@Override
public void destroy() 
		{
			
		Dao.cleanUp(con, pst,rs);
		Dao.cleanUp(null, ps,null);
		}
	}
