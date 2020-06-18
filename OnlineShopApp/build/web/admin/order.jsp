<%-- 
    Document   : order
    Created on : Jun 17, 2020, 8:10:38 PM
    Author     : to cong hau
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link href="css/admin/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/admin/order.css" rel="stylesheet" type="text/css"/>
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
                    <li class="breadcrumb-item active">Hoá đơn</li>
                </ol>

                <!-- DataTables Example -->
                <div class="card mb-3">
                    <div class="card-header row">
                        <div class="col-sm-6 mt-1">
                            <i class="fas fa-table"></i>
                            Danh sách hóa đơn
                        </div>
                        <div class="col-sm-4">
                            <form class="form-inline mt-0 mt-md-0">
                                <input name="name" class="form-control-sm mr-sm-2" type="text" placeholder="Nhập tên người nhận" aria-label="Search">
                                <button class="btn btn-info btn-sm my-2 my-sm-0" type="submit">Tìm kiếm</button>
                            </form>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" cellspacing="0">
                                <thead  class="thead-light">
                                    <tr>
                                        <th>Mã hóa đơn</th>
                                        <th>Người nhận</th>
                                        <th>Số điện thoại</th>
                                        <th>Email</th>
                                        <th>Địa chỉ</th>
                                        <th>Ngày đặt</th>
                                        <th>Thanh toán</th>
                                        <th>Trạng thái</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
<!--                                    <tr id="row_1" *ngFor="let order of listOrders">
                                        <td><a [routerLink]="['detail/', order.idOrder]">{{order.idOrder}}</a></td>
                                        <td>{{order.receiver}}</td>
                                        <td>{{order.phoneNumber}}</td>
                                        <td>{{order.email}}</td>
                                        <td>{{order.address}}</td>
                                        <td>{{order.orderDate}}</td>
                                        <td>{{order.paid}}</td>
                                        <td *ngIf="order.orderState == 1">Đang chờ xử lý</td>
                                        <td *ngIf="order.orderState == 2">Đã xác nhận</td>
                                        <td *ngIf="order.orderState == 0">Đơn hàng bị hủy</td>
                                        <td>
                                            <i (click)="updateOrder(order.idOrder, 2)" class="fas fa-check fa-sm text-primary"></i>
                                            |
                                            <i (click)="updateOrder(order.idOrder, 0)" class="fas fa-trash-alt fa-sm text-danger"></i>
                                        </td>
                                    </tr>-->
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <td colspan="7"><b>Tổng đơn hàng</b></td>
                                        <td colspan="1">{{listOrders.length}}</td>
                                    </tr>
                                </tfoot>
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
