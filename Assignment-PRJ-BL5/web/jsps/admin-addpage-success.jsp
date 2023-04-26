<%-- 
    Document   : admin-addpage-success
    Created on : Apr 26, 2023, 7:50:45 AM
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
        <h1>Them san pham thanh cong!</h1>
        <button onlick="toURL('${pageContext.request.contextPath}/admin/addproduct')">Them tiep don hang</button>
        <%@include file="footer.jsp" %>
        <script>
            function toURL(url) {
                window.location.href = url;
            }
        </script>
    </body>
</html>
