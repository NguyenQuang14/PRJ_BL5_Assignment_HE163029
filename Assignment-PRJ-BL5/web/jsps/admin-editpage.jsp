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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <form action="${pageContext.request.contextPath}/admin/editpage" method="POST" enctype="multipart/form-data">
            <label>Ten San Pham:</label>
            <input type="hidden" name="masp" value="${requestScope.sp.getMaSp()}">
            <input required type="text" name="tensanpham" value="${requestScope.sp.getTenSp()}"/> <br/>
            <label>Danh muc:</label>
            <select name="danhmuc" value="${requestScope.sp.getdMuc().getMaDMuc()}">
                <c:forEach items="${requestScope.dmlist}" var="d">
                    <option value="${d.getMaDMuc()}">${d.getTenDMuc()}</option>
                </c:forEach>
            </select> <br/>
            <label>File Anh:</label>
            <input type="hidden" name="prevlinkanh" value="${requestScope.sp.getLinkAnh()}">
            <input type="file" name="linkanh" /> <br/>
            <label>Mo Ta San Pham:</label>
            <textarea name="motasanpham" />${requestScope.sp.getMoTa()}</textarea> <br/>
            <label>Gia Ban:</label>
            <input required type="number" name="giaban" value="${requestScope.sp.getGiaBan()}"/> <br/>
            <input type="submit" value="Cap Nhat San Pham" />
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
