<!DOCTYPE html>
<html lang="en" ng-app="myLogin" ng-controller="loginCtrl">
 <head>
	  <title>Login Page</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <link rel="stylesheet" href="css/login.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
      <script data-require="ui-bootstrap@*" data-semver="0.10.0" src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/places.js@1.4.15"></script>
	  <script src="js/begin-login.js"></script>
	  <script src="js/city-navbar.js"></script>
  </head>
  <!------------------------------------------Body------------------------------------------------------>
  <body class="has-bg-img">
   <!--   <center>
          <img src="logo/STBILOGO.jpg">
     </center> -->
     <div >
            <div class="containers">  
			   <ul class="nav nav-tabs container-opportunity">
			   <li class="active">
						<a href="#login" data-toggle="tab" class="font ">Login</a>
					</li>
					<li >
						<a href="#registration" data-toggle="tab" class="font">New Registration</a>
					</li>
			  </ul>
		  	<div class="tab-content">
			    <div id="login" class="tab-pane fade in active">
			        <div class="panel panel-default panel-top-border card">
			        	<div class="panel-body">
						        <div class="center">
							   		 <div class="panel  panel-border ">
							   		   <div class="panel-body">
									        <form> 
										          <div class="centers">
										          		<img src="logo/avtar.png" class="avtar">
										          </div><hr>
												  <div class="input-group">
												    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
												    <input id="email" type="text" class="form-control input-lg" name="email" ng-model="email" placeholder="Email ID" required>
												  </div><br>
												  <div class="input-group">
												    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
												    <input id="password" type="password" class="form-control input-lg" name="password" ng-model="password" placeholder="Password" required>
												  </div><br>
												   <div class="fload_right">
												    	<button type="submit" class="btn btn-info active">Login</button>
												    	<button type="button" class="btn btn-warning   active">Reset</button>
												    	<a href="find-dashboard.jsp" target="_blank" class="btn btn-warning active">Next</a>
												  </div><br><hr>
												  <div class="fload_right">
												    	<a href="" target="_blank" >Forget Password</a>
												  </div>
											</form> 
									    </div>
							        </div>
							    </div>
			        	</div>
			        </div>
			    </div> 
			    <div id="registration" class="tab-pane fade ">
			          <div class="panel panel-default panel-top-border card">
			        	   <div class="panel-body">
						        <div class="registration-center ">
							    	 <div class="panel   panel-border">
								   		   <div class="panel-body">
								   		   		 <form class="form-horizontal" name="myForm">
													  <div class="form-group ">
														    <label class="col-sm-3 control-label">First Name</label>
														    <div class="col-sm-8  has-feedback">
														      <input class="form-control" id="focusedInput" type="text" value="" ng-model="fname"  name="fname" ng-pattern="stringonly" required>
														      <span class="glyphicon glyphicon-user form-control-feedback"></span>
														      <span style="color:red" ng-show="myForm.fname.$dirty && myForm.fname.$invalid">
														      <span ng-show="myForm.fname.$error.required">Please specify your First Name</span></span>
														      <span style="color:red" ng-show="myForm.fname.$error.pattern">Numeric and special Characters are Not Allowed</span>
														    </div>
													  </div>
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Middle Name</label>
														    <div class="col-sm-8  has-feedback">
														      <input class="form-control" id="focusedInput" type="text" value="" ng-model="Middlename"  name="Middlename"  ng-pattern="stringonly" required/>
														   	  <span class="glyphicon glyphicon-user form-control-feedback"></span>
														   	  <span style="color:red" ng-show="myForm.Middlename.$dirty && myForm.Middlename.$invalid">
														      <span ng-show="myForm.Middlename.$error.required">Please specify your Middle Name</span></span>
														      <span style="color:red" ng-show="myForm.Middlename.$error.pattern">Numeric and special Characters are Not Allowed</span>
														    </div>
													  </div>
													   <div class="form-group  has-feedback">
														    <label class="col-sm-3 control-label">Last Name</label>
														    <div class="col-sm-8">
														      <input class="form-control" id="focusedInput" type="text" value="" ng-model="lastname"  name="lastname" ng-pattern="stringonly" required/>
														   	  <span class="glyphicon glyphicon-user form-control-feedback"></span>
														   	  <span style="color:red" ng-show="myForm.lastname.$dirty && myForm.lastname.$invalid">
														      <span ng-show="myForm.lastname.$error.required">Please specify your Last Name</span></span>
														      <span style="color:red" ng-show="myForm.lastname.$error.pattern">Numeric and special Characters are Not Allowed</span>
														    </div>
													  </div>
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Date of Birth <br><small>(MM-DD-YYYY)</small></label>
														    <div class="col-sm-8  has-feedback">
														         <input   type="text" datepicker-popup="MM/dd/yyyy"  ng-model="someDate"  name="someDate"  class="form-control"  ng-pattern="^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$" required />
														         <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
														         <span style="color:red" ng-show="myForm.someDate.$dirty && myForm.someDate.$invalid">
	 												     		 <span ng-show="myForm.someDate.$error.required">Please specify your Last Name</span></span>
													     	 	 <span style="color:red" ng-show="myForm.someDate.$error.pattern">Invalid Format</span>
														    </div>
													  </div>
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Gender</label>
														    <div class="col-sm-8">
														      <select  class="form-control" ng-model="gender" name="gender"  required/>
															      <option value=""ng-show="false"><span class="">Select Gender</option>
															      <option value="Male">Male</option>
															      <option value="Female">Female</option>
															</select>
														    </div>
													  </div><hr>
													  <!-- ------------------------------------ -->
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Mobile Number</label>
														    <div class="col-sm-8 has-feedback">
														      <input class="form-control" id="focusedInput" type="text" value="" ng-model="mobilenumber" name="mobilenumber" ng-pattern="mobiles" required/><small>Format :+91 9855514371</small><br>
														      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
														      <span style="color:red" ng-show="myForm.mobilenumber.$dirty && myForm.mobilenumber.$invalid">
														      <span ng-show="myForm.mobilenumber.$error.required">Please specify your Mobile Number</span></span>
														      <span ng-show="myForm.mobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
														    </div>
													  </div>
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Email Id</label>
														    <div class="col-sm-8 has-feedback">
														      <input class="form-control" id="focusedInput" type="text" value="" name="email" ng-model="email" ng-pattern="emailid" required/>
															  <span class="glyphicon  glyphicon-envelope form-control-feedback"></span>
															  <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
														      <span ng-show="myForm.email.$error.required">Please specify your Email ID</span></span>
															  <span ng-show="myForm.email.$error.pattern" style="color:red">Please enter correct email address.</span>
														    </div>
													  </div>
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Adhar/UI No.</label>
														    <div class="col-sm-8 has-feedback">
														      <input class="form-control" id="focusedInput" type="text" value="" ng-model="adharnumber" name="adharnumber" ng-pattern="adhar" required/><small>Max 12 Digit</small><br>
														 	  <span class="glyphicon  glyphicon-globe form-control-feedback"></span>
														 	  <span style="color:red" ng-show="myForm.adharnumber.$dirty && myForm.adharnumber.$invalid">
														      <span ng-show="myForm.adharnumber.$error.required">Please specify your Adhar No. & UI Id</span></span>
														 	  <span ng-show="myForm.adharnumber.$error.pattern" style="color:red">Adhar No. should be 12 digit <br> Alphabet and special Characters are Not Allowed </span>
														    </div>
													  </div><hr>
													  
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Temporary Address</label>
														    <div class="col-sm-8 has-feedback">
														      <textarea rows="2" cols="" class="form-control" name="taddress" ng-model="taddress" required/></textarea>
														       <span class="glyphicon glyphicon-home form-control-feedback"></span>
														      <p class="text-right">{{ taddress.length }}</p>
														    </div>
													  </div>
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Permanent Address</label>
														    <div class="col-sm-8 has-feedback">
														       <textarea rows="2" cols="" class="form-control" name="address" ng-model="address" required/></textarea>
														        <span class="glyphicon glyphicon-home form-control-feedback"></span>
														       <p class="text-right">{{ address.length }}</p>
														    </div>
													  </div>
													  <div class="form-group">
														    <label class="col-sm-3 control-label">City</label>
														    <div class="col-sm-8">
														      <input type="search" id="address-input" class="form-control" name="city" ng-model="city" required/>
														    </div>
													  </div>
													   <div class="form-group">
														    <label class="col-sm-3 control-label">Pincode</label>
														    <div class="col-sm-8 has-feedback">
														       <input class="form-control" id="focusedInput" type="text"name="pincode" ng-model="pincode" ng-trim="false" ng-pattern="pincodes" required/><small>Max 6 Digit</small><br>
														       <span style="color:red" ng-show="myForm.pincode.$dirty && myForm.pincode.$invalid">
														       <span ng-show="myForm.pincode.$error.required">Please specify Pincode</span></span>
														       <span ng-show="myForm.pincode.$error.pattern" style="color:red">Pincode Should be 6 Digit <br> Alphabet and special Characters are Not Allowed.</span>
														    </div>
													  </div><hr>
													   <div class="label-statement">
													   		<center>I hereby declare that all the statements made by me in the application form and information sheet are true and complete to the best of my knowledge.</center>
													  </div>
													  <div  class="radio-button">
														  <label class="radio-inline">
													       		<input   type="radio" name="check" ng-model="yesno"  value="yes"  checked="checked" />Yes
													      </label>
													      <label for="test1" class="radio-inline">
													      	    <input   type="radio" name="check" ng-model="yesno" value="no" /> No
													      </label>
												      </div><br>
												      <div ng-switch="yesno">
												      		<div ng-switch-when="no">
												      			 <div class="save-button">
														 		 </div>
												      		</div>
												      		<div ng-switch-when="yes">
												      			 <div class="save-button">
																    <button type="submit" class="btn btn-info btn-md active" 
																    	 	   ng-disabled="myForm.fname.$dirty && myForm.fname.$invalid &&  myForm.fname.$error.pattern 
																    		             || myForm.Middlename.$dirty && myForm.Middlename.$invalid && myForm.Middlename.$error.pattern
																    		             || myForm.lastname.$dirty && myForm.lastname.$invalid && myForm.lastname.$error.pattern
																    		             || myForm.someDate.$dirty && myForm.someDate.$invalid && myForm.someDate.$error.pattern
																    		             || myForm.mobilenumber.$dirty && myForm.mobilenumber.$invalid && myForm.mobilenumber.$error.pattern
																    		             || myForm.email.$dirty && myForm.email.$invalid && myForm.email.$error.pattern
																    		             || myForm.adharnumber.$dirty && myForm.adharnumber.$invalid && myForm.adharnumber.$error.pattern
																    		             || myForm.pincode.$dirty && myForm.pincode.$invalid && myForm.pincode.$error.pattern">Submit</button>
																    		             
																    <button type="reset" class="btn btn-warning btn-md active ">Reset</button><br>
														 		 </div>
														 		 <center>
														 		 	<span style="color:red" ng-show=" myForm.fname.$error.pattern ">First Name : Numeric and special Characters are Not Allowed</span>
														 		 </center>
														 				 
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
  </body>
</html>
