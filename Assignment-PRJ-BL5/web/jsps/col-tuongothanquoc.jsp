<%-- 
    Document   : col-tuongothanquoc
    Created on : Apr 25, 2023, 10:21:45 PM
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
        
        <p>
            Gochujang là một loại gia vị không thể thiếu, có mặt trong hầu hết các món ăn truyền thống nổi tiếng của Hàn Quốc. Người Hàn Quốc coi ớt là sức mạnh tinh thần, là vũ khí để chống lại thời tiết lạnh lẽo khắc nghiệt của mùa đông, thậm chí là để kích thích hưng phấn sau những giờ làm việc căng thẳng.
        </p>
        <img src="${pageContext.request.contextPath}/images/gochujang-tuong-ot-han-quoc_480x480.webp" />
        <p>
            Gochujang có màu đỏ thẫm, vị ngọt và hơi cay được làm từ ớt đỏ, gạo nếp, tương đậu lên men và muối. Theo truyền thống, gochujang được để lên men trong nhiều năm trong nồi đất nung kiểu Hàn gọi là onggi để ngoài trời. Trong quá trình ủ, tinh bột trong gạo nếp được chuyển hóa thành đường, tạo cho gochujang vị ngọt đặc trưng. Thành phần ớt giúp nó có vị cay nhè nhẹ dễ chịu trong khi tương đậu lên men giúp gochujang tăng thêm vị ngọt tự nhiên.
        </p>
        
        <div class="catalog">
            <c:forEach items="${requestScope.dsSanPham}" var="sp">
                <div class="product" style="background-color:#aaa;">
                    <img src="${pageContext.request.contextPath}/images/${sp.getLinkAnh()}"/>
                    <p><b>${sp.getTenSp()}</b></p>
                    <p>${sp.getGiaBan()}d</p>
                </div>
            </c:forEach>
            
            
         </div>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
