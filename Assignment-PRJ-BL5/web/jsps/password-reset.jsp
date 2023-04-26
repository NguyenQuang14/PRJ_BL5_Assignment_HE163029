<%-- 
    Document   : password-reset
    Created on : Apr 26, 2023, 12:01:08 PM
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
        <form action="${pageContext.request.contextPath}/passwordreset" method="POST">
            <c:if test="${requestScope.errmsg ne null}">
                <p style="color: red">
                    ${requestScope.errmsg}
                </p>
            </c:if>
            <c:if test="${requestScope.successmsg ne null}">
                <p style="color: blue">
                    ${requestScope.successmsg}
                </p>
            </c:if>
            
            <p style="color: blue">
            </p>
            <label>Mat khau cu</label>
            <input type="password" name="oldpass" /> <br/>
            <label>Nhap lai mat khau cu</label>
            <input type="password" name="oldpassrepeat" /> <br/>
            <a> Mat khau moi </a>
            <input type="password" name="newpass" /> <br/>
            <input type="submit" value="Doi mat khau" />
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
