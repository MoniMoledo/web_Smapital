<%-- 
    Document   : preRegistration
    Created on : Oct 31, 2015, 2:58:29 AM
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
        <title>Choose One</title>
    </head>
    <body>
        <%@include file="header.jsp"%> 
        <div class="text-center" id="prereg">
        <a class="btn btn-success" href="registerMedic.jsp" name="teste">Physician</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <a class="btn btn-info" href="registerPatient.jsp">Patient</a>
        </div>
         <%@include file="footer.jsp"%> 
    </body>
</html>
