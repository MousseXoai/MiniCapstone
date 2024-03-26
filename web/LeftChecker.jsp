<%-- 
    Document   : LeftChecker
    Created on : Mar 23, 2024, 3:13:23 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Left Admin</title>

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
        <script src="assets/js/demo.js"></script>

    </head>
    <body>
        <div class="wrapper">
            <div class="sidebar" data-background-color="white" data-active-color="danger">


                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="#" class="simple-text">
                            Checker
                        </a>
                    </div>

                    <ul class="nav">
                        <li id="dashboardMenuItem">
                            <a href="statistic">
                                <i class="ti-panel"></i>
                                <p>Manage Product</p>
                            </a>
                        </li>
                        <li id="shopProfileMenuItem">
                            <a href="managerContact">
                                <i class="ti-user"></i>
                                <p>Manage Contact</p>
                            </a>
                        </li>
                        <li>
                            <a href="checkReport">
                                <i class="ti-view-list-alt"></i>
                                <p>Manage Report</p>
                            </a>
                        </li>
                      
                        
                    </ul>
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
    <script>
        // Get the current page URL
        var currentPage = window.location.href;

        // Highlight the active menu item based on the current URL
        if (currentPage.includes("statistic")) {
            document.getElementById("dashboardMenuItem").classList.add("active");
        } 
        else if (currentPage.includes("ShopDetailInfoControl")) {
            document.getElementById("shopProfileMenuItem").classList.add("active");
        }
        else if (currentPage.includes("shoprefundconfirm")) {
            document.getElementById("shoprefundconfirm").classList.add("active");
        }
        // Add similar conditions for other menu items
    </script>

</html>
