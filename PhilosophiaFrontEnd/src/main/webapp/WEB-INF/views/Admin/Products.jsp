<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<title>Admin : Manage Products</title>
</head>
<body>
<center><h1>Product Management</h1></center>
<div class="container">
  <h2>Available Products</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Supplier Id</th>
        <th>Category Id</th>
        <th>Book Description</th>
        <th>Book Quantity</th>
        <th>Book Cost</th>
        <th>Book Cover</th>
        <th>Edit / Remove</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${prList}" var="pList">
      <tr>
        <td><c:out value="${pList.productId}" /></td>
        <td><c:out value="${pList.productName}" /></td>
        <td><c:out value="${pList.supplierId}" /></td>
        <td><c:out value="${pList.categoryId }" /></td>
        <td><c:out value="${pList.productDesc }" /></td>
        <td><c:out value="${pList.productQuantity }" /></td>
        <td><c:out value="${pList.productCost }" /></td>
        <td><img src="${path}${pList.productId}.jpg" height="55" width="50"/></td>
        <td><form action="findProduct"><input type="hidden" name="prdEditID" value="${ pList.productId}"><input type="submit"  class="btn btn-info" value="Edit"></form>
        <form action="deleteProduct"><input type="hidden" name="prdDeleteID" value="${ pList.productId}"><input type="submit" class="btn btn-danger" value="Delete"></form></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  <br>
  <br>
  <c:if test="${ empty editProductMsg }">
  <center><h2>Add a Product</h2></center> 
  <form:form class="form-horizontal"  method="post" action="addProduct?${_csrf.parameterName}=${_csrf.token}" modelattribute="Product" enctype="multipart/form-data">
    <div class="form-group">
      <label class="control-label col-sm-2" for="productId">Book ID:</label>
      <div class="col-sm-10">
        <form:input path="productId" type="text" class="form-control" id="productId" placeholder="Enter Book Id" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productName">Book Name:</label>
      <div class="col-sm-10">          
        <form:input path="productName" type="text" class="form-control" id="productName" placeholder="Enter Book Name" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productDesc">Book Description:</label>
      <div class="col-sm-10">          
        <form:input path="productDesc" type="text" class="form-control" id="productDesc" placeholder="Enter Book Description" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryId">Category Id:</label>
      <div class="col-sm-10">          
        <form:input path="categoryId" type="text" class="form-control" id="categoryId" placeholder="Enter Category Id" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierId">Supplier Id:</label>
      <div class="col-sm-10">          
        <form:input path="supplierId" type="text" class="form-control" id="supplierId" placeholder="Enter Supplier Id" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productQuantity">Book Qunatity:</label>
      <div class="col-sm-10">          
        <form:input path="productQuantity" type="text" class="form-control" id="productQuantity" placeholder="Enter Book Qunatity" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productCost">Book Cost:</label>
      <div class="col-sm-10">          
        <form:input path="productCost" type="text" class="form-control" id="productCost" placeholder="Enter Book Cost" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productImage">Book Cover:</label>
      <div class="col-sm-10">          
        <form:input path="productImage" type="file" class="form-control" id="productImage" placeholder="Enter Book Cover" />
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>
  </c:if>
  <c:if test="${not empty editProductMsg }">
  <h2>Edit Product</h2>
  <form class="form-horizontal" action="editProduct" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="productId">Book ID:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="productId" value="${prFound.productId}" disabled="disabled">
        <input type="hidden" id="prID" name="prID" value="${prFound.productId}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productName">Book Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="productName" name="productName" value="${prFound.productName}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productDesc">Book Description:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="productDesc" name="productDesc" value="${prFound.productDesc}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierId">Supplier Id:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="supplierId" name="supplierId" value="${prFound.supplierId}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryId">Category Id:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="categoryId" name="categoryId" value="${prFound.categoryId}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productDesc">Book Description:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="productDesc" name="productDesc" value="${prFound.productDesc}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productQuantity">Book Quantity:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="productQuantity" name="productQuantity" value="${prFound.productQuantity}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="productCost">Book Cost:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="productCost" name="productCost" value="${prFound.productCost}">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
  </c:if>
</div>
</body>
</html>