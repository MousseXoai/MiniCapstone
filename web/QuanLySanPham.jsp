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
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <div>
                    <p class="app-sidebar__user-name"><b>Manage Your Product</b></p>
                    <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
                </div>
            </div>
            <hr>
            <!--            <ul class="app-menu">
            -->                <div class="col-sm-2">

                <a class="btn btn-add btn-sm" href="addproduct" title="Thêm"><i class="fas fa-plus"></i>
                    Tạo mới sản phẩm</a>
            </div><!--
            <div class="col-sm-2">
                <a class="btn btn-delete btn-sm nhap-tu-file" type="button" title="Nhập" onclick="myFunction(this)"><i
                        class="fas fa-file-upload"></i> Tải từ file</a>
            </div>
            <div class="col-sm-2">
                <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                        class="fas fa-print"></i> In dữ liệu</a>
            </div>
            <div class="col-sm-2">
                <a class="btn btn-delete btn-sm print-file js-textareacopybtn" type="button" title="Sao chép"><i
                        class="fas fa-copy"></i> Sao chép</a>
            </div>

            <div class="col-sm-2">
                <a class="btn btn-excel btn-sm" href="" title="In"><i class="fas fa-file-excel"></i> Xuất Excel</a>
            </div>
            <div class="col-sm-2">
                <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)"><i
                        class="fas fa-file-pdf"></i> Xuất PDF</a>
            </div>
            <div class="col-sm-2">
                <a class="btn btn-delete btn-sm" type="button" title="Xóa" onclick="myFunction(this)"><i
                        class="fas fa-trash-alt"></i> Xóa tất cả </a>
            </div>
        </ul>-->
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách sản phẩm</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">
                                <div class="col-md-7"></div> <!-- Empty column to create space on the left -->
                                <form action="SearchControl" method="get" class="col-md-5 text-right">
                                    <div class="input-group">
                                        <div class="input-group-append" style="margin-right: 10px;padding: 5px;">
                                            <button class="btn btn-primary" type="submit">Tìm Kiếm</button>
                                        </div>
                                        <input style="width: 200px" type="text" class="form-control" id="searchInput" name="searchTerm" placeholder="Tìm kiếm">

                                    </div>
                                </form>




                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th width="10"><input type="checkbox" id="all"></th>
                                        <th>Mã sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Ảnh</th>
                                        <th>Số lượng</th>
                                        <th>Tình trạng</th>
                                        <th>Giá tiền</th>
                                        <th>Danh mục</th>
                                        <th>Thương hiệu</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${getProduct}" var="p">
                                        <tr>
                                            <td width="10"><input type="checkbox" name="check1" value="1"></td>
                                            <td>${p.id}</td>
                                            <td>${p.name}</td>
                                            <td><img src="${p.image}" style="width:100px;"></td>
                                            <td>${p.quantity}</td>
                                            <td>
                                                <span class="badge ${p.quantity > 0 ? 'bg-success' : 'bg-danger'}">
                                                    ${p.quantity > 0 ? 'Còn hàng' : 'Hết hàng'}
                                                </span>
                                            </td>
                                            <td><fmt:formatNumber type="currency" value="${p.price}" /></td>
                                            <td>
                                                <c:forEach items="${getCategory}" var="c">
                                                    <c:if test="${p.cateID eq c.cid }">
                                                        ${c.cname}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td>
                                                <c:forEach items="${getBrand}" var="b">
                                                    <c:if test="${p.branID eq b.bid }">
                                                        ${b.bname}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td>
                                                <button class="btn btn-primary btn-sm trash" type="button" title="Xóa" onclick="confirmDelete(${p.id})">
                                                    <i class="fas fa-trash-alt"></i> Xóa
                                                    <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" data-toggle="modal" data-target="#ModalUP" onclick="editProduct(${p.id})">
                                                        <i class="fas fa-edit"></i> Chỉnh sửa
                                                    </button>

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