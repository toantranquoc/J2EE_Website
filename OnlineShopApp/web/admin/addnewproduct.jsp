<%-- 
    Document   : addnewproduct
    Created on : Jun 17, 2020, 8:33:04 PM
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
        <link href="css/admin/addnewproduct.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    </head>
    <script>
        $( document ).ready(function() {
            $('#save').click(function(){
                debugger;
                var filename = $('#photo')[0].files[0];
                const  fileType = filename['type'];
                const validImageTypes = ['image/gif', 'image/jpeg', 'image/png'];
                if (!validImageTypes.includes(fileType)) {
                    // invalid file type code goes here.
                    alert("file không hợp lệ");
                    return false;
                }
               
            });
            
            
        });
        
    </script>
    </head>
    <body>
        <jsp:directive.include file="template.jsp"/>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4" >
            <div class="container mt-4">
                <div class="row">
                    <div class="col-sm-10">
                        <form method="post" action="./AddNewProductAdminServlet" enctype="multipart/form-data">
                        <h4>Thông tin thêm mới</h4>
                        
                            <div class="form-group">
                                <h6>Tên sản phẩm</h6>
                                <div class="col-4">
                                    <input type="text" name="name" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <h6>Hình ảnh</h6>
                                <div class="col-4">
                                    <input type="file" name="photo" id="photo" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <h6>Giá</h6>
                                <div class="col-3">
                                    <input type="number" name="price" class="form-control" min="0" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <h6>Giới thiệu</h6>
                                <div class="col-10">
                                    <textarea rows="4" name="introduction" class="form-control"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <h6>Số lượng</h6>
                                <div class="col-3">
                                    <input type="number" name="quantity" class="form-control" min="0" required>
                                </div>
                            </div>

                            <div class="form-group row inlineRow">
                                <h6>Mới</h6>
                                <div class="col-4">
                                    <input type="checkbox" name="isNew" class="form-control isNew" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <h6>Mô tả</h6>
                                <div class="col-10">
                                    <textarea rows="4" name="description" class="form-control"></textarea>
                                </div>
                            </div>

                            <div class="form-group row mt-4 inlineRow">
                                <h6 style="margin-top:3px;">Hãng sản xuất</h6>
                                <div class="ml-5 styled-select">
                                    <!-- <select [(ngModel)]="selectedLevel" (change)="selected()">
                                      <option *ngFor="let item of data" [ngValue]="item">{{item.name}}</option>
                                    </select> -->
                                    
                                    <select name="manu">
                                        <c:forEach items="${listmanufacturers}" var="manufacturer" >
                                            <option value="${manufacturer.getIDManufacturer()}">${manufacturer.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group mt-5 ml-3">
                                <button class="btn btn-primary btn-sm" id="save"
                                        type="submit">Lưu</button>
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
