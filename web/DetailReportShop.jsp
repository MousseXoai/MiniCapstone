<%-- 
    Document   : DetailReportShop
    Created on : Mar 12, 2024, 1:36:49 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Report Shop</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/style_3.css">
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




            input[type="file"] {
                display: none;
            }

            .file-upload-container {
                position: relative;
                margin-bottom: 20px;
            }

            .file-upload-input {
                opacity: 0;
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                cursor: pointer;
            }

            .file-upload-label {
                display: inline-block;
                padding: 10px 20px;
                background-color: #3498db;
                color: #fff;
                cursor: pointer;
                border-radius: 4px;
                transition: background-color 0.3s;
            }

            .file-upload-label:hover {
                background-color: #2980b9;
            }

            .selected-file-label {
                margin-top: 10px;
                color: #333;
            }

            input[type="submit"] {
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #2ecc71;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            input[type="submit"]:hover {
                background-color: #27ae60;
            }
        </style>

    </head>
    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h1 class="heading-section">Report Shop</h1>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-lg-10">
                        <div class="wrapper img" style="background-image: url(images/img.jpg);">
                            <div class="row">
                                <div class="col-md-9 col-lg-7">
                                    <div class="contact-wrap w-100 p-md-5 p-4">
                                        <h3 class="mb-4">Reason Report Shop</h3>

                                        <form action="changeStatusReport" method="post" enctype="multipart/form-data" class="contactForm">
                                            <div class="row">

                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Reason Report</label>
                                                        <c:forEach items="${list}" var="a">
                                                            <c:if test="${a.reasonID==report.reasonID}">
                                                                <input type="text" class="form-control" name="reason" value="${a.reason}">
                                                            </c:if>
                                                        </c:forEach>
                                                    </div>
                                                </div>

                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="#">Description</label>
                                                        <input name="descrip" value="${report.description}" class="form-control" placeholder="Description" >
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="#">Image</label>
                                                        <img style="width: 425px" src="${report.image1}">
                                                    </div>
                                                </div>
                                                    <input type="text" name="id" value="${report.reportID}" hidden> 
                                                <c:if test="${report.status==1}">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label class="label" for="#">Refute</label>
                                                            <textarea name="refute" class="form-control" id="message" cols="30" rows="4" placeholder="Refute" ></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="file-upload-container" class="form-group col-md-12">
                                                        <input type="file" name="image" id="fileInput" class="file-upload-input" required="required" accept=".png, .jpg, .jpeg"/>
                                                        <label for="fileInput" class="file-upload-label" >Choose an image</label>
                                                        <span id="selectedFileName" class="selected-file-label">No file chosen</span>
                                                    </div>
                                                </c:if>
                                                    <c:if test="${report.status==4}">
                                                        <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label class="label" for="#">Refute</label>
                                                            <input name="refute" class="form-control" id="message" value="${report.appeal}" >
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="#">Image2</label>
                                                        <img style="width: 425px" src="${report.image2}">
                                                    </div>
                                                </div>
                                                    </c:if>
                                                        


                                                <c:if test="${report.status==1}">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="submit" value="Send Refute" class="btn btn-primary">
                                                            <div class="submitting"></div>
                                                        </div>
                                                    </div>

                                                </c:if>
                                                <c:if test="${report.status==2}">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="button" value="BÁO CÁO ĐÃ ĐƯỢC CHẤP NHẬN" class="btn btn-primary">
                                                            <div class="submitting"></div>
                                                        </div>
                                                    </div>

                                                </c:if>
                                                <c:if test="${report.status==3}">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="button" value="BÁO CÁO ĐÃ BỊ BÁC BỎ" class="btn btn-primary">
                                                            <div class="submitting"></div>
                                                        </div>
                                                    </div>

                                                </c:if>
                                                <c:if test="${report.status==4}">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="button" value="BÁO CÁO ĐANG CHỜ ADMIN XEM XÉT" class="btn btn-primary">
                                                            <div class="submitting"></div>
                                                        </div>
                                                    </div>

                                                </c:if>


                                            </div>
                                        </form>
                                        <c:if test="${report.status==1}">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <form action="changeStatusReport">
                                                        <input type="text" name="id" value="${report.reportID}" hidden> 
                                                        <input type="submit" value="Accept Report" class="btn btn-primary">
                                                        <div class="submitting"></div>
                                                    </form>

                                                </div>
                                            </div>
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.min_1.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min_3.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/main_2.js"></script>
        <script>
            document.getElementById('fileInput').addEventListener('change', function () {
                var fileName = this.value.split('\\').pop();
                document.getElementById('selectedFileName').innerText = fileName;
            });
        </script>

    </body>
</html>
