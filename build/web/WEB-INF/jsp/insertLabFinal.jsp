<%-- 
    Document   : insertLabFinal
    Created on : Feb 24, 2015, 10:03:08 PM
    Author     : USER
--%>

<%@page import="WebApp.Model.LabMark"%>
<%@page import="WebApp.Model.Student"%>
<%@page import="WebApp.Model.LabMarkingScale"%>
<%@page import="WebApp.Model.TeacherCourse"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lab</title>
<link href="CSS/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="templatemo_top_panel">
	<div id="templatemo_header_section">
    </div> <!-- end of header -->
</div>    
    
<div id="templatemo_menu_panel">
    <div id="templatemo_menu_section">
        <ul class="dropdown">
            
            <%
                String viewMenu ="";
                viewMenu +="<li><a href='home'>Home</a></li><li><a href='LabMarkForm?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Insert Marks</a></li>";
                viewMenu +="<li><a href='LabMarkView?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>View Marks</a></li>";
                viewMenu +="<li><a href='logout'>Logout</a></li>";
                out.println(viewMenu);
             %>             
        </ul> 
    </div>
</div> <!-- end of menu -->

<div id="templatemo_content_panel">
	<div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<div class="left_section_title">Courses</div>
                <div class="left_section_content">
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
                      
            <div class="templatemo_content_left_section">
            	<div class="left_section_title">Students</div>
                <div class="left_section_content">
                	<ul>
                        <li> <a href="#">1st year</a></li>
                        <li><a href="#">2nd year</a></li>
                        <li><a href="#">3rd year</a></li>
                        <li><a href="#">4th year</a></li>
                    </ul>
                </div>
            </div>
            
            <div class="templatemo_content_left_section">
            	<div class="left_section_title">Exam Committee</div>
                <div class="left_section_content">
                	<ul>	
                        <li> <a href="#">1st year</a></li>
                        <li><a href="#">2nd year</a></li>
                        <li><a href="#">3rd year</a></li>
                        <li><a href="#">4th year</a></li>
                    </ul>
                </div>
            </div>
         </div> <!-- end of content left -->
         
         <div id="templatemo_content_right">
        	<div class="templatemo_post_section">
                <div class="date_section">                 
                </div>
            	<div class="post_content">                	
					<div id="contact_form2">
                                            
                        <%
                               LabMarkingScale labMarkingScale =(LabMarkingScale) request.getAttribute("labMarkingScale");
                               String dataTable="<form method='post' action='InsertLabMark?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                               dataTable +="<table  style='width:500px;border:1px solid black;'>";
                               dataTable +="<tr><th >Roll</th>";  
                               
                               if(labMarkingScale.getAssessment()!=0.0)
                               {
                                   dataTable +="<th >Assessment<br />"+labMarkingScale.getAssessment()+"</th>";
                               }
                               if(labMarkingScale.getLab_exam()!=0.0)
                               {
                                   dataTable +="<th >Exam<br />"+labMarkingScale.getLab_exam()+"</th>";
                               }
                               if(labMarkingScale.getViva()!=0.0)
                               {
                                   dataTable +="<th >Viva<br />"+labMarkingScale.getViva()+"</th>";
                               }
                               if(labMarkingScale.getAssignment()!=0.0)
                               {
                                   dataTable +="<th >Assignment<br />"+labMarkingScale.getAssignment()+"</th>";
                               }
                               if(labMarkingScale.getPresentation()!=0.0)
                               {
                                   dataTable +="<th >Presentation<br />"+labMarkingScale.getPresentation()+"</th>";
                               }
                               if(labMarkingScale.getProject()!=0.0)
                               {
                                   dataTable +="<th >Project<br />"+labMarkingScale.getProject()+"</th>";
                               }
                               if(labMarkingScale.getReport()!=0.0)
                               {
                                   dataTable +="<th >Report<br />"+labMarkingScale.getReport()+"</th>";
                               }
                               if(labMarkingScale.getAttendance()!=0.0)
                               {
                                   dataTable +="<th >Attendance<br />"+labMarkingScale.getReport()+"</th>";
                               }
                               if(labMarkingScale.getTotalMarks()!=0.0)
                               {
                                   dataTable +="<th >TotalMarks<br />"+labMarkingScale.getTotalMarks()+"</th>";
                               }
                              
                               dataTable +="</tr>";
                               
                               List<Student> students =(List<Student>) request.getAttribute("students");
                               List<LabMark> labMarks = (List<LabMark>)request.getAttribute("labMarks");
                               int serial=0;
                              
                               if(students!=null)
                               {
                                        for(Student student : students)
                                    {
                                       serial++; 
                                       dataTable +="<tr><td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+student.getDeptRoll()+"' class='required input_field2' /></td>";

                                       if(labMarkingScale.getAssessment()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='assessment_marks"+serial+"' name='assessment_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getLab_exam()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='lab_exam_marks"+serial+"' name='lab_exam_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getViva()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='viva_marks"+serial+"' name='viva_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getAssignment()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='assignment_marks"+serial+"' name='assignment_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getPresentation()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='presentation_marks"+serial+"' name='presentation_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getReport()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='report_marks"+serial+"' name='report_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getProject()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='project_marks"+serial+"' name='project_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getAttendance()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='attendance_marks"+serial+"' name='attendance_marks"+serial+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getTotalMarks()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='total_marks"+serial+"' name='total_marks"+serial+"' class='required input_field2' /></td>";
                                    }

                                       dataTable+="</tr>";
                                    }
                                    dataTable +="</table><input type='hidden' name='student_no' value='"+serial+"' /><div class='cleaner_h10'></div>";
                                    dataTable +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:350px;' />";

                                    dataTable +="<input name='submit' type='submit' class='submit_btn' value='Insert' /></form>";
                               }
                               else if(labMarks!=null)
                               {
                                   for(LabMark labMark : labMarks)
                                   {
                                      serial++; 
                                       dataTable +="<tr><td><input type='text' id='roll_"+serial+"' name='roll_"+serial+"' value='"+labMark.getDept_Roll()+"' class='required input_field2' /></td>";

                                       if(labMarkingScale.getAssessment()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='assessment_marks"+serial+"' name='assessment_marks"+serial+"' value='"+labMark.getAssessment()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getLab_exam()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='lab_exam_marks"+serial+"' name='lab_exam_marks"+serial+"' value='"+labMark.getLab_exam()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getViva()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='viva_marks"+serial+"' name='viva_marks"+serial+"' value='"+labMark.getViva()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getAssignment()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='assignment_marks"+serial+"' name='assignment_marks"+serial+"' value='"+labMark.getAssignment()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getPresentation()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='presentation_marks"+serial+"' name='presentation_marks"+serial+"' value='"+labMark.getPresentation()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getReport()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='report_marks"+serial+"' name='report_marks"+serial+"' value='"+labMark.getReport()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getProject()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='project_marks"+serial+"' name='project_marks"+serial+"' value='"+labMark.getProject()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getAttendance()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='attendance_marks"+serial+"' name='attendance_marks"+serial+"' value='"+labMark.getAttendance()+"' class='required input_field2' /></td>";
                                    }
                                    if(labMarkingScale.getTotalMarks()!=0.0)
                                    {
                                        dataTable +="<td><input type='text' id='total_marks"+serial+"' name='total_marks"+serial+"' value='"+labMark.getTotalMarks()+"' class='required input_field2' /></td>";
                                    }

                                       dataTable+="</tr>";
                                    }
                                    dataTable +="</table><input type='hidden' name='student_no' value='"+serial+"' /><input type='hidden' name='update' value='update' /><div class='cleaner_h10'></div>";
                                    dataTable +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:350px;' />";

                                    dataTable +="<input name='submit' type='submit' class='submit_btn' value='Update' /></form>";
                               }
                               out.println(dataTable);
                        %>				
						
						
		</div>                   
                </div>
            </div> <!-- end of 1 post -->
        </div> <!-- end of content right -->
        
		<div class="cleaner_with_height">&nbsp;</div>
    </div>
</div> <!-- end of content panel -->

<div id="templatemo_footer_panel">
    <div id="templatemo_footer_section">
       Department of Computer Science & Engineering,University of Dhaka
	   <br /> Science Complex Building,Mokarram Bhaban
		</div>
</div>
</body>
</html>