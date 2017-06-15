<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="Resources/Bootstrap/thumbnail-gallery.css">
<script src="Resources/Bootstrap/bootstrap.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<link  rel="stylesheet" href="Resources/FontAwesome/font-awesome.min.css">
<title>View Books</title>
<style>
@font-face {
  font-family: 'Glyphicons Halflings';
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot');
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.woff') format('woff'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.ttf') format('truetype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.svg#glyphicons-halflingsregular') format('svg');
}
img {
  display: block;
  max-width: 100%;
  height: auto;
}
</style>
</head>
<body>
<jsp:include page="MainHeader.jsp"></jsp:include>
 <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Books Gallery</h1>
            </div>
            <center><h3>${error }</h3></center>
            <c:forEach items="${prList}" var="pList">
            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
               <div class="thumbnail">
                    <img class="img-responsive" src="${path}${pList.productId}.jpg" alt="${pList.productName}" >
                    <c:if test="${not empty UserMsg }">
                    <center><p>${pList.productName }<br>
                    Cost : ${pList.productCost }</p></center>
                    <center>
                    <form action="addConfirmProduct">
                    <input type="hidden" id="prdAddId" name="prdAddId" value="${pList.productId}"> 
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>                  
                    <input type="submit" value="Add to Cart" class="btn btn-primary">
                    </form>
                    </center>
                    </c:if>
                    </div>
            </div>
            </c:forEach>
       </div>
  </div>
  
<jsp:include page="MainFooter.jsp"></jsp:include>
</body>
</html>