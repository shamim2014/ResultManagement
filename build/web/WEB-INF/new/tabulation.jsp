<%-- 
    Document   : tabulation
    Created on : Jan 17, 2015, 11:53:39 PM
    Author     : shamim
--%>

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
                    <th>
                     <table>
                         <tr><th>Honours Courses and Grades</th></tr>
                         <tr><th>Theory Courses</th> <th>Lab Courses</th></tr>
                         
                         <%
                             List<Course> courses = (List<Course>) request.getAttribute("courses");
                             String courseCode="<tr>";
                             String credit="</tr><tr>";
                             String courseName="</tr><tr>";
                             String grade="</tr><tr>";
                             for(int i=0;i<courses.size();i++)
                             {
                                 courseCode+="<th>Course No. "+courses.get(i).getCourseCode()+"</th>";
                                 credit+="<th>"+courses.get(i).getCredit()+" Credits</th>";
                                 courseName+="<th>"+courses.get(i).getTitle()+" Credits</th>";
                                 grade+="<th>Grade Point</th><th>Grade</th>";
                             }
                             grade+="</tr>";
                             courseCode+=credit+courseName+grade;
                             out.print(courseCode);
                         %>
                       
                     </table>
                    </th>
                    <th>Cumulative Grade Point Average (CGPA)(160 Credits)</th>
                    <th>Result</th>
                    <th>Remarks</th>
                </tr>
            </table>
        </div>
    </body>
</html>
