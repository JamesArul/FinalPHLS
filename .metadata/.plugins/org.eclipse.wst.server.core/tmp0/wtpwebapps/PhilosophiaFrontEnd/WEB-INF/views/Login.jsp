<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<script src="Resources/Bootstrap/bootstrap.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<title>Login</title>
</head>
<body>
<jsp:include page="MainHeader.jsp"></jsp:include>
 <div class="container">
 <center>
 <form class="form-horizontal" name='loginForm' action="<c:url value='j_spring_security_check' />" method="post">
 <div class="form-group">
      <label class="control-label col-sm-2" for="username">User ID:</label>
      <div class="col-sm-10">
         <input type="text" name="username" id="username" placeholder="Enter your unique User ID">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="password">User Password:</label>
      <div class="col-sm-10">
         <input type="password" id="password" name="password" placeholder="Enter your password">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Login</button>
      </div>
    </div>
 </form>
 <p>${msg }</p>
 </center>
 </div>
<jsp:include page="MainFooter.jsp"></jsp:include>
</body>
</html>