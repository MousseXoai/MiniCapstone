

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>khách hàng thân thiết</title>
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
    </style>
</head>

<body onload="time()" class="app sidebar-mini rtl">
    <fmt:setLocale value="vi_VN" />
    <fmt:setBundle basename="path.to.your.resource.bundle" />
    <!-- Navbar-->
    <header class="app-header">
        <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                        aria-label="Hide Sidebar"></a>
        <!-- Navbar Right Menu-->
        <ul class="app-nav">


            <!-- User Menu-->
            <li><a class="app-nav__item" href="statistic"><i class='bx bx-log-out bx-rotate-180'></i> </a>

            </li>
        </ul>
    </header>
    <!-- Sidebar menu-->


    <main style="margin-left: 0" class="app-content">
        <div class="app-title">
            <ul class="app-breadcrumb breadcrumb side">
                <li class="breadcrumb-item active"><b>Danh sách khách hàng thân thiết</b></a></li>
            </ul>
            <div id="clock"></div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <div class="tile-body">
                        <div class="row element-button"> </div>
                        <table class="table table-hover table-bordered" id="sampleTable">
                            <thead>
                                <tr>
                                    <th>User ID</th>
                                    <th>Name</th>
                                    <th>Avatar</th>
                                    <th>address</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Total Spent</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${LoyalCustomers}" var="Loyal">
                                    <tr>
                                        <td>${Loyal.getuID()}</td>
                                        <td>${Loyal.getName()}</td>
                                        <td><img src="${Loyal.getAvatar()}" alt="" width="100px;"></td>                            
                                        <td>${Loyal.getAddress()}</td>
                                        <td>${Loyal.getPhonenumber()}</td>
                                        <td>${Loyal.getEmail()}</td>

                                        <td ><fmt:setLocale value="vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${Loyal.getTongChiTieu()}" currencySymbol="₫"/></td>
                                    </tr>
                                </c:forEach>
                        </table>

                        </main>
                        </body>
                        </html>
