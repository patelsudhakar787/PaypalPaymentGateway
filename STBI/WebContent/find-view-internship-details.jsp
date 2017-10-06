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
	    <script src="js/city-navbar.js"></script>
	    <script src="js/find-dashboard.js"></script>
    </head>
	<body>
		<div ng-include="'find-navbar.jsp'"></div>
		<div class="containers" >
			<div class="top">
			   <div class="panel panel-default card ">
					<div class="panel-body">
						<div class="panel panel-default panels">
							<div class="panel-body">
								<div class="idealabels">
									<label >INTERNSHIP DETAILS</label>
								</div>
								<div>
									<div class="user-idea-details">
										<label>Title of Internship</label>
										<p class="font-containt">Marketing</p>
									</div>
									<div class="user-idea-details">
										<label>Industry Name</label>
										<p class="font-containt">RLARD</p>
									</div>
									<div class="row">
									     <div class="col-sm-4">
											<div class="user-idea-details">
												<label>Internship location</label>
												<p class="font-containt">Pune, Maharashtra</p>
											</div>
										 </div>
										  <div class="col-sm-4">
								 			<div class="user-idea-details">
												<label>Select type of internship</label>
												<p class="font-containt">Full Time</p>
											</div>
										</div>
										 <div class="col-sm-4">
											<div class="user-idea-details">
												<label>Stipend</label>
												<p class="font-containt">15000 /Month </p>
											</div>
								   		</div>
										
									</div>
									<div class="row">
										 <div class="col-sm-4">
											<div class="user-idea-details">
												<label>Posted on</label>
												<p class="font-containt">Jul 4, 2017</p>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="user-idea-details">
												<label>Internship duration</label>
												<p class="font-containt">10</p>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="user-idea-details">
												<label>Number of openings </label>
												<p class="font-containt">10</p>
											</div>
										</div>
									</div>
									<div class="user-idea-details">
										<label>Qualification</label>
										<p class="font-containt">MCA,BCA</p>
									</div>
									<div class="user-idea-details">
										<label>Skills that you are looking for</label>
										<p class="font-containt">Java, Bootstrap</p>
									</div>
									<div class="user-idea-details">
										<label>Internship Description</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>About Company</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
								</div>
								<hr>
								<div class="fload_right">
								    <button class="btn btn-info active">Apply</button>
								    <button class="btn btn-warning active">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
