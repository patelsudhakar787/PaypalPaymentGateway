<%@page import="com.dao.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myDashboard" ng-controller="dashboard">
 <head>
	    <title>View Idea</title>
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
	    <script src="js/city-navbar.js"></script>
	    <script src="js/dashboard.js"></script>
    </head>
    
    <%!
	
	Connection con=null;
	String query,query1;
    PreparedStatement pst,pst1;
    ResultSet rs,rs1;
    %>
	   <% response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
 	      response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
     	  response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
          response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
			session=request.getSession();
			String useremail=(String)session.getAttribute("useremail");
			long ideaidd=Long.parseLong(request.getParameter("ideaid"));
			try
			{
			if(useremail.equals(null)|| useremail=="")
			{
				response.sendRedirect("begin-login.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("/begin-login.jsp");
			//rd.forward(request,response);
			}
			else
			{}
			}
			catch(Exception e)
			{
			//RequestDispatcher rd=request.getRequestDispatcher("/begin-login.jsp");
			//rd.forward(request,response);
				response.sendRedirect("begin-login.jsp");
			}
			con=Dao.getConnection();
			query1="select userId,firstname,middlename,lastname from user where emailid=?";
			pst1=con.prepareStatement(query1);
			pst1.setString(1,useremail);
			rs1=pst1.executeQuery();
			long userid=0;
			String dbfname1="",dbmname1="",dblanme1="";
			while(rs1.next())
			{
			userid=rs1.getLong(1);
			dbfname1=rs1.getString(2);
			dbmname1=rs1.getString(3);
			dblanme1=rs1.getString(4);
			}
			
			
			String query="select * from ideasubmit where ideaid=?";
			pst=con.prepareStatement(query);
			pst.setLong(1,ideaidd);
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
					                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user-circle-o fa-icons"><br><span class="icon-fonts"><%=dbfname1%> <%=dblanme1%></span></i>
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
													        <td><%=dbfname1%> <%=dbmname1%> <%=dblanme1%></td>
													      </tr>
													      <tr>
													        <td>Email Id</td>
													        <td><%=useremail %></td>
													      </tr>
													       <tr>
													        <td colspan="2" style="text-align:center;"><a href="UserLogout">SignOut</a></td>
													     
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
  	   
		<div class="container top" >
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
							<p class="idea-data-width"><%=dbideaid%></p>
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
				    <li class="active"><a data-toggle="tab" href="#new-request-submit" class="tab-font-grorgia">Submit New Request</a></li>
				    <li><a data-toggle="tab" href="#response-of-request" class="tab-font-grorgia">View Response</a></li>
			  </ul>
			  <div class="tab-content">
				   <div id="new-request-submit" class="tab-pane fade in active">
					    <div class="panel panel-default card panels">
					    	<div class="panel-body panels">
					    	    <form name="requestForm" action="./UserRequestSupport" method="post">
						    		<div class="user-idea-details">
						    			<select class="form-control" ng-model="support" name="support" required/>
												    			    <option value="" ng-show="false"> Select</option>
												    				<option value="Incubation and SME General Support">Incubation and SME General Support</option>
												    				<option  value="IT Support">IT Support</option>
												    				<option  value="Technology / R & D Support">Technology / R & D Support</option>
												    				<option  value="Techno-Legal Support (IP Protection)">Techno - Legal Support (IP Protection)</option>
												    				<option  value="Co-working Space Support">Co-working Space Support</option>
												    				<option  value="Makers Space/Fab Lab Support">Makers Space / Fab Lab Support</option>
												    				<option  value="Business Plan Support">Business Plan Support</option>
												    				<option  value="Market Research Support">Market Research Support</option>
												    				<option  value="Funds and Finance Support">Funds and Finance Support</option>
												    				<option  value="Company Formation Support">Company Formation Support</option>
												    				<option  value="Accounting and Taxation Support">Accounting and Taxation Support</option>
												    				<option  value="Design Support (Logo, Branding, Pro motion Material)">Design Support (Logo, Branding, Pro motion Material)</option>
												    				<option  value="Product Testing and Certification">Product Testing and Certification</option>
												    				<option  value="Stress Management Support">Stress Management Support</option>
												    				<option  value="Product Development Support">Product Development Support</option>
												    				<option  value="ISO System and Certification Support">ISO System and Certification Support</option>
												    			</select>
						    		</div>
						    		<input type="hidden" name="ideaid" value="<%=dbideaid %>"> 
						    		<div class="user-idea-details">
						    			<textarea rows="6" cols="" class="form-control" name="requestdetails" ng-model="requestdetails" required/></textarea>
						    		</div>
						    		<div class="user-idea-details">
										<button type="submit" class="btn btn-info btn-md active fload_right">Submit</button>
						    		</div>
						    	</form>
					    	</div>
					    </div>
				  </div>
				  <div id="response-of-request" class="tab-pane">
				     <form>
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
													 <form>												      
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
													    	<textarea rows="" cols="" class="form-control" name="generel" ng-model="generel" required/></textarea><br>
													    	<div class="row">
													    	    <div class="col-sm-8"></div>
													    	    <div class="col-sm-2">
												    		        <div ng-init="rating = star.rating + 1"></div>
																    <div class="star-rating fload_right" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
															    </div>
															    <div class="col-sm-2">
															    	<input type="text"  class="rating-text"  ng-model="rating" required readonly/>/5
															    	<button type="submit" class="btn btn-info btn-sm active ">Reply</button>
															    </div>
															</div>
														</form>
												  </div>
												  <!------------------------------------------------------------------------------------------>
												  <div ng-switch-when="IT Support">
												     <form>
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
														   <textarea rows="" cols="" class="form-control" name="itresponse" ng-model="itresponse" required/></textarea><br>
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
													   </form>
												  </div>
												   <!------------------------------------------------------------------------------------------>
												  <div ng-switch-when="Technology / R & D Support">
												     <form>
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
														   <textarea rows="" cols="" class="form-control" name="technology" ng-model="technology" required/></textarea><br>
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
														</form> 
												  </div>
												  <!------------------------------------------------------------------------------------------>
												  <div ng-switch-when="Techno - Legal Support">
												     <form>
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
														   <textarea rows="" cols="" class="form-control" name="technolegal" ng-model="technolegal" required/></textarea><br>
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
														</form>
												  </div>
												  <!------------------------------------------------------------------------------------------------------>
												  <div ng-switch-when="Infrastructure Support">
												     <form>
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
														    <textarea rows="" cols="" class="form-control" name="infrastructure" ng-model="infrastructure" required/></textarea><br>
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
														</form>
												  </div>
												  <!-------------------------------------------------->
												   <div ng-switch-when="Makers Space / Fab Lab Support">
												      <form>
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
														   <textarea rows="" cols="" class="form-control" name="marketspace" ng-model="marketspace" required/ ></textarea><br>
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
													  </form>
												  </div>
												  <!---------------------------------------------------------------------------------------------->
												  <div ng-switch-when="Business Plan Support">
												      <form>
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
														   <textarea rows="" cols="" class="form-control" name="buisnessplan" ng-model="buisnessplan" required/></teaxtarea><br>
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
													  </form>
												  </div>
												  <!------------------------------------------------------------------------------------------->
												   <div ng-switch-when="Marketing Research Support">
												      <form>
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
														   <textarea rows="" cols="" class="form-control" name="marketpplace" ng-model="marketpplace" required/></textarea><br>
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
													   </form>
												  </div>
												 <!----------------------------------------------------------------------------------------->
												  <div ng-switch-when="Funds and Finance Support">
												     <form>
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
														   <textarea rows="" cols="" class="form-control" name="fundandfinance" ng-model="fundandfinance" required></textarea><br>
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
													  </form>
												  </div>
												<!--------------------------------------------------------------------------------------------------------------------->										  
												  <div ng-switch-when="Company Formation Support">
												     <form>
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
														   <textarea rows="" cols="" class="form-control" name="companyformation" ng-model="companyformation" required></textarea><br>
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
														</form>
												  </div>
												  <!--------------------------------------------------------------------------------------------------------------------->										  
												  <div ng-switch-when="Accounting and Taxation Support">
												      <form>
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
														   <textarea rows="" cols="" class="form-control" name="accounttaxation" ng-model="accounttaxation" required/></textarea><br>
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
														</form>
												  </div>
												  <!--------------------------------------------------------------------------------------------------------------------->										  
												  <div ng-switch-when="Design Support (Logo, Branding, Pro motion Material)">
													  <form>
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
														   <textarea rows="" cols="" class="form-control" name="designsupport" ng-model="designsupport" required/></textarea><br>
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
														</form>
												  </div>
											</div>
										 </div>
									</form>
								</div>
					    	</div>
					    </div>
				 </div>
			</div>
		</div>
	</body> 
</html>
<script>
angular.module("myDashboard",[]).controller("dashboard", function($scope){
	 $scope.today = new Date();
	 $scope.rating = 5;
	 
	 $scope.emailid = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
     $scope.mobiles = /^(\+\91{1,2}[- ])\d{10}$/;
     $scope.landline = /^[0-9]\d{2,5}-\d{6,8}$/;
     $scope.numberonly = /^[0-9]{1,6}$/;
     $scope.stringonly = /^[a-zA-Z ]{1,25}$/;
     $scope.ages = /^[0-9]{1,2}$/;
     $scope.dateformat = /^[0,1]?\d{1}\/(([0-2]?\d{1})|([3][0,1]{1}))\/(([1]{1}[9]{1}[9]{1}\d{1})|([2-9]{1}\d{3}))$/ ;
	 
	 $scope.setFile = function(element) {
       $scope.$apply(function($scope) {
           $scope.theFile = element.files[0];
           $scope.FileMessage = '';
           var filename = $scope.theFile.name;
           console.log(filename.length)
           var index = filename.lastIndexOf(".");
           var strsubstring = filename.substring(index, filename.length);
           if (strsubstring == '.pdf' || strsubstring == '.doc')
           {
             console.log('File Uploaded sucessfully');
           }
           else {
               $scope.theFile = '';
                 $scope.FileMessage = 'please upload correct File Name, File extension should be .pdf, .doc or';
           }

       });
   };
})
.directive('starRating',
		function() {
			return {
				restrict : 'A',
				template : '<ul class="rating">'
						 + '	<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">'
						 + '\u2605'
						 + '</li>'
						 + '</ul>',
				scope : {
					ratingValue : '=',
					max : '=',
					onRatingSelected : '&'
				},
				link : function(scope, elem, attrs) {
					var updateStars = function() {
						scope.stars = [];
						for ( var i = 0; i < scope.max; i++) {
							scope.stars.push({
								filled : i < scope.ratingValue
							});
						}
					};
					
					scope.toggle = function(index) {
						scope.ratingValue = index + 1;
						scope.onRatingSelected({
							rating : index + 0
						});
					};
					
					scope.$watch('ratingValue',
						function(oldVal, newVal) {
							if (newVal) {
								updateStars();
							}
						}
					);
				}
			};
		}
	);
</script>