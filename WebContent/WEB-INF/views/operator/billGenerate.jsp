<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
     
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function myFunction() {
    window.print();
}
</script>
<style>

	body{
	padding-top: 0px;
	}
</style>
  <link href="<c:url value="/css/custom.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/cover.css" />" rel="stylesheet">
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet">
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Generated</title>
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
	 <img alt="header" src="images/bill.jpg" width="30%"><br>
	 <table bgcolor="gray" border="2" background="white" align="center" width="30%" height="300%"><tr>
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
	<tr><td><font color="black">PAYMENT MODE</font></td>
	<td><font color="black">${paymentMode}</font></td><tr>
	<tr><td><font color="black">Bill</font></td>
	<td><font color="black">${bill}</font></td><tr>
	</table>
	 
	 <div class="myButton"><input type="submit" onclick="myFunction()" value="Print Ticket" style="width:auto" /></div>
	 
	 <a href="preParkingProcess">Go to home page</a>
	 
	 </div>
	 </div>
	 </div>

</body>
</html>