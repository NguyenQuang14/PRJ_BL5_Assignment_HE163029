<%-- 
    Document   : header
    Created on : Apr 25, 2023, 9:21:24 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="nav-bar">
            <img id="logo" style="margin-right: 20px" width="64" height="64" src="images/logo_teobokki_store_tron_260x.png" />
                <div class="dropdown">
                    <button class="dropbtn">Danh muc</button>
                        <div class="dropdown-content">
                            <a href="#">Tuong ot Han Quoc Cay</a>
                            <a href="#">Tuong ot Han Quoc Sieu Cay</a>
                        </div>
                </div>
            <button class="dropbtn">Cau chuyen am thuc</button>
            <div style="float: right">
                <button class="dropbtn">Tim kiem</button>
                <button class="dropbtn">Dang nhap</button>
                <button class="dropbtn">Gio hang</button>
            </div>
        </div>
    </body>
</html>
