<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.button {
    background-color: #00000; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button5 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
}

.button5:hover {
    background-color: #555555;
    color: white;
}
	body{
	padding-top: 0px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operator Page</title>
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/cover.css" />" rel="stylesheet">
<link href="<c:url value="/css/signin.css" />" rel="stylesheet">
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>
</head>
<body background="images/bg.jsp" style="padding-top: 0px;">
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
	<div class="site-wrapper"
		style="background-image: url('images/bg.jpg'); background-size: 1350px 700px; background-repeat: no-repeat;">
		<div class="inner cover">
		<br>
		<br>
		<br>
		
			<h1><font color="black">Available Slots to Select</font></h1>
			<div class="button" style="color: #bce44e;">
				<c:forEach items="${parkingSlots}" var="slot" begin="0">
				<button class="button button5">	<a  href="<c:url value="allocateParking">
        	<c:param name="slotId" value="${slot.slotId }"/>
        	<c:param name="vehicleType" value="${vehicleType}"/>
        	<c:param name="customerType" value="${customerType}"/>
	       </c:url> 
    	">
    	<font color="black">${slot.slotId }</font></a></button>
				</c:forEach>
			</div>
		</div>
		<a href="preParkingProcess">Go to home page</a>
	</div>
</body>
</html>