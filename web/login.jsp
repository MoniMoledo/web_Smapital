<%-- 
    Document   : login
    Created on : Nov 2, 2015, 5:07:38 PM
    Author     : fenius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="includes/style/bootstrap.css">
        <link rel="stylesheet" href="includes/style/bootstrap-theme.css">
        <link rel="stylesheet" href="includes/style/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@include file="header.jsp"%> 
        <h3>Please put your credentials</h3>
        <form action="LoginServlet" method="post">
            <label>Username: </label>
            <input type="text" name="username" required="true"/>
            <br/>
            <label>Password: </label>
            <input type="password" name="password" required="true">
            <br/>
            <input type="submit" value="Log In!"/>
        </form>
        <c:if test="${requestScope.login_error != null}">
            <span>${requestScope.login_error}</span>
        </c:if>
             <%@include file="footer.jsp"%> 
    </body>
</html>
