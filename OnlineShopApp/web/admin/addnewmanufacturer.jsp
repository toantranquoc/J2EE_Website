<%-- 
    Document   : addnewmanufacturer
    Created on : Jun 17, 2020, 9:22:53 PM
    Author     : to cong hau
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session = request.getSession();
    String mess = "";
    mess = (String) session.getAttribute("mess");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản trị</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2d0af8021d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"/>
        <link href="css/admin/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/admin/addnewmanufacturer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:directive.include file="template.jsp"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4" >
            <div class="container">
                <div class="row">
                    <div class="col-5">
                        <form autocomplete="off" method="post" novalidate="" onsubmit="return validRegister()" action="./AddNewManufacturerAdminServlet">
                            <h4 class="text-danger">Thêm Nhà cung cấp</h4>
                            <c:if test="${not empty mess}">
                                <div class="alert alert-danger">
                                    ${mess}
                                </div>
                            </c:if>
                            <input type="hidden" name="idManufacturer">
                            <div class="form-group row">
                                <label for="su-nameManufacturer" class="col-sm-5 col-form-label">Tên hãng</label>
                                <div class="col-7">
                                    <input type="text" name="name"
                                           class="form-control" required minlength="2" maxlength="20">
                                </div>
                            </div>
                            
                            <div>
                                <span></span>
                            </div>
                            <div class="form-group row">
                                <label for="status" class="col-sm-5 col-form-label">Trạng thái hoạt động</label>
                                <div class="col-7">
                                    <input type="checkbox" id="status" name="status">
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <button class="btn btn-primary btn-sm"
                                       type="submit">Thêm mới</button>
                                <a href="./HomeAdminServlet">
                                    <button class="btn btn btn-danger btn-sm" style="margin-left: 10px;"
                                        type="button">Quay lại</button>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </body>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
</html>
