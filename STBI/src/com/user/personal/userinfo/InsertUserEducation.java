package com.user.personal.userinfo;

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
import com.dao.WebResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class InsertUserEducation
 */
//@WebServlet("/InsertUserEducation")
public class InsertUserEducation extends HttpServlet
{
		private static final long serialVersionUID = 1L;
	  //create object of connection,preparedstatement and resultset
		Connection con;
		String message = null;  // message will be sent back to client
		PreparedStatement p,ps,pst;
		ResultSet rs,rs1,rs2;
		private String ismobile=null;
		private String useremail="";
		int dbuserId=0;
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
		WebResponse wb=new WebResponse();
		
		ismobile=request.getParameter("is_Mobile");
		if(ismobile == null)
		{
			ismobile="0";
			System.out.println("under");
		}
		
		if(ismobile.equals("1"))
		{
			dbuserId=Integer.parseInt(request.getParameter("userid"));
			System.out.println("userid"+dbuserId);
		}
		try
			{
			if(ismobile.equals("0"))
			{
			HttpSession session=request.getSession();
			useremail=(String)session.getAttribute("useremail");
			}
			int educid=1;
			String college=request.getParameter("name");
			String qualification=request.getParameter("degree");
			String stream=request.getParameter("field");
			String grade=request.getParameter("grade");
			String fromdate=request.getParameter("fromdate");
			String todate=request.getParameter("todate");
			String description=request.getParameter("description");
			System.out.println("name"+college);
			System.out.println("name"+description);
			if(ismobile.equals("0"))
			{
			String se="select userId from user where emailid=?";   //get userid through email id
			p=con.prepareStatement(se);
			p.setString(1,useremail);
			rs2=p.executeQuery();
			
					while(rs2.next())
						{
						dbuserId=rs2.getInt(1);  //get userid
						}
			}
		
					String query="select max(eduid) from education";
					pst=con.prepareStatement(query);
					rs=pst.executeQuery();
					int dbeduid=0;
					while(rs.next())
					{
						dbeduid=rs.getInt(1);
					}
					if(dbeduid==0)
					{
						educid=dbeduid+educid;	
					}
					else
					{
						educid=dbeduid+1;
					}
					String query1="insert into education values(?,?,?,?,?,?,?,?,?)";
					ps=con.prepareStatement(query1);
					ps.setInt(1,educid);
					ps.setString(2,college);
					ps.setString(3,qualification);
					ps.setString(4,stream);
					ps.setString(5,grade);
					ps.setString(6,fromdate);
					ps.setString(7,todate);
					ps.setString(8,description);
					ps.setInt(9,dbuserId);
					int i=ps.executeUpdate();
					if(i==1)
					{
						if(ismobile.equals("0"))
						{
						out.println("<html><body style=background-color:>");
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Educational details inserted successfully')");
						out.println("document.location.href = 'begin-dashboard.jsp';\n");
						out.println("</script>");
						out.println("</body></html>");	
						}
						
						
						if(ismobile.equals("1"))
						{
							wb.data="Inserted";
							wb.result=true;
						}
					}
					else if(i==0)
					{
						if(ismobile.equals("1"))
						{
							wb.data="NotInserted";
							wb.result=false;
						}
					}
					else
					{
						out.write("Technical Issue");
					}
					
					if(ismobile.equals("1"))
					{
						System.out.println("under");
						Gson gson=new Gson();
						String tojson=gson.toJson(wb);
						out.print(tojson);
						System.out.println("Response"+tojson);
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
	Dao.cleanUp(con, p, rs1);
	Dao.cleanUp(null, pst, rs);
    Dao.cleanUp(null, ps, rs2);
	}
}
