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
  background-color:teal;
  margin-top:40px;
  padding: 40px 60px;
}
.bottom {
	overflow: hidden;
	background-color:teal;
 	
 	padding: 30px 80px;
}
/* Style the header links */
.header a {
  float: left;
  color: orange;
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
  color: orange;
}

/* Float the link section to the right */
.header-right {
  float: right;
}

/* Add media queries for responsiveness - when the screen is 500px wide or less, stack the links on top of each other */
@media screen and (max-width: 500px) {
  
.pic {
  background: transparent;
  display: inline-block;
}

   .flip-this a{
  position: relative;
  width: 100%;
  height: 100%;
  transition: transform 0.6s;
  transform-style: preserve-3d;
}

.pic:hover .flip-this a{
  transition: 0.9s;
  transform: rotateY(180deg);
}   





.form-popup {
  box-shadow:2px 3px 5px rgb(177, 159, 159);
   margin-top: 140px;
   margin-right: 20px;
  display: none;
  position: fixed;
  top: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
 
  max-width: 300px;
  padding: 10px;
  background-color: white;
  color: black;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background:#f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  border-radius:6px;
  background-color: #4d79ff/*#4CAF50*/;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
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

/*for button signup*/
.form-popup1 {
  margin-top: 110px;
  display: none;
  position: fixed;
  top: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container1 {
  max-width: 600px;
  padding: 10px;
  background-color: white;
  color: black;
}

/* Full-width input fields */
.form-container1 input[type=text], .form-container1 input[type=password], .form-container1 input[type=email]{
  width: 50%;
  padding: 15px;
  margin: 5px 0 5px 0;
  border: none;
  background:#f1f1f1;
}

/* When the inputs get focus, do something */
.form-container1 input[type=text]:focus, .form-container1 input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container1 .btn {
  background-color: #4d79ff/*#4CAF50*/;
  color: white;
  padding: 8px 10px/*16px 20px*/;
  border: none;
  cursor: pointer;
  margin-left: 80px;
  width: 50%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container1 .cancel {
  background-color: black;
}

/* Add some hover effects to buttons */
.form-container1 .btn:hover, .open-button:hover {
  opacity: 1;
} 

 

</style>
<body>
	<div class="header">
  		<a href="#default" class="logo"></a>
  		<div class="header-right">
    		<a class="active" href="#home">Home</a>
    		<a href="AboutUs.jsp">About</a>
    		<a href="Register.jsp">Sign Up</a>
    		<a href="#" onclick="openForm()">Login</a>
  		</div>
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
	
	<div class="logo">
		<a href="#"><img src="log.jpg" style="width:25%;margin-left:-5px;margin-top:-205px;height:280px;  "/></a>
	</div>
	<div class="pic">
			<div class="flip-this">
			<h2 style="color:red; font-size:25px;font-family:cursive;text-decoration: underline overline black;margin-left:750px;margin-top:150px;">You'll love to take these home</h2>
			<a href="#"><img src="books.jpg" style="width: 19%;margin-left:40px;margin-top:3px;  "/></a>
            <a href="#"><img src="laptops.png" style="width: 22%;margin-left:60px;margin-top:3px;"/></a>
            <a href="#"><img src="headphones.jpg" style="width: 24%;margin-left:60px;margin-top:3px;"/></a>
            <a href="#"><img src="phones.jpg" style="width: 20%;margin-left:70px;margin-top:3px;"/></a>
            </div>
	</div>
		
		
		<div class="pic">
			<div class="flip-this">
			<a href="#"><img src="qual.PNG" style="width: 35%;margin-left:40px;margin-top:270px;  "/></a>
            <a href="#"><img src="return.PNG" style="width: 15%;margin-left:100px;margin-top:270px;"/></a>
            <a href="#"><img src="upgrade.PNG" style="width: 27%;margin-left:190px;margin-top:270px;"/></a>
            </div>
		</div>
         
                
		
		
		
		
		
             
	<div class="bottom">
        	<div class="col_w280">
            	<h4 class="twitter">Borrow with Confidence</h4>
                 <p>Nullam luctus, eros sed pellentesque dictum, sem ex aliquet libero, nec viverra est ligula.</p>
            </div>
	</div>
	
</body>
</html>