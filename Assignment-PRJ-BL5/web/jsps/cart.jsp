<%-- 
    Document   : cart
    Created on : Apr 26, 2023, 8:22:18 AM
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
        
        <h1> Gio hang </h1>
        <c:if test="${sessionScope.cart == null or sessionScope.cart.size() == 0}">
            <p> Ban hien tai chua them gi vao gio hang! </p>
        </c:if>
        <c:if test="${sessionScope.cart != null and sessionScope.cart.size() > 0}">
        <table>
            <thead>
                <tr>
                <th>TT</th>
                <th> Ma san pham </th>
                <th>Hinh anh + ten san pham</th>
                <th>Mo ta</th>
                <th>Don gia</th>
                <th>So luong</th>
                <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.cart}" var="item" varStatus="loop">
                    <tr>
                    <td>${loop.index+1}</td>
                    <td>${item.key.getMaSp()}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/images/${item.key.getLinkAnh()}">
                        <label>${item.key.getTenSp()}</label>
                    </td>
                    <td>${item.key.getMoTa()}</td>
                    <td>${item.key.getGiaBan()}</td>
                    <td>${item.value}</td>
                    <td>
                        <form onsubmit="confirmFormDelete(event)" action="${pageContext.request.contextPath}/cart" method="POST">
                            <input type="hidden" name="spxoa" value="${item.key.getMaSp()}">
                            <input type="submit" value="Xoa bo">
                        </form>
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
            
        <script>
            function confirmFormDelete(e) {
                if (confirm("Bạn có chắc muốn xoá mục này không?") != true) {
                    e.preventDefault(); // Ngan chay function
                }
            }
        </script>
        <%@include file="footer.jsp" %>
    </body>
</html>
