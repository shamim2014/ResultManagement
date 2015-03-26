<%@page import="WebApp.Model.Teacher"%>
<%@page import="WebApp.Model.Student"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
<title>Official</title>
<link href='CSS/style.css' rel='stylesheet' type='text/css' />

</head>
<body>
<div id='templatemo_top_panel'>
    <div id='templatemo_header_section'>
    </div> <!-- end of header -->
</div>    
    
<div id='templatemo_menu_panel'>
    <div id='templatemo_menu_section'>
        <ul class='dropdown'>
            <li><a href='#'>Students</a>
                <ul>
                    <li><a href='studentForm'>Insert Student</a></li>
                    <li><a href='editStudent'>Edit Student</a></li>
                    <li><a href='1styearexamroll'>1st year exam roll</a></li>
                    <li><a href='2ndyearexamroll'>2nd year exam roll</a></li>
                    <li><a href='3rdyearexamroll'>3rd year exam roll</a></li>
                    <li><a href='4thyearexamroll'>4th year exam roll</a></li>
                </ul>
            </li>
            <li><a href='#'>Teachers</a>
                <ul>
                    <li><a href='TeacherForm'>Insert Teacher</a></li>
                    <li><a href='editTeacher?pagename=editForm'>Edit Teacher</a></li>
                </ul>
            </li>
            <li><a href='#'>Exam Committee</a>
                <ul>
                    <li><a href='makeExamCommittee'>Insert Committee</a></li>
                    <li><a href='editExamCommittee'>Edit Committee</a></li>
                </ul>
            </li>    
            <li><a href='#'>Courses</a>
                <ul>
                    <li><a href='CourseForm'>Insert Course</a></li>
                    <li><a href='editCourse'>Edit Course</a></li>
                    <li><a href='CourseTeacherForm'>Insert Course Teacher</a></li>
                    <li><a href='editCourseTeacher'>Edit Course Teacher</a></li>
                </ul>
            </li>
            <li><a href='#'>Semester Info.</a>
                <ul>
                    <li><a href='CourseSemesterForm'>Insert</a></li>
                    <li><a href='BatchForm'>Insert batch</a></li>
                    <li><a href='editSemesterCourse'>Update</a></li>
                </ul>
            </li>
            <li><a href='logout'>Logout</a></li>                  
        </ul> 
    </div>
</div> <!-- end of menu -->

<div id='templatemo_content_panel'>
	<div id='templatemo_content'>
    	
        <div id='templatemo_content_left'>
        	<div class='templatemo_content_left_section'>
            	<div class='left_section_title'>Students</div>
                <div class='left_section_content'>
                	<ul>
                        <li><a href='viewStudents?year=1st'>1st year</a></li>
                        <li><a href='viewStudents?year=2nd'>2nd year</a></li>
                        <li><a href='viewStudents?year=3rd'>3rd year</a></li>
                        <li><a href='viewStudents?year=4th'>4th year</a></li>
                    </ul>
                </div>
            </div>
            
            <div class='templatemo_content_left_section'>
            	<div class='left_section_title'>Teachers</div>
                <div class='left_section_content'>
                	<ul>
                        <li><a href='#'>See teacher profile</a></li>
                    </ul>
                </div>
            </div>
            
            <div class='templatemo_content_left_section'>
            	<div class='left_section_title'>Exam Committee</div>
                <div class='left_section_content'>
                	<ul>	
                        <li> <a href='viewExamCommittee?year=1st'>1st year</a></li>
                        <li><a href='viewExamCommittee?year=2nd'>2nd year</a></li>
                        <li><a href='viewExamCommittee?year=3rd'>3rd year</a></li>
                        <li><a href='viewExamCommittee?year=4th'>4th year</a></li>
                    </ul>
                </div>
            </div>
         </div> <!-- end of content left -->
       <div id='templatemo_content_right'>
        	<div class='templatemo_post_section'>
                <div class='date_section'>                 
                </div>
            	<div class='post_content'>                	
                    <div id='contact_form2'> 
               <%
                 String finalView="";
                 List<Student> students = (List<Student>) request.getAttribute("students");
                 Teacher chairmanTeacher = (Teacher) request.getAttribute("chairmanTeacher");
                 Teacher firstTeacher = (Teacher) request.getAttribute("firstTeacher");
                 Teacher secondTeacher = (Teacher) request.getAttribute("secondTeacher");
                
                 if(students!=null)
                 { 
                        finalView +="<table><tr><th>name</th><th>dept roll</th><th>current session</th><th>gender</th><th>batch</th><th>exam roll</th><th>email</th><th>phone</th><th>regi_session </th><th>registration</th><th>hall</th></tr>";
                        for(Student student:students)
                        {
                            finalView +="<tr><td>"+student.getName()+"</td><td>"+student.getDeptRoll()+"</td><td>"+student.getSession()+"</td><td>"+student.getGender()+"</td><td>"+student.getBatch()+"</td><td>"+student.getExamRoll()+"</td><td>"+student.getEmail()+"</td><td>"+student.getPhone()+"</td><td>"+student.getRegistrationSession()+"</td><td>"+student.getRegistration()+"</td><td>"+student.getHall()+"</td></tr>";                    
                        }
                        finalView +="</table>";
                 }
                 else if(chairmanTeacher!=null && firstTeacher!=null && secondTeacher!=null)
                 {
                        finalView +="<table>";
                        finalView +="<tr><th width='100'></th><th width='215'>Chairman</th><th width='215'>Member</th><th width='215'>Member</th><tr>";
                        finalView +="<tr><td>Name</td><td>"+chairmanTeacher.getName()+"</td><td>"+firstTeacher.getName()+"</td><td>"+secondTeacher.getName()+"</td></tr>";
                        finalView +="<tr><td>Designation</td><td>"+chairmanTeacher.getDesignation()+"</td><td>"+firstTeacher.getDesignation()+"</td><td>"+secondTeacher.getDesignation()+"</td></tr>";
                        finalView +="<tr><td>Department</td><td>"+chairmanTeacher.getDepartment()+"</td><td>"+firstTeacher.getDepartment()+"</td><td>"+secondTeacher.getDepartment()+"</td></tr>";
                        finalView +="<tr><td>Email</td><td>"+chairmanTeacher.getEmail()+"</td><td>"+firstTeacher.getEmail()+"</td><td>"+secondTeacher.getEmail()+"</td></tr>";
                        finalView +="<tr><td>Phone</td><td>"+chairmanTeacher.getPhone()+"</td><td>"+firstTeacher.getPhone()+"</td><td>"+secondTeacher.getPhone()+"</td></tr>";
                        finalView +="</table>";
                  }
                 else
                 {
                     finalView +="<span>THERE IS NO Data</span>";
                 }
                 out.println(finalView);
             %>
         </div>                   
                </div>
            </div> <!-- end of 1 post -->
        </div> <!-- end of content right -->
        
		<div class='cleaner_with_height'>&nbsp;</div>
    </div>
</div> <!-- end of content panel -->

<div id='templatemo_footer_panel'>
    <div id='templatemo_footer_section'>
       Department of Computer Science & Engineering,University of Dhaka
	   <br /> Science Complex Building,Mokarram Bhaban
	</div>
</div>
</body>
</html>
</html>