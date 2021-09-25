<%@page import="com.hsbc.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--a set of assets/WebContent/WEB-INF/UserHomepage.html-->

<%-- <%
   
	User curruser=(User)session.getAttribute("currentUser");	
	String username=(String)curruser.getName();
	String email=(String) curruser.getEmail();
%> --%>


<!DOCTYPE html>
<html>
<head>
	<title>Admin Home</title>
<style>


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


	/* Split the screen in half */
body {
  margin: 0;
  font-family: ALEGREYA, Helvetica, sans-serif;
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

.lefttable{
	margin-top:40px;
	margin-left:95px;
	margin-bottom:20px;
	margin-right:40px;
	position:left;
	table-layout: justify;
	color:#0F0E0E;


}
td {

color:black;
padding-left: 80px; 
padding-top: 5px;
padding-bottom: 5px;
padding-right: 60px;
}

/* Control the right side */
.right {
  right: 0;
  background-color: #f4f3f3;
}

.right::after {
  content: "";
  background-image: url("images/new1.jpg");
  background-size: 100% 90%;
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
  top: 20%;
  left: 40%;
  transform: translate(5%, -50%);
  text-align: left;
}

/* Style the image inside the centered container, if needed */
.centered img {
  width: 150px;
  border-radius: 70%;
}


</style>
</head>
<body>

<%--
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
   if(session.getAttribute("userid")==null){
	   response.sendRedirect("index.jsp");
   }

--%>



<div class="header">
  		<a href="#default" class="logo"></a>
  		<div class="header-right">
    		<a >Admin</a>
    		<a  href="AddAsset.jsp" >Add Assets</a>
    		<a  href="overdueAssets.jsp">Over-due Assets</a>
    		<a class="active" href="ImportUsers.jsp">Import Users</a>
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
  		<td><%-- <%=username%> --%></td>
  	</tr>
  	
 	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">EMAIL</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td><%-- <%=email%> --%></td>
  	</tr>
    </table>
	</div>
</div>

<div class="split right">
	<br><br><br><br><br>
    <h2 style="font-family:monospace;font-size:30px; " align="center">IMPORT USERS</h2><br><br><br>
	<form method="post" onclick="validate()" action="importuser">

			<h2 style=margin-left:50px; align="center"> Select a file to upload:</h2>
        	<form enctype="multipart/form-data" method="post" align="center">
			<input type="file" name="jsonFile" style="margin-top:30px;margin-left:400px;">
			<input type="submit" value="Upload File" style="margin-left:450px;margin-top:30px;">
			</form>
			<br> <br>
			</form>
			
			
			<%-- <%
			String str = (String)session.getAttribute("result");
			pageContext.setAttribute("str", str);
			%> --%>
			
			<h3>${str }</h3>
			<br> <br>
		<form align="center">
			<input type="button" value="Back to Home" style=margin-left:50px;
				onclick="location.href = 'AdminHome.jsp';" />
		</form>

</div>

<footer>
       <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            
            <p style="font-weight:bold; font-color:red; margin-top:20px;"    class="copyright-text">Copyright &copy; 2020 All Rights Reserved by assets@yourservice pvt. ltd.
           
            </p>
          </div>
	</footer>

</body>
</html>