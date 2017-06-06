<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
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
    <link href="<c:url value="/css/custom.css" />" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/cover.css" />" rel="stylesheet">
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet">
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.js" />"></script>
    <%--  <script src="<c:url value="/resources/js/main.js" />"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ticket Generate</title>
</head>
<body style="padding-top: 0px;">
	<div class="effHeader">
		<table>
			<tr>
				<td><div class="logo">
						<img alt="header" src="images/logo.jpg">
					</div></td>
			</tr>

		</table>
	</div>
	
    <div class="site-wrapper" style="background-image: url('images/bg.jpg'); background-size: 1350px 700px;
    background-repeat: no-repeat;">
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
       
         

          <div class="inner cover">
           <div class="container">
           <br>
           <br>
           <br>
           <img alt="header" src="images/ticket.jpg" width="30%"><br>
           <table bgcolor="gray" border="2" background="white" align="center" width="30%" height="300%"><tr>
           <td><font color="black">VEHICLE TYPE</font></td>
	<td><font color="black">${vehicleType}</font></td></tr>
	<tr><td><font color="black">SLOT ID</font></td>
	<td><font color="black">${slotId}</font></td></tr>
	<tr><td><font color="black">PARKING ID</font></td>
	<td><font color="black">${parkingId}</font></td></tr>
	<tr><td><font color="black">MOBILE NUMBER</font></td>
	<td><font color="black">${mobileNumber}</font></td><tr>
	<tr><td><font color="black">ENTRY TIME</font></td>
	<td><font color="black">${now}</font></td><tr>
	</table>

<script>
function myFunction() {
    window.print();
}
</script>
	<div class="myButton"><input type="submit" onclick="myFunction()" value="Print Ticket" style="width:auto" /><a href="PreParkingProcess.jsp"></a></div>
	</div>
	</div>
	
	<a href="preParkingProcess"><font size="5" color="blue">Go to home page</font></a>
	</div>
	
</body>
</html>