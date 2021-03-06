<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<script src="Resources/Bootstrap/bootstrap.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<script src="Resources/AngularJS/angular.min.js"></script>
<title>Display user carts</title>
</head>
<body>
<jsp:include page="..\MainHeader.jsp"></jsp:include>
<center><H1>Your Orders</H1></center>
<table class="table table-bordered">
    <thead>
      <tr>
        <th>Delivery Name</th>
        <th>Contact</th>
        <th>Order Status</th> 
        <th>Total Cost</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${cartUser}" var="cList">
      <tr>
        <td><c:out value="${cList.delivery_name}" /></td>
        <td><c:out value="${cList.user_contact}" /></td>
        <td><c:out value="${cList.cartStatus}" /></td>
        <td><c:out value="${cList.totalCost}" /></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
<jsp:include page="..\MainFooter.jsp"></jsp:include>
</body>
</html>