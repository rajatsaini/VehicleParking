<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Parking</title>
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/cover.css" />" rel="stylesheet">
<link href="<c:url value="/css/signin.css" />" rel="stylesheet">
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>
<%--  <script src="<c:url value="/resources/js/main.js" />"></script> --%>
<style>
body {
	padding-top: 0px;
}
</style>
</head>

<body background="images/bg.jsp">
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


			<div class="container">
				<div class="effleft" style="margin-top: 57px;">

					<form class="form-signin" method="post" action="PreParkingProcess">
						<div class="drop">
							<h3 style="color: black">Allocate Parking Slot</h3>
							<h3 style="color: blue">Vehicle Type</h3>

							<select style="color: gray" name="vehicleType">
								<option selected="selected" style="color: black" value="TWO">Two
									Wheeler</option>
								<option style="color: black" value="CAR">Four Wheeler</option>
							</select> <br> <br>
							<h3 style="color: blue">Customer Type</h3>
							<select style="color: gray" name="customerType">
								<option selected="selected">Package Customers</option>
								<option style="color: black">Non-Package Customers</option>
							</select>
						</div>
						<br>
						<div class="myButton">
							<input type="submit" value="Next" />
						</div>
					</form>
				</div>
				<div class="effright" style="margin-top: 65px;">
					<div class="drop">

						<h3 style="color: black">Deallocate Parking Slot</h3>
						<h3 style="color: blue">Enter Parking Id</h3>
						<form class="form-signin" action="deAllocate">

							<label for="inputparkingId" class="sr-only">Parking Id</label> <input
								type="number" id="inputparkingId" name="parkingId" maxlength="5"
								class="form-control" placeholder="Parking Id" required>
								<h4 style="color:red">${msg}</h4>
							<br> <br>

							<div class="myButton">
								<input type="submit" value="Deallocate" />
							</div>
					</div>
					</form>

				</div>

			</div>
		</div>



	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>