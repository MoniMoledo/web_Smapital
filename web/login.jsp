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
        </br>
        <form class="form-group" action="LoginServlet" method="post">
            <label class="label label-primary" id="lblfntsize">Username: </label>
            <input class="input-group" type="text" name="username" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Password: </label>
            <input class="input-group" type="password" name="password" required="true">
            <br/>
            <input class="btn btn-toolbar btn-lg btn-success" type="submit" value="Log In!"/>
        </form>
        <c:if test="${requestScope.login_error != null}">
            </br> <span class="alert alert-danger">${requestScope.login_error}</span>
        </c:if>
             <%@include file="footer.jsp"%> 
    </body>
</html>
