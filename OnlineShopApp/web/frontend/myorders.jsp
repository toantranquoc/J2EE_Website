<%-- 
    Document   : cart
    Created on : Jun 11, 2020, 6:24:27 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.onlineshop.dto.OrderDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Orders</title>
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
                                    <li aria-current="page" class="breadcrumb-item active">Đơn hàng của tôi</li>
                                </ol>
                            </nav>
                        </div>
                        <div id="basket" class="col-lg-12">
                            <div class="box">
                                <c:if test="${myorders.size() == 0 || myorders == null}">
                                    <div class="alert alert-danger" role="alert">Bạn chưa mua đơn hàng nào</div>
                                </c:if>
                                <c:if test="${myorders.size() > 0}">
                                <div >
                                    <h1 style="text-align: center;">Đơn hàng của ${username}</h1>
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>Mã đơn hàng</th>
                                                    <th>Tên người nhận</th>
                                                    <th>Email</th>
                                                    <th>Số điện thoại</th>
                                                    <th>Địa chỉ</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Thanh toán</th>
                                                    <th>Trạng thái hóa đơn</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${myorders}" var="order">
                                                    <tr>
                                                        <td><a href="./GoOrderDetailServlet?IdOrder=${order.getId()}">${order.getId()}</a></td>
                                                        <td>${order.getReceiver()}</td>
                                                        <td>${order.getEmail()}</td>
                                                        <td>${order.getPhone()}</td>
                                                        <td>${order.getAddress()}</td>
                                                        <td>${order.getOrderDate()}</td>
                                                        <td>${order.getPaid()}</td>
                                                        <c:if test="${order.getOrderState() == 1}">
                                                            <td>Đang chờ xác nhận</td> 
                                                        </c:if>
                                                        <c:if test="${order.getOrderState() == 0}">
                                                            <td>Bị hủy</td> 
                                                        </c:if>
                                                        <c:if test="${order.getOrderState() == 2}">
                                                            <td>Đang được giao</td> 
                                                        </c:if>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th colspan="7">Tổng đơn hàng đã đặt:</th>
                                                    <th colspan="2">${myorders.size()} đơn hàng</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                                                                                    
                                </c:if>
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
