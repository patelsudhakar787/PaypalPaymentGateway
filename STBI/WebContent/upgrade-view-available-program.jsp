<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myEvent" ng-controller="eventCtrl">
	<head>
	    <title>Event</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/event.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
	    <div ng-include="'upgrade-navbar.jsp'"></div>
		<!-- --------------------------------------------------------------------------------------------------------->
		<div >
			<div class="container top">
			     <div class="row">
			          <div class="col-sm-2">
					 </div>
					 <div class="col-sm-8">
					    <div class="well well-lg content card">
					        <div class="all-padding">
								<form>
					      			<div>
						      			<label>Name of Course</label>
						      			<p>Fun with Electronic</p>
					      			</div><hr>
					      			<div>
						      			<label>Course Description</label>
						      			<p>We think the best way to spark a child's creativity and curiosity in electronics is to get them to solder and build a small circuit. This one day workshop is aims to be a starting point for parents who wish to expose their children to the world on electronics engineering. It lets parents to quickly check if their child has inclination and aptitude towards manipulating technology.
											If the child enjoys the workshop, we can help parent's decide the kind of courses that can further nurture their child's interest/talent in the field of electronics.</p>
					      			</div><hr>
					      			<div>
						      			<label>Course Level</label>
						      			<p>Beginner</p>
					      			</div><hr>
				      				<div>
				      					<label>Course Prerequisite</label>
				      					<p>We think the best way to spark a child's creativity and curiosity in electronics is to get them to solder and build a small circuit.</p>
				      				</div><hr>
				      				<div>
				      					<label>Course Duration</label>
				      					<p>We think the best way to spark a child's creativity and curiosity in electronics is to get them to solder and build a small circuit.</p>
				      				</div><hr>
				      				<div>
				      					<label>Course Credit</label>
				      					<p>5</p>
				      				</div><hr>
				      				<div>
				      					<label>Course Objective</label>
				      					<p>We think the best way to spark a child's creativity and curiosity in electronics is to get them to solder and build a small circuit.</p>
				      				</div><hr>
				      				<div>
				      					<label>Course Outcome</label>
				      					<p>We think the best way to spark a child's creativity and curiosity in electronics is to get them to solder and build a small circuit.</p>
				      				</div><hr>
				      				<div>
				      					<label>Course Modules</label>
				      					<p>We think the best way to spark a child's creativity and curiosity in electronics is to get them to solder and build a small circuit.</p>
				      				</div><hr>
				      				<div>
				      					<label>Course Lab Work / Equipments / Tools</label>
				      					<p>We think the best way to spark a child's creativity and curiosity in electronics is to get them to solder and build a small circuit.</p>
				      				</div><hr>
				      				<div>
				      					<label>Reference Book / Link</label>
				      					<p>www.samruddhitbi.com</p>
				      				</div>
					      		</form>
					      	</div>
							<hr class="colorgraph">
								<div class="center">
									<button type="button" class="btn btn-info btn-md active " data-toggle="modal" data-target="#viewDetails">Apply</button>
								</div>
								<div id="viewDetails" class="modal fade" role="dialog">
								  <div class="modal-dialog modal-md">
								    <!-- Modal content-->
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal">&times;</button>
								        <h4 class="modal-title">Your Basic Information</h4>
								      </div>
								      <div class="modal-body">
								        <form class="form-horizontal">
										    <div class="form-group">
										      <p class="control-label col-sm-4">Full Name:</p>
										      <div class="col-sm-8">
										        <p class="font-color">Dattaprasad Dashrath Ingle</p>
										      </div>
										    </div>
										    <div class="form-group">
										      <p class="control-label col-sm-4">Email Id:</p>
										      <div class="col-sm-8">
										        <p class="font-color">dattaprasad.ingle@rlard.com</p>
										      </div>
										    </div>
										    <div class="form-group">
										      <p class="control-label col-sm-4">Mobile No:</p>
										      <div class="col-sm-8">
										        <p class="font-color">8793340769</p>
										      </div>
										    </div>
										    <div class="form-group">
										      <p class="control-label col-sm-4">Date of Birth:</p>
										      <div class="col-sm-8"> 
										        <p class="font-color">15/03/1993</p>
										      </div>
										    </div>
										       <div class="form-group">
										      <p class="control-label col-sm-4">Age:</p>
										      <div class="col-sm-8"> 
										        <p class="font-color">24</p>
										      </div>
										    </div>
										       <div class="form-group">
										      <p class="control-label col-sm-4">Gender:</p>
										      <div class="col-sm-8"> 
										        <p class="font-color">Male</p>
										      </div>
										    </div>
										    <div class="form-group">
										      <p class="control-label col-sm-4">Address:</p>
										      <div class="col-sm-8"> 
										        <p class="font-color">A 201 Mitrangan,Next to Kapil Malhar,Baner Road, Pune, Maharashtra, India - 411045</p>
										      </div>
										    </div>
										     
										  </form>
								      </div>
								      <div class="modal-footer">
								      	<button type="button" class="btn btn-info active">Apply</button>
								        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								      </div>
								    </div>
								  </div>
								</div>
						</div>
					 </div>
					 <div class="col-sm-2">
					 </div>
				 </div>
			</div>
		</div>
	</body>
	<script>
		angular.module("myEvent",[])
	</script>
</html>