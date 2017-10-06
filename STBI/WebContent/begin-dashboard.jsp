<%@page import="beginmystartup_pojo.EducationDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myDashboard" ng-controller="dashboard">
    <head>
	   <title> User Dashboard</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/find-dashboard.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/dashboard.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
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
    	  response.sendRedirect("begin-login.jsp");
	 //RequestDispatcher rd=request.getRequestDispatcher("/begin_login.jsp");
	 // rd.forward(request,response);
	    }
       else
       {}
      }
    catch(Exception e)
       {
    	response.sendRedirect("begin-login.jsp");
  // RequestDispatcher rd=request.getRequestDispatcher("/begin_login.jsp");
  // rd.forward(request,response);
   }
	    con=Dao.getConnection();
	    query="select userId,firstname,middlename,lastname from user where emailid=?";
	    pst=con.prepareStatement(query);
	    pst.setString(1,useremail);
	    rs=pst.executeQuery();
	    String dbfname1="",dbmname1="",dblanme1="";
	    while(rs.next())
	    {
	    userid=rs.getLong(1);
	    dbfname1=rs.getString(2);
	    dbmname1=rs.getString(3);
	    dblanme1=rs.getString(4);
	    
	    
	    }
	   %>
		<div class="containers" >
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
		</nav>			<div class="top">
				<ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#myidea" class="tab-font-grorgia">MY IDEA</a></li>
				    <li><a data-toggle="tab" href="#myprofile" class="tab-font-grorgia">MY PROFILE</a></li>
				</ul>
				<div class="tab-content">
				    <div id="myidea" class="tab-pane fade in active">
					    <div class="panel panel-default card panels">
					    	<div class="panel-body">
					    	   <div>
					    	   <!----------------------------------Form------------------------------------------->
					    	     <form name="myIdeas" action="./Ideasubmit" method="post" enctype="multipart/form-data">
					    	   		<button  type="button" class="btn btn-info btn-md active" data-toggle="modal" data-target="#submit_new_idea">Submit New Idea</button>
					    	   		 <!-- Modal -->
									  <div class="modal fade" id="submit_new_idea" role="dialog">
									    <div class="modal-dialog modal-lg">
									      <!-- Modal content-->
									      <div class="modal-content">
									        <div class="modal-header">
									          <button type="button" class="close" data-dismiss="modal">&times;</button>
									          <h4 class="modal-title font-heading">Submit Information of New Idea</h4>
									        </div>
									        <div class="modal-body">
												  <div class="form-group">
												    <label for="inputsm">Title of your Idea / Innovation / Product / Solution</label>
												    <input class="form-control input-md" type="text" name="ideas" ng-model="ideas" required/>
												  </div>
												   <div class="form-group">
												    <label for="inputdefault">Enter <strong>TEN</strong> key words that are closely related to your idea</label>
												    <input class="form-control input-md"  type="text" name="keyword" ng-model="keyword" required/>
												    Ex :<small>(IOT, Java, DotNet, Agriculture Etc)</small>
												  </div>
												  <div class="form-group">
												    <label for="inputlg">Who are KEY users of your Product / Solution</label>
												    <input class="form-control input-md"  type="text" name="solution" ng-model="solution" required/>
												    Ex :<small>(Common Man, Doctor, Farmer, Student, Girls Etc)</small>
												  </div>
												  <div class="form-group">
												    <label for="inputlg">Maximum number of KEY users of solution/ Product in India</label>
												    <input class="form-control input-md"  type="text" name="keyuser" ng-model="keyuser" ng-pattern="/^[0-9]{1,6}$/" required/>
												     Ex :<small>(100000, 500000, 1000000 etc )</small><br>
												    <span style="color:red" ng-show="myIdeas.keyuser.$dirty && myIdeas.keyuser.$invalid">
												    <span ng-show="myIdeas.keyuser.$error.required"></span></span>
												    <span ng-show="myIdeas.keyuser.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed </span>
												  </div>
												  <div class="form-group">
												    <label for="inputlg">Target Market (Maximum possible value  for Sale)</label>
												    <input class="form-control input-md"  type="text" name="targetmarket" ng-model="targetmarket"  ng-pattern="/^[0-9]{1,6}$/" required/>
												    Ex :<small>(25000, 35000, 50000 etc )</small><br>
												    <span style="color:red" ng-show="myIdeas.targetmarket.$dirty && myIdeas.targetmarket.$invalid">
												    <span ng-show="myIdeas.targetmarket.$error.required"></span></span>
												    <span ng-show="myIdeas.targetmarket.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed </span>
												 
												    
												  </div>
												  <div class="form-group">
												    <label for="inputlg">Idea Description</label>
												    <textarea class="form-control" name="description" ng-model="description" required/></textarea>
												    <small>Explain <strong>crisply</strong> about your idea in 140 words and clearly mention what are its different solution. Also write unique selling point USP of your idea.</small>
												  </div>
												  <div class="form-group">
												     <label for="inputlg">Attachment (If available)</label>
												  	 <input type="file" class="btn btn-xs" name="pic" accept="application/pdf,application/vnd.ms-excel"  onchange="angular.element(this).scope().setFile(this)">{{FileMessage}} 
      
												  </div>
												  <div class="form-group">
												    <label for="inputlg">Date(MM DD,YYYY)</label>
												    <input class="form-control input-md"  type="text" name="today"  ng-model="today | date : 'dd/MM/y'" readonly>
												  </div>
												  <div class="form-group">
												    <label for="inputlg">Status</label> 
												    <input class="form-control input-md"  type="text" name="status" value="Pending" readonly>
												  </div>
									        </div>
									        <div class="modal-footer">
									          <button type="submit" class="btn btn-info btn-md active" ng-disabled="myIdeas.keyuser.$dirty && myIdeas.keyuser.$invalid && myIdeas.keyuser.$error.pattern||myIdeas.targetmarket.$dirty && myIdeas.targetmarket.$invalid && myIdeas.targetmarket.$error.pattern" >Submit</button>  
									          <button type="button" class="btn btn-warning btn-md active" data-dismiss="modal">Close</button>
									        </div>
									      </div>
									    </div>
									  </div>
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
								      String query1="select user.userId,ideasubmit.ideaid, ideasubmit.titlename,ideasubmit.idearegidate,ideasubmit.statusofidea from user,ideasubmit where user.userId=ideasubmit.userId and user.userId=? ";   	
							     	  pst1=con.prepareStatement(query1);
								      pst1.setLong(1,userid);
							     	  rs1=pst1.executeQuery();
							     	   long dbid=0,dbideasubmitid=0;
							     	    String dbuserappli="", dbideatitle="",dbideadate="",dbideastatus="",dbemail="";
							     	    while(rs1.next())
							     	    { //  dbuserappli=r.getString(1);
							     	    	dbid=rs1.getLong(1);
							     	    	dbideasubmitid=rs1.getLong(2);
							     	    	dbideatitle=rs1.getString(3);
							     	    	dbideadate=rs1.getString(4);
							     	    	dbideastatus=rs1.getString(5);
								       %>
								          <tbody>
								      <tr>
								        <td><b><%=dbideasubmitid %></b></td>
								        <td><p class="table-idea"><a href="begin-view-all-details.jsp" target="_blank"><%=dbideatitle %></a></p></td>
								        <td><p class="table-data "><%=dbideadate %></p></td>
								        <td><p class="table-data "><%=dbideastatus %></p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" name="ideaid" href="begin-user-view-idea.jsp?ideaid=<%=dbideasubmitid %>" target="_blank" >My Support</a>
											<a class="btn btn-xs btn-warning active" href="begin-update-progress.jsp" target="_blank">Update Progress</a>
											<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#delete"><i class="fa fa-trash" style="font-size:18px"></i></button>
										</p></td>
								      </tr>
								     </tbody>
								     <%}
							     	   try
							     		 {
							     			pst1.close();
								     		rs1.close();	 
							     		 }
							     		 catch(SQLException ex)
							     		 {
							     			ex.printStackTrace();
							     		 }
							     	  %>
							     	</table><hr>
								  <!-------------------------------Delete----------------------------------->
								   <div class="modal fade" id="delete" role="dialog">
									    <div class="modal-dialog modal-md">
									      <div class="modal-content">
									        <div class="modal-header">
									          <button type="button" class="close" data-dismiss="modal">&times;</button>
									          <h5 class="modal-title">Say reason for deleting your idea.</h5>
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
								  	<button class="btn btn-info btn-md active">FIND MY OPPORTUNITY</button>
								  	<button class="btn btn-warning btn-md active">UPGRADE MY SKILL</button>
								  	<button class="btn btn-info btn-md active">JOIN AS MENTOR</button>
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
								                <a data-toggle="tab" href="#myskills" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>MY SKILLS
								                </a>
							              </div><br>
							               <div class="list-group btn-aligns">
								                <button class="btn btn-info btn-md active btn-block">FIND MY OPPORTUNITY</button>
							              </div>
							               <div class="list-group btn-aligns">
								               <button class="btn btn-warning btn-md active btn-block ">UPGRADE MY SKILL</button>
							              </div>
							              <div class="list-group btn-aligns">
								               <button class="btn btn-info btn-md active btn-block">JOIN AS MENTOR</button>
							              </div>
							         </div>
							         <div class="col-sm-9 profile-all-details">
								     	   <div class="tab-content">
											    <div id="personal-details" class="tab-pane fade in active">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			 <div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title ">
																        <a data-toggle="collapse" href="#personals" class="font-containt"><b class="font-containt">Add Personal Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="personals" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="infoForm" action="./UpdateUserInfo" method="post">
																			  <div class="form-group">
																			    <label for="inputsm">Add New Mobile No:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="mobilenumber" ng-model="mobilenumber" ng-pattern="mobiles" required/>
																			    <small>Format :+91 9855514371</small><br>
																			     <span style="color:red" ng-show="infoForm.mobilenumber.$dirty && infoForm.mobilenumber.$invalid">
														   					     <span ng-show="infoForm.mobilenumber.$error.required">Please specify your Mobile Number</span></span>
														                         <span ng-show="infoForm.mobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Add New Email Id:</label>
																			      <input class="form-control" id="focusedInput" type="text" value="" name="email" ng-model="email" ng-pattern="emailid" required/>
																				  <span style="color:red" ng-show="infoForm.email.$dirty && infoForm.email.$invalid">
																			      <span ng-show="infoForm.email.$error.required">Please specify your Email ID</span></span>
																				  <span ng-show="infoForm.email.$error.pattern" style="color:red">Please enter correct email address.</span>
														 
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Add New Address</label>
																			    <textarea rows="" cols="" class="form-control" name="address" ng-model="address" required/></textarea>
																			  </div>
																			  <div class="fload_right">
																			  		<button type="submit" class="btn btn-info btn-md active"
																			  		        ng-disabled="infoForm.email.$dirty && infoForm.email.$invalid && infoForm.email.$error.pattern || 
																			  		                     infoForm.mobilenumber.$dirty && infoForm.mobilenumber.$invalid && infoForm.mobilenumber.$error.pattern"
																			  		>Save</button>
																			  </div>
																		</form> 
																	  </div>
																    </div>
																  </div>
															 </div> <hr>
															 <!-- ------------------------------------------------------------------- -->
															 <%
															 
															 String query2="select * from user where userId=?";
															 pst2=con.prepareStatement(query2);
															 pst2.setLong(1,userid);
															 rs2=pst2.executeQuery();
															 long dbuserid=0;
															 String dbfname="",dbmname="",dblname="",dbdob="",dbgender="",dbmobile="",dbemail1="";
															
															 while(rs2.next())
															 {
																 
																 dbuserid=rs2.getLong("userId");
																 if(dbuserid==userid)
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
																      <p class="control-label col-sm-3">Full Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbfname %> &nbsp<%=dbmname %>&nbsp<%=dblname %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Email:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbemail1 %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Mobile No:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbmobile %></p>
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
																     
																    
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
											    <div id="education" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#educations"><b class="font-containt">Add Education Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="educations" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="educationForm" action="./InsertUserEducation" method="post">
																			  <div class="form-group">
																			    <label for="inputsm">School / College Name</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="name" ng-model="name" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Degree</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="degree" ng-model="degree" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Field of Study</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="field" ng-model="field" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Grade</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="grade" ng-model="grade" required/>
																			  </div>
																			  <div class="row form-group">
																			      <label for="inputsm" style="padding-left: 15px;">Time Period</label><br>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>From (Format : MM/DD/YYYY)</small></label>
																				    <input class="form-control input-md" id="inputsm" type="text" name="fromdate" ng-model="from" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																				      <span style="color:red" ng-show="educationForm.from.$dirty && educationForm.from.$invalid">
																				      <span ng-show="educationForm.from.$error.required">Please specify Date</span></span>
																					  <span ng-show="educationForm.from.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>To (Format : MM/DD/YYYY)</small></label>
																				    <input class="form-control input-md" id="inputsm" type="text" name="todate" ng-model="to" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																					  <span style="color:red" ng-show="educationForm.to.$dirty && educationForm.to.$invalid">
																				      <span ng-show="educationForm.to.$error.required">Please specify Date</span></span>
																					  <span ng-show="educationForm.to.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Description</label>
																			    <textarea rows="" cols="" class="form-control" name="description"/></textarea>
																			  </div>
																			  <div class="form-group">
																			    	<button type="submit" class="btn btn-info btn-md active fload_right"
																			    			ng-disabled="educationForm.from.$dirty && educationForm.from.$invalid && educationForm.from.$error.pattern 
																			    			|| educationForm.to.$dirty && educationForm.to.$invalid && educationForm.to.$error.pattern"
																			    	>Save</button>
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
																   <%--  <%
																    String query3="select * from education where userId=? ";
																    pst3=con.prepareStatement(query3);
																    pst3.setLong(1,userid);
																    rs3=pst3.executeQuery();
																    String dbcollegename="",dbquali="",dbstream="",dbgrade="",dbfromdate="",dbtodte="",dbdesc="";
																    long dbuseridd=0;
																    while(rs3.next())
																    {
																    	       dbcollegename=rs3.getString("collegename");
																               dbquali=rs3.getString("qualification");
																    		   dbstream=rs3.getString("stream");
																    		   dbgrade=rs3.getString("grade");
																    		   dbfromdate=rs3.getString("fromda");
																    		   dbtodte=rs3.getString("toda");
																    		   dbdesc=rs3.getString("description");
																    		   dbuserid=rs3.getLong("userId");
																    			
																    		%>	--%>
																    		
																    		<%
																    	
																    		ArrayList<EducationDetails> list = (ArrayList<EducationDetails>) request.getAttribute("ed");

																    		// print the information about every category of the list
																    		for(EducationDetails category : list) {
																    		    out.println(category.getCollegename());
																    		   
																    		}
																    		
																    		
																    		%>
																    	<%-- 	  <div class="form-group">
																      <p class="control-label col-sm-3">School / College Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=educationDetails.getCollegename() %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Degree:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbquali %></p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Field of Study:</p>
																      <div class="col-sm-8">
																        <p class="font-color"><%=dbstream %></p>
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
																        <p class="control-label col-xs-1"><%=dbfromdate %></p>
																        <p class="control-label col-sm-2 time"><%=dbtodte %></p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Description:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color"><%=dbdesc %></p>
																      </div>
																    </div><hr>
																    			
																 <%-- <%  }
																    %>--%>
																  
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
											    <div id="myskills" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#myskill"><b class="font-containt">Add Skills</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="myskill" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form action="./UserAddskill" method="post">
																			  <div class="form-group">
																			    <label for="inputsm">Add Skills</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="skills" ng-model="skills" required/>
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
															    String query4="select skills.skillid,skills.skillname from user,skills where user.userId=skills.userId and user.userId=?";
													             pst4=con.prepareStatement(query4);
													             pst4.setLong(1,userid);
															     rs4=pst4.executeQuery();
															     int dbskillid=0;
																String dbskillname="";
																while(rs4.next())
																{
																	dbskillid=rs4.getInt(1);
																	dbskillname=rs4.getString(2);
																
																     %>
																      <div class="form-group">
																      <p class="control-label col-sm-1"></p>
																      <div class="col-sm-8">
																      
																         <p class="font-color"><%=dbskillname %></p><hr>
																        
																      </div>
																    </div>
																     
															    <%}%>
															      </form>
															  </div><hr>
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
