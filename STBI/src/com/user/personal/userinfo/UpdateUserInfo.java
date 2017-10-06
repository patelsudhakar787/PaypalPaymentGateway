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
import com.mentor.mentorpersonalinfo.Checkemail;
import com.mentor.mentorpersonalinfo.Checkmobile;

/**
 * Servlet implementation class UpdateUserInfo
 */
//@WebServlet("/UpdateUserInfo")
public class UpdateUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//create object of connection,preparedstatement and resultset
    Connection con;
    String message = null;  // message will be sent back to client
    PreparedStatement ps,pst;
    ResultSet rs,rs1;
    private String ismobile=null;
    private String  useremail="";
    private int dbuserId=0;
  
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
			
		 }
		System.out.println("IsMobile"+ismobile);
		
		try
			{
			if(ismobile.equals("0"))
			{
				
				HttpSession session=request.getSession();
				 useremail=(String)session.getAttribute("useremail");
			}
				String mobile=request.getParameter("mobilenumber");
				String email=request.getParameter("email");
				String tempaddress=request.getParameter("address");
				
			 
				if(ismobile.equals("1"))
				{
			dbuserId=Integer.parseInt(request.getParameter("userId"));		
				}
				
				
			
				if(ismobile.equals("0") && CheckEmail.checkUser(email))
				{
				
					out.println("<html><body style=background-color:>");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Email ID Already Registered,Please  try another Email Id')");
					out.println("document.location.href = 'begin-dashboard.jsp';\n");
					out.println("</script>");
					out.println("</body></html>");		
				}
				else if(ismobile.equals("0") && CheckUserMobile.checkUser(mobile))
				{
					
					out.println("<html><body style=background-color:>");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Mobile Number Already Registered,Please try another Mobile Number')");
					out.println("document.location.href = 'begin-dashboard.jsp';\n");
					out.println("</script>");
					out.println("</body></html>");		
				}
				else
				{
					if(ismobile.equals("0"))
					{
						
					String se="select userId from user where emailid=?";   //get userid through email id
					ps=con.prepareStatement(se);
					ps.setString(1,useremail);
					rs1=ps.executeQuery();
					 dbuserId=0;
							while(rs1.next())
							{
								dbuserId=rs1.getInt(1);  //get userid
							}
							
					}
					
					System.out.println("1");
					
					String query="update user set mobilenumber=?,emailid=?,tempararyaddress=? where userId=?";
							pst=con.prepareStatement(query);
							pst.setString(1,mobile);
							pst.setString(2,email);
							pst.setString(3,tempaddress);
							pst.setLong(4,dbuserId);
							int i=pst.executeUpdate();
							System.out.println("i"+i);
							if(i==1)
							{
								if(ismobile.equals("0"))
								{
									System.out.println("undernull");
								out.println("<html><body style=background-color:>");
								out.println("<script type=\"text/javascript\">");
								out.println("alert('Record updated successfully')");
								out.println("document.location.href = 'begin-dashboard.jsp';\n");
								out.println("</script>");
								out.println("</body></html>");	
								}
								if(ismobile.equals("1"))
								{
									wb.result=true;
									wb.data="updated";
								}
							}
							if(i==0)
							{
								if(ismobile.equals("1"))
								{
									System.out.println("unsercondition");
									wb.result=false;
									wb.data="update failed";
								}
							}
							
							if(ismobile.equals("1"))
							{
								System.out.println("unsercondition");
								Gson gson=new Gson();
								String tojson=gson.toJson(wb);
								out.write(tojson);
							}
							
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
			Dao.cleanUp(null, ps, rs1);
	}
}


