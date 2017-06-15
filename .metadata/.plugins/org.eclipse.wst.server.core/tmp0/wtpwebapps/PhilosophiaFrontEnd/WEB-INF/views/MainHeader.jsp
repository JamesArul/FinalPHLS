<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<script type="text/javascript" src="Resources/Bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<link  rel="stylesheet" href="Resources/FontAwesome/font-awesome.min.css">
<style>
@font-face {
  font-family: 'Glyphicons Halflings';
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot');
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.woff') format('woff'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.ttf') format('truetype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.svg#glyphicons-halflingsregular') format('svg');
}
.navbar-custom {
	background-color:#18767a;
    color:#ffffff;
  	border-radius:0;
}
  
.navbar-custom .navbar-nav > li > a {
  	color:#fff;
}

.navbar-custom .navbar-nav > .active > a {
    color: #ffffff;
	background-color:transparent;
}
      
.navbar-custom .navbar-nav > li > a:hover,
.navbar-custom .navbar-nav > li > a:focus,
.navbar-custom .navbar-nav > .active > a:hover,
.navbar-custom .navbar-nav > .active > a:focus,
.navbar-custom .navbar-nav > .open >a {
    text-decoration: none;
    background-color: #33aa33;
}
     
.navbar-custom .navbar-brand {
  	color:#eeeeee;
}
.navbar-custom .navbar-toggle {
  	background-color:#eeeeee;
}
.navbar-custom .icon-bar {
  	background-color:#33aa33;
}
</style>
</head>
<body>
<nav class="navbar navbar-custom">
  <div class="container-fluid">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="goHome">Philosophia</a>
  </div>
  <div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
      <li><a href="goAboutUs">About Us</a></li>
      <li><a href="goProdView">Books</a></li>
      <c:if test="${not empty UserMsg }">
      <li><a href="goMyCart">MyCart</a></li>
      <li><a href="goAllMyCart">View My Orders</a></li>
      </c:if>
      <c:if test="${not empty AdminMsg }">
      <li><a href="goAdmin">Overall Management</a></li>
      </c:if>
    </ul>
    <c:if test="${ not empty loginMsg }">
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-user"></span>
        <span class="caret"></span></a>
        <ul class="dropdown-menu pull-right">
          <li><a href="goLogin">Login</a></li>
          <li><a href="goRegister">Register</a></li>
        </ul>
      </li>
      </ul>
      </c:if>
      <c:if test="${not empty UserMsg }">
      <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-user"></span>${ UserName }
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="goModifyUser">Modiy Account</a></li>
          <li><c:url var="logoutUrl" value="/j_spring_security_logout" />
    <form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
    </form>
    <a href="#" onclick="document.getElementById('logout').submit();">Logout</a></li>
        </ul>
      </li>
      </ul>
      </c:if>
      <c:if test="${not empty AdminMsg }">
      <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-user"></span>${ UserName }
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Modiy Account</a></li>
          <li><c:url var="logoutUrl" value="/j_spring_security_logout" />
    <form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
    </form>
    <a href="#" onclick="document.getElementById('logout').submit();">Logout</a></li>
        </ul>
      </li>
      </ul>
      </c:if>
    </ul>
  </div>
  </div>
</nav>
</body>
</html>