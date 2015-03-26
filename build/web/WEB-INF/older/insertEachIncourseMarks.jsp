<%-- 
    Document   : insertEachIncourseMarks
    Created on : Dec 3, 2014, 8:08:02 PM
    Author     : shamim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Incourse Marks</title>
        <link rel='stylesheet' href='CSS/screen.css' type='text/css' media='screen'>
        <link rel='stylesheet' href='CSS/style.css' type='text/css' media='screen'>
    </head>
    <body>
        <div class='container'>
  <!--centers the content between from header to footer-->
  <header  class='clearfix'>
  <img src='IMAGES/du.jpg' alt='' style='width=200px; height=300px; position:relative;left:50%;top:50%;margin-left:-100px;margin-right:-150px;'>
  <center> <h1 style="position: relative;"><span>CSEDU </span> RESULT</h1></center>
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Insert Incourse Marks: </p>
	 <center>
	 <div id='contact_form2'>
	  <form method='post' action='insertIncourseFinal'>
		<label> Course Code: </label> <select id='course_code' name='course_code' class='select'/>
		 <option value='cse-401'>cse-4101</option>
		 <option value='cse-4102'>cse-4102</option>
		 <option value='cse-4102'>cse-4102</option>
		 </select>
        <div class='cleaner_h10'></div>
		<label> Session:</label>  <select id='session' name='session' class='select'/>
		 <option value='2014-2015'>2014-2015</option>
		 <option value='2013-2014'>2013-2013</option>
		 <option value='2012-2013'>2012-2013</option>
		 
		 </select>
         <div class='cleaner_h10'></div>
		 <label>Class Roll: </label> <input type='text' id='dept_roll' name='dept_roll' class='required input_field' />
        <div class='cleaner_h10'></div>
		 <label>Obtained Marks: </label> <input type='text' id='mark' name='mark_final' class='required input_field' />
        <div class='cleaner_h10'></div>
		
		<input type='reset' class='submit_btn' value='Reset' />
		<input name='submit' type='submit' class='submit_btn' value='Insert' />
		</form>
	    </div>
		</center>
   </div>
 </body>
</html>
