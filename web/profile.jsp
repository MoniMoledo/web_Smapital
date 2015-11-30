<%-- 
    Document   : profile
    Created on : Nov 2, 2015, 10:30:28 PM
    Author     : fenius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="includes/style/bootstrap.css">
        <link rel="stylesheet" href="includes/style/bootstrap-theme.css">
        <link rel="stylesheet" href="includes/style/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%@include file="/includes/check_login.jsp"%> 
       <%@include file="header.jsp"%> 
        <h2>Hello, ${sessionScope.user.name}</h2>
        
        <form action="AptmtServlet" method="get">
            <input type="submit" value="Show Appointments"/>
        </form>
        </br>
        <c:if test="${sessionScope.isPatient}">
            <a href="InsertServlet?action=getMedic">Schedule an appointment</a>
        </c:if>
         <%@include file="footer.jsp"%> 
    </body>
</html>
