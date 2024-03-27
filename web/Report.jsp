<%-- 
    Document   : Report
    Created on : Mar 12, 2024, 9:13:39 AM
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
                                        <h3 class="mb-4">Fill Reason Report Shop For Us</h3>
                                        
                                        <form action="reasonReport" method="POST" enctype="multipart/form-data" class="contactForm">
                                            <div class="row">

                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Reason Report</label>
                                                        <select name="reason" class="form-control">
                                                            <c:forEach items="${list}" var="a">
                                                                <option value="${a.reasonID}">${a.reason}</option>

                                                            </c:forEach>


                                                        </select>
                                                    </div>
                                                </div>
                                                <input type="text" value="${id}" name="id" hidden>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="#">Description</label>
                                                        <textarea name="descrip" class="form-control" id="message" cols="30" rows="4" placeholder="Description"></textarea>
                                                    </div>
                                                </div>
                                                <div class="file-upload-container" class="form-group col-md-12">
                                                    <input type="file" name="image" id="fileInput" class="file-upload-input" required="required" accept=".png, .jpg, .jpeg"/>
                                                    <label for="fileInput" class="file-upload-label" >Choose an image</label>
                                                    <span id="selectedFileName" class="selected-file-label">No file chosen</span>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <input type="submit" value="Send Report" class="btn btn-primary">
                                                        <div class="submitting"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
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
