<%@page import="WebApp.Model.LabMark"%>
<%@page import="WebApp.Model.LabMarkingScale"%>
<%@page import="WebApp.Model.Student"%>
<%@page import="WebApp.Model.Student"%>
<%@page import="WebApp.Model.IncourseMarkDistribution"%>
<%@page import="WebApp.Model.Incourse"%>
<%@page import="WebApp.Model.FinalExamMark"%>
<%@page import="java.util.List" %>
<%@page import="WebApp.Model.TeacherCourse" %>

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Exam Committee Home</title>
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
                String courseCode =(String) request.getParameter("course_code");
                String courseSession =(String) request.getParameter("session");
                String courseType =(String) request.getParameter("courseType");
                if(courseCode!=null &&courseSession!=null && courseType!=null)
                {
                    viewMenu +="<ul class='dropdown'><li><a href='home'>Home</a></li><li><a href='LabMarkForm?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Insert Marks</a></li>";
                    viewMenu +="<li><a href='LabMarkView?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>View Marks</a></li>";
                    viewMenu +="<li><a href='logout'>Logout</a></li></ul>";
                }
                else if(courseCode!=null &&courseSession!=null)
                {
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
                }
                else
                {
                    viewMenu +="<ul class='dropdown'>";
                    viewMenu +="<li><a href='home'>Home</a></li><li><a href='logout'>Logout</a></li></ul>"; 
                }
                
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
                 <%
                    String comYear ="";
                    List<String> examYears =(List<String>) request.getAttribute("examYears");
                   
                   if(examYears!=null) 
                   { 
                       for(int i=0;i<examYears.size();i++)
                    {
                       comYear +="<ul>";
                       comYear +="<li> <a href='viewStudents?year="+examYears.get(i)+"'>"+examYears.get(i)+" Year</a></li>";
                       comYear +="</ul>";
                    }
                    
                    out.println(comYear);
                   }
                 %>
                    
                        
                    
                </div>
            </div>
           <div class='templatemo_content_left_section'>
           <div class='left_section_title'>Exam Courses</div>
                <div class='left_section_content'>
                <%
                   
                    String examCourse="";
                    {
                        if(examYears!=null) 
                        for(String examYear : examYears)
                    {
                       examCourse +="<ul>";
                       examCourse +="<li> <a href='ExamCourses?year="+examYear+"'>"+examYear+" Year</a></li>";
                       examCourse +="</ul>";
                    }
                    out.println(examCourse);
                    }
                 %>
                    
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
                List<FinalExamMark> finalExamMarks = (List<FinalExamMark>) request.getAttribute("finalExamMarks");
                List<Incourse> incourses =(List<Incourse> ) request.getAttribute("incourses");
                IncourseMarkDistribution incourseMarkDistributuion =(IncourseMarkDistribution ) request.getAttribute("incourseMarkDistributuion");
                List<Student> students = (List<Student>) request.getAttribute("students");
                LabMarkingScale labMarkingScale =(LabMarkingScale) request.getAttribute("labMarkingScale");
                List<LabMark> labMarks = (List<LabMark>)request.getAttribute("labMarks");
                
                
                if(finalExamMarks!=null)
                {
                    finalView +="<table >"; 
                    finalView +="<tr>";
                    finalView +="<th >Exam Roll</th><th >Q1 Marks</th><th >Q2 Marks</th><th >Q3 Marks</th><th>Q4 Marks</th><th>Q5 Marks</th><th>Q6 Marks</th></tr>";
                    
                    int serial=0;
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
                }
                else if(incourseMarkDistributuion!=null && incourses!=null)
                {
                    finalView +="<table>";
                    finalView +="<tr>";
                    finalView +="<th>Roll</th>";
                    
                    if(incourseMarkDistributuion.getIncourseExam1()!=0.0)
                          finalView +="<th >1st incourse<br />"+incourseMarkDistributuion.getIncourseExam1()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam2()!=0.0)
                          finalView +="<th >2nd incourse<br />"+incourseMarkDistributuion.getIncourseExam2()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam3()!=0.0)
                          finalView +="<th >3rd incourse<br />"+incourseMarkDistributuion.getIncourseExam3()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam4()!=0.0)
                          finalView +="<th >4th incourse<br />"+incourseMarkDistributuion.getIncourseExam4()+"</th>";
                    if(incourseMarkDistributuion.getIncourseExam()!=0.0)
                          finalView +="<th >incourse<br />"+incourseMarkDistributuion.getIncourseExam()+"</th>";
                    if(incourseMarkDistributuion.getAssignment()!=0.0)
                          finalView +="<th >Assignment<br />"+incourseMarkDistributuion.getAssignment()+"</th>";
                    if(incourseMarkDistributuion.getPresentation()!=0.0)
                          finalView +="<th >Presentation<br />"+incourseMarkDistributuion.getPresentation()+"</th>";
                    if(incourseMarkDistributuion.getSuddentTest()!=0.0)
                          finalView +="<th >Suddent Test<br />"+incourseMarkDistributuion.getSuddentTest()+"</th>";
                    if(incourseMarkDistributuion.getViva()!=0.0)
                          finalView +="<th >Viva<br />"+incourseMarkDistributuion.getViva()+"</th>";
                    if(incourseMarkDistributuion.getAttendance()!=0.0)
                          finalView +="<th >Attendance<br />"+incourseMarkDistributuion.getAttendance()+"</th>";
                    if(incourseMarkDistributuion.getTotalMarks()!=0.0)
                          finalView +="<th >Total<br />"+incourseMarkDistributuion.getTotalMarks()+"</th>";
                   
                    finalView +="</tr>";
                    int serial=0;
                    for(Incourse incourse : incourses)
                     {
                          serial++;
                        finalView +="<tr>";
                        finalView +="<td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+incourse.getDept_Roll()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam1()!=0.0)
                             finalView +="<td><input type='text' id='exam1_marks_"+serial+"' name='exam1_marks_"+serial+"' value='"+incourse.getIncourseExam1()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam2()!=0.0)
                              finalView +="<td><input type='text' id='exam2_marks_"+serial+"' name='exam2_marks_"+serial+"' value='"+incourse.getIncourseExam2()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam3()!=0.0)
                              finalView +="<td><input type='text' id='exam3_marks_"+serial+"' name='exam3_marks_"+serial+"' value='"+incourse.getIncourseExam3()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getIncourseExam4()!=0.0)
                               finalView +="<td><input type='text' id='exam4_marks_"+serial+"' name='exam4_marks_"+serial+"' value='"+incourse.getIncourseExam4()+"' class='required input_field2' /></td>";
                        
                        finalView +="<td><input type='text' id='exam_marks_"+serial+"' name='exam_marks_"+serial+"' value='"+incourse.getIncourseFinal()+"' class='required input_field2' required/></td>";
                            

                        if(incourseMarkDistributuion.getAssignment()!=0.0)
                              finalView +="<td><input type='text' id='assignment_"+serial+"' name='assignment_"+serial+"' value='"+incourse.getAssignment()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getPresentation()!=0.0)
                             finalView +="<td><input type='text' id='presentation_"+serial+"' name='presentation_"+serial+"' value='"+incourse.getPresentation()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getSuddentTest()!=0.0)
                             finalView +="<td><input type='text' id='suddent_"+serial+"' name='suddent_"+serial+"' value='"+incourse.getSuddentTest()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getViva()!=0.0)
                              finalView +="<td><input type='text' id='viva_"+serial+"' name='viva_"+serial+"' value='"+incourse.getViva()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getAttendance()!=0.0)
                              finalView +="<td><input type='text' id='attendance_"+serial+"' name='attendance_"+serial+"' value='"+incourse.getAttendance()+"' class='required input_field2' /></td>";
                        if(incourseMarkDistributuion.getTotalMarks()!=0.0)
                              finalView +="<td><input type='text' id='total_marks_"+serial+"' name='total_marks_"+serial+"' value='"+incourse.getTotalObtainMarks()+"' class='required input_field2' /></td>";
                        
                        finalView +="</tr>";
                        
                    }
                       
                    finalView +="</table>";
                    finalView +="<div class='cleaner_h10'></div>";
                        
                   }
                 else if(students!=null)
                 { 
                       finalView +="<table><tr><th>name</th><th>dept roll</th><th>current session</th><th>gender</th><th>batch</th><th>exam roll</th><th>email</th><th>phone</th><th>regi_session </th><th>registration</th><th>hall</th></tr>";
                        for(Student student:students)
                        {
                            finalView +="<tr><td>"+student.getName()+"</td><td>"+student.getDeptRoll()+"</td><td>"+student.getSession()+"</td><td>"+student.getGender()+"</td><td>"+student.getBatch()+"</td><td>"+student.getExamRoll()+"</td><td>"+student.getEmail()+"</td><td>"+student.getPhone()+"</td><td>"+student.getRegistrationSession()+"</td><td>"+student.getRegistration()+"</td><td>"+student.getHall()+"</td></tr>";                    
                        }
                       finalView +="</table>";
                 }
                else if(labMarks!=null && labMarkingScale!=null)
                {
                    finalView +="<table  style='width:500px;border:1px solid black;'>";
                    finalView +="<tr><th >Roll</th>";  
                               
                    if(labMarkingScale.getAssessment()!=0.0)
                    {
                        finalView +="<th >Assessment<br />"+labMarkingScale.getAssessment()+"</th>";
                    }
                    if(labMarkingScale.getLab_exam()!=0.0)
                    {
                        finalView +="<th >Exam<br />"+labMarkingScale.getLab_exam()+"</th>";
                    }
                    if(labMarkingScale.getViva()!=0.0)
                    {
                        finalView +="<th >Viva<br />"+labMarkingScale.getViva()+"</th>";
                    }
                    if(labMarkingScale.getAssignment()!=0.0)
                    {
                        finalView +="<th >Assignment<br />"+labMarkingScale.getAssignment()+"</th>";
                    }
                    if(labMarkingScale.getPresentation()!=0.0)
                    {
                        finalView +="<th >Presentation<br />"+labMarkingScale.getPresentation()+"</th>";
                    }
                    if(labMarkingScale.getProject()!=0.0)
                    {
                        finalView +="<th >Project<br />"+labMarkingScale.getProject()+"</th>";
                    }
                    if(labMarkingScale.getReport()!=0.0)
                    {
                        finalView +="<th >Report<br />"+labMarkingScale.getReport()+"</th>";
                    }
                               if(labMarkingScale.getAttendance()!=0.0)
                               {
                                   finalView +="<th >Attendance<br />"+labMarkingScale.getReport()+"</th>";
                               }
                               if(labMarkingScale.getTotalMarks()!=0.0)
                               {
                                   finalView +="<th >TotalMarks<br />"+labMarkingScale.getTotalMarks()+"</th>";
                               }
                              
                               finalView +="</tr>";
                               
                    int serial=0;
                    for(LabMark labMark : labMarks)
                    {
                        serial++; 
                        finalView +="<tr><td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+labMark.getDept_Roll()+"' class='required input_field2' /></td>";

                        if(labMarkingScale.getAssessment()!=0.0)
                        {
                             finalView +="<td><input type='text' id='assessment_marks"+serial+"' name='assessment_marks"+serial+"' value='"+labMark.getAssessment()+"' class='required input_field2' /></td>";
                         }
                         if(labMarkingScale.getLab_exam()!=0.0)
                         {
                             finalView +="<td><input type='text' id='lab_exam_marks"+serial+"' name='lab_exam_marks"+serial+"' value='"+labMark.getLab_exam()+"' class='required input_field2' /></td>";
                         }
                         if(labMarkingScale.getViva()!=0.0)
                          {
                              finalView +="<td><input type='text' id='viva_marks"+serial+"' name='viva_marks"+serial+"' value='"+labMark.getViva()+"' class='required input_field2' /></td>";
                          }
                                    if(labMarkingScale.getAssignment()!=0.0)
                                    {
                                        finalView +="<td><input type='text' id='assignment_marks"+serial+"' name='assignment_marks"+serial+"' value='"+labMark.getAssignment()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getPresentation()!=0.0)
                                    {
                                        finalView +="<td><input type='text' id='presentation_marks"+serial+"' name='presentation_marks"+serial+"' value='"+labMark.getPresentation()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getReport()!=0.0)
                                    {
                                        finalView +="<td><input type='text' id='report_marks"+serial+"' name='report_marks"+serial+"' value='"+labMark.getReport()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getProject()!=0.0)
                                    {
                                        finalView +="<td><input type='text' id='project_marks"+serial+"' name='project_marks"+serial+"' value='"+labMark.getProject()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getAttendance()!=0.0)
                                    {
                                        finalView +="<td><input type='text' id='attendance_marks"+serial+"' name='attendance_marks"+serial+"' value='"+labMark.getAttendance()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getTotalMarks()!=0.0)
                                    {
                                        finalView +="<td><input type='text' id='total_marks"+serial+"' name='total_marks"+serial+"' value='"+labMark.getTotalMarks()+"' class='required input_field2' /></td>";
                                    }

                                       finalView+="</tr>";
                                    }
                                    finalView +="</table>";
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