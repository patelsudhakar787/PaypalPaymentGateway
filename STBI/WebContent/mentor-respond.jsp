<%@page import="com.dao.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="mentorDashboard" ng-controller="mentorctrldashboard">
 <head>
	    <title>Mentor View Idea</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/userviewidea.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-animate.js"></script>
	    <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.2.js"></script>
	    <script src="js/mentor-dashboard.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
    <%   Connection con;
    PreparedStatement ps,pst,pst1;
    ResultSet r,rs,rs1;
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
 	  response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
	   	  response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
    session=request.getSession();
    String mentoremail=(String)session.getAttribute("mentoremail");
    
    try
      {
    if(mentoremail.equals(null)|| mentoremail=="")
      {
  	   response.sendRedirect("mentor-login.jsp");
	 //RequestDispatcher rd=request.getRequestDispatcher("/begin_login.jsp");
	 // rd.forward(request,response);
	    }
     else
     {}
    }
  catch(Exception e)
     {
  	   response.sendRedirect("mentor-login.jsp");
// RequestDispatcher rd=request.getRequestDispatcher("/begin_login.jsp");
// rd.forward(request,response);
 }
    long ideaid=Long.parseLong(request.getParameter("ideaid"));
    con=Dao.getConnection();
    String query1="select mentorId,firstname,middlename,lastname from mentor where emailid=?";
    ps=con.prepareStatement(query1);
    ps.setString(1,mentoremail);
    r=ps.executeQuery();
    long mentorid=0;
    String dbfname1="",dbmname1="",dblname1="";
    while(r.next())
    {
    	mentorid=r.getLong(1);	
    	dbfname1=r.getString(2);
    	dbmname1=r.getString(3);
    	dblname1=r.getString(4);
    }
    session.setAttribute("mentorid",mentorid);
    
    String query="select * from ideasubmit where ideaid=?";
    pst=con.prepareStatement(query);
    pst.setLong(1,ideaid);
    rs=pst.executeQuery();
    long dbideaid=0,dbuserid=0;
    String dbtitle="",dbenterkeywords="",dbkeyusers="",dbmaxusers="",dbtargetmarket="",dbideadesc="",dbidearegidate="",dbstatusofidea="";
    while(rs.next())
        {
    	dbideaid=rs.getLong("ideaid");
    	dbtitle=rs.getString("titlename");
    	dbenterkeywords=rs.getString("enterkeywords");
    	dbkeyusers=rs.getString("keyusers");
    	dbmaxusers=rs.getString("maxuser");
    	dbtargetmarket=rs.getString("targetmarket");
    	dbideadesc=rs.getString("ideadescription");
    	dbidearegidate=rs.getString("idearegidate");
    	dbstatusofidea=rs.getString("statusofidea");
    	}
   
   %>
    <nav class="navbar navbar-fixed-top ">
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
					                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user-circle-o fa-icons"><br><span class="icon-fonts"><%=dbfname1 %> <%=dblname1 %></span></i>
					               		<ul class="dropdown-menu">
								          <li><a href="#">
													<table class="table ">
													    <tbody>
													      <tr>
													        <td>Registration Id</td>
													        <td><%=mentorid %></td>
													      </tr>
													      <tr>
													        <td>Name</td>
													        <td><%=dbfname1 %> <%=dbmname1 %> <%=dblname1 %></td>
													      </tr>
													      <tr>
													        <td>Email Id</td>
													        <td><%=mentoremail %></td>
													      </tr>
													      <tr>
													        <td colspan="2" style="text-align:center;"><a href="MentorLogout">SignOut</a></td>
													     
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
        <body>
	  
		<div class="container top">
			<div class="panel-group">
			    <div class="panel panel-info">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-toggle="collapse" href="#collapse1" class="idea-id"><%=dbideaid %></a>
			          <a data-toggle="collapse" href="#collapse1" class="idea-id"><%=dbtitle %></a>
			          <a data-toggle="collapse" href="#collapse1" class="idea-id"><%=dbidearegidate %></a>
			          <a data-toggle="collapse" href="#collapse1" class="idea-id">View</a>
			        </h4>
			      </div>
			      <div id="collapse1" class="panel-collapse collapse">
			        <div class="panel-body">
			        <div class="user-idea-details">
							<label>Idea Id</label>
							<p class="idea-data-width"><%=dbideaid %></p>
						</div>
						
						<div class="user-idea-details">
							<label>Title of your Idea / Innovation / Product / Solution</label>
							<p class="idea-data-width"><%=dbtitle %></p>
						</div>
						<div class="user-idea-details">
							<label>Enter TEN key words that are closely related to your idea</label>
							<p class="idea-data-width"><%=dbenterkeywords %></p>
						</div>
						<div class="user-idea-details">
							<label>Who are KEY users of your Product / Solution</label>
							<p class="idea-data-width"><%=dbkeyusers %></p>
						</div>
						<div class="user-idea-details">
							<label>Maximum number of KEY users of solution/ Product in India</label>
							<p class="idea-data-width"><%=dbmaxusers %></p>
						</div>
						<div class="user-idea-details">
							<label>Target Market (Maximum possible value for Sale)</label>
							<p class="idea-data-width"><%=dbtargetmarket %></p>
						</div>
						<div class="user-idea-details">
							<label>Idea Description</label>
							<p class="idea-data-width"><%=dbideadesc %></p>
						</div>
						<div class="user-idea-details">
							<label>Date(MM/dd/YYYY)</label>
							<p class="idea-data-width"><%=dbidearegidate %></p>
						</div>
						<div class="user-idea-details">
							<label>Status</label>
							<p class="idea-data-width"><%=dbstatusofidea %></p>
						</div>
					</div>
			      </div>
			    </div>
			  </div>
			  <!----------------------------------------------------------- End of ideas -------------------------------------------->
			  <ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#new-request-submit" class="tab-font-grorgia">Support And Response</a></li>
				    <li><a data-toggle="tab" href="#response-of-request" class="tab-font-grorgia">View Response</a></li>
			  </ul>
			  <div class="tab-content">
				   <div id="new-request-submit" class="tab-pane fade in active">
				   <form action="./UserChatMentor" method="post">
					    <div class="panel panel-default card panels">
					    	<div class="panel-body panels">
					    	<%--	<div class="user-idea-details">
					    			<select class="form-control" ng-model="gender">
					    			    <option value="" ng-show="false"> Select</option>
					    				<option>General</option>
					    				<option>IT Support</option>
					    				<option>Technology / R & D Support</option>
					    				<option>Techno - Legal Support (IP Protection)</option>
					    				<option>Infrastructure Support</option>
					    				<option>Makers Space / Fab Lab Support</option>
					    				<option>Business Plan Support</option>
					    				<option>Market Research Support</option>
					    				<option>Funds and Finance Support</option>
					    				<option>Company Formation Support</option>
					    				<option>Accounting and Taxation Support</option>
					    				<option>Design Support (Logo, Branding, Pro motion Material)</option>
					    			</select>
					    		</div> --%>
					    		<input type="hidden" name="ideaid" value="<%=dbideaid%>" />
					    		<div class="user-idea-details">
					    			<textarea rows="6" cols="" name="description" class="form-control"></textarea>
					    		</div>
					    		<div class="user-idea-details">
									<button type="submit" class="btn btn-info btn-md active fload_right">Submit</button>
					    		</div>
					    	</div>
					    </div>
					    </form>
				  </div>
				  <div id="response-of-request" class="tab-pane">
				     <form>
				     <%
				     
				     String query3="select * from usermentorchat where mentorId=?";
						pst1=con.prepareStatement(query3);
						pst1.setLong(1,mentorid);
						rs1=pst1.executeQuery();
					    long dbideaiid=0,dbmentorid=0;
					    String dbdesc="";
						while(rs1.next())
						{
							
							dbideaiid=rs1.getLong("ideaId");
							dbmentorid=rs1.getLong("mentorId");
							dbdesc=rs1.getString("description");
							
						}
									
				     
				     
				     
				     
				     
				     
				     
				     
				     %>
					    <div class="panel panel-default card panels">
					    	<div class="panel-body">
					    		<div class="user-idea-details">
					    			<select class="form-control" ng-model="response">
					    			    <option value="" ng-show="false"> Select</option>
					    				<option value="General">General</option>
					    				<option value="IT Support">IT Support</option>
					    				<option value="Technology / R & D Support">Technology / R & D Support</option>
					    				<option value="Techno - Legal Support">Techno - Legal Support (IP Protection)</option>
					    				<option value="Infrastructure Support">Infrastructure Support</option>
					    				<option value="Makers Space / Fab Lab Support">Makers Space / Fab Lab Support</option>
					    				<option value="Business Plan Support">Business Plan Support</option>
					    				<option value="Marketing Research Support">Market Research Support</option>
					    				<option value="Funds and Finance Support">Funds and Finance Support</option>
					    				<option value="Company Formation Support">Company Formation Support</option>
					    				<option value="Accounting and Taxation Support">Accounting and Taxation Support</option>
					    				<option value="Design Support (Logo, Branding, Pro motion Material)">Design Support (Logo, Branding, Pro motion Material)</option>
					    			</select>
					    		</div>
					    		<div class="user-idea-details">
						    		<div ng-switch="response">
										  <div ng-switch-when="General">
										      <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">General <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">General <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">General <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
										    	<textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!------------------------------------------------------------------------------------------>
										  <div ng-switch-when="IT Support">
										    <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">IT Support  <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">IT Support  <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">IT Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										   <!------------------------------------------------------------------------------------------>
										  <div ng-switch-when="Technology / R & D Support">
										    <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Technology / R & D Support <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Technology / R & D Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Technology / R & D Support<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!------------------------------------------------------------------------------------------>
										  <div ng-switch-when="Techno - Legal Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Techno - Legal Support <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Techno - Legal Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Techno - Legal Support<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!------------------------------------------------------------------------------------------------------>
										  <div ng-switch-when="Infrastructure Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Infrastructure Support <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Infrastructure Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Infrastructure Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											    <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!-------------------------------------------------->
										   <div ng-switch-when="Makers Space / Fab Lab Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Makers Space / Fab Lab Support<small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Makers Space / Fab Lab Support<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Makers Space / Fab Lab Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!---------------------------------------------------------------------------------------------->
										   <div ng-switch-when="Business Plan Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Business Plan Support <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Business Plan Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Business Plan Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!------------------------------------------------------------------------------------------->
										   <div ng-switch-when="Marketing Research Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Marketing Research Support <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Marketing Research Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Marketing Research Support<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										 <!----------------------------------------------------------------------------------------->
										  <div ng-switch-when="Funds and Finance Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Funds and Finance Support <small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Funds and Finance Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Funds and Finance Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										<!--------------------------------------------------------------------------------------------------------------------->										  
										  <div ng-switch-when="Company Formation Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Company Formation Support<small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Company Formation Support <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Company Formation Support<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!--------------------------------------------------------------------------------------------------------------------->										  
										  <div ng-switch-when="Accounting and Taxation Support">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Accounting and Taxation Support<small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Accounting and Taxation Support<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Accounting and Taxation Support<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
										  <!--------------------------------------------------------------------------------------------------------------------->										  
										  <div ng-switch-when="Design Support (Logo, Branding, Pro motion Material)">
										     <div class="media-left">
											      <img src="logo/avtar.png" class="media-object" style="width:45px">
											    </div>
											    <div class="media-body">
											      <h4 class="media-heading">Design Support (Logo, Branding, Pro motion Material)<small><i>Posted on February 19, 2016</i></small></h4>
											      <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											      <!-- Nested media object -->
											      <div class="media replay-user">
											        <div class="media-left">
											          <img src="logo/avtar.png" class="media-object" style="width:45px">
											        </div>
											        <div class="media-body">
											          <h4 class="media-heading">Design Support (Logo, Branding, Pro motion Material) <small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											          <h4 class="media-heading">Design Support (Logo, Branding, Pro motion Material)<small><i>Posted on February 19, 2016</i></small></h4>
											          <p class="idea-data-width">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><hr>
											    
											        </div>
											      </div>
											    </div>
											   <textarea rows="" cols="" class="form-control"></textarea><br>
										    	<div class="row">
										    	    <div class="col-sm-8"></div>
										    	    <div class="col-sm-2">
									    		        <div ng-init="rating = star.rating + 1"></div>
													    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
												    </div>
												    <div class="col-sm-2">
												    	<input type="text" ng-model="rating" class="rating-text" readonly>/5
												    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
												    </div>
												</div>
										  </div>
									</div>
								</div>
					    	</div>
					    </div>
					</form>
				 </div>
			</div>
		</div>
	</body>
</html>
