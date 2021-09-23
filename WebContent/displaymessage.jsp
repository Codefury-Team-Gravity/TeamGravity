<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Messages</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
/* Split the screen in half */
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

footer {
	background-color: black;
	text-align: center;
	color: white;
	z-index: 22;
	left: 0;
	width: 100%;
	height: 7%;
	bottom: 0;
	position: fixed;
}

.split {
	height: 100%;
	width: 50%;
	position: absolute;
	z-index: 1;
	top: 5;
	overflow-x: hidden;
	padding-top: 20px;
}

/* Control the left side */
.left {
	left: 0;
	background-color: black;
	background-attachment:fixed;
	background-image: url("com.gif");
	background-repeat: no-repeat;
	background-size: 50% 100%;
	color: white;
	position: fixed;
}

/* Control the right side */
.right {
	right: 0;
	height: 1000px;
	background-color: #f4f3f3;
	overflow-y: scroll;
}

.right::after {
	content: "";
	background-image: url("message.jpeg");
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
	opacity: 0.20;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	position: absolute;
	z-index: -1;
}

/* If you want the content centered horizontally and vertically */
.centered {
	position: relative;
	top: 25%;
	left: 35%;
	transform: translate(5%, -50%);
	text-align: left;
}

.centered1 {
	position: relative;
	top: 15%;
	left: 15%;
	transform: translate(5%, -50%);
	text-align: left;
}
/* Style the image inside the centered container, if needed */
.centered img {
	width: 150px;
	border-radius: 65%;
}

td {
	padding-left: 80px;
	padding-top: 5px;
	padding-bottom: 5px;
	padding-right: 60px;
	color: black;
	
	
}

ol {
	padding-left: 120px;
}

.topnav {
	overflow: hidden;
	background-color: black;
	z-index: 100;
	width: 100%;
	position: fixed;
}

.topnav a {
	float: right;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 20px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color:purple;
	color: white;
}

.topnav .search-container {
	float: right;
}

.topnav input[type=text] {
	padding: 6px;
	margin-top: 8px;
	font-size: 17px;
	border: none;
}

.topnav .search-container button {
	float: right;
	padding: 6px 10px;
	margin-top: 8px;
	margin-right: 16px;
	background: #ddd;
	font-size: 17px;
	border: none;
	cursor: pointer;
}

.topnav .search-container button:hover {
	background: #ccc;
}

@media screen and (max-width: 200px) {
	.topnav .search-container {
		float: none;
	}
	.topnav a, .topnav input[type=text], .topnav .search-container button {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
	#box {
		background-color: lightgrey;
		width: 300px;
		padding: 50px;
		z-index: 200;
		color: white;
		box-sizing: border-box;
	}
}
</style>
</head>
<body>

	<div class="topnav">
	<div class="search-container">
	<form action="">
				<!--
      <input type="text" placeholder="Search.." name="search">
      <input type="submit" name="Search" value="Submit">-->
				<a href="logout">Logout</a>
			</form>
			</div>
		<a href="userReturn.jsp">Return</a>
		<a href="borrowAssets.jsp">Borrow</a>
		<a class="active" href="">Messages</a>
		<a href="UserHomepage.jsp">Home</a>
		<img src="logo.jpeg" width="40" height="40" style="margin-top:3px;margin-left:3px;">
		<a style="margin-right:10px; padding-right:1160px;">asset@yourservice</a>
			
		
	</div>
	<div class="split left">
		<div class="centered">
			<img src="back2.jpeg" alt="USER" style="left: 40%; margin-top:35px; margin-bottom:25px">
		</div>
		<br> <br> <br> <br> <br>
		<table class="left" align="left" style="color: white;">
		
			<tr>
				<td><ul>
						<li>User Name </li>
					</ul></td>
				<td>:</td>
				<td>--</td>
			</tr>
			<tr>
				<td><ul>
						<li>Employee ID</li>
					</ul></td>
				<td>:</td>
				<td>--</td>
			</tr>
			<tr>
				<td><ul>
						<li>Name</li>
					</ul></td>
				<td>:</td>
				<td>--</td>
			</tr>
			<tr>
				<td><ul>
						<li>Telephone</li>
					</ul></td>
				<td>:</td>
				<td>--</td>
			</tr>
			<tr>
				<td><ul>
						<li>Email</li>
					</ul></td>
				<td>:</td>
				<td>--</td>
			</tr>

		</table>
	</div>
	<div class="split right">

		<br> <br> <br> <br> <br>
		<h2 style="text-shadow: 4px 4px 2px #A0A0A0" align="center">Messages</h2>
		<br>
		<div class="centered1">
			<form method="post" action="display">
				Enter Userame :<input type="text" name="uname"> <br> <br>
				Enter password :<input type="password" name="password"> <br>
				<br> <input type="submit" value="Show" onclick="f1();">
			</form>
		</div>
		<br> <br> <br>
		<div
			style="color: black; padding: 50px; border: 1px solid #000 !important; margin: 100px; text-align: center;">
			<c:if test="${list.size()!=0}">
				<h1>${list}</h1>
			</c:if>
		</div>
		<form action="DisplayMessage.jsp">
			<input type="submit" value="Return">
		</form>
	</div>

	<footer>
		<p>
			<b>Copyright 2021 All Rights Reserved by asset@yourservice.</b>
		</p>
	</footer>
	
</body>
</html>