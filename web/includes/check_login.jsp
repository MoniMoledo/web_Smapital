<%-- 
    Document   : header
    Created on : Nov 3, 2015, 2:32:20 PM
    Author     : fenius
--%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>

 <c:if test="${sessionScope.user == null }">
   <%
   // New location to be redirected'
   String site = new String("http://localhost:8084/Smarpital/index.jsp");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
    %>
 
    </c:if> 
