<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add New Category</title>
<style>
body{
background-color:white;
background-image:url("adminbg10.jpeg");
background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
 }
.ctrtable
{
 margin-left: auto;
  margin-right: auto;
  width:120px;
height:300px;
margin-top:50px;
}
.addcategry
{
	color:black;
	font-size:40px;
	margin-top:150px;
	border:2px solid black;
	margin-left:700px;
	padding:20px;
	width:500px;
}
td {
padding-left: 20px; 
padding-top: 5px;
padding-bottom: 5px;
padding-right: 40px;
color:black;
font-size:25px;
}

.addassetbutn{
border:5px solid #C0C0C0;
font-weight: bold; 
font-size:20px;
color:black;
width:40px;
margin-left:925px;

}
</style>
</head>
<body>
<form method = "post" action="addcategory" align=center>
<div class="addcategry"><b>ADD CATEGORY</b></div><br>
		
		<table class="ctrtable">
	        
		<tr>
			<td><b>Category</b></td>
			<td><input type=text name="categoryname" id="categoryname" required></td>
		</tr>
		<!-- <tr>
			<td><b>Sub-Category</b></td>
			<td><input type=text name="subcategoryname" id="subcategoryname" required></td>
		</tr> -->
		<tr class="row2">
			<td><b>Lending Period</b></td>
			<td><input type=text name="lendingperiod" id="lendingperiod" required></td>
		
		</tr>
		
		<tr class="row2">
			<td><b>Ban Period</b></td>
			<td><input type=text name="banperiod" id="banperiod" required></td>
		</tr>
		
		<tr class="row2">
			<td><b>Fine</b></td>
			<td><input type=text name="fine" id="fine" required></td>
		</tr>
		
	</table>
	
</div>
<br>
<div class="addassetbutn">
<input type=submit value="Add"></div>
</form>
</body>