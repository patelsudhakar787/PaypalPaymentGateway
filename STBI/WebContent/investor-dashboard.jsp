<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="investorDashboard" ng-controller="investorctrldashboard">
    <head>
	    <title>Dashboard</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/mentor-dashboard.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/investor-dashboard.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
	    <div ng-include="'investor-navbar.jsp'"></div>
		<div class="containers">
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
								    <tbody>
								      <tr>
								        <td><b>325335</b></td>
								        <td><p class="table-idea"><a href="investor-view-all-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class="table-data">Pending</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="" target="_blank">Interested</a>
											<button class="btn btn-xs btn-warning active" data-toggle="modal" data-target="#delete"><i class="fa fa-trash" style="font-size:18px"></i></button>
										</p></td>
								      </tr>
								      <tr>
								        <td><b>656765</b></td>
								        <td><p class="table-idea"><a href="investor-view-all-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class="table-data">Pending</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="" target="_blank">Interested</a>
											<button class="btn btn-xs btn-warning active" data-toggle="modal" data-target="#delete"><i class="fa fa-trash" style="font-size:18px"></i></button>
										</p></td>
								      </tr>
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
								  	<button class="btn btn-info btn-md active">BEGIN MY STARTUP</button>
								  	<button class="btn btn-warning btn-md active"> Skill UPGRADE MY SKILL</button>
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
							                    <a data-toggle="tab" href="#basic-details" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>BASIC DETAILS
								                </a>
								                <a data-toggle="tab" href="#personal-details" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>PERSONAL DETAILS
								                </a>
								                <a data-toggle="tab" href="#education" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-university fa-profile-size"></i><br/>EDUCATION DETAILS
								                </a>
								                <a data-toggle="tab" href="#experience" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>PROFESSIONAL EXPERIENCE
								                </a>
								                 <a data-toggle="tab" href="#myskills" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>MY AREA OF INTERESTED FOR INVESTMENT
								                </a>
							              </div><br>
							         </div>
							         <div class="col-sm-9 profile-all-details">
								     	   <div class="tab-content">
								     	         <div id="basic-details" class="tab-pane fade in active">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
										      				   <div class="form-group">
															      <p class="control-label col-sm-3">First Name:</p>
															      <div class="col-sm-8">
															        <p class="font-color">8793340769</p>
															      </div>
															    </div>
															    <div class="form-group">
															      <p class="control-label col-sm-3">Middle Name:</p>
															      <div class="col-sm-8">
															        <p class="font-color">dattaprasad.ingle@rlard.com</p>
															      </div>
															    </div>
															    <div class="form-group">
															      <p class="control-label col-sm-3">Last Name:</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
															     <div class="form-group">
															      <p class="control-label col-sm-3">Date of Birth :</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
															     <div class="form-group">
															      <p class="control-label col-sm-3">Gender:</p>
															      <div class="col-sm-8">
															        <p class="font-color">8793340769</p>
															      </div>
															    </div>
															    <div class="form-group">
															      <p class="control-label col-sm-3">Mobile Number:</p>
															      <div class="col-sm-8">
															        <p class="font-color">dattaprasad.ingle@rlard.com</p>
															      </div>
															    </div>
															    <div class="form-group">
															      <p class="control-label col-sm-3">Email Id:</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
															     <div class="form-group">
															      <p class="control-label col-sm-3">Adhar/UI No.:</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
															    <div class="form-group">
															      <p class="control-label col-sm-3">Temporary Address:</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
															     <div class="form-group">
															      <p class="control-label col-sm-3">Permanent Address:</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
															    <div class="form-group">
															      <p class="control-label col-sm-3">City:</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
															     <div class="form-group">
															      <p class="control-label col-sm-3">Pincode:</p>
															      <div class="col-sm-8">
															        <p class="font-color">15/03/1993</p>
															      </div>
															    </div>
											      		</div>
											      	</div>
											     </div>
											    <div id="personal-details" class="tab-pane fade">
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
																		<form name="myForm">
																			  <div class="form-group">
																			    <label for="inputsm">Add New Mobile No :</label>
																			    <input class="form-control input-sm"  type="text" ng-model="mobilenumber" name="mobilenumber" ng-pattern="/^(\+\91{1,2}[- ])\d{10}$/"><small>+91 9855514371</small><br>
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
																			    <label for="inputsm">Add New Address</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="address" >
																			  </div>
																			  <div class="form-group fload_right">
																			  		<button type="submit" class="btn btn-info btn-md active"
																			  		  ng-disabled="myForm.mobilenumber.$dirty && myForm.mobilenumber.$invalid && myForm.mobilenumber.$error.pattern ||
																			  		  			   myForm.email.$dirty && myForm.email.$invalid && myForm.email.$error.pattern"
																			  		>Submit</button>
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
																        <label class="control-label col-sm-6">Personal Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Mobile No:</p>
																      <div class="col-sm-8">
																        <p class="font-color">8793340769</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Email Id:</p>
																      <div class="col-sm-8">
																        <p class="font-color">dattaprasad.ingle@rlard.com</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Address:</p>
																      <div class="col-sm-8">
																        <p class="font-color">15/03/1993</p>
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
																        <a data-toggle="collapse" href="#educations"><b>Add Education Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="educations" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="educationForm">
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
																				    <input class="form-control input-md" id="inputsm" type="text" name="from" ng-model="from" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																				      <span style="color:red" ng-show="educationForm.from.$dirty && educationForm.from.$invalid">
																				      <span ng-show="educationForm.from.$error.required">Please specify Date</span></span>
																					  <span ng-show="educationForm.from.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>To (Format : MM/DD/YYYY)</small></label>
																				    <input class="form-control input-md" id="inputsm" type="text" name="to" ng-model="to" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																					  <span style="color:red" ng-show="educationForm.to.$dirty && educationForm.to.$invalid">
																				      <span ng-show="educationForm.to.$error.required">Please specify Date</span></span>
																					  <span ng-show="educationForm.to.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Description</label>
																			    <textarea rows="" cols="" class="form-control" name="description"></textarea>
																			  </div>
																			  <div class="form-group fload_right">
																			    	<button type="submit" class="btn btn-info btn-md active" 
																			    			ng-disabled="educationForm.to.$dirty && educationForm.to.$invalid && educationForm.to.$error.pattern ||
																			    						 educationForm.from.$dirty && educationForm.from.$invalid && educationForm.from.$error.pattern"
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
																        <label class="control-label col-sm-6">Education Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">School / College Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color">MIT College</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Degree:</p>
																      <div class="col-sm-8">
																        <p class="font-color">PG</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Field of Study:</p>
																      <div class="col-sm-8">
																        <p class="font-color">MCA</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Grade:</p>
																      <div class="col-sm-8">
																        <p class="font-color">A</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Time Period:</p>
																      <div class="col-sm-8">
																        <p class="control-label col-xs-1">14/06/2014</p>
																        <p class="control-label col-sm-2 time">14/06/2016</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Description:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">A</p>
																      </div>
																    </div>
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
											    <!-------------------------------PROFESSIONAL EXPERIENCE-------------------------->
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
																		<form name="profForm">
																			  <div class="form-group">
																			    <label for="inputsm">Designation</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="designation" ng-model="designation" required>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Company Name</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="cname" ng-model="cname" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Location</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="location" ng-model="location" required/>
																			  </div>
																			   <div class="row form-group">
																			      <label for="inputsm" style="padding-left: 15px;">Time Period</label><br>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>From (Format : MM/DD/YYYY)</small></label>
																				    <input class="form-control input-md" id="inputsm" type="text" name="from" ng-model="from" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																				      <span style="color:red" ng-show="profForm.from.$dirty && profForm.from.$invalid">
																				      <span ng-show="profForm.from.$error.required">Please specify Date</span></span>
																					  <span ng-show="profForm.from.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																				  <div class=" col-sm-6">
																				    <label for="inputsm"><small>To (Format : MM/DD/YYYY)</small></label>
																				    <input class="form-control input-md" id="inputsm" type="text" name="to" ng-model="to" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																					  <span style="color:red" ng-show="profForm.to.$dirty && profForm.to.$invalid">
																				      <span ng-show="profForm.to.$error.required">Please specify Date</span></span>
																					  <span ng-show="profForm.to.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																				  </div>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Description</label>
																			    <textarea rows="" cols="" class="form-control"></textarea>
																			  </div>
																			  <div class="form-group">
																			    	<button type="submit" class="btn btn-info btn-md active fload_right"
																			    	        ng-disabled="profForm.from.$dirty && profForm.from.$invalid && profForm.from.$error.pattern ||
																			    	         	profForm.to.$dirty && profForm.to.$invalid && profForm.to.$error.pattern"
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
																        <label class="control-label col-sm-6">Professional Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Designation:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Software Developer</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Company Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color">RLARD</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Location:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Baner, Pune</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Time Period:</p>
																      <div class="col-sm-8">
																        <p class="control-label col-xs-1">14/06/2014</p>
																        <p class="control-label col-sm-2 time">14/06/2016</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Description:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">A</p>
																      </div>
																    </div>
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
																        <a data-toggle="collapse" href="#myskill"><b>Add Area of Interested for Investment</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="myskill" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form>
																			  <div class="form-group">
																			    <label for="inputsm">Add</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="skill" ng-model="skill" required/>
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
																    <div class="form-group">
																      <p class="control-label col-sm-1"></p>
																      <div class="col-sm-8">
																         <p class="font-color">Angular JS</p><hr>
																         <p class="font-color">Bootstrap</p><hr>
																         <p class="font-color">HTML5</p><hr>
																         <p class="font-color">CSS3</p><hr>
																      </div>
																    </div>
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
