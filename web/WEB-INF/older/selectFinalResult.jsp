<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page  import="java.util.Date" %>
<%@page import="java.util.Calendar" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Select Final Result</title>
<meta charset='utf-8'>
<link rel='stylesheet' href='CSS/screen.css' type='text/css' media='screen'>
<link rel='stylesheet' href='CSS/style.css' type='text/css' media='screen'>
</head>
<body>
<div class='container'>
  <!--centers the content between from header to footer-->
  <header  class='clearfix'>
 <img src='IMAGES/du.jpg' alt='' style='width=200px; height=300px; position:relative;left:50%;top:50%;margin-left:-100px;margin-right:-150px;'>
  <center> <h1 style='position: relative;'><span>CSEDU </span> RESULT</h1></center>
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Select Result Options: </p>
	 <center>
	 <div id='contact_form2'>
	  <form method='post' action='#'>
		
		  <label> Session:</label>  <select id='xm_session' name='session' class='select'/>
                  <%
                      int y =java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                      String yr="";
                      for(int i=-5;i<=5;i++)
                      {
                          yr+="<option value='"+(y+i)+"-"+(y+i+1)+"'>"+(y+i)+"-"+(y+i+1)+"</option>";
                      }
                      yr+= "</select>";
                      out.print(yr);
                  %>
		 
		 
		
		 <div class='cleaner_h10'></div>
		 <label> Batch: </label> <select id='batch' name='batch' class='select' />
		 <option value='17'>17th</option>
		 <option value='18'>18th</option>
		 <option value='19'>19th</option>
		 <option value='20'>20th</option>
		 <option value='21'>21st</option>
		 </select>
		 
		 <div class='cleaner_h10'></div>
		<label>Year:</label>  <select id='year_num' name='year' class='select'/>
		 <option value='1st'>1st year</option>
		 <option value='2nd'>2nd year</option>
		 <option value='3rd'>3rd year</option>
		 <option value='4th'>4th year</option>
		 </select>
		 <div class='cleaner_h10'></div>
		<label> Semester:</label>  <select id='semester_num' name='semester' class='select'/>
		 <option value='1st'>1st Semester</option>
		 <option value='2nd'>2nd Semester</option>
		 </select>
		 <div class='cleaner_h10'></div>
		
		<input type='reset' class='submit_btn' value='Reset' />
		<input name='submit' type='submit' class='submit_btn' value='Go' />
		</form>
	    </div>
		</center>
</div>
</body>
  </html>