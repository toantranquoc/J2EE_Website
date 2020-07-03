<%-- 
    Document   : customer
    Created on : Jun 17, 2020, 6:00:54 PM
    Author     : to cong hau
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int i = 1;%>
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
        <link href="css/admin/customer.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:directive.include file="template.jsp"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="./HomeAdminServlet"">Trang chủ</a>
                    </li>
                    <li class="breadcrumb-item active">Khách hàng</li>
                </ol>

                <!-- DataTables Example -->
                <div class="card mb-3">
                    <c:if test="${not empty messageCus}">
                        <div class="alert alert-primary">
                            <button id="xoa" type="button" class="close" data-dismiss="alert">${messageCus}
                        </div>
                    </c:if>
                    <%
                        // Removing after display
                        session.removeAttribute("messageCus");
                    %>
                    <div class="card-header row">
                        <div class="col-sm-8 mt-1">
                            <i class="fas fa-table"></i>
                            Danh sách khách hàng
                        </div>
                        <div class="col-sm-4">
                            <form class="form-inline mt-0 mt-md-0" method="GET" action="./SearchCustomer">
                                <input name="nameSearch" class="form-control-sm mr-sm-2" type="text" placeholder="Nhập tên khách hàng" aria-label="Search">
                                <button class="btn btn-info btn-sm my-2 my-sm-0" type="submit">Tìm kiếm</button>
                            </form>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" cellspacing="0">
                                <thead class="thead-light">
                                    <tr>
                                        <th>Số TT</th>
                                        <th>Username</th>
                                        <th>Họ tên</th>
                                        <th>Ngày sinh</th>
                                        <th>Email</th>
                                        <th>Số điện thoại</th>
                                        <th>Địa chỉ</th>
                                        <th>Ngày tạo</th>

                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listusers}" var="user" >
                                        <tr id="row_1" *ngFor="let user of users, let i=index">
                                            <td><%= i%></td>
                                                <td> ${user.getUsername()} </td>
                                                <td> ${user.getFullname()} </td>
                                                <td> ${user.getDateOfBirth()} </td>
                                                <td> ${user.getEmail()} </td>
                                                <td> ${user.getPhoneNumber()} </td>
                                                <td> ${user.getAddress()} </td>
                                                <td> ${user.getCreated()} </td>
                                                <td>
                                                    <a href="./DeleteUser?idUser=${user.getId()}"><li class="list-inline-item"><buttons><i class="fas fa-trash-alt fa-sm text-danger"></i></button></li></a>     
                                            </td>
                                        </tr>
                                        <%i++;%>
                                    </c:forEach>
                                         <%i=1;%>
                                </tbody>
                            </table>
                            <br>
                            <div class="d-flex justify-content-center">
<!--                                <pagination [boundaryLinks]="true"
                                    [totalItems]="pagination.totalItems"
                                    [itemsPerPage]="pagination.itemsPerPage"
                                    [(ngModel)]="pagination.currentPage"
                                    (pageChanged)="pageChanged($event)"
                                    previousText="&lsaquo;" nextText="&rsaquo;" firstText="&laquo;" lastText="&raquo;">
                                </pagination>-->
                            </div>
                        </div>
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
