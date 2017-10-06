<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="findDashboard" ng-controller="fintctrldashboard">
	 <head>
	    <title>Project Details</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/begin-view-all-details.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/find-dashboard.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
		<div ng-include="'find-navbar.jsp'"></div>
		<div class="containers" >
			<div class="top">
			   <div class="panel panel-default card ">
					<div class="panel-body">
							       <div class="well" style="background-color: white;">
									  <div class="form-group">
									    <p class="idea-data-width">Marketing</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Number of Vacancies</label>
									    <p class="idea-data-width">10</p>
									  </div>
									   <div class="form-group">
									    <label for="inputsm">Job Description</label>
									    <p class="idea-data-width">Marketing</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Skill Keyword</label>
									    <p class="idea-data-width">Java, Dot Net</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Work Experience</label>
									    <div class="row">
									    	<div class="col-sm-2">
									    		<p class="idea-data-width">1 Year</p>
									    	</div>
									    	<div class="col-sm-1">
									    		<label class="text-align-center">To</label>
									    	</div>
									    	<div class="col-sm-2">
									    		<p class="idea-data-width">2 Year</p>
									    	</div>
									    </div>
									  </div>
									   <div class="form-group">
									    <label for="inputsm">CTC</label>
									    <div class="row">
									    	<div class="col-sm-2">
									    		<p class="idea-data-width">10000 Rs</p>
									    	</div>
									    	<div class="col-sm-1">
									    		<label class="text-align-center">To</label>
									    	</div>
									    	<div class="col-sm-2">
									    		<p class="idea-data-width">15000 Rs</p>
									    	</div>
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Location of Job</label>
									    <p class="idea-data-width">Pune, Maharashtra</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Name of Industry</label>
									    <p class="idea-data-width">RLARD</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Function Area</label>
									    <p class="idea-data-width">Not Mention</p>
									  </div>
								</div>
								<div class="well" style="background-color: white;">
									<p style="text-align: center;">DESIRED CONDIDATE PROFILE</p>
									 <div class="form-group">
									    <label for="inputsm">Qualification</label>
									    <p class="idea-data-width">MCA, BCA</p>
									  </div>
								 </div>
								 <div class="well">
									<p style="text-align: center;">EMPLOYEE AND RECRUITER DETAILS</p>
									 <div class="form-group">
									    <label for="inputsm">Company Name</label>
									    <p class="idea-data-width">RLARD</p>
									  </div>
									   <div class="form-group">
									    <label for="inputsm">About Company</label>
									    <p class="idea-data-width">Marketing</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Company Website</label>
									    <p class="idea-data-width">https://www.rlard.com</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Contact Person</label>
									    <p class="idea-data-width">Mr. Manish </p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Address</label>
									    <p class="idea-data-width">Pune, Maharshtra</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Contact Number</label>
									    <p class="idea-data-width">98989898989</p>
									  </div>
									  <div class="form-group">
									    <label for="inputsm">Posted On</label>
									    <p class="idea-data-width">5 Jul, 2017</p>
									  </div> 
								 </div>
								<div class="fload_right">
								    <button class="btn btn-info active">Apply</button>
								    <button class="btn btn-warning active">Cancel</button>
								</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
