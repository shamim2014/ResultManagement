<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="WebApp.Model.Course" %>
<%@page import="java.util.List" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Courses</title>
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
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Available Courses: </p>
	 <center>
	 <div id='contact_form2'>
             <%
                 String view="";
                 List<Course> courses = (List<Course>) request.getAttribute("courses");
                 if(courses!=null)
                 { 
                        view +="<table><tr><th>Course Code</th><th>Course Title</th><th>Credit Hours</th><th>Course Year</th><th>Course Semester</th></tr>";
                        for(Course course:courses)
                        {
                            view +="<tr><td>"+course.getCourseCode()+"</td><td>"+course.getTitle()+"</td><td>"+course.getCredit()+"</td><td>"+course.getYear()+"</td><td>"+course.getSemester()+"</td></tr>";                    
                        }
                        view +="</table>";
                 }
                 else
                 {
                     view +="<span>THERE IS NO COURSES</span>";
                 }
                 out.println(view);
             %>
             
             
	    </div>
		</center>
</div>
</body>
  </html>
