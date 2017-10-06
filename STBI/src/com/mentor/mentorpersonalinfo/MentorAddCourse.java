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
 * Servlet implementation class Mentoraddcourse
 */
//@WebServlet("/MentorAddCourse")
public class MentorAddCourse extends HttpServlet {
private static final long serialVersionUID = 1L;
	 	//create object of connection,preparedstatement and resultset
		Connection con;
		String message = null;  // message will be sent back to client
		PreparedStatement p,ps,pst;
		ResultSet rs,rs1;
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
				String mentoremail=(String)session.getAttribute("mentoremail");
				long mentorcourseid=1;
				String coursename,description,level,prerequisite,monthweek,courseobjective,courseoutcomes,modules,tools,referencebooklink;
				coursename=request.getParameter("coursname");
				description=request.getParameter("descriptionss");
				level=request.getParameter("myVar");
				prerequisite=request.getParameter("courseprere");
				int duration=Integer.parseInt(request.getParameter("duration"));
				monthweek=request.getParameter("month");
				int coursecredit=Integer.parseInt(request.getParameter("credit"));
				courseobjective=request.getParameter("objective");
				courseoutcomes=request.getParameter("outcome");
				modules=request.getParameter("module");
				tools=request.getParameter("tools");
				referencebooklink=request.getParameter("reference");
				String se="select mentorId from mentor where emailid=?";   //get userid through email id
				p=con.prepareStatement(se);
				p.setString(1,mentoremail);
				rs1=p.executeQuery();
				long dbmentorid=0;
						while(rs1.next())
							{
							dbmentorid=rs1.getLong(1);  //get userid
							}
				String query="select max(mentorcourseId) from mentorcourse";
				pst=con.prepareStatement(query);
				rs=pst.executeQuery();
				long dbmentorcourseid=0;
					while(rs.next())
						{
						dbmentorcourseid=rs.getLong(1);
						}
					if(dbmentorcourseid==0)
							{
						mentorcourseid=dbmentorcourseid+mentorcourseid;	
							}
					else
							{
						mentorcourseid=dbmentorcourseid+1;
							}	
				String query1="insert into mentorcourse values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				ps=con.prepareStatement(query1);
				ps.setLong(1,mentorcourseid);
				ps.setString(2,coursename);
				ps.setString(3,description);
				ps.setString(4,level);
				ps.setString(5,prerequisite);
				ps.setInt(6,duration);
				ps.setString(7,monthweek);
				ps.setInt(8,coursecredit);
				ps.setString(9,courseobjective);
				ps.setString(10,courseoutcomes);
				ps.setString(11,modules);
				ps.setString(12,tools);
				ps.setString(13,referencebooklink);
				ps.setLong(14,dbmentorcourseid);
				int i=ps.executeUpdate();
				if(i>0)
					{
					out.println("<html><body style=background-color:#F0FFF0>");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Course Information inserted successfully')");
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
		Dao.cleanUp(con, p,rs1);
		Dao.cleanUp(null, pst,rs);	
		Dao.cleanUp(null, ps,null);	
		}
}
