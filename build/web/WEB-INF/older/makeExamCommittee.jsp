<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="WebApp.Model.Teacher" %>
<%@page import="java.util.List" %>
<%@page import="WebApp.Model.ExamCommittee" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<meta charset='utf-8'>
<link rel='stylesheet' href='style.css' type='text/css' media='screen'>
</head>
<body>
<div class='container'>
  <!--centers the content between from header to footer-->
  <header  class='clearfix'>
  <img src='IMAGES/du.jpg' alt='' style='width=200px; height=300px; position:relative;left:50%;top:50%;margin-left:-100px;margin-right:-150px;'>
  <h1 class='left' align='center'><span>CSEDU </span> RESULT</h1>
	 
	 <p style=' color:#000099; font-size:20px;' align='center'>Make Exam Committee: </p>
	 <center>
	 <div id='contact_form2'>
              <% 
                  String view="";
                  ExamCommittee examCommittee = (ExamCommittee) request.getAttribute("examCommittee");
                  List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
                  
                  if(examCommittee==null)
                  {
                      view +="<form method='post' action='insertExamCommittee'><label>Session:</label><select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='session' name='session'/>";
                      String session_year ="";
                      int y =java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                
                        for(int i=-1;i<=2;i++)
                        {
                            session_year +="<option value='"+(y+i)+"-"+(y+i+1)+"'>"+(y+i)+"-"+(y+i+1)+"</option>";
                        }
                        view +=session_year+"</select><div class='cleaner_h10'></div>";
                        
                        view +="<label> Year: </label> <select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='year' name='year'/>";
                        view +="<option value='1st'>1st Year</option><option value='2nd'>2nd Year</option><option value='3rd'>3rd Year</option><option value='4th'>4th Year</option></select><div class='cleaner_h1'></div>";
                        
                        String examCommitteeName ="";
                        String examCommitteeEmail ="";
                        
                        if(teachers!=null)
                        {
                            for(Teacher teacher:teachers)
                            {
                                examCommitteeName +="<option value='"+teacher.getName()+"'>"+teacher.getName()+"</option>";
                                examCommitteeEmail +="<option value='"+teacher.getEmail()+"'>"+teacher.getEmail()+"</option>";
                            }
                          view +="<label>Chairman Name: </label><select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='chairman_name' name='chairman_name' >";
                          view +=examCommitteeName+"</select><div class='cleaner_h10'></div>";
                          view +="<label for='user'>Chairman Email: </label><select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='chairman_email' name='chairman_email' >";
                          view +=examCommitteeEmail+"</select><div class='cleaner_h10'></div>";
                          
                          view +="<label>Member Name: </label><select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='1stmem_name' name='1stmem_name' >";
                          view +=examCommitteeName+"</select><div class='cleaner_h10'></div>";
                          view +="<label for='user'>Chairman Email: </label><select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='1stmem_email' name='1stmem_email' >";
                          view +=examCommitteeEmail+"</select><div class='cleaner_h10'></div>";
                          
                          view +="<label>Member Name: </label><select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='2ndmem_name' name='2ndmem_name' >";
                          view +=examCommitteeName+"</select><div class='cleaner_h10'></div>";
                          view +="<label for='user'>Chairman Email: </label><select style='width: 265px;height:40px;font-size:15px; padding: 8px; background:#999999; border: 1px solid #000099; color: #FFF;' id='2ndmem_email' name='2ndmem_email' >";
                          view +=examCommitteeEmail+"</select><div class='cleaner_h10'></div>";
                          view +="<input name='submit' type='submit' class='submit_btn' value='Insert' /><input type='reset' class='submit_btn' value='Reset' /></form>";
                          
                        }
                   }
                  else if(teachers!=null)
                  {
                      String view1="";
                      String view2="";
                      String view3="";
                      for(Teacher teacher:teachers)
                      {
                          if(examCommittee.getChairmanEmail().equalsIgnoreCase(teacher.getEmail()))
                          {
                              view1 +="<div><h1>Exam Committee Chairman<h1><div class='cleaner_h10'></div>";
                              view1 +="<label> Name: </label>"+teacher.getName()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Designation: </label>"+teacher.getDesignation()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Department: </label>"+teacher.getDepartment()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Email: </label>"+teacher.getEmail()+"<div class='cleaner_h10'></div>";
                              view1 +="<label> Phone: </label>"+teacher.getPhone()+"<div class='cleaner_h10'></div>";
                              view1+="</div>"+"<div class='cleaner_h10'></div>";
                          }
                          else if(examCommittee.getFirstMemberEmail().equalsIgnoreCase(teacher.getEmail()))
                          {
                              view2 +="<div><h1>Exam Committee Member<h1><div class='cleaner_h10'></div>";
                              view2 +="<label> Name: </label>"+teacher.getName()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Designation: </label>"+teacher.getDesignation()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Department: </label>"+teacher.getDepartment()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Email: </label>"+teacher.getEmail()+"<div class='cleaner_h10'></div>";
                              view2 +="<label> Phone: </label>"+teacher.getPhone()+"<div class='cleaner_h10'></div>";
                              view2 +="</div>"+"<div class='cleaner_h10'></div>";
                          }
                          else
                          {
                              view3 +="<div><h1>Exam Committee Member<h1><div class='cleaner_h10'></div>";
                              view3 +="<label> Name: </label>"+teacher.getName()+"<div class='cleaner_h10'></div>";
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
	  </center>
</div>
</body>
  </html>