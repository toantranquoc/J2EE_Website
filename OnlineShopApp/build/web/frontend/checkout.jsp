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
        <link href="css/checkout.css" rel="stylesheet" type="text/css"/>
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
                                    <li aria-current="page" class="breadcrumb-item active">Thanh toán</li>
                                </ol>
                            </nav>
                        </div>
                        <div id="basket" class="col-lg-12">
                            <div class="box">
                                <form method="post" action="./CreateOrderServlet" >
                                    <c:if test = "${username == null}">
                                        <div class="alert alert-danger" role="alert">Vui lòng đăng nhập để thanh toán</div>
                                    </c:if>
                                    <c:if test="${username != null}">
                                        <hr>
                                        <h4 class="text-center text-primary">Thông tin thanh toán</h4>
                                        <hr>

                                        <div class="form-group row">
                                            <label for="su-name" class="col-sm-4 col-form-label">Người nhận</label>
                                            <div class="col-8">
                                                <input type="text" name="receiver" required 
                                                       class="form-control" placeholder="Họ tên người nhận">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="su-fullname"  class="col-sm-4 col-form-label">Email</label>
                                            <div class="col-8">
                                                <input type="email"  
                                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                                                       placeholder="example@example.com"
                                                       name="email" required 
                                                       class="form-control">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="su-email" class="col-sm-4 col-form-label">Số điện thoại</label>
                                            <div class="col-8">
                                                <input type="text"  name="phone" required
                                                       pattern="(09|03|07|08|05)+([0-9]{8})"
                                                       class="form-control">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="su-address" class="col-sm-4 col-form-label">Địa chỉ</label>
                                            <div class="col-8">
                                                <textarea class="form-control" rows="2" required name="address" maxlength="2000"></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group text-center">
                                            <button class="btn btn-primary btn-sm" 
                                                    type="submit">Cập nhật</button>
                                            <a href="./GoCartServlet"><button class="btn btn btn-info btn-sm" style="margin-left: 10px;"
                                                                              type="button">Quay lại</button> </a>
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
