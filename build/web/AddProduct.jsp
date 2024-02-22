<%-- 
    Document   : AddProduct
    Created on : Jan 28, 2024, 2:29:10 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>EduBook add-product</title>

        <link href="css/bootstrap.min_2.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/bootstrap-table.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <!--Icons-->
        <script src="js/lumino.glyphs.js"></script>

        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
<!--        <style>
            /* Global Styles */

            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            /* Header Styles */

            ol.breadcrumb {
                background-color: #fff;
                padding: 10px;
                border-radius: 4px;
                margin: 15px 0;
            }

            .page-header {
                color: #333;
            }

            /* Form Styles */

            .panel-default {
                border: none;
            }

            .panel-body {
                padding: 20px;
            }

            .form-group {
                margin-bottom: 20px;
            }

            .form-control {
                width: 100%;
                padding: 10px;
                box-sizing: border-box;
            }

            .checkbox label {
                font-weight: normal;
                color: #333;
            }

            /* Image Styles */

            .img-preview {
                filter: drop-shadow(0 0 5px rgb(119, 119, 145));
                width: 80px;
            }

            /* Button Styles */

            .btn {
                margin-top: 10px;
            }

            .btn-success {
                background-color: #5cb85c;
                border: none;
            }

            .btn-default {
                background-color: #ccc;
                border: none;
                margin-left: 10px;
            }

            /* Main Content Styles */

            .main {
                padding: 20px;
            }

            .row {
                margin-bottom: 20px;
            }

            /* Responsive Styles */

            @media (max-width: 767px) {
                .breadcrumb {
                    margin-bottom: 0;
                }

                .main {
                    padding-top: 60px;
                }
            }

        </style>-->
    </head>

    <body>




        <div class="container-fluid">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="statistic"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li><a href="QuanLySanPhamControl">Quản lý sản phẩm</a></li>
                    <li class="active">Thêm sản phẩm</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-xs-12">
                    <h1 class="page-header">Thêm sản phẩm</h1>
                </div>
            </div><!--/.row-->
            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-6">
                                <form action="addproduct" method="post" enctype="multipart/form-data">
                                    
                                        <div class="form-group">
                                            <label>Tên sản phẩm</label>
                                            <input required name="prd_name" class="form-control" placeholder="">
                                        </div>

                                        <div class="form-group">
                                            <label>Giá sản phẩm</label>
                                            <input required name="prd_price" type="number" min="0" class="form-control">
                                        </div>
                                        <div class="form-group">
                                                <label>Mô tả sản phẩm</label>
                                                <textarea required name="prd_details" class="form-control" rows="3"></textarea>
                                            </div>
                                        <div class="form-group">
                                            <label>Số lượng</label>
                                            <input required name="prd_quantity" type="number" min="0" class="form-control">
                                        </div> 
                                        <div class="form-group">
                                            <label>Tiêu đề</label>
                                            <input required name="prd_title"  class="form-control">
                                        </div> 
                                         '

                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Ảnh sản phẩm</label>

                                                <input required name="prd_image1" type="file">
                                                <input required name="prd_image2" type="file">
                                                <input required name="prd_image3" type="file">
                                                <input required name="prd_image4" type="file">
                                                
                                            </div>
                                            <div class="form-group">
                                            <label>Màu sắc</label>
                                            <input required name="prd_color" class="form-control">
                                        </div>
                                            <div class="form-group">
                                                <label>Danh mục</label>
                                                <select name="cat_id" class="form-control">
                                                    <c:forEach items="${getCategory}" var="c">
                                                        
                                                            <option value="${c.cid}">${c.cname}</option>
                                                        
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Thương hiệu</label>
                                                <select name="bid" class="form-control">
                                                    <c:forEach items="${getBrand}" var="b">
                                                        
                                                            <option value="${b.bid}">${b.bname}</option>
                                                        
                                                    </c:forEach>
                                                </select>
                                            </div>

<!--                                            <div class="form-group">
                                                <label>Sản phẩm khuyến mãi</label>
                                                <div class="checkbox">
                                                    <label>
                                                        <input name="prd_sale" type="checkbox" value=1>Khuyến mãi
                                                    </label>
                                                </div>
                                            </div>-->
                                            
                                   
                                    <button name="sbm" type="submit" class="btn btn-success">Thêm mới</button>
                                    <button type="reset" class="btn btn-default">Làm mới</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div><!-- /.col-->
            </div><!-- /.row -->

        </div>	<!--/.main-->	
    </body>

</html>

