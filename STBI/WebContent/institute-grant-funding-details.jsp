<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="sigDashboard" ng-controller="sigctrldashboard">
	 <head>
	    <title>Grants and Funding</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/begin-view-all-details.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/sig-dashboard.js"></script>
    </head>
	<body>
		<div ng-include="'institute-navbar.jsp'"></div>
		<div class="containers" >
			<div class="top">
			   <div class="panel panel-default card ">
					<div class="panel-body">
						<div class="panel panel-default panels">
							<div class="panel-body">
								<div class="idealabels">
									<label >GRANTS AND FUNDING DETAILS</label>
								</div>
								<div>
									<div class="user-idea-details">
										<label>Grant Name</label>
										<p class="idea-data-width">XYZ</p>
									</div>
									<div class="user-idea-details">
										<label>Funding</label>
										<p class="idea-data-width">1,00,000 Rs</p>
									</div>
									<div class="user-idea-details">
										<label>Eligibility :</label>
										<p class="idea-data-width">MCA, BCA , XYZ.</p>
									</div>
									<div class="user-idea-details">
										<label>Description :</label>
										<p class="idea-data-width">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
								</div>
								<hr>
								<div class="fload_right">
								    <button class="btn btn-warning active">Accept</button>
									<a class="btn btn-info btn-md active ">Cancel</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
