<%-- 
    Document   : profile
    Created on : Apr 25, 2023, 11:45:09 PM
    Author     : admin
--%>

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
        <h1>Thong tin nguoi dung</h1>
        <p><b>Ho va ten:</b> ${sessionScope.user.getFullName()}</p>
        <p><b>SÐT:</b> ${sessionScope.user.getPhone()}</p>
        <p><b>Dia chi:</b> ${sessionScope.user.getAddress()}</p>
        <a href="${pageContext.request.contextPath}/passwordreset">Doi mat khau</a>
        <%@include file="footer.jsp" %>
    </body>
</html>
