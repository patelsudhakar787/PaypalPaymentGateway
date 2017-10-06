<%@page import="com.dao.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="mentorDashboard" ng-controller="mentorctrldashboard">
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
	    <script src="js/mentor-dashboard.js"></script>
    </head>
	<body>
	<%
	
	 session=request.getSession();
    long mentorid=(Long)session.getAttribute("mentorid");
    long ideaid=Long.parseLong(request.getParameter("ideaid"));
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    con=Dao.getConnection();
    String query="select * from ideasubmit where ideaid=?";
     pst=con.prepareStatement(query);
     pst.setLong(1,ideaid);
     rs=pst.executeQuery();
     long dbideaid=0,dbuserid=0;
     String dbtitle="",dbenterkeywords="",dbkeyusers="",dbmaxusers="",dbtargetmarket="",dbideadesc="",dbidearegidate="",dbstatusofidea="";
     while(rs.next())
         {
     	dbideaid=rs.getLong("ideaid");
     	dbtitle=rs.getString("titlename");
     	dbenterkeywords=rs.getString("enterkeywords");
     	dbkeyusers=rs.getString("keyusers");
     	dbmaxusers=rs.getString("maxuser");
     	dbtargetmarket=rs.getString("targetmarket");
     	dbideadesc=rs.getString("ideadescription");
     	dbidearegidate=rs.getString("idearegidate");
     	dbstatusofidea=rs.getString("statusofidea");
     	}
    
	
	
	
	
	
	
	
	
	
	
	
	%>
		<div ng-include="'mentor-navbar.jsp'"></div>
		<div class="containers">
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
										<p class="font-containt"><%=dbtitle %></p>
									</div>
									<div class="user-idea-details">
										<label>Enter TEN key words that are closely related to your idea</label>
										<p class="font-containt"><%=dbenterkeywords %></p>
									</div>
									<div class="user-idea-details">
										<label>Who are KEY users of your Product / Solution</label>
										<p class="font-containt"><%=dbkeyusers %></p>
									</div>
									<div class="user-idea-details">
										<label>Maximum number of KEY users of solution/ Product in India</label>
										<p class="font-containt"><%=dbmaxusers %></p>
									</div>
									<div class="user-idea-details">
										<label>Target Market (Maximum possible value for Sale)</label>
										<p class="font-containt"><%=dbtargetmarket %></p>
									</div>
									<div class="user-idea-details">
										<label>Idea Description</label>
										<p class="font-containt"><%=dbideadesc %></p>
									</div>
									<div class="user-idea-details">
										<label>Date(MM/dd/YYYY)</label>
										<p class="font-containt"><%=dbidearegidate %></p>
									</div>
									<div class="user-idea-details">
										<label>Status</label>
										<p class="font-containt"><%=dbstatusofidea %></p>
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
