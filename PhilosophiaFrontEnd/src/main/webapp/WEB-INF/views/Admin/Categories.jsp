<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<title>Admin : Manage Categories</title>
</head>
<body>
<center><h1>Category Management</h1></center>
<div class="container">
  <h2>Available Categories</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Category Id</th>
        <th>Category Name</th>
        <th>Category Description</th>
        <th>Edit / Remove</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${cgList}" var="cList">
      <tr>
        <td><c:out value="${cList.categoryId}" /></td>
        <td><c:out value="${cList.categoryName}" /></td>
        <td><c:out value="${cList.categoryDescription}" /></td>
        <td><form action="findCategory"><input type="hidden" name="ctgEditID" value="${ cList.categoryId}"><input type="submit"  class="btn btn-info" value="Edit"></form>
        <form action="deleteCategory"><input type="hidden" name="ctgDeleteID" value="${ cList.categoryId}"><input type="submit" class="btn btn-danger" value="Delete"></form></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  <br>
  <br>
  <c:if test="${ empty editCategoryMsg }">
  <center><h2>Add a Category</h2></center>
  <form:form class="form-horizontal"  method="post" action="addCategory" modelattribute="Category">
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryId">Category ID:</label>
      <div class="col-sm-10">
        <form:input path="categoryId" type="text" class="form-control" id="categoryId" placeholder="Enter Category Id" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryName">Category Name:</label>
      <div class="col-sm-10">          
        <form:input path="categoryName" type="text" class="form-control" id="categoryName" placeholder="Enter Category Name" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryDescription">Category Description:</label>
      <div class="col-sm-10">          
        <form:input path="categoryDescription" type="text" class="form-control" id="categoryDescription" placeholder="Enter Category Description" />
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>
  </c:if>
  <c:if test="${not empty editCategoryMsg }">
  <form class="form-horizontal" action="editCategory" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryId">Category ID:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="categoryId" value="${cgFound.categoryId}" disabled="disabled">
        <input type="hidden" id="ctID" name="ctID" value="${cgFound.categoryId}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryName">Category Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="categoryName" name="categoryName" value="${cgFound.categoryName}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="categoryDescription">Category Description:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="categoryDescription" name="categoryDescription" value="${cgFound.categoryDescription}">
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