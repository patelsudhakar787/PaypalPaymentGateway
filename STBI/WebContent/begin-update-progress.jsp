<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myDashboard" ng-controller="dashboard">
 <head>
	    <title>Update Progress </title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/update_progress.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/city-navbar.js"></script>
	    <script src="js/dashboard.js"></script>
    </head>
	<body>
	    <div ng-include="'begin-navbar.jsp'"></div>
		<div class="containers top" >
			  <ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#build-my-pitch" class="tab-font-grorgia">Build My Pitch</a></li>
				    <li><a data-toggle="tab" href="#update-progrss" class="tab-font-grorgia">Update Progress</a></li>
			  </ul>
			  <div class="tab-content">
				   <div id="build-my-pitch" class="tab-pane fade in active">
					    <div class="panel panel-default panels card">
					    	<div class="panel-body">
					    		<div class="user-idea-details">
					    		</div>
					    		<div class="user-idea-details">
					    			<textarea rows="6" cols="" class="form-control"></textarea>
					    		</div><br>
					    		<div class="user-idea-details">
									<button type="submit" class="btn btn-info btn-md active fload_right">Submit</button>
					    		</div>
					    	</div>
					    </div>
				  </div>
				  <div id="update-progrss" class="tab-pane">
				     <form>
						    <div class="panel panel-default panels card">
						    	<div class="panel-body">
						    	     <div class="container">
						    	         <div class="panel panel-default card">
						                	<div class="panel-body">
									    	    <div class="row">
									    	        <div class="col-sm-4">
											    		<input type="text" class="form-control" ng-model="today | date">
											    	</div>
											    	<div class="col-sm-4">
												    	<input type="text" class="form-control" placeholder="Milstone Name">
											    	</div>
											    	 <div class="col-sm-4">
										    			<select class="form-control" ng-model="response">
										    			    <option value="" ng-show="false">Milestone Type</option>
										    				<option value="Start Up Mitra">Product Release</option>
										    				<option value="Start Up Mitra">Funding</option>
										    				<option value="Start Up Mitra">Media Coverage</option>
										    				<option value="Start Up Mitra">Business Performance</option>
										    				<option value="Start Up Mitra">Strategy Update</option>
										    				<option value="Start Up Mitra">Angel Help Needed</option>
										    			</select>
											    	</div>
									           </div><br>
									           <div>
									           		<textarea class="form-control"></textarea>
									           </div><br>
									            <div class="fload_right">
									           		<button class="btn btn-info btn-md active">Upload</button>
									            </div>
									       </div>
									   </div>
									   <div class="inner-container">
										   <div class="panel panel-default card">
							                	<div class="panel-body">
							                		<div class="row">
							                			<div class="col-sm-12">
							                				<label class="name-heading font-heading">Mobile App</label>
							                				<label class="name-type">Product Release</label>
							                				<button data-toggle="modal" data-target="#delete" class="fload_right buttons"><i class="fa fa-trash-o " style="font-size:24px"></i></button>
							                				<br><small class="date">15/07/2017</small>
							                			</div>
							                			<div class="col-sm-12">
							                				<p class="informations">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
							                			</div>
							                		</div>
										       </div>
										   </div>
										    <div class="panel panel-default card">
							                	<div class="panel-body">
							                		<div class="row">
							                			<div class="col-sm-12">
							                				<label class="name-heading font-heading">Web Application</label>
							                				<label class="name-type">Funding</label>
							                				 <button data-toggle="modal" data-target="#delete" class="fload_right buttons"><i class="fa fa-trash-o " style="font-size:24px"></i></button>
							                				<br><small class="date">15/07/2017</small>
							                			</div>
							                			<div class="col-sm-12">
							                				<p class="informations">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
							                			</div>
							                		</div>
										       </div>
										   </div>
										   <!----------------------------Deleting---------------------------- -->
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
						  </div>
					  </form>
				 </div>
			</div>
		</div>
	</body>
</html>
