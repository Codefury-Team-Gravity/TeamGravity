<%@page import="java.util.Date"%>
<%@page import="com.hsbc.pojo.User"%>
<%@page import="java.util.*"%>

<%@page import="com.hsbc.service.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%
	List<String> listOfAssetTypes = new ArrayList<String>();
//System.out.println("size of array list after creating: " + size);
CategoryService cs = CategoryServiceFactory.getCategoryServiceImplObject() ;
listOfAssetTypes = cs.getAllCategory();//get assets under a category
int size = listOfAssetTypes.size();
%> 


<!DOCTYPE html>
<html>
<head>
	<title>Add Assets</title>
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
  
  background-image: url("/portal_content/images/Laptop.gif");
  background-attachment:fixed;
  background-repeat: no-repeat;
  background-size: 50% 100%;
  color:yellow;
  position: absolute;
}


td {

color:black;
padding-left: 80px; 
padding-top: 5px;
padding-bottom: 20px;
padding-right: 60px;
}

/* Control the right side */
.right {
  right: 0;
  background-color: #f4f3f3;
}

.right::after {
  content: "";
  background-image: url("images/addassets.jpg");
  background-size: 50% 90%;
  background-position: center;
  background-repeat: no-repeat;
  opacity: 0.30;
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

.addassetbox{

width:250px;
margin-top:80px;
}


.addassetbutn{
margin-left:325px;
font-weight: bold; 

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
    		<a  href="AdminHome.jsp">Admin</a>
    		<a  class="active" >Add Assets</a>
    		<a  href="overduetrans.jsp">Over-due Assets</a>
    		<a href="ImportUsers.jsp">Import Users</a>
    		<a href="ViewReport.jsp">View Reports</a>
    		<a href="index.jsp">Logout</a>
  		</div>
	</div>
	
	<div class="logo">
		<a href="#"><img src="../../images/log.jpg" style="width:6%;margin-left:-5px;
		margin-top:-205px;margin-bottom:15px;height:84px;  "/></a>
		<h1 style="color:white; font-size:40px;font-family:'ALEGREYA',sans-serif;
			margin-left:110px;margin-top:-80px;">asset@yourservice</h1>
	</div>

<div class="split left">
  <div class="centered">
    <img src="images/user.jpg" alt="USER" style="left: 60%; width:100px; margin-top:90px; margin-left:-80px;">
  </div>
  <br><br><br><br>
  <div class="left" align="left">
  <table class="lefttable" style="font-size:25px; width:30%;">
  
  <% User user = (User)session.getAttribute("currentUser");
  	String name = user.getName();
  	String email = user.getEmail();
  	//Date lastLogin = user.getLastLoginTime();
  	%>
  	
 
  
  
 
  	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">NAME</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td><%=name%></td>
  	</tr>
  	
 	<tr>
  		<td><ul><li style="font-size:20px;font-family:fantasy;color:black;">EMAIL</li></ul></td>
  		<td style="color:black;font-size:40px;">:</td>
  		<td><%=email%></td>
  	</tr>
	

    </table>
	</div>
</div>

<div class="split right" style="position:absolute">
	<br><br><br>
    <h1 style="text-shadow: 4px 4px 2px #A0A0A0" align="center" >Add Assets</h1><br><br><br>
   	<div class="addassetbox">
<form method = "post" action = "addasset">
					<table class="righttable">
					<tr>
					<td><b>Category</b></td>
					
					<td><select name="category" id="newcategory">
								<option>Category</option>
									
								<%
									for (int i = 0; i < size; i++) {
								%>
								<option value="<%=listOfAssetTypes.get(i)%>">
									<%=listOfAssetTypes.get(i)%>
								</option>
								<%
									}
								%>
						<input type="button" value="Add New Category"onclick="location.href = 'AddNewCategory.jsp';" style="font-size:15px;color:black; background-color:yellow;margin-left:9px;" />
								
						</select></td>	
					</tr>
					

					<tr>
						<td style="width: 20px; font-size: 18px;"><b>Sub-Category<b></td>
						<td><input type="text" name="subcategory" required
							style="height: 30px; width: 200px;"></td>
					</tr>


	<td required>

	<tr>
		<td style="width:20px;font-size:18px;"><b>Description<b></td>
		<td>
			<textarea name="description"  rows="5" cols="35" required>
			</textarea>
		</td>
	</tr>
</table>
<br>
<div class="addassetbutn">
<b><input type= submit value="Add Asset" style="color:white; background-color:blue"><b>
</div>
</form>
</div>

</div>
<footer>
       <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            
            <p style="font-weight:bold; font-color:red; margin-top:20px;margin-left:150px;" class="copyright-text">Copyright &copy; 2021 All Rights Reserved by assets@yourservice pvt. ltd.
           
            </p>
          </div>
	</footer>
</body>
</html>