<%-- 
    Document   : listproducts
    Created on : Jun 10, 2020, 8:12:22 PM
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
        <link href="css/product.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <script src="js/jquery.twbsPagination.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>
        <div class="row">
            <c:forEach items="${listproducts}" var="product" >
                <div class="col-lg-2 col-md-3 col-sm-6">
                    <div class="card mb-4">
                        <div class="card-img-wrapper">
                            <img src="https://cdn.tgdd.vn/Products/Images/44/221251/acer-aspire-3-a315-nx-heesv-00d-221251-600x600.jpg" alt="${product.getName()}" class="card-img-top">
                            <ul class="list-inline product-icons animate text-center">
                                <a href="./GoProductDetailServlet?idProduct=${product.getIdProduct()}"><li class="list-inline-item"><button class="btn btn-primary"><i class="fas fa-search"></i></button></li></a>
                                <a href="./AddToCartServlet?idProduct=${product.getIdProduct()}"><li class="list-inline-item"><button class="btn btn-primary"><i class="fas fa-shopping-cart"></i></button></li></a>
                            </ul>
                        </div>
                        <div class="card-body p-1">
                            <h6 class="card-title mb-1"><i class="fa fa-user"></i>
                                ${product.getName()}
                            </h6>
                            <p class="card-text text-muted"> ${product.getPrice()}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="d-flex justify-content-center mt-2">
            <ul class="pagination" id="pagination"></ul>
        </div>
        <jsp:directive.include file="footer.jsp"/>
    </body>
    <script type="text/javascript">
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: 35,
                visiblePages: 10,
                onPageClick: function (event, page) {
                    console.info(page + ' (from options)');
                }
            }).on('page', function (event, page) {
                console.info(page + ' (from event listening)');
            });
        });

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
