package com.user.idea;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

//@WebServlet("/IdeaSubmit")
@MultipartConfig(maxFileSize = 16177215) 
public class IdeaSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//create object of connection,preparedstatement and resultset
	Connection con;
	String message = null;  // message will be sent back to client
	PreparedStatement ps,pst;
	ResultSet rs,rs1;
	private String ismobile=null;
	private Part filePart;
	private String useremail;
	
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
						
						try
							{
							if(ismobile.equals("0"))
							{
							HttpSession session=request.getSession();//create session object
							useremail=(String)session.getAttribute("useremail");
							}
							//to get user email through session and convert that into string 
							int ideaid=0; //to declare id to store max id value of table
							//to get values through userside
							if(ismobile.equals("1"))
							{
							useremail=request.getParameter("email");
							}
							String title=request.getParameter("ideas");
							String keywords=request.getParameter("keyword");
							String keyusers=request.getParameter("solution");
							long maxuuser=Long.parseLong(request.getParameter("keyuser"));
							String targetmarket=request.getParameter("targetmarket");
							String ideadesc=request.getParameter("description");
							InputStream inputStream = null; // input stream of the upload file
							// obtains the upload file part in this multipart request
							
							
							if(ismobile.equals("0"))
							{
								filePart = request.getPart("pic");
							if (filePart != null) {
								// prints out some information for debugging
								System.out.println(filePart.getName());
								System.out.println(filePart.getSize());
								System.out.println(filePart.getContentType());
								// obtains input stream of the upload file
								inputStream = filePart.getInputStream();
							}
							}
							 
							String date=request.getParameter("today");
							String status=request.getParameter("status");
							String deletedesc="";//by defaullt this variable pass null
							String se="select userId from user where emailid=?";   //get userid through email id
							ps=con.prepareStatement(se);
							ps.setString(1,useremail);
							rs1=ps.executeQuery();
							int dbuserId=0;
									while(rs1.next())
									{
										dbuserId=rs1.getInt(1);  //get userid
									}
									String query="select max(ideaid) from ideasubmit";   //select max of id from ideasumit table 
									PreparedStatement pst=con.prepareStatement(query);
									ResultSet rs=pst.executeQuery();
									int dbid=0;
									while(rs.next())
									{
										dbid=rs.getInt(1);//to get max of id from ideasubmit table
							        }
									if(dbid==0)
									{
										ideaid=dbid+123456; 
									}
									else
									{
										ideaid=dbid+1; 
									}
									String quuery1="";
									if(ismobile.equals("0"))
									{
										quuery1="insert into ideasubmit(ideaid,titlename,enterkeywords,keyusers,maxuser,targetmarket,ideadescription,attachedfile,idearegidate,statusofidea,userId,deleteideadescription) values(?,?,?,?,?,?,?,?,?,?,?,?)";
									}
									
									if(ismobile.equals("1"))
									{
										quuery1="insert into ideasubmit(ideaid,titlename,enterkeywords,keyusers,maxuser,targetmarket,ideadescription,idearegidate,statusofidea,userId) values(?,?,?,?,?,?,?,?,?,?)";
									}
									//increase max id by and store in id variable
									
									PreparedStatement pst1=con.prepareStatement(quuery1);
									pst1.setInt(1,ideaid);
									pst1.setString(2,title);
									pst1.setString(3,keywords);
									pst1.setString(4,keyusers);
									pst1.setLong(5,maxuuser);
									pst1.setString(6,targetmarket);
									pst1.setString(7,ideadesc);
									if(ismobile.equals("0"))
									{
									if (inputStream != null) 
									{
										pst1.setBlob(8, inputStream);
									}
									pst1.setString(9,date);
									pst1.setString(10,status);
									pst1.setInt(11,dbuserId);
									pst1.setString(12,deletedesc);
									}
									
									if(ismobile.equals("1"))
									{
										pst1.setString(8,date);
										pst1.setString(9,status);
										pst1.setInt(10,dbuserId);
									}
									int i=pst1.executeUpdate(); //record inserted successfully.
									if(i==1)
									{
										if(ismobile.equals("0"))
										{
										out.println("<html><body style=background-color:>");
										out.println("<script type=\"text/javascript\">");
										out.println("alert('Your Idea Submitted Successfully....')");
										out.println("document.location.href = 'begin-dashboard.jsp';\n");
										out.println("</script>");
										out.println("</body></html>");
										//RequestDispatcher rd=request.getRequestDispatcher("/begin-dashboard.jsp");
										//rd.include(request,response);
										}
										if(ismobile.equals("1"))
										{
											wb.data="Inserted";
											wb.result=true;
										}
									}
									
									else if(i==0)
									{
										wb.data="NotInserted";
										wb.result=false;
									}
									
									
									if(ismobile.equals("1"))
									{
										Gson gson=new Gson();
										String tojson=gson.toJson(wb);
										out.print(tojson);
									}
								}
						catch (SQLException ex)
						{
								message = "ERROR: " + ex.getMessage();
								out.println(ex);
						} 
					}
@Override
public void destroy()
			{
				Dao.cleanUp(con, pst, rs);
				Dao.cleanUp(null, ps, rs1);
			}
		}


