<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<title>Modify User Accoubt</title>
</head>
<body>
<center>Modify Your Account Details</center>
<form class="form-horizontal" action="editUser" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="userID">User ID:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="userID" value="${currentUser.userID}" disabled="disabled">
        <input type="hidden" id="uID" name="uID" value="${currentUser.userID}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="userName">User Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="userName" name="userName" value="${currentUser.userName}">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="userEmail">User Email:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="userEmail" name="userEmail" value="${currentUser.userEmail}">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="userPassword">User Password:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="userPassword" name="userPassword" value="${currentUser.userPassword}">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="userContact">User Contact:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="userContact" name="userContact" value="${currentUser.userContact}">
      </div>
    </div>
     <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</body>
</html>