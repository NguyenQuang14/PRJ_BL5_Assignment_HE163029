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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1> Quan ly san pham </h1>
        <c:if test="${requestScope.noti ne null}">
                <p style="color: blue">
                    ${requestScope.noti}
                </p>
            </c:if>
        <button onclick="toURL('${pageContext.request.contextPath}/admin/addproduct')">Them san pham</button> <br/>
        <label> Danh muc: </label>
        <form action="${pageContext.request.contextPath}/admin" method="POST">
        <select name="dmid">
            <c:forEach items="${requestScope.listdm}" var="dm">
                <option value="${dm.getMaDMuc()}">${dm.getTenDMuc()}</option>
            </c:forEach>
        </select>
        <label>Tu khoa: </label>
        <input type="text" name="keysearch" />
        <input type="submit" value="Tim kiem" />
        </form>
        <c:if test="${requestScope.listsp != null and requestScope.listsp.size() > 0}">
        <table>
            <thead>
                <tr>
                <th>TT</th>
                <th> Ma san pham </th>
                <th> Danh muc </th>
                <th>Hinh anh + ten san pham</th>
                <th>Mo ta</th>
                <th>Don gia</th>
                <th></th>
                <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.listsp}" var="item" varStatus="loop">
                    <tr>
                    <td>${loop.index+1}</td>
                    <td>${item.getMaSp()}</td>
                    <td>${item.getdMuc().getTenDMuc()}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/images/${item.getLinkAnh()}">
                        <label>${item.getTenSp()}</label>
                    </td>
                    <td>${item.getMoTa()}</td>
                    <td>${item.getGiaBan()}</td>
                    <td>
                        <button onclick="toURL('${pageContext.request.contextPath}/admin/editpage?pid=${item.getMaSp()}')">Cap nhat</button>
                    </td>
                    <td>
                        <button onclick="confirmUrlDelete('${pageContext.request.contextPath}/admin/deletepage?pid=${item.getMaSp()}')">Xoa bo</button>
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
        <%@include file="footer.jsp" %>
        <script>
            function toURL(url) {
                window.location.href = url;
            }
            
            function confirmUrlDelete(url) {
                if (confirm("Bạn có chắc muốn xoá mục này không?") == true) {
                    window.location.href = url;
                }
            }
        </script>
    </body>
    
</html>
