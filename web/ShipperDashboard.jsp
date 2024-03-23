<%-- 
    Document   : ShipperDashboard
    Created on : Mar 23, 2024, 2:55:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Ship</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <style>
            .edit {
                background-color: #28a745;
                color: #fff;
                border: none;
                padding: 8px 16px;
                border-radius: 4px;
                cursor: pointer;
            }

            .edit:hover {
                background-color: #218838; /* Darker color on hover */
            }

            /* Style the delete button */
            .trash {
                background-color: #dc3545;
                color: #fff;
                border: none;
                padding: 8px 16px;
                border-radius: 4px;
                cursor: pointer;
            }

            .trash:hover {
                background-color: #c82333; /* Darker color on hover */
            }
            .app-content-1{
                margin-top: 10px;
            }
            .app-title1 {
                display: block;
                background-color: #FFF;
                padding: 10px 30px;
                margin-bottom: 20px;
                border-radius: .375rem;
                -webkit-box-shadow: 0 1px 2px rgb(0 0 0 / 10%);
                box-shadow: 0 1px 2px rgb(0 0 0 / 10%);
                border-left: 6px solid #FFD43B;
            }
            .app-title2{
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
                -webkit-box-orient: horizontal;
                -webkit-box-direction: normal;
                -ms-flex-direction: row;
                flex-direction: row;
            }

            /*----------------------------*\
                    Main nav
            \*----------------------------*/
            .container1{
                width: 100%;
                padding-right: 15px;
                padding-left: 15px;
                margin-right: auto;

            }
            .navbar-nav-1{
                margin:7.5px -15px;
            }
            .navbar-nav-1>li>a{
                display: flex;
                padding-top:10px;
                padding-bottom:10px;
                line-height:20px;
            }
            .navbar-nav-1 a{
                text-decoration: none;
            }
            .main-nav>li+li {
                margin-left: 30px;
            }

            .main-nav>li>a {
                padding: 20px 0px;
            }

            .main-nav>li>a:hover, .main-nav>li>a:focus, .main-nav>li.active>a {
                color: #FFD43B;
                background-color: transparent;
            }

            .main-nav>li>a:after {
                content: "";
                display: block;
                width: 0%;
                height: 2px;
                background-color: #FFD43B;
                -webkit-transition: 0.2s all;
                transition: 0.2s all;
            }

            .main-nav>li>a:hover:after, .main-nav>li>a:focus:after, .main-nav>li.active>a:after {
                width: 100%;
            }

            .header-ctn li.nav-toggle {
                display: none;
            }
            .nav {
                padding-left: 0;
                margin-bottom: 0;
                list-style: none;
            }
            .nav>li{
                position: relative;
                display: block;
            }
            .nav>li>a{
                position: relative;
                display: block;
                padding: 10px 15px;
            }
            .bg-delivery{
                background-color: #FFD43B !important;
                color: #FFF !important;
            }
        </style>
    </head>

    <body onload="time()" class="app sidebar-mini rtl">


        <main class="app-content-1">
            <div class="app-title1">
                <div class="app-title2">

                    <ul class="app-breadcrumb breadcrumb side">
                        <li class="breadcrumb-item active"><a href="#"><b>Ship</b></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="logout">

                                <p>Logout</p>
                            </a>
                        </li>

                    </ul>
                </div>

                <hr style="background: #000">

            </div>
           
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">




                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>

                                        <th>Order Date</th>
                                        <th>Order Details</th>
                                        <th>Image</th>
                                        <th>Product Name</th>
                                        <th>Delivery Address</th>
                                        <th>Order Status</th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="c">


                                        <tr>                                           
                                            <td><span>${c.ngayXuat}</span><br></td>
                                            <td>
                                                <input type="hidden" name="maHD" value="${c.maHD}"/>
                                                <span>Mã Hóa Đơn: ${c.maHD}</span><br>
                                                <c:forEach items="${accInfo}" var="a">
                                                    <c:if test="${c.accountID == a.uID}">
                                                        <span>Buyer Name: ${a.name}</span><br>
                                                        <span>Address: ${a.address}</span>

                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <c:forEach items="${orderLine}" var="o">
                                                <c:if test="${o.invoiceID == c.maHD}">
                                                    <c:forEach items="${productList}" var="p">

                                                        <c:if test="${p.id == o.productID}">   
                                                            <td><img src="${p.image}" style="width: 70px;"></td>
                                                            <td>
                                                                <span>${p.name}</span><br>

                                                                <span>Quantity: ${o.quantity}</span><br>
                                                                <span>Item subtotal: <fmt:formatNumber type="currency" value="${o.price}" /> đ</span>

                                                            </td>
                                                        </c:if>

                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach>
                                            <c:forEach items="${infoLine}" var="i">
                                                <c:if test="${i.invoiceID == c.maHD}">
                                                    <td>
                                                        <span>${i.address}</span><br>
                                                        <span>${i.phonenumber}</span><br>
                                                        <span>${i.note}</span>
                                                    </td>
                                                </c:if>
                                            </c:forEach>




                                            <td>
                                                <c:if test="${c.trangThaiId == 2}">
                                                    <span class="badge bg-danger">
                                                        Delivering to customer
                                                    </span>
                                                </c:if>
                                                <c:if test="${c.trangThaiId == 6}">
                                                    <span class="badge bg-delivery">
                                                        Delivering to shop
                                                    </span>
                                                </c:if>

                                            </td>




                                            <td>
                                                <a href="changeDelivery?status=${c.trangThaiId}&id=${c.maHD}">Giao Hàng Thành Công</a>
                                            </td>




                                        </tr>




                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!--
          MODAL
        -->


        <!--
        MODAL
        -->

        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>

    </body>

</html>
