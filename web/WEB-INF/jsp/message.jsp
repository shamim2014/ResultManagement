<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:out value="${message}" />
<% 
    out.println(request.getParameter("pagename")+"<br />");
    out.println(request.getParameter("session")+"<br />");
%>