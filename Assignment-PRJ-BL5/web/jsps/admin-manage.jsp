<%-- 
    Document   : admin-manage
    Created on : Apr 26, 2023, 1:22:05 AM
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
        <h1> Quan ly san pham </h1>
        <button onclick="toURL('${pageContext.request.contextPath}/admin/addproduct')">Them san pham</button>
        <%@include file="footer.jsp" %>
        <script>
            function toURL(url) {
                window.location.href = url;
            }
        </script>
    </body>
    
</html>
