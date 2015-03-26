<%@page import="WebApp.Model.Student" %>
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
    Student student = (Student) request.getAttribute("student");
    String view="";
    String errorMessage =(String) request.getAttribute("errorMessage");
    
    if(errorMessage!=null)
        view +="<h1 style='font-family:'Times New Roman', Times, serif;font-size:30px;color:blue;'><span>"+errorMessage+"</span></h1>";
    if(student!=null)
    {
        view +="<table style='border:1px solid black;width:700px;'><tr><th>name</th><th>dept roll</th><th>current session</th><th>gender</th><th>batch</th><th>email</th><th>phone</th><th>regi_session </th><th>registration</th><th>hall</th></tr>";
        view +="<tr><td style='width:70px;'>"+student.getName()+"</td><td style='width:70px'>"+student.getDeptRoll()+"</td><td style='width:70px'>"+student.getSession()+"</td><td style='width:70px'>"+student.getGender()+"</td><td style='width:70px'>"+student.getBatch()+"</td><td style='width:70px'>"+student.getEmail()+"</td><td style='width:70px'>"+student.getPhone()+"</td><td style='width:70px'>"+student.getRegistrationSession()+"</td><td style='width:70px'>"+student.getRegistration()+"</td><td style='width:70px'>"+student.getHall()+"</td></tr>";
        view +="</table>";
    }
    else
    {
           view +="<form method='post' action='InsertStudentInfo'>";
           view +="<label> Student Name: </label> <input type='text' id='student_name' name='student_name' class='required input_field' /><div class='cleaner_h10'></div>";
           view +="<label> Roll: </label> <input type='text' id='roll' name='roll' class='required input_field' /><div class='cleaner_h10'></div>";
           view +="<label>Registration No: </label> <input type='text' id='registration' name='registration' class='required input_field' /><div class='cleaner_h10'></div>";
           view +="<label> Registration Session:</label>  <select id='regi_session' name='regi_session' class='select'/>";
           
           String session_year ="";
           int y =java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

           for(int i=-7;i<=1;i++)
           {
               session_year +="<option value='"+(y+i)+"-"+(y+i+1)+"'>"+(y+i)+"-"+(y+i+1)+"</option>";
           }
            view +=session_year+"</select><div class='cleaner_h10'></div>";
            view +="<label>Hall: </label> <input type='text' id='hall' name='hall' class='required input_field' /><div class='cleaner_h10'></div>";
            view +="<label> Batch: </label> <input type='text' id='batch' name='batch' class='required input_field' /><div class='cleaner_h10'></div>";
            view +="<label> Current Session:</label>  <select id='current_session' name='current_session' class='select'/>";
            view +=session_year+"</select><div class='cleaner_h10'></div>";
            view +="<label> E-Mail:</label> <input type='text' id='email' name='email' class='required input_field' /><div class='cleaner_h10'></div>";
            view +="<label> Phone:</label> <input type='text' id='phone' name='phone' class='required input_field' /><div class='cleaner_h10'></div>";
            view +="<label>sex:</label> <input style='border-left: 10px;' type='radio' name='sex' value='Male' />Male <input type='radio' name='sex' value='Female' />Female<div class='cleaner_h10'></div>";
            view +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:280px;' /><input name='submit' type='submit' class='submit_btn' value='Insert' />";
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