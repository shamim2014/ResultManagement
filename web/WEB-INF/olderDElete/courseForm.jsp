<!DOCTYPE HTML>
<html>
<head>
<title>Course</title>
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
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Insert Courses: </p>
	 <center>
	 <div id='contact_form2'>
            <div><span>${message}</span></div>
        <div class='cleaner_h10'></div>
	  <form method='post' action='InsertCourseInfo'>
		
		<label> Course Name: </label> <input type='text' id='course_name' name='course_name' class='required input_field' />
        <div class='cleaner_h10'></div>
		<label> Course Code: </label> <input type='text' id='course_code' name='course_code' class='required input_field' />
        <div class='cleaner_h10'></div>
		<label> Year: </label> <select id='course_year' name='course_year' class='select'/>
		 <option value='1st'>1st Year</option>
		 <option value='2nd'>2nd Year</option>
		 <option value='3rd'>3rd Year</option>
		 <option value='4th'>4th Year</option>
		 </select>
        <div class='cleaner_h10'></div>
		<label> Semester: </label> <select  id='course_year' name='course_semester' class='select'/>
		 <option value='1st'>1st Semester</option>
		 <option value='2nd'>2nd Semester</option>
		 </select>
	<div class='cleaner_h10'></div>
		<label> Credit: </label> <input type='text' id='course_credit' name='course_credit' class='required input_field' />
        <div class='cleaner_h10'></div>
	<label>Course Type: </label> <select  id='course_type' name='course_type' class='select'/>
		 <option value='lab'>LAB</option>
		 <option value='theory'>THEORY</option>
		 </select>
        <div class='cleaner_h10'></div>
		<input name='submit' type='submit' class='submit_btn' value='Insert' />
		<input type='reset' class='submit_btn' value='Reset' />
		</form>
	    </div>
		</center>
</div>
</body>
  </html>