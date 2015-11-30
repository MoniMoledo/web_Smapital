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
         <link rel="stylesheet" href="includes/style/bootstrap.css">
        <link rel="stylesheet" href="includes/style/bootstrap-theme.css">
        <link rel="stylesheet" href="includes/style/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment</title>
        

        <script src="includes/js/jquery-2.1.4.js"></script>
        <script src="includes/js/bootstrap.js"></script>
    </head>
    <body>
        <%@include file="header.jsp"%> 
           <div style="container">
            <div class="row">
                <div class="col-md-10">
            
        <h2 class="text-center text-capitalize"> Appointments </h2>
         <table class="table table-bordered table-striped table-hover table-responsive" id="lblfntsize">
           
       <c:choose>
                <c:when test="${sessionScope.isPatient==true}">
                     <tr>
                <th>Physician</th>
                <th>Date</th>
                <th>Time</th>
                <th>Status</th>
                <th>Prescription</th>
                <th>Cancel</th>
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
                <td>
                    <c:if test="${ap.status == 'scheduled'}">
                     <form action="CancelServlet?apId=${ap.id}" method="post">
                        <input class="btn btn-danger" type="submit" value="Cancel"/>
                    </form>
                    </c:if>          
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
                <th>Cancel</th>
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
                    <c:choose>
                        <c:when test="${ap.prescription == '' && ap.status=='scheduled'}">
                            <form action="FinishApServlet?apId=${ap.id}" method="post">
                            <input type="text" name="newPrescription" />
                            <input class="btn btn-success" type="submit" value="Finish">
                            </form>
                        </c:when>
                        <c:otherwise>
                             ${ap.prescription}
                        </c:otherwise>
                    </c:choose>                  
                </td>
                <td>
                     <c:if test="${ap.status == 'scheduled'}">
                     <form action="CancelServlet?apId=${ap.id}" method="post">
                        <input class="btn btn-danger" type="submit" value="Cancel"/>
                    </form>
                     </c:if>
                </td>
            </tr>
       
        </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
                     </div>
                 </div>
        </div>
       <%@include file="footer.jsp"%> 
    </body>
</html>
