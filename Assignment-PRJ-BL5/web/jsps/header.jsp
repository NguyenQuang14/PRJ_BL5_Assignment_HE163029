<%-- 
    Document   : header
    Created on : Apr 25, 2023, 9:21:24 PM
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/Assignment-PRJ-BL5/css/main.css">
    </head>
    <body>
        <div class="nav-bar">
            <img id="logo" style="margin-right: 20px" width="64" height="64" src="${pageContext.request.contextPath}/images/logo_teobokki_store_tron_260x.png" />
                <div class="dropdown">
                    <button class="dropbtn">Danh muc</button>
                        <div class="dropdown-content">
                            <a href="${pageContext.request.contextPath}/collection/tuong-ot-han-quoc">Tuong ot Han Quoc Cay</a>
                            <a href="${pageContext.request.contextPath}/collection/tuong-ot-han-quoc-sieu-cay">Tuong ot Han Quoc Sieu Cay</a>
                        </div>
                </div>
            <button class="dropbtn">Câu chuyện ẩm thực</button>
            <div style="float: right">
                <button class="dropbtn">Tìm kiếm</button>
                
                    <c:if test="${sessionScope.user != null}">
                        <button class="dropbtn" onclick="toURL('${pageContext.request.contextPath}/profile')">Tai khoan</button>
                    </c:if>
                    <c:if test="${sessionScope.user == null}">
                        <button class="dropbtn" onclick="toURL('${pageContext.request.contextPath}/login')">Dang nhap</button>
                    </c:if>
                <button class="dropbtn">Gio hang</button>
                
            </div>
        </div>
        <script>
            function toURL(url) {
                window.location.href = url;
            }
        </script>
    </body>
    
</html>
