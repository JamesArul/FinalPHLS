<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error encountered</title>
</head>
<body>
<jsp:include page="MainHeader.jsp"></jsp:include>
<center><h1>Error</h1></center>
<center><h2>${error}</h2></center>
<p>${errorMsg}</p>
<jsp:include page="MainFooter.jsp"></jsp:include>
</body>
</html>