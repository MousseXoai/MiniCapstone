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
        <style>
            .row-feedback{
                
                -ms-flex-wrap: wrap;
                flex-wrap: wrap;
                margin-right: -15px;
                margin-left: -15px;
            }
        </style>
    </head>

    <body>

        <div class="container-fluid">

            <div class="container">
                <a  href="SellerOrderManagement">
                    <i style="font-size: 15px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">  Back</i>  
                </a>
                <!-- Title -->
                <div class="d-flex justify-content-between align-items-center py-3">
                    <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Order #${hoadon.getMaHD()}</h2>
                </div>

                <!-- Main content -->
                <div class="row-feedback">
                    <div class="">
                        <!-- Details -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="mb-3 d-flex justify-content-between">
                                    <div>
                                        <span class="me-3">${hoadon.getNgayXuat()}</span>
                                        <span class="me-3">#${hoadon.getMaHD()}</span>
                                        <span class="me-3">Visa</span>
                                        <span class="">
                                            <c:if test="${trangthai.getTrangThaiId() == hoadon.getTrangThaiId()}">
                                                ${trangthai.getTrangThai()}  
                                            </c:if>
                                        </span>
                                    </div>
                                    <div class="d-flex">
<!--                                        <button class="btn btn-link p-0 me-3 d-none d-lg-block btn-icon-text"><i class="bi bi-download"></i> <span class="text">Invoice</span></button>
                                        <div class="dropdown">
                                            <button class="btn btn-link p-0 text-muted" type="button" data-bs-toggle="dropdown">
                                                <i class="bi bi-three-dots-vertical"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                                <li><a class="dropdown-item" href="#"><i class="bi bi-pencil"></i> Edit</a></li>
                                                <li><a class="dropdown-item" href="#"><i class="bi bi-printer"></i> Print</a></li>
                                            </ul>
                                        </div>-->
                                    </div>
                                </div>
                                <table class="table table-borderless">
                                    <tbody>

                                        <tr>
                                            <td>
                                                <div class="d-flex mb-2">
                                                    <div class="flex-shrink-0">
                                                        <img src="${sanpham.getImage()}" alt="" width="35" class="img-fluid">
                                                    </div>
                                                    <div class="flex-lg-grow-1 ms-3">
                                                        <h6 class="small mb-0"><a href="#" class="text-reset">${sanpham.getName()}</a></h6>
                                                        <span class="small">Color: ${sanpham.getColor()}</span>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>${orderline.getQuantity()}</td>
                                            <td class="text-end">
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber type="currency" value="${sanpham.getPrice()}" currencySymbol="₫"/>                                              
                                            </td>
                                        </tr>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td colspan="2">Subtotal</td>
                                            <td class="text-end">
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber type="currency" value="${sanpham.getPrice() * orderline.getQuantity()}" currencySymbol="₫"/> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">Shipping</td>
                                            <td class="text-end">Free</td>
                                        </tr>
                                        <tr class="fw-bold">
                                            <td colspan="2">Total</td>
                                            <td class="text-end">
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber type="currency" value="${sanpham.getPrice() * orderline.getQuantity()}" currencySymbol="₫"/> 
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                        
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div style="display: flex;">
                                            
                                        <img src="${accinfo.getAvatar()}" class="img" alt="" id="profileImage"/>
                                        <div style="margin-left: 10px">
                                        <h5>${accinfo.getName()}</h5>
                                        <p style="font-weight: bold">${nhanxet.getDateReview()}</p>
                                        </div>
                                        </div>
                                        <p>${nhanxet.getContentReview()}</p>
                                    </div>
                                </div>
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