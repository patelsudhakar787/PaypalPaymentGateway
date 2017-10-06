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
	    <script src="js/sig-dashboard.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
		<div ng-include="'institute-navbar.jsp'"></div>
		<div class="containers">
			<div class="top">
				<ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#myidea" class="tab-font-grorgia">IDEA FROM INSTITUTE</a></li>
				    <li><a data-toggle="tab" href="#opportinity" class="tab-font-grorgia">MY OPPORTUNITY</a></li>
				    <li><a data-toggle="tab" href="#myprofile" class="tab-font-grorgia">INSTITUTE PROFILE</a></li>
				</ul>
				<div class="tab-content">
				    <!---------------------------------------------------------MY SIG IDEA-------------------------------------------->
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
								        <td><p class="table-idea"><a href="institute-view-all-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class="table-data">Pending</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="institute-user-view-details.jsp" target="_blank">My Support</a>
											<button type="button" class="btn btn-xs btn-warning active"  data-toggle="modal" data-target="#delete"><i class="fa fa-trash" style="font-size:18px"></i></button>
										</p></td>
								      </tr>
								      <tr>
								        <td><b>656765</b></td>
								        <td><p class="table-idea"><a href="institute-view-all-details.jsp" target="_blank"> The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class="table-data">Pending</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="institute-user-view-details.jsp" target="_blank">My Support</a>
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
														        <td><p class="table-idea"><a href="institute-project-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="institute-project-view-ideas.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="institute-project-upgrade-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#projectdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														      <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea"><a href="institute-project-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="institute-project-view-ideas.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="institute-project-upgrade-progress.jsp" target="_blank">Update Progress</a>
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
														        <td><p class="table-idea"><a href="institute-grant-funding-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="institute-grant-funding-view-all-deatails.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="institute-grand-funding-upgrate-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#granddelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														      <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea"><a href="institute-grant-funding-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="institute-grant-funding-view-all-deatails.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="institute-grand-funding-upgrate-progress.jsp" target="_blank">Update Progress</a>
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
																	<a class="btn btn-xs btn-info active" href="institute-hackathons-view-all-details.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="institute-hackathons-upgrate-progress.jsp" target="_blank">Update Progress</a>
																	<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#hackathonsdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
																</p></td>
														      </tr>
														      <tr>
														        <td><b>325335</b></td>
														        <td><p class="table-idea">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p></td>
														        <td><p class="table-data">23/06/2017</p></td>
														        <td><p class="table-data">Pending</p></td>
														        <td><p class=" fload_right table-data-button">
																	<a class="btn btn-xs btn-info active" href="institute-hackathons-view-all-details.jsp" target="_blank">Respond</a>
																	<a class="btn btn-xs btn-warning active" href="institute-hackathons-upgrate-progress.jsp" target="_blank">Update Progress</a>
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
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>ADD INFORMATION
								                </a>
								                <a data-toggle="tab" href="#department" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-university fa-profile-size"></i><br/>DEPARTMENT
								                </a>
								                <a data-toggle="tab" href="#techmology" class="list-group-item tab-font-verti-grorgia">
								                     <i class="fa fa-user-circle-o fa-profile-size"></i><br/>DEPARTMENT <small>MILESTONES/ ACHIEMENTS/ SUCCESS STORIES</small>
								                </a>
							              </div><br>
							         </div>
							         <div class="col-sm-9 profile-all-details">
								     	   <div class="tab-content">
								     	         <div id="basic-profile" class="tab-pane fade in active">
								     	             <div class="panel panel-default card">
											      		<div class="panel-body">
										     	            <div class="list-group font">
															    <form class="form-horizontal">
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name of Institute:</p>
																      <div class="col-sm-8">
																        <p class="font-color">MIT College</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name of Principal:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Dattaprasad D. Ingle</p>
																      </div>
																    </div>
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
																      <p class="control-label col-sm-3">No. of Department:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">5</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">No. of Total Faculty Member:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">4</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Registered As:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">SIG</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Institute Official Mobile No:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">8793340769</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Institute Official Email Id:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">dattaprasad.ingle@rlard.com</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Institute Address:</p>
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
																        <a data-toggle="collapse" href="#personals"><b>Add Principal Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="personals" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="myForm">
																		      <div class="form-group">
																			    <label for="inputsm">Add New Principal Name</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="address" >
																			  </div>
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
																        <label class="control-label col-sm-8">Principal Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">New Principle Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Dattaprasad Dashrath Ingle</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">New Mobile No:</p>
																      <div class="col-sm-8">
																        <p class="font-color">8793340769</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">New Email Id:</p>
																      <div class="col-sm-8">
																        <p class="font-color">dattaprasad.ingle@rlard.com</p>
																      </div>
																    </div>
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
											    <div id="department" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#educations"><b>Add Department Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="educations" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="deptForm">
																			  <div class="form-group">
																			    <label for="inputsm">Department Name:</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="dname" ng-model="dname" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">HoD Name:</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="hodname" ng-model="hodname" ng-pattern="/^[a-zA-Z ]{1,25}$/" required/>
																			     <span style="color:red" ng-show="deptForm.hodname.$dirty && deptForm.hodname.$invalid">
																			     <span ng-show="deptForm.hodname.$error.required">Please specify your First Name</span></span>
																			     <span style="color:red" ng-show="deptForm.hodname.$error.pattern">Numeric and special Characters are Not Allowed</span>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Mobile Number:</label>
																			      <input class="form-control" id="focusedInput" type="text" value="" ng-model="mobilenumber" name="mobilenumber" ng-pattern="/^(\+\91{1,2}[- ])\d{10}$/" required/><small>Format :+91 9855514371</small><br>
																			      <span style="color:red" ng-show="deptForm.mobilenumber.$dirty && deptForm.mobilenumber.$invalid">
																			      <span ng-show="deptForm.mobilenumber.$error.required">Please specify your Mobile Number</span></span>
																			      <span ng-show="deptForm.mobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
														  
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Email id:</label>
																			     <input class="form-control" id="focusedInput" type="text" value="" name="email" ng-model="email" ng-pattern="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i" required/>
																				  <span style="color:red" ng-show="deptForm.email.$dirty && deptForm.email.$invalid">
																			      <span ng-show="deptForm.email.$error.required">Please specify your Email ID</span></span>
																				  <span ng-show="deptForm.email.$error.pattern" style="color:red">Please enter correct email address.</span>
														
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm" >No. of Student</label><br>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="nostudent" ng-model="nostudent" ng-pattern="/^[0-9]{1,6}$/" required/>
																			 	  <span style="color:red" ng-show="deptForm.nostudent.$dirty && deptForm.nostudent.$invalid">
																			      <span ng-show="deptForm.nostudent.$error.required">Please specify No. of Student</span></span>
																				  <span ng-show="deptForm.nostudent.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed.</span>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Description</label>
																			    <textarea rows="" cols="" class="form-control" name="description" ng-model="description" required></textarea>
																			  </div>
																			  <div class="form-group">
																			    	<button type="submit" class="btn btn-info btn-md active fload_right" 
																			    	        ng-disabled="deptForm.hodname.$dirty && deptForm.hodname.$invalid && deptForm.hodname.$error.pattern || 
																			    	        			 deptForm.mobilenumber.$dirty && deptForm.mobilenumber.$invalid && deptForm.mobilenumber.$error.pattern ||
																			    	        			 deptForm.email.$dirty && deptForm.email.$invalid && deptForm.email.$error.pattern ||
																			    	        			 deptForm.nostudent.$dirty && deptForm.nostudent.$invalid && deptForm.nostudent.$error.pattern "
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
																        <label class="control-label col-sm-6">Department Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Department Name:</p>
																      <div class="col-sm-8">
																        <p class="font-color">MCA (Management)</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name of Department HoD:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Dattapraasd Ingle</p>
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
																        <p class="font-color">dattaprasad.ingle@rlard.com</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">No .of Student:</p>
																      <div class="col-sm-8">
																        <p class="control-label">45</p>
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
											    <div id="techmology" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			<div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#myskill"><b>Add Department Milestones/ Achievements/ Success Stories</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="myskill" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="milestoForm">
																			  <div class="form-group">
																			    <label for="inputsm">Date: (Format : MM/DD/YYYY)</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="dates" ng-model="dates" ng-pattern="/^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/" required/>
																			      <span style="color:red" ng-show="milestoForm.dates.$dirty && milestoForm.dates.$invalid">
																			      <span ng-show="milestoForm.dates.$error.required">Please specify Date</span></span>
																				  <span ng-show="milestoForm.dates.$error.pattern" style="color:red"> Incorrect Format, should be MM/DD/YYYY.</span>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Milestone Name :</label>
																			    <input class="form-control input-sm" id="inputsm" type="text" name="milename" ng-model="milename" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Milestone Type:</label>
																			    <select class="form-control" name="milestone" ng-model="milestone" required/>
																			    	<option value="" ng-show="false">Select</option>
																			    	<option value="Faculty Achievement">Faculty Achievement</option>
																			    	<option value="Faculty Achievement">Student Achievement</option>
																			    </select>
																			  </div>
																			  <div class="form-group">
																			    <label for="inputsm">Brief Description:</label>
																			   <textarea rows="" cols="" class="form-control" name="description" ng-model="description" required/></textarea>
																			  </div>
																			  <div class="fload_right">
																			  		<button type="submit" class="btn btn-info btn-md active"
																			  		   ng-disabled="milestoForm.dates.$error.pattern"
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
																        <label class="control-label col-sm-7">Department Milestones/ Achievements/ Success Stories</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
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
