<%-- 
    Document   : login
    Created on : Apr 25, 2023, 11:04:09 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <h1> Dang nhap </h1>
        <form action="${pageContext.request.contextPath}/login" method="POST"">
            <label>Ten nguoi dung</label>
            <input type="text" name="username" />
            <label>Mat khau</label>
            <input type="password" name="password" />
            <input type="submit" value="Dang nhap" />
        </form>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
