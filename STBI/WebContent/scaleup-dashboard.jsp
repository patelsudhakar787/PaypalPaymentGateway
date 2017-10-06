<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="scaleupDashboard" ng-controller="scaleupctrldashboard">
    <head>
	    <title>Dashboard</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/scaleupdashboard.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/scaleup-dashboard.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
	    <div ng-include="'scaleup-navbar.jsp'"></div>
		<div class="containers">
			<div class="top">
				<ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#opportinity" class="tab-font-grorgia">MY UPGRADE OPPORTUNITY</a></li>
				    <li><a data-toggle="tab" href="#government" class="tab-font-grorgia">MY GOVERNMENT SUPPORT</a></li>
				    <li><a data-toggle="tab" href="#myprofile" class="tab-font-grorgia">MY BUSINESS PROFILE</a></li>
				</ul>
				<div class="tab-content">
					  <!---------------------------------------------------------MY OPPORTUNITY-------------------------------------------->
					  <div id="opportinity" class="tab-pane fade in active">
				       <div class="panel panel-default card panels">
					      <div class="panel-body">
								<div class="tabbable-line">
									<ul class="nav nav-tabs container-opportunity ">
										<li class="active">
											<a href="#intern" data-toggle="tab" class="tab-sub-font-grorgia">INTERNSHIP/PROJECT OFFER</a>
										</li>
										<li>
											<a href="#technology" data-toggle="tab" class="tab-sub-font-grorgia">CONSULTANCY OFFER</a>
										</li>
										<li>
											<a href="#mychallenge" data-toggle="tab" class="tab-sub-font-grorgia">MY CHALLENGES (HACKATHONS)</a>
										</li>
									</ul><hr>
									<div class="tab-content">
										<div class="tab-pane active" id="intern">
										   <div>
								    	   		<button  type="button" class="btn btn-info btn-md active" data-toggle="modal" data-target="#submit_new_intern">Submit Internship Offer</button>
								    	   		 <!-- Modal -->
												  <div class="modal fade" id="submit_new_intern" role="dialog">
												    <div class="modal-dialog modal-lg">
												      <!-- Modal content-->
												      <div class="modal-content">
												        <div class="modal-header">
												          <button type="button" class="close" data-dismiss="modal">&times;</button>
												          <h4 class="modal-title">Submit Information of Internship </h4>
												        </div>
												        <form name="scaleupForm">
														        <div class="modal-body">
																	  <div class="form-group">
																	    <label for="inputsm">Title of Internship</label>
																	    <select class="form-control" name="about" ng-model="about" required/>
																    	    <option ng-show="false">Select Primary Profile</option>
																    		<option>Business Development (Sales) </option>
																    		<option>Web Development </option>
																    		<option>Graphic Design  </option>
																    		<option>Content Writing  </option>
																    		<option> Marketing  </option>
																    		<option>Operations  </option>
																    		<option>Mobile App Development </option>
																    		<option>Digital Marketing  </option>
																    		<option> Human Resources (HR) </option>
																    		<option>Law/ Legal  </option>
																    		<option>Campus Ambassador </option>
																    		<option value="other">Other</option>
																    	</select>
																	  </div>
																	  <div ng-switch="about">
																	  		<div ng-switch-when="other">
																			    <input class="form-control input-md"  type="text">
																	  		</div>
																	   </div>
																	  <div class="row">
																	       <div class="col-sm-4">
																			   <div class="form-group">
																			    <label for="inputdefault">Internship location</label>
																			    <input class="form-control input-md"  type="text" name="location" ng-model="location" required/>
																			  </div>
																		   </div>
																		    <div class="col-sm-4">
																			  <div class="form-group">
																			    <label for="inputlg">Select type of Internship</label>
																			    	<select class="form-control" name="typeinter" ng-model="typeinter" required/>
																			    	    <option ng-show="false">Select</option>
																			    		<option>Full Time</option>
																			    		<option>Part Time</option>
																			    	</select>
																			  </div>
																		   </div>
																		   <div class="col-sm-4">
																			  <div class="form-group">
																			    <label for="inputlg">Stipend (In Rs.)</label>
																			    <input class="form-control input-md"  type="text" name="stipend" ng-model="stipend" ng-pattern="/^[0-9]{1,6}$/" required/>
																			 	<span ng-show="scaleupForm.stipend.$error.pattern" style="color:red">Enter only number.</span>
																			  </div>
																		   </div>
																      </div>
																       <div class="form-group">
																          <label>Internship Duration <small>(Shorter the duration, more the applications)</small></label>
																          <div class="row">
																               <div class="col-sm-8">
																			   		 <select class="form-control" name="interduration" ng-model="interduration" required/>
																			    	    <option ng-show="false">Choose Duration</option>
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
																			    	    <option ng-show="false">Select Months/Weeks</option>
																			    		<option>Months</option>
																			    		<option>Weeks</option>
																			    	</select>
																			   </div>
																	      </div>
																	   </div>
																	   <div class="form-group">
																	    <label for="inputlg">Number of Opening <br><small>(Enter only numbers)</small></label>
																	    <input class="form-control input-md"  type="text" name="opening" ng-model="opening" ng-pattern="/^[0-9]{1,6}$/" required/>
																	    <span ng-show="scaleupForm.opening.$error.pattern" style="color:red">Enter only number.</span>
																	  </div>
																	  <div class="form-group">
																	    <label for="inputlg">Qualification</label>
																	    <input class="form-control input-md"  type="text" name="qualifiacation" ng-model="qualification" required/>
																	  </div>
																	   <div class="form-group">
																	     <label for="inputlg">Skills that you are Looking for: <br><small>(Type one or more skills) (Recommended)</small></label>
																	    <input class="form-control input-md"  type="text" name="proskill" ng-model="proskill" required placeholder="Ex: PHP, JAVA, MS Office">
																	  </div>
																	   <div class="form-group">
																	    <label for="inputlg">Internship Description</label>
																	    <textarea class="form-control" name="interndiscrip" ng-model="interndiscrip" required></textarea>
																	  </div>
																	   <div class="form-group">
																	    <label for="inputlg">Status</label> 
																	     <input class="form-control"  type="text" value="Pending" readonly>
																	  </div>
																	  <div class="form-group">
																	    <label for="inputlg">Date(MM DD,YYYY)</label>
																	    <input class="form-control input-md"  type="text"  ng-model="today | date" readonly>
																	  </div>
														        </div>
														        <div class="modal-footer">
														          <button type="submit" class="btn btn-info btn-md active"
														          		  ng-disabled="scaleupForm.opening.$error.pattern || scaleupForm.stipend.$error.pattern"
														          >Upload</button>
														          <button type="button" class="btn btn-warning btn-md active" data-dismiss="modal">Close</button>
														        </div>
												         </form> 
												      </div>
												    </div>
												  </div>
								    	   </div>
								    	    <hr>
											<table class="table table-list table-hover card">
											    <thead>
											      <tr>
											        <th class="table-fent-gray">ID</th>
											        <th class="table-dark-gray">LIST OF INTERNSHIP/PROJECT OFFER</th>
											        <th class="table-fent-gray">DATE </th>
											        <th class="table-dark-gray">STATUS</th>
											        <th class="table-fent-gray"></th>
											      </tr>
											    </thead>
											    <tbody>
											     <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="scaleup-view-intership-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class="table-data">Pending</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">View Update</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">View Response</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#intersdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											      <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="scaleup-view-intership-details.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class="table-data">Pending</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">View Update</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">View Response</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#intersdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											    </tbody>
											 </table><hr>
											 <!-------------------------------Delete----------------------------------->
											   <div class="modal fade" id="intersdelete" role="dialog">
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
										<div class="tab-pane" id="technology">
											<table class="table table-list table-hover card">
											    <thead>
											      <tr>
											        <th class="table-fent-gray">ID</th>
											        <th class="table-dark-gray">TECHNOLOGY CONSULTANCY OFFER</th>
											        <th class="table-fent-gray">DATE </th>
											        <th class="table-dark-gray">STATUS</th>
											        <th class="table-fent-gray"></th>
											      </tr>
											    </thead>
											    <tbody>
											     <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class="table-data">Pending</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#technologydelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											      <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class="table-data">Pending</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#technologydelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											    </tbody>
											 </table><hr>
											 <!-------------------------------Delete----------------------------------->
											   <div class="modal fade" id="technologydelete" role="dialog">
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
										<div class="tab-pane " id="mychallenge">
											<table class="table table-list table-hover card">
											    <thead>
											      <tr>
											        <th class="table-fent-gray">ID</th>
											        <th class="table-dark-gray">HACKATHONS</th>
											        <th class="table-fent-gray">DATE </th>
											        <th class="table-dark-gray">STATUS</th>
											        <th class="table-fent-gray"></th>
											      </tr>
											    </thead>
											    <tbody>
											     <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class="table-data">Pending</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#businessdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											      <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class="table-data">Pending</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#businessdelete"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											    </tbody>
											 </table><hr>
											 <!-------------------------------Delete----------------------------------->
											   <div class="modal fade" id="businessdelete" role="dialog">
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
									</div>
								</div>
					      </div>
					   </div>
					  </div>
					   <!---------------------------------------------------------MY GOVERNEMENT SUPPORT-------------------------------------------->
					  <div id="government" class="tab-pane fade">
				       <div class="panel panel-default card panels">
					      <div class="panel-body">
								<div class="tabbable-line">
									<ul class="nav nav-tabs container-opportunity ">
										<li class="active">
											<a href="#msmescheme" data-toggle="tab" class="tab-sub-font-grorgia">MSME SCHEMES</a>
										</li>
										<li>
											<a href="#dsirscheme" data-toggle="tab" class="tab-sub-font-grorgia">DSIR SCHEMES</a>
										</li>
										<li>
											<a href="#othersceme" data-toggle="tab" class="tab-sub-font-grorgia">OTHER SCHEMES</a>
										</li>
									</ul><hr>
									<div class="tab-content">
										<div class="tab-pane active" id="msmescheme">
											<table class="table table-list table-hover card">
											    <thead>
											      <tr>
											        <th class="table-fent-gray">ID</th>
											        <th class="table-dark-gray">MSME SCHEMES</li></th>
											        <th class="table-fent-gray">DATE </th>
											        <th class="table-fent-gray"></th>
											      </tr>
											    </thead>
											    <tbody>
											     <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">View Update</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">View Response</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#msmeschemes"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											      <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">View Update</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">View Response</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#msmeschemes"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											    </tbody>
											 </table><hr>
											 <!-------------------------------Delete----------------------------------->
											   <div class="modal fade" id="msmeschemes" role="dialog">
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
										<div class="tab-pane" id="dsirscheme">
											<table class="table table-list table-hover card">
											    <thead>
											      <tr>
											        <th class="table-fent-gray">ID</th>
											        <th class="table-dark-gray">DSIR SCHEMES</th>
											        <th class="table-fent-gray">DATE </th>
											        <th class="table-fent-gray"></th>
											      </tr>
											    </thead>
											    <tbody>
											     <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#disrscemes"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											      <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#disrscemes"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											    </tbody>
											 </table><hr>
											 <!-------------------------------Delete----------------------------------->
											   <div class="modal fade" id="disrscemes" role="dialog">
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
										<div class="tab-pane " id="othersceme">
											<table class="table table-list table-hover card">
											    <thead>
											      <tr>
											        <th class="table-fent-gray">ID</th>
											        <th class="table-dark-gray">OTHER SCHEMES</th>
											        <th class="table-fent-gray">DATE </th>
											        <th class="table-fent-gray"></th>
											      </tr>
											    </thead>
											    <tbody>
											     <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#otherscemes"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											      <tr>
											        <td><b>325335</b></td>
											        <td><p class="table-idea"><a href="" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
											        <td><p class="table-data">23/06/2017</p></td>
											        <td><p class=" fload_right table-data-button">
														<a class="btn btn-xs btn-info active" href="" target="_blank">Apply</a>
														<a class="btn btn-xs btn-warning active" href="" target="_blank">Update Progress</a>
														<button type="button" class="btn btn-xs btn-info active"  data-toggle="modal" data-target="#otherscemes"><i class="fa fa-trash" style="font-size:18px"></i></button>
													</p></td>
											      </tr>
											    </tbody>
											 </table><hr>
											 <!-------------------------------Delete----------------------------------->
											   <div class="modal fade" id="otherscemes" role="dialog">
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
									</div>
								</div>
					      </div>
					   </div>
					  </div>
					 <!---------------------------------------------------------MY PROFILE-------------------------------------------->
				    <div id="myprofile" class="tab-pane fade">
				       <div class="panel panel-default card panels">
					      <div class="panel-body">
					    	<div class="row">
					    	   <div class="col-sm-12">
							          <div class="col-sm-3 bhoechie-tab-menu ">
							              <div class="list-group card">
								                <a data-toggle="tab" href="#personal-details" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>COMPANY DETAILS
								                </a>
								                 <a data-toggle="tab" href="#company-product" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>COMPANY PRODUCTS
								                </a>
								                <a data-toggle="tab" href="#design-course" class="list-group-item tab-font-verti-grorgia">
								                  	 <i class="fa fa-user-circle-o fa-profile-size"></i><br/>OFFER SKILL DEVELOPMENT PROGRAM
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
																        <a data-toggle="collapse" href="#personals"><b>Add Company Details</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="personals" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form name="infoForm">
																			  <div class="form-group">
																			    <label for="inputsm">Add New Mobile No:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="mobilenumber" ng-model="mobilenumber" ng-pattern="/^(\+\91{1,2}[- ])\d{10}$/" required/>
																			    <small>Format :+91 9855514371</small><br>
																			     <span style="color:red" ng-show="infoForm.mobilenumber.$dirty && infoForm.mobilenumber.$invalid">
														   					     <span ng-show="infoForm.mobilenumber.$error.required">Please specify your Mobile Number</span></span>
														                         <span ng-show="infoForm.mobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Add New Email Id:</label>
																			      <input class="form-control" id="focusedInput" type="text" value="" name="email" ng-model="email" ng-pattern="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i" required/>
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
															  <div class="list-group font">
															    <form class="form-horizontal">
															        <div class="form-group">
																      <div class="col-sm-11">
																        <label class="control-label col-sm-6">Company Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name of Industry:</p>
																      <div class="col-sm-8">
																        <p class="font-color">RLARD</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name of Owner:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Manish Patil</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Company Office Address:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Baner, Pune</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Email Id</p>
																      <div class="col-sm-8">
																        <p class="font-color">director@rlard.com</p>
																         <p class="font-color">manish.patil@rlard.com</p>
																      </div>
																    </div>
																     <div class="form-group">
																      <p class="control-label col-sm-3">Mobile No:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">0000000000</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Office Ph.no:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">4444444444</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Year of Establish :</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">01/01/2009</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">No. of Department:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">6</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">No. of Employee:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">26</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Annual Turnover:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">26</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Recruitment Strategy:</p>
																      <div class="col-sm-8"> 
																        <p class="font-color">ourcing is critical. If you don’t utilize sources that attract a high percentage of top performers, it is unlikely you will make a quality hire. After employment branding, effective sourcing is the most critical element of the recruiting process. Generally, the most effective source is employee referrals. Other effective but under-used sources include recruiting at professional events and contests. Using ineffective sources means that you must spend inordinate amounts of time and money on candidate screening in order to avoid a weak hire. The source that is used must be shift, depending on the type of candidate required for that position. Unfortunately, many recruiters use the same exact sourcing scheme for every job.</p>
																      </div>
																    </div>
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
											    <div id="company-product" class="tab-pane fade">
											      	<div class="panel panel-default card">
											      		<div class="panel-body">
											      			 <div class="panel-group">
																  <div class="panel panel-default">
																    <div class="panel-heading">
																      <h4 class="panel-title">
																        <a data-toggle="collapse" href="#company-products"><b>Add Company Products</b><i class="fa fa-plus fload_right" style="font-size:20px"></i></a>
																      </h4>
																    </div>
																    <div id="company-products" class="panel-collapse collapse font">
																      <div class="panel-body font">
																		<form>
																			  <div class="form-group">
																			    <label for="inputsm">Add Product Name:</label>
																			    <input class="form-control input-md" id="inputsm" type="text" name="comname" ng-model="comname" required>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Add Product Image:</label>
																			    <input type="file" name="picture" ng-model="picture" required/>
																			  </div>
																			 <div class="form-group">
																			    <label for="inputsm">Add Product Description</label>
																			    <textarea rows="" cols="" class="form-control" name="descriptions" ng-model="descriptions" required></textarea>
																			  </div>
																			  <div class="fload_right">
																			  		<button type="submit" class="btn btn-info btn-md active">Upload</button>
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
																        <label class="control-label col-sm-6">Company Products</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																      </div>
																    </div><hr>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Name of Product:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Tube Light</p>
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Image of Product:</p>
																      <div class="col-sm-8">
																        <img src="http://www.ledteksa.co.za/wp-content/uploads/2014/02/12W-LED-Tube.jpg" width="10%;">
																      </div>
																    </div>
																    <div class="form-group">
																      <p class="control-label col-sm-3">Product Description:</p>
																      <div class="col-sm-8">
																        <p class="font-color">Through aluminum PCB, heat dissipation greatly expands life spanThrough aluminum PCB, heat dissipation greatly expands life span</p>
																      </div>
																    </div>
																  </form>
															  </div><hr>
											      		</div>
											      	</div>
											    </div>
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
																			<form class="courseForm">
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
																	        <label class="control-label col-sm-6">Course Details</label><i class="fa fa-edit fload_right" style="font-size:20px"></i>
																	      </div>
																	    </div><hr>
																	    <div class="form-group">
																	      <p class="control-label col-sm-3">Name of Course:</p>
																	      <div class="col-sm-8">
																	        <p class="font-color">Tub Light</p>
																	      </div>
																	    </div>
																	    <div class="form-group">
																	      <p class="control-label col-sm-3">Description of Course:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">Tub Light</p>
																	      </div>
																	    </div>
																	    <div class="form-group">
																	      <p class="control-label col-sm-3">Select Level:</p>
																	      <div class="col-sm-8">
																	        <select ng-model="myCourse" class="form-control">
																	            <option ng-show="false">Select</option>
																		    	<option  value="Beginner-details">Beginner</option>
																		    	<option  value="Core-details">Core</option>
																		    	<option  value="Advanced-details">Advanced </option>
																		    	<option  value="Expert-details">Expert</option>
																		    </select>
																	      </div>
																	    </div>
																	  <div class="form-group">
																	      <p class="control-label col-sm-3">Course Prerequisite:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">xyz</p>
																	      </div>
																	  </div>
																	  <div class="form-group">
																	      <p class="control-label col-sm-3">Course Duration:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">4 Month</p>
																	      </div>
																	  </div>
																	  <div class="form-group">
																	      <p class="control-label col-sm-3">Course Credit:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">5</p>
																	      </div>
																	  </div>
																	  <div class="form-group">
																	      <p class="control-label col-sm-3">Course Objectives:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">We live in challenging times. To succeed, one needs a good handle on technology and awareness of ones own self. We focus on delivering training in the fields of cutting edge technology and personal leadership. We believe that the world can be a better place when people have the tools and technology to manage self and their communities.</p>
																	      </div>
																	  </div>
																	  <div class="form-group">
																	      <p class="control-label col-sm-3">Course Outcome:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">We live in challenging times. To succeed, one needs a good handle on technology and awareness of ones own self. We focus on delivering training in the fields of cutting edge technology and personal leadership. We believe that the world can be a better place when people have the tools and technology to manage self and their communities.</p>
																	      </div>
																	  </div>
																	  <div class="form-group">
																	      <p class="control-label col-sm-3">Course Modules:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">We live in challenging times.</p>
																	      </div>
																	  </div>
																	  <div class="form-group">
																	      <p class="control-label col-sm-3">Course Lab work / Equipments / Tools:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">ABC</p>
																	      </div>
																	  </div>
																	   <div class="form-group">
																	      <p class="control-label col-sm-3">Reference Book / Link:</p>
																	      <div class="col-sm-8">
																	         <p class="font-color">www.seekhow.in</p>
																	      </div>
																	  </div>
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
		</div>
	</body>
</html>
