<%@page import="com.dao.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="mentorDashboard" ng-controller="mentorctrldashboard">
    <head>
	    <title> Mentor Dashboard</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/mentor-dashboard.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/mentor-dashboard.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
	<%!
	
	Connection con=null;
	String query;
    PreparedStatement ps,ps1,ps2,pst,pst1,pst2,pst3,pst4,pst5,pst6,pst7;
    ResultSet r,r1,r2,rs,rs1,rs2,rs3,rs4,rs5,rs6,rs7;
    %>
	   <%
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
	     con=Dao.getConnection();
	    query="select mentorId,firstname,middlename,lastname from mentor where emailid=?";
	    pst=con.prepareStatement(query);
	    pst.setString(1,mentoremail);
	    rs=pst.executeQuery();
	    long mentorid=0;
	    String dbfname1="",dbmname1="",dblname1="";
	    while(rs.next())
	    {
	    	mentorid=rs.getLong(1);	
	    	dbfname1=rs.getString(2);
	    	dbmname1=rs.getString(3);
	    	dblname1=rs.getString(4);
	    }
	    session.setAttribute("mentorid",mentorid);
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
		<div class="containers" >
			<div class="top">
				<ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#myidea" class="tab-font-grorgia">IDEAS (FROM INCUBATEE)</a></li>
				    <li><a data-toggle="tab" href="#myprofile" class="tab-font-grorgia">MY PROFILE</a></li>
				</ul>
				<div class="tab-content">
				    <div id="myidea" class="tab-pane fade in active">
					    <div class="panel panel-default card panels">
					    	<div class="panel-body">
					    	    <button type="button" class="btn btn-info active" data-toggle="collapse" data-target="#filter-ideas">Filter</button>
								<div id="filter-ideas" class="collapse center ">
								   <form>
								      <input type="search" name="googlesearch" placeholder="Department" class="search"> 
								      <input type="search" name="googlesearch" placeholder="Keyword" class="search"> 
								      <input type="search" name="googlesearch" placeholder="State" class="search">
								      <input type="search" name="googlesearch" placeholder="City" class="search"> 
								      <button class="btn btn-info btn-lg active "> <span class="glyphicon glyphicon-search "></span></button>
								    </form>
								</div>
					    	    <hr>
								<table class="table table-list table-hover card">
								    <thead>
								      <tr>
								        <th class="table-fent-gray">ID</th>
								        <th class="table-dark-gray">TITLE OF IDEA</th>
								        <th class="table-fent-gray">DATE </th>
								        <th class="table-dark-gray">STATUS</th>
								        <th class="table-fent-gray"></th>
								      </tr>
								    </thead>
								    <%
		
		String que="select areaofsupport from mentor where mentorId=?";
		ps=con.prepareStatement(que);
		ps.setLong(1,mentorid);
		r=ps.executeQuery();
		
		String dbareaofsupport="";
		while(r.next())
		    {
			dbareaofsupport=r.getString(1);
			}
		
		String que1="select supporttype from newuserrequestsupport";
		ps1=con.prepareStatement(que1);
		r1=ps1.executeQuery();
		String dbsupporttype="";
		while(r1.next())
		    {
			dbsupporttype=r1.getString(1);
			
			if(dbsupporttype.equals(dbareaofsupport))
			{
				break;
			}
		   }
			String que2="select ideasubmit.ideaId,ideasubmit.titlename,ideasubmit.idearegidate,ideasubmit.statusofidea from ideasubmit,newuserrequestsupport where ideasubmit.ideaId=newuserrequestsupport.ideaId and newuserrequestsupport.supporttype=? ";
			ps2=con.prepareStatement(que2);
			ps2.setString(1,dbsupporttype);
			r2=ps2.executeQuery();
			long dbideaid=0;
			String ideatitle="",dbregidate="",dbstatusofidea="";
			while(r2.next())
			{
				dbideaid=r2.getLong(1);
				ideatitle=r2.getString(2);
				dbregidate=r2.getString(3);
				dbstatusofidea=r2.getString(4);
				%>
				<tbody>
			      <tr>
			        <td><b><%=dbideaid %></b></td>
			        <td><p class="table-idea"><a href="mentor-view-all-details.jsp?ideaid=<%=dbideaid %>" target="_blank"><%=ideatitle %></a></p></td>
			        <td><p class="table-data"><%=dbregidate %></p></td>
			        <td><p class="table-data"><%=dbstatusofidea %></p></td>
			        <td><p class=" fload_right table-data-button">
						<a class="btn btn-xs btn-info active" name="ideaid" href="mentor-respond.jsp?ideaid=<%=dbideaid %>" target="_blank">Respond</a>
						<button class="btn btn-xs btn-warning active" data-toggle="modal" data-target="#delete"><i class="fa fa-trash" style="font-size:18px"></i></button>
					</p></td>
			      </tr>
				  <%}%>
								    </tbody>
								  </table><hr>
								   <!----------------------------Deleting---------------------------- -->
								    <div class="modal fade" id="delete" role="dialog">
									    <div class="modal-dialog modal-md">
									      <div class="modal-content">
									        <div class="modal-header">
									          <button type="button" class="close" data-dismiss="modal">&times;</button>
									          <h5 class="modal-title">Say reason for deleting Incubatee idea.</h5>
									        </div>
									        <div class="modal-body">
									          <textarea rows="" cols="" class="form-control"></textarea>
									        </div>
									        <div class="modal-footer">
									          <button type="Submit" class="btn btn-warning active" data-dismiss="modal">Submit</button>
									          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									        </div>
									      </div>
									    </div>
									</div>
									
								  <div class="float-left">
								  	<button class="btn btn-info btn-md active">Begin My Startup</button>
								  	<button class="btn btn-warning btn-md active">Upgrade my Skill</button>
								  </div>
					    	</div>
					    </div>
					 </div>
				    <div id="myprofile" class="tab-pane fade">
				       <div class="panel panel-default card panels">
					      <div class="panel-body">
					    	<div class="row">
					    	   <div class="col-sm-12">
							          <div class="col-sm-3 bhoechie-tab-menu ">
							              <div class="list-group card">
								                <a data-toggle="tab" href="#personal-details" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>PERSONAL DETAILS
								                </a>
								                <a data-toggle="tab" href="#education" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-university fa-profile-size"></i><br/>EDUCATION
								                </a>
								                <a data-toggle="tab" href="#experience" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>PROFESSIONAL EXPERIENCE
								                </a>
								                 <a data-toggle="tab" href="#myskills" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>MY SKILLS FOR COMMERCIALIZATION
								                </a>
								                 <a data-toggle="tab" href="#design-course" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>COURSE DESIGN
								                 </a>
								                 <a data-toggle="tab" href="#offer" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>OFFER TRAINING
								                </a>
							              </div><br>
							         </div>
							         <div class="col-sm-9 profile-all-details">
								     	   <div class="tab-content">
											    <div id="personal-details" class="tab-pane fade in active">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			 <div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#personals"><b>Add Personal Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="personals" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="myForm" action="./MentorUpdatepersonal"  method="post">
																			  <div class="form-group">
																			    <label for="inputsm">Add New Mobile No :</label>
																			    <input class="form-control input-sm"  type="text" ng-model="mobilenumber" name="mobilenumber" ng-pattern="/^(\+\91{1,2}[- ])\d{10}$/"><small>+91 9855514371</small>
																			     <span style="color:red" ng-show="myForm.mobilenumber.$dirty && myForm.mobilenumber.$invalid">
														      					 <span ng-show="myForm.mobilenumber.$error.required">Please specify your Mobile Number</span></span>
														     					 <span ng-show="myForm.mobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
 																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Add New Email Id</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="email" ng-model="email" ng-pattern="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i">
																		    	  <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
																			      <span ng-show="myForm.email.$error.required">Please specify your Email ID</span></span>
																				  <span ng-show="myForm.email.$error.pattern" style="color:red">Please enter correct email address.</span>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Add New Temporary Address</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="address" >
																			  </div>
																			  <div class="form-group fload_right">
																			  		<button type="submit" class="btn btn-info btn-md active"
																			  		  ng-disabled="myForm.mobilenumber.$dirty && myForm.mobilenumber.$invalid && myForm.mobilenumber.$error.pattern ||
																			  		  			   myForm.email.$dirty && myForm.email.$invalid && myForm.email.$error.pattern">Submit</button>
																			  </div>
																		</form> 
																	  </div>
																    </div>
																  </div>
															 </div> <hr>
															 <!-- ------------------------------------------------------------------- -->
															  <%
															 String query2="select * from mentor where mentorId=?";
															 pst2=con.prepareStatement(query2);
															 pst2.setLong(1,mentorid);
															 rs2=pst2.executeQuery();
															 long dbmentorid=0;
															 String dbfname="",dbmname="",dblname="",dbdob="",dbgender="",dbmobile="",dbemail1="";
															
															 while(rs2.next())
															 {
																 
																 dbmentorid=rs2.getLong("mentorId");
																 if(dbmentorid==mentorid)
																 {
																	 dbfname=rs2.getString("firstname");
																	 dbmname=rs2.getString("middlename");
																	 dblname=rs2.getString("lastname");
																	 dbdob=rs2.getString("dob");
																	 dbgender=rs2.getString("gender");
																	 dbmobile=rs2.getString("mobilenumber");
																	 
																	 dbemail1=rs2.getString("emailid"); 
																 }
																 else
																 {
																	 
																 }
																 
															 }
															 %>
															  <div class="list-group font">
															    <form class="form-horizontal">
															        <div class="form-group">
																      <div class="col-sm-11">
																        <label class="control-label col-sm-6">INFORMATION OF PERSONAL DETAILS</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																   
																    <div class="form-group">
																      <p class="control-label col-sm-3">Full Name::</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbfname %> &nbsp <%=dbmname %>&nbsp<%=dblname %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Date of Birth:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbdob %></p>
																      </div>
																    </div>
																      <div class="form-group">
																      <p class="control-label col-sm-3">Gender:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color"><%=dbgender %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Mobile No:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbmobile %></p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Email Id:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color"><%=dbemail1 %></p>
																      </div>
																    </div>
																  
																  </form>
													
															  </div><hr>											      		</div>
											      	</div>
											    </div>
											    <div id="education" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#educations"><b>Add Education Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="educations" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="educationForm" action="./MentoraddEducation" method="post">
																			  <div class="form-group">
																			    <label for="inputsm">School / College Name</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="sname" ng-model="sname" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Degree</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="degree" ng-model="degree" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Field of Study</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="study" ng-model="study" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Grade</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="grade" ng-model="grade" required/>
																			  </div>
																			  <div class="row form-group">
																			      <label for="inputsm" style="padding-left: 15px;">Time Period</label><br>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>From (Format : MM/DD/YYYY)</small></label>
																				    <input class="form-control input-md" id="inputsm" type="text" name="fromdate" ng-model="fromdate" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																				      <span style="color:red" ng-show="educationForm.fromdate.$dirty && educationForm.fromdate.$invalid">
																				      <span ng-show="educationForm.fromdate.$error.required">Please specify Date</span></span>
																					  <span ng-show="educationForm.fromdate.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>To (Format : MM/DD/YYYY)</small></label>
																				    <input class="form-control input-md" id="inputsm" type="text" name="todate" ng-model="todate" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																					  <span style="color:red" ng-show="educationForm.todate.$dirty && educationForm.todate.$invalid">
																				      <span ng-show="educationForm.todate.$error.required">Please specify Date</span></span>
																					  <span ng-show="educationForm.todate.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Description</label>
																			    <textarea rows="" cols="" class="form-control" name="description"></textarea>
																			  </div>
																			  <div class="form-group fload_right">
																			    	<button type="submit" class="btn btn-info btn-md active">Save</button>
																			  </div>
																		</form> 
																	  </div>
																    </div>
																  </div>
															 </div> <hr>
															 <!-- ------------------------------------------------------------------- -->
															  <div class="list-group font">
															    <form class="form-horizontal">
															     <div class="form-group">
																      <div class="col-sm-11">
																        <label class="control-label col-sm-6">INFORMATION OF EDUCATION DETAILS</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
															    <%
															    String query3="select mentoreducation.mentoreduId,mentoreducation.collegename,mentoreducation.qualification,mentoreducation.stream,mentoreducation.grade,mentoreducation.fromda,mentoreducation.toda,mentoreducation.description  from mentor,mentoreducation where mentor.mentorId=mentoreducation.mentorId and mentor.mentorId=?";
																 pst3=con.prepareStatement(query3);
																 pst3.setLong(1,mentorid);
																    rs3=pst3.executeQuery();
																	String dbcollege="",dbqualification="",dbfield="",dbgrade="",dbfrom="",dbto="",dbdesc="";
																	 long dbmentoreduid=0;
																	while(rs3.next())
																	    {   
																		dbmentoreduid=rs3.getLong(1);
																		dbcollege=rs3.getString(2);
																		dbqualification=rs3.getString(3);
																		dbfield=rs3.getString(4);
																		dbgrade=rs3.getString(5);
																		dbfrom=rs3.getString(6);
																		dbto=rs3.getString(7);
																		dbdesc=rs3.getString(8);
																		%>
																		 <div class="form-group">
																      <p class="control-label col-sm-3">School / College Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbcollege %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Degree:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbqualification %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Field of Study:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbfield %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Grade:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbgrade %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Time Period:</p>
																      <div class="col-sm-8">
																        <p class="control-label col-xs-1"><%=dbfrom %></p>
																        <p class="control-label col-sm-2 time"><%=dbto %></p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Description:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color"><%=dbdesc %></p>
																      </div>
																    </div><hr>
																     <%   }
																
															          %>
															       
																   
																  </form>
															  </div>
											      		</div>
											      	</div>
											    </div>
											    <div id="experience" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#professinal-experience"><b>Add Professional Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="professinal-experience" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form action="./Mentorexp" method="post">
																			  <div class="form-group">
																			    <label for="inputsm">Designation</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="designation">
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Company Name</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="company">
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Location</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="location">
																			  </div>
																			  <div class="row form-group">
																			      <label for="inputsm" style="padding-left: 15px;">Time Period</label><br>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>From</small></label>
																				    <input class="form-control input-sm" id="inputsm" type="text" name="fromdate">
																				  </div>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>To</small></label>
																				    <input class="form-control input-sm" id="inputsm" type="text" name="todate">
																				  </div>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Description</label>
																			    <textarea rows="" cols="" class="form-control" name="description"></textarea>
																			  </div>
																			  <div class="form-group">
																			    	<button type="submit" class="btn btn-info btn-md active fload_right">Save</button>
																			  </div>
																		</form> 
																	  </div>
																    </div>
																  </div>
															 </div> <hr>
															 <!----------------------------------------------------------------------->
															  <div class="list-group font">
															    <form class="form-horizontal">
															        <div class="form-group">
																      <div class="col-sm-11">
																        <label class="control-label col-sm-6">INFORMATION OF EXPERIENCE DETAILS</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
															 <%
															 
											                  String query4="select mentorexperience.mentorexpId, mentorexperience.designation,mentorexperience.companyname,mentorexperience.location,mentorexperience.fromda,mentorexperience.toda,mentorexperience.description from mentor,mentorexperience where mentor.mentorId=mentorexperience.mentorId and mentor.mentorId=?";      	                
											                  pst4=con.prepareStatement(query4);
											                  pst4.setLong(1,mentorid);
											                  rs4=pst4.executeQuery();
											                  String dbdesignation="",dbcompany="",dblocation="",dbfromdate="",dbtodate="",dbdescription="",dbuser="",dbname="";
									                          long dbmentorexpid=0;
									                           
									                           while(rs4.next())
									                           {
									                        	   dbmentorexpid=rs4.getLong(1);
									                         
									                        	   dbdesignation=rs4.getString(2);   
									                        	   dbcompany=rs4.getString(3);
									                        	   dblocation=rs4.getString(4);
									                        	   dbfromdate=rs4.getString(5);  	                
									                        	   dbtodate=rs4.getString(6); 	                
									                        	   dbdescription=rs4.getString(7);
									                        	   %>
									                        	   <div class="form-group">
																      <p class="control-label col-sm-3">Designation:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbdesignation %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Company Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbcompany %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Location:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dblocation %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Time Period:</p>
																      <div class="col-sm-8">
																        <p class="control-label col-xs-1"><%=dbfromdate %></p>
																        <p class="control-label col-sm-2 time"><%=dbtodate %></p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Description:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color"><%=dbdescription %></p>
																      </div>
																    </div><hr>
									                        <%   }
								                        	                %>
															 
															 
															 
															 
														
															 
																  
																  </form>
															  </div>
											      		</div>
											      	</div>
											    </div>
											   <!------------------------------------------------Myskills------------------------------------>
											    <div id="myskills" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#myskill"><b>Add Skills</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="myskill" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form action="./Mentoraddskill" method="post">
																			  <div class="form-group">
																			    <label for="inputsm">Add Skills</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="myskills" ng-model="myskills" required/>
																			  </div>
																			  <div class="form-group">
																			    	<button type="submit" class="btn btn-info btn-md active fload_right">Save</button>
																			  </div>
																		</form> 
																	  </div>
																    </div>
																  </div>
															 </div> <hr>
															  <div class="list-group font">
															    <form class="form-horizontal">
															        <div class="form-group">
																      <div class="col-sm-11">
																        <label class="control-label col-sm-3">MY KEY SKILLS</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
															 <%
															 
															 String query5="select mentorskill.mentorskillId,mentorskill.skill from mentor,mentorskill where mentor.mentorId=mentorskill.mentorId and mentor.mentorId=?";
												             pst5=con.prepareStatement(query5);
												             pst5.setLong(1,mentorid);
														     rs5=pst5.executeQuery();
														     long dbmentorskillid=0;
															String dbskillname="";
															while(rs5.next())
															{
																dbmentorskillid=rs5.getLong(1);
																dbskillname=rs5.getString(2);
																%>
																
																 <div class="form-group">
																      <p class="control-label col-sm-1"></p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbskillname %></p><hr>
																       
																      </div>
																    </div>
															<%}
															 
															 
															 %>
															
																   
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
											    <!-----------------------------------------------Courses---------------------->
											     <div id="design-course" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			 <div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#course-designs"><b>Add Course Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="course-designs" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form class="courseForm" action="./Mentoraddcourse" method="post">
																			  <div class="form-group">
																			    <label for="inputsm">Course Title:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="coursname" ng-model="coursname" required/>
																			    
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Course Description</label>
																			    <textarea rows="" cols="" class="form-control" name="descriptionss" ng-model="descriptionss" required></textarea>
																			 </div>
																			 <div class="form-group">
																			    <label for="inputsm">Select Level:</label>
																			    <select name="myVar" ng-model="myVar" class="form-control" required/>
																			    	<option  value="Beginner">Beginner</option>
																			    	<option  value="Core">Core</option>
																			    	<option  value="Advanced">Advanced </option>
																			    	<option  value="Expert">Expert</option>
																			    </select>
																		     </div>
															     			 <div class="form-group">
																			    <label for="inputsm">Course Prerequisite:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="courseprere" ng-model="courseprere" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Course Duration:</label>
																			    <div class="row">
																			         <div class="col-sm-8">
																					    <select class="form-control" name="duration" ng-model="duration" required/>
																					       <option></option>
																					        <option>1</option>
																					        <option>2</option>
																					        <option>3</option>
																					        <option>4</option>
																					        <option>5</option>
																					        <option>6</option>
																					    </select>
																					 </div>
																					 <div class="col-sm-4">
																					    <select class="form-control" name="month" ng-model="month" required/>
																					        <option>Months</option>
																					        <option>Weeks</option>
																					    </select>
																					 </div>
																				 </div>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Course Credit:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="credit" ng-model="credit" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Course Objective:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="objective" ng-model="objective" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Course Outcome:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="outcome" ng-model="outcome" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Course Modules:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="module" ng-model="module" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Course lab work / Equipments / Tools :</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="tools" ng-model="tools" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Reference:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="reference" ng-model="reference" required/>
																			  </div>
																			  <div class="form-group fload-right">
																			  		<button type="submit" class="btn btn-info active">Upload</button>
																			  </div>
																		</form> 
																	  </div>
																    </div>
																  </div>
															 </div> <hr>
															 <!-- ------------------------------------------------------------------- -->
															  <div class="list-group font">
															    <form class="form-horizontal">
															        <div class="form-group">
																      <div class="col-sm-11">
																        <label class="control-label col-sm-6">INFORMATION OF COURSE</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <%
																    
																    String query6="select mentorcourse.mentorcourseId,mentorcourse.coursename,mentorcourse.description,mentorcourse.couserlevel,mentorcourse.prerequisite,mentorcourse.duration,mentorcourse.weekmonth,mentorcourse.coursecredit,mentorcourse.courseobjective,mentorcourse.courseoutcomes,mentorcourse.coursemodule,mentorcourse.coursetool,mentorcourse.referencebook from mentor,mentorcourse where mentor.mentorId=mentorcourse.mentorId and mentor.mentorId=?";
														             pst6=con.prepareStatement(query6);
														             pst6.setLong(1,mentorid);
																     rs6=pst6.executeQuery();
																     long dbmentorcourseid=0;
																     int dbduration=0,dbcoursecredit=0;
																	String coursename="",dbdescription1="",dbcouserlevel="",dbprerequisite="",dbweekmonth="",dbcourseobjective="",dbcourseoutcomes="",dbcoursemodule="",dbcoursetool="",dbreferencebook="";
																	while(rs6.next())
																	{
																		dbmentorskillid=rs6.getLong(1);
																		coursename=rs6.getString(2); 
																		dbdescription1=rs6.getString(3);   
																		dbcouserlevel=rs6.getString(4);   
																		dbprerequisite=rs6.getString(5);   
																		dbduration=rs6.getInt(6);   
																		dbweekmonth=rs6.getString(7);   
																		dbcoursecredit=rs6.getInt(8);   
																		dbcourseobjective=rs6.getString(9);   
																		dbcourseoutcomes=rs6.getString(10);   
																		dbcoursemodule=rs6.getString(11);   
																		dbcoursetool=rs6.getString(12);   
																		dbreferencebook=rs6.getString(13);   
																		%>  
																     <div class="form-group">
																      <p class="control-label col-sm-3">Name of Course:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=coursename %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Description of Course:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbdescription1 %></p>
																      </div>
																    </div>
																    <%
																     if(dbcouserlevel.equals("Beginner"))
																    {%>
																    
																     <div class="form-group">
																      <p class="control-label col-sm-3">Select Level:</p>
																      <div class="col-sm-8">
																         <select class="form-control" name="">
																            <option  value="Beginner">Beginner</option>
																	    	<option  value="Core">Core</option>
																	    	<option  value="Advanced">Advanced </option>
																	    	<option  value="Expert">Expert</option>
																	    </select>
																      </div>
																    </div>	
																    <%}else if(dbcouserlevel.equals("Core"))
																    {%>
																      <div class="form-group">
																      <p class="control-label col-sm-3">Select Level:</p>
																      <div class="col-sm-8">
																        <select  class="form-control">
																         	<option  value="Core">Core</option>
																	    	<option  value="Beginner">Beginner</option>
																	    	<option  value="Advanced">Advanced </option>
																	    	<option  value="Expert">Expert</option>
																	    </select>
																      </div>
																    </div>		
																   <%}else  if(dbcouserlevel.equals("Advanced")) 
																    {%>
																      <div class="form-group">
																      <p class="control-label col-sm-3">Select Level:</p>
																      <div class="col-sm-8">
																        <select  class="form-control">
																            <option  value="Advanced">Advanced </option>
																	    	<option  value="Beginner">Beginner</option>
																	    	<option  value="Core">Core</option>
																	    	<option  value="Expert">Expert</option>
																	    </select>
																      </div>
																    </div>		
																   <% } else if(dbcouserlevel.equals("Expert")) 
																   {%>
																	   
																	  <div class="form-group">
																      <p class="control-label col-sm-3">Select Level:</p>
																      <div class="col-sm-8">
																        <select  class="form-control">
																            <option  value="Expert">Expert</option>
																	    	<option  value="Beginner">Beginner</option>
																	    	<option  value="Core">Core</option>
																	    	<option  value="Advanced">Advanced </option>
																	   </select>
																      </div>
																    </div>	  
																	 <% }else%>
																   
																  <div class="form-group">
																      <p class="control-label col-sm-3">Course Prerequisite:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbprerequisite %></p>
																      </div>
																  </div>
																  <div class="form-group">
																      <p class="control-label col-sm-3">Course Duration:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbduration%>&nbsp<%=dbweekmonth %></p>
																      </div>
																  </div>
																  <div class="form-group">
																      <p class="control-label col-sm-3">Course Credit:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbcoursecredit %></p>
																      </div>
																  </div>
																  <div class="form-group">
																      <p class="control-label col-sm-3">Course Objectives:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbcourseobjective %></p>
																      </div>
																  </div>
																  <div class="form-group">
																      <p class="control-label col-sm-3">Course Outcome:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbcourseoutcomes %></p>
																      </div>
																  </div>
																  <div class="form-group">
																      <p class="control-label col-sm-3">Course Modules:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbcoursemodule %></p>
																      </div>
																  </div>
																  <div class="form-group">
																      <p class="control-label col-sm-3">Course Lab work / Equipments / Tools:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbcoursetool %></p>
																      </div>
																  </div>
																   <div class="form-group">
																      <p class="control-label col-sm-3">Reference Book / Link:</p>
																      <div class="col-sm-8">
																         <p class="font-color"><%=dbreferencebook %></p>
																      </div>
																  </div><hr>
																   <%} %>
																   
															  </form>
											      		</div>
											      	</div>
											    </div>
										    </div>
								        </div>
							        </div>
					            </div>
					        </div>
					    </div>
					 </div>
			     </div>
			</div>
		 </div>
	</body>
</html>
