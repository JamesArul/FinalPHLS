<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form class="form-horizontal" method="post" action="getShippingAddress">
<center><h2>Enter the Shipping Address</h2></center>
<div class="form-group">
<label class="control-label col-sm-2" for="addr1">Street:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr1" name="addr1" placeholder="Enter Shipping street">
</div></div>
<div class="form-group">
<label class="control-label col-sm-2" for="addr2">City:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr2" name="addr2" placeholder="Enter Shipping City">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="addr3">State:</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr3" name="addr3" placeholder="Enter Shipping State">
</div>
</div><br>
<div class="form-group">
<label class="control-label col-sm-2" for="addr4">Pincode</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="addr4" name="addr4" placeholder="Enter Shipping Pincode">
</div>
</div><br>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<center><input type="submit" value="This is My Final Shipping Address"></center>
</form>
<jsp:include page="..\MainFooter.jsp"></jsp:include>
</body>
</html>