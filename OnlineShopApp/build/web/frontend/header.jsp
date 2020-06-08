<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar-sticky bg-light">
    <div class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <a class="navbar-brand d-none d-sm-block mr-3 flex-shrink-0" style="min-width: 7rem;">
                <img width="180" height="55" src="images/logo.png" alt="Home Shoppe">
            </a>
            <a class="navbar-brand d-sm-none mr-2" style="min-width: 4.625rem;">
                <img width="100" height="35" src="images/logo.png" alt="Home Shoppe">
            </a>
            <div class="input-group-overlay d-none d-lg-flex mx-4 w-75">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-1" type="search" placeholder="Nhập tên sản phẩm cần tìm" aria-label="Search" name="nameSearch" required style="width:500px">
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit"><span><i class="fas fa-search"></i></span></button>
                </form>
            </div>
            <div class="navbar-toolbar d-flex flex-shrink-0 align-items-center">
                <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-expanded="false">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <form class="form-inline my-2 my-lg-0 form-login-register">
                    <button onClick="openDialog()" class="btn btn-outline-success btn-sm my-2 my-sm-0 p-2" type="button">Đăng nhập <strong>|</strong> Đăng ký</button>
                </form>
                <div class="dropdown">
                    <a class="navbar-tool ml-1 ml-lg-0 mr-n1 mr-lg-2" href="#signin-modal" data-toggle="modal">
                        <div class="navbar-tool-icon-box">
                            <i class="navbar-tool-icon fas fa-user"></i>
                        </div>
                        <div class="navbar-tool-text ml-n3">
                            <small>Hello,</small>My Account
                        </div>
                    </a>
                    <div class="dropdown-content">
                        <a>Tài khoản của tôi</a>
                        <a>Đơn hàng của tôi</a>
                        <a style="color:#00bfa5">Đăng xuất</a>
                    </div>
                </div>

                <div class="navbar-tool ml-3">
                    <a class="navbar-tool-icon-box bg-secondary dropdown-toggle">
                        <span class="navbar-tool-label"></span>
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
                <form id="signin-tab" class="needs-validation tab-pane fade show active" method="post" autocomplete="off" novalidate="">
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
                <form id="signup-tab" class="needs-validation tab-pane fade" method="post" autocomplete="off" novalidate="" >
                    <div class="form-group">
                        <label for="su-name">Tên đăng nhập</label>
                        <input  type="text" class="form-control" id="usernameRegister" name="usernameRegister" placeholder="John Doe">
                    </div>
                    <div class="form-group">
                        <label for="su-password">Mật khẩu</label>
                        <input type="passwordRegister"
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