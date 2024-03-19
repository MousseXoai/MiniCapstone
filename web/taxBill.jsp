<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>Tax Bill</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            .receipt-content .logo a:hover {
                text-decoration: none;
                color: #7793C4;
            }

            .receipt-content .invoice-wrapper {
                background: #FFF;
                border: 1px solid #CDD3E2;
                box-shadow: 0px 0px 1px #CCC;
                padding: 40px 40px 60px;
                margin-top: 40px;
                border-radius: 4px;
            }

            .receipt-content .invoice-wrapper .payment-details span {
                color: #A9B0BB;
                display: block;
            }
            .receipt-content .invoice-wrapper .payment-details a {
                display: inline-block;
                margin-top: 5px;
            }

            .receipt-content .invoice-wrapper .line-items .print a {
                display: inline-block;
                border: 1px solid #9CB5D6;
                padding: 13px 13px;
                border-radius: 5px;
                color: #708DC0;
                font-size: 13px;
                -webkit-transition: all 0.2s linear;
                -moz-transition: all 0.2s linear;
                -ms-transition: all 0.2s linear;
                -o-transition: all 0.2s linear;
                transition: all 0.2s linear;
            }

            .receipt-content .invoice-wrapper .line-items .print a:hover {
                text-decoration: none;
                border-color: #333;
                color: #333;
            }

            .receipt-content {
                background: #ECEEF4;
            }
            @media (min-width: 1200px) {
                .receipt-content .container {
                    width: 900px;
                }
            }

            .receipt-content .logo {
                text-align: center;
                margin-top: 50px;
            }

            .receipt-content .logo a {
                font-family: Myriad Pro, Lato, Helvetica Neue, Arial;
                font-size: 36px;
                letter-spacing: .1px;
                color: #555;
                font-weight: 300;
                -webkit-transition: all 0.2s linear;
                -moz-transition: all 0.2s linear;
                -ms-transition: all 0.2s linear;
                -o-transition: all 0.2s linear;
                transition: all 0.2s linear;
            }

            .receipt-content .invoice-wrapper .intro {
                line-height: 25px;
                color: #444;
            }

            .receipt-content .invoice-wrapper .payment-info {
                margin-top: 25px;
                padding-top: 15px;
            }

            .receipt-content .invoice-wrapper .payment-info span {
                color: #A9B0BB;
            }

            .receipt-content .invoice-wrapper .payment-info strong {
                display: block;
                color: #444;
                margin-top: 3px;
            }

            @media (max-width: 767px) {
                .receipt-content .invoice-wrapper .payment-info .text-right {
                    text-align: left;
                    margin-top: 20px;
                }
            }
            .receipt-content .invoice-wrapper .payment-details {
                border-top: 2px solid #EBECEE;
                margin-top: 30px;
                padding-top: 20px;
                line-height: 22px;
            }


            @media (max-width: 767px) {
                .receipt-content .invoice-wrapper .payment-details .text-right {
                    text-align: left;
                    margin-top: 20px;
                }
            }
            .receipt-content .invoice-wrapper .line-items {
                margin-top: 40px;
            }
            .receipt-content .invoice-wrapper .line-items .headers {
                color: #A9B0BB;
                font-size: 13px;
                letter-spacing: .3px;
                border-bottom: 2px solid #EBECEE;
                padding-bottom: 4px;
            }
            .receipt-content .invoice-wrapper .line-items .items {
                margin-top: 8px;
                border-bottom: 2px solid #EBECEE;
                padding-bottom: 8px;
            }
            .receipt-content .invoice-wrapper .line-items .items .item {
                padding: 10px 0;
                color: #696969;
                font-size: 15px;
            }
            @media (max-width: 767px) {
                .receipt-content .invoice-wrapper .line-items .items .item {
                    font-size: 13px;
                }
            }
            .receipt-content .invoice-wrapper .line-items .items .item .amount {
                letter-spacing: 0.1px;
                color: #84868A;
                font-size: 16px;
            }
            @media (max-width: 767px) {
                .receipt-content .invoice-wrapper .line-items .items .item .amount {
                    font-size: 13px;
                }
            }

            .receipt-content .invoice-wrapper .line-items .total {
                margin-top: 30px;
            }

            .receipt-content .invoice-wrapper .line-items .total .extra-notes {
                float: left;
                width: 40%;
                text-align: left;
                font-size: 13px;
                color: #7A7A7A;
                line-height: 20px;
            }

            @media (max-width: 767px) {
                .receipt-content .invoice-wrapper .line-items .total .extra-notes {
                    width: 100%;
                    margin-bottom: 30px;
                    float: none;
                }
            }

            .receipt-content .invoice-wrapper .line-items .total .extra-notes strong {
                display: block;
                margin-bottom: 5px;
                color: #454545;
            }

            .receipt-content .invoice-wrapper .line-items .total .field {
                margin-bottom: 7px;
                font-size: 14px;
                color: #555;
            }

            .receipt-content .invoice-wrapper .line-items .total .field.grand-total {
                margin-top: 10px;
                font-size: 16px;
                font-weight: 500;
            }

            .receipt-content .invoice-wrapper .line-items .total .field.grand-total span {
                color: #20A720;
                font-size: 16px;
            }

            .receipt-content .invoice-wrapper .line-items .total .field span {
                display: inline-block;
                margin-left: 20px;
                min-width: 85px;
                color: #84868A;
                font-size: 15px;
            }

            .receipt-content .invoice-wrapper .line-items .print {
                margin-top: 50px;
                text-align: center;
            }



            .receipt-content .invoice-wrapper .line-items .print a i {
                margin-right: 3px;
                font-size: 14px;
            }

            .receipt-content .footer {
                margin-top: 40px;
                margin-bottom: 110px;
                text-align: center;
                font-size: 12px;
                color: #969CAD;
            }
        </style>
    </head>
    <body>
        <fmt:setLocale value="vi_VN" />
        <fmt:setBundle basename="path.to.your.resource.bundle" />
        <c:forEach items="${getTax}" var="t">
            <form action="paymentshop" method="get" class="checkout__form">
        <div class="receipt-content">
            <div class="container bootstrap snippets bootdey">
                <div class="row">
                    <div class="col-md-12">
                        <div class="invoice-wrapper">
                            <div class="intro">
                                Hi <strong>${shopName}</strong>,
                                <br>
                                This is the receipt for a payment of <strong><fmt:formatNumber type="currency" value="${revenueThisMonth*5/100}" /></strong> for your works
                            </div>
                            <div class="payment-info">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <span>Payment No.</span>
                                        <strong>${t.maShopHD}</strong>
                                    </div>
                                    <div class="col-sm-6 text-right">
                                        <span>Payment Date</span>
                                        <strong>${t.ngayXuat}</strong>
                                    </div>
                                </div>
                            </div>
                            <div class="payment-details">
                                <div class="row">
                                    <c:forEach items="${shopinfo}" var="si">
                                    <div class="col-sm-6">
                                        <span>Client</span>
                                        <strong>
                                           <div name="fullname" value="${shopName}"> ${shopName}</div>
                                        </strong>
                                        <p>
                                           <div name="address" value="${si.address}"> ${si.address} <br></div>
                                           <div name="phonenum" value="${si.phonenumber}"> ${si.phonenumber} <br></div>
                                            <a href="#">
                                                <span name="email" value="${si.email}" class="__cf_email__" data-cfemail="d7bdb8b9b9aeb3b2b1b197b0bab6bebbf9b4b8ba">[${si.email}]</span>
                                            </a>
                                        </p>
                                    </div>
                                    </c:forEach>
                                    <div class="col-sm-6 text-right">
                                        <c:forEach items="${admininfo}" var="ai">
                                        <span>Payment To</span>
                                        <strong>
                                            <div> ${ai.name}</div>
                                        </strong>
                                        <p>
                                          <div>  ${ai.address} <br></div>
                                           <div> ${ai.phonenumber} <br></div>
                                            <a href="#">
                                                <span class="__cf_email__" data-cfemail="dfb5aabeb1b9baad9fb8b2beb6b3f1bcb0b2">[${ai.email}]</span>
                                            </a>
                                        </p>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="line-items">
                                <div class="headers clearfix">
                                    <div class="row">
                                        <div class="col-xs-4">Description</div>
                                        <div class="col-xs-3">Quantity</div>
                                        <div class="col-xs-5 text-right">Amount</div>
                                    </div>
                                </div>
                                <div class="items">
                                    <div class="row item">
                                        <div class="col-xs-4 desc">
                                            Total revenue of your shop this month
                                        </div>
                                        <div class="col-xs-3 qty">
                                            1
                                        </div>
                                        <div class="col-xs-5 amount text-right">
                                            <fmt:formatNumber type="currency" value="${revenueThisMonth}" />
                                        </div>
                                    </div>
                      
                                </div>
                                <div class="total text-right">
                                    <p class="extra-notes">
                                        <strong>Extra Notes</strong>
                                        Please send all items at the same time to shipping address by next week.
                                        Thanks a lot.
                                    </p>
                                    <div class="field">
                                        Subtotal <span><fmt:formatNumber type="currency" value="${revenueThisMonth}" /></span>
                                    </div>
                                    <div class="field">
                                        Shipping <span>$0.00</span>
                                    </div>
                                    <div class="field">
                                        Tax <span>5.0%</span>
                                    </div>
                                    <div class="field grand-total" name="totalprice" value="${revenueThisMonth*5/100}">
                                        Total <span><fmt:formatNumber type="currency" value="${revenueThisMonth*5/100}" /></span>
                                    </div>
                                </div>
                                <div class="print">
                                    <button type="submit" class="site-btn">Pay</button>
                                </div>
                            </div>
                        </div>
                                    </c:forEach>
                        <div class="footer">
                            Copyright © 2014. company name
                        </div>
                    </div>
                </div>
            </div>
        </div>
            </form>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type="text/javascript">


        </script>
    </body>
</html>