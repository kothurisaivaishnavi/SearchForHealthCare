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
	align: center;
	background-image:url("https://www.humanitas.net/content/uploads/2017/10/medical-care.jpg");
	
}

form {
	display: inline-block;
	margin-top:10%;
	margin-bottom:10%;
	padding:20px;
	background:rgba(92,151,191,0.5);
}
td{
font-weight:bold;
}

.row {
	margin-top:50%;
	margin-bottom:50%;
}

header {
	height: 72px;
	background-color: skyblue;
}
table{
borer-spacing:0 5px;
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
.heading{
font-size: 45px;
padding-right: 210px;
padding-left:410px;
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

</style>

<title>Login...</title>
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
				<li class="nav-item"><a class="nav-link" href="#">About us</a></li>
				<li class="nav-item"><a class="nav-link  active"
					href="loginpage">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="userregisterpage">Register</a></li>
			</ul></ul>
		</nav>
	</header>

	<div >

		<form:form method="post" action="/login" modelAttribute="login">
			<table>
			         <tr><h2>Login</h2></tr>
				<tr>
					<td>USER Type:</td>
					<td><form:select path="type" class="form-select" aria-label="Default select example">
							<option value="admin">Admin</option>
							<option value="user">User</option>
							<option value="service">Service Provider</option>
						</form:select></td>
				</tr>
				<tr>
					<td>UserName:</td>
					<td><form:input path="username" type="text"
							required="required" class="form-control" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" type="password"
							required="required"  class="form-control" aria-describedby="passwordHelpBlock"/></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="Login" class="btn btn-success link" /></td>
				</tr>
			</table>
			<div>${msg}</div>
		</form:form>
	</div>
	<footer>
		<h5>@ Healthcare Ltd | AllRight Reserved</h5>
	</footer>
</body>
</html>