<%@page import="WebApp.Model.TeacherCourse"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComCourse</title>
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
               String viewMenu="<li><a href='home'"+request.getAttribute("year")+">Home</a>";
                     
                      if(request.getParameter("year")!=null)
                       viewMenu +="<li><a href='makeFinalResult?year="+request.getParameter("year")+"'>Tabulation</a></li> ";
                      viewMenu +="<li><a href='logout'>Logout</a></li> ";
                      
                      out.println(viewMenu);
            %>
		    
                        
         </ul>        
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
                   
                    
                    for(String examYear : examYears)
                    {
                       comYear +="<ul>";
                       comYear +="<li> <a href='viewStudents?year="+examYear+"'>"+examYear+" Year</a></li>";
                       comYear +="</ul>";
                    }
                    
                    out.println(comYear);
                 %>
                    
                        
                    
                </div>
            </div>
           <div class='templatemo_content_left_section'>
           <div class='left_section_title'>Exam Courses</div>
                <div class='left_section_content'>
                <%
                   
                    String examCourse="";
                    for(String examYear : examYears)
                    {
                       examCourse +="<ul>";
                       examCourse +="<li> <a href='ExamCourses?year="+examYear+"'>"+examYear+" Year</a></li>";
                       examCourse +="</ul>";
                    }
                    out.println(examCourse);
                 %>
                    
                </div>
            </div>
            
         </div> <!-- end of content left -->
         
         <div id="templatemo_content_right">
        	<div class="templatemo_post_section">
                <div class="date_section">                 
                </div>
            	<div class="post_content">                	
                    <div class="post_title">
                    	<h1>Course Teacher(s)</h1>
                    </div>
                    
                    <div class="post_body">
                        
                       <table  style="width:600px;border:1px solid black;">
						<tr>
						<th width="200">Name</th>
						<th width="200">Email</th>
						<th width="100">Designation</th>
						<th width="100">Cell Number</th>
						</tr>
						<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						</tr>
						</table>
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