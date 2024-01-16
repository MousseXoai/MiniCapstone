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
                <!-- Title -->
                <div class="d-flex justify-content-between align-items-center py-3">
                    <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Order #${hoadon.getMaHD()}</h2>
                </div>

                <!-- Main content -->
                <div class="row">
                    <div class="col-lg-8">
                        <!-- Details -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="mb-3 d-flex justify-content-between">
                                    <div>
                                        <span class="me-3">${hoadon.getNgayXuat()}</span>
                                        <span class="me-3">#${hoadon.getMaHD()}</span>
                                        <span class="me-3">Visa</span>
                                        <span class="badge rounded-pill bg-info">
                                            <c:if test="${trangthai.getTrangThaiId() == hoadon.getTrangThaiId()}">
                                            ${trangthai.getTrangThai()}  
                                            </c:if>
                                        </span>
                                    </div>
                                    <div class="d-flex">
                                        <button class="btn btn-link p-0 me-3 d-none d-lg-block btn-icon-text"><i class="bi bi-download"></i> <span class="text">Invoice</span></button>
                                        <div class="dropdown">
                                            <button class="btn btn-link p-0 text-muted" type="button" data-bs-toggle="dropdown">
                                                <i class="bi bi-three-dots-vertical"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                                <li><a class="dropdown-item" href="#"><i class="bi bi-pencil"></i> Edit</a></li>
                                                <li><a class="dropdown-item" href="#"><i class="bi bi-printer"></i> Print</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-borderless">
                                    <tbody>

                                        <tr>
                                            <td>
                                                <div class="d-flex mb-2">
                                                    <div class="flex-shrink-0">
                                                        <img src="https://www.bootdey.com/image/280x280/FF69B4/000000" alt="" width="35" class="img-fluid">
                                                    </div>
                                                    <div class="flex-lg-grow-1 ms-3">
                                                        <h6 class="small mb-0"><a href="#" class="text-reset">Smartwatch IP68 Waterproof GPS and Bluetooth Support</a></h6>
                                                        <span class="small">Color: White</span>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>1</td>
                                            <td class="text-end">$79.99</td>
                                        </tr>
                                        
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td colspan="2">Subtotal</td>
                                            <td class="text-end">$159,98</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">Shipping</td>
                                            <td class="text-end">Free</td>
                                        </tr>
                                        <tr class="fw-bold">
                                            <td colspan="2">Total</td>
                                            <td class="text-end">$169,98</td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                        <!-- Payment -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <h3 class="h6">Payment Method</h3>
                                        <p>Visa <br>
                                            Total: $169,98 <span class="badge bg-success rounded-pill">PAID</span></p>
                                    </div>
                                    <div class="col-lg-6">
                                        <h3 class="h6">Billing address</h3>
                                        <address>
                                            <strong>${acc.getName()}</strong><br>
                                            Address: ${acc.getAddress()}<br>
                                            Email: ${acc.getEmail()}<br>
                                            Phone number: ${acc.getPhonenumber()}
                                        </address>
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
                                <p>${infoline.getNote()}</p>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <!-- Shipping information -->
                            <div class="card-body">
                                <h3 class="h6">Shipping Information</h3>
                                <strong>Giao Hàng tiết Kiệm</strong>
                                <span><a href="#" class="text-decoration-underline" target="_blank">GHTK123</a> <i class="bi bi-box-arrow-up-right"></i> </span>
                                <hr>
                                <h3 class="h6">Address</h3>
                                <address>
                                    <strong>${infoline.getName()}</strong><br>
                                    Address: ${infoline.getAddress()}<br>
                                    Email: ${infoline.getEmail()}<br>
                                    Phone number: ${infoline.getPhonenumber()}
                                </address>
                            </div>
                        </div>
                    </div>
                </div>
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

