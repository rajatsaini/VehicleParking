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

<title>Manager Home</title>
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">

<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/cover.css" />" rel="stylesheet">
<link href="<c:url value="/css/signin.css" />" rel="stylesheet">
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>
<%--  <script src="<c:url value="/resources/js/main.js" />"></script> --%>
<style>
body {

	padding: 0px;
	padding-bottom: 0px;
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

	<div class="site-wrapper"
		style="background-image: url('./images/bg.jpg'); background-size: cover; background-repeat: no-repeat;">
		<div class="image">


			<div class="inner cover">

				<div class="container">

					<h2 class="form-signin-heading">Select the operation</h2>

					<center>
						<table
							style="border-collapse: collapse; position: absolute; top: 190px; left: 300px; width: 200px; height: 100px;"
							cellspacing="100">

							<tr>
								<td colspan="2"><a href="addUser">
										<div class="myButton">
											<input type="submit" value="Add Operator" />
										</div>
								</a></td>
							</tr>

							<tr>
								<td style="padding: 15px"><a href="deleteUserForm">
										<div class="myButton">
											<input type="submit" value="Delete Operator" />
										</div>
								</a></td>

								<td><a href="resetPasswordForm">
										<div class="myButton">
											<input type="submit" value="Reset password for Operator" />
										</div>
								</a></td>
							<tr>
								<td style="padding: 15px"><a href="currentlyParkedVehicles">
										<div class="myButton">
											<input type="submit"
												value="View details of currently parked vehicles" />
										</div>
								</a></td>
								<td><a href="previouslyParkedVehiclesForm">
										<div class="myButton">
											<input type="submit"
												value="View details of previously parked vehicles" />
										</div>
								</a></td>
							</tr>

							<tr>
								<td style="padding: 15px"><div class="myButton">
										<a href="blockSlotForm"> <input type="submit"
											value="Block slots" />
										</a>
									</div></td>
								<td><a href="addNewSlotForm">
										<div class="myButton">
											<input type="submit" value="Add new slots" />
										</div>
								</a>
									</button></td>
							</tr>

							<tr>
								<td style="padding: 15px"><div class="myButton">
										<a href="newRegistrationForm"> <input type="submit"
											value="New Registeration" />
										</a>
									</div></td>
								<td><a href="renewRegistrationForm">
										<div class="myButton">
											<input type="submit" value="Renew Registeration" />
										</div>
								</a>
									</button></td>
							</tr>
							<tr>
								<td colspan="2"><a href="unblockSlotForm">
										<div class="myButton">
											<input type="submit" value="Unblock Slot" />
										</div>
								</a></td>
							</tr>

						</table>
					</center>
					<br> <br> <br> . . . .

				</div>
			</div>


		</div>
	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>