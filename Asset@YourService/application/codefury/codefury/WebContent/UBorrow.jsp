<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,java.util.List,java.io.*,java.util.*,
	com.hsbc.*, com.hsbc.pojo.*"%>

<%@ page import="com.hsbc.pojo.User" %>
<%
	
	User curruser=(User)session.getAttribute("currentUser");	
	String username=(String)curruser.getUserName();
	String empid=curruser.getUserId()+"";
	String name=(String)curruser.getName();
	String email=(String) curruser.getEmail();
	String telephone=(String)curruser.getPhoneNumber();

%>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<style type="text/css">



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
  font-size: 28px;
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

td {

padding-left: 80px; 
padding-bottom: 13px;
padding-right: 60px;
}


.split {
  margin-top:5px;
  margin-left:20px;
  width: 45%;
  position: absolute;
  z-index: 1;
  top: 5;
  padding-top: 10px;
  
}


.right {
  right: 0;
  margin-right:-900px;
  margin-top:-250px;
  overflow-x: visible;
  color:black;
  width:100%;
  height:100px;
}



/* Control the left side */
.left {
  left: 0;
  background-color: pink;
  background-image: url("spacedot.gif");
  background-repeat: no-repeat;
  background-size: 100% 100%;
  color: white;
}

footer {
  background-color:black;
  text-align: center;
  color: white;
  left: 0;
  width: 100%;
  height: 7%;
  bottom: 0;
  position: fixed;
}

</style>

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
    		<a  href="UserHome.jsp">User</a>
    		<a class="active" href="#">Borrow</a>
    		<a  href="UReturn.jsp">Return</a>
    		<a href="displayMessage.jsp">Messages</a>
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
   <img src="images/userlogo.PNG" alt="USER" style="margin-left: 250px; width:30%;">
  </div>
  <br><br><br><br><br>
	
	
	
	
	
	<table class="left" align="left">
    <tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">USER NAME</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td style="font-size:20px; font-family:fantasy;color:black;"><%=username%></td>
  	</tr>
  	<tr>
  		<td><ul><li style="font-size:20px; font-family:fantasy;color:black;">EMPLOYEE ID</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td style="font-size:20px; font-family:fantasy;color:black;"><%=empid%></td>
  	</tr>
  	<tr>
  		<td><ul><li style="font-size:20px; font-family:fantasy;color:black;">NAME</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td style="font-size:20px; font-family:fantasy;color:black;"><%=name%></td>
  	</tr>
  	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">TELEPHONE</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td style="font-size:20px; font-family:fantasy;color:black;"><%=telephone%></td>
  	</tr>
 	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">E-MAIL</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td style="font-size:20px; font-family:fantasy;color:black;"><%=email%></td>
  	</tr>         
    </table>
    
    
    <div class="split right">
  <br><br><br><br><br>
    <h2 style="text-shadow: 4px 4px 2px #A0A0A0" align="center">Available Assets </h2><br>
    <p align="center">You can choose from the variety of assets available <br>exclusively for your comfort at a single click..</p><hr><br>
<%
// AssetDao dao=new AssetDao();
int userid = (Integer)session.getAttribute("userid");
// ArrayList<Asset> assetList= (ArrayList<Asset>)dao.getLendableAssets(userid);
List<Asset> assetList= (List<Asset>) session.getAttribute("asset");
pageContext.setAttribute("asset",assetList);
System.out.println(assetList); // Debugging purpose
%>
<table border=5>
		<tr>
			<th>Asset ID</th>
			<th>Category</th>
			<th>Sub-Category</th>
			<th>Feature Description</th>
			<th>Date Added</th>
			<th>Available</th>
			<th>Borrow</th>
		</tr>
		<tr>
			<th>109</th>
			<th>Camera</th>
			<th>Nikon camera</th>
			<th>Takes high definition pictures</th>
			<th>2021-09-26</th>
			<th>Yes</th>
			<th><input type="checkbox" name="assetIdToBorrow" >   
			<input type="submit" value="Borrow"></th>
		</tr>	
		
	<!-- 	<c:forEach var="a" items="${asset}">
		<tr>
				<td>${a.assetId}</td>
				<td>${a.category}</td>
				<td>${a.subcategory}</td>
				<td>${a.featureDescription}</td>
				<td>${a.dateAdded}</td>
				<td>${a.isAvailable}</td>
				<td>
					<form method="get" action="borrowAssetServlet">
				 	<input type="checkbox" name="assetIdToBorrow" value="${a.assetId}">   
					<input type="submit" value="Borrow">
					</form>	
				</td>
				<td><a href="borrowAssetServlet?borrowing=yes&assetIdToBorrow=${a.assetId}">Borrow</a></td>  
		</tr>
		</c:forEach>
		-->
		</table>
		<hr>
</div>
	
	<footer>
       <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            
            <p style="font-weight:bold; font-color:red;"    class="copyright-text">Copyright &copy; 2021 All Rights Reserved by assets@yourservice pvt. ltd.
           
            </p>
          </div>
	</footer>
	
	
	
	
	
	
	
	
	
</body>
</html>