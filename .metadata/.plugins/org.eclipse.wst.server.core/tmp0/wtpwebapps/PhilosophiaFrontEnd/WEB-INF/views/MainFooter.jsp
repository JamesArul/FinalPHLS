<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/FontAwesome/font-awesome.min.css">
<style>
@font-face {
  font-family: 'FontAwesome';
  src: url('Resources/FontAwesome/fonts/fontawesome-webfont.eot?v=4.7.0');
  src: url('Resources/FontAwesome/fonts/fontawesome-webfont.eot?#iefix&v=4.7.0') format('embedded-opentype'),
    url('Resources/FontAwesome/fonts/fontawesome-webfont.woff?v=4.7.0') format('woff'),
    url('Resources/FontAwesome/fonts/fontawesome-webfont.ttf?v=4.7.0') format('truetype');
  font-weight: normal;
  font-style: normal;
}
.navbar-fixed-bottom
{
background-color: #18767a;
<!--position : absolute; -->
position: fixed;
bottom: 0px;
width: 100%;
}
</style>
<script>
function cprdisplay()
{
	document.getElementById('mytext').innerHTML = 'Coryrights owned by James Arularasan';
}
function cntdisplay()
{
	document.getElementById('mytext').innerHTML = 'Contact @ ProjectPhilosophia.com';
}
function spnrdisplay()
{
	document.getElementById('mytext').innerHTML = 'Sponsored by JPro';
}
</script>
</head>
<body>
<br>
<br>
<br>
<footer class="navbar-fixed-bottom">
<div class="container">
<center>
<button title="Copyright" onclick="cprdisplay()"><i class="fa fa-copyright"></i></button><!-- Copyright -->
<button title="Contact" onclick="cntdisplay()"><i class="fa fa-phone"></i></button><!-- Contact -->
<button title="Our Sponsors" onclick="spnrdisplay()"><i class="fa fa-inr"></i></button><!-- Our Sponsors -->
</center>
<br>
<center><p id="mytext"></p></center>
</div>
</footer>
</body>
</html>