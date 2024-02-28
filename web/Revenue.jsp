<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <title>Báo cáo kinh doanh</title>
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

        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    </aside>
    <form action="revenueByDay" method="post" onsubmit="return validateDates();">
        <main class="app-content1">
<!--            <div class="row">
                <div class="col-md-12">
                    <a href="statistic" class="btn btn-secondary">Back</a>
                </div>
            </div>-->
            <div class="row">
                <div class="col-md-12">
                    <div class="app-title">
                        <ul class="app-breadcrumb breadcrumb">
                            <li class="breadcrumb-item"><a href="statistic"><b>Home</b></a></li> 
                            <li class="breadcrumb-item"><a href=""><b>Báo cáo doanh thu  </b></a></li> 
                        </ul>

                        <div id="clock"></div>
                        <ul class="app-breadcrumb breadcrumb">
                            <input type="submit" value ="Áp dụng">
                            Từ  <input type="date" id="date1" name ="date1" value="${date1}"> Đến  <input type="date" id="date2" name="date2" value="${date2}"> 
                        </ul>

                    </div>
                </div>
            </div>
            <div class="row">
                <!--            <div class="col-md-6 col-lg-3">
                                <div class="widget-small primary coloured-icon"><i class='icon  bx bxs-user fa-3x'></i>
                                    <div class="info">
                                        <h4>Tổng Nhân viên</h4>
                                        <p><b>26 nhân viên</b></p>
                                    </div>
                                </div>
                            </div>-->
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small info coloured-icon"><i class='icon bx bxs-purchase-tag-alt fa-3x' ></i>
                        <div class="info">
                            <h4>Tổng sản phẩm</h4>
                            <p><b>${countTotalProduct} sản phẩm</b></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-shopping-bag-alt'></i>
                        <div class="info">
                            <h4>Tổng đơn hàng</h4>
                            <p><b>${countNumOfInvoice} đơn hàng</b></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small danger coloured-icon"><i class='icon fa-3x bx bxs-info-circle' ></i>
                        <div class="info">
                            <h4>Tổng phản hồi</h4>
                            <p><b>${numOfCmt} phản hồi</b></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small primary coloured-icon"><i class='icon fa-3x bx bxs-chart' ></i>
                        <div class="info">
                            <h4>Tổng thu nhập</h4>
                            <p><b><fmt:formatNumber type="currency" value="${revenue}" /></b></p>
                        </div>
                    </div>
                </div>
                <!--            <div class="col-md-6 col-lg-3">
                                <div class="widget-small info coloured-icon"><i class='icon fa-3x bx bxs-user-badge' ></i>
                                    <div class="info">
                                        <h4>Nhân viên mới</h4>
                                        <p><b>3 nhân viên</b></p>
                                    </div>
                                </div>
                            </div>-->
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-tag-x' ></i>
                        <div class="info">
                            <h4>Hết hàng</h4>
                            <p><b>${countNumOfOutProduct} sản phẩm</b></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small danger coloured-icon"><i class='icon fa-3x bx bxs-receipt' ></i>
                        <div class="info">
                            <h4>Đơn hàng hoàn trả</h4>
                            <p><b>${countNumOfRefundInvoice} đơn hàng</b></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div>
                            <h3 class="tile-title">SẢN PHẨM ĐẠT DOANH THU CAO</h3>
                        </div>
                        <div class="tile-body">
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>Mã sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Danh mục</th>
                                        <th>Doanh Thu</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${top5SPBanChay}" var="top">
                                        <tr>
                                            <td>${top.id}</td>
                                            <td>${top.name}</td>
                                            <td><c:forEach items="${getCategory}" var="c">
                                                    <c:if test="${top.cateID eq c.cid }">
                                                        ${c.cname}
                                                    </c:if>
                                                </c:forEach></td>
                                            <td><fmt:formatNumber type="currency" value="${top.totalRevenue}" /></td>
                                            
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div>
                            <h3 class="tile-title">SẢN PHẨM ĐÃ HẾT</h3>
                        </div>
                        <div class="tile-body">
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>Mã sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Ảnh</th>
                                        <th>Số lượng</th>
                                        <th>Tình trạng</th>
                                        <th>Giá tiền</th>
                                        <th>Danh mục</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${getOutOfProduct}" var="out">
                                        <tr>
                                            <td>${out.id}</td>
                                            <td>${out.name}</td>
                                            <td><img src="${out.image}" alt="" width="100px;"></td>
                                            <td>${out.quantity}</td>
                                            <td><span class="badge bg-danger">Hết hàng</span></td>
                                            <td><fmt:formatNumber type="currency" value="${out.price}" /></td>
                                            <td>
                                                <c:forEach items="${getCategory}" var="c">
                                                    <c:if test="${out.cateID eq c.cid }">
                                                        ${c.cname}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </form>
    <!--        <div class="row">
                <div class="col-md-6">
                    <div class="tile">
                        <h3 class="tile-title">DỮ LIỆU HÀNG THÁNG</h3>
                        <div class="embed-responsive embed-responsive-16by9">
                            <canvas class="embed-responsive-item" id="lineChartDemo"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="tile">
                        <h3 class="tile-title">THỐNG KÊ DOANH SỐ</h3>
                        <div class="embed-responsive embed-responsive-16by9">
                            <canvas class="embed-responsive-item" id="barChartDemo"></canvas>
                        </div>
                    </div>
                </div>
            </div>-->

    <div class="text-right" style="font-size: 12px">
        <p><b>Hệ thống quản lý | Code by MQuan</b></p>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="js/plugins/chart.js"></script>
<script type="text/javascript">
    var data = {
        labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
        datasets: [{
                label: "Dữ liệu đầu tiên",
                fillColor: "rgba(255, 255, 255, 0.158)",
                strokeColor: "black",
                pointColor: "rgb(220, 64, 59)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "green",
                data: [20, 59, 90, 51, 56, 100, 40, 60, 78, 53, 33, 81]
            },
            {
                label: "Dữ liệu kế tiếp",
                fillColor: "rgba(255, 255, 255, 0.158)",
                strokeColor: "rgb(220, 64, 59)",
                pointColor: "black",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "green",
                data: [48, 48, 49, 39, 86, 10, 50, 70, 60, 70, 75, 90]
            }
        ]
    };


    var ctxl = $("#lineChartDemo").get(0).getContext("2d");
    var lineChart = new Chart(ctxl).Line(data);

    var ctxb = $("#barChartDemo").get(0).getContext("2d");
    var barChart = new Chart(ctxb).Bar(data);
</script>
<!-- Google analytics script-->
<script type="text/javascript">
    if (document.location.hostname == 'pratikborsadiya.in') {
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                    m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-72504830-1', 'auto');
        ga('send', 'pageview');
    }
</script>
<script>
    function validateDates() {
        var date1 = new Date(document.getElementById("date1").value);
        var date2 = new Date(document.getElementById("date2").value);

        if (date1 > date2) {
            alert("Ngày bắt đầu phải nhỏ hơn hoặc bằng ngày kết thúc.");
            return false; // Ngăn chặn gửi biểu mẫu nếu có lỗi
        }
        return true; // Cho phép gửi biểu mẫu nếu không có lỗi
    }
</script>
</body>

</html>