<%@page import="WebApp.Model.TeacherCourse"%>
<%@page import="java.util.List"%>

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
                viewMenu +="<li><a href='LabMarkForm?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>Insert Marks</a></li>";
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
            	<div class="post_content">                	
                     <div id="contact_form2">
                         
                    <%
                         String scaleView ="";
                         
                         scaleView +="<form method='post' action='labScle?course_code="+request.getParameter("course_code")+"&session="+request.getParameter("session")+"'>";
                     
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='assessment' value='assessment'/>";
                         scaleView +="<div class='chekbox'>Continuous Evaluation:</div>";
                         scaleView +="<input type='text' id='assessment_marks' name='assessment_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='lab_exam' value='lab_exam' /> <div class='chekbox'> LAB EXAM: </div><input type='text' id='lab_exam_marks' name='lab_exam_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='project' value='project' /> <div class='chekbox'> Project: </div><input type='text' id='project_marks' name='project_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='viva' value='viva' /> <div class='chekbox'> Viva: </div> <input type='text' id='viva_marks' name='viva_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='report' value='report'  /> <div class='chekbox'> Report: </div> <input type='text' id='report_marks' name='report_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='attendance' value='attendance'  /><div class='chekbox'> Attendance: </div> <input type='text' id='attendance_marks' name='attendance_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='assignment' value='assignment' > <div class='chekbox'> Assignment:  </div><input type='text' id='assignment_marks' name='assignment_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='presentation' value='presentation' /> <div class='chekbox'> Presentation:</div> <input type='text' id='presentation_marks' name='presentation_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='checkbox' name='total' value='total' /> <div class='chekbox'> Total Marks:</div> <input type='text' id='total_marks' name='total_marks' placeholder='mark(%)' class='required input_field' /><br/>";
                         scaleView +="<div class='cleaner_h10'></div>";
                         scaleView +="<input type='submit' class='submit_btn' value='Submit'style='margin-left:385px;'>";
                         scaleView +="</form>";
                         
                         
                         out.println(scaleView);
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