<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
     
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
background-color:gray;
color:gray;
    border-collapse: collapse;
    width: 50%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}
body{
	padding-top: 0px;
	}
.button {
    background-color: #00000;
    border: none;
    color: gray;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
	
</style>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Deallocate</title>
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">
    
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/cover.css" />" rel="stylesheet">
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet">
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.js" />"></script>
    <%--  <script src="<c:url value="/resources/js/main.js" />"></script> --%>
	
  </head>

  <body background="../images/bg.jsp" style="padding-top: 0px;">
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
	<br>
	<br>
		<table  align="center" width="30%" height="300%"><tr>
           <td><font color="black">SLOT ID</font></td>
	<td><font color="black">${slotId}</font></td></tr>
	<tr><td><font color="black">PARKING ID</font></td>
	<td><font color="black">${parkingId}</font></td></tr>
	<tr><td><font color="black">VEHICLE NUMBER</font></td>
	<td><font color="black">${vehicleNumber}</font></td></tr>
	
	
	<tr><td><font color="black">MOBILE NUMBER</font></td>
	<td><font color="black">${mobileNumber}</font></td><tr>
	<tr><td><font color="black">VEHICLE TYPE</font></td>
	<td><font color="black">${vehicleType}</font></td></tr>
	<tr><td><font color="black">ENTRY TIME</font></td>
	<td><font color="black">${entryTime}</font></td><tr>
	<tr><td><font color="black">EXIT TIME</font></td>
	<td><font color="black">${exitTime}</font></td><tr>
	<tr><td><font color="black">NUMBER OF HOURS</font></td>
	<td><font color="black">${numberofhours}</font></td><tr>
	<tr><td><font color="black">Bill</font></td>
	<td><font color="black">${bill}</font></td><tr>
	</table>
	<form class="form-signin" action="billGenerate" method="post">
	<br><h4 style="color:blue">Payment Mode</h4>
        <input type="radio" name="paymentMode" value="CARD" checked><font color="black">Credit Card</font>
        <input type="radio" name="paymentMode" value="PACKAGE"><font color="black">Premium Package</font>
        <input type="radio" name="paymentMode" value="CASH"><font color="black">Cash</font>
        
        
        
        <input type="hidden" name="slotId" value="${slotId}">
        <input type="hidden" name="parkingId" value="${parkingId}">
        <input type="hidden" name="vehicleNumber" value="${vehicleNumber}">
        <input type="hidden" name="mobileNumber" value="${mobileNumber}">
        <input type="hidden" name="vehicleType" value="${vehicleType}">
        <input type="hidden" name="entryTime" value="${entryTime}">
        <input type="hidden" name="exitTime" value="${exitTime}">
        <input type="hidden" name="numberofhours" value="${numberofhours}">
        <input type="hidden" name="bill" value="${bill}">
        
	<div class="myButton"><input type="submit" value="Next" style="width:auto" /></div>
	</form>
	
	<a href="preParkingProcess">Go to home page</a>
	
	</div>
	</div>
      <c:set var="payMode" value="${param.paymentMode}" scope="session"></c:set>
      <c:if test="${payMode=='Credit Card'}">
	  <c:redirect url="CreditCard.jsp"/>
	  </c:if>

       <c:if test="${payMode=='Premium Package'}">
	   <c:redirect url="generatedBill.jsp"/>
	   </c:if>
	   
	   <c:if test="${payMode=='Cash'}">
	   <c:redirect url="generatedBill.jsp"/>
	   </c:if>
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