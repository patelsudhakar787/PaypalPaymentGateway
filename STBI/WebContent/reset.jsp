<%@page import="com.dao.Dao"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password
</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script> 
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/wow/0.1.12/wow.min.js"></script> 
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<link rel="stylesheet" type="text/css" href="css1/login.css">
  		 <script type="text/javascript">
    function Validate() {
        var password = document.getElementById("Password").value;
        var confirmPassword = document.getElementById("Confirmed Password").value;
        if (password != confirmPassword) {
            alert("password and confirmed password do not match");
            return false;
        }
        return true;
    }
</script>
 
</head>
<body>
 <%  
 //create object
 
      Connection con;
      PreparedStatement pst;
      ResultSet rs;
      
      //get values 
	    String uuid=request.getParameter("code");
        String email=request.getParameter("email");
      
	    con=Dao.getConnection();//use dao class
	    
	    if(uuid!=null)//check condition
	    {
        String query="select * from user where uuidnumber=?";
        pst=con.prepareStatement(query);
        pst.setString(1,uuid);
        rs=pst.executeQuery();
        String dbuid="",dbemailto="",edbemailstatus="";
        String datetimer="",dbemail="";
        while(rs.next())//retrive data 
        {
        	dbemail=rs.getString("emailid");
        	dbuid=rs.getString("uuidnumber");
            dbemailto=rs.getString("emailtodate");
        	edbemailstatus=rs.getString("emailstatus");
        	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        Date d1 = new Date();
			Date d2 = null,d3=null;
		    d2 = format.parse(dbemailto);
		    long diff = d2.getTime() - d1.getTime();
            long diffmin = diff / (60 * 1000) % 60;
           
     if(uuid.equals(dbuid) && (edbemailstatus.equalsIgnoreCase("Unhit")) && diffmin>=0)
             {
        	 String edbemailsta="Hit";
        	 String query1="update user set emailstatus=? where uuidnumber=?";
             PreparedStatement pst1=con.prepareStatement(query1);
             pst1.setString(1,edbemailsta);
             pst1.setString(2,uuid);
             int i=pst1.executeUpdate();
            // out.println("record updated successfully..."+i);
              }
          else
             {
        	  out.println("<html><body style=background:silver>");
      	    out.println("<script type=\"text/javascript\">");
  	        out.println("alert('Hit Link Already or Link Expired....')");
  	        out.println("document.location.href = 'forgot.jsp';\n");
  	        out.println("</script>");
  	        out.println("</body></html>");
             } 
            }
	    }else
	    {
	    	 out.println("<html><body style=background:silver>");
	      	    out.println("<script type=\"text/javascript\">");
	  	        out.println("alert('Enter Your Email Id First....')");
	  	        out.println("document.location.href = 'forgot.jsp';\n");
	  	        out.println("</script>");
	  	        out.println("</body></html>");	
	    }
        %>
        <%-- pass values to corresponding textboxes --%>
        
        <form action="./SetPassword" method="post">
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <h1 class="text-center">Reset</h1>
        </div>
         <div class="modal-body">
           <div class="form-group">
                 <input type="text" class="form-control input-lg" name="email" value="<%=email %>" readOnly />
             </div>
             <div class="form-group">
                 <input type="password"  class="form-control input-lg" id="Password" placeholder="Enter New Password" name="Password"/>
             </div>

             <div class="form-group">
                 <input type="password" class="form-control input-lg"  id="Confirmed Password" placeholder="Enter New Confirmed  Password" name="Confirmed Password"/>
             </div>
             <div class="form-group">
                 <input type="hidden" class="form-control input-lg"  name="hid" value="<%=uuid %>" />
             </div>

             <div class="form-group">
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Reset Password" onclick="return Validate()"/>
                 <span class="pull-right"><a href="begin-login.jsp">New User Register</a></span><span><a href="begin-login.jsp">Login</a></span>
             </div>
         </div>
    </div>
 </div>
</form>
</body>
</html>