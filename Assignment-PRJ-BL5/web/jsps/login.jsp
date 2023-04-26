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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <h1> Dang nhap </h1>
        <c:if test="${requestScope.msg ne null}">
                <p style="color: blue">
                    ${requestScope.msg}
                </p>
        </c:if>
        <form action="${pageContext.request.contextPath}/login" method="POST">
            <label>Tai khoan</label>
            <input type="text" name="username" /> <br/>
            <label>Mat khau</label>
            <input type="password" name="password" /> <br/>
            <label>Chua co tai khoan? <a href="${pageContext.request.contextPath}/register">Dang ky ngay!</a></label><br/>
            <input type="submit" value="Dang nhap" />
            
        </form>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
