<%-- 
    Document   : register
    Created on : Oct 31, 2015, 2:45:50 AM
    Author     : fenius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Physician</title>
    </head>
    <body>
        <h2> New Registration! </h2>
        <form action="RegisterServlet" method="get">
            <label>Name: </label>
            <input type="text" name="name" required="true"/>
            <br/>
            <label>Age: </label>
            <input type="number" name="age" required="true"/>
            <br/>
            <label>Medcode: </label>
            <input type="text" name="medcode" required="true"/>
            <br/>
            <label>Password: </label>
            <input type="password" name="password" required="true"/>
            <br/>
            <label>Email: </label>
            <input type="email" name="email" required="true"/>
            <br/>
            <label>Phone:  </label>
            <input type="text" name="phone" required="true"/>
            <br/>
            <label>Specialty: </label>
            <input type="text" name="specialty" required="true"/>
            <br/>
            <label>Street: </label>
            <input type="text" name="street" required="true"/>
            <br/>
            <label>Number: </label>
            <input type="number" name="hnumber" required="true"/>
            <br/>
            <label>City: </label>
            <input type="text" name="city" required="true"/>
            <br/>
            <label>State: </label>
            <input type="text" name="state" required="true"/>
            <br/>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
