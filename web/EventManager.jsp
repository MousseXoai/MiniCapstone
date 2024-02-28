<%-- 
    Document   : EventManager
    Created on : Feb 23, 2024, 1:33:56 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
    <title>Event</title>
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



    <main style="margin-left: 0" class="app-content">
        <div class="app-title">
            <ul class="app-breadcrumb breadcrumb side">
                <li class="breadcrumb-item active"><a href="#"><b>Danh sách sự kiện</b></a></li>
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

                                    <th>EventID</th>
                                    <th>Image</th>
                                    <th>Event Name</th>
                                    <th><a href="AddEvent.jsp"><button class="btn btn-primary btn-sm edit" type="button" title="Thêm" data-toggle="modal" data-target="#ModalUP" >
                                            Tạo mới
                                        </button></a></th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${getEvent}" var="e">
                                    <tr>

                                        <td>${e.eid}</td>

                                        <td><img src="${e.image}" alt="" width="50%"></td>
                                        <td>${e.eventName}</td>


                                        <td>
                                            <button class="btn btn-primary btn-sm trash" type="button" title="Xóa" onclick="confirmDelete(${e.eid})">
                                                <i class="fas fa-trash-alt"></i> Xóa
                                            </button>
                                            <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" data-toggle="modal" data-target="#ModalUP" onclick="editEvent(${e.eid})">
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
        function editEvent(eventid) {
            // Redirect to the UpdateProductControl page with the product ID as a parameter
            window.location.href = "UpdateEventControl?eid=" + eventid;
        }
    </script>
</body>
</html>
