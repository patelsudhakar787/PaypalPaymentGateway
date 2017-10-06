package com.user.forgot.userpassword;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
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
import javax.servlet.http.HttpSession;
import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserForgotpass
 */
//@WebServlet("/UserForgotpass")
public class UserForgotpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
			//create object
			Connection con;
			PreparedStatement pst;
			ResultSet rs,rs1;
			RequestDispatcher rd,rd1;
			private String ismobile=null;
			private String tooo="";
			private String randomUUIDString="";
	     
public void init(ServletConfig config) throws ServletException
		{
			try {
	 			con = Dao.getConnection();//access dao class getconnection method
	 		    } 
	 		catch (ClassNotFoundException | IOException | SQLException e)
	 			{
	 		e.printStackTrace();
	 			}
		}
private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//create object

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			WebResponse wb=new WebResponse();
			try {
					HttpSession sess=request.getSession();
					String email=request.getParameter("email");
					ismobile=request.getParameter("is_Mobile");
					
					if(ismobile==null)
					{
						ismobile="0";
					}
				
					
					if(ismobile.equals("0"))
					{
				    sess.setAttribute("email",email);
				    
					}
					UUID uuid = UUID.randomUUID();//generate random number
					randomUUIDString = uuid.toString();//convert random into string
			        Date from;
				    from=new Date();
				    String fromm=(String)sdf.format(from);	 
				    Calendar cal = Calendar.getInstance();
					cal.setTime(from);
					cal.add(Calendar.MINUTE,30);
					tooo = sdf.format(cal.getTime());
					System.out.println(tooo);
					String status="Unhit";
                    String query1="select password,registrationstatus from user where emailid=?";
					pst=con.prepareStatement(query1);
				    pst.setString(1,email);
				    rs1=pst.executeQuery();
				    String dbpass="",dbregi="";
		            while(rs1.next())
			          {
				    dbpass=rs1.getString("password"); 
				    dbregi=rs1.getString("registrationstatus");
				      }
		            	if(dbpass.equals("null") && dbregi.equals("Pending") )
		            		{
		            		if(ismobile.equals("0"))
		            		{
							    out.println("<html><body style=background-color:#F0FFF0>");
					   	        out.println("<script type=\"text/javascript\">");
						        out.println("alert('You Are Not A Approved User')");
						        out.println("document.location.href = 'login.jsp';\n");
						        out.println("</script>");
						        out.println("</body></html>");
		            		}
		            		if(ismobile.equals("1"))
		            		{
		            			wb.data="You Are Not A Approved User";
		            			wb.result=false;
		            		}
		            		} 
		            	else if(ForgotUserDao.checkUser(email))
							{
							     String query="update user set uuidnumber=?,emailtodate=?,emailstatus=? where emailid=?";
			                     pst=con.prepareStatement(query);
							     pst.setString(1,randomUUIDString);
							     pst.setString(2,tooo);
							     pst.setString(3,status);
							     pst.setString(4,email);
							     int i=pst.executeUpdate();
										     String host = "smtp.gmail.com";
									         String to=email;
									         String username = "samruddhitbi@rlard.com";
									         String password = "Anarkali@123";
									         Properties props = new Properties();
									         Session sessionn = Session.getInstance(props);
									         MimeMessage msg = new MimeMessage(sessionn);
									         Transport t = sessionn.getTransport("smtps");
									         props = new Properties();
									         props.put("mail.debug", true);
									         msg = new MimeMessage(sessionn);
									         msg.setFrom(new InternetAddress(username));
									         msg.setRecipient(RecipientType.TO, new InternetAddress(to));
									         msg.setSubject("Reset Password");
									         msg.setContent(" Click On this link to reset Your password.<br><br><br> https://accounts.google.com","text/html" );
									         t = sessionn.getTransport("smtps");
									         if(ismobile.equals("0"))
									         {
										    out.println("<html><body style=background-color:#F0FFF0>");
							        	    out.println("<script type=\"text/javascript\">");
							    	        out.println("alert('Verification Mail Sent On Your Email Id.......')");
							    	        out.println("document.location.href = 'begin-login.jsp';\n");
							    	        out.println("</script>");
							    	        out.println("</body></html>");
									         }
										         try {
										           t.connect(host, username, password);
										           t.sendMessage(msg, msg.getAllRecipients());
										               }
										           finally 
										           {
										           t.close();
										            }
							}
					     else 
					        {
					    	 if(ismobile.equals("0"))
					    	 {
					    	 out.println("<html><body style=background-color:#F0FFF0>");
				        	 out.println("<script type=\"text/javascript\">");
				    	     out.println("alert('Incorrect Email ID')");
				             out.println("document.location.href = 'forgot.jsp';\n");
				             out.println("</script>");
				    	     out.println("</body></html>");					        	    
					        }
					    	 if(ismobile.equals("1"))
					    	 {
					    		 wb.data="Incorrect Email Id";
					    		 wb.result=false;
					    	 }
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
		Dao.cleanUp(con, pst, rs);
	    Dao.cleanUp(null, null, rs1);
	}
	}


