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
<title>Cart Creation</title>
</head>
<body>
<jsp:include page="..\MainHeader.jsp"></jsp:include>
 <h2>${ noCartInitialized }</h2>  
<center>Create a cart and then add Products to your cart</center>
<!-- <div class="form-group">
      <label class="control-label col-sm-2" for="categoryId">Category Id:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="categoryId" name="categoryId" value="${prFound.categoryId}">
      </div>
    </div> -->
<form class="form-horizontal" method="post" action="createCartOfUser">
<div class="form-group">
<label class="control-label col-sm-2" for="title">User ID:</label>
<div class="col-sm-10">
<input type="text" class="form-control" value="${userID}" disabled="disabled">
<input type="hidden" id="usID" name="usID" value="${userID}">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="usName">Deliver To (Receiver Name):</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="usName" name="usName" value="${ UserName }">
</div>
</div>
<center><h3>Enter the Billing Address</h3></center>
<div class="form-group">
<label class="control-label col-sm-2" for="addr1">Street:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr1" name="addr1" placeholder="Enter your street">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="addr2">City:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr2" name="addr2" placeholder="Enter your City">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="addr3">State:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr3" name="addr3" placeholder="Enter your State">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="addr4">Pincode</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr4" name="addr4" placeholder="Enter your Pincode">
</div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<center><input type="submit" value="Create Cart"></center>
</form>
<jsp:include page="..\MainFooter.jsp"></jsp:include>
</body>
</html>