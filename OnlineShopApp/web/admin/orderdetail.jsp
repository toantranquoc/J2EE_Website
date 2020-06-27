<%-- 
    Document   : order
    Created on : Jun 17, 2020, 8:10:38 PM
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
                            Chi tiết hóa đơn
                        </div>
                        
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" cellspacing="0">
                                <thead  class="thead-light">
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên SP</th>
                                        <th>Số lượng</th>
                                        <th>Đơn giá</th>
                                        <th>Thành tiền</th>
                                        
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                     <c:forEach items="${listordersdetail}" var="order" >
                                        <tr id="row_1" *ngFor="let order of listorders, let i = index">
                                            <td><%= i%></td>
                                            
                                            <td>${order.name}</td>
                                            <td>${order.quantity}</td>
                                            <td>${order.currencyFormat(order.getUnitPrice())}</td>
                                            <td>${order.currencyFormat(order.getUnitPrice()*order.quantity)}</td>
                                        </tr>
                                        <%i++;%>
                                    </c:forEach>
                                        <%i = 1;%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <td colspan="4"><b>Tổng tiền</b></td>
                                        <td colspan="1">${totalpayment}</td>
                                        
                                    </tr>
                                </tfoot>
                            </table>
                            <br>
                            
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
