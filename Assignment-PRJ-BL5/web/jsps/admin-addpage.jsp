<%-- 
    Document   : admin-addpage
    Created on : Apr 26, 2023, 1:22:24 AM
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <form action="${pageContext.request.contextPath}/admin/addproduct" method="POST" enctype="multipart/form-data">
            <label>Ten San Pham:</label>
            <input type="text" name="tensanpham" /> <br/>
            <label>Danh muc:</label>
            <select name="danhmuc">
                <c:forEach items="${requestScope.dmlist}" var="d">
                    <option value="${d.getMaDMuc()}">${d.getTenDMuc()}</option>
                </c:forEach>
            </select> <br/>
            <label>File Anh:</label>
            <input type="file" name="linkanh" /> <br/>
            <label>Mo Ta San Pham:</label>
            <textarea name="motasanpham" /> </textarea> <br/>
            <label>Gia Ban:</label>
            <input type="number" name="giaban" /> <br/>
            <input type="submit" value="Them San Pham" />
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
