<%-- 
    Document   : info-user
    Created on : Jun 18, 2020, 12:29:27 AM
    Author     : to cong hau
--%>
<%@page import="com.onlineshop.dto.UserDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2d0af8021d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-5">
                    <form id="editForm" action="./UpdateUserInforServlet">
                        <h4 class="text-center text-primary">Thông tin tài khoản</h4>
                        <hr>
                        <div class="form-group row">
                            <label for="su-fullname"  class="col-sm-4 col-form-label">Họ tên</label>
                            <div class="col-8">
                                <input type="text" id="fullname" name="fullname"
                                       value="${inforuser.getFullname()}"
                                       class="form-control" placeholder="Full name">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="su-dateOfBirthday" class="col-sm-4 col-form-label">Ngày sinh</label>
                            <div class="col-8">
                                <input type="date" id="dateOfBirthday"
                                       required name="dateOfBirth" 
                                       value="${inforuser.getDateOfBirth()}"
                                       class="form-control">                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="su-email" class="col-sm-4 col-form-label">Email</label>
                            <div class="col-8">
                                <input type="email" id="email"
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                                       required 
                                       placeholder="abc@email.com"
                                       name="email"
                                       value="${inforuser.getEmail()}"                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="su-phoneNumber" class="col-sm-4 col-form-label">Số điện thoại</label>
                            <div class="col-8">
                                <input type="tel" id="phoneNumber"
                                       pattern="(09|03|07|08|05)+([0-9]{8})"
                                       required 
                                       name="phoneNumber"
                                       value="${inforuser.getPhoneNumber()}"
                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="su-address" class="col-sm-4 col-form-label">Địa chỉ</label>
                            <div class="col-8">

                                <textarea class="form-control" required rows="2" id="address" name="address">${inforuser.getAddress()}</textarea>
                            </div>
                        </div>

                        <div class="form-group text-center">
                            <button class="btn btn-primary btn-sm"
                                    form="editForm" type="submit">Cập nhật</button>
                            <a href="./HomeServlet">
                                <button class="btn btn btn-info btn-sm" style="margin-left: 10px;"
                                        type="button">Quay lại</button>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <jsp:directive.include file="footer.jsp"/>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    </body>
</html>
