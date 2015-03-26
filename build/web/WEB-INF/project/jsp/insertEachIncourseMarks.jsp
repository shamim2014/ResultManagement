<%@page import="WebApp.Model.IncourseExamScale" %>
<%@page import="java.util.List" %>
<%@page import="WebApp.Model.Student" %>
<%@page import="WebApp.Model.TeacherCourse" %>
<%@page import="WebApp.Model.IncourseExam" %>

<!DOCTYPE html>
<html xmlns='http://www.w3.org/1999/xhtml'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
<title>Each Incourse</title>
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
                viewMenu +="<ul class='dropdown'><li><a href='home'>Home</a></li><li><a href='theoryCourse?examiner=firstExaminer&course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Incourse Marks</a>";
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
                           view +="<li><a href='labCourse?examiner=firstInstructor&course_code="+teacherCourse.getCourseCode()+"&session="+teacherCourse.getSession()+"'>"+teacherCourse.getTitle()+"</a></li>"; 
                        }
                    }
                    
                    examinar =(List<TeacherCourse>) request.getAttribute("secondInstructor");
                    if(examinar!=null)
                    {
                        for(TeacherCourse teacherCourse : examinar)
                        {
                           view +="<li><a href='labCourse?examiner=secondInstructor&course_code="+teacherCourse.getCourseCode()+"&session="+teacherCourse.getSession()+"'>"+teacherCourse.getTitle()+"</a></li>"; 
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
                        <li> <a href='#'>1st year</a></li>
                        <li><a href='#'>2nd year</a></li>
                        <li><a href='#'>3rd year</a></li>
                        <li><a href='#'>4th year</a></li>
                    </ul>
                </div>
            </div>
            
            <div class='templatemo_content_left_section'>
            	<div class='left_section_title'>Exam Committee</div>
                <div class='left_section_content'>
                	<ul>	
                        <li> <a href='#'>1st year</a></li>
                        <li><a href='#'>2nd year</a></li>
                        <li><a href='#'>3rd year</a></li>
                        <li><a href='#'>4th year</a></li>
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
               List<Student> students = (List<Student>) request.getAttribute("students");
               List<IncourseExam> incourseExams = (List<IncourseExam>) request.getAttribute("incourseExams");
               IncourseExamScale incourseExamScale = (IncourseExamScale) request.getAttribute("incourseExamScale");
               
               String viewForm ="";
               if(students!=null)
               {
                    viewForm +="<form method='post' action='InsertIncourseExamMarks?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                    viewForm +="<label>Incourse Number:</label><select id='marking_type' name='marking_type' class='select2'>";
                    viewForm +="<option value='1'>1</option>";
                    viewForm +="<option value='2'>2</option>";
                    viewForm +="<option value='3'>3</option></select>";
                    viewForm +="<div class='cleaner_h10'></div>";
                    viewForm +="<label> Total Marks: </label> <input type='text' id='total_marks' name='total_marks' class='required input_field' />";
                    viewForm +="<div class='cleaner_h10'></div>";
                    viewForm +="<table style='border:1px solid black;width:280px;margin-left:130px;'>";
                    viewForm +="<tr><th >Roll</th><th >Obtained Marks</th></tr>"; 
                    
                    int serial =0;
                    for(Student student: students)
                    {
                       serial++;
                       viewForm +="<tr>"; 
                       viewForm +="<td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+student.getDeptRoll()+"' class='required input_field2' /></td>";
                       viewForm +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' class='required input_field2' /></td>";
                       viewForm +="</tr>";
                    }
                    viewForm +="</table>";
                    viewForm +="<input type='hidden' name='student_no' value='"+serial+"' />";
                    viewForm +="<div class='cleaner_h10'></div>";
                    viewForm +="<input type='reset' class='submit_btn' value='Reset' style='margin-left:250px;' />";
                    viewForm +="<input name='submit' type='submit' class='submit_btn' value='Insert Marks' />";
                    viewForm +="</form>";
                    
               }
               else if(incourseExams!=null)
               {
                   viewForm +="<form method='post' action='InsertIncourseExamMarks?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                    viewForm +="<label>Incourse Number:</label><input type='text' id='marking_type' name='marking_type'";
                    
                    if(incourseExamScale.getIncourseExam1()!=0.0)
                    {
                      viewForm +=" value='1'";
                      viewForm +=" class='required input_field' />";
                      viewForm +="<div class='cleaner_h10'></div>";
                      viewForm +="<label> Total Marks: </label> <input type='text' id='total_marks' name='total_marks'";
                      viewForm +=" value='"+incourseExamScale.getIncourseExam1()+"' class='required input_field' />";
                    }
                    else if(incourseExamScale.getIncourseExam2()!=0.0)
                    {
                       viewForm +=" value='2'";
                       viewForm +=" class='required input_field' />";
                       viewForm +="<div class='cleaner_h10'></div>";
                       viewForm +="<label> Total Marks: </label> <input type='text' id='total_marks' name='total_marks'";
                       viewForm +=" value='"+incourseExamScale.getIncourseExam2()+"' class='required input_field' />";
                    }
                    else if(incourseExamScale.getIncourseExam3()!=0.0)
                    {
                       viewForm +=" value='3'";
                       viewForm +=" class='required input_field' />";
                       viewForm +="<div class='cleaner_h10'></div>";
                       viewForm +="<label> Total Marks: </label> <input type='text' id='total_marks' name='total_marks'";
                       viewForm +=" value='"+incourseExamScale.getIncourseExam3()+"' class='required input_field' />";
                    }
                    else if(incourseExamScale.getIncourseExam4()!=0.0)
                    {
                        viewForm +=" value='4'";
                        viewForm +=" class='required input_field' />";
                        viewForm +="<div class='cleaner_h10'></div>";
                        viewForm +="<label> Total Marks: </label> <input type='text' id='total_marks' name='total_marks'";
                        viewForm +=" value='"+incourseExamScale.getIncourseExam4()+"' class='required input_field' />";
                    }
                    
                    
                    viewForm +="<div class='cleaner_h10'></div>";
                    viewForm +="<table style='border:1px solid black;width:280px;margin-left:130px;'>";
                    viewForm +="<tr><th >Roll</th><th >Obtained Marks</th></tr>"; 
                    
                    int serial =0;
                    for(IncourseExam incourseExam: incourseExams)
                    {
                       serial++;
                       viewForm +="<tr>"; 
                       viewForm +="<td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+incourseExam.getDept_Roll()+"' class='required input_field2' /></td>";
                       
                       if(incourseExamScale.getIncourseExam1()!=0.0)
                             viewForm +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' value='"+incourseExam.getIncourseExam1()+"' class='required input_field2' /></td>";
                       else if(incourseExamScale.getIncourseExam2()!=0.0)
                             viewForm +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' value='"+incourseExam.getIncourseExam2()+"' class='required input_field2' /></td>";
                       else if(incourseExamScale.getIncourseExam3()!=0.0)
                             viewForm +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' value='"+incourseExam.getIncourseExam3()+"' class='required input_field2' /></td>";
                       else if(incourseExamScale.getIncourseExam4()!=0.0)
                             viewForm +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' value='"+incourseExam.getIncourseExam4()+"' class='required input_field2' /></td>";
                       viewForm +="</tr>";
                    }
                    viewForm +="</table>";
                    viewForm +="<input type='hidden' name='student_no' value='"+serial+"' />";
                    viewForm +="<input type='hidden' name='update' value='update' />";
                    viewForm +="<div class='cleaner_h10'></div>";
                    viewForm +="<input type='reset' class='submit_btn' value='Reset' style='margin-left:250px;' />";
                    viewForm +="<input name='submit' type='submit' class='submit_btn' value='Insert Marks' />";
                    viewForm +="</form>";
                    
               }
                 out.println(viewForm);     
                      
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