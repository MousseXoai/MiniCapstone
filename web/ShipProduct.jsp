<%-- 
    Document   : QuanLySanPham
    Created on : Jan 15, 2024, 1:18:40 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Seller Order Management</title>
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
                        <li class="breadcrumb-item active"><a href="shipperProfile"><b>Back</b></a></li>
                        <li class="breadcrumb-item active"><a href="#"><b>Product Waiting to ship</b></a></li>
                    </ul>
                    <div>
                        <form action="searchship1">
                            Invoice ID
                            <input type="text" name="input" value="${inv}"/>
                            <input type="submit" value="Search"/>
                        </form>

                    </div>

                </div>

                <hr style="background: #000">
                <nav id="navigation">
                    <div class="container1">
                        <div id="responsive-nav">
                            <ul class="main-nav nav navbar-nav-1">
                                <li ><a href="shippinginvoice">Đơn đang giao</a></li>
                                <li ><a href="shipdone">Đơn giao thành công</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>

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
                                        <th>Mã hóa đơn</th>
                                        <th>Image</th>
                                        <th>Product Name</th>
                                        <th>Address</th>
                                        <th>Next</th>
                                        <th>View detail</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ListInvoiceShipping}" var="c">
                                        <tr>                                           
                                            <td>
                                                <input type="hidden" name="maHD" value="${c.invoiceID}"/>
                                                <span>${c.invoiceID}</span><br>
                                            </td>
                                            <td><img src="${c.img}" style="width: 70px;"></td>
                                            <td>
                                                <span>${c.name}</span><br>
                                            </td>
                                            <td>
                                                <span>${c.address}</span><br>
                                            </td>
                                            <td>
                                                <form action="changestatus">
                                                    <input type="hidden" name="ivId" value="${c.invoiceID}">
                                                    <button type="submit">Done</button>
                                                </form>
                                            </td>
                                            <td>
                                                <a href="shipdetailinvoice?invoiceId=${c.invoiceID}" style="color: blue">View</a>
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
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>

    </body>

</html>