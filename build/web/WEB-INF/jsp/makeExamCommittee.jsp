<%@page import="java.util.List"%>
<%@page import="WebApp.Model.ExamCommittee"%>
<%@page import="WebApp.Model.Teacher"%>
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
                  String view="";
                  ExamCommittee examCommittee = (ExamCommittee) request.getAttribute("examCommittee");
                  List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
                  
                  if(examCommittee==null)
                  {
                      view +="<form method='post' action='insertExamCommittee'><label>Session:</label><select class='select2' id='session' name='session'/>";
                      String session_year ="";
                      int y =java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                
                        for(int i=-1;i<=2;i++)
                        {
                            session_year +="<option value='"+(y+i)+"-"+(y+i+1)+"'>"+(y+i)+"-"+(y+i+1)+"</option>";
                        }
                        view +=session_year+"</select><div class='cleaner_h10'></div>";
                        
                        view +="<label> Year: </label> <select class='select2' id='year' name='year'/>";
                        view +="<option value='1st'>1st Year</option><option value='2nd'>2nd Year</option><option value='3rd'>3rd Year</option><option value='4th'>4th Year</option></select><div class='cleaner_h1'></div>";
                        
                        view +="<div class='cleaner_h10'></div>";
                        String examCommitteeName ="";
                        String examCommitteeEmail ="";
                        
                        if(teachers!=null)
                        {
                            for(Teacher teacher:teachers)
                            {
                                examCommitteeName +="<option value='"+teacher.getName()+"'>"+teacher.getName()+"</option>";
                                examCommitteeEmail +="<option value='"+teacher.getEmail()+"'>"+teacher.getEmail()+"</option>";
                            }
                          view +="<label>Chairman Name: </label><select class='select2' id='chairman_name' name='chairman_name' >";
                          view +=examCommitteeName+"</select><div class='cleaner_h10'></div>";
                          view +="<label for='user'>Chairman Email: </label><select class='select2' id='chairman_email' name='chairman_email' >";
                          view +=examCommitteeEmail+"</select><div class='cleaner_h10'></div>";
                          
                          view +="<label>Member Name: </label><select class='select2' id='1stmem_name' name='1stmem_name' >";
                          view +=examCommitteeName+"</select><div class='cleaner_h10'></div>";
                          view +="<label for='user'>Chairman Email: </label><select class='select2' id='1stmem_email' name='1stmem_email' >";
                          view +=examCommitteeEmail+"</select><div class='cleaner_h10'></div>";
                          
                          view +="<label>Member Name: </label><select class='select2' id='2ndmem_name' name='2ndmem_name' >";
                          view +=examCommitteeName+"</select><div class='cleaner_h10'></div>";
                          view +="<label for='user'>Chairman Email: </label><select class='select2' id='2ndmem_email' name='2ndmem_email' >";
                          view +=examCommitteeEmail+"</select><div class='cleaner_h10'></div>";
                          view +="<input type='reset' class='reset_btn' value='Reset' style='margin-left:280px;' /><input name='submit' type='submit' class='submit_btn' value='Insert' /></form>";
                          
                        }
                   }
                  else if(teachers!=null)
                  {
                      String view1="";
                      String view2="";
                      String view3="";
                      String view4="";
                      String view5="";
                      String view6="";
                      for(Teacher teacher:teachers)
                      {
                          if(examCommittee.getChairmanEmail().equalsIgnoreCase(teacher.getEmail()))
                          {
                              view1 +="<h1 style='font-family:'Times New Roman', Times, serif;font-size:30px;color:blue;'>Exam Committee Chairman</h1><div class='cleaner_h10'></div>";
                              view1 +="<div><label> Name: </label>"+teacher.getName()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Designation: </label>"+teacher.getDesignation()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Department: </label>"+teacher.getDepartment()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Email: </label>"+teacher.getEmail()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Phone: </label>"+teacher.getPhone()+"<div class='cleaner_h10'></div>";
                              view1+="</div>"+"<div class='cleaner_h10'></div>";
                          }
                          else if(examCommittee.getFirstMemberEmail().equalsIgnoreCase(teacher.getEmail()))
                          {
                              view2 +="<h1 style='font-family:'Times New Roman', Times, serif;font-size:30px;color:blue;'>Exam Committee Member</h1><div class='cleaner_h10'></div>";
                              view2 +="<div><label> Name: </label>"+teacher.getName()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Designation: </label>"+teacher.getDesignation()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Department: </label>"+teacher.getDepartment()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Email: </label>"+teacher.getEmail()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Phone: </label>"+teacher.getPhone()+"<div class='cleaner_h10'></div>";
                              view2 +="</div>"+"<div class='cleaner_h10'></div>";
                          }
                          else
                          {
                              view3 +="<h1 style='font-family:'Times New Roman', Times, serif;font-size:30px;color:blue;'>Exam Committee Member</h1><div class='cleaner_h10'></div>";
                              view3 +="<div><label> Name: </label>"+teacher.getName()+"<div class='cleaner_h10'></div>";
                              view3 +="<label> Designation: </label>"+teacher.getDesignation()+"<div class='cleaner_h10'></div>";
                              view3 +="<label> Department: </label>"+teacher.getDepartment()+"<div class='cleaner_h10'></div>";
                              view3 +="<label> Email: </label>"+teacher.getEmail()+"<div class='cleaner_h10'></div>";
                              view3 +="<label> Phone: </label>"+teacher.getPhone()+"<div class='cleaner_h10'></div>";
                              view3 +="</div>"+"<div class='cleaner_h10'></div>";
                          }
                      }
                      
                      view +=view1+view2+view3;
                   
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