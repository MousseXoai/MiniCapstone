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
        <title>Quản Lý Thuế</title>
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
            .app1{
                min-height: calc(100vh - 50px);
                padding: 10px;

                background-color: #f5f5f5;
                -webkit-transition: margin-left 0.3s ease;
                -o-transition: margin-left 0.3s ease;
                transition: margin-left 0.3s ease;
            }
        </style>
    </head>

    <body onload="time()" class="app1 sidebar-mini rtl">
        <fmt:setLocale value="vi_VN" />
        <fmt:setBundle basename="path.to.your.resource.bundle" />


        <c:if test="${sessionScope.acc != null}">
            <div style="text-align: right; margin-right: 20px;">
                <a style="font-size: 15px; color: red;" href="logout"><i class="fas fa-sign-out-alt"></i> Đăng Xuất</a>
            </div>
        </c:if>

        <main class="app-content1">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Bill Thuế Các Shop</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">

                                <div class="col-md-7">
                                    <div class="col-sm-2">

                                        <a class="btn btn-add btn-sm" href="settax" title="Thêm"><i class="fas fa-plus"></i>
                                            Send Fee To All Shop</a>
                                    </div>
                                </div> <!-- Empty column to create space on the left -->





                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <!--                                        <th width="10"><input type="checkbox" id="all"></th>-->
                                        <th>Fee ID</th>
                                        <th>Shop ID</th>
                                        <th>Fee Money</th>
                                        <th>Date</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                        <th>Change Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${taxList}" var="t">
                                        <tr>
                                            <!--                                            <td width="10"><input type="checkbox" name="check1" value="1"></td>-->
                                            <td>${t.maShopHD}</td>
                                            <td>${t.shopID}</td>
                                            <td>${t.amount} đ</td>
                                            <td>${t.ngayXuat}</td>
                                            <td>
                                                <span class="badge ${t.status > 0 ? 'bg-success' : 'bg-danger'}">
                                                    ${t.status == 0 ? 'Chưa thanh toán' : 'Đã thanh toán'}
                                                </span>
                                            </td>
                                            <td>
                                                <button class="btn btn-primary btn-sm trash" type="button" title="Xóa" onclick="confirmDelete(${t.maShopHD})">
                                                    <i class="fas fa-trash-alt"></i> Xóa
    <!--                                                    <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" data-toggle="modal" data-target="#ModalUP" onclick="editProduct(${t.maShopHD})">
                                                        <i class="fas fa-edit"></i> Chỉnh sửa
                                                    </button>-->
                                            </td>
                                            <td>
                                                <select name="status" class="form-control" onchange="changeStatus(${t.status}, ${t.maShopHD})">
                                                    <option value="0" ${t.status == 0 ? 'selected' : ''}>Chưa Thanh Toán</option>
                                                    <option value="1" ${t.status == 1 ? 'selected' : ''}>Đã Thanh Toán</option>
                                                </select>
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
        <!--        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
                <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>-->
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
            function confirmDelete(maShopHD) {
                swal({
                    title: "Cảnh báo",
                    text: "Bạn có chắc chắn là muốn xóa bill thuế này?",
                    buttons: ["Hủy bỏ", "Đồng ý"],
                }).then((willDelete) => {
                    if (willDelete) {
                        // Call the server-side delete function using AJAX
                        deleteProduct(maShopHD);
                    }
                });
            }

            function deleteProduct(maShopHD) {
                // Use AJAX to call the server-side delete function
                $.ajax({
                    type: "POST",
                    url: "deletebill", // Specify the URL of your server-side delete control
                    data: {id: maShopHD},
                    success: function (response) {
                        // Handle success, for example, you can reload the page
                        location.reload();
                    },
                    error: function (error) {
                        console.error("Error deleting product: " + error);
                    }
                });
            }
        </script>
        <script>
            function editProduct(maShopHD) {
                // Redirect to the UpdateProductControl page with the product ID as a parameter
                window.location.href = "UpdateProductControl?id=" + maShopHD;
            }
        </script>
        <script>
            function changeStatus(status, maShopHD) {
                $.ajax({
                    type: "POST",
                    url: "changeStatus", // Thay đổi đường dẫn tương ứng với API của bạn
                    data: {id: maShopHD, status: status},
                    success: function (response) {
                        location.reload();
                    },
                    error: function (error) {
                        console.error("Lỗi khi cập nhật trạng thái: " + error);
                    }
                });
            }

        </script>
    </body>

</html>