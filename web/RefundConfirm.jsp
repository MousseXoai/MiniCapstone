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
                                <a class="navbar-brand" href="#">Refund Confirm </a>
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
                                            <table class="table table-striped table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>MaHD</th>
                                                        <th>Product</th>
                                                        <th>Order Date</th>						
                                                        <th>Status</th>						
                                                        <th>Total Price</th>
                                                        <th>Details</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>            
                                              
                                                <c:forEach items="${listHD}" var="listHD">      
                                                    <tr>
                                                        <td>${listHD.getMaHD()}                                                          
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${listOL}" var="listOL"> 
                                                                <c:if test="${listOL.getInvoiceID() == listHD.getMaHD()}">
                                                                    <c:forEach items="${listSP}" var="listSP">
                                                                        <c:if test="${listSP.getId() == listOL.getProductID() }">
                                                                            <img style="max-width: 25%; height: auto;" src="${listSP.getImage()}" class="avatar">${listSP.getName()}
                                                                        </c:if>
                                                                    </c:forEach>                                   
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td>${listHD.getNgayXuat()}</td>                        
                                                        <td><span class="status text-success">&bull;</span>    
                                                            <c:forEach items="${listTT}" var="listTT">  
                                                                <c:if test="${listHD.getTrangThaiId() == listTT.getTrangThaiId()}">
                                                                    ${listTT.getTrangThai()}  
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td> 
                                                            <c:forEach items="${listOL}" var="listOL"> 
                                                                <c:if test="${listOL.getInvoiceID() == listHD.getMaHD()}">
                                                                    <c:forEach items="${listSP}" var="listSP">
                                                                        <c:if test="${listSP.getId() == listOL.getProductID()}">
                                                                            <fmt:setLocale value="vi_VN"/>
                                                                            <fmt:formatNumber type="currency" value="${listSP.getPrice()*listOL.getQuantity()}" currencySymbol="₫"/>
                                                                        </c:if>
                                                                    </c:forEach>                                   
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td><a href="refundinfomation?invoiceID=${listHD.getMaHD()}" class="view" title="View Details" data-toggle="tooltip">Details</a></td>
                                                        <c:if test="${listHD.getTrangThaiId() == 1 && listHD.getLoaiid() == 2}">
                                                        <td><a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=approve&getshipped=shipping" class="view" title="View Details" data-toggle="tooltip">Approve</a></td>
                                                        <td><a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=decline&getshipped=shipping" class="view" title="View Details" data-toggle="tooltip">Decline</a></td>
                                                        </c:if>
                                                        <c:if test="${listHD.getTrangThaiId() == 6 && listHD.getLoaiid() == 2}">
                                                            <td>In delivery</td>
                                                        </c:if>
                                                        <c:if test="${listHD.getTrangThaiId() == 4 && listHD.getLoaiid() == 2}">
                                                            <td>Cancelled</td>
                                                        </c:if>
                                                        <c:if test="${listHD.getTrangThaiId() == 5 && listHD.getLoaiid() == 2}">
                                                            <td><a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=approve&getshipped=done" class="view" title="View Details" data-toggle="tooltip">Approve</a></td>
                                                            <td><a href="refunddecide?invoiceID=${listHD.getMaHD()}&status=decline&getshipped=done" class="view" title="View Details" data-toggle="tooltip">Decline</a></td>
                                                        </c:if>
                                                    </tr>  
                                                </c:forEach>  
                                                  
                                            </tbody>
                                        </table>
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