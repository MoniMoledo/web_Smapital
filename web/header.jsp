<%-- 
    Document   : header
    Created on : Nov 27, 2015, 10:06:35 PM
    Author     : fenius
--%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>



<header class="header">
    <div id="header-wrapper">
        <div id="header-logo">
            <img id="img-logo" src="includes/resources/smarpital-logo.png"/>
            
        </div>
        <div id="header-login">
            <div id="menu-login">
                <c:choose>
                <c:when test="${sessionScope.user == null }">
                     <p> <a class="btn btn-warning" href="preRegistration.jsp">Sign Up!</a>
                         <a class="btn btn-info" href="login.jsp">Sign In!</a> </p>
                </c:when>
                    <c:otherwise>
                     <p>
                         <a class="btn btn-default" href="index.jsp"> Home </a> &nbsp;
                         <a class="btn btn-warning" href="profile.jsp">${sessionScope.user.name}</a>
                         &nbsp; <a class="btn btn-danger" href="EndServlet"> Logout</a></p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</header>
<div class="header-detail"></div>