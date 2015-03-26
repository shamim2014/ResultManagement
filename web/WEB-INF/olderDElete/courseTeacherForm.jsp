<%-- 
    Document   : courseTeacherForm
    Created on : Dec 5, 2014, 3:18:16 PM
    Author     : shamim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Course Teacher</title>
<meta charset='utf-8'>
<link rel='stylesheet' href='CSS/screen.css' type='text/css' media='screen'>
<link rel='stylesheet' href='CSS/style.css' type='text/css' media='screen'>
</head>
<body>
<div class='container'>
  <!--centers the content between from header to footer-->
  <header  class='clearfix'>
  <img src='IMAGES/du.jpg' alt='' style='width=200px; height=300px; position:relative;left:50%;top:50%;margin-left:-100px;margin-right:-150px;'>
  <center> <h1 style="position: relative;"><span>CSEDU </span> RESULT</h1></center>
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Insert Course Teacher: </p>
	 <center>
	 <div id='contact_form2'>
        <div class='cleaner_h10'></div>
	<form method='post' action='InsertCourseTeacher'>
	<label> Course Type : </label> 
               <select  id='course_type' name='course_type' class='select'/>
		    <option value='lab'>Lab</option>
		    <option value='theory'>Theory</option>
		</select>
        <div class='cleaner_h10'></div>
        <label> Course Code: </label> <input type='text' id='course_code' name='course_code' class='required input_field' /> 
	<div class='cleaner_h10'></div>
	<label> Session:</label> <input type='text' id='session' name='session' class='required input_field' />
	<div class='cleaner_h10'></div>
        <label> Teacher Id:</label> <input type='text' id='teacher_id' name='teacher_id' class='required input_field' />
	<div class='cleaner_h10'></div>
        <input type='reset' class='submit_btn' value='Reset' />
        <input name='submit' type='submit' class='submit_btn' value='Insert' />
        </form>
    </div>
</center>
</div>
</body>
  </html>