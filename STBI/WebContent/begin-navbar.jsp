<!DOCTYPE html>
<%@page import="com.dao.Dao"%>
<%@page import="java.sql.*"%>
<html lang="en">
<%!
	long userid=0;
	Connection con=null;
	String query;
    PreparedStatement pst,pst1,pst2,pst3,pst4;
    ResultSet rs,rs1,rs2,rs3,rs4;
    %>
	   <%
	   		    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		  	    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		    	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
	    session=request.getSession();
	    String useremail=(String)session.getAttribute("useremail");
	    try
        {
      if(useremail.equals(null)|| useremail=="")
        {
	  RequestDispatcher rd=request.getRequestDispatcher("/begin_login.jsp");
	  rd.forward(request,response);
	    }
       else
       {}
      }
    catch(Exception e)
       {
   RequestDispatcher rd=request.getRequestDispatcher("/begin_login.jsp");
   rd.forward(request,response);
   }
	    con=Dao.getConnection();
	    query="select userId from user where emailid=?";
	    pst=con.prepareStatement(query);
	    pst.setString(1,useremail);
	    rs=pst.executeQuery();
	    
	    while(rs.next())
	    {
	    userid=rs.getLong(1);	
	    }
	    request.setAttribute("userid",userid);
	   %>		<nav class="navbar navbar-fixed-top ">
			       <div class="navbar-conteiner">
				    <div class="navbar-header">
				     <!--  <img src="logo/Logo.jpg"> -->
				    </div>
				    
				    <div class="collapse navbar-collapse" id="myNavbar">
					      <ul class="nav navbar-nav">
						     <img src="logo/STBILOGO.jpg" style="width: 250px;margin-top: 12px;"/>
						  </ul>
					      <ul class="nav navbar-nav navbar-right navbars">
						    <li class="dropdown notification">
					                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-mobile fa-icons"><br><span class="icon-fonts">Contact</span></i>
					               		<ul class="dropdown-menu">
								          <li><a href="#">Page 1-1</a></li>
								          <li><a href="#">Page 1-2</a></li>
								          <li><a href="#">Page 1-3</a></li>
								        </ul>
					                </a>
						    </li>
					       <li class="dropdown notification">
					       		     <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-calendar-check-o fa-icons"><br><span class="icon-fonts">Event</span></i>
						       		    <span class="label badge">10</span>
						       		    <ul class="dropdown-menu">
								          <li><a href="#">Event Name <span class="badge text-center">12</span></a></li>
								        </ul>
					       		    </a>
						    </li>
					        <li class="dropdown notification">
					                <a  class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-bell-o fa-icons"><br><span class="icon-fonts">Notification</span></i>
					       				<span class="badge badges">10</span>
								        <ul class="dropdown-menu">
								          <li><a href="#">Notification <span class="badge text-center">12</span></a></li>
								        </ul>
					                </a>
						    </li>
					         <li class="dropdown notification">
					                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user-circle-o fa-icons"><br><span class="icon-fonts">Dattaprasad</span></i>
					               		<ul class="dropdown-menu">
								          <li><a href="#">
													<table class="table ">
													    <tbody>
													      <tr>
													        <td>Registration Id</td>
													        <td><%=userid %></td>
													      </tr>
													      <tr>
													        <td>Name</td>
													        <td>Dattaprasad Dashrath Ingle</td>
													      </tr>
													      <tr>
													        <td>Email Id</td>
													        <td>dattaprasad.ingle@rlard.com</td>
													      </tr>
													    </tbody>
													  </table>
											  </a></li>
								        </ul>
					                </a>
						    </li>
					      </ul>
				    </div>
			  </div>
		</nav>
</html>
