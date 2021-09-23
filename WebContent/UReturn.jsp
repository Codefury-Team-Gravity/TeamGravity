<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
padding-bottom: 15px;
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
  margin-right:-1000px;
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

	<div class="header">
  		<a href="#default" class="logo"></a>
  		<div class="header-right">
    		<a  href="UserHome.jsp">User</a>
    		<a href="UBorrow.jsp">Borrow</a>
    		<a class="active" href="UReturn.jsp">Return</a>
    		<a href="#">Messages</a>
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
  		<td></td>
  	</tr>
  	<tr>
  		<td><ul><li style="font-size:20px; font-family:fantasy;color:black;">EMPLOYEE ID</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td></td>
  	</tr>
  	<tr>
  		<td><ul><li style="font-size:20px; font-family:fantasy;color:black;">NAME</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td></td>
  	</tr>
  	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">TELEPHONE</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td></td>
  	</tr>
 	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">E-MAIL</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td></td>
  	</tr>         
    </table>
    
    
    <div class="split right">
	<br><br><br><br><br>
    <h2 style="text-shadow: 4px 4px 2px #A0A0A0" align="center">Return items</h2><br><br><br>
   	<p align="center">
    <!--<a href="" onclick="window.open('userLogin.html', 'Return', 'width=2000,height=2000')">return</a>-->
    <!-- <form method = "get" action = "userReturn.jsp">
         <input type = "button" value = "Return" onclick = "getConfirmation();" align="center">
     </form>  -->
     
     <table border="2" style="height: 100%;">
		<tr>
			<th style="font-size:20px;">Transaction ID</th>
			<th style="font-size:20px;">User ID</th>
			<th style="font-size:20px;">Asset ID</th>
			<th style="font-size:20px;">Issue Date</th>
			<th style="font-size:20px;">Due Date</th>
			<th style="font-size:20px;">Borrow Status</th>
			<th style="font-size:20px;">Return Item</th>
			<th style="font-size:20px;">Pay Fine</th>
		</tr>
		
		
		
		<%-- <c:forEach items="${assets}" var="con">
			<tr>
				<td>${con.transactionId}</td>
				<td>${con.userId}</td>
				<td>${con.assetId}</td>
				<td>${con.issueDate}</td>
				<td>${con.dueDate}</td>
				<td>${con.borrowStatus}</td>
				<td><a href = "ReturnAssetServlet?userid=${con.userId}">Delete</a></td>
			</tr> 
		</c:forEach>--%>
	</table>
  </p>
</div>
    
    
    
	
	<!--  <foo> 
          <div class="col">
            <p style="margin-top:400px;">
            </p>
          </div>
         </foo>-->
	
	<footer>
       <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            
            <p style="font-weight:bold; font-color:red;"    class="copyright-text">Copyright &copy; 2020 All Rights Reserved by assets@yourservice pvt. ltd.
           
            </p>
          </div>
	</footer>
	
	
	
	
	
	
	
	
	
</body>
</html>