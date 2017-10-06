package com.user.newuser.request.support;

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

import com.dao.Dao;

/**
 * Servlet implementation class UserRequestSupport
 */
//@WebServlet("/UserRequestSupport")
public class UserRequestSupport extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement ps,pst;
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
						long requestsupportid=1;
						long ideaid=Long.parseLong(request.getParameter("ideaid"));
						String supporttype=request.getParameter("support");
						String description=request.getParameter("requestdetails");
						String query="select max(RequestsupportId) from newuserrequestsupport";
						pst=con.prepareStatement(query);
						rs=pst.executeQuery();
						long dbrequestsupportid=0;
						while(rs.next())
							{
							dbrequestsupportid=rs.getLong(1);
							}
						if(dbrequestsupportid==0)
							{
							requestsupportid=dbrequestsupportid+requestsupportid;	
							}
						else
							{
							requestsupportid=dbrequestsupportid+1;
							}
						String query1="insert into newuserrequestsupport values(?,?,?,?)";
						ps=con.prepareStatement(query1);
						ps.setLong(1,requestsupportid);
						ps.setString(2,supporttype);
						ps.setString(3,description);
						ps.setLong(4,ideaid);
						int i=ps.executeUpdate();
						if(i>0)
							{
							out.println("<html><body style=background-color:>");
							out.println("<script type=\"text/javascript\">");
							out.println("alert('Support request send successfully')");
							out.println("document.location.href = 'begin-dashboard.jsp';\n");
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
			Dao.cleanUp(con, pst, rs);
			Dao.cleanUp(null, ps,null);
			}
		}
