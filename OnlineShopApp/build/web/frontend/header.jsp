<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.onlineshop.dto.ManufacturerDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="css/nav.css" rel="stylesheet" type="text/css"/>
<%
    session = request.getSession();
    String name = "";
    name = (String) session.getAttribute("username");
%>
<div class="navbar-sticky bg-light">
    <div class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <a class="navbar-brand d-none d-sm-block mr-3 flex-shrink-0" style="min-width: 7rem;" href="./HomeServlet">
                <img width="180" height="55" src="images/logo.png" alt="Home Shoppe">
            </a>
            <a class="navbar-brand d-sm-none mr-2" style="min-width: 4.625rem;" href="./HomeServlet">
                <img width="100" height="35" src="images/logo.png" alt="Home Shoppe">
            </a>
            <div class="input-group-overlay d-none d-lg-flex mx-4 w-75">
                <form class="form-inline my-2 my-lg-0" method="GET" action="./SearchProductServlet">
                    <input class="form-control mr-sm-1" type="search" placeholder="Nhập tên sản phẩm cần tìm" aria-label="Search" name="nameSearch" required style="width:500px">
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit"><span><i class="fas fa-search"></i></span></button>
                </form>
            </div>
            <div class="navbar-toolbar d-flex flex-shrink-0 align-items-center">
                <% if (name == null || name == "") {
                %>
                <form class="form-inline my-2 my-lg-0 form-login-register">
                    <button onClick="openDialog()" class="btn btn-outline-success btn-sm my-2 my-sm-0 p-2" type="button">Đăng nhập <strong>|</strong> Đăng ký</button>
                </form>
                <%
                } else {
                %>
                <div class="dropdown">
                    <a class="navbar-tool ml-1 ml-lg-0 mr-n1 mr-lg-2" href="#signin-modal" data-toggle="modal">
                        <div class="navbar-tool-icon-box">
                            <i class="navbar-tool-icon fas fa-user"></i>
                        </div>
                        <div class="navbar-tool-text ml-n3">
                            <small>Hello,</small><%=name%>
                        </div>
                    </a>
                    <div class="dropdown-content">
                        <a href="./GoUserInfoServlet">Tài khoản của tôi</a>
                        <a>Đơn hàng của tôi</a>
                        <a style="color:#00bfa5" id="btnLogout" href="./Logout">Đăng xuất</a>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="navbar-tool ml-3">
                    <a class="navbar-tool-icon-box bg-secondary dropdown-toggle" href="./GoCartServlet">
                        <span class="navbar-tool-label">${totalcart}</span>
                        <i class="navbar-tool-icon fas fa-shopping-cart"></i>
                    </a>
                    <a class="navbar-tool-text"><small>My Cart</small>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="modal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <ul class="nav nav-tabs card-header-tabs" role="tablist">
                    <li class="nav-item"><a class="nav-link active" href="#signin-tab" data-toggle="tab" role="tab" aria-selected="true"><i class="fas fa-unlock-alt mr-2 mt-n1"></i>Đăng nhập</a></li>
                    <li class="nav-item"><a class="nav-link" href="#signup-tab" data-toggle="tab" role="tab" aria-selected="false"><i class="far fa-user mr-2 mt-n1"></i>Đăng ký</a></li>
                </ul>
                <button class="close" onClick="closeDialog()" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            </div>
            <div class="modal-body tab-content py-4">

                <form id="signin-tab" class="needs-validation tab-pane fade show active" method="post" autocomplete="off" novalidate="" onsubmit="return validLogin()" action="./LoginServlet" name="form">
                    <div class="form-group">
                        <label for="si-user">Tên đăng nhập</label>
                        <input class="form-control" type="text" id="username" name="username">
                    </div>
                    <div class="form-group">
                        <label for="si-password">Mật khẩu</label>
                        <div class="password-toggle">
                            <input class="form-control" type="password" id="password" name="password">
                            <label class="password-toggle-btn">
                                <input class="custom-control-input" type="checkbox"><i id="showEye" class="fa fa-eye password-toggle-indicator" onClick="showPassword()"></i><span class="sr-only">Show password</span>
                            </label>
                        </div>
                    </div>
                    <div class="form-group d-flex flex-wrap justify-content-between">
                        <div class="custom-control custom-checkbox mb-2">
                            <input class="custom-control-input" type="checkbox" id="si-remember">
                            <label class="custom-control-label" for="si-remember">Remember me</label>
                        </div><a class="font-size-sm" href="#">Forgot password?</a>
                    </div>
                    <button class="btn btn-primary btn-block btn-shadow btn-login" type="submit">Sign in</button>
                </form>
                <form id="signup-tab" class="needs-validation tab-pane fade" method="post" autocomplete="off" novalidate="" onsubmit="return validRegister()" action="./RegisterServlet">
                    <div class="form-group">
                        <label for="su-name">Tên đăng nhập</label>
                        <input  type="text" class="form-control" id="usernameRegister" name="usernameRegister"  placeholder="John Doe">
                    </div>
                    <div class="form-group">
                        <label for="su-password">Mật khẩu</label>
                        <input type="password"
                               class="form-control"
                               id="passwordRegister" name="passwordRegister">
                    </div>
                    <div class="form-group">
                        <label for="su-password-confirm">Xác nhận mật khẩu</label>
                        <input type="password"
                               class="form-control"
                               id="passwordConfirm" name="passwordConfirm">
                    </div>
                    <button class="btn btn-primary btn-block btn-shadow" type="submit">Sign up</button>
                </form>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-lg">
    <div class="container">
        <div class="navbar-buttons">
            <button type="button" data-toggle="collapse" data-target="#navigation" class="btn btn-outline-secondary navbar-toggler"><span class="sr-only">Toggle navigation</span><i class="fa fa-align-justify"></i></button>
            <button type="button" data-toggle="collapse" data-target="#search" class="btn btn-outline-secondary navbar-toggler"><span class="sr-only">Toggle search</span><i class="fa fa-search"></i></button><a href="basket.html" class="btn btn-outline-secondary navbar-toggler"><i class="fa fa-shopping-cart"></i></a>
        </div>
        <div id="navigation" class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a href="./HomeServlet" class="nav-link">Trang chủ</a></li>
                <li class="nav-item"><a href="./GoListAllProductsServlet?page=1&maxPageItem=12" class="nav-link">Sản phẩm</a></li>
                <li class="nav-item dropdown menu-large"><a href="#" data-toggle="dropdown" data-hover="dropdown" data-delay="200" class="dropdown-toggle nav-link">Danh mục<b class="caret"></b></a>
                    <ul class="dropdown-menu megamenu">
                        <li>
                            <div class="row">
                                <c:forEach items="${listmanufacturers}" var="manufacturer" >
                                    <div class="col-md-6 col-lg-3">
                                        <a class="nav-link" href="./GoListProductsServlet?id=${manufacturer.getIDManufacturer()}&page=1&maxPageItem=12">${manufacturer.getName()}</a>
                                    </div>
                                </c:forEach>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>                     

<script>
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var limit = 12;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage !== page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        });
    });
    function validLogin() {
        var username = $('#username').val();
        var password = $('#password').val();
        var isValid = true;

        $(".error").remove();
        if (username.length < 1) {
            $('#username').after('<span class="error">Bạn chưa nhập tên đăng nhập</span>');
            isValid = false;
        }
        if (password.length <= 0) {
            $('#password').after('<span class="error">Bạn chưa nhập mật khẩu</span>');
            isValid = false;
        } else if (password.length < 4 || password.length > 10) {
            $('#password').after('<span class="error">Mật khẩu phải từ 4 đến 10 ký tự</span>');
            isValid = false;
        }

        if (isValid === true) {
            toastr.info("Đăng nhập thành công");
            return true;
        } else {
            toastr.error("Đăng nhập thất bại");
            return false;
        }
    }

    function validRegister() {
        var usernameRegister = $('#usernameRegister').val();
        var passwordRegister = $('#passwordRegister').val();
        var passwordConfirm = $('#passwordConfirm').val();
        var isValid = true;

        $(".error").remove();
        if (usernameRegister.length < 1) {
            $('#usernameRegister').after('<span class="error">Bạn chưa nhập tên đăng nhập</span>');
            isValid = false;
        }
        if (passwordRegister.length <= 0) {
            $('#passwordRegister').after('<span class="error">Bạn chưa nhập mật khẩu</span>');
            isValid = false;
        } else if (passwordRegister.length < 4 || password.length > 10) {
            $('#passwordRegister').after('<span class="error">Mật khẩu phải từ 4 đến 10 ký tự</span>');
            isValid = false;
        }

        if (passwordConfirm.length <= 0) {
            $('#passwordConfirm').after('<span class="error">Bạn chưa nhập mật khẩu xác nhận</span>');
            isValid = false;
        }

        if (isValid === true) {
            toastr.success("Đăng ký thành công");
            return true;
        } else {
            toastr.error("Đăng ký thất bại");
            return false;
        }

        document.getElementById('btnLogout').addEventListener('click', function () {
            toastr.success("Đăng xuất thành công");
        });

    }
</script>
