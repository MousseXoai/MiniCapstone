<%-- 
    Document   : FeedBack
    Created on : Feb 23, 2024, 2:08:22 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Contact Form 09</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="feedbackform/css/style.css">

    </head>
    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-10 col-md-12">
                        <div class="wrapper">
                            <div class="row justify-content-center">
                                <div class="col-lg-8 mb-5">
                                </div>
                                <div class="col-lg-8">
                                    <div class="contact-wrap">
                                        <h3 class="mb-4 text-center">Feed Back</h3>
                                        <div id="form-message-warning" class="mb-4 w-100 text-center"></div> 
                                        <div id="form-message-success" class="mb-4 w-100 text-center">
                                            Your message was sent, thank you!
                                        </div>
                                        <form action="feedBack" method="post" id="contactForm" name="contactForm" class="contactForm">
                                            <c:if test="${not empty errorMessage}">
                                                <div style="color: red;">${errorMessage}</div>
                                            </c:if>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" name="rate" id="subject" required placeholder="Vote (1* --> 5*)">
                                                    </div>
                                                </div>
                                                <input type="hidden" name="pid" value="${pid}">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <textarea name="message" class="form-control" id="message" cols="30" rows="8" required placeholder="Message"></textarea>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <input type="submit" value="Submit" class="btn btn-primary">
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

        <script src="feedbackform/js/jquery.min.js"></script>
        <script src="feedbackform/js/popper.js"></script>
        <script src="feedbackform/js/bootstrap.min.js"></script>
        <script src="feedbackform/js/jquery.validate.min.js"></script>
        <script src="feedbackform.js/main.js"></script>

    </body>
</html>


