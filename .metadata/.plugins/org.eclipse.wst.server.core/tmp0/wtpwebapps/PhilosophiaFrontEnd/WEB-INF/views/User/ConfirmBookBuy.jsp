<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<script src="Resources/AngularJS/angular.min.js"></script>
<script src="Resources/Bootstrap/bootstrap.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<link  rel="stylesheet" href="Resources/FontAwesome/font-awesome.min.css">
<title>Confirm your order</title>
<style>
.input-group
{
width : 300px;
}
</style>
</head>
<body>
<jsp:include page="..\MainHeader.jsp"></jsp:include>
<div ng-app>
<center><img src="${path}${ProductDetails.productId}.jpg" height="85" width="70"/>
<h1>${ProductDetails.productName }</h1>
<h2>${ProductDetails.productDesc }</h2></center>
<input type="hidden" ng-model="ProductCost" ng-init="ProductCost=${ProductDetails.productCost }" id="ProductCost" value="${ProductDetails.productCost }" />
<input type="hidden" ng-model="Available_Quantity" ng-init="Available_Quantity=${AvailableQty }" />
<c:if test="${empty OutOfStock }">
<center>
<h2>Cost : <p>{{ ProductCost * quantity }}</p> </h2>
</center>
<form action="addCartProduct">
<input type="hidden" id="prdAddId" name="prdAddId" value="${ProductDetails.productId}" />
<center>
<div class="input-group">
<span class="input-group-addon">Quantity</span>
<input type="text" class="form-control" ng-model="quantity" ng-init="quantity=1" placeholder="Enter the Product Quantity" id="quantity" value="1" name="quantity" max="${ProductDetails.productQuantity }" />
</div>
<br/>
<div ng-if="quantity <= Available_Quantity">
<input type="submit" value="Add to Cart" class="btn btn-primary" />
</div>
<div ng-if="quantity > Available_Quantity">
<h2><center>Over Stock Limit</center></h2>
</div>
</form>
</center>
</c:if>
<c:if test="${not empty OutOfStock }">
<center>
<h2>Cost : ${ProductDetails.productCost }</h2>
<h1>Product Out Of Stock</h1>
</center>
</c:if>
</div>
<jsp:include page="..\MainFooter.jsp"></jsp:include>
</body>
</html>