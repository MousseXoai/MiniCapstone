<%-- 
    Document   : UpdateProduct
    Created on : Jan 16, 2024, 2:46:56 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
            }

            /* Style the modal */
            .modal {
                background-color: #fff;
                border-radius: 8px;
            }

            /* Style the modal content */
            .modal-content {
                border: none;
            }

            /* Style the modal header */
            .modal-header {
                background-color: #007bff;
                color: #fff;
                padding: 15px;
                border-bottom: none;
            }

            /* Style the modal body */
            .modal-body {
                padding: 20px;
            }

            /* Style the form labels */
            .control-label {
                font-weight: bold;
            }

            /* Style the form inputs and selects */
            .form-control {
                width: 100%;
                padding: 8px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            /* Style the save and cancel buttons */
            .btn-save {
                background-color: #28a745;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }

            .btn-cancel {
                background-color: #ea0000;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }

            /* Style the link for advanced editing */
            a {
                text-decoration: none;
                color: #007bff;
            }

            a:hover {
                text-decoration: underline;
                color: #0056b3;
            }
        </style>
        
    </head>
    
    <body>
        <form action="SaveUpdateProductControl" method="post">
        <fmt:setLocale value="vi_VN" />
            <fmt:setBundle basename="path.to.your.resource.bundle" />
        <c:forEach items="${getProductByPID}" var="p">
            <div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
                 data-keyboard="false">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        

                        <div class="modal-body">
                            <div class="row">
                                <div class="form-group  col-md-12">
                                    <span class="thong-tin-thanh-toan">
                                        <h5>Chỉnh sửa thông tin sản phẩm</h5>
                                    </span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="control-label">Mã sản phẩm </label>
                                    <input class="form-control" type="number" name ="pid" value="${p.id}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="control-label">Tên sản phẩm</label>
                                    <input class="form-control" type="text" name="pname" required value="${p.name}">
                                </div>
                                <div class="form-group  col-md-6">
                                    <label class="control-label">Giá bán</label>
                                    <input class="form-control" type="text" name="pprice" required value="${p.price}">
                                </div>
                                <div class="form-group  col-md-6">
                                    <label class="control-label">Số lượng</label>
                                    <input class="form-control" type="number" name="pquantity" required value="${p.quantity}">
                                </div>
                                <div class="form-group  col-md-6">
                                    <label class="control-label">Tiêu đề</label>
                                    <input class="form-control" type="text" name="ptitle" required value="${p.title}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="control-label">Mô tả sản phẩm</label>
                                    <textarea class="form-control" rows="5" name="pdescription" required value="${p.description}">${p.description}</textarea>
                                </div>   
                                <div class="form-group col-md-6">
                                    <label for="exampleSelect1" class="control-label">Loại sản phẩm</label>
                                    <select class="form-control" name="category" id="exampleSelect1">
                                        <c:forEach items="${getCategory}" var="c">
                                        <option value="${c.cid}">${c.cname}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="exampleSelect1" class="control-label">Thương hiệu</label>
                                    <select class="form-control" name="brand" id="exampleSelect1">
                                        <c:forEach items="${getBrand}" var="b">
                                        <option value="${b.bid}">${b.bname}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group  col-md-6">
                                    <label class="control-label">Màu sắc</label>
                                    <input class="form-control" type="text" name="pcolor" required value="${p.color}">
                                </div>
                            </div>
                            <BR>

                            <BR>
                            <BR>
                            <button class="btn btn-save" type="submit">Lưu lại</button>
                            <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                            <a class="btn btn-cancel" data-dismiss="modal" href="QuanLySanPhamControl">Thoát</a>
                            <BR>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </form>
    </body>
</html>
