package org.apache.jsp.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<div class=\"navbar-sticky bg-light\">\r\n");
      out.write("    <div class=\"navbar navbar-expand-lg navbar-light\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <a class=\"navbar-brand d-none d-sm-block mr-3 flex-shrink-0\" style=\"min-width: 7rem;\">\r\n");
      out.write("                <img width=\"180\" height=\"55\" src=\"../images/logo.png\" alt=\"Home Shoppe\">\r\n");
      out.write("            </a>\r\n");
      out.write("            <a class=\"navbar-brand d-sm-none mr-2\" style=\"min-width: 4.625rem;\">\r\n");
      out.write("                <img width=\"100\" height=\"35\" src=\"../images/logo.png\" alt=\"Home Shoppe\">\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"input-group-overlay d-none d-lg-flex mx-4 w-75\">\r\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("                    <input class=\"form-control mr-sm-1\" type=\"search\" placeholder=\"Nhập tên sản phẩm cần tìm\" aria-label=\"Search\" name=\"nameSearch\" required style=\"width:500px\">\r\n");
      out.write("                    <button class=\"btn btn-secondary my-2 my-sm-0\" type=\"submit\"><span><i class=\"fas fa-search\"></i></span></button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"navbar-toolbar d-flex flex-shrink-0 align-items-center\">\r\n");
      out.write("                <button class=\"navbar-toggler collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" aria-expanded=\"false\">\r\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0 form-login-register\">\r\n");
      out.write("                    <button onClick=\"openDialog()\" class=\"btn btn-outline-success btn-sm my-2 my-sm-0 p-2\" type=\"button\">Đăng nhập <strong>|</strong> Đăng ký</button>\r\n");
      out.write("                </form>\r\n");
      out.write("                <div class=\"dropdown\">\r\n");
      out.write("                    <a class=\"navbar-tool ml-1 ml-lg-0 mr-n1 mr-lg-2\" href=\"#signin-modal\" data-toggle=\"modal\">\r\n");
      out.write("                        <div class=\"navbar-tool-icon-box\">\r\n");
      out.write("                            <i class=\"navbar-tool-icon fas fa-user\"></i>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"navbar-tool-text ml-n3\">\r\n");
      out.write("                            <small>Hello,</small>My Account\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"dropdown-content\">\r\n");
      out.write("                        <a>Tài khoản của tôi</a>\r\n");
      out.write("                        <a>Đơn hàng của tôi</a>\r\n");
      out.write("                        <a style=\"color:#00bfa5\">Đăng xuất</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
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
      out.write("                <form id=\"signin-tab\" class=\"needs-validation tab-pane fade show active\" method=\"post\" autocomplete=\"off\" novalidate=\"\" action=\"../LoginServlet\">\r\n");
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
      out.write("                <form id=\"signup-tab\" class=\"needs-validation tab-pane fade\" action=\"../RegisterServlet\" method=\"post\" autocomplete=\"off\" novalidate=\"\" >\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"su-name\">Tên đăng nhập</label>\r\n");
      out.write("                        <input  type=\"text\" class=\"form-control\" id=\"usernameRegister\" name=\"usernameRegister\" placeholder=\"John Doe\" >\r\n");
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
      out.write("</div>");
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
}
