<%-- 
    Document   : orderdetail
    Created on : Jun 11, 2020, 6:24:27 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.onlineshop.dto.OrderDetailHelperDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Detail Cart</title>
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
                                    <li aria-current="page" class="breadcrumb-item active">Chi tiết đơn hàng</li>
                                </ol>
                            </nav>
                        </div>
                        <div id="basket" class="col-lg-12">
                            <div class="box">
                                <form method="post" action="./GoCheckOutServlet">
                                    <c:if test = "${mydetailorders == null || mydetailorders.size() == 0}">
                                        <div class="alert alert-danger" role="alert">Chi tiết đơn hàng rỗng</div>
                                    </c:if>
                                    <c:if test="${mydetailorders.size() > 0}">
                                        <div>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Mã đơn hàng</th>
                                                            <th colspan="2" style="text-align: center;">Sản phẩm</th>
                                                            <th>Số lượng đặt</th>
                                                            <th>Đơn giá sản phẩm</th>
                                                            <th>Thanh toán</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${mydetailorders}" var="selection">
                                                            <tr>
                                                                <td>
                                                                    ${selection.getIdOrder()}
                                                                </td>
                                                                <td>
                                                                    <img style="width: 50px; height: 50px; border-style: none;vertical-align: middle;" src="https://cdn.tgdd.vn/Products/Images/44/221251/acer-aspire-3-a315-nx-heesv-00d-221251-600x600.jpg" alt="${selection.getName()}">
                                                                </td>
                                                                <td>
                                                                    ${selection.getName()}
                                                                </td>
                                                                <td>                                                              
                                                                    ${selection.getQuantity()}
                                                                </td>
                                                                <td>
                                                                    ${selection.currencyFormat(selection.getUnitPrice())}
                                                                </td>                  
                                                                <td>${selection.currencyFormat(selection.getUnitPrice()*selection.getQuantity())}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>                   
                                                </table>
                                            </div>
                                        </div>
                                    </c:if>
                                </form>
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
