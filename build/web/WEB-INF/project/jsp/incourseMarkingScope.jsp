<%@page import="WebApp.Model.TeacherCourse"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IncourseMarkingScope</title>
<link href='CSS/style.css' rel='stylesheet' type='text/css' />

</head>
<body>
<div id='templatemo_top_panel'>
	<div id='templatemo_header_section'>
    </div> <!-- end of header -->
</div>    
    
<div id='templatemo_menu_panel'>
    <div id='templatemo_menu_section'>
             <% 
                String viewMenu="";
                viewMenu +="<ul class='dropdown'><li><a href='home'>Home</a></li><li><a href='home'>Logout</a></li><li><a href='theoryCourse?examiner=firstExaminer&course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Incourse Marks</a>";
                viewMenu +="<ul>";
                viewMenu +="<li><a href='IncourseExamForm?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Each Incourse Marks</a></li>";
                viewMenu +="<li><a href='IncourseMarkDistibution?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Final Incourse Marks</a></li>";
                viewMenu +="</ul></li>";
                
                viewMenu +="<li><a href='FinalMarksForm?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Semester Final Marks</a></li>";
                viewMenu +="<li><a href='#?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>View Marks</a>";
                viewMenu +="<ul>";
                viewMenu +="<li><a href='viewIncourseMarks?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Incourse Marks</a></li>";
                viewMenu +="<li><a href='viewFinalmarks?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Semester Final Marks</a></li>";
                viewMenu +="</ul></li> ";
                viewMenu +="<li><a href='logout'>Logout</a></li></ul>";
                out.println(viewMenu);
            %>	
    </div>
</div> <!-- end of menu -->


<div id='templatemo_content_panel'>
	<div id='templatemo_content'>
    	
        <div id='templatemo_content_left'>
        	<div class='templatemo_content_left_section'>
            	<div class='left_section_title'>Courses</div>
                <div class='left_section_content'>
                	<% 
                    String view="";
                    view +="<ul>";
                    
                    List<TeacherCourse> examinar =(List<TeacherCourse>) request.getAttribute("firstExaminar");
                    
                    if(examinar!=null)
                    {
                        for(TeacherCourse teacherCourse : examinar)
                        {
                           view +="<li><a href='theoryCourse?examiner=firstExaminer&course_code="+teacherCourse.getCourseCode()+"&session="+teacherCourse.getSession()+"'>"+teacherCourse.getTitle()+"</a></li>"; 
                        }
                    }
                    
                    examinar =(List<TeacherCourse>) request.getAttribute("secondExaminar");
                    if(examinar!=null)
                    {
                        for(TeacherCourse teacherCourse : examinar)
                        {
                           view +="<li><a href='theoryCourse?examiner=secondExaminer&course_code="+teacherCourse.getCourseCode()+"&session="+teacherCourse.getSession()+"'>"+teacherCourse.getTitle()+"</a></li>"; 
                        }
                    }
                    examinar =(List<TeacherCourse>) request.getAttribute("firstInstructor");
                    if(examinar!=null)
                    {
                        for(TeacherCourse teacherCourse : examinar)
                        {
                           view +="<li><a href='LabCourse?examiner=firstInstructor&course_code="+teacherCourse.getCourseCode()+"&session="+teacherCourse.getSession()+"'>"+teacherCourse.getTitle()+"</a></li>"; 
                        }
                    }
                    
                    examinar =(List<TeacherCourse>) request.getAttribute("secondInstructor");
                    if(examinar!=null)
                    {
                        for(TeacherCourse teacherCourse : examinar)
                        {
                           view +="<li><a href='LabCourse?examiner=secondInstructor&course_code="+teacherCourse.getCourseCode()+"&session="+teacherCourse.getSession()+"'>"+teacherCourse.getTitle()+"</a></li>"; 
                        }
                    }
                    view +="</ul>";
                    
                    out.println(view);
                %>
                </div>
            </div>
            
           <div class='templatemo_content_left_section'>
            	<div class='left_section_title'>Students</div>
                <div class='left_section_content'>
                	<ul>
                        <li> <a href='viewStudents?year=1st'>1st year</a></li>
                        <li><a href='viewStudents?year=1st'>2nd year</a></li>
                        <li><a href='viewStudents?year=1st'>3rd year</a></li>
                        <li><a href='viewStudents?year=1st'>4th year</a></li>
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
            	<div class='post_content'>                	
                     <div id='contact_form2'>
                         <%
                             String viewFinal ="<form method='post' action='InsertIncourseMarkDistibution?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<input type='checkbox' name='exam' value='exam' /><div class='chekbox'> Exam Mark</div><input type='text' id='exam_marks' name='exam_marks' placeholder='mark(out of 40)' class='required input_field' required /><br/>";
                            viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<label>Select Marking Type:</label>  <select id='marking_type' name='marking_type' class='select2' required>";
                             viewFinal +="<option value='1'>Best One</option>";
                             viewFinal +="<option value='2'>Best Two Average</option>";
                             viewFinal +="<option value='3'>Average</option>";
                             viewFinal +="<option value='4'>Manual</option>";
                             viewFinal +="</select>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<input type='checkbox' name='viva' value='viva' /> <div class='chekbox'>Viva Mark</div><input type='text' id='viva_marks' name='viva_marks' placeholder='mark(out of 40)' class='required input_field' /><br/>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<input type='checkbox' name='attendance' value='attendance' /><div class='chekbox'> Attendance </div><input type='text' id='attendance_marks' name='attendance_marks' placeholder='mark(out of 40)' class='required input_field' /><br/>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<input type='checkbox' name='assignment' value='assignment' /><div class='chekbox'> Assignment</div> <input type='text' id='assignment_marks' name='assignment_marks' placeholder='mark(out of 40)' class='required input_field' /><br/>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<input type='checkbox' name='sudden_test' value='sudden_test' /><div class='chekbox'> Sudden Test</div> <input type='text' id='sudden_test_marks' name='sudden_test_marks' placeholder='mark(out of 40)' class='required input_field' /><br/>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<input type='checkbox' name='presentation' value='presentation' /><div class='chekbox'> Presentation </div><input type='text' id='presentation_marks' name='presentation_marks' placeholder='mark(out of 40)' class='required input_field' /><br/>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="<input type='submit' class='submit_btn' value='Submit'style='margin-left:385px;'>";
                             viewFinal +="<div class='cleaner_h10'></div>";
                             viewFinal +="</form>";
                             viewFinal +="";
                             
                             out.println(viewFinal);
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