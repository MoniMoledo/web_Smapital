<%-- 
    Document   : aptmts
    Created on : Nov 26, 2015, 1:02:02 PM
    Author     : Monique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="includes/style/bootstrap.css">
        <link rel="stylesheet" href="includes/style/bootstrap-theme.css">
        <link rel="stylesheet" href="includes/style/cs3520.css">

        <script src="includes/js/jquery-2.1.4.js"></script>
        <script src="includes/js/bootstrap.js"></script>
    </head>
    <body>
           <div style="container">
            <div class="row">
                <div class="col-md-10">
            
        <p> Appointments </p>
         <table class="table">
           
      <%--  <c:forEach var="ap" items="${requestScope.aptmts}">
            
            <tr>
                <td>
                   ${ap.med.name}
                </td>
                   <td>
                    ${ap.date}
                </td>
                   <td>
                    ${ap.time}
                </td>
                <td>
                    ${ap.status}
                </td>
                <td>
                    ${ap.prescription}
                </td>
            </tr>
       
        </c:forEach> --%>
      
       <c:choose>
                <c:when test="${sessionScope.isPatient==true}">
                     <tr>
                <th>Medic </th>
                <th>Date</th>
                <th>Time</th>
                <th>Status</th>
                <th>Prescription</th>
            </tr>
                    <c:forEach var="ap" items="${requestScope.aptmts}">
            
            <tr>
                <td>
                   ${ap.med.name}
                </td>
                   <td>
                    ${ap.date}
                </td>
                   <td>
                    ${ap.time}
                </td>
                <td>
                    ${ap.status}
                </td>
                <td>
                    ${ap.prescription}
                </td>
            </tr>
       
        </c:forEach>
                    
                </c:when>
                <c:otherwise>
                           <tr>
                <th>Patient </th>
                <th>Date</th>
                <th>Time</th>
                <th>Status</th>
                <th>Prescription</th>
            </tr>
                    <c:forEach var="ap" items="${requestScope.aptmts}">
            
            <tr>
                <td>
                   ${ap.pat.name}
                </td>
                   <td>
                    ${ap.date}
                </td>
                   <td>
                    ${ap.time}
                </td>
                <td>
                    ${ap.status}
                </td>
                <td>
                    ${ap.prescription}
                </td>
            </tr>
       
        </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
                     </div>
                 </div>
        </div>
    </body>
</html>
