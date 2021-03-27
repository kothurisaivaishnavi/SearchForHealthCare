<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
	integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
	integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<style>
body {
	text-align: center;
	background-image:url("https://www.humanitas.net/content/uploads/2017/10/medical-care.jpg");
	
}

form {
	display: inline-block;
	background:rgba(92,151,191,0.5);
	padding-right:20px;
	padding-left:20px;
	padding-top:20px;
	padding-bottom:20px;
}

.row {
	margin-top:50%;
	margin-bottom:50%;
}

header {
	height: 72px;
	background-color: skyblue;
}

a {
	color: black;
	font-weight: bold;
	text-decoration: none;
}

.space {
	padding-top: 30px;
	padding-left: 10px;
	padding-right: 10px;
}
#logo {
   padding-top:5px;
   padding-left:5px;
   padding-right:5px;
   
}

footer {
	background-color: skyblue;
	color: white;
	text-align: center;
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 30px
}
.reg{
padding-top:30px;
padding-bottom:30px;
font-weight:bold;
}

.link{
margin-right:10px;
margin-left:10px;
}
h3{
color:black;
}
.heading{
font-size: 45px;
padding-right: 210px;
padding-left:410px;
}


</style>

<title>User Home</title>
</head>

<body>
<header>
		<nav class="site-nav">
			<ul class="nav justify-content-center">
			<li><img src="https://p7.hiclipart.com/preview/395/546/561/medicine-health-care-logo-health-thumbnail.jpg"
					height=65px, width=80px id="logo"></li>
				<li  class="heading">Health Care</li>
				
				<ul class="nav nav-tabs justify-content-end space"><li class="nav-item"><a class="nav-link " aria-current="page"
					href="/">Home</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="/logout/${username}">Logout</a></li>
				
			</ul></ul>
		</nav>
	</header>
<h3>Hello,${username}.</h3>
 
	<h1>Search</h1>
	<form:form action="/search" method="POST" modelAttribute="addService">
	<table>
	<tr>
	<th>Service Name:</th>
	<td><form:select path="serviceName" required="required" class="form-control">
	 <form:option value="all" label="All"/>
	 <form:options items="${SearchName}"/>
	</form:select></td>
	<tr>
	<th> Location:</th>
	<td><form:select path="location" required="required" class="form-control">
	<form:option value="all" label="All"/>
	<form:options items="${SearchLocation}"/>
	</form:select></td>
	</tr>
	<tr>
	<th> Medical Store:</th>
	<td><form:select path="medicalStore" required="required" class="form-control">
	<form:option value="yes">Yes</form:option>
	<form:option value="no">No</form:option>
	</form:select></td>
	</tr>
	<tr>
	<th>Ambulance:</th>
	    <td><form:select path="ambulance" required="required" class="form-control">
	    <form:option value="yes">Yes</form:option>
	    <form:option value="no">No</form:option>
	    </form:select></td>
	</tr>
	<tr><td><input type="submit" value="Search" class="btn btn-success link"></td>
	<td><input type="reset" value="Reset" class="btn btn btn-danger link"></td>
	</tr>
	</table>
	</form:form>
	<footer>
		<h5>@ Healthcare Ltd | AllRight Reserved</h5>
	</footer>
</body>
</html>