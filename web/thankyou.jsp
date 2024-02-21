<%-- 
    Document   : thankyou
    Created on : Feb 18, 2024, 3:29:45 AM
    Author     : Tosaka
--%>
<%@ page import="java.util.Map, java.util.HashMap, java.util.Enumeration, model.Config" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">


        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>

        <div class="site-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <span class="icon-check_circle display-3 text-success"></span>
                        <h2 class="display-3 text-black">Thank you!</h2>
                        <p class="lead mb-5">You order was successfuly completed.</p>
                        <p><a href="home" class="btn btn-sm btn-primary">Back to home</a></p>
                    </div>
                </div>
            </div>
        </div>

        <%
       try
       {
		            
           /*  IPN URL: Record payment results from VNPAY
           Implementation steps:
           Check checksum
           Find transactions (vnp_TxnRef) in the database (checkOrderId)
           Check the payment status of transactions before updating (checkOrderStatus)
           Check the amount (vnp_Amount) of transactions before updating (checkAmount)
           Update results to Database
           Return recorded results to VNPAY
           */
			
           // ex:  	PaymnentStatus = 0; pending 
           //              PaymnentStatus = 1; success 
           //              PaymnentStatus = 2; Faile 
        
           //Begin process return from VNPAY	
           Map fields = new HashMap();
           for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
               String fieldName = (String) params.nextElement();
               String fieldValue = request.getParameter(fieldName);
               if ((fieldValue != null) && (fieldValue.length() > 0)) 
               {
                   fields.put(fieldName, fieldValue);
               }
           }

           String vnp_SecureHash = request.getParameter("vnp_SecureHash");
           if (fields.containsKey("vnp_SecureHashType")) 
           {
               fields.remove("vnp_SecureHashType");
           }
           if (fields.containsKey("vnp_SecureHash")) 
           {
               fields.remove("vnp_SecureHash");
           }
		
                   // Check checksum
           String signValue = Config.hashAllFields(fields);
           if (signValue.equals(vnp_SecureHash)) 
           {

               boolean checkOrderId = true; // vnp_TxnRef exists in your database
               boolean checkAmount = true; // vnp_Amount is valid (Check vnp_Amount VNPAY returns compared to the amount of the code (vnp_TxnRef) in the Your database).
               boolean checkOrderStatus = true; // PaymnentStatus = 0 (pending)
			
			
               if(checkOrderId)
               {
                   if(checkAmount)
                   {
                       if (checkOrderStatus)
                       {
                           if ("00".equals(request.getParameter("vnp_ResponseCode")))
                           {
                            
                               //Here Code update PaymnentStatus = 1 into your Database
                           }
                           else
                           {
                            
                               // Here Code update PaymnentStatus = 2 into your Database
                           }
                           out.print ("{\"RspCode\":\"00\",\"Message\":\"Confirm Success\"}");
                       }
                       else
                       {
                        
                           out.print("{\"RspCode\":\"02\",\"Message\":\"Order already confirmed\"}");
                       }
                   }
                   else
                   {
                      out.print("{\"RspCode\":\"04\",\"Message\":\"Invalid Amount\"}"); 
                   }
               }
               else
               {
                   out.print("{\"RspCode\":\"01\",\"Message\":\"Order not Found\"}");
               }
           } 
           else 
           {
               out.print("{\"RspCode\":\"97\",\"Message\":\"Invalid Checksum\"}");
           }
       }
       catch(Exception e)
       {
           out.print("{\"RspCode\":\"99\",\"Message\":\"Unknow error\"}");
       }
        %>


        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>

        <script src="js/main.js"></script>

    </body>
</html>
