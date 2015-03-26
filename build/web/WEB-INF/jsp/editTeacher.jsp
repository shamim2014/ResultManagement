
<%@page import="WebApp.Model.Teacher"%>
<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
<title>Edit teacher</title>
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
                            Teacher  teacher =(Teacher) request.getAttribute("teacher");
                            
                            String view ="";
                            
                            if(teacher==null)
                            {
                                view +="<form method='post' action='editTeacher?pagename=Insert'>";
                                view +="<label> Teacher Email: </label> <input type='text' id='teacher_name' name='teacher_email' class='required input_field' required />";
                                view +="<div class='cleaner_h10'></div>";
                                view +="<label> New Email: </label> <input type='text' id='department' name='email' class='required input_field' />";
                                view +="<div class='cleaner_h10'></div>";
                                view +="<label> New Cell Number:</label> <input type='text' id='email' name='phone' class='required input_field' />";
                                view +="<div class='cleaner_h10'></div>";
                                view +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:280px;' />";
                                view +="<input name='submit' type='submit' class='submit_btn' value='Insert' />";
                                view +="</form>";
                            }
                            else
                            {
                                view +="<table><tr> <th>Teacher Name</th><th>Designation</th><th>Department</th><th>Email</th><th>Phone</th></tr>";
                                view +="<tr><td>"+teacher.getName()+"</td><td>"+teacher.getDesignation()+"</td><td>"+teacher.getDepartment()+"</td><td>"+teacher.getEmail()+"</td><td>"+teacher.getPhone()+"</td></tr>";
                                view +="</table>";
                            }
                             out.println(view);
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
