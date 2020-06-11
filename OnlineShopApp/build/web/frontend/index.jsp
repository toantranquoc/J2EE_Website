<%-- 
    Document   : index
    Created on : Jun 7, 2020, 12:47:39 PM
    Author     : to cong hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/2d0af8021d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>

        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">

                <div class="item active image-slide">
                    <img src="images/bg_4.jpg" alt="Image" style="width:100%;">
                </div>

                <div class="item">
                    <img src="images/bg_1.jpg" alt="Image" style="width:100%;">
                </div>

                <div class="item">
                    <img src="images/bg_2.jpg" alt="Image" style="width:100%;">
                </div>

                <div class="item">
                    <img src="images/bg_3.jpg" alt="Image" style="width:100%;">
                </div>

            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div align="center">
            <h3>This is main content: </h3>
            <h2>New books</h2>
            <h2>Best-Selling Books</h2>
        </div>
        <jsp:directive.include file="footer.jsp"/>
<!--        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>-->
        <script src="https://code.jquery.com/jquery-3.1.1.min.js">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
    <script type="text/javascript">
        function closeDialog() {
            document.getElementById('modal').style.display = "none";
        }

        function openDialog() {
            document.getElementById('modal').style.display = "block";
        }

        function showPassword() {
            var typePassword = document.getElementById('password').type;
            if (typePassword === "password") {
                document.getElementById('password').type = "text";
                document.getElementById("showEye").className = "fa fa-eye-slash password-toggle-indicator";
            } else {
                document.getElementById('password').type = "password";
                document.getElementById("showEye").className = "fa fa-eye password-toggle-indicator'";
            }
        }
    </script>
</html>
