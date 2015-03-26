<%-- 
    Document   : loginForm
    Created on : Feb 25, 2015, 11:44:27 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML>
<html>
	<head>
		<title>ResultHome</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="CSS/style_home.css" type="text/css" media="screen">
		<link rel="stylesheet" href="CSS/Login.css" media="screen" type="text/css" />
		</head>	
	</head>
	<body>
		<div id="header_container">		
		    <div class="container">
			<!-- Header -->
			<div id="box">
			         <img src='IMAGES/du.jpg' alt='' style='width:100%; height:100%;'>
					 </div>
					<nav id="main-nav" class="8u">
						<ul>
							<li><a class="active" href="index.html">Home</a></li>
							<li><a href="examples.html">Official</a></li>
							<li><a href="apage.html">Exam Committee</a></li>
							<li><a href="anotherpage.html">Teacher</a></li>
						</ul>
					</nav>
			</div>	
        </div>
		<div id="main">
		<div id="sidebar">	
		 <img src="curzonhall.jpg" alt="" style='width:100%;height:100%;'>
        </div>	
		<div id="page-wrap">	
		 <img src="images/bangla.jpg" alt="" style='width:100%;height:100%;'>
		     <div class="login-container">
				
				  <div id="login-form">
				
					<h3>Login</h3>
				
					<fieldset>
				
					  <form action="javascript:void(0);" method="get">
				
						<input type="email" required value="Email" onBlur="if(this.value=='')this.value='Email'" onFocus="if(this.value=='Email')this.value='' "> <!-- JS because of IE support; better: placeholder="Email" -->
				
						<input type="password" required value="Password" onBlur="if(this.value=='')this.value='Password'" onFocus="if(this.value=='Password')this.value='' "> <!-- JS because of IE support; better: placeholder="Password" -->
				
						<input type="submit" value="Login">
				
						<footer class="clearfix">
				
						  <p><span class="info">?</span><a href="#">Forgot Password</a></p>
				
						</footer>
				
					  </form>
				
					</fieldset>
				
				  </div> <!-- end login-form -->
				
				</div>
        </div>	
		</div>
		<div id="footer">
		<center>
		<header  class='clearfix'>
		<h2><span>Department of Computer Science & Engineering</span></h2>
		<h2><span>Science Complex Building,2nd & 3rd floor,Mokarram Vaban</span></h2>
		<h3><span>Copyright:Department Of Computer Science & Engineering,University of Dhaka</span></h3>
		</center>
		</div>
	</body>
</html>

