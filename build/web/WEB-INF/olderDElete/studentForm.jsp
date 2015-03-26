<%@page  contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Student</title>
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
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Insert Students: </p>
	 <center>
	 <div id='contact_form2'>
        <div class='cleaner_h10'></div>
	  <form method='post' action='InsertStudentInfo'>
<%
    String view ="<label> Student Name: </label> <input type='text' id='student_name' name='student_name' class='required input_field' /><div class='cleaner_h10'></div>";
           view +="<label> Roll: </label> <input type='text' id='roll' name='roll' class='required input_field' /><div class='cleaner_h10'></div>";
           view +="<label>Registration No: </label> <input type='text' id='registration' name='registration' class='required input_field' /><div class='cleaner_h10'></div>";
           view +="<label> Registration Session:</label>  <select id='regi_session' name='regi_session' class='select'/>";
           
    String session_year ="";
    int y =java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                
    for(int i=-10;i<=4;i++)
    {
        session_year +="<option value='"+(y+i)+"-"+(y+i+1)+"'>"+(y+i)+"-"+(y+i+1)+"</option>";
    }
    view +=session_year+"</select><div class='cleaner_h10'></div>";
    view +="<label>Hall: </label> <input type='text' id='hall' name='hall' class='required input_field' /><div class='cleaner_h10'></div>";
    view +="<label> Batch: </label> <input type='text' id='batch' name='batch' class='required input_field' /><div class='cleaner_h10'></div>";
    view +="<label> Current Session:</label>  <select id='current_session' name='current_session' class='select'/>";
    view +=session_year+"</select><div class='cleaner_h10'></div>";
    view +="<label> E-Mail:</label> <input type='text' id='email' name='email' class='required input_field' /><div class='cleaner_h10'></div>";
    view +="<label> Phone:</label> <input type='text' id='phone' name='phone' class='required input_field' /><div class='cleaner_h10'></div>";
    view +="<label>sex:</label> <input style='border-left: 10px;' type='radio' name='sex' value='Male' />Male <input type='radio' name='sex' value='Female' />Female<div class='cleaner_h10'></div>";
    view +="<input type='reset' class='submit_btn' value='Reset' /><input name='submit' type='submit' class='submit_btn' value='Insert' />";
    
    out.println(view);
%>	
</form>
</div>
</center>
</div>
</body>
  </html>