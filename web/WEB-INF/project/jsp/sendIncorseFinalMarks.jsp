<%@page import="WebApp.Model.TeacherCourse"%>
<%@page import="WebApp.Model.Incourse"%>
<%@page import="WebApp.Model.IncourseMarkDistribution"%>
<%@page import="WebApp.Model.IncourseExam"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Incoursemarksform</title>
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
                viewMenu +="<ul class='dropdown'><li><a href='theoryCourse?examiner=firstExaminer&course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Incourse Marks</a>";
                viewMenu +="<ul>";
                viewMenu +="<li><a href='IncourseExamForm?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Each Incourse Marks</a></li>";
                viewMenu +="<li><a href='IncourseMarkDistibution?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Final Incourse Marks</a></li>";
                viewMenu +="</ul></li>";
                
                viewMenu +="<li><a href='FinalMarksForm?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Semester Final Marks</a></li>";
                viewMenu +="<li><a href='#?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>View Marks</a>";
                viewMenu +="<ul>";
                viewMenu +="<li><a href='viewincoursemarks.html?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Incourse Marks</a></li>";
                viewMenu +="<li><a href='viewfinalmarks.html?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Semester Final Marks</a></li>";
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
                <div class='date_section'>                 
                </div>
            	<div class='post_content'>                	
		   <div id='contact_form2'>
                <%
                    List<IncourseExam> incourseExams =(List<IncourseExam> ) request.getAttribute("incourseExams");
                    IncourseMarkDistribution incourseMarkDistributuion =(IncourseMarkDistribution ) request.getAttribute("incourseMarkDistributuion");
                    
                    List<Incourse> incourses =(List<Incourse> ) request.getAttribute("incourses");
                    String message =(String) request.getParameter("errorMessage");
                    
                    if(message!=null)
                         out.println("<h1>"+message+"</h1>");
                    else 
                    {
                    String viewFinal = "<form method='post' action='insertIncourseTotal?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                    viewFinal +="<table>";
                    viewFinal +="<tr>";
                    viewFinal +="<th>Roll</th>";
                    
                    if(incourseMarkDistributuion.getIncourseExam1()!=0.0)
                          viewFinal +="<th >1st incourse<br />"+incourseMarkDistributuion.getIncourseExam1()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam2()!=0.0)
                          viewFinal +="<th >2nd incourse<br />"+incourseMarkDistributuion.getIncourseExam2()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam3()!=0.0)
                          viewFinal +="<th >3rd incourse<br />"+incourseMarkDistributuion.getIncourseExam3()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam4()!=0.0)
                          viewFinal +="<th >4th incourse<br />"+incourseMarkDistributuion.getIncourseExam4()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam()!=0.0)
                          viewFinal +="<th >incourse<br />"+incourseMarkDistributuion.getIncourseExam()+"</th>";
                    if(incourseMarkDistributuion.getAssignment()!=0.0)
                          viewFinal +="<th >Assignment<br />"+incourseMarkDistributuion.getAssignment()+"</th>";
                    if(incourseMarkDistributuion.getPresentation()!=0.0)
                          viewFinal +="<th >Presentation<br />"+incourseMarkDistributuion.getPresentation()+"</th>";
                    if(incourseMarkDistributuion.getSuddentTest()!=0.0)
                          viewFinal +="<th >Suddent Test<br />"+incourseMarkDistributuion.getSuddentTest()+"</th>";
                    if(incourseMarkDistributuion.getViva()!=0.0)
                          viewFinal +="<th >Viva<br />"+incourseMarkDistributuion.getViva()+"</th>";
                    if(incourseMarkDistributuion.getAttendance()!=0.0)
                          viewFinal +="<th >Attendance<br />"+incourseMarkDistributuion.getAttendance()+"</th>";
                    if(incourseMarkDistributuion.getTotalMarks()!=0.0)
                          viewFinal +="<th >Total<br />"+incourseMarkDistributuion.getTotalMarks()+"</th>";
                   
                    viewFinal +="</tr>";
                    int serial=0;
                    
                   if(incourses==null) 
                   {
                       for(IncourseExam incourseExam: incourseExams)
                     {
                        serial++;
                        viewFinal +="<tr>";
                        viewFinal +="<td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+incourseExam.getDept_Roll()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam1()!=0.0)
                             viewFinal +="<td><input type='text' id='exam1_marks_"+serial+"' name='exam1_marks_"+serial+"' value='"+incourseExam.getIncourseExam1()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam2()!=0.0)
                             viewFinal +="<td><input type='text' id='exam2_marks_"+serial+"' name='exam2_marks_"+serial+"' value='"+incourseExam.getIncourseExam2()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam3()!=0.0)
                              viewFinal +="<td><input type='text' id='exam3_marks_"+serial+"' name='exam3_marks_"+serial+"' value='"+incourseExam.getIncourseExam3()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam4()!=0.0)
                              viewFinal +="<td><input type='text' id='exam4_marks_"+serial+"' name='exam4_marks_"+serial+"' value='"+incourseExam.getIncourseExam4()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam()!=0.0)
                        {
                            if(incourseMarkDistributuion.getMarkingType()!=0 && incourseMarkDistributuion.getMarkingType()!=4)
                            {
                                viewFinal +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' value='"+incourseExam.getIncourseFinal()+"' class='required input_field2' required/></td>";
                            } 
                            else
                            {
                                viewFinal +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' class='required input_field2' /></td>";
                            }
                        }

                        if(incourseMarkDistributuion.getAssignment()!=0.0)
                              viewFinal +="<td><input type='text' id='assignment_"+serial+"' name='assignment_"+serial+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getPresentation()!=0.0)
                              viewFinal +="<td><input type='text' id='presentation_"+serial+"' name='presentation_"+serial+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getSuddentTest()!=0.0)
                              viewFinal +="<td><input type='text' id='suddent_"+serial+"' name='suddent_"+serial+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getViva()!=0.0)
                              viewFinal +="<td><input type='text' id='viva_"+serial+"' name='viva_"+serial+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getAttendance()!=0.0)
                              viewFinal +="<td><input type='text' id='attendance_"+serial+"' name='attendance_"+serial+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getTotalMarks()!=0.0)
                              viewFinal+="<td><input type='text' id='total_marks_"+serial+"' name='total_marks_"+serial+"' class='required input_field2' /></td>";
                        
                        viewFinal +="</tr>";
                        
                    }
                       
                    viewFinal +="</table>";
                    viewFinal +="<input type='hidden' name='student_no' value='"+serial+"' />";
                    viewFinal +="<div class='cleaner_h10'></div>";
                    viewFinal +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:350px;' />";
                    viewFinal +="<input name='submit' type='submit' class='submit_btn' value='Insert' />";
                   }
                   else
                   {
                      for(Incourse incourse : incourses)
                      {
                          serial++;
                        viewFinal +="<tr>";
                        viewFinal +="<td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+incourse.getDept_Roll()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam1()!=0.0)
                             viewFinal +="<td><input type='text' id='exam1_marks_"+serial+"' name='exam1_marks_"+serial+"' value='"+incourse.getIncourseExam1()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam2()!=0.0)
                              viewFinal +="<td><input type='text' id='exam2_marks_"+serial+"' name='exam2_marks_"+serial+"' value='"+incourse.getIncourseExam2()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam3()!=0.0)
                              viewFinal +="<td><input type='text' id='exam3_marks_"+serial+"' name='exam3_marks_"+serial+"' value='"+incourse.getIncourseExam3()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam4()!=0.0)
                               viewFinal +="<td><input type='text' id='exam4_marks_"+serial+"' name='exam4_marks_"+serial+"' value='"+incourse.getIncourseExam4()+"' class='required input_field2' /></td>";
                        
                        viewFinal +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' value='"+incourse.getIncourseFinal()+"' class='required input_field2' required/></td>";
                            

                        if(incourseMarkDistributuion.getAssignment()!=0.0)
                              viewFinal +="<td><input type='text' id='assignment_"+serial+"' name='assignment_"+serial+"' value='"+incourse.getAssignment()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getPresentation()!=0.0)
                             viewFinal +="<td><input type='text' id='presentation_"+serial+"' name='presentation_"+serial+"' value='"+incourse.getPresentation()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getSuddentTest()!=0.0)
                             viewFinal +="<td><input type='text' id='suddent_"+serial+"' name='suddent_"+serial+"' value='"+incourse.getSuddentTest()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getViva()!=0.0)
                              viewFinal +="<td><input type='text' id='viva_"+serial+"' name='viva_"+serial+"' value='"+incourse.getViva()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getAttendance()!=0.0)
                              viewFinal +="<td><input type='text' id='attendance_"+serial+"' name='attendance_"+serial+"' value='"+incourse.getAttendance()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getTotalMarks()!=0.0)
                              viewFinal +="<td><input type='text' id='total_marks_"+serial+"' name='total_marks_"+serial+"' value='"+incourse.getTotalObtainMarks()+"' class='required input_field2' /></td>";
                        
                        viewFinal +="</tr>";
                        
                    }
                       
                    viewFinal +="</table><input type='hidden' name='update' value='update' />";
                    viewFinal +="<input type='hidden' name='student_no' value='"+serial+"' />";
                    viewFinal +="<div class='cleaner_h10'></div>";
                    viewFinal +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:350px;' />";
                    viewFinal +="<input name='submit' type='submit' class='submit_btn' value='Update' />";

                     
                   }
                    viewFinal +="</form>";
                    
                    
                    
                       
                        out.println(viewFinal);
                    }
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