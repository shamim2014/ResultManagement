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
                    <li><a href='2ndExaminar'>examiner/Instructor</a></li>
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
                             List<Student> students =(List<Student>) request.getAttribute("students");
                             String finalView="";
                             
                             if(students!=null)
                             {
                                 finalView +="<form method='post' action='InsertExamRoll'>";
                                 finalView +="<table style='border:1px solid black;width:700px;'>";
                                 finalView +="<tr>";
                                 finalView +="<th>Dept Roll</th><th>Registration</th><th>Registration Session</th><th>Name</th><th>Batch</th><th>Email</th><th>Exam Roll</th></tr>";
                                 
                                 int serial=0;
                                 for(Student student : students)
                                 {
                                     serial++;
                                     finalView +="<tr>";
                                     finalView +="<td><input type='text' id='xm_roll' name='xm_roll"+serial+"' value='"+student.getDeptRoll()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q1' name='q1"+serial+"' value='"+student.getRegistration()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q2' name='q2"+serial+"' value='"+student.getRegistrationSession()+"' class='required input_field3' /></td>";
                                    finalView +="<td style='padding : 2px 4px 2px 4px;'><input type='text' id='q3' name='q3"+serial+"' value='"+student.getName()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q4' name='q4"+serial+"' value='"+student.getBatch()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q5' name='q5"+serial+"' value='"+student.getEmail()+"' class='required input_field3' /></td>";
                                    
                                    if(student.getExamRoll()!=null)
                                        finalView +="<td><input type='text' id='q6' name='q6"+serial+"' value='"+student.getExamRoll()+"' class='required input_field3' /></td>";
                                    else
                                        finalView +="<td><input type='text' id='q6' name='q6"+serial+"' class='required input_field3' /></td>";
                                    finalView +="</tr>";
                                 }
                                 finalView +="</table>";
                                finalView +="<div class='cleaner_h10'></div>";
                                finalView +="<input type='hidden' name='student_no' value='"+serial+"' />";
                                finalView +="<input name='submit' type='submit' class='submit_btn' value='Save' style='margin-left:670px;' />";
                                 finalView +="</form>";
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