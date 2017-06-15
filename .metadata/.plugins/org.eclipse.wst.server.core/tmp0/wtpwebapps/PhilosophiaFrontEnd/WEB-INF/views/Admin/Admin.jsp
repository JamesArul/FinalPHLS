<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<script type="text/javascript" src="Resources/Bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
function manageCategories()
{
	window.location="selManageCategories";
}
function manageProducts()
{
	window.location="selManageProducts";
}
function manageSuppliers()
{
	window.location="selManageSuppliers";
}
</script>
<title>Admin</title>
</head>
<body>
<jsp:include page="..\MainHeader.jsp"></jsp:include>
<center>
<div class="row">
<div class="col-sm-4">
<button type="button" class="btn btn-success" onclick="manageCategories()">Manage Categories</button>
</div>
<div class="col-sm-4">
<button type="button" class="btn btn-success" onclick="manageProducts()">Manage Products</button>
</div>
<div class="col-sm-4">
<button type="button" class="btn btn-success" onclick="manageSuppliers()">Manage Suppliers</button>
</div>
</div>
</center>
<c:if test="${not empty CategoryManage }">
<jsp:include page="Categories.jsp"></jsp:include>
</c:if>
<c:if test="${not empty SuppierManage }">
<jsp:include page="Suppliers.jsp"></jsp:include>
</c:if>
<c:if test="${not empty ProductManage }">
<jsp:include page="Products.jsp"></jsp:include>
</c:if>
<jsp:include page="..\MainFooter.jsp"></jsp:include>
</body>
</html>