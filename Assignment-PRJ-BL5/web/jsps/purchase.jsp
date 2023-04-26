<%-- 
    Document   : purchase
    Created on : Apr 26, 2023, 8:26:08 AM
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
        <img src="${pageContext.request.contextPath}/images/${requestScope.sp.getLinkAnh()}">
        <label> Mo ta: </label>
        <p> <b> ${requestScope.sp.getMoTa()}</b></p>
        <label> So luong: </label>
        <input type="number" name="soluong" />
        <input type="submit" value="Mua hang" />
        <%@include file="footer.jsp" %>
    </body>
</html>
