
<html lang="en">
  <head>
  	<title>Sign Up!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" >
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  </head>
  <style type="text/css">
  *
{
margin: 0;
padding: 0;
box-sizing:border-box;
font-family:'ALEGREYA',sans-serif
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



    
  </style>
  

  <body style=" background-image:url('images/bg1.jpg');background-repeat: no-repeat;background-size: cover;">
    <div class="header">
  		<a href="#default" class="logo"></a>
  		<div class="header-right">
    		<a class="active">Register</a>
    		<a  href="index.jsp" >Home</a>
    		<a  href="AboutUs.jsp">About</a>
  		</div>
	</div>
	
	<div class="logo">
		<a href="#"><img src="images/log.jpg" style="width:6%;margin-left:-5px;
		margin-top:-80px;margin-bottom:15px;height:80px;  "/></a>
		<h1 style="color:white; font-size:40px;font-family:'ALEGREYA',sans-serif;
			margin-left:110px;margin-top:-70px;">asset@yourservice</h1>
	</div>
	
	
    <div class="container-fluid" style="margin-top:-30px;margin-bottom:60px;color:#34495E">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-4" style="margin-left:500px; margin-top:55px">
          <center>
		  <div class="card">
            
		
            <div class="card-body" style="box-shadow: 0 10px 12px 0 rgba(112, 103, 103, 0.7)">
              
              <h2><b>SIGN UP</b></h2><br>
			  
              <form align="center" class="form-group" method="post" action="registration">
                <div class="row">
                  <div class="col-md-5"><label>NAME: </label></div>
                  <div class="col-md-7"><input type="text" name="name" class="form-control" placeholder="enter name" required/></div><br><br><br>


                  <div class="col-md-5"><label >ROLE </label></div>
                  <div class="col-md-7" style="margin-left: 100px;margin-top:-30px;"><input type="radio" required
                    id="User" name="role" value="User"}>
                  <label for="User" style="text-align: center;">User</label>
                  <div class="col-md-8"></div><input type="radio" id="Admin" name="role" value="Admin">
                  <label for="Admin">Admin</label></div><br><br><br>


                  <div class="col-md-5"><label>TELEPHONE: </label></div>
                  <div class="col-md-7"><input pattern ="^\s*(?:\+?(\d{1,3}))?[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?\s*$"class="form-control" name="telephone" placeholder="enter telephone" required/></div><br><br><br>
                  <div class="col-md-5"><label>EMAIL(abc@xyz.com)</label></div>
                  <div class="col-md-7"><input type="email"  class="form-control" name="email" placeholder="enter email" required/></div><br><br><br>
                  <div class="col-md-5"><label>USERNAME: </label></div>
                  <div class="col-md-7"><input type="text" class="form-control" name="username" placeholder="enter username" required/></div><br><br><br>
                  <div class="col-md-5"><label>PASSWORD: </label></div>
                  <div class="col-md-7"><input type="password" class="form-control" name="password" placeholder="enter password" required/></div><br><br><br>
                  <div class="col-md-5"><label>CONFIRM PASSWORD: </label></div>
                  <div class="col-md-7"><input type="password" class="form-control" name="conpass" placeholder="confirm password" required/></div><br><br><br>
				  
                </div>
				
                <center><input type="submit" id="inputbtn" name="login_submit" value="SIGN UP" class="btn btn-primary">
              </form>
            
            </div>
          </div>
		  
        </div>
		</center>
         <div class="col-md-7"></div>
      </div>
    </div>

  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  
  
  <footer>
       <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            
            <p style="font-weight:bold; margin-right:-450px;font-color:red;margin-top:20px;"class="copyright-text">Copyright &copy; 2020 All Rights Reserved by assets@yourservice pvt. ltd.
           
            </p>
          </div>
	</footer>
  
  
  
  </body>