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
                <a  href="orderdetail?invoiceID=${hoadon.getMaHD()}">
                    <i style="font-size: 15px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">  Back</i>  
                </a>
                <!-- Title -->
                <div class="d-flex justify-content-between align-items-center py-3">
                    <h2 class="h5 mb-0"><a href="#" class="text-muted"></a>Refund invoice #${hoadon.getMaHD()}</h2>
                </div>

                <!-- Main content -->    
                <form action="refund" method="post">
                <div class="row">                   
                    <div class="col-lg-8">
                        <!-- Details -->
                        <div class="card mb-4">
                            <div class="card-body">
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
                                                        <h6 class="small">
                                                            <c:if test="${trangthai.getTrangThaiId() == hoadon.getTrangThaiId()}">
                                                                ${trangthai.getTrangThai()}  
                                                            </c:if>
                                                        </h6>
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
                                </table>
                            </div>
                        </div>
                        <!-- Payment -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <h3 class="h6">Information refund order</h3>                                      
                                        <input type="hidden" name="invoiceID" value="${hoadon.getMaHD()}">
                                        <p>Money for refund: 
                                            <fmt:setLocale value="vi_VN"/>
                                            <b><fmt:formatNumber type="currency" value="${sanpham.getPrice()}" currencySymbol="₫"/></b>
                                        </p>
                                        <p>Refund in: Tech Market Account Balance</p>
                                        <p>Account name: ${acc.getName()}</p>
                                        <p>Email: ${acc.getEmail()}</p>
                                        <hr/>
                                        <div class="col-lg-12" style="text-align: right;">
                                            <h5>
                                                The money you will receive: 
                                                <fmt:setLocale value="vi_VN"/>
                                                <b><fmt:formatNumber type="currency" value="${sanpham.getPrice()}" currencySymbol="₫"/></b>
                                            </h5>
                                            <p>
                                            <h5></h5>
                                            <button type="submit" class="btn btn-sm btn-primary">Refund now</button>                                       
                                        </div>                                     
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <!-- Customer Notes -->
                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6">Reason</h3>
                                <div class="checkout__order__widget">
                                    <select name="reason_option" id="reason_option">
                                        <c:forEach items="${reason}" var="reason">
                                            <option value="${reason.getReasonID()}">${reason.getReasonName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <h3></h3>
                                <h3 class="h6">Solution plan: Refund product and take money back</h3>
                            </div>
                            <div class="card-body">
                                <h3 class="h6">Note</h3>
                                <textarea type="text" name="note" placeholder="Note about why you need to refund" style="width: 100%; height: 291px;"></textarea>
                            </div>
                        </div>
                    </div>                       
                </div>   
                </form>
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