<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login </title>
    <meta charset='utf-8'>
    <link rel='stylesheet' href='CSS/style_home.css' type='text/css' media='screen' />
    <link rel='stylesheet' href='CSS/Login.css' media='screen' type='text/css' />
    
</head>	
    <body>
	<div id='header_container'>		
            <div class='container'>
			<!-- Header -->
                <div id='box'>
                    <img src='IMAGES/du.jpg' alt='' style='width:100%; height:100%;'>
                </div>
                <nav id='main-nav' class='8u'>
                    <ul>
                      <li><a class='active' href='home'>Home</a></li>
		      <li><a href='login?pagename=official'>Official</a></li>
		      <li><a href='login?pagename=committee'>Exam Committee</a></li>
		      <li><a href='login?pagename=teacher'>Teacher</a></li>
                    </ul>
                </nav>
	    </div>	
        </div>
	<div id='main'>
	<div id='sidebar'>	
	<img src='IMAGES/curzonhall.jpg' alt='' style='width:100%;height:100%;'>
        </div>	
	    <div id='page-wrap'>	
	        <img src='IMAGES/bangla.jpg' alt='' style='width:100%;height:100%;'>
		    <div class='login-container'>
			<div id='login-form'>
			    <h3>Login</h3>
				<fieldset>
				<form action='login?pagename=login' method='post'>
                                  <span class="text-danger">${loginError}</span>
                                 <input type='email' name='email' required value='Email' onBlur='if(this.value=='')this.value='Email'' onFocus='if(this.value=='Email')this.value='' '/> <!-- JS because of IE support; better: placeholder='Email' -->
                                 <input type='password' name='password' required value='Password' onBlur='if(this.value=='')this.value='Password'' onFocus='if(this.value=='Password')this.value='' '/> <!-- JS because of IE support; better: placeholder='Password' -->
                                <%
                                    String view ="<input type='hidden' name='who' value='"+request.getAttribute("pagename")+"'/>";
                                    out.println(view);
                                %>
                                <input type='submit' value='Login'>
				
				<footer class='clearfix'>
				<p><span class='info'>?</span><a href='#'>Forgot Password</a></p>
				</footer>
				</form>
				</fieldset>
		        </div> <!-- end login-form -->
		    </div>
            </div>	
	</div>
	<div id='footer'>
	Department of Computer Science & Engineering
         </br>
	Science Complex Building,2nd & 3rd floor,Mokarram Vaban
	</div>
	</body>
</html>

