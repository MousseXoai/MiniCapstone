<%-- 
    Document   : ReplyContact
    Created on : Jan 28, 2024, 10:09:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <form action="replyContact" method="post">
        
            <div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
                 data-keyboard="false">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        

                        <div class="modal-body">
                            <div class="row">
                                <div class="form-group  col-md-12">
                                    <span class="thong-tin-thanh-toan">
                                        <h5>Chi tiết thông tin Contact</h5>
                                    </span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="control-label">Mã contact</label>
                                    <input class="form-control" type="number" name ="id" value="${c.contactID}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="control-label">User Name</label>
                                    <input class="form-control" type="text" name="name" required value="${c.name}" readonly>
                                </div>
                                <div class="form-group  col-md-6">
                                    <label class="control-label">Email</label>
                                    <input class="form-control" type="text" name="email" required value="${c.email}" readonly>
                                </div>
                                <div class="form-group  col-md-6">
                                    <label class="control-label">Subject</label>
                                    <input class="form-control" type="text" name="subject" required value="${c.subject}" readonly>
                                </div>
                                <div class="form-group  col-md-6">
                                    <label class="control-label">Message</label>
                                    <input class="form-control" type="text" name="content" required value="${c.content}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="control-label">Reply</label>
                                    <textarea class="form-control" rows="5" name="reply" required ></textarea>
                                </div>   
                                
                            <BR>

                            <BR>
                            <BR>
                            <button class="btn btn-save" type="submit">Trả lời</button>
                            <a class="btn btn-cancel" data-dismiss="modal" href="managerContact">Thoát</a>
                            <BR>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>
            </div>
        
        </form>
    </body>
</html>
