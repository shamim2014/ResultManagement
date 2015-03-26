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
         
         <div id="templatemo_content_right">
        	<div class="templatemo_post_section">
                <div class="date_section">                 
                </div>
            	<div class="post_content">                	
                    <div class="post_title">
                    	<h1>CSEDU Result</h1>
                    </div>
                    
                    <div class="post_body">
                        <img src="IMAGES/templatemo_image_01.jpg" alt="image" />
                        <p>So,manage each section of result management and get the accurate result within the shortest time!!!!</p>
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
