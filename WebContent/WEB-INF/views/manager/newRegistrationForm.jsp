<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	
	<h3 style="color:red">${msg}</h3>
	    <div class="container">
<h2 class="form-signin-heading"><font color="black" size="5">Enter the details</font></h2> <br><br>
<br>
      <form action="newRegistration" method="post" class="form-signin">
        
        <label for="inputusernmae" class="sr-only">Registration Id</label>
        <input type="number" min="1" id="Registrationid" name="registrationId" minlength="4" maxlength="5"class="form-control" value="${registrationId}" required autofocus>
        <label for="inputPassword" class="sr-only">Customer Name</label>
        <input type="text" id="customername" minlength="8" maxlength="24"name="customerName"class="form-control" placeholder="Customer Name" required>
        <label for="inputPassword" class="sr-only">Vehicle Registration Number</label>
        <input type="text" id="vehiclenumber" minlength="8" maxlength="12" name="vehicleRegistrationNumber"class="form-control" placeholder="Vehicle Registration Number" required>
        <select style="color: gray" name="vehicleType">
        	<option value="TWO" selected="selected"><font color="black" size="3">Two Wheeler</font></option>
        	<option value="CAR"><font color="black" size="3">Four Wheeler</font></option>
        </select><br><br>
        <label for="inputPassword" class="sr-only">Driver Phone Number</label>
        <input type="number" id="mobilenumber"  maxlength="10" min="7000000000" min="9999999999" name="driverMobileNumber" class="form-control" placeholder="Driver Phone Number" required> 
        <label for="inputPassword" class="sr-only">Package Price</label>
        <input type="number" id="price" name="price" min=1; minlength="4" maxlength="4"class="form-control" placeholder="Package Price" required> <br> <br> 
      <div class="myButton">    <input type="submit" value="Add Registration"></div>
        
        </form>      
        
        <a href="managerhome"><font size="5" color="blue">Go to home page</font></a>     

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