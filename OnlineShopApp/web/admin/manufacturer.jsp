<%-- 
    Document   : manufacturer
    Created on : Jun 17, 2020, 8:19:11 PM
    Author     : to cong hau
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int i = 1;%>
<%! String isActive = ""; %>
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:directive.include file="template.jsp"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="./HomeAdminServlet">Trang chủ</a>
                    </li>
                    <li class="breadcrumb-item active">Nhà cung cấp</li>
                </ol>

                <!-- DataTables Example -->
                <div class="card mb-3">
                    <c:if test="${not empty messageManu}">
                        <div class="alert alert-primary">
                            <button id="xoa" type="button" class="close" data-dismiss="alert">&times;</button>${messageManu}
                        </div>
                    </c:if>
                    <%
                        // Removing after display
                        session.removeAttribute("messageManu");
                    %>
                    <div class="card-header row">
                        <div class="col-sm-6 mt-1">
                            <i class="fas fa-table"></i>
                            Danh sách nhà cung cấp
                        </div>
                        <div class="col-sm-4">
                            <form class="form-inline mt-0 mt-md-0" method="GET" action="./SearchManufacturer">
                                <input name="nameSearch" class="form-control-sm mr-sm-2" type="text" placeholder="Nhập tên nhà cung cấp" aria-label="Search">
                                <button class="btn btn-info btn-sm my-2 my-sm-0" type="submit">Tìm kiếm</button>
                            </form>
                        </div>
                        <div class="col-sm-2">
                            <a class="btn btn-success btn-sm" style="float:right" href="./AddNewManufacturerAdminServlet">
                                Thêm mới
                            </a>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" cellspacing="0">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên hãng</th>
                                        <th>Trạng thái</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                     <c:forEach items="${listmanufacturers}" var="manufacturer" >
                                        <tr id="row_1" *ngFor="let manufacturer of manufacturers, let i = index">
                                            <td><%= i%></td>
                                            <td>${manufacturer.name}</td>
                                            
                                            <td>${manufacturer.isActive == true? 'Hoạt động': 'Không hoạt động'}</td>
                                            <td>
                                                <a href="./RemoveManufacturer?idManu=${manufacturer.getIDManufacturer()}"><li class="list-inline-item"><buttons><i class="fas fa-trash-alt fa-sm text-danger"></i></button></li></a>     
                                            </td>
                                        </tr>
                                        <%i++;%>
                                    </c:forEach>
                                        <%i = 1;%>
                                </tbody>
                            </table>
                            <br>
<!--                            <div class="d-flex justify-content-center">
                                <pagination [boundaryLinks]="true"
                                    [totalItems]="pagination.totalItems"
                                    [itemsPerPage]="pagination.itemsPerPage"
                                    [(ngModel)]="pagination.currentPage"
                                    (pageChanged)="pageChanged($event)"
                                    previousText="&lsaquo;" nextText="&rsaquo;" firstText="&laquo;" lastText="&raquo;">
                                </pagination>
                            </div>-->
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
    <script type="text/javascript">
        
    </script>
</html>
