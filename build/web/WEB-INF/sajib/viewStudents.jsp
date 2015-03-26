<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="WebApp.Model.Student" %>
<%@page import="java.util.List" %>

<!DOCTYPE HTML>
<html>
<head>
<title>ViewStudents</title>
<meta charset='utf-8'>
<link rel='stylesheet' href='CSS/screen.css' type='text/css' media='screen'>
<link rel='stylesheet' href='style.css' type='text/css' media='screen'>
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
                 List<Student> students = (List<Student>) request.getAttribute("students");
                 if(students!=null)
                 { 
                        view +="<table><tr><th>name</th><th>dept roll</th><th>current session</th><th>gender</th><th>batch</th><th>exam roll</th><th>email</th><th>phone</th><th>regi_session </th><th>registration</th><th>hall</th></tr>";
                        for(Student student:students)
                        {
                            view +="<tr><td>"+student.getName()+"</td><td>"+student.getDeptRoll()+"</td><td>"+student.getSession()+"</td><td>"+student.getGender()+"</td><td>"+student.getBatch()+"</td><td>"+student.getExamRoll()+"</td><td>"+student.getEmail()+"</td><td>"+student.getPhone()+"</td><td>"+student.getRegistrationSession()+"</td><td>"+student.getRegistration()+"</td><td>"+student.getHall()+"</td></tr>";                    
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
