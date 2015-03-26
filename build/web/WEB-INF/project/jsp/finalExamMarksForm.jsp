<%@page import="WebApp.Model.FinalExamMark"%>
<%@page import="WebApp.Model.Student"%>
<%@page import="WebApp.Model.TeacherCourse"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html xmlns='http://www.w3.org/1999/xhtml'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
<title>Theory Course</title>
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
                           
                            List<Student> students =(List<Student>) request.getAttribute("students");
                            List<FinalExamMark> finalExamMarks = (List<FinalExamMark>) request.getAttribute("finalExamMarks");
                            String finalView="";
                            int serial =0;
                            String message =(String) request.getAttribute("errorMessage");
                            if(message!=null)
                            {
                                finalView +="<h1>"+message+"</h1>";
                            }
                            if(students!=null)
                            {
                                
                                
                                finalView+="<form method='post' action='InsertFinalExamMarks?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                            
                              finalView +="<table style='border:1px solid black;width:700px;'>"; 
                             finalView +="<tr>";
                             finalView +="<th>Exam Roll</th><th>Q1 Marks</th><th>Q2 Marks</th><th>Q3 Marks</th><th>Q4 Marks</th><th>Q5 Marks</th><th>Q6 Marks</th></tr>";
                                
                                for(Student student: students)
                                {
                                    serial++;
                                    finalView +="<tr>";
                                    finalView +="<td><input type='text' id='xm_roll' name='xm_roll"+serial+"' value='"+student.getExamRoll()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q1' name='q1"+serial+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q2' name='q2"+serial+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q3' name='q3"+serial+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q4' name='q4"+serial+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q5' name='q5"+serial+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q6' name='q6"+serial+"' class='required input_field3' /></td>";
                                    finalView +="</tr>";
                                }
                                
                                finalView +="</table>";
                                finalView +="<div class='cleaner_h10'></div>";
                                finalView +="<input type='hidden' name='student_no' value='"+serial+"' />";
                                finalView +="<input name='submit' type='submit' class='submit_btn' value='Insert Marks' style='margin-left:640px;' />";
                                finalView +="</form>";
                            }
                            else if(finalExamMarks!=null)
                            {
                                finalView+="<form method='post' action='InsertFinalExamMarks?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                            
                              finalView +="<table style='border:1px solid black;width:700px;'>"; 
                             finalView +="<tr>";
                             finalView +="<th>Exam Roll</th><th>Q1 Marks</th><th>Q2 Marks</th><th>Q3 Marks</th><th>Q4 Marks</th><th>Q5 Marks</th><th>Q6 Marks</th></tr>";
                                for(FinalExamMark finalExamMark: finalExamMarks)
                                {
                                     serial++;
                                    finalView +="<tr>";
                                    finalView +="<td><input type='text' id='xm_roll' name='xm_roll"+serial+"' value='"+finalExamMark.getExamRoll()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q1' name='q1"+serial+"' value='"+finalExamMark.getQuestionOneMarks()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q2' name='q2"+serial+"' value='"+finalExamMark.getQuestionTwoMarks()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q3' name='q3"+serial+"' value='"+finalExamMark.getQuestionThreeMarks()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q4' name='q4"+serial+"' value='"+finalExamMark.getQuestionFourMarks()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q5' name='q5"+serial+"' value='"+finalExamMark.getQuestionFiveMarks()+"' class='required input_field3' /></td>";
                                    finalView +="<td><input type='text' id='q6' name='q6"+serial+"' value='"+finalExamMark.getQuestionSixMarks()+"' class='required input_field3' /></td>";
                                    finalView +="</tr>";
                                }
                                finalView +="</table>";
                                finalView +="<div class='cleaner_h10'></div>";
                                finalView +="<input type='hidden' name='student_no' value='"+serial+"' /><input type='hidden' name='update' value='update' />";
                                finalView +="<input name='submit' type='submit' class='submit_btn' value='Update Marks' style='margin-left:640px;' />";
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