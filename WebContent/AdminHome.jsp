<!DOCTYPE html>
<html>
<head>
	<title>Admin Home</title>
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
#menu {
  background:black;
  color: #eee;
  height: 35px;
  border-bottom: 4px solid #eeeded;
  width:110px;
}

#menu ul,
#menu li {
  margin: 0 0;
  padding: 0 0;
 
  list-style: none
}

#menu ul {
  height: 35px
  
}

#menu li {
  float: left;
  display: inline;
  position: relative;
  font: bold 12px ALEGREYA;
  text-shadow: 0 -1px 0 #000;
  border-right: 1px solid #444;
  border-left: 1px solid #111;
  text-transform: uppercase
}

#menu li:first-child {
  border-left: none
}

#menu a {
  display: block;
  
  line-height: 35px;
  padding: 0 14px;
  text-decoration: none;
  color:white;
}

#menu li:hover > a,
#menu li a:hover {
  background: #111
}

#menu input {
  display: none;
  margin: 0 0;
  padding: 0 0;
  width: 80px;
  height: 35px;
  opacity: 0;
  cursor: pointer
}

#menu label {
  font: bold 30px ALEGREYA;
  display: none;
  width: 35px;
  height: 36px;
  line-height: 36px;
  text-align: center
}

#menu label span {
  font-size: 12px;
  position: absolute;
  left: 35px
}

#menu ul.menus {
  height: auto;
  width: 180px;
  background: #111;
  position: absolute;
  z-index: 99;
  display: none;
  border: 0;
}

#menu ul.menus li {
  display: block;
  width: 100%;
  font: 12px ALEGREYA;
  text-transform: none;
}

#menu li:hover ul.menus {
  display: block
}


#menu a.addassetsclass {
  padding: 0 27px 0 14px
}

#menu a.addassetsclass::after {
  content: "";
  width: 0;
  height: 0;
  border-width: 6px 5px;
  border-style: solid;
  border-color: #eee transparent transparent transparent;
  position: absolute;
  top: 15px;
  right: 9px
}

#menu ul.menus a:hover {
  background: #333;
}

#menu ul.menus .submenu {
  display: none;
  position: absolute;
  left: 180px;
  background: #111;
  top: 0;
  width: 180px;
}

#menu ul.menus .submenu li {
  background: #111;
}

#menu ul.menus .has-submenu:hover .submenu {
  display: block;
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
  
  background-image: url("laptop.gif");
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
  background-image: url("new1.jpg");
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
.topnav {
  overflow: hidden;
  background-color: black;
  z-index: 100;
  position:fixed;
  width:100%;
  height:8vh;
  margin-top: 0px;
  
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: purple;
  color: white;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
  
.addassetbox{

width:250px;
margin-top:80px;
}


.addassetbutn{
margin-left:325px;
font-weight: bold; 

}

  .site-footer
{
  background-color:#26272b;
  padding:45px 0 20px;
  font-size:15px;
  line-height:24px;
  color:#737373;
}
.site-footer hr
{
  border-top-color:#bbb;
  opacity:0.5
}
.site-footer hr.small
{
  margin:20px 0
}
.site-footer h6
{
  color:#fff;
  font-size:16px;
  text-transform:uppercase;
  margin-top:5px;
  letter-spacing:2px
}
.site-footer a
{
  color:#737373;
}
.site-footer a:hover
{
  color:#3366cc;
  text-decoration:none;
}
.footer-links
{
  padding-left:0;
  list-style:none
}
.footer-links li
{
  display:block
}
.footer-links a
{
  color:#737373
}
.footer-links a:active,.footer-links a:focus,.footer-links a:hover
{
  color:#3366cc;
  text-decoration:none;
}
.footer-links.inline li
{
  display:inline-block
}
.site-footer .social-icons
{
  text-align:right
}
.site-footer .social-icons a
{
  width:40px;
  height:40px;
  line-height:40px;
  margin-left:6px;
  margin-right:0;
  border-radius:100%;
  background-color:#33353d
}
.copyright-text
{
  margin:0
}
@media (max-width:991px)
{
  .site-footer [class^=col-]
  {
    margin-bottom:30px
  }
}
@media (max-width:767px)
{
  .site-footer
  {
    padding-bottom:0
  }
  .site-footer .copyright-text,.site-footer .social-icons
  {
    text-align:center
  }
}
.social-icons
{
  padding-left:0;
  margin-bottom:0;
  list-style:none
}
.social-icons li
{
  display:inline-block;
  margin-bottom:4px
}
.social-icons li.title
{
  margin-right:15px;
  text-transform:uppercase;
  color:#96a2b2;
  font-weight:700;
  font-size:13px
}
.social-icons a{
  background-color:#eceeef;
  color:#818a91;
  font-size:16px;
  display:inline-block;
  line-height:44px;
  width:44px;
  height:44px;
  text-align:center;
  margin-right:8px;
  border-radius:100%;
  -webkit-transition:all .2s linear;
  -o-transition:all .2s linear;
  transition:all .2s linear
}
.social-icons a:active,.social-icons a:focus,.social-icons a:hover
{
  color:#fff;
  background-color:#29aafe
}
.social-icons.size-sm a
{
  line-height:34px;
  height:34px;
  width:34px;
  font-size:14px
}
.social-icons a.facebook:hover
{
  background-color:#3b5998
}
.social-icons a.twitter:hover
{
  background-color:#00aced
}
.social-icons a.linkedin:hover
{
  background-color:#007bb6
}
.social-icons a.dribbble:hover
{
  background-color:#ea4c89
}
@media (max-width:767px)
{
  .social-icons li.title
  {
    display:block;
    margin-right:0;
    font-weight:600
  }
}
.topnav a {
  float:right;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  
}
/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}
section h1 span{
    opacity: 0;
    display: inline-block; animation: animate 1s linear forwards;
}
@keyframes animate
{
    
    0%
    {
        opacity: 0;
        transform:rotateY(90deg);
        filter: blur(10px);
    }
    100%
    {
        opacity: 1;
        transform:rotateY(0deg);
        filter: blur(0px);
    }
}



