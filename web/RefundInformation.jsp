<%-- 
    Document   : ShopDetailInfo
    Created on : Jan 13, 2024, 3:56:07 AM
    Author     : admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Refund Information</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Paper Dashboard core CSS    -->
        <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />

        <!--  Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">

    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="LeftAdmin.jsp"></jsp:include>

                <div class="main-panel">
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar bar1"></span>
                                    <span class="icon-bar bar2"></span>
                                    <span class="icon-bar bar3"></span>
                                </button>
                                <a class="navbar-brand" style="color:red" href="shoprefundconfirm">|< Back to Refund Confirm</a>                    
                            </div>
                            <div class="collapse navbar-collapse">
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <i class="ti-panel"></i>
                                            <p>Stats</p>
                                        </a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <i class="ti-bell"></i>
                                            <p class="notification">5</p>
                                            <p>Notifications</p>
                                            <b class="caret"></b>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Notification 1</a></li>
                                            <li><a href="#">Notification 2</a></li>
                                            <li><a href="#">Notification 3</a></li>
                                            <li><a href="#">Notification 4</a></li>
                                            <li><a href="#">Another notification</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="ti-settings"></i>
                                            <p>Settings</p>
                                        </a>
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </nav>


                    <div class="content">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-12 col-md-12">
                                    <div class="card">
                                        <div class="header">
                                            <h4 class="title">Refund confirmation</h4>
                                        </div>
                                        <div class="content">
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
                                                                        The money you will return: 
                                                                        <fmt:setLocale value="vi_VN"/>
                                                                        <b><fmt:formatNumber type="currency" value="${sanpham.getPrice()}" currencySymbol="₫"/></b>
                                                                    </h5>
                                                                    <p>
                                                                    <h5></h5>
                                                                    <c:if test="${listHD.getTrangThaiId() == 1 && listHD.getLoaiid() == 2}">
                                                                        <a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=approve" class="view" title="View Details" data-toggle="tooltip">Approve</a>
                                                                        <a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=decline" class="view" title="View Details" data-toggle="tooltip">Decline</a>
                                                                    </c:if>
                                                                    <c:if test="${listHD.getTrangThaiId() == 6 && listHD.getLoaiid() == 2}">
                                                                        In delivery
                                                                    </c:if>
                                                                    <c:if test="${listHD.getTrangThaiId() == 4 && listHD.getLoaiid() == 2}">
                                                                        Cancelled
                                                                    </c:if>
                                                                    <c:if test="${listHD.getTrangThaiId() == 5 && listHD.getLoaiid() == 2}">
                                                                        <a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=approve&getshipped=get" class="view" title="View Details" data-toggle="tooltip">Approve</a>
                                                                        <a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=decline" class="view" title="View Details" data-toggle="tooltip">Decline</a>
                                                                    </c:if>
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
                                                        <h3 class="h6">Customer reason: </h3>
                                                        <p>${reason.getReasonName()}</p>
                                                        <h3></h3>
                                                        <h3 class="h6">Solution plan: Refund product and take money back for cusotmer</h3>
                                                    </div>
                                                    <div class="card-body">
                                                        <h3 class="h6">Customer note: </h3>
                                                        <p>${rr.getNote()}</p>
                                                    </div>
                                                </div>
                                            </div>                       
                                        </div>   
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="container-fluid">

                        <div class="copyright pull-right">
                            &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com">TrongQuan</a>
                        </div>
                    </div>
                </footer>

            </div>
        </div>
    </body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="assets/js/bootstrap-checkbox-radio.js"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
    <script src="assets/js/paper-dashboard.js"></script>

    <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>

</html>