<%-- 
    Document   : OrderDetail
    Created on : Jan 12, 2024, 5:21:20 PM
    Author     : Tosaka
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ashion Template">
        <meta name="keywords" content="Ashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ashion | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/usersetting.css" type="text/css">
        <link rel="stylesheet" href="css/orderdetailsetting.css" type="text/css">
    </head>

    <body>

        <div class="container-fluid">

            <div class="container">
                <a  href="shippinginvoice">
                    <i style="font-size: 15px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">  Back</i>  
                </a>
                <!-- Title -->
                <c:forEach items="${ListInvoiceDetailShip}" var="c">
                    <div class="d-flex justify-content-between align-items-center py-3">
                        <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Order #${c.invoiceID}</h2>
                    </div>
                    <!-- Main content -->
                    <div class="row">
                        <div class="col-lg-8">
                            <!-- Details -->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <div class="mb-3 d-flex justify-content-between">
                                        <div>
                                            <span class="me-3">#${c.invoiceID}</span>
                                            <span class="">
                                                ${c.status}  
                                            </span>
                                        </div>
                                    </div>
                                    <table class="table table-borderless">
                                        <tbody>

                                            <tr>
                                                <td>
                                                    <div class="d-flex mb-2">
                                                        <div class="flex-shrink-0">
                                                            <img src="${c.img}" alt="" width="35" class="img-fluid">
                                                        </div>
                                                        <div class="flex-lg-grow-1 ms-3">
                                                            <h6 class="small mb-0"><a href="#" class="text-reset">${c.name}</a></h6>
                                                            <span class="small">Color: ${c.color}</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>${c.quantity} (Product)</td>
                                                <td class="text-end">
                                                </td>
                                            </tr>

                                        </tbody>
                                        <tfoot>
                                            <tr class="fw-bold">
                                                <td colspan="2">Total</td>
                                                <td class="text-end">
                                                    <fmt:setLocale value="vi_VN"/>
                                                    <fmt:formatNumber type="currency" value="${c.tonggia}" currencySymbol="₫"/> 
                                                </td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                            <!-- Payment -->
                            <div class="card mb-12">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <h3 class="h6" style="color: red">Information Of Customer</h3><br>
                                                <strong>Name: ${c.cusName}</strong><br><br><!-- comment -->
                                                Address: ${c.address}<br><br>
                                                Email: ${c.email}<br><br>
                                                Phone number: ${c.phonenumber}<br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <!-- Customer Notes -->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h3 class="h6">Customer Notes</h3>
                                    <p>${c.note}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>