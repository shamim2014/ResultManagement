<!DOCTYPE HTML>
<html>
<head>
<title>Teacher</title>
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
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Insert Teachers: </p>
	 <center>
	 <div id='contact_form2'>
             <div><span>${message}</span></div>
        <div class='cleaner_h10'></div>
	  <form method='post' action='InsertTeacherInfo'>
		
		<label> Teacher Name: </label> <input type='text' id='teacher_name' name='teacher_name' class='required input_field' />
        <div class='cleaner_h10'></div>
        <label> Designation: </label> <input type='text' id='designation' name='designation' class='required input_field' />
        <div class='cleaner_h10'></div>
		<label> Department: </label> <input type='text' id='department' name='department' class='required input_field' />
        <div class='cleaner_h10'></div>
		<label> E-Mail:</label> <input type='text' id='email' name='email' class='required input_field' />
        <div class='cleaner_h10'></div>
		<label> Cell Number: </label> <input type='text' id='cell_num' name='cell_num' class='required input_field' />
        <div class='cleaner_h10'></div>
		
		<input type='reset' class='submit_btn' value='Reset' />
		<input name='submit' type='submit' class='submit_btn' value='Insert' />
		</form>
	    </div>
	</center>
</div>
</body>
  </html>