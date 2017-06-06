<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Allocate Parking</title>
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/cover.css" />" rel="stylesheet">
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet">
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.js" />"></script>
    <%--  <script src="<c:url value="/resources/js/main.js" />"></script> --%>
	<style>
	body{
	padding-top: 0px;
	}
	</style>
  </head>

  <body background="../images/bg.jsp">
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
	 <h4 style="color:red">${msg}</h4>
       <font size="5" color="black">Enter Vehicle Details</font>
        <br>
      <form action ="ticketGenerate" style="color:black" class="form-signin">

        
                
        <label for="inputParkingId" class="sr-only">Parking Id</label>
        <input type="number" min="1" name="parkingId" maxlength="5" id="inputParkingId" class="form-control" value="${parkingId}" required>
        
        <label for="inputSlotId" class="sr-only">Slot Id</label>
        <input type="text" name="slotId" maxlength="5" id="inputSlotId" class="form-control" value="${slotId}" required autofocus>
        
        <label for="inputVehicleNo" class="sr-only">Vehicle Number</label>
        <input type="text" name="vehicleNumber" minlength="6" maxlength="10" id="inputVehicleNo" class="form-control" placeholder="Vehicle Number" required autofocus>
        
        <label for="inputMobileNo" class="sr-only">Driver's Mobile No</label>
        <input type="number" name="mobileNumber" maxlength="10" id="inputMobileNo" class="form-control" min="7000000000" max="9999999999" placeholder="Driver's Mobile No" required>
        
        <jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
        <fmt:formatDate value="${now}" dateStyle="long"/>
         <fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss a z"/>
         <input type="hidden" name="vehicleType" value="${vehicleNumber}">
         <input type="hidden" name="vehicleType" value="${vehicleType}">
        <input type="hidden" name="customerType" value="${customerType}">
        <input type="hidden" name="entryTime" value="${now}">
        
      <label for="inputEntryTime" class="sr-only" style="color:black"><b>${now}</b></label>
        
      
        <br><br>
        
        <div class="myButton"><input type="submit" value="Allocate Parking"/></div>
        
      </form>
      
      <a href="preParkingProcess"><font size="5" color="blue">Go to home page</font></a>
    </div>
          </div>

          

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