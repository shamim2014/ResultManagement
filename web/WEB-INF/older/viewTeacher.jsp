<%@page import="WebApp.Model.Teacher" %>
<%@page import="java.util.List" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Insert Incourse Marks</title>
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
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Teacher </p>
	 <center>
	 <div id='contact_form2'>
             <%
                 List<Teacher> teachers =(List<Teacher>) request.getAttribute("teachers");
                 String view ="";
                 
                 if(teachers!=null)
                 {
                     view +="<table><tr> <th>Teacher Name</th><th>Designation</th><th>Department</th><th>Email</th><th>Phone</th></tr>";
                     for(Teacher teacher:teachers)
                     {
                        view +="<tr><td>"+teacher.getName()+"</td><td>"+teacher.getDesignation()+"</td><td>"+teacher.getDepartment()+"</td><td>"+teacher.getEmail()+"</td><td>"+teacher.getPhone()+"</td></tr>";
                     }
                     view +="</table>";
                 }
                 else
                 {
                     view +="Teacher not found";
                 }
                out.println(view);
             %>
	 </div>
	</center>
</div>
</body>
  </html>