</style>
</head>
<body>

<div class="topnav" style="color:white; font-size:20">

  <a href="logout" class="logoutbtn"><b>Logout<b></a> 
  <a href="#"><b>View Reports</b></a>
  <a href="#"><b>Import User</b></a>
  <a href="overdueTransactionManagement.jsp"><b>Over-due Assets</b></a>
  <a class="active" href="AddNewAsset.html"><b>Add Assets</b></a>
  <a href="AdminHome.jsp"><b>Admin Home</b></a>
  <img src="bg.jpg" width="50" height="54" style="margin-top:3px;margin-left:3px;">
  <a style="margin-right:555px">asset@yourservice</a>
    
  </div>

<div class="split left">
  <div class="centered">
    <img src="user.jpg" alt="USER" style="left: 60%; width:100px; height:100px; margin-top:20px";">
  </div>
  <br><br><br><br><br>
  <div class="left" align="left">
  <table class="lefttable" style="font-size:28px;">
 
  	<tr>
  		<td><ul><b>Name</b></ul></td>
  		
  		
  	</tr>
  	
 	<tr>
  		<td><ul><b>Email</b></ul></td>
  		
  		
  	</tr>
    </table>
	</div>
</div>


<div class="split right">
  <br><br><br><br><br>
    <h2 align="center" style="color:#000000; font-size:32;">---WELCOME ADMIN---</h2><br><br><br>
    <p align="center">
    <article style="margin-top: 5px; margin-left: 245px;">
                        <div  class="slideshow-container">
                    
                            <div class="mySlides fade">
                              <!-- <div class="numbertext">1 / 3</div> -->
                              <img src="m1.jpg" style="width:55%; height:28%;">
                              <!-- <div class="text">Caption Text</div> -->
                            </div>
                            
                            <div class="mySlides fade">
                              <!-- <div class="numbertext">2 / 3</div> -->
                              <img src="m2.jpg" style="width:55%; height:28%;">
                              <!-- <div class="text">Caption Two</div> -->
                            </div>
                            
                            <div class="mySlides fade">
                                <!-- <div class="numbertext">2 / 3</div> -->
                                <img src="m4.jpg" style="width:55%; height:28%;">
                                <!-- <div class="text">Caption Two</div> -->
                              </div>
                              
                       
                            </div>
                            <br>
                            
                            <div style="text-align:center">
                              <span class="dot"></span> 
                              <span class="dot"></span> 
                              <span class="dot"></span> 
                            </div>
                    </article>
                    </p><br><br>
                    <p style="color: black; margin-bottom:10px; font-size:25" align="center">Making good, BETTER!</p>
					
</div>

<footer>
        <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright &copy; 2021 All Rights Reserved by asset@yourservice.
            </p>
          </div>

          <div class="col-md-4 col-sm-6 col-xs-12">
            <ul class="social-icons">
              <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
              <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
              <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
              <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>   
            </ul>
          </div>
        </div>
      </div>
</footer>
<script>
        var slideIndex = 0;
        showSlides();
        
        function showSlides() {
          var i;
          var slides = document.getElementsByClassName("mySlides");
          var dots = document.getElementsByClassName("dot");
          for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";  
          }
          slideIndex++;
          if (slideIndex > slides.length) {slideIndex = 1}    
          for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
          }
          slides[slideIndex-1].style.display = "block";  
          dots[slideIndex-1].className += " active";
          setTimeout(showSlides, 2000); // Change image every 2 seconds
        }
        </script>
</body>
</html>