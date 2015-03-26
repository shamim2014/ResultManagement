<%@page import="WebApp.Model.ExamCommittee"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1>${exam.getChairmanId()}</h1>
            <h1>${s}</h1>
            <h1>${shamim}</h1>
            
            <% out.println("last"); %>
            <% out.println(((ExamCommittee)request.getAttribute("examCommittee")).getChairmanId()); %>
            
        </body>
</html>

