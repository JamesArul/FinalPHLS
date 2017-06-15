<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<title>Admin : Manage Suppliers</title>
</head>
<body>
<center><h1>Supplier Management</h1></center>
<div class="container">
  <h2>Available Suppliers</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Supplier Id</th>
        <th>Supplier Name</th>
        <th>Supplier Description</th>
        <th>Supplier Address</th>
        <th>Edit / Remove</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${spList}" var="sList">
      <tr>
        <td><c:out value="${sList.supplierId}" /></td>
        <td><c:out value="${sList.supplierName}" /></td>
        <td><c:out value="${sList.supplierDescription}" /></td>
        <td><c:out value="${sList.supplierAddress.street }" />
        <c:out value="${sList.supplierAddress.city }" />
        <c:out value="${sList.supplierAddress.state }" />
        <c:out value="${sList.supplierAddress.pincode }" /></td>
        <td><form action="findSupplier"><input type="hidden" name="supEditID" value="${ sList.supplierId}"><input type="submit"  class="btn btn-info" value="Edit"></form>
        <form action="deleteSupplier"><input type="hidden" name="supDeleteID" value="${ sList.supplierId}"><input type="submit" class="btn btn-danger" value="Delete"></form></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  <br>
  <br>
  <c:if test="${ empty editSupplierMsg }">
  <center><h2>Add a Supplier</h2></center>
  <form:form class="form-horizontal"  method="post" action="addSupplier" modelattribute="Supplier">
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierId">Supplier ID:</label>
      <div class="col-sm-10">
        <form:input path="supplierId" type="text" class="form-control" id="supplierId" placeholder="Enter Supplier Id" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierName">Supplier Name:</label>
      <div class="col-sm-10">          
        <form:input path="supplierName" type="text" class="form-control" id="supplierName" placeholder="Enter Supplier Name" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierDescription">Supplier Description:</label>
      <div class="col-sm-10">          
        <form:input path="supplierDescription" type="text" class="form-control" id="supplierDescription" placeholder="Enter Supplier Description" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressStreet">Supplier Street:</label>
      <div class="col-sm-10">          
        <form:input path="supplierAddress.street" type="text" class="form-control" id="supplierAddressStreet" placeholder="Enter Supplier Street" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressCity">Supplier City:</label>
      <div class="col-sm-10">          
        <form:input path="supplierAddress.city" type="text" class="form-control" id="supplierAddressCity" placeholder="Enter Supplier City" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressState">Supplier State:</label>
      <div class="col-sm-10">          
        <form:input path="supplierAddress.state" type="text" class="form-control" id="supplierAddressState" placeholder="Enter Supplier State" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressPincode">Supplier Pincode:</label>
      <div class="col-sm-10">          
        <form:input path="supplierAddress.pincode" type="text" class="form-control" id="supplierAddressPincode" placeholder="Enter Supplier Pincode" />
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>
  </c:if>
   <c:if test="${not empty editSupplierMsg }">
  <form class="form-horizontal" action="editSupplier" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierId">Supplier ID:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="supplierId" value="${supFound.supplierId}" disabled="disabled">
        <input type="hidden" id="spID" name="spID" value="${supFound.supplierId}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierName">Supplier Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="supplierName" name="supplierName" value="${supFound.supplierName}" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierDescription">Supplier Description:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="supplierDescription" name="supplierDescription" value="${supFound.supplierDescription}" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressStreet">Supplier Street:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="supplierAddressStreet" name="supplierAddressStreet" value="${supFound.supplierAddress.street}" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressCity">Supplier City:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="supplierAddressCity" name="supplierAddressCity" value="${supFound.supplierAddress.city}" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressState">Supplier State:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="supplierAddressState" name="supplierAddressState" value="${supFound.supplierAddress.state}" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplierAddressPincode">Supplier Pincode:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="supplierAddressPincode" name="supplierAddressPincode" value="${supFound.supplierAddress.pincode}" >
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