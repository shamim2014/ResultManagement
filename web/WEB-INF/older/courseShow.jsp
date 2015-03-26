<%-- 
    Document   : courseTeacherForm
    Created on : Dec 5, 2014, 3:18:16 PM
    Author     : shamim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="WebApp.Model.Course" %>
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
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Insert Students: </p>
	 <center>
	 <div id='contact_form2'>
        <div class='cleaner_h10'></div>
        <%
            Course course = (Course) request.getAttribute("course");
            String courseInfo="";
            if(course!=null)
            {
                courseInfo+="<h1>following information inserted</h1><label> Course Name: </label>"+course.getTitle()+ "<div class='cleaner_h10'></div>";
                courseInfo+="<label> Course Code: </label>"+course.getCourseCode()+ "<div class='cleaner_h10'></div>";
                courseInfo+="<label> Course Credit: </label>"+course.getCredit()+ "<div class='cleaner_h10'></div>";
                courseInfo+="<label> Course Type: </label>"+course.getCourseType()+ "<div class='cleaner_h10'></div>";
                courseInfo+="<label> Course Year: </label>"+course.getYear()+ "<div class='cleaner_h10'></div>";
                courseInfo+="<label> Course Semester: </label>"+course.getSemester()+ "<div class='cleaner_h10'></div>";
            }
            else
            {
                courseInfo +=request.getAttribute("message").toString();
            }
            out.print(courseInfo);
         %>
         <a href="CourseForm" >Insert Another</a><br />
        <div class='cleaner_h10'></div>
        <a href="login" >home</a><br />
        <div class='cleaner_h10'></div>
    </div>
</center>
</div>
</body>
  </html>