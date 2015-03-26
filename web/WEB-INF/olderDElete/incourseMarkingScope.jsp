<%@page import="java.util.List" %>
<%@page import="WebApp.Model.CourseTeacher" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<meta charset='utf-8'>
<link rel='stylesheet' href='css/screen.css' type='text/css' media='screen'>
<link rel='stylesheet' href='style.css' type='text/css' media='screen'>
</head>
<body>
<div class='container'>
  <!--centers the content between from header to footer-->
  <header  class='clearfix'>
  <img src='du.jpg' alt='' style='width=200px; height=300px; position:relative;left:50%;top:50%;margin-left:-100px;margin-right:-150px;'>
  <h1 class='left' align='center'><span>CSEDU </span> RESULT</h1>
	 
	 <p style=' color:#000099; font-size:20px;'>Select Catagory of Incourse Marks Distribution: </p>
	 <div id='contact_form2'>
	  <form method='post' action='InsertIncourseMarkDistibution' style='margin-left:auto; margin-right:auto'>
           
              <div class='cleaner_h10'></div>
		<label> Course Code: </label>
                <% 
                    String selectCourse = "<select id='course_code' name='course_code' class='select'/>";
                    String selectSession ="</select><div class='cleaner_h10'></div><label> Session:</label>  <select id='incourse_session' name='incourse_session' class='select'/>";
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
         <input type='checkbox' name='exam' value='exam' /> Exam <input type='text' id='exam_marks' name='exam_marks' placeholder='mark(%)' class='required input_field' /><br/>
        <input type='checkbox' name='viva' value='viva' /> Viva <input type='text' id='viva_marks' name='viva_marks' placeholder='mark(%)' class='required input_field' /><br/>
        <input type='checkbox' name='attendance' value='attendance' /> Attendance <input type='text' id='attendance_marks' name='attendance_marks' placeholder='mark(%)' class='required input_field' /><br/>
        <input type='checkbox' name='assignment' value='assignment' /> Assignment <input type='text' id='assignment_marks' name='assignment_marks' placeholder='mark(%)' class='required input_field' /><br/>
        <input type='checkbox' name='sudden_test' value='sudden_test' /> Sudden Test <input type='text' id='sudden_test_marks' name='sudden_test_marks' placeholder='mark(%)' class='required input_field' /><br/>
        <input type='checkbox' name='presentation' value='presentation' /> Presentation <input type='text' id='presentation_marks' name='presentation_marks' placeholder='mark(%)' class='required input_field' /><br/>
        <input type='submit' class='submit_btn' value='Submit'>
	  </form>
	  </div>
</div>
</body>
  </html>