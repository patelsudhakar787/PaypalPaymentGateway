<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> User Forgot password</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css1/forgot.css">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script> 
<style type="text/css">
.form-gap {
    padding-top: 70px;
}
</style>
</head>
<body>

 <form id="register-form" role="form" autocomplete="off" class="form"  action="./UserForgotpass" method="post">
 <div class="form-gap"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Forgot Password?</h2>
                  <p>You can reset your password here.</p>
                  <div class="panel-body">
    
                   
    
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <input id="email" ng-model="email" name="email" placeholder="Enter Email Id" class="form-control"  type="email" required/>
                        </div>
                      </div>
                      <div class="form-group">
                        <input name="recover-submit" class="btn btn-md btn-info active btn-block" value="Send Verification Link" type="submit" onclick="return "><br>
                         <span class="pull-right"><a href="begin-login.jsp">New User Register</a></span><span class="pull-left"><a href="begin-login.jsp">Login</a></span>
                      </div>
                      
                      <input type="hidden" class="hide" name="token" id="token" value=""> 
                    
    
                  </div>
                </div>
              </div>
            </div>
          </div>
	</div>
</div>
</form>
</body>
</html>