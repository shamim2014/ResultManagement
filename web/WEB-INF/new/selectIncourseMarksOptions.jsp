<%@page import="java.util.List" %>
<%@page import="WebApp.Model.CourseTeacher" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Incourse Marks</title>
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
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Insert Incourse Options: </p>
	 <center>
	 <div id='contact_form2'>
	  <form method='post' action='#'>
		<label> Course Code:</label> 
                <% 
                    String selectCourse = "<select id='course_code' name='course_code' class='select'>";
                    String selectSession ="</select><div class='cleaner_h10'></div><label> Session:</label>  <select id='incourse_session' name='incourse_session' class='select'>";
                    List<CourseTeacher> courses =(List<CourseTeacher>) request.getAttribute("courses");
                    for(int i=0;i<courses.size();i++)
                    {
                        selectCourse +="<option value='"+courses.get(i).getCourseCode()+"'>"+courses.get(i).getCourseCode()+"</option>";
                        selectSession +="<option value='"+courses.get(i).getSession()+"'>"+courses.get(i).getSession()+"</option>";
                    }
                    selectSession +="</select>";
                   
                    out.println(selectCourse+selectSession);
                %>
		 <div class='cleaner_h10'></div>
		<label> Incourse Number:</label>  <select id='incourse_num' name='incourse_num' class='select'/>
		 <option value='1'>1st Incourse</option>
		 <option value='2'>2nd Incourse</option>
		 <option value='3'>3rd Incourse</option>
		 <option value='4'>4th Incourse</option>
		 </select>
		 <div class='cleaner_h10'></div>
		 <label>Total Marks: </label> <input type='text' id='batch' name='batch' class='required input_field' />
        <div class='cleaner_h10'></div>
		 <div class='cleaner_h10'></div>
		
		<input type='reset' class='submit_btn' value='Reset' />
		<input name='submit' type='submit' class='submit_btn' value='Insert Marks' />
		</form>
	    </div>
		</center>
</div>
</body>
  </html>
