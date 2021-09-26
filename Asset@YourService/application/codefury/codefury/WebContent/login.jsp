<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">

.header {
  overflow: hidden;
  background-color:black;
  margin-top:40px;
  padding: 40px 60px;
}
.bottom {
	overflow: hidden;
	background-color:black;
 	
 	padding: 30px 80px;
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



.form-popup {
  	box-shadow:2px 3px 5px rgb(177, 159, 159);
   	margin-top:-20px;
   	margin-right: 500px;
  	margin-left: 580px;
  	top: 0;
  	right: 15px;
  	border: 3px solid #f1f1f1;
  	z-index: 9;
  	
}
 .form-container {
 
  max-width: 600px;
  padding: 100px;
  background-color:white;
  color: black;
}
  .form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 25px;
  margin: 15px 0 42px 0;
  border: thin;
  background:#f1f1f1;
}

  .form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  border-radius:10px;
  background-color: #4d79ff/*#4CAF50*/;
  color: white;
  padding: 26px 10px;
  border: thick;
  cursor: pointer;
  width: 100%;
  float:centre;
  margin-bottom:40px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}

.bottom {
	overflow: hidden;
	background-color:black;
 	margin-top:100%;
 	padding: 30px 80px;
}


</style>

<body>
<div class="header">
  		<a href="#default" class="logo"></a>
  		<div class="header-right">
    		<a class="active" href="index.jsp">Back</a>
    		
    		
  		</div>
	</div>
	
	
	<div class="logo">
		<a href="#"><img src="images/log.jpg" style="width:11%;margin-left:-5px;
		margin-top:-205px;margin-bottom:15px;height:164px;  "/></a>
		<h1 style="color:white; font-size:50px;font-family:'ALEGREYA',sans-serif;
			margin-left:210px;margin-top:-130px;">asset@yourservice</h1>
	</div>
	
<div class="form-popup" id="myForm" >
         <form method="post" action="login" class="form-container">
           <h1 style="text-align: center;">LOGIN</h1><br><br>

           <label for="username"><b>User Name</b></label>
           <input type="text" placeholder="Enter User Name" name="username" required>

           <label for="psw"><b>Password</b></label>
           <input type="password" placeholder="Enter Password" name="password" required>

           <button type="submit" class="btn" onclick="login.jsp">Login</button>
           <button type="submit" class="btn cancel" onclick="closeForm()">Close</button>
         </form>
       </div>   
       </div>  
       
	
</body>
</html>