<%-- 
    Document   : header
    Created on : Nov 27, 2015, 10:06:35 PM
    Author     : fenius
--%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>



<header class="header">
    <div id="header-wrapper">
        <div id="header-logo"><h3>Welcome to Smarpital!</h3></div>
        <div id="header-login">
            <div id="menu-login">
                <c:choose>
                <c:when test="${sessionScope.user == null }">
                     <p> <a href="preRegistration.jsp">Sign Up!</a>
                         <a href="login.jsp">Sign In!</a> </p>
                </c:when>
                    <c:otherwise>
                     <p>
                         <a href="/index.jsp"> Home </a> &nbsp;
                         <a href="profile.jsp">${sessionScope.user.name}</a>
                         &nbsp; <a href="LogoutServlet"> Logout</a></p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</header>
<div class="header-detail"></div>