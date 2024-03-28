<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>Create Shop</title>

        <!-- Icons font CSS-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/main_1.css" rel="stylesheet" media="all">
        <style>
            .bg-color{
                background: #eee;
            }
        </style>
    </head>

    <body>
        <div class="page-wrapper bg-color p-t-180 p-b-100 font-robo">
            <div class="wrapper wrapper--w960">
                <div class="card card-2">
                    <div class="card-heading"></div>
                    <div class="card-body">
                        <h2 class="title">Fill in your shop info</h2>
                        <form action="createShop" method="POST" enctype="multipart/form-data">
                            <div class="input-group">
                                <input class="input--style-2" type="text" placeholder="Shop Name" required name="name">
                            </div>
                            <div class="row row-space">
                                <input type="text" class="input--style-2" value="Upload proof" readonly>
                                <div class="input-group">
                                    <input required name="proof1" type="file" >
                                </div>
                                <div class="input-group">
                                    <input required name="proof2" type="file">
                                </div>
                            </div>
                            <c:forEach items="${email}" var="e">
                            
                                    <div class="input-group">
                                        <input class="input--style-2" type="text" name="email" value="${e.email}" readonly>
                                    </div>
                              
                            </c:forEach>
                            
                                    <div  class="input-group">
                                        <input class="input--style-2" type="text" placeholder="Address" required name="address">
                                    </div>
                             
                            
                            <div class="p-t-30">
                                <button class="btn btn--radius btn--green" type="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Jquery JS-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/datepicker/moment.min.js"></script>
        <script src="vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="js/global.js"></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->