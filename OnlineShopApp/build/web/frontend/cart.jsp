<%-- 
    Document   : cart
    Created on : Jun 11, 2020, 6:24:27 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.onlineshop.dto.CartDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2d0af8021d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/cart.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>
        <div id="all">
            <div id="content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- breadcrumb-->
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="./HomeServlet">Home</a></li>
                                    <li aria-current="page" class="breadcrumb-item active">Shopping cart</li>
                                </ol>
                            </nav>
                        </div>
                        <div id="basket" class="col-lg-12">
                            <div class="box">
                                    <c:if test = "${totalcart == null || totalcart == 0}">
                                    <div class="alert alert-danger" role="alert">Chưa có sản phẩm nào trong giỏ hàng</div>
                                    </c:if>
                                    <c:if test="${totalcart > 0}">
                                    <div>
                                        <h1>Giỏ hàng</h1>
                                        <p class="text-muted">Bạn có ${totalcart} sản phẩm trong giỏ hàng.</p>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th colspan="2">Tên sản phẩm</th>
                                                        <th>Số lượng</th>
                                                        <th>Giá tiền</th>
                                                        <th colspan="2">Tổng tiền</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${cart.listProduct}" var="selection">
                                                    <form action="./UpdateToCartServlet" method="post">
                                                        <tr>
                                                            <td>
                                                                <input type="hidden" name="IdProduct" value="${selection.getId()}">
                                                                <img style="width: 50px; height: 50px; border-style: none;vertical-align: middle;" src="./images/${selection.getImage()}" alt="${selection.getName()}">
                                                            </td>
                                                            <td>
                                                                ${selection.getName()}
                                                            </td>
                                                            <td>                                                              
                                                                <input type="number" class="form-control" min="1" max="30" name="UpdateQuantity" id="UpdateQuantity" value="${selection.getQuantity()}">
                                                            </td>
                                                            <td>
                                                              ${selection.currencyFormat(selection.getPrice())}
                                                            </td>                  
                                                            <td>${selection.currencyFormat(selection.getPrice()*selection.getQuantity())}</td>
                                                            <td><button type="submit" class="btn btn-outline-secondary">Cập nhật số lượng</button></td>
                                                            <td><a href="./RemoveFromCartServlet?idItem=${selection.getId()}&itemQuantity=${selection.getQuantity()}"><i class="fa fa-trash-o"></i></a></td>
                                                        </tr>
                                                        </form>
                                                    </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th colspan="4">Total</th>
                                                        <th colspan="2">${cart.currencyFormat(cart.getTotalPrice())}</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive-->
                                        <div class="box-footer d-flex justify-content-between flex-column flex-lg-row">
                                            <div class="left">
                                                <a href="./HomeServlet"><button type="button" class="btn btn-outline-secondary"><i class="fa fa-chevron-left"></i> Tiếp tục mua</button></a>
                                            </div>
                                            <div class="right">
                                                <a href="./GoCheckOutServlet"><button type="submit" class="btn btn-primary">Thanh toán <i class="fa fa-chevron-right"></i></button></a>
                                            </div>
                                        </div>
                                    </div>
                                    </c:if>
                            </div>
                            <!-- /.box-->
                        </div>
                        <!-- /.col-lg-9-->
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
