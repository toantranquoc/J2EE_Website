<%-- 
    Document   : login
    Created on : Jun 17, 2020, 5:11:47 PM
    Author     : to cong hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản trị</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2d0af8021d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"/>
        <link href="../css/admin/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Đăng nhập trang Quản trị</h3>
                        </div>
                        <div class="panel-body">
                            <form onsubmit="return validLogin()" action="./LoginServlet">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Username" id="username" name="username"
                                               type="text" autofocus="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" id="password" name="password"
                                               type="password">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Ghi nhớ
                                        </label>
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <button  class="btn btn-lg btn-primary btn-block">Đăng nhập</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    </body>
    <script>
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
    </script>
</html>
