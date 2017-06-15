<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<script src="Resources/Bootstrap/bootstrap.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="Resources/AngularJS/angular.min.js"></script>
<script type="text/javascript" src="Resources/AngularJS/angular-messages.js"></script>
<script type="text/javascript">
function validateRegForm()
{
	var x = document.forms["RegForm"]["uId"].value;
    if (x == "" || x.length <= 5) {
        alert("Id must be filled properly");
        return false;	
    }
    var y = document.forms["RegForm"]["uName"].value;
    if (y == "" || y.length <= 7 ) {
        alert("Name must be filled");
        return false;	
    }
    var z = document.forms["RegForm"]["uPwd"].value;
    if (z == "" || z.length <= 7) {
        alert("Password must be filled");
        return false;	
    }
    var e = document.forms["RegForm"]["uEmail"].value;
    if (e == "") {
        alert("Password must be filled");
        return false;	
    }
    var c = document.forms["RegForm"]["uContact"].value;
    if (c == "" || c.length <= 9) {
        alert("Password must be filled");
        return false;	
    }
    return true;
}
</script>
<script type="text/javascript">
var validationApp = angular.module('validationApp', []);

// create angular controller
validationApp.controller('mainController', function($scope) {

	// function to submit the form after all validation has occurred			
	$scope.submitForm = function() {

		// check to make sure the form is completely valid
		if ($scope.userForm.$valid) {
			alert('our form is amazing');
		}

	};

});
</script>
<style>
input.ng-invalid {
    background-color: pink;
}
input.ng-valid {
    background-color: lightgreen;
}
</style>
</head>
<body>
<div ng-app="validationApp" ng-controller="mainController">
<jsp:include page="MainHeader.jsp"></jsp:include>
<center><p>Enter the User Details</p>
<form:form class="form-horizontal" name="RegForm" method="post" action="addUser" modelattribute="user" onsubmit="return validateRegForm()" novalidate="novalidate">
<div class="form-group" ng-class="{ 'has-error' : RegForm.userID.$invalid && !RegForm.userID.$pristine }">
<label class="control-label col-sm-2" for="uId">Enter ID:</label>
<div class="col-sm-10">
<form:input class="form-control" id="uId" path="userID" name="userID" ng-model="userID" ng-minlength="5" ng-maxlength="10"/>
<p ng-show="RegForm.userID.$error.minlength" class="help-block">UserID is too short.</p>
<p ng-show="RegForm.userID.$error.maxlength" class="help-block">UserID is too long.</p>
<form:errors  path="userID" />
</div>
</div>
<div class="form-group" ng-class="{ 'has-error' : RegForm.userName.$invalid && !RegForm.userName.$pristine }">
<label class="control-label col-sm-2" for="uName">Enter your Name:</label>
<div class="col-sm-10">
<form:input class="form-control" id="uName" path="userName" name="userName" ng-model="userName" ng-minlength="4" ng-maxlength="25"/><form:errors  path="userName" />
<p ng-show="RegForm.userName.$error.minlength" class="help-block">UserName is too short.</p>
<p ng-show="RegForm.userName.$error.maxlength" class="help-block">UserName is too long.</p>
</div>
</div>
<div class="form-group" ng-class="{ 'has-error' : RegForm.userEmail.$invalid && !RegForm.userEmail.$pristine }">
<label class="control-label col-sm-2" for="uEmail">Enter your Email</label>
<div class="col-sm-10">
<form:input type="email" class="form-control" id="uEmail" path="userEmail" name="userEmail" ng-model="userEmail"/><form:errors  path="userEmail" />
<p ng-show="RegForm.userEmail.$invalid && !userForm.userEmail.$pristine" class="help-block">Enter a valid email.</p>
</div>
</div>
<div class="form-group" ng-class="{ 'has-error' : RegForm.userPassword.$invalid && !RegForm.userPassword.$pristine }">
<label class="control-label col-sm-2" for="uPwd">Password</label>
<div class="col-sm-10">
<form:password class="form-control" id="uPwd" path="userPassword" name="userPassword" ng-model="userPassword" ng-minlength="7" ng-maxlength="25"/><form:errors  path="userPassword" />
<p ng-show="RegForm.userPassword.$error.minlength" class="help-block">Password is too short.</p>
<p ng-show="RegForm.userPassword.$error.maxlength" class="help-block">Password is too long.</p>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="uContact">Contact</label>
<div class="col-sm-10">
<form:input class="form-control" id="uContact" path="userContact"/><form:errors  path="userContact" />
</div>
</div>
<input type="submit" value="Register" ng-disabled="RegForm.$invalid">
</form:form>
</center>
<br>
<br>
<br>
</div>
<jsp:include page="MainFooter.jsp"></jsp:include>
</body>
</html>