<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"--%>
	
<%@page import="com.hsbc.pojo.User"%>

<%
   
	User curruser=(User)session.getAttribute("currentUser");	
	String username=(String)curruser.getName();
	String email=(String) curruser.getEmail();
%>


<!DOCTYPE html>
<html>
<head>
	<title>Report</title>
<style>
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

/* Split the screen in half */
body {
  margin: 0;
  font-family: ALEGREYA, Helvetica, sans-serif;
}
.split {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 2;
  top: 5;
  overflow-x: hidden;
  padding-top: 20px;
  
  
}

/* Control the left side */
.left {
  
  background-image: url("images/12.gif");
  background-attachment:fixed;
  background-repeat: no-repeat;
  background-size: 50% 100%;
  color:yellow;
  position: fixed;
}

.lefttable{
	
	margin-left:95px;
	
	margin-right:40px;
	position:center-left;
	table-layout: justify;
	color:#0F0E0E;
	font-size:22px;


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
  background-image: url("images/13.jpg");
  background-size: 100% 100%;
  background-position: center;
  background-repeat: no-repeat;
  opacity: 0.25;
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
    		<a class="active">Admin</a>
    		<a  href="AddAsset.jsp" >Add Assets</a>
    		<a  href="overduetrans.jsp">Over-due Assets</a>
    		<a href="#">Import Users</a>
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
			<img src="images/user.jpg" alt="USER" style="left: 60%; width:100px; height:100px; margin-top:30px">
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br>
		<div class="left" align="left">
			<table class="lefttable">

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
		<h1 align="center" style="color:black; font-family:monospace; font-size:36" >GRAPH OF QUANTITY VS ITEM</h1>
		
			
			<div id="chartContainer" style="height: 300px; width: 100%; margin: 0 auto;">
			
			<script>
 function picture() {

document.getElementById('chartContainer').style.display='block';
document.getElementById('bttn').style.display='none';
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2",
	title:{
		text: "Number of items borrowed:"
	},
	data: [{        
		type: "line",
      	indexLabelFontSize: 16,
		dataPoints: [
			{ y: 41, indexLabel: "\u2191 DSLR",markerColor: "green", markerType: "circle" },
			{ y: 29, indexLabel: "\u2193 TV",markerColor: "green", markerType: "circle"},
			{ y: 52, indexLabel: "\u2191 Books",markerColor: "red", markerType: "triangle" },
			{ y: 23, indexLabel: "\u2193 Gaming console",markerColor: "green", markerType: "circle" },
			{ y: 45, indexLabel: "\u2191 Smart gadgets",markerColor: "green", markerType: "circle" },
			{ y: 19, indexLabel: "\u2191 Mobile phones",markerColor: "green", markerType: "circle" },
			{ y: 13, indexLabel: "\u2191 Laptos",markerColor: "green", markerType: "circle" },
			{ y: 7 , indexLabel: "\u2193 Headphones",markerColor: "black", markerType: "cross" },
		],
	}]

	
});


chart.render();



}
	
</script>
			<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<br><br><br><br><br><br><br><button onclick="picture()" id="bttn" style="display:block; margin: 0 auto; width:50%; height:20%; background-color:yellow; color:black; border-radius:8px"><b>Click here to view number of assets which have been bought....</b></button>

				
			
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