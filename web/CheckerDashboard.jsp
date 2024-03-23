<%-- 
    Document   : CheckerDashboard
    Created on : Mar 23, 2024, 3:10:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Checker Dashboard</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <link href="assets/css/animate.min.css" rel="stylesheet"/>

        <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

        <link href="assets/css/demo.css" rel="stylesheet" />

        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">

    </head>
    <body>

        <div class="wrapper">
            <jsp:include page="LeftChecker.jsp"></jsp:include>
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
                            <a class="navbar-brand" href="#">Dashboard</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="logout">
                                        
                                        <p>Logout</p>
                                    </a>
                                </li>
                                
                                
                            </ul>

                        </div>
                    </div>
                </nav>


                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            
                        </div>
                    </div>
                </div>


                <footer class="footer">
                    <div class="container-fluid">
                        
                        <div class="copyright pull-right">
                            &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com">MinhQuan</a>
                        </div>
                    </div>
                </footer>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>

        <script>
                                $(document).ready(function () {
                                    // Move this script after Chart.js is loaded
                                    // Graph
                                    // pie
                                    var ctxP = document.getElementById("pieChart").getContext('2d');

                                    var myPieChart = new Chart(ctxP, {
                                        type: 'pie',
                                        data: {
                                            labels: ["Sunday", "Saturday", "Friday", "Thursday", "Wednesday", "Tuesday", "Monday"],
                                            datasets: [{
                                                    data: [${calculateRevenueDay1}, ${calculateRevenueDay7}, ${calculateRevenueDay6}, ${calculateRevenueDay5}, ${calculateRevenueDay4}, ${calculateRevenueDay3}, ${calculateRevenueDay2}],
                                                    backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360", "#1874CD", "#CDB5CD"],
                                                    hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774", "#1E90FF", "#FFE1FF"]
                                                }]
                                        },
                                        options: {
                                            responsive: true
                                        }
                                    });

                                    // Your other scripts...
                                });
        </script>
        <script>
           // Graph
            //Horizontal Bar Chart
            new Chart(document.getElementById("horizontalBar"), {
                "type": "horizontalBar",
                "data": {
                    "labels": ["Tháng 12", "Tháng 11", "Tháng 10", "Tháng 9", "Tháng 8", "Tháng 7", "Tháng 6", "Tháng 5", "Tháng 4", "Tháng 3", "Tháng 2", "Tháng 1"],
                    "datasets": [{
                            "label": "Doanh thu $",
                            "data": [${calculateRevenueMonth12}, ${calculateRevenueMonth11}, ${calculateRevenueMonth10}, ${calculateRevenueMonth9}, ${calculateRevenueMonth8}, ${calculateRevenueMonth7}, ${calculateRevenueMonth6}, ${calculateRevenueMonth5}, ${calculateRevenueMonth4}, ${calculateRevenueMonth3}, ${calculateRevenueMonth2}, ${calculateRevenueMonth1}],
                            "fill": false,
                            "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
                                "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)",
                                "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)", "#99FF99", "#FFFF99", "#FFC1C1", "#FFB5C5", "#DDC488"
                            ],
                            "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
                                "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)", "	#66FF99", "#FFFF66", "#EEB4B4", "#EEA9B8", "#ECAB53"
                            ],
                            "borderWidth": 1
                        }]
                },
                "options": {
                    "scales": {
                        "xAxes": [{
                                "ticks": {
                                    "beginAtZero": true
                                }
                            }]
                    }
                }
            });
        </script>
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

    <script type="text/javascript">
            $(document).ready(function () {

                demo.initChartist();

                $.notify({
                    icon: 'ti-gift',
                    message: "Welcome back to <b>Your Shop</b> . Hope you become a wise businessman."

                }, {
                    type: 'success',
                    timer: 4000
                });

            });
    </script>

</html>
