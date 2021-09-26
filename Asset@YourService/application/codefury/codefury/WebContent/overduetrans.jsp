<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="com.hsbc.pojo.User"%>

<%
   
	User curruser=(User)session.getAttribute("currentUser");	
	String username=(String)curruser.getName();
	String email=(String) curruser.getEmail();
%>
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

.header {
  overflow: hidden;
  background-color:black;
  margin-top:30px;
  padding: 0px 0px;
}

/* Style the header links */
.header a {
  float: left;
  color: white;
  text-align: center;
  padding: 30px;
  text-decoration:inherit;
  font-family:fantasy;
  font-size: 20px;
  line-height: 25px;
  border-radius: 4px;
}

/* Style the logo link (notice that we set the same value of line-height and font-size to prevent the header to increase when the font gets bigger */
.header a.logo {
  font-size: 45px;
  font-weight: bold;
}

/* Change the background color on mouse-over */
.header a:hover {
   background-color: orange;  
   color: black;
}

/* Style the active/current link*/
.header a.active {
  background-color: purple;
  color: white;
}

/* Float the link section to the right */
.header-right {
  float: right;
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
margin-top:5px;
  margin-left:20px;
  margin-right:20px;
  height: 80%;
  width: 50%;
  position: fixed;
  z-index: 2;
  top: 5;
  overflow-x: hidden;
  padding-top: 20px;
  
  
}

/* Control the left side */
.left {
  
  background-image: url("images/Laptop.gif");
  background-attachment:fixed;
  background-repeat: no-repeat;
  background-size: 50% 100%;
  
  color:yellow;
  position: fixed;
}


/* Control the right side */
.right {
	right: 0;
	background-color: #f4f3f3;

}


.right::after {
	content: "";
	background-image: url("images/el.jpg");
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
	opacity: 0.50;
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
}

ol {
	padding-left: 120px;
}









</style>


</head>
<body>

<%
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
   if(session.getAttribute("userid")==null){
	   response.sendRedirect("index.jsp");
   }

%>



	<div class="header">
  		<a href="#default" class="logo"></a>
  		<div class="header-right">
    		<a >Admin</a>
    		<a  href="AddAsset.jsp" >Add Assets</a>
    		<a class="active" href="overdueAssets.jsp">Over-due Assets</a>
    		<a  href="ImportUsers.jsp">Import Users</a>
    		<a href="ViewReport.jsp">View Reports</a>
    		<a href="index.jsp">Logout</a>
  		</div>
	</div>
	
	<div class="logo">
		<a href="#"><img src="images/log.jpg" style="width:6%;margin-left:-5px;
		margin-top:-205px;margin-bottom:15px;height:84px;  "/></a>
		<h1 style="color:white; font-size:40px;font-family:'ALEGREYA',sans-serif;
			margin-left:110px;margin-top:-80px;">asset@yourservice</h1>
	</div>
	<div class="split left">
  <div class="centered">
    <img src="images/user.jpg" alt="USER" style="left: 60%; width:100px; height:100px; margin-left:-50px;margin-top:70px";">
  </div>
  <br><br><br><br><br>
  <div class="left" align="left">
  <table class="lefttable" style="font-size:28px;width:25%;">
 
  	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">NAME</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td><%=username%></td>
  	</tr>
  	
 	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">EMAIL</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td><%=email%></td>
  	</tr>
    </table>
	</div>
</div>
	<div class="split right">
		<br> <br> <br> <br> <br>
		<h2 style="font-family:monospace;font-size:30px; " align="center">OVER DUE TRANSACTION MANAGEMENT</h2>
		<div class= "button" >
		<table align="center">
		<center>
		
	
		
		<br><br><b><input type="button" value="CLICK HERE TO VIEW DETAILS BY ID"
				onclick="location.href = 'searchById.jsp';" style="font-size:20px;color:white;background-color:green; width:50%; border-radius: 12px; height:60px;" /></b>
				
		
		<br><br><b><input type="button" value="CLICK HERE TO VIEW DETAILS BY CATEGORY"
				onclick="location.href = 'searchByCategory.jsp';" style="font-size:20px;color:white;background-color:red; width:50%; border-radius: 12px; height:60px;" /></b>
			
		
		<br><br><b><input type="button" value="CLICK HERE TO SEND MESSAGE"
				onclick="location.href = 'Sendmessage.jsp';" style="font-size:20px;color:white;background-color:blue; width:50%; border-radius: 12px; height:60px;" /></b>
				</center>
	
			
		</table>
		</div>

		<footer>
       <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            
            <p style="font-weight:bold; font-color:red; margin-top:20px;"    class="copyright-text">Copyright &copy; 2021 All Rights Reserved by assets@yourservice pvt. ltd.
           
            </p>
          </div>
	</footer>
</body>
</html>