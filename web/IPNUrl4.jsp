<%-- 
    Document   : IPNUrl4
    Created on : Mar 9, 2024, 8:12:09 PM
    Author     : Admin
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Config"%>
<%@page import="model.Cart"%>
<%@page import="model.Account"%>
<%@page import="model.AccInfo"%>
<%@page import="model.SanPham"%>
<%@page import="model.SoLuongBan"%>
<%@page import="dal.DAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="application/json; charset=UTF-8"%>

<!-- Url IPN (Instant Payment Notification) -->
<%
    //Begin process return from VNPAY
     /* Payment Notify
     * IPN URL: Ghi nhận kết quả thanh toán từ VNPAY
     * Các bước thực hiện:
     * Kiểm tra checksum 
     * Tìm giao dịch trong database
     * Kiểm tra số tiền giữa hai hệ thống
     * Kiểm tra tình trạng của giao dịch trước khi cập nhật
     * Cập nhật kết quả vào Database
     * Trả kết quả ghi nhận lại cho VNPAY
     */
    
    Map fields = new HashMap();
             for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }
    String vnp_SecureHash = request.getParameter("vnp_SecureHash");
    if (fields.containsKey("vnp_SecureHashType")) {
        fields.remove("vnp_SecureHashType");
    }
    if (fields.containsKey("vnp_SecureHash")) {
        fields.remove("vnp_SecureHash");
    }
    String signValue = Config.hashAllFields(fields);
    if (signValue.equals(vnp_SecureHash)) {
        boolean checkOrderId = true; // Giá trị của vnp_TxnRef tồn tại trong CSDL của merchant
        boolean checkAmount = true; //Kiểm tra số tiền thanh toán do VNPAY phản hồi(vnp_Amount/100) với số tiền của đơn hàng merchant tạo thanh toán: giả sử số tiền kiểm tra là đúng.
        boolean checkOrderStatus = true; // Giả sử PaymnentStatus = 0 (pending) là trạng thái thanh toán của giao dịch khởi tạo chưa có IPN.
        if (checkOrderId) {
            if (checkAmount) {
                if (checkOrderStatus) {
                    if ("00".equals(request.getParameter("vnp_ResponseCode"))) { 
                    
                        
                        Account a = (Account) session.getAttribute("acc");
                        int accountID = a.getuID();
                            
                        DAO dao = new DAO();
                        int shopID= dao.getShopIdByAccountId(accountID);
                        
                        int vnp_TxnRef = Integer.parseInt(request.getParameter("vnp_TxnRef"));
                        long vnp_Amount = Long.parseLong(request.getParameter("vnp_Amount")) / 100;
                        String vnp_BankCode = request.getParameter("vnp_BankCode");
                        String vnp_BankTranNo = request.getParameter("vnp_BankTranNo");
                        String vnp_CardType = request.getParameter("vnp_CardType");
                        String vnp_OrderInfo = request.getParameter("vnp_OrderInfo");
                                
                        String vnp_PayDateStr = request.getParameter("vnp_PayDate");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                        LocalDateTime vnp_PayDate = LocalDateTime.parse(vnp_PayDateStr, formatter);
                    
                        int vnp_ResponseCode = Integer.parseInt(request.getParameter("vnp_ResponseCode"));
                        String vnp_TmnCode = request.getParameter("vnp_TmnCode");
                        int vnp_TransactionNo = Integer.parseInt(request.getParameter("vnp_TransactionNo"));
                        String vnp_SecureHashType = "hmacSHA512";
                                
                        long shopBalance= dao.getShopBalByID(shopID);
                        dao.insertThanhToanVNPAY(vnp_TxnRef, vnp_Amount, vnp_BankCode, vnp_BankTranNo,vnp_CardType, vnp_OrderInfo, vnp_PayDate, vnp_ResponseCode, vnp_TmnCode,vnp_TransactionNo, vnp_SecureHashType, vnp_SecureHash);
                        dao.editShopBalance(shopID, shopBalance-vnp_Amount);
                        dao.insertShopBalance1(shopID, vnp_Amount, vnp_TxnRef);        
                        
                                
                        response.sendRedirect("shopBalance");
                        out.print("{\"RspCode\":\"00\",\"Message\":\"Confirm Success\"}");
                        //Xử lý/Cập nhật tình trạng giao dịch thanh toán "Thành công"
                        out.print("GD Thanh cong");
                    } else {
                        //Xử lý/Cập nhật tình trạng giao dịch thanh toán "Không thành công"                      
                        out.print("GD Khong thanh cong do bi huy");
                        response.sendRedirect("shopBalance");
                    }
                } else {
                    //Trạng thái giao dịch đã được cập nhật trước đó                 
                    out.print("{\"RspCode\":\"02\",\"Message\":\"Order already confirmed\"}");
                    response.sendRedirect("shopBalance");
                }
            } else {
                //Số tiền không trùng khớp
                out.print("{\"RspCode\":\"04\",\"Message\":\"Invalid Amount\"}");
                response.sendRedirect("shopBalance");
            }
        } else {
            out.print("{\"RspCode\":\"01\",\"Message\":\"Order not Found\"}");
            response.sendRedirect("shopBalance");
        }

    } else {
        // Sai checksum
        out.print("{\"RspCode\":\"97\",\"Message\":\"Invalid Checksum\"}");
        response.sendRedirect("shopBalance");
    }
%>
