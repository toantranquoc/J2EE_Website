<%@page import="java.util.ArrayList"%>
<%@page import="com.onlineshop.dto.ProductDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int i = 1;%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
    Integer sum = (Integer)request.getAttribute("SUM");
    ArrayList<ProductDTO> ls = (ArrayList<ProductDTO>)request.getAttribute("top10pro");
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
if(ls != null && sum > 0)
{
    for(ProductDTO pro : ls) {
        map = new HashMap<Object,Object>(); map.put("label", pro.getName()); map.put("y", pro.getQuantity()/sum*100); list.add(map);
    }
}

String dataPoints = gsonObj.toJson(list);
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
        <link href="css/admin/product.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.twbsPagination.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <script type="text/javascript">
        window.onload = function() { 

        var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title:{
                        text: "Top 10 sản phẩm bán chạy"
                },
                legend: {
                        verticalAlign: "center",
                        horizontalAlign: "right"
                },
                data: [{
                        type: "pie",
                        showInLegend: true,
                        indexLabel: "{y}%",
                        indexLabelPlacement: "inside",
                        legendText: "{label}: {y}%",
                        toolTipContent: "<b>{label}</b>: {y}%",
                        dataPoints : <%out.print(dataPoints);%>
                }]
        });
        chart.render();

        }
        </script>
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
                </ol>

                <!-- DataTables Example -->
                <div class="card mb-3">
                   
                    <div class="card-header row">
                        
                        <div class="col-sm-6 mt-1">
                            <i class="fas fa-table"></i>
                            Top 10 sản phẩm bán chạy nhất
                        </div>
                        <div class="col-sm-4">
                            <form class="form-inline mt-0 mt-md-0" method="GET" action="./chart">
                                <input type="date" id="startDate" name="startDate" placeholder="Từ ngày" value="${StartDate}">
                                <input type="date" id="endDate" name="endDate" placeholder="Đến ngày" value="${EndDate}">
                                <button class="btn btn-info btn-sm my-2 my-sm-0" type="submit">Xem kết quả</button>
                            </form>
                        </div>
                        
                    </div>
                   <div id="chartContainer" style="height: 370px; width: 100%;"></div> 
                </div>
            </div>

        </main>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
    
    
</html>