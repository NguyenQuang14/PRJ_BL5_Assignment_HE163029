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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:if test="${requestScope.noti ne null}">
                <p style="color: blue">
                    ${requestScope.noti}
                </p>
        </c:if>
        <img src="${pageContext.request.contextPath}/images/${requestScope.sp.getLinkAnh()}">
        <label> Mo ta: </label>
        <p> <b> ${requestScope.sp.getMoTa()}</b></p>
        <form action="${pageContext.request.contextPath}/purchase" method="POST">
            <label> So luong: </label>
            <input type="hidden" name="pid" value="${requestScope.sp.getMaSp()}"/>
            <input type="number" name="soluong" />
            <input type="submit" value="Mua hang" />
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
