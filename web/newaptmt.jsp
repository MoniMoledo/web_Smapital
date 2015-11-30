<%-- 
    Document   : newaptmt
    Created on : Nov 27, 2015, 11:27:49 PM
    Author     : Monique
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="includes/style/bootstrap.css">
        <link rel="stylesheet" href="includes/style/bootstrap-theme.css">
        <link rel="stylesheet" href="includes/style/main.css">
        <script type="text/javascript">
            function getMedics(){
                    var element = document.getElementById("specialty");
                    var op = element.options[element.selectedIndex].value;
                    document.location.replace("http://localhost:8084/Smarpital/MedicServlet?option="+op);
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Appointment</title>
    </head>
    <body>
        <%@include file="header.jsp"%> 
        <h2> New appointment: </h2>
        </br>
        <form class="form-group" action="InsertServlet?action=Insert" method="post">
            <label class="label label-primary" id="lblfntsize">Select a specialty:</label>
            <select  onChange="getMedics();" name="specialty" id="specialty">
                
                <c:forEach var="spt" items="${sessionScope.specialties}">
                    <option value="${spt}"> <c:out value=" ${spt}"/> </option>
                </c:forEach> 
            </select>
            <br/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Select a Physician:</label>
            <select  name="medic" >
                <c:forEach var="med" items="${requestScope.medics}">
                    <option value="${med.getKey()}"> ${med.getValue()} </option>
                </c:forEach>
            </select>
            <br/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Date: </label>
            <input class="input-group" type="date" name="date" required="true"/>
            <br/>
            <label class="label label-primary" id="lblfntsize">Time: </label>
            <select  name="time">
                <option value="08:00:00">8AM</option>
                <option value="09:00:00">9AM</option>
                <option value="10:00:00">10AM</option>
                <option value="11:00:00">11AM</option>
                <option value="12:00:00">12PM</option>
                <option value="13:00:00">1PM</option>
                <option value="14:00:00">2PM</option>
                <option value="15:00:00">3PM</option>
                <option value="16:00:00">4PM</option>
                <option value="17:00:00">5PM</option>
                <option value="18:00:00">6PM</option>
            </select>
            <br/><br/>
            <input class="btn btn-success btn-lg" type="submit" value="Create"/>
        </form>
        <c:if test="${requestScope.error != null}">
            </br> <span class="alert alert-danger">${requestScope.error}</span>
        </c:if>

        
 <%@include file="footer.jsp"%> 
    </body>
</html>
