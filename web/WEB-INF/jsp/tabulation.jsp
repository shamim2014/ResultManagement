<%@page import="WebApp.Model.StudentTabulation"%>
<%@page import="java.util.List"%>
<%@page import="WebApp.Model.StudentTabulationHeader"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
<title>Tabulation</title>
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
            <%
                String viewMenu ="";
                String downlink =(String)  request.getAttribute("downlink");
                
                if(downlink!=null)
                {
                    viewMenu +="<li><a href='home'>Home</a></li>";
                    viewMenu +="<li><a href='download/tabulation.xls'>Download</a></li>";
                    viewMenu +="<li><a href='logout'>Logout</a></li>";
                }
                
                out.println(viewMenu);
            %>
            
        </ul> 
    </div>
</div> <!-- end of menu -->

<div id='templatemo_content_panel'>
	<div id='templatemo_content'>
            
            <% 
                String view ="<center><h1 style='font-family:'Times New Roman', Times, serif;font-size:30px;color:blue;'><span>Academic Transcript</span></h1>";
                 view +="<table style='width:750px;border:1px solid black;'>";
                 view +="<tr><th>Name of the Hall</th>";
                 view +="<th>Registration No.</th>";
                 view +="<th>Session</th>";
                 view +="<th>Class Roll No.</th>";
                 view +="<th>Exam Roll No.</th>";
                 view +="<th>Name of Examinee</th>";
                 view +="<th>Appearing Course Nos.</th>";
                 
                 StudentTabulationHeader studentTabulationHeader =(StudentTabulationHeader) request.getAttribute("studentTabulationHeader");
                 List<StudentTabulation> studentTabulations = (List<StudentTabulation>) request.getAttribute("studentTabulations");
                   
                             if(studentTabulationHeader!=null && studentTabulations!=null)
                             {
                                 if(studentTabulationHeader.getSemister()==8)
                                 {
                                     view +="<th>4th year 2nd semester SGPA</th>";
                                     view +="<th>4th year 1st semester SGPA</th>";
                                     view +="<th>4th year GPA</th>";
                                     view +="<th>3rd year GPA</th>";
                                     view +="<th>2nd year GPA</th>";
                                     view +="<th>1st year GP</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==7)
                                 {
                                     view +="<th>4th year 1st semester SGPA</th>";
                                     view +="<th>3rd year GPA</th>";
                                     view +="<th>2nd year GPA</th>";
                                     view +="<th>1st year GPA</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==6)
                                 {
                                     view +="<th>3rd year 2nd semester SGPA</th>";
                                     view +="<th>3rd year 1st semester SGPA</th>";
                                     view +="<th>3rd year GPA</th>";
                                     view +="<th>2nd year GPA</th>";
                                     view +="<th>1st year GPA</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==5)
                                 {
                                     view +="<th>3rd year 1st semester SGPA</th>";
                                     view +="<th>2nd year GPA</th>";
                                     view +="<th>1st year GPA</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==4)
                                 {
                                     view +="<th>2nd year 2nd semester SGPA</th>";
                                     view +="<th>2nd year 1st semester SGPA</th>";
                                     view +="<th>2nd year GPA</th>";
                                     view +="<th>1st year GPA</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==3)
                                 {
                                     view +="<th>2nd year 1st semester SGPA</th>";
                                     view +="<th>1st year GPA</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==2)
                                 {
                                     view +="<th>1st year 2nd semester SGPA</th>";
                                     view +="<th>1st year 1st semester SGPA</th>";
                                     view +="<th>1st year GPA</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==1)
                                 {
                                     view +="<th>1st year 1st semester SGPA</th>";
                                 }
                                  view +="<th>CGPA</th><th>Remarks</th></tr>";
                                  
                                  
                                  for(StudentTabulation studentTabulation : studentTabulations)
                                 {
                                      view +="<tr><td>"+studentTabulation.getNameOfHall()+"</td>";
                                      view +="<td>"+studentTabulation.getRegistration()+"</td>";
                                      view +="<td>"+studentTabulation.getRegistrationSession()+"</td>";
                                      view +="<td>"+studentTabulation.getDept_Roll()+"</td>";
                                      view +="<td>"+studentTabulation.getExamRoll()+"</td>";
                                      view +="<td>"+studentTabulation.getName()+"</td>";
                                      view +="<td>"+studentTabulation.getTheory().size()+"</td>";
                                      
                                      if(studentTabulationHeader.getSemister()==8)
                                     {
                                        view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                        view +="<td>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</td>";
                                        view +="<td>"+studentTabulation.getFourYearWeightedPoint()/studentTabulation.getFourYearCredit()+"</td>";
                                        view +="<td>"+studentTabulation.getThreeYearWeightedPoint()/studentTabulation.getThreeYearCredit()+"</td>";
                                        view +="<td>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</td>";
                                        view +="<td>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</td>";
                                    }
                                    else if(studentTabulationHeader.getSemister()==7)
                                    {
                                        view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                        view +="<td>"+studentTabulation.getThreeYearWeightedPoint()/studentTabulation.getThreeYearCredit()+"</td>";
                                        view +="<td>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</td>";
                                        view +="<td>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</td>";
                                    }
                                 else if(studentTabulationHeader.getSemister()==6)
                                 {
                                     view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                     view +="<td>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</td>";
                                     view +="<td>"+studentTabulation.getThreeYearWeightedPoint()/studentTabulation.getThreeYearCredit()+"</td>";
                                     view +="<td>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</td>";
                                     view +="<td>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</td>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==5)
                                 {
                                     view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                     view +="<td>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</td>";
                                     view +="<td>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</td>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==4)
                                 {
                                     view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                     view +="<td>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</td>";
                                     view +="<td>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</td>";
                                     view +="<td>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</td>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==3)
                                 {
                                     view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                     view +="<td>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</td>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==2)
                                 {
                                     view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                     view +="<td>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</td>";
                                     view +="<td>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</td>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==1)
                                 {
                                     view +="<td>"+studentTabulation.getSgpa()+"</td>";
                                 }
                                  view +="<td>"+studentTabulation.getTotalWeightedPoint()/studentTabulation.getTotalCredit()+"</td>";
                         
                                  
                                  if(studentTabulation.getTotalWeightedPoint()/studentTabulation.getTotalCredit()>=2.0)
                                      view +="<th>Passed</td></tr>";
                                  else
                                       view +="<th>Failed</td></tr>";
                                  
                                 
                                 }
                             }
                         view +="</table></center>";
                             out.println(view);
                 
            %>
                       
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