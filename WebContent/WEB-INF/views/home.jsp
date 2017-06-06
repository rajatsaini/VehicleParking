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


          <div class="inner cover">
           <br>
           <br>
	<h1 style="color:black;">Welcome to Q Park System</h1>
	    <div class="container">

      <form class="form-signin" action="login" method="post">
      <img alt="header" src="images/ii.png" width="40%">
      <br>
      <input type="radio" name="role" value="OPERATOR" checked><font color="black">Operator</font> 
  			<input type="radio" name="role" value="MANAGER"> <font color="black">Manager</font>
  			<input type="radio" name="role" value="BUSINESSMAN"><font color="black"> Business Man</font>
        <label for="inputusernmae" class="sr-only">user name</label>
        <input type="text" id="username" name="username" maxlength="20"class="form-control" placeholder="User Name" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        	<input type="password" id="inputPassword" name="password" maxlength="20" class="form-control" placeholder="Password" required>
        	
        
        
        <div class="myButton"><input type="submit" value="Login"/></div>
        <h4 style="color:red">${msg}</h4>
      </form>

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
<%--<img alt="header" src="images/footer.png" width="100%">--%>
	
</body>
</html>