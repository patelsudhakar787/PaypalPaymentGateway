package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;

/**
 * Servlet implementation class Registration
 */
//@WebServlet("/Registration")
public class Registration extends HttpServlet {
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

    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		        try
		          {
					int UserId=100000;
					String firstname=request.getParameter("fname");
					String middlename=request.getParameter("Middlename");
					String lastname=request.getParameter("lastname");
					String dob=request.getParameter("someDate");
					String gender=request.getParameter("gender");
					String mobilenumber=(request.getParameter("mobilenumber"));
					String email=request.getParameter("email");
					String password="null";
					long adharcardnumber=Long.parseLong(request.getParameter("adharnumber"));
					String tempaddress=request.getParameter("taddress");
					String peraddress=request.getParameter("address");
					String cityname=request.getParameter("city");
					String pincode=(request.getParameter("pincode"));
					String regiverification=request.getParameter("check");
					String registatus="Pending";
					String uuidnumber="-";
					String toemailid="-";
					String emailstatus="-";
					
					  if(EmailMatch.checkUser(email)) // call EmailMatch class method and check email present or not
				       {
					   //mail present  then below code execute
				    	    out.println("<html><body style=background-color:#FFFFFF>");
				    	    out.println("<script type=\"text/javascript\">");
					        out.println("alert('Email Already Present,Please Try Another Email Id')");
					        out.println("document.location.href = 'begin-login.jsp';\n");
					        out.println("</script>");
					        out.println("</body></html>");
					        RequestDispatcher rd=request.getRequestDispatcher("/begin-login.jsp");
				    	    rd.include(request,response);
				       	 
				 	   
				       }else
				       {
				    	   //mail not present then below code execute
				        query="select max(userId) from user"; //get max id of user database
				        pst=con.prepareStatement(query);
				        rs=pst.executeQuery();
				        int dbid=0;
				        while(rs.next())
				        {
				        	dbid=rs.getInt(1);
				        	
				        }
				        if(dbid==0)
			        	{
			        		UserId=dbid+1000000000;
			        	}
			        	else
			        	{
				        UserId=dbid+1;
			        	}
				        System.out.println(UserId);
				        //insert the records into database
				        query1="insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				        pst1=con.prepareStatement(query1);
				    	pst1.setLong(1,UserId);
				    	pst1.setString(2,firstname);
				    	pst1.setString(3,middlename);
				    	pst1.setString(4,lastname);
				    	pst1.setString(5,dob);
				    	pst1.setString(6,gender);
				    	pst1.setString(7,mobilenumber);
				        pst1.setString(8,email);
				        pst1.setString(9,password);
				    	pst1.setLong(10,adharcardnumber);
				    	pst1.setString(11,tempaddress);
				    	pst1.setString(12,peraddress);
				    	pst1.setString(13,cityname);
				    	pst1.setString(14,pincode);
				    	pst1.setString(15,regiverification);
				    	pst1.setString(16,registatus);
				    	pst1.setString(17,uuidnumber);
				    	pst1.setString(18,toemailid);
				    	pst1.setString(19,emailstatus);
				        int i=pst1.executeUpdate();
//...........................................................................................................................................................................
				        String host = "smtp.gmail.com";
						String to=email;
						String username = "samruddhitbi@rlard.com";
						String pass = "Anarkali@123";
						Properties props = new Properties();
						Session sessionn = Session.getInstance(props);
						MimeMessage msg = new MimeMessage(sessionn);
						Transport t = sessionn.getTransport("smtps");
						props = new Properties();
						props.put("mail.debug", true);
						msg = new MimeMessage(sessionn);
						msg.setFrom(new InternetAddress(username));
						msg.setRecipient(RecipientType.TO, new InternetAddress(to));
						msg.setSubject("Registered Incubitees");
		    	        msg.setContent("<center><table border=0 cellspacing=0 cellpadding=0 class=table_width_100 width=100% style=max-width: 680px; min-width: 300px;> <tr><td></td></tr><tr><td align=center><table width=90% border=0 cellspacing=0 cellpadding=0><tr><td align=center>	<a href=# target=_blank style=color: #596167; font-family: Arial, Helvetica, sans-serif; float:left; width:100%; padding:20px;text-align:center; font-size: 13px;><font face=Arial, Helvetica, sans-seri; font-size: 13px; size=3 color=><img></font></a></td><td align=right></td></tr></table></td></tr><tr><td align=center><font face=Arial, Helvetica, sans-serif size=4 style=font-size: 15px;><table width=90% border=0 cellspacing=0 cellpadding=0><tr><td> <font> Dear "+firstname+",<br/><br><font><b>Congratulations..Your application has been submitted successfully.</b></font><br/><br> Your Submitted Details Are<br/><br>Name:"+firstname+"<br/>Middle Name:"+middlename+"<br/>Last Name:"+lastname+"<br/>Mobile Number:"+mobilenumber+"<BR>Email ID: "+email+"<br/><br> Your Password Reset Link Will be forwarded to your registered mail ID. After verification of your Application.<br/><br ><br></font><font>If you have not registered it,Please forward this mail to incubation@samruddhitbi.com<BR>Mention <b>Cancellation of Registration</b> in the subject.<BR><br>TEAM STBI Foundation.</td></tr><tr><td align=center><div style=line-height: 24px;></div><!-- padding --><div style=height: 60px; line-height: 60px; font-size: 10px;></div></td></tr></table></font></td></tr><tr><td class=iage_footer align=center bgcolor=#ffffff><table width=100% border=0 cellspacing=0 cellpadding=0><tr><td align=center style=padding:20px;flaot:left;width:100%; text-align:center;><font face=Arial, Helvetica, sans-serif size=3 color=#96a5b5 style=font-size: 13px;><span style=font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #96a5b5;>2015 © ALL Rights Reserved.</span></font></td></tr></table></td></tr><tr><td></td></tr></table></center>","text/html" );
		    	        t = sessionn.getTransport("smtps");
		    	      try {
		    	         t.connect(host, username, pass);
		    	         t.sendMessage(msg, msg.getAllRecipients());
		    	          }
		    	      finally 
		    	        {
		    	         t.close();
		    	        }
//...........................................................................................................................................................................		    	     
		    	     Mailtoadmin.sendEmail();   //send mail to admin through this class
//...........................................................................................................................................................................
		    	        out.println("<html><body style=background-color:#FFFFFF>");
		    	        out.println("<script type=\"text/javascript\">");
		    	        out.println("alert('Your application will be verified by administration.Then your account will be enable for further access')");
		    	        out.println("document.location.href = 'begin-login.jsp';\n");
		    	        out.println("</script>");
		    	        out.println("</body></html>");
			        RequestDispatcher rd=request.getRequestDispatcher("/begin-login.jsp");
		    	    rd.include(request,response);
				       }
			          }
	        	catch(Exception e)
		                         {
			            out.println(e);
		                         }
		                        }
//...............................................................................................................................................................................
	   @Override
	     public void destroy()
	             {
		Dao.cleanUp(con, pst, rs);
		Dao.cleanUp(null, pst1, null);
		          }
	             }
