<%-- 
    Document   : registerPatient
    Created on : Oct 31, 2015, 3:13:21 AM
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
        <title>New Patient</title>
    </head>
    <body>
        <%@include file="header.jsp"%> 
        <h2> New Registration! </h2>
        <form action="RegisterServlet" method="get">
            <label class="label label-primary" id="lblfntsize">Name: </label>
            <input class="input-group" type="text" name="name" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Age: </label>
            <input class="input-group" type="number" name="age" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">SSN: </label>
            <input class="input-group" type="text" name="ssn" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Password: </label>
            <input class="input-group" type="password" name="password" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Email: </label>
            <input class="input-group" type="email" name="email" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Phone:  </label>
            <input class="input-group" type="text" name="phone" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Street: </label>
            <input class="input-group" type="text" name="street" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Number: </label>
            <input  class="input-group"type="number" name="hnumber" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">City: </label>
            <input class="input-group" type="text" name="city" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">State: </label>
            <input class="input-group" type="text" name="state" required="true"/>
            <br/>
            <input class="btn btn-lg btn-success btn-toolbar" type="submit" value="Register"/>
        </form>
         <%@include file="footer.jsp"%> 
    </body>
</html>
