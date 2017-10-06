<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html ng-app="sigDashboard" ng-controller="sigctrldashboard">
    <head>
	    <title>Dashboard</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/sig-dashboard.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/city-navbar.js"></script>
	    <script src="js/sig-dashboard.js"></script>
    </head>
	<body>
		<div ng-include="'incubation-navbar.jsp'"></div>
		<div class="containers" >
			<div class="top">
				<ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#myidea" class="tab-font-grorgia">IDEA FROM INCUBATION</a></li>
				    <li><a data-toggle="tab" href="#opportinity" class="tab-font-grorgia">MY OPPORTUNITY</a></li>
				    <li><a data-toggle="tab" href="#myprofile" class="tab-font-grorgia">INCUBATION PROFILE</a></li>
				</ul>
				<div class="tab-content">
				    <!---------------------------------------------------------iNCUBATION IDEA-------------------------------------------->
				    <div id="myidea" class="tab-pane fade in active">
					    <div class="panel panel-default card panels">
					    	<div class="panel-body">
					    	    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Filter</button>
								<div id="demo" class="collapse center ">
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
								        <td><p class="table-idea"><a href="incubation-view-all-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class="table-data">Pending</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="incubation-user-view-details.jsp" target="_blank">My Support</a>
											<button type="button" class="btn btn-xs btn-warning active"  data-toggle="modal" data-target="#delete"><i class="fa fa-trash" style="font-size:18px"></i></button>
										</p></td>
								      </tr>
								      <tr>
								        <td><b>656765</b></td>
								        <td><p class="table-idea"><a href="incubation-view-all-details.jsp" target="_blank"> The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class="table-data">Pending</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="incubation-user-view-details.jsp" target="_blank">My Support</a>
											<button type="button" class="btn btn-xs btn-warning active"  data-toggle="modal" data-target="#delete"><i class="fa fa-trash" style="font-size:18px"></i></button>
										</p></td>
								      </tr>
								    </tbody>
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
					    	</div>
					    </div>
					 </div>
					  <!---------------------------------------------------------MY OPPORTUNITY-------------------------------------------->
					  <div id="opportinity" class="tab-pane fade">
				       <div class="panel panel-default card panels">
					      <div class="panel-body">
					      	   <div class="row">
									<div class="col-md-12">
											<div class="tabbable-line">
												<ul class="nav nav-tabs container-opportunity ">
													<li class="active">
														<a href="#project" data-toggle="tab" class="tab-sub-font-grorgia">PROJECTS</a>
													</li>
													<li>
														<a href="#grand-funding" data-toggle="tab" class="tab-sub-font-grorgia">GRANTS AND FUNDING</a>
													</li>
													<li>
														<a href="#halcathons" data-toggle="tab" class="tab-sub-font-grorgia">HACKATHONS </a>
													</li>
												</ul><hr>
												<div class="tab-content">
													<div class="tab-pane active" id="project">
													    <button type="button" class="btn btn-info active" data-toggle="collapse" data-target="#proj">Filter</button>
														<div id="proj" class="collapse center ">
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
														        <th class="table-dark-gray">LIST OF PROJECTS</th>
														        <th class="table-fent-gray">DATE </th>
														        <th class="table-dark-gray">STATUS</th>
														        <th class="table-fent-gray"></th>
														      </tr>
														    </thead>
														    <tbody>
														     <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea"><a href="incubation-project-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="incubation-project-view-ideas.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="incubation-project-upgrade-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#projectdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														      <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea"><a href="incubation-project-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="incubation-project-view-ideas.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="incubation-project-upgrade-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#projectdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														    </tbody>
														 </table><hr>
														 <!-------------------------------Delete----------------------------------->
														   <div class="modal fade" id="projectdelete" role="dialog">
															    <div class="modal-dialog modal-md">
															      <div class="modal-content">
															        <div class="modal-header">
															          <button type="button" class="close" data-dismiss="modal">&times;</button>
															          <h5 class="modal-title">Say reason for deleting your idea ?</h5>
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
													</div>
													<div class="tab-pane" id="grand-funding">
													    <button type="button" class="btn btn-info active" data-toggle="collapse" data-target="#grands">Filter</button>
														<div id="grands" class="collapse center ">
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
														        <th class="table-dark-gray">LIST OF GRAND AND FUNDING</th>
														        <th class="table-fent-gray">DATE </th>
														        <th class="table-dark-gray">STATUS</th>
														        <th class="table-fent-gray"></th>
														      </tr>
														    </thead>
														    <tbody>
														     <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea"><a href="incubation-grant-funding-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="incubation-grant-funding-view-all-deatails.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="incubation-grand-funding-upgrate-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#granddelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														      <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea"><a href="incubation-grant-funding-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="incubation-grant-funding-view-all-deatails.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="incubation-grand-funding-upgrate-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#granddelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														    </tbody>
														 </table><hr>
														  <!-------------------------------Delete----------------------------------->
														   <div class="modal fade" id="granddelete" role="dialog">
															    <div class="modal-dialog modal-md">
															      <div class="modal-content">
															        <div class="modal-header">
															          <button type="button" class="close" data-dismiss="modal">&times;</button>
															          <h5 class="modal-title">Say reason for deleting your Grand and Funding ?</h5>
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
													</div>
													<div class="tab-pane" id="halcathons">
														<button type="button" class="btn btn-info active" data-toggle="collapse" data-target="#hackas">Filter</button>
														<div id="hackas" class="collapse center ">
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
														        <th class="table-dark-gray">LIST OF HALCATHONS</th>
														        <th class="table-fent-gray">DATE </th>
														        <th class="table-dark-gray">STATUS</th>
														        <th class="table-fent-gray"></th>
														      </tr>
														    </thead>
														    <tbody>
														     <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="incubation-hackathons-view-all-details.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="incubation-hackathons-upgrate-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#hackathonsdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														      <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="incubation-hackathons-view-all-details.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="incubation-hackathons-upgrate-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#hackathonsdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														    </tbody>
														 </table><hr>
														 <!-------------------------------Delete----------------------------------->
														   <div class="modal fade" id="hackathonsdelete" role="dialog">
															    <div class="modal-dialog modal-md">
															      <div class="modal-content">
															        <div class="modal-header">
															          <button type="button" class="close" data-dismiss="modal">&times;</button>
															          <h5 class="modal-title">Say reason for deleting your Hackathon ?</h5>
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
													</div>
												</div>
											</div>
									</div>
								</div>
					      </div>
					   </div>
					  </div>
					 <!---------------------------------------------------------MY SIG PROFILE-------------------------------------------->
				    <div id="myprofile" class="tab-pane fade">
				       <div class="panel panel-default card panels">
					      <div class="panel-body">
					    	<div class="row">
					    	   <div class="col-sm-12">
							          <div class="col-sm-3 bhoechie-tab-menu ">
							              <div class="list-group card">
							                   <a data-toggle="tab" href="#basic-profile" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>BASIC PROFILE
								                </a>
								                <a data-toggle="tab" href="#personal-details" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>ADD INCUBATEE DETAILS
								                </a>
								                <a data-toggle="tab" href="#techmology" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>INCUBATION<br><small>MILESTONES/ ACHIEMENTS/ SUCCESS STORIES</small>
								                </a>
							              </div><br>
							         </div>
							         <div class="col-sm-9 profile-all-details">
								     	   <div class="tab-content">
								     	         <div id="basic-profile" class="tab-pane fade in active">
								     	             <div class="panel panel-default card">
											      		<div class="panel-body">
										     	            <div class="list-group font">
															    <form class="form-horizontal" name="detailsForm">
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name of Incubation Center:</p>
																      <div class="col-sm-8">
																        <p class="font-color">samruddhitbi</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Thrust Area:</p>
																      <div class="col-sm-8">
																        <p class="font-color">abc</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Legal Status:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Section 8 company</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Total Incubation Space in Sq.Ft:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Less than 10000</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Name of Incubation Member:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">dattaprasad D. Ingle</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Mobile Number:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">8793340769</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Email Id:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">dattaprasad D. Ingle</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Incubation Center Address:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">Kothrud, Pune</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">City:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">Pune</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Pincode:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">411036</p>
																      </div>
																    </div>
																  </form>
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
																        <a data-toggle="collapse" href="#personals"><b>Add Incubatee Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="personals" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="incubateeForm">
																		      <div class="form-group">
																			    <label for="inputsm">Name / Title of Incubatee:</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="incuname" ng-model="incuname" required/>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Incubatee Profile:</label>
																			    <select class="form-control" name="profile" ng-model="profile" required>
																			    	<option ng-show="false">Select</option>
																			    	<option>Ideation</option>
																			    	<option>POC</option>
																			    	<option>Rapid Prototype</option>
																			    	<option>Pilet Production</option>
																			    	<option>Pitch / building</option>
																			    	<option>Waiting for scaleup funding</option>
																			    	<option>Graduated</option>
																			    </select>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">No. of Team Member:</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="team" ng-model="team" ng-pattern="/^[0-9]{1,6}$/" required>
																			     <span style="color:red" ng-show="incubateeForm.team.$dirty && incubateeForm.team.$invalid">
																				 <span ng-show="incubateeForm.team.$error.required">Please specify Date</span></span>
																			     <span ng-show="incubateeForm.team.$error.pattern" style="color:red"> Alphabet and special Characters are Not Allowed .</span>
											
																			  </div>
																			 <div class="form-group">
																			     <label for="inputsm">Date of Start-up: (Format : MM/DD/YYYY)</label>
																				 <input class="form-control input-md" id="inputsm" type="text" name="dates" ng-model="dates" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																				 <span style="color:red" ng-show="incubateeForm.dates.$dirty && incubateeForm.dates.$invalid">
																				 <span ng-show="incubateeForm.dates.$error.required">Please specify Date</span></span>
																			     <span ng-show="incubateeForm.dates.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																			
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Legal Status:</label>
																			    <select class="form-control" name="legalstatus" ng-model="legalstatus"  required>
																			    	<option ng-show="false">Select</option>
																			    	<option>Unregistered Beginner</option>
																			    	<option>Registered Startup</option>
																			    	<option>Partner ship</option>
																			    	<option>Private Limited</option>
																			    	<option>LLP</option>
																			    	<option>Public Limited</option>
																			    	<option value="other">Other</option>
																			    </select><br>
																			    <div ng-switch="legalstatus">
																			    	<div ng-switch-when="other">
																			    		<input type="text" class="form-control" placeholder="Please Mention">
																			    	</div>
																			    </div>
																			  </div>
																			  <div class="fload_right">
																			  		<button type="submit" class="btn btn-info btn-ms active"
																			  		        ng-disabled="incubateeForm.dates.$error.pattern || incubateeForm.team.$error.pattern"
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
																        <label class="control-label col-sm-8">Incubatee Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name / Title of Incubatee:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Dattaprasad Dashrath Ingle</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Incubatee Profile:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Pilet Production</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">No. of Team Member :</p>
																      <div class="col-sm-8">
																        <p class="font-color">5</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Date of Start-up:</p>
																      <div class="col-sm-8">
																        <p class="font-color">18/07/2017</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Legal Status:</p>
																      <div class="col-sm-8">
																        <p class="font-color">LLP</p>
																      </div>
																    </div>
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
											    <div id="techmology" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#myskill"><b>Add Incubation Milestones/ Achievements/ Success Stories</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="myskill" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="mileForm">
																			  <div class="form-group">
																			    <label for="inputsm">Date: (Format : MM/DD/YYYY)</label>
																				 <input class="form-control input-md" id="inputsm" type="text" name="dates" ng-model="dates" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																				 <span style="color:red" ng-show="mileForm.dates.$dirty && mileForm.dates.$invalid">
																				 <span ng-show="mileForm.dates.$error.required">Please specify Date</span></span>
																			     <span ng-show="mileForm.dates.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Milestone Name :</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="milestonename" ng-model="milestonename" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Milestone Type:</label>
																			    <select class="form-control" name="milestone" ng-model="milestone" required>
																			    	<option value="" ng-show="false">Select</option>
																			    	<option value="Faculty Achievement">Publication</option>
																			    	<option value="Faculty Achievement">Grants</option>
																			    	<option value="Faculty Achievement">POC</option>
																			    	<option value="Faculty Achievement">Rapid Prototype</option>
																			    	<option value="Faculty Achievement">Ready to Commercialization</option>
																			    	<option value="Faculty Achievement">Outcome</option>
																			    	<option value="Faculty Achievement">Consultancy</option>
																			    	<option value="Faculty Achievement">Training</option>
																			    	<option value="Faculty Achievement">Medal and Certificate</option>
																			    </select>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Brief Description:</label>
																			   <textarea rows="" cols="" class="form-control" name="description" ng-model="description" required></textarea>
																			  </div>
																			  <div class="fload_right">
																			  		<button type="submit" class="btn btn-info btn-md active"
																			  		        ng-disabled="mileForm.dates.$error.pattern"
																			  		>Save</button>
																			  
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
																        <label class="control-label col-sm-7">Incubation Milestones/ Achievements/ Success Stories</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Date:</p>
																      <div class="col-sm-8">
																        <p class="font-color">12/07/2017</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Milestone Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Powertech Event</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Milestone Type:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Student Faculty</p>
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
