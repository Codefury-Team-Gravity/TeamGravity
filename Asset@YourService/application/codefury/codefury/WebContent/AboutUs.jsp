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






 

</style>
<body>
	<div class="header">
  		<a href="#default" class="logo"></a>
  		<div class="header-right">
    		<a class="active" href="#home">Home</a>
    		<a href="AboutUs.jsp">About</a>
    		<a href="Register.jsp">Sign Up</a>
    		<a href="login.jsp">Login</a>
  		</div>
	</div>
	
	
	<div class="logo">
		<a href="#"><img src="bg.jpg" style="width:11%;margin-left:-5px;
		margin-top:-166px;margin-bottom:15px;height:164px;  "/></a>
		<h1 style="color:white; font-size:50px;font-family:'ALEGREYA',sans-serif;
			margin-left:210px;margin-top:-130px;">asset@yourservice</h1>
	</div>
	<div class="pic">
			<div class="flip-this">
			
			<a href="#"><img src="about.jpg" style="width: 90%; height: 67%; margin-left: 75px;margin-top:3px; margin-bottom:50px;  "/></a>
			<h1 style="color:black; font-size:50px;font-family:monospace; margin-left:550px;margin-top:10px; text-decoration: underline overline red;">A  B  O  U  T &nbsp U  S</h1>
			<img src="Post.jpg" style="width: 50%;margin-left: 390px; margin-top:3px; margin-bottom:50px;  "/>
            <img src="emp.jpeg" style="width: 40%;margin-left: 450px;margin-top:3px; margin-bottom:50px;  "/>
            
			
            </div>
	</div>
		
		
		
		
		
		
		
		
         
                
		
		
		
		
		
             
	<div class="bottom">
        	<div class="col_w280">
            	
                 <p style="margin-left:440px; color:white;"class="copyright-text">Copyright &copy; 2021 All Rights Reserved by 
           <a href="#"style="color:red;">assets@yourservice pvt. ltd.</a>.
              </p></div>
	</div>
	
</body>
</html>