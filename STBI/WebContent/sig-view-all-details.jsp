<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="sigDashboard" ng-controller="sigctrldashboard">
	 <head>
	    <title>View All Details</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/begin-view-all-details.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/city-navbar.js"></script>
	    <script src="js/sig-dashboard.js"></script>
    </head>
	<body>
		<div ng-include="'sig-navbar.jsp'"></div>
		<div class="containers" >
			<div class="top">
			   <div class="panel panel-default card ">
					<div class="panel-body">
						<div class="panel panel-default panels">
							<div class="panel-body">
								<div class="idealabels">
									<label >MY IDEA DETAILS</label>
								</div>
								<div class="sentence">
									<p>This idea is under registration of applicable <b class="bold">Intellectual Property (IP) </b>through Samruddhi TBI Foundation.<br> The protection is apply in the name of Inventor / Originator of this idea.</p>
								</div>
								<div>
									<div class="user-idea-details">
										<label>Title of your Idea / Innovation / Product / Solution</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>Enter TEN key words that are closely related to your idea</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>Who are KEY users of your Product / Solution</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>Maximum number of KEY users of solution/ Product in India</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>Target Market (Maximum possible value for Sale)</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>Idea Description</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>Date(MM/dd/YYYY)</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
									<div class="user-idea-details">
										<label>Status</label>
										<p class="font-containt">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</p>
									</div>
								</div>
								<hr>
								<!---------------------------------------------------------------------------------------------------------->
								<div class="idealabels">
									<label >MY PROGRESS / MILESTONE</label>
								</div>
								<div class="user-idea-details">
									<div class="row">
			                			<div class="col-sm-12">
			                				<label class="name-heading">Mobile App</label>
			                				<label class="name-type">Product Release</label>
			                				<br><small class="date">15/07/2017</small>
			                			</div>
			                			<div class="col-sm-12">
			                				<p class="informations font-containt">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			                			</div>
			                		</div>
								</div><hr>
								<!---------------------------------------------------------------------------------------------------------->
								<div class="idealabels">
									<label >MY RATING</label>
								</div>
								 <div class="list-group font font-containt">
								    <form class="form-horizontal">
									    <div class="form-group">
									      <p class="control-label col-sm-5">General:</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									    <div class="form-group">
									      <p class="control-label col-sm-5">Finance Support:</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									    <div class="form-group">
									      <p class="control-label col-sm-5">Infrastructure Support:</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									    <div class="form-group">
									      <p class="control-label col-sm-5">Mentoring Support (Technical):</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									     <div class="form-group">
									      <p class="control-label col-sm-5">Business Plan Support:</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									    <div class="form-group">
									      <p class="control-label col-sm-5">Marketing strategy:</p>
									       <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									     <div class="form-group">
									      <p class="control-label col-sm-5">IT Support (Protection):</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									     <div class="form-group">
									      <p class="control-label col-sm-5">Company Formation Support:</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									     <div class="form-group">
									      <p class="control-label col-sm-5">Techno - Legal Support:</p>
									      <div class="col-sm-7 rating-top">
									        <div ng-init="rating = star.rating + 1"></div>
	    									<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
									      </div>
									    </div>
									  </form>
								  </div>
								<hr>
								<div class="idealabels">
									<label >MY PITCH</label>
								</div>
								<div class="user-idea-details">
									<form class="form-horizontal">
									   <div class="form-group">
									    <label class="col-sm-2 control-label">Focused</label>
									    <div class="col-sm-10">
									      <input class="form-control" id="focusedInput" type="text" value="Click to focus">
									    </div>
									  </div>
									   <div class="form-group">
									    <label class="col-sm-2 control-label">Focused</label>
									    <div class="col-sm-10">
									      <input class="form-control" id="focusedInput" type="text" value="Click to focus">
									    </div>
									  </div>
									   <div class="form-group">
									    <label class="col-sm-2 control-label">Focused</label>
									    <div class="col-sm-10">
									      <input class="form-control" id="focusedInput" type="text" value="Click to focus">
									    </div>
									  </div>
									   <div class="form-group">
									    <label class="col-sm-2 control-label">Focused</label>
									    <div class="col-sm-10">
									      <input class="form-control" id="focusedInput" type="text" value="Click to focus">
									    </div>
									  </div>
									   <div class="form-group">
									    <label class="col-sm-2 control-label">Focused</label>
									    <div class="col-sm-10">
									      <input class="form-control" id="focusedInput" type="text" value="Click to focus">
									    </div>
									  </div>
									   <div class="form-group">
									    <label class="col-sm-2 control-label">Focused</label>
									    <div class="col-sm-10">
									      <input class="form-control" id="focusedInput" type="text" value="Click to focus">
									    </div>
									  </div> <div class="form-group">
									    <label class="col-sm-2 control-label">Focused</label>
									    <div class="col-sm-10">
									      <input class="form-control" id="focusedInput" type="text" value="Click to focus">
									    </div>
									  </div>
									  
									</form> 
								</div>
								<div>
									<a class="btn btn-info btn-md active fload_right">Back</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
