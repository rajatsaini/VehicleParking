<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/cover.css" />" rel="stylesheet">
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.js" />"></script>
    <%--  <script src="<c:url value="/resources/js/main.js" />"></script> --%>
<style>
.myButton input[type=submit] {
    width: 300px;
   
    }
	body{
	padding-top: 0px;
	}
	</style>
  </head>
  <body>
<div class="effHeader">
		<table>
			<tr>
				<td><div class="logo">
						<img alt="header" src="images/logo.jpg">
					</div></td>
				<td><a href="logout">Log Out</a></td>
			</tr>

		</table>
	</div>
  
    <div class="site-wrapper" style="background-image: url('images/bg.jpg'); background-size: 1350px 700px;
    background-repeat: no-repeat;">


          <div class="inner cover">
	
	
	    <div class="container">
	    <br>
	<h3 style="colr:blue">${msg}</h3>
	<br>
	<br>
	<h4><font color="black" size="3"> Details of Premium Member are:</font> </h4>
	<br>
	<br>
	 <table bgcolor="gray" border="1" align="center">
      <tr>
      	<td><font color="black" size="3">REGISTRATION ID</font></td>
      	<td><font color="black" size="3">DRIVER MOBILE NUMBER</font></td>
      	<td><font color="black" size="3">VECHILE REGD NUMBER</font></td>
      	<td><font color="black" size="3">VECHILE NUMBER</font></td>
      	<td><font color="black" size="3">COUSTOMER NAME</font></td>
      	<td><font color="black" size="3">DATE</font></td>
      </tr>
      <tr>
      
   <td><font color="black" size="3">  ${registrationId}</font></td>
   <td><font color="black" size="3">  ${driverMobileNumber}</font></td>
    <td><font color="black" size="3"> ${vehicleRegistrationNumber}</font></td>
    <td><font color="black" size="3"> ${vehicleType}</font></td>
   <td><font color="black" size="3">  ${customerName}</font></td>
   <td><font color="black" size="3">  ${date}   </font></td> 
   </tr>
   </table>
     <br><br>
     <a href="newRegistrationForm"><font color="blue" size="3">Create More Registration(s)</font></a>
     <br>
     <br>
				
	  <a href="managerhome"><font color="blue" size="3">Go to Home Page</font></a>      

    </div>
          </div>
        </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

	
</body>
</html>