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
					              <div class="form-group ">
								      <div class="col-sm-12  has-feedback">
							              <select class="form-control" name="selectlogin" ng-model="selectlogin" required>
							              		<option value="" ng-show="false">Login as</option>
							              		<option value="SIG">SIG</option>
							              		<option value="Institute">Institute</option>
							              		<option value="Incubation">Incubation</option>
							              </select>
							           </div>
							      </div>
					              <div ng-switch="selectlogin">
					              		<div ng-switch-when="SIG">
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
														    	<button type="submit" class="btn btn-info active">Login as SIG</button>
														    	<button type="button" class="btn btn-warning   active">Reset</button>
														    	<a href="sig-dashboard.jsp" target="_blank" class="btn btn-warning active">Next</a>
														  </div><br><hr>
														  <div class="fload_right">
														    	<a href="" target="_blank" >Forget Password</a>
														  </div>
													</form> 
											    </div>
									        </div>
					              		</div>
					              		<div ng-switch-when="Institute">
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
														    	<button type="submit" class="btn btn-info active">Login as Institute</button>
														    	<button type="button" class="btn btn-warning   active">Reset</button>
														    	<a href="institute-dashboard.jsp" target="_blank" class="btn btn-warning active">Next</a>
														  </div><br><hr>
														  <div class="fload_right">
														    	<a href="" target="_blank" >Forget Password</a>
														  </div>
													</form> 
											    </div>
									        </div>
					              		</div>
					              		<div ng-switch-when="Incubation">
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
														    	<button type="submit" class="btn btn-info active">Login as Incubation</button>
														    	<button type="button" class="btn btn-warning   active">Reset</button>
														    	<a href="incubation-dashboard.jsp" target="_blank" class="btn btn-warning active">Next</a>
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
			        </div>
			    </div> 
			    <div id="registration" class="tab-pane fade ">
			         <div class="panel panel-default panel-top-border card">
			        	 <div class="panel-body">
					    	<div class="tabbable-line">
								<ul class="nav nav-tabs container-opportunity ">
									<li class="active">
										<a href="#sig" data-toggle="tab" class="font-containt">SIG</a>
									</li>
									<li>
										<a href="#institude" data-toggle="tab" class="font-containt">INSTITUTE</a>
									</li>
									<li>
										<a href="#incubation" data-toggle="tab" class="font-containt">INCUBATION</a>
									</li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="sig">
								        <div class="registration-center ">
									    	 <div class="panel   panel-border">
										   		   <div class="panel-body">
										   		   		 <form class="form-horizontal" name="sigForm">
															  <div class="form-group ">
																    <label class="col-sm-3 control-label">SIG Group Name</label>
																    <div class="col-sm-8  has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="signame"  name="signame" ng-pattern="stringonly" required>
																      <span class="glyphicon glyphicon-user form-control-feedback"></span>
																      <span style="color:red" ng-show="sigForm.fname.$dirty && sigForm.fname.$invalid">
																      <span ng-show="sigForm.fname.$error.required">Please specify SIG Group Name</span></span>
																      <span style="color:red" ng-show="sigForm.fname.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Area of Specialization</label>
																    <div class="col-sm-8  has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="special"  name="special"  ng-pattern="stringonly" required/>
																   	  <span class="glyphicon glyphicon-user form-control-feedback"></span>
																   	  <span style="color:red" ng-show="sigForm.Middlename.$dirty && sigForm.Middlename.$invalid">
																      <span ng-show="sigForm.Middlename.$error.required">Please specify Area of Specialization</span></span>
																      <span style="color:red" ng-show="sigForm.Middlename.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															   <div class="form-group  has-feedback">
																    <label class="col-sm-3 control-label">Name of Group Lead</label>
																    <div class="col-sm-8">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="lastname"  name="lastname" ng-pattern="stringonly" required/>
																   	  <span class="glyphicon glyphicon-user form-control-feedback"></span>
																   	  <span style="color:red" ng-show="sigForm.lastname.$dirty && sigForm.lastname.$invalid">
																      <span ng-show="sigForm.lastname.$error.required">Please specify your Last Name</span></span>
																      <span style="color:red" ng-show="sigForm.lastname.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															  <div class="form-group">
															        <label class="col-sm-3 control-label">SIG Group Type</label>
															        <div class="col-sm-8 has-feedback">
																  		<select class="form-control" ng-model="sigtype" required>
																  			<option ng-show="false">Select</option>
																  			<option value="Individual">Individual</option>
																  			<option value="Association with Industry">Association with Industry</option>
																  			<option value="Under Academic">Under Academic</option>
																  		</select><br>
																  		<div  ng-switch="sigtype">
															  				<div ng-switch-when="Association with Industry">
															  					<input class="form-control" type="text" value="" name="association" placeholder="Please Mention Name">
															  				</div>
															  			</div>
																  	</div>
															  </div>
															  <!-- ------------------------------------ -->
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Mobile Number</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="mobilenumber" name="mobilenumber" ng-pattern="mobiles" required/><small>Format :+91 9855514371</small><br>
																      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
																      <span style="color:red" ng-show="sigForm.mobilenumber.$dirty && sigForm.mobilenumber.$invalid">
																      <span ng-show="sigForm.mobilenumber.$error.required">Please specify your Mobile Number</span></span>
																      <span ng-show="sigForm.mobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Email Id</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" name="email" ng-model="email" ng-pattern="emailid" required/>
																	  <span class="glyphicon  glyphicon-envelope form-control-feedback"></span>
																	  <span style="color:red" ng-show="sigForm.email.$dirty && sigForm.email.$invalid">
																      <span ng-show="sigForm.email.$error.required">Please specify your Email ID</span></span>
																	  <span ng-show="sigForm.email.$error.pattern" style="color:red">Please enter correct email address.</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Address of SIG Leader</label>
																    <div class="col-sm-8 has-feedback">
																      <textarea rows="2" cols="" class="form-control" name="taddress" ng-model="taddress" required/></textarea>
																       <span class="glyphicon glyphicon-home form-control-feedback"></span>
																      <p class="text-right">{{ taddress.length }}</p>
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
																       <span style="color:red" ng-show="sigForm.pincode.$dirty && sigForm.pincode.$invalid">
																       <span ng-show="sigForm.pincode.$error.required">Please specify Pincode</span></span>
																       <span ng-show="sigForm.pincode.$error.pattern" style="color:red">Pincode Should be 6 Digit <br> Alphabet and special Characters are Not Allowed.</span>
																    </div>
															  </div><hr>
															   <div class="label-statement">
															   		<center>I hereby declare that all the statements made by me in the application form and information sheet are true and complete to the best of my knowledge.</center>
															  </div>
															  <div  class="radio-button">
																  <label class="radio-inline">
															       		<input   type="radio" name="check" ng-model="sigyesno"  value="sigyes"  checked="checked" />Yes
															      </label>
															      <label for="test1" class="radio-inline">
															      	    <input   type="radio" name="check" ng-model="sigyesno" value="signo" /> No
															      </label>
														      </div><br>
														      <div ng-switch="sigyesno">
														      		<div ng-switch-when="signo">
														      			 <div class="save-button">
																 		 </div>
														      		</div>
														      		<div ng-switch-when="sigyes">
														      			 <div class="save-button">
																		    <button type="submit" class="btn btn-info btn-md active" 
																		    	 	   ng-disabled="sigForm.signame.$dirty && sigForm.signame.$invalid &&  sigForm.signame.$error.pattern 
																		    		             || sigForm.Middlename.$dirty && sigForm.Middlename.$invalid && sigForm.Middlename.$error.pattern
																		    		             || sigForm.lastname.$dirty && sigForm.lastname.$invalid && sigForm.lastname.$error.pattern
																		    		             || sigForm.mobilenumber.$dirty && sigForm.mobilenumber.$invalid && sigForm.mobilenumber.$error.pattern
																		    		             || sigForm.email.$dirty && sigForm.email.$invalid && sigForm.email.$error.pattern
																		    		             || sigForm.pincode.$dirty && sigForm.pincode.$invalid && sigForm.pincode.$error.pattern">Submit as SIG</button>
																		    		             
																		    <button type="reset" class="btn btn-warning btn-md active ">Reset</button><br>
																 		 </div>
														      		</div>
														      </div>
														</form> 
										   		   </div>
										   	 </div>
										 </div>
									</div>
									<!-- ----------------------------------------------END of SIG ---------------------------------------------->
									<div class="tab-pane " id="institude">
								        <div class="registration-center ">
									    	 <div class="panel   panel-border">
										   		   <div class="panel-body">
										   		   		 <form class="form-horizontal" name="instituteForm">
															  <div class="form-group ">
																    <label class="col-sm-3 control-label">Name of Institute</label>
																    <div class="col-sm-8  has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="iname"  name="iname" ng-pattern="stringonly" required>
																      <span class="glyphicon glyphicon-user form-control-feedback"></span>
																      <span style="color:red" ng-show="instituteForm.iname.$dirty && instituteForm.iname.$invalid">
																      <span ng-show="instituteForm.iname.$error.required">Please specify your Institute Name</span></span>
																      <span style="color:red" ng-show="instituteForm.iname.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Name of Principal</label>
																    <div class="col-sm-8  has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="pname"  name="pname"  ng-pattern="stringonly" required/>
																   	  <span class="glyphicon glyphicon-user form-control-feedback"></span>
																   	  <span style="color:red" ng-show="instituteForm.pname.$dirty && instituteForm.pname.$invalid">
																      <span ng-show="instituteForm.pname.$error.required">Please specify Principle Name</span></span>
																      <span style="color:red" ng-show="instituteForm.pname.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															  <div class="form-group">
																    <label class="col-sm-3 control-label">Gender</label>
																    <div class="col-sm-8">
																      <select  class="form-control" ng-model="pgender" name="pgender"  required/>
																	      <option value=""ng-show="false"><span class="">Select Gender</option>
																	      <option value="Male">Male</option>
																	      <option value="Female">Female</option>
																	</select>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Mobile Number</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="" type="text" value="" ng-model="pmobilenumber" name="pmobilenumber" ng-pattern="mobiles" required/><small>Format :+91 9855514371</small><br>
																      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
																      <span style="color:red" ng-show="instituteForm.pmobilenumber.$dirty && instituteForm.pmobilenumber.$invalid">
																      <span ng-show="instituteForm.pmobilenumber.$error.required">Please specify your Mobile Number</span></span>
																      <span ng-show="instituteForm.pmobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Email Id</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" name="pemail" ng-model="pemail" ng-pattern="emailid" required/>
																	  <span class="glyphicon  glyphicon-envelope form-control-feedback"></span>
																	  <span style="color:red" ng-show="instituteForm.pemail.$dirty && instituteForm.pemail.$invalid">
																      <span ng-show="instituteForm.pemail.$error.required">Please specify your Email ID</span></span>
																	  <span ng-show="instituteForm.pemail.$error.pattern" style="color:red">Please enter correct email address.</span>
																    </div>
															  </div>
															  <div class="form-group">
																    <label class="col-sm-3 control-label">No. of Department</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="" type="text" value="" ng-model="dept" name="dept" ng-pattern="numberonly" required/>
																      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
																      <span style="color:red" ng-show="instituteForm.dept.$dirty && instituteForm.dept.$invalid">
																      <span ng-show="instituteForm.dept.$error.required">Please specify No. of Department</span></span>
																      <span ng-show="instituteForm.dept.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed</span>
																    </div>
															  </div>
															  <div class="form-group">
																    <label class="col-sm-3 control-label">No. of Total Faculty Member (Teaching)</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="" type="text" value="" ng-model="faculty" name="faculty" ng-pattern="numberonly" required/>
																      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
																      <span style="color:red" ng-show="instituteForm.faculty.$dirty && instituteForm.faculty.$invalid">
																      <span ng-show="instituteForm.faculty.$error.required">Please specify No. of faculty member</span></span>
																      <span ng-show="instituteForm.faculty.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed</span>
																    </div>
															  </div>
															  <div class="form-group">
															  		<label class="col-sm-3 control-label">Registered As </label>
																    <div class="col-sm-8 has-feedback">
																    	<select class="form-control" name="registerassig" ng-model="registerassig" required>
																    		<option value="" ng-show="false">Select</option>
																    		<option>SIG</option>
																    		<option>Institute</option>
																    		<option>Incubatee</option>
																    	</select>
																    </div>
															  </div>
															<!--    <div class="form-group">
																    <label class="col-sm-3 control-label">Institute official landline number</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="" type="text" value="" ng-model="institutelandline" name="institutelandline" ng-pattern="landline" required/><small>Format :+91 9855514371</small><br>
																      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
																      <span style="color:red" ng-show="instituteForm.institutelandline.$dirty && instituteForm.institutelandline.$invalid">
																      <span ng-show="instituteForm.institutelandline.$error.required">Please specify institute official landline number</span></span>
																      <span ng-show="instituteForm.institutelandline.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
																    </div>
															  </div>--> 
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Institute Official Mobile Number</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="" type="text" value="" ng-model="institutemobilenumber" name="institutemobilenumber" ng-pattern="mobiles" required/><small>Format :+91 9855514371</small><br>
																      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
																      <span style="color:red" ng-show="instituteForm.institutemobilenumber.$dirty && instituteForm.institutemobilenumber.$invalid">
																      <span ng-show="instituteForm.institutemobilenumber.$error.required">Please specify institute official Mobile Number</span></span>
																      <span ng-show="instituteForm.institutemobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
																    </div>
															  </div>
															  
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Institute Official Email Id</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" name="instituteemail" ng-model="instituteemail" ng-pattern="emailid" required/>
																	  <span class="glyphicon  glyphicon-envelope form-control-feedback"></span>
																	  <span style="color:red" ng-show="instituteForm.instituteemail.$dirty && instituteForm.instituteemail.$invalid">
																      <span ng-show="instituteForm.instituteemail.$error.required">Please specify institute official email ID</span></span>
																	  <span ng-show="instituteForm.instituteemail.$error.pattern" style="color:red">Please enter correct email address.</span>
																    </div>
															  </div>
															  
															  
															  <!-- ------------------------------------ -->
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Institute Address</label>
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
																       <span style="color:red" ng-show="instituteForm.pincode.$dirty && instituteForm.pincode.$invalid">
																       <span ng-show="instituteForm.pincode.$error.required">Please specify Pincode</span></span>
																       <span ng-show="instituteForm.pincode.$error.pattern" style="color:red">Pincode Should be 6 Digit <br> Alphabet and special Characters are Not Allowed.</span>
																    </div>
															  </div><hr>
															   <div class="label-statement">
															   		<center>I hereby declare that all the statements made by me in the application form and information sheet are true and complete to the best of my knowledge.</center>
															  </div>
															  <div  class="radio-button">
																  <label class="radio-inline">
															       		<input   type="radio" name="check" ng-model="instiyesno"  value="instiyes"  checked="checked" />Yes
															      </label>
															      <label for="test1" class="radio-inline">
															      	    <input   type="radio" name="check" ng-model="instiyesno" value="instino" /> No
															      </label>
														      </div><br>
														      <div ng-switch="instiyesno">
														      		<div ng-switch-when="no">
														      			 <div class="save-button">
																 		 </div>
														      		</div>
														      		<div ng-switch-when="instiyes">
														      			 <div class="save-button">
																		    <button type="submit" class="btn btn-info btn-md active" 
																		    	 	   ng-disabled="instituteForm.iname.$dirty && instituteForm.iname.$invalid &&  instituteForm.iname.$error.pattern 
																		    		             || instituteForm.pname.$dirty && instituteForm.pname.$invalid && instituteForm.pname.$error.pattern
																		    		             || instituteForm.pmobilenumber.$dirty && instituteForm.pmobilenumber.$invalid && instituteForm.pmobilenumber.$error.pattern
																		    		             || instituteForm.email.$dirty && instituteForm.email.$invalid && instituteForm.email.$error.pattern
																		    		             || instituteForm.pincode.$dirty && instituteForm.pincode.$invalid && instituteForm.pincode.$error.pattern">Submit as Institute</button>
																		    		             
																		    <button type="reset" class="btn btn-warning btn-md active ">Reset</button><br>
																 		 </div>
														      		</div>
														      </div>
														</form> 
										   		   </div>
										   	 </div>
										 </div>
									</div>
									<!-----------------------------------------------end Institude------------------------------------------------->
									<div class="tab-pane " id="incubation">
								        <div class="registration-center ">
									    	 <div class="panel   panel-border">
										   		   <div class="panel-body">
										   		   		 <form class="form-horizontal" name="incubateeForm">
															  <div class="form-group ">
																    <label class="col-sm-3 control-label">Name of Incubation Center</label>
																    <div class="col-sm-8  has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="incuname"  name="incuname" ng-pattern="stringonly" required>
																      <span class="glyphicon glyphicon-user form-control-feedback"></span>
																      <span style="color:red" ng-show="incubateeForm.incuname.$dirty && incubateeForm.incuname.$invalid">
																      <span ng-show="incubateeForm.incuname.$error.required">Please specify name of incubation center</span></span>
																      <span style="color:red" ng-show="incubateeForm.incuname.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Thrust Area</label>
																    <div class="col-sm-8  has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="Middlename"  name="Middlename"  ng-pattern="stringonly" required/>
																   	  <span class="glyphicon glyphicon-user form-control-feedback"></span>
																   	  <span style="color:red" ng-show="incubateeForm.Middlename.$dirty && incubateeForm.Middlename.$invalid">
																      <span ng-show="incubateeForm.Middlename.$error.required">Please specify thrust area</span></span>
																      <span style="color:red" ng-show="incubateeForm.Middlename.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															  <div class="form-group">
															  		<label class="col-sm-3 control-label">Legal Status </label>
																    <div class="col-sm-8 has-feedback">
																    	<select class="form-control" name="legal" ng-model="legal" required>
																    		<option value="" ng-show="false">Select</option>
																    		<option> Section-8 company</option>
																    		<option> Trust / Society </option>
																    		<option>Unregistered</option>
																    		<option value="other">Other</option>
																    	</select><br>
																    	<div ng-switch="legal">
																    		<div ng-switch-when="other">
																    			<input type="text" class="form-control" placeholder="Please mention">
																    		</div>
																    	</div>
																    </div>
															  </div>
															   <div class="form-group">
															  		<label class="col-sm-3 control-label">Total Incubation Space in Sq.Ft</label>
																    <div class="col-sm-8 has-feedback">
																    	<select class="form-control" name="space" ng-model="space" required>
																    		<option value="" ng-show="false">Select</option>
																    		<option> Less than 10000</option>
																    		<option> Grater than 10000 </option>
																    		<option>Grater than 20000</option>
																    		<option value="other">Other</option>
																    	</select><br>
																    	<div ng-switch="space">
																    		<div ng-switch-when="other">
																    			<input type="text" class="form-control" placeholder="Please mention">
																    		</div>
																    	</div>
																    </div>
															  </div>
															  <div class="form-group ">
																    <label class="col-sm-3 control-label">Name of Incubation Member</label>
																    <div class="col-sm-8  has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="incumembername"  name="incumembername" ng-pattern="stringonly" required>
																      <span class="glyphicon glyphicon-user form-control-feedback"></span>
																      <span style="color:red" ng-show="incubateeForm.incumembername.$dirty && incubateeForm.incuname.$invalid">
																      <span ng-show="incubateeForm.incumembername.$error.required">Please specify name of incubation center</span></span>
																      <span style="color:red" ng-show="incubateeForm.incumembername.$error.pattern">Numeric and special Characters are Not Allowed</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Mobile Number</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" ng-model="mobilenumber" name="mobilenumber" ng-pattern="mobiles" required/><small>Format :+91 9855514371</small><br>
																      <span class="glyphicon  glyphicon-earphone form-control-feedback"></span>
																      <span style="color:red" ng-show="incubateeForm.mobilenumber.$dirty && incubateeForm.mobilenumber.$invalid">
																      <span ng-show="incubateeForm.mobilenumber.$error.required">Please specify your Mobile Number</span></span>
																      <span ng-show="incubateeForm.mobilenumber.$error.pattern" style="color:red">Alphabet and special Characters are Not Allowed <br> Please enter valid format(+91 9855514371)</span>
																    </div>
															  </div>
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Email Id</label>
																    <div class="col-sm-8 has-feedback">
																      <input class="form-control" id="focusedInput" type="text" value="" name="email" ng-model="email" ng-pattern="emailid" required/>
																	  <span class="glyphicon  glyphicon-envelope form-control-feedback"></span>
																	  <span style="color:red" ng-show="incubateeForm.email.$dirty && incubateeForm.email.$invalid">
																      <span ng-show="incubateeForm.email.$error.required">Please specify your Email ID</span></span>
																	  <span ng-show="incubateeForm.email.$error.pattern" style="color:red">Please enter correct email address.</span>
																    </div>
															  </div>
															  
															   <div class="form-group">
																    <label class="col-sm-3 control-label">Incubation Center Address</label>
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
																       <span style="color:red" ng-show="incubateeForm.pincode.$dirty && incubateeForm.pincode.$invalid">
																       <span ng-show="incubateeForm.pincode.$error.required">Please specify Pincode</span></span>
																       <span ng-show="incubateeForm.pincode.$error.pattern" style="color:red">Pincode Should be 6 Digit <br> Alphabet and special Characters are Not Allowed.</span>
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
																		    	 	   ng-disabled="incubateeForm.fname.$dirty && incubateeForm.fname.$invalid &&  incubateeForm.fname.$error.pattern 
																		    		             || incubateeForm.Middlename.$dirty && incubateeForm.Middlename.$invalid && incubateeForm.Middlename.$error.pattern
																		    		             || incubateeForm.lastname.$dirty && incubateeForm.lastname.$invalid && incubateeForm.lastname.$error.pattern
																		    		             || incubateeForm.someDate.$dirty && incubateeForm.someDate.$invalid && incubateeForm.someDate.$error.pattern
																		    		             || incubateeForm.mobilenumber.$dirty && incubateeForm.mobilenumber.$invalid && incubateeForm.mobilenumber.$error.pattern
																		    		             || incubateeForm.email.$dirty && incubateeForm.email.$invalid && incubateeForm.email.$error.pattern
																		    		             || incubateeForm.adharnumber.$dirty && incubateeForm.adharnumber.$invalid && incubateeForm.adharnumber.$error.pattern
																		    		             || incubateeForm.pincode.$dirty && incubateeForm.pincode.$invalid && incubateeForm.pincode.$error.pattern">Submit as Incubation</button>
																		    		             
																		    <button type="reset" class="btn btn-warning btn-md active ">Reset</button><br>
																 		 </div>
														      		</div>
														      </div>
														</form> 
										   		   </div>
										   	 </div>
										 </div>
									</div>
									<!-------------------------------------END INCUBATION-------------------------------------------------->
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
