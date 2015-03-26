<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="WebApp.Model.BatchSemester" %>
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
                 List<BatchSemester> batchSemesters = (List<BatchSemester>) request.getAttribute("batchSemesters");
                 if(batchSemesters!=null)
                 { 
                        view +="<table><tr><th>BATCH</th><th>YEAR</th><th>SEMESTER</th><th>SESSION</th></tr>";
                        for(BatchSemester batchSemester:batchSemesters)
                        {
                            view +="<tr><td>"+batchSemester.getBatch()+"</td><td>"+batchSemester.getYear()+"</td><td>"+batchSemester.getSemester()+"</td><td>"+batchSemester.getSession()+"</td></tr>";                    
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
