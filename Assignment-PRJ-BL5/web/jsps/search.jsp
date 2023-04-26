<%-- 
    Document   : search
    Created on : Apr 26, 2023, 4:47:43 PM
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1> Hien thi ${requestScope.splist.size()} ket qua. </h1>
            <c:forEach items="${requestScope.splist}" var="sp">
                <img width="64" height="32" src="${pageContext.request.contextPath}/images/${sp.getLinkAnh()}" />
                <h3>${sp.getTenSp()}</h3>
                <h5> <i>${sp.getGiaBan()} </i> </h5>
                <p>${sp.getMoTa()} </p>
            </c:forEach>
        <%@include file="footer.jsp" %>
    </body>
</html>
