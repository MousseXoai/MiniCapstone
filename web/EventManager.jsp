<%-- 
    Document   : EventManager
    Created on : Feb 23, 2024, 1:33:56 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Statistic Your Online Shop</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Paper Dashboard core CSS    -->
        <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>


        <!-- Icon sweet alert -->
        <link href="assets/css/demo.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css"href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

        <!--  Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">
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
        <fmt:setBundle basename="path.to.your.resource.bundle" />>

        <div class="wrapper">
            <jsp:include page="LeftAdmin.jsp"></jsp:include>
            <fmt:setLocale value="vi_VN" />
            <fmt:setBundle basename="path.to.your.resource.bundle" />
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
                            <a class="navbar-brand" href="#">Event Marketing</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="logout">

                                        <p>Logout</p>
                                    </a>
                                </li>
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
                <main class="app-content">
                    <div class="app-title">

                        <div id="clock"></div>
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
                                                <th width="10"><input type="checkbox" id="all"></th>
                                                <th>EventID</th>
                                                
                                                <th>Image</th>
                                                <th>Event Name</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${getEvent}" var="e">
                                                <tr>
                                                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                                                    <td>${e.eid}</td>
                                                    
                                                    <td><img src="${e.image}" alt="" width="400"></td>
                                                    <td>${e.eventName}</td>


                                                    <td>
                                                        <button class="btn btn-primary btn-sm trash" type="button" title="Xóa" onclick="confirmDelete(${e.eid})">
                                                            <i class="fas fa-trash-alt"></i> Xóa
                                                            </button>
                                                            <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" data-toggle="modal" data-target="#ModalUP" onclick="editProduct(${p.id})">
                                                                <i class="fas fa-edit"></i> Chỉnh sửa
                                                            </button>

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
                <script type="text/javascript">
                                                                $('#sampleTable').DataTable();
                                                                //Thời Gian
                                                                function time() {
                                                                    var today = new Date();
                                                                    var weekday = new Array(7);
                                                                    weekday[0] = "Chủ Nhật";
                                                                    weekday[1] = "Thứ Hai";
                                                                    weekday[2] = "Thứ Ba";
                                                                    weekday[3] = "Thứ Tư";
                                                                    weekday[4] = "Thứ Năm";
                                                                    weekday[5] = "Thứ Sáu";
                                                                    weekday[6] = "Thứ Bảy";
                                                                    var day = weekday[today.getDay()];
                                                                    var dd = today.getDate();
                                                                    var mm = today.getMonth() + 1;
                                                                    var yyyy = today.getFullYear();
                                                                    var h = today.getHours();
                                                                    var m = today.getMinutes();
                                                                    var s = today.getSeconds();
                                                                    m = checkTime(m);
                                                                    s = checkTime(s);
                                                                    nowTime = h + " giờ " + m + " phút " + s + " giây";
                                                                    if (dd < 10) {
                                                                        dd = '0' + dd
                                                                    }
                                                                    if (mm < 10) {
                                                                        mm = '0' + mm
                                                                    }
                                                                    today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                                                                    tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                                                                            '</span>';
                                                                    document.getElementById("clock").innerHTML = tmp;
                                                                    clocktime = setTimeout("time()", "1000", "Javascript");

                                                                    function checkTime(i) {
                                                                        if (i < 10) {
                                                                            i = "0" + i;
                                                                        }
                                                                        return i;
                                                                    }
                                                                }
                </script>
                <script>
                    function confirmDelete(eventid) {
                        swal({
                            title: "Cảnh báo",
                            text: "Bạn có chắc chắn là muốn xóa sản phẩm này?",
                            buttons: ["Hủy bỏ", "Đồng ý"],
                        }).then((willDelete) => {
                            if (willDelete) {
                                // Call the server-side delete function using AJAX
                                deleteEvent(eventid);
                            }
                        });
                    }

                    function deleteEvent(eventid) {
                        // Use AJAX to call the server-side delete function
                        $.ajax({
                            type: "get",
                            url: "DeleteEventControl", // Specify the URL of your server-side delete control
                            data: {eid: eventid},
                            success: function (response) {
                                // Handle success, for example, you can reload the page
                                location.reload();
                            },
                            error: function (error) {
                                console.error("Error deleting event: " + error);
                            }
                        });
                    }
                </script>
                <script>
                    function editProduct(productId) {
                        // Redirect to the UpdateProductControl page with the product ID as a parameter
                        window.location.href = "UpdateProductControl?id=" + productId;
                    }
                </script>
                </body>
                </html>
