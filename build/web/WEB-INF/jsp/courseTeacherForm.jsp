<%@page import="WebApp.Model.Teacher" %>
<%@page import="WebApp.Model.Course" %>
<%@page import="java.util.List" %>
<%@page import="WebApp.Model.TeacherCourse" %>

<!DOCTYPE html>
<html xmlns='http://www.w3.org/1999/xhtml'>
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
                          TeacherCourse teacherCourse =(TeacherCourse) request.getAttribute("teacherCourse");
                          List<Teacher> teachers =(List<Teacher>) request.getAttribute("teachers"); 
                          List<Course> courses =(List<Course>) request.getAttribute("courses");
                          
                          String view="";
                          String teacherCourseError =(String) request.getAttribute("teacherCourseError");
                        
                          if(teacherCourseError!=null)
                              view +="<h1 style='font-family:'Times New Roman', Times, serif;font-size:30px;color:blue;'>"+request.getAttribute("teacherCourseError")+"</span></h1>";
                          
                          if(teacherCourse!=null)
                          {
                              view +="<table><tr> <th>Teacher Name</th><th>Designation</th><th>Department</th><th>Email</th><th>Course Title</th><th>Course Code</th><th>Session</th><th>Year</th><th>Semester</th></tr>";
                              view +="<tr><td>"+teacherCourse.getName()+"</td><td>"+teacherCourse.getDesignation()+"</td><td>"+teacherCourse.getDepartment()+"</td><td>"+teacherCourse.getEmail()+"</td><td>"+teacherCourse.getCourseCode()+"</td><td>"+teacherCourse.getSession()+"</td><td>"+teacherCourse.getYear()+"</td><td>"+teacherCourse.getEmail()+"</td><td>"+teacherCourse.getSemester()+"</td></tr>";
                              view +="</table>";
                          }
                          else
                          {
                                view+="<form method='post' action='InsertCourseTeacher'>";
                                view+="<label> Course Name: </label><select id='course_name' name='course_name' class='select' >";
                                String courseCode ="";
                                for(Course course : courses)
                                {
                                     view+="<option value='"+course.getTitle()+"'>"+course.getTitle()+"</option>";
                                     courseCode +="<option value='"+course.getCourseCode()+"'>"+course.getCourseCode()+"</option>";
                                }
                                view+="</select><div class='cleaner_h10'></div>";
                                view+="<label> Course Code: </label>";
                                view+="<select id='course_code' name='course_code' class='select' >";
                                view+=courseCode;
                                view+="</select><div class='cleaner_h10'></div>";
                                view+="<label>Session:</label><select id='session' name='session' class='select' >";

                                int y =java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

                                for(int i=-2;i<=1;i++)
                                {
                                      view +="<option value='"+(y+i)+"-"+(y+i+1)+"'>"+(y+i)+"-"+(y+i+1)+"</option>";
                                }
                                view +="</select><div class='cleaner_h10'></div>";
                                view +="<label>Teacher Email: </label>";
                                view +="<select id='email' name='email' class='select' >";

                               for(Teacher teacher:teachers)
                               {
                                   view+="<option value='"+teacher.getEmail()+"'>"+teacher.getEmail()+"</option>";
                               }
                               view +="</select><div class='cleaner_h10'></div>";
                               view +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:280px;' />";
                               view +="<input name='submit' type='submit' class='submit_btn' value='Insert' />";
                               view +="</form>";

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