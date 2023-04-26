<%-- 
    Document   : register
    Created on : Apr 26, 2023, 4:17:49 PM
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
        <h1>Dang ky tai khoan</h1>
        <form action="${pageContext.request.contextPath}/register" method="POST">
            <label>Ho va Ten</label>
            <input type="text" name="fullname" /> <br/>
            <label>Ten dang nhap</label>
            <input type="text" name="username" /> <br/>
            <label>Mat khau</label>
            <input type="password" name="password" /> <br/>  
            <label>SÐT</label>
            <input type="number" name="phone" /> <br/>
            <label>Dia chi</label>
            <input type="text" name="address" /> <br/>  
            
            <input type="submit" value="Dang ky" />
 
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
