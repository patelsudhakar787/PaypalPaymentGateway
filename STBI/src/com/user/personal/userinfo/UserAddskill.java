package com.user.personal.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UserAddskill
 */
//@WebServlet("/UserAddskill")
public class UserAddskill extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	//create object of connection,preparedstatement and resultset
    Connection con;
    String message = null;  // message will be sent back to client
    PreparedStatement pss,ps,pst;
    ResultSet rs,rs1;
    private String ismobile=null;
    private String useremail="";
    private int dbuserId=0;
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
			try
				{
				if(ismobile.equals("0"))
				{
				HttpSession session=request.getSession();
				useremail=(String)session.getAttribute("useremail");
				}
				long skilid=0;
				String skill=request.getParameter("skills");
				if(ismobile.equals("0"))
				{
				String se="select userId from user where emailid=?";   //get userid through email id
				pss=con.prepareStatement(se);
				pss.setString(1,useremail);
				rs1=pss.executeQuery();
				
				while(rs1.next())
						{
						dbuserId=rs1.getInt(1);  //get userid
						}
				
				}
				if(ismobile.equals("1"))
				{
					dbuserId=Integer.parseInt(request.getParameter("userid"));
				}
				String query="select max(skillid) from skills";
				ps=con.prepareStatement(query);
				rs=ps.executeQuery();
				long dbskillid=0;
				while(rs.next())
				{
					dbskillid=rs.getLong(1);	
				}
				if(dbskillid==0)
				{
					skilid=dbskillid+001;
				}
				else
				{
					skilid=	dbskillid+1;
				}
				String query1="insert into skills values(?,?,?)";
				pst=con.prepareStatement(query1);
				pst.setLong(1,skilid);
				pst.setString(2,skill);
				pst.setLong(3,dbuserId);
				int i=pst.executeUpdate();
				if(i==1)
				{
					if(ismobile.equals("0"))
					{
	    	    out.println("<html><body style=background-color:#FFFFFF>");
		        out.println("<script type=\"text/javascript\">");
		        out.println("alert('Record inserted successfully')");
		        out.println("document.location.href = 'begin-dashboard.jsp';\n");
		        out.println("</script>");
		        out.println("</body></html>"); 
				}
					
					//code for mobile application
					if(ismobile.equals("1"))
					{
						wb.data="Inserted";
						wb.result=true;
					}
				}
				else if(i==0)
				{
					if(ismobile.equals("0"))
					{
				out.println("<html><body style=background-color:#FFFFFF>");
		        out.println("<script type=\"text/javascript\">");
		        out.println("alert('Record not inserted')");
		        out.println("document.location.href = 'begin-dashboard.jsp';\n");
		        out.println("</script>");
		        out.println("</body></html>");  
		        out.println("");
		        RequestDispatcher rd=request.getRequestDispatcher("/begin-login.jsp");
				rd.include(request,response);
				}
					
					
					//code for mobile application
					if(ismobile.equals("1"))
					{
						wb.data="NotInserted";
						wb.result=false;
					}
				}
				
				else
				{
					out.print("Technical Issue");
				}
				
				
				if(ismobile.equals("1"))
				{
					Gson gson=new Gson();
					String tojson=gson.toJson(wb);
					out.write(tojson);
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
			Dao.cleanUp(con, pss, rs1);
			Dao.cleanUp(null, ps, rs);
			Dao.cleanUp(null, pst,null);
		}
}
