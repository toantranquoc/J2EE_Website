<%-- 
    Document   : productdetail
    Created on : Jun 10, 2020, 9:27:04 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.onlineshop.dto.ProductDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2d0af8021d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/productdetail.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>
        <div class="container mt-4">
            <div class="row">
                <div class="col-sm-4">
                    <div class="card">
                        <img src="./images/${productdetail.getImage()}" alt="Apple" class="card-img-top img-thumbnail">
                        <div class="card-body">
                            <div>
                                <strong>${productdetail.getName()}</strong>
                            </div>
                            <div>
                                <strong>${productdetail.currencyFormat(productdetail.getPrice())}</strong>
                            </div>
                            <div>
                                <p>Số lượng trong kho<strong> ${productdetail.getQuantity()}</strong></p>
                            </div>
                            <div>
                                <i>${productdetail.getIntroduction()}</i>
                            </div>
                        </div>
                        <div class="card-footer">
                            <a href="./AddToCartServlet?idProduct=${productdetail.getIdProduct()}"><button class="btn btn-primary"><i class="fas fa-shopping-cart"></i></button></a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="tab-panel">
                        <tabset class="member-tabset">
                            <tab heading="Hình ảnh sản phẩm">
                                <ngx-gallery class="ngx-gallery"></ngx-gallery>
                            </tab>
                            <tab heading="Chi tiết sản phẩm">
                                <h5>Thông số kĩ thuật</h5>
                                <p>${productdetail.getDescription()}</p>
                            </tab>
                        </tabset>
                    </div>
                </div>
            </div>
        </div>

        <jsp:directive.include file="footer.jsp"/>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
    <script type="text/javascript">
function closeDialog() {
    document.getElementById('modal').style.display = "none";
}

function openDialog() {
    document.getElementById('modal').style.display = "block";
}

function showPassword() {
    var typePassword = document.getElementById('password').type;
    if (typePassword === "password") {
        document.getElementById('password').type = "text";
        document.getElementById("showEye").className = "fa fa-eye-slash password-toggle-indicator";
    } else {
        document.getElementById('password').type = "password";
        document.getElementById("showEye").className = "fa fa-eye password-toggle-indicator'";
    }
}
    </script>
</html>
