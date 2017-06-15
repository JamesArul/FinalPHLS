<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" src="Resources/Bootstrap/bootstrap.min.css">
<script src="Resources/Bootstrap/bootstrap.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<link  rel="stylesheet" href="Resources/FontAwesome/font-awesome.min.css">
<style>
.mid
{
height: 500px;
}
@font-face {
  font-family: 'Glyphicons Halflings';
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot');
  src: url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.woff') format('woff'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.ttf') format('truetype'), url('Resources/Bootstrap/fonts/glyphicons-halflings-regular.svg#glyphicons-halflingsregular') format('svg');
}
.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
 }
 .carousel {
width: 100%;
}
.carousel-inner > .item > img,
.carousel-inner > .item > a > img {
  width: 500px;
  min-height: 300px;    /* Set slide height here */
  max-height: 300px;

}
</style>
<title>Love of Wisdom</title>
</head>
<body>
<jsp:include page="MainHeader.jsp"></jsp:include>
<center><h1>Welcome to Philosophia</h1></center>
<br>
<center>${cartSuccess }</center>
<center>${msg}</center>
<br>
<div id="mid">
<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="Resources/Images/i1.jpg" width="500" height="300">
        <div class="carousel-caption">
          <h3>Largest Collection</h3>
          <p>We have the largest collection of bookss.</p>
        </div>
      </div>

      <div class="item">
        <img src="Resources/Images/i2.jpg" width="500" height="300">
        <div class="carousel-caption">
          <h3>Unbeilvable Offers</h3>
          <p>Great and Exciting Offers</p>
        </div>
      </div>
    
      <div class="item">
        <img src="Resources/Images/i3.jpg" width="500" height="400">
        <div class="carousel-caption">
          <h3>The Best Shop for You</h3>
          <p>The Shop for all Books</p>
        </div>
      </div>

      <div class="item">
        <img src="Resources/Images/i4.jpg" width="500" height="400">
        <div class="carousel-caption">
          <h3>Find your Book</h3>
          <p>Grab a book and start READING.</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</div>
<br>
<br>
<jsp:include page="MainFooter.jsp"></jsp:include>
</body>
</html>