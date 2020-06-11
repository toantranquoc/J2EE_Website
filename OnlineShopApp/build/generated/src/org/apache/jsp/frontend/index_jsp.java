package org.apache.jsp.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.onlineshop.dto.ManufacturerDTO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/frontend/header.jsp");
    _jspx_dependants.add("/frontend/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Home page</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/2d0af8021d.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css\"/>\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/nav.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");

    session = request.getSession();
    String name = "";
    name = (String) session.getAttribute("username");

      out.write("\r\n");
      out.write("<div class=\"navbar-sticky bg-light\">\r\n");
      out.write("    <div class=\"navbar navbar-expand-lg navbar-light\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <a class=\"navbar-brand d-none d-sm-block mr-3 flex-shrink-0\" style=\"min-width: 7rem;\" href=\"./HomeServlet\">\r\n");
      out.write("                <img width=\"180\" height=\"55\" src=\"images/logo.png\" alt=\"Home Shoppe\">\r\n");
      out.write("            </a>\r\n");
      out.write("            <a class=\"navbar-brand d-sm-none mr-2\" style=\"min-width: 4.625rem;\" href=\"./HomeServlet\">\r\n");
      out.write("                <img width=\"100\" height=\"35\" src=\"images/logo.png\" alt=\"Home Shoppe\">\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"input-group-overlay d-none d-lg-flex mx-4 w-75\">\r\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("                    <input class=\"form-control mr-sm-1\" type=\"search\" placeholder=\"Nhập tên sản phẩm cần tìm\" aria-label=\"Search\" name=\"nameSearch\" required style=\"width:500px\">\r\n");
      out.write("                    <button class=\"btn btn-secondary my-2 my-sm-0\" type=\"submit\"><span><i class=\"fas fa-search\"></i></span></button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"navbar-toolbar d-flex flex-shrink-0 align-items-center\">\r\n");
      out.write("                ");
 if (name == null || name == "") {
                
      out.write("\r\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0 form-login-register\">\r\n");
      out.write("                    <button onClick=\"openDialog()\" class=\"btn btn-outline-success btn-sm my-2 my-sm-0 p-2\" type=\"button\">Đăng nhập <strong>|</strong> Đăng ký</button>\r\n");
      out.write("                </form>\r\n");
      out.write("                ");

                } else {
                
      out.write("\r\n");
      out.write("                <div class=\"dropdown\">\r\n");
      out.write("                    <a class=\"navbar-tool ml-1 ml-lg-0 mr-n1 mr-lg-2\" href=\"#signin-modal\" data-toggle=\"modal\">\r\n");
      out.write("                        <div class=\"navbar-tool-icon-box\">\r\n");
      out.write("                            <i class=\"navbar-tool-icon fas fa-user\"></i>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"navbar-tool-text ml-n3\">\r\n");
      out.write("                            <small>Hello,</small>");
      out.print(name);
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"dropdown-content\">\r\n");
      out.write("                        <a>Tài khoản của tôi</a>\r\n");
      out.write("                        <a>Đơn hàng của tôi</a>\r\n");
      out.write("                        <a style=\"color:#00bfa5\" id=\"btnLogout\" href=\"./Logout\">Đăng xuất</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    }
                
      out.write("\r\n");
      out.write("                <div class=\"navbar-tool ml-3\">\r\n");
      out.write("                    <a class=\"navbar-tool-icon-box bg-secondary dropdown-toggle\">\r\n");
      out.write("                        <span class=\"navbar-tool-label\"></span>\r\n");
      out.write("                        <i class=\"navbar-tool-icon fas fa-shopping-cart\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a class=\"navbar-tool-text\"><small>My Cart</small>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"modal\" class=\"modal\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <ul class=\"nav nav-tabs card-header-tabs\" role=\"tablist\">\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link active\" href=\"#signin-tab\" data-toggle=\"tab\" role=\"tab\" aria-selected=\"true\"><i class=\"fas fa-unlock-alt mr-2 mt-n1\"></i>Đăng nhập</a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"#signup-tab\" data-toggle=\"tab\" role=\"tab\" aria-selected=\"false\"><i class=\"far fa-user mr-2 mt-n1\"></i>Đăng ký</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <button class=\"close\" onClick=\"closeDialog()\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body tab-content py-4\">\r\n");
      out.write("\r\n");
      out.write("                <form id=\"signin-tab\" class=\"needs-validation tab-pane fade show active\" method=\"post\" autocomplete=\"off\" novalidate=\"\" onsubmit=\"return validLogin()\" action=\"./LoginServlet\" name=\"form\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"si-user\">Tên đăng nhập</label>\r\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"username\" name=\"username\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"si-password\">Mật khẩu</label>\r\n");
      out.write("                        <div class=\"password-toggle\">\r\n");
      out.write("                            <input class=\"form-control\" type=\"password\" id=\"password\" name=\"password\">\r\n");
      out.write("                            <label class=\"password-toggle-btn\">\r\n");
      out.write("                                <input class=\"custom-control-input\" type=\"checkbox\"><i id=\"showEye\" class=\"fa fa-eye password-toggle-indicator\" onClick=\"showPassword()\"></i><span class=\"sr-only\">Show password</span>\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group d-flex flex-wrap justify-content-between\">\r\n");
      out.write("                        <div class=\"custom-control custom-checkbox mb-2\">\r\n");
      out.write("                            <input class=\"custom-control-input\" type=\"checkbox\" id=\"si-remember\">\r\n");
      out.write("                            <label class=\"custom-control-label\" for=\"si-remember\">Remember me</label>\r\n");
      out.write("                        </div><a class=\"font-size-sm\" href=\"#\">Forgot password?</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button class=\"btn btn-primary btn-block btn-shadow btn-login\" type=\"submit\">Sign in</button>\r\n");
      out.write("                </form>\r\n");
      out.write("                <form id=\"signup-tab\" class=\"needs-validation tab-pane fade\" method=\"post\" autocomplete=\"off\" novalidate=\"\" onsubmit=\"return validRegister()\" action=\"./RegisterServlet\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"su-name\">Tên đăng nhập</label>\r\n");
      out.write("                        <input  type=\"text\" class=\"form-control\" id=\"usernameRegister\" name=\"usernameRegister\"  placeholder=\"John Doe\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"su-password\">Mật khẩu</label>\r\n");
      out.write("                        <input type=\"password\"\r\n");
      out.write("                               class=\"form-control\"\r\n");
      out.write("                               id=\"passwordRegister\" name=\"passwordRegister\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"su-password-confirm\">Xác nhận mật khẩu</label>\r\n");
      out.write("                        <input type=\"password\"\r\n");
      out.write("                               class=\"form-control\"\r\n");
      out.write("                               id=\"passwordConfirm\" name=\"passwordConfirm\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button class=\"btn btn-primary btn-block btn-shadow\" type=\"submit\">Sign up</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-md bg-dark navbar-dark manufacturer\">\r\n");
      out.write("  <a class=\"navbar-brand\" href=\"./HomeServlet\">Trang chủ</a>\r\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\r\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("  </button>\r\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("    <ul class=\"navbar-nav\">\r\n");
      out.write("      ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>  \r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function validLogin() {\r\n");
      out.write("        var username = $('#username').val();\r\n");
      out.write("        var password = $('#password').val();\r\n");
      out.write("        var isValid = true;\r\n");
      out.write("\r\n");
      out.write("        $(\".error\").remove();\r\n");
      out.write("        if (username.length < 1) {\r\n");
      out.write("            $('#username').after('<span class=\"error\">Bạn chưa nhập tên đăng nhập</span>');\r\n");
      out.write("            isValid = false;\r\n");
      out.write("        }\r\n");
      out.write("        if (password.length <= 0) {\r\n");
      out.write("            $('#password').after('<span class=\"error\">Bạn chưa nhập mật khẩu</span>');\r\n");
      out.write("            isValid = false;\r\n");
      out.write("        } else if (password.length < 4 || password.length > 10) {\r\n");
      out.write("            $('#password').after('<span class=\"error\">Mật khẩu phải từ 4 đến 10 ký tự</span>');\r\n");
      out.write("            isValid = false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        if (isValid === true) {\r\n");
      out.write("            toastr.info(\"Đăng nhập thành công\");\r\n");
      out.write("            return true;\r\n");
      out.write("        } else{\r\n");
      out.write("            toastr.error(\"Đăng nhập thất bại\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function validRegister() {\r\n");
      out.write("        var usernameRegister = $('#usernameRegister').val();\r\n");
      out.write("        var passwordRegister = $('#passwordRegister').val();\r\n");
      out.write("        var passwordConfirm = $('#passwordConfirm').val();\r\n");
      out.write("        var isValid = true;\r\n");
      out.write("        \r\n");
      out.write("        $(\".error\").remove();\r\n");
      out.write("        if (usernameRegister.length < 1) {\r\n");
      out.write("            $('#usernameRegister').after('<span class=\"error\">Bạn chưa nhập tên đăng nhập</span>');\r\n");
      out.write("            isValid = false;\r\n");
      out.write("        }\r\n");
      out.write("        if (passwordRegister.length <= 0) {\r\n");
      out.write("            $('#passwordRegister').after('<span class=\"error\">Bạn chưa nhập mật khẩu</span>');\r\n");
      out.write("            isValid = false;\r\n");
      out.write("        } else if (passwordRegister.length < 4 || password.length > 10) {\r\n");
      out.write("            $('#passwordRegister').after('<span class=\"error\">Mật khẩu phải từ 4 đến 10 ký tự</span>');\r\n");
      out.write("            isValid = false;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        if (passwordConfirm.length <= 0) {\r\n");
      out.write("            $('#passwordConfirm').after('<span class=\"error\">Bạn chưa nhập mật khẩu xác nhận</span>');\r\n");
      out.write("            isValid = false;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        if (isValid === true) {\r\n");
      out.write("            toastr.success(\"Đăng ký thành công\");\r\n");
      out.write("            return true;\r\n");
      out.write("        } else{\r\n");
      out.write("            toastr.error(\"Đăng ký thất bại\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        document.getElementById('btnLogout').addEventListener('click',function(){\r\n");
      out.write("            toastr.success(\"Đăng xuất thành công\");\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"carousel slide\" data-ride=\"carousel\" id=\"slides\" data-interval=\"3000\">\r\n");
      out.write("            <ul class=\"carousel-indicators\">\r\n");
      out.write("                <li data-target=\"#slides\" data-slide-to=\"0\"></li>\r\n");
      out.write("                <li data-target=\"#slides\" data-slide-to=\"1\"></li>\r\n");
      out.write("                <li data-target=\"#slides\" data-slide-to=\"2\"></li>\r\n");
      out.write("                <li data-target=\"#slides\" data-slide-to=\"3\"></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("                <div class=\"carousel-item active\">\r\n");
      out.write("                    <img src=\"images/bg_4.jpg\" width=\"100%\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <img src=\"images/bg_3.jpg\" width=\"100%\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <img src=\"images/bg_2.jpg\" width=\"100%\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <img src=\"images/bg_1.jpg\" width=\"100%\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <a class=\"carousel-control-prev\" href=\"#slides\" data-slide=\"prev\">\r\n");
      out.write("                <span class=\"carousel-control-prev-icon\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <a class=\"carousel-control-next\" href=\"#slides\" data-slide=\"next\">\r\n");
      out.write("                <span class=\"carousel-control-next-icon\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div align=\"center\">\r\n");
      out.write("            <h3>This is main content: </h3>\r\n");
      out.write("            <h2>New books</h2>\r\n");
      out.write("            <h2>Best-Selling Books</h2>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("<link href=\"css/footer.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<footer>\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row text-center mt-6\">\r\n");
      out.write("\t\t\t<div class=\"col-md-4 col-sm-6\" >\r\n");
      out.write("\t\t\t\t<h5>Member</h5>\r\n");
      out.write("\t\t\t\t<hr class=\"light\">\r\n");
      out.write("\t\t\t\t<p>Tran Quoc Toan</p>\r\n");
      out.write("\t\t\t\t<p>To Cong Hau</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-md-4 col-sm-6\">\r\n");
      out.write("\t\t\t\t<h5>Project</h5>\r\n");
      out.write("\t\t\t\t<hr class=\"light\">\r\n");
      out.write("\t\t\t\t<p>Shopping Online</p>\r\n");
      out.write("\t\t\t\t<p>Group: 14 </p>\r\n");
      out.write("\t\t\t\t<p>GVHD: Huynh Ngoc Tin</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-md-4 col-sm-6\"> \r\n");
      out.write("\t\t\t\t<h5>Contact</h5>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.227417615001!2d106.80126261415018!3d10.870299992257882!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527587e9ad5bf%3A0xafa66f9c8be3c91!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBDw7RuZyBuZ2jhu4cgVGjDtG5nIHRpbiDEkEhRRyBUUC5IQ00!5e0!3m2!1svi!2s!4v1552574275589\" width=\"250\" height=\"150\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("<!--        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>-->\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("                document.getElementById('btnLogout').addEventListener('click',function(){\r\n");
      out.write("            toastr.success(\"Đăng xuất thành công\");\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        function closeDialog() {\r\n");
      out.write("            document.getElementById('modal').style.display = \"none\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function openDialog() {\r\n");
      out.write("            document.getElementById('modal').style.display = \"block\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function showPassword() {\r\n");
      out.write("            var typePassword = document.getElementById('password').type;\r\n");
      out.write("            if (typePassword === \"password\") {\r\n");
      out.write("                document.getElementById('password').type = \"text\";\r\n");
      out.write("                document.getElementById(\"showEye\").className = \"fa fa-eye-slash password-toggle-indicator\";\r\n");
      out.write("            } else {\r\n");
      out.write("                document.getElementById('password').type = \"password\";\r\n");
      out.write("                document.getElementById(\"showEye\").className = \"fa fa-eye password-toggle-indicator'\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listmanufacturers}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("manufacturer");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("      <li class=\"nav-item\">\r\n");
          out.write("        <a class=\"nav-link\" href=\"./GoListProductsServlet?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${manufacturer.getIDManufacturer()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${manufacturer.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("      </li>\r\n");
          out.write("      ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
