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

  <body background="images/bg.jsp">
    <img alt="header" src="images/logo.jpg" width="100%">
	
    <div class="site-wrapper" style="background-image: url('images/bg.jpg'); background-size: 1300px 700px;
    background-repeat: no-repeat;">
    <div class="inner cover">
           
	 <div class="container">

      <form style="color:blue" class="form-signin">
        <h2 class="form-signin-heading">Enter Card Details</h2>
         <label for="inputCardHolderName" class="sr-only">Card Holder's Name</label>
        <input type="text" id="inputCardHolderName" class="form-control" placeholder="Card Holder Name" required autofocus>
        
        <label for="inputCardNo" class="sr-only">CreditCard No</label>
        <input type="text" id="inputCardNo" class="form-control" placeholder="Card No" required autofocus>
        
        <label for="inputExpDate" class="sr-only">Expiration Date</label>
        <input type="date" id="inputExpDate" class="form-control" placeholder="Expiration Date" required>
        
       
        <label for="inputCVV" class="sr-only">CVV</label>
        <input type="text" id="inputCVV" class="form-control" placeholder="CVV" required>
        
        
        <br><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Pay Bill</button>
      </form>
      
      
      <a href="preParkingProcess">Go to home page</a>
      
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