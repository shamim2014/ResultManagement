<%-- 
    Document   : tabulation
    Created on : Jan 17, 2015, 11:53:39 PM
    Author     : shamim
--%>

<%@page import="WebApp.Model.StudentTabulation"%>
<%@page import="WebApp.Model.StudentTabulationHeader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="WebApp.Model.Course" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="CSS/NewExcelFile.xls">Download</a>
        <div>
            <table> 
                <tr> 
                    <th>Name of the Hall</th>
                    <th>Registration No.</th>
                    <th>Session</th>
                    <th>Class Roll No.</th>
                    <th>Exam Roll No.</th>
                    <th>Name of Examinee</th>
                    <th>Appearing Course Nos.</th>
                    
                     
                         <%
                             StudentTabulationHeader studentTabulationHeader =(StudentTabulationHeader) request.getAttribute("studentTabulationHeader");
                             List<StudentTabulation> studentTabulations = (List<StudentTabulation>) request.getAttribute("studentTabulations");
                             String view ="";
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
                                 else if(studentTabulationHeader.getSemister()==4)
                                 {
                                     view +="<th>1st year 2nd semester SGPA</th>";
                                     view +="<th>1st year 1st semester SGPA</th>";
                                     view +="<th>1st year GPA</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==3)
                                 {
                                     view +="<th>2nd year 1st semester SGPA</th>";
                                 }
                                  view +="<th>CGPA< br /></th><th>Result</th><th>Remarks</th></tr>";
                                  
                                  
                                  for(StudentTabulation studentTabulation : studentTabulations)
                                 {
                                      view +="<tr><th>"+studentTabulation.getNameOfHall()+"</th>";
                                      view +="<th>"+studentTabulation.getRegistration()+"</th>";
                                      view +="<th>"+studentTabulation.getRegistrationSession()+"</th>";
                                      view +="<th>"+studentTabulation.getDept_Roll()+"</th>";
                                      view +="<th>"+studentTabulation.getExamRoll()+"</th>";
                                      view +="<th>"+studentTabulation.getName()+"</th>";
                                      view +="<th>"+studentTabulation.getTheory().size()+"</th>";
                                      
                                      if(studentTabulationHeader.getSemister()==8)
                                     {
                                        view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                        view +="<th>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</th>";
                                        view +="<th>"+studentTabulation.getFourYearWeightedPoint()/studentTabulation.getFourYearCredit()+"</th>";
                                        view +="<th>"+studentTabulation.getThreeYearWeightedPoint()/studentTabulation.getThreeYearCredit()+"</th>";
                                        view +="<th>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</th>";
                                        view +="<th>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</th>";
                                    }
                                    else if(studentTabulationHeader.getSemister()==7)
                                    {
                                        view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                        view +="<th>"+studentTabulation.getThreeYearWeightedPoint()/studentTabulation.getThreeYearCredit()+"</th>";
                                        view +="<th>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</th>";
                                        view +="<th>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</th>";
                                    }
                                 else if(studentTabulationHeader.getSemister()==6)
                                 {
                                     view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                     view +="<th>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</th>";
                                     view +="<th>"+studentTabulation.getThreeYearWeightedPoint()/studentTabulation.getThreeYearCredit()+"</th>";
                                     view +="<th>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</th>";
                                     view +="<th>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==5)
                                 {
                                     view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                     view +="<th>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</th>";
                                     view +="<th>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==4)
                                 {
                                     view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                     view +="<th>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</th>";
                                     view +="<th>"+studentTabulation.getTwoYearWeightedPoint()/studentTabulation.getTwoYearCredit()+"</th>";
                                     view +="<th>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==3)
                                 {
                                     view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                     view +="<th>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==2)
                                 {
                                     view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                     view +="<th>"+studentTabulation.getPrevouseWeightedPoint()/studentTabulation.getPrevouseTotalCredit()+"</th>";
                                     view +="<th>"+studentTabulation.getOneYearWeightedPoint()/studentTabulation.getOneYearCredit()+"</th>";
                                 }
                                 else if(studentTabulationHeader.getSemister()==1)
                                 {
                                     view +="<th>"+studentTabulation.getSgpa()+"</th>";
                                 }
                                  view +="<th>"+studentTabulation.getTotalWeightedPoint()/studentTabulation.getTotalCredit()+"</th>";
                                  view +="<th>"+studentTabulation.getTotalWeightedPoint()/studentTabulation.getTotalCredit()+"</th>";
                                  
                                  if(studentTabulation.getTotalWeightedPoint()/studentTabulation.getTotalCredit()>=2.0)
                                      view +="<th>Passed</th></tr>";
                                  else
                                       view +="<th>Failed</th></tr>";
                                  
                                 
                                 }
                             }
                             
                             out.println(view);
                         %>
                        
         
                
            </table>
        </div>
    </body>
</html>
