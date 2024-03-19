<%-- 
    Document   : ManagerReport
    Created on : Mar 12, 2024, 2:48:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Quản Lý Sản Phẩm</title>
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

        <main class="app-content1">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="statistic"><b>Home</b></a></li>
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách Report</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">
                                <a href="getListReportByStatus?status=0">ĐANG CHỜ XÁC MINH</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                <a href="getListReportByStatus?status=1">ĐANG CHỜ SHOP PHẢN HỒI</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                <a href="getListReportByStatus?status=2">BÁO CÁO ĐƯỢC CHẤP NHẬN</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                <a href="getListReportByStatus?status=3">BÁO CÁO BỊ BÁC BỎ</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                <a href="getListReportByStatus?status=4">ĐANG CHỜ XEM XÉT PHẢN HỒI TỪ SHOP</a>
                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>

                                        <th>Report ID</th>
                                        <th>Reason Report</th>
                                        <th>Description</th>
                                        <th>Image</th>
                                        <th>Appeal</th>
                                        <th>Image Of Shop</th>
                                        <th>Date Report</th>
                                        <th>Status</th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="l">
                                        <tr>

                                            <td>${l.reportID}</td>
                                            <c:forEach items="${listReason}" var="r">
                                                <c:if test="${l.reasonID==r.reasonID}">
                                                    <td>${r.reason}</td>
                                                </c:if>
                                            </c:forEach>
                                            <td>${l.description}</td>
                                            <td><img src="${l.image1}" style="width:100px;"></td>
                                            <td>${l.appeal}</td>
                                            <td><img src="${l.image2}" style="width:100px;"></td>

                                            <td>${l.ngayReport}</td>
                                            <td>
                                                <c:if test="${l.status==0}">
                                                    ĐANG CHỜ XÁC MINH
                                                </c:if>
                                                <c:if test="${l.status==1}">
                                                    ĐANG CHỜ SHOP PHẢN HỒI
                                                </c:if>
                                                <c:if test="${l.status==2}">
                                                    BÁO CÁO ĐƯỢC CHẤP NHẬN
                                                </c:if>
                                                <c:if test="${l.status==3}">
                                                    BÁO CÁO BỊ BÁC BỎ
                                                </c:if>
                                                <c:if test="${l.status==4}">
                                                    ĐANG CHỜ XEM XÉT PHẢN HỒI TỪ SHOP
                                                </c:if>


                                            </td>
                                            <td>
                                                <c:if test="${l.status==0}">
                                                    <form action="changeReport" method="post">
                                                        <input type="text" name="id" value="${l.reportID}" hidden>

                                                        <button class="btn btn-primary btn-sm edit" type="submit" title="Sửa" data-toggle="modal" data-target="#ModalUP">
                                                            <i class="fas fa-edit"></i> Delete
                                                        </button>
                                                    </form>
                                                    <form action="changeReport">
                                                        <input type="text" name="status" value="1" hidden>   
                                                        <input type="text" name="id" value="${l.reportID}" hidden>
                                                        <button class="btn btn-primary btn-sm edit" type="submit" title="Sửa" data-toggle="modal" data-target="#ModalUP">
                                                            <i class="fas fa-edit"></i> Send to shop
                                                        </button>
                                                    </form>

                                                </c:if>
                                                <c:if test="${l.status==4}">
                                                    <form action="changeReport">
                                                        <input type="text" name="shopID" value="${l.shopID}" hidden>
                                                        <input type="text" name="status" value="2" hidden>
                                                        <input type="text" name="id" value="${l.reportID}" hidden>
                                                        <button class="btn btn-primary btn-sm edit" type="submit" title="Sửa" data-toggle="modal" data-target="#ModalUP">
                                                            <i class="fas fa-edit"></i> Accept
                                                        </button>
                                                    </form>
                                                    <form action="changeReport">

                                                        <input type="text" name="status" value="3" hidden>
                                                        <input type="text" name="id" value="${l.reportID}" hidden>
                                                        <button class="btn btn-primary btn-sm edit" type="submit" title="Sửa" data-toggle="modal" data-target="#ModalUP">
                                                            <i class="fas fa-edit"></i> Deny
                                                        </button>
                                                    </form>

                                                </c:if>
                                                <c:if test="${l.status==1}">
                                                    <form action="changeReport">
                                                        <input type="text" name="shopID" value="${l.shopID}" hidden>
                                                        <input type="text" name="status" value="2" hidden>
                                                        <input type="text" name="id" value="${l.reportID}" hidden>
                                                        <button class="btn btn-primary btn-sm edit" type="submit" title="Sửa" data-toggle="modal" data-target="#ModalUP">
                                                            <i class="fas fa-edit"></i> Accept
                                                        </button>
                                                    </form>
                                                </c:if>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <c:if test="${tag!=null}">
                                <div class="col-lg-12 text-center">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination pagination-circle justify-content-center float-md-right mb-0">
                                            <c:if test="${tag != 1}">
                                                <li class="page-item"><a href="QuanLySanPhamControl?index=${tag-1 }" class="page-link">Trước</a></li>
                                                </c:if> 
                                                <c:forEach begin="1" end="${endPage }" var="i">
                                                <li class="${tag==i?"page-item active":"page-item" }"><a href="QuanLySanPhamControl?index=${i }" class="page-link">${i }</a></li>
                                                </c:forEach>
                                                <c:if test="${tag != endPage}">
                                                <li class="page-item"><a href="QuanLySanPhamControl?index=${tag+1 }" class="page-link">Sau</a></li>
                                                </c:if> 
                                        </ul>
                                    </nav>
                                </div>
                            </c:if>
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
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

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
            function confirmDelete(productId) {
                swal({
                    title: "Cảnh báo",
                    text: "Bạn có chắc chắn là muốn xóa sản phẩm này?",
                    buttons: ["Hủy bỏ", "Đồng ý"],
                }).then((willDelete) => {
                    if (willDelete) {
                        // Call the server-side delete function using AJAX
                        deleteProduct(productId);
                    }
                });
            }

            function deleteProduct(productId) {
                // Use AJAX to call the server-side delete function
                $.ajax({
                    type: "POST",
                    url: "DeleteControl", // Specify the URL of your server-side delete control
                    data: {id: productId},
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
            function editProduct(productId) {
                // Redirect to the UpdateProductControl page with the product ID as a parameter
                window.location.href = "UpdateProductControl?id=" + productId;
            }
        </script>
    </body>

</html>

