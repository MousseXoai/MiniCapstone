<%-- 
    Document   : IPNUrl
    Created on : Feb 22, 2024, 7:32:23 AM
    Author     : Tosaka
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
                    
                        String fullnameParam = (String) session.getAttribute("ssFullname");
                        String fullname = "";
                        if (fullnameParam != null) {
                        fullname = fullnameParam.replaceAll("\\s+", " ").trim();
                        }
                        
                        String addressParam = (String) session.getAttribute("ssAddress");
                        String address = "";
                        if (addressParam != null) {
                        address = addressParam.replaceAll("\\s+", " ").trim();
                        }
                        
                        String phonenumParam = (String) session.getAttribute("ssPhonenum");
                        String phonenum = "";
                        if (phonenumParam != null) {
                        phonenum = phonenumParam.replaceAll("\\s+", " ").trim();
                        }
                        
                        String emailParam = (String) session.getAttribute("ssEmail");
                        String email = "";
                        if (emailParam != null) {
                        email = emailParam.replaceAll("\\s+", " ").trim();
                        }
                        
                        String noteParam = (String) session.getAttribute("ssNote");
                        String note = "";
                        if (noteParam != null) {
                        note = noteParam.replaceAll("\\s+", " ");
                        }

                        int paymentid = 2;
                        
                        Account a = (Account) session.getAttribute("acc");
                        int accountID = a.getuID();
                            
                        DAO dao = new DAO();
                        ArrayList<Cart> list = dao.getProductInCartByAccId(accountID);
                        ArrayList<SanPham> listSP = dao.getAllProduct();
                        AccInfo accInfo = dao.getAccInfo(accountID);
                        
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
                                
                        dao.insertThanhToanVNPAY(vnp_TxnRef, vnp_Amount, vnp_BankCode, vnp_BankTranNo,vnp_CardType, vnp_OrderInfo, vnp_PayDate, vnp_ResponseCode, vnp_TmnCode,vnp_TransactionNo, vnp_SecureHashType, vnp_SecureHash);
                                
                        for (Cart cart : list) {
                            for (SanPham sanPham : listSP) {
                                if (cart.getProductID() == sanPham.getId()) {
                                dao.insertBillVNPAY(accountID, vnp_Amount, vnp_PayDate, 1, 1, paymentid, vnp_TxnRef);
                                dao.insertInfoLine(fullname, email, address, phonenum, note);
                                SoLuongBan slb = dao.getSoLuongBanByID(sanPham.getId());
                                dao.insertOrderLine(cart.getProductID(), (float) (sanPham.getPrice()*(1-sanPham.getSale()/100.0)), cart.getAmount());
                                dao.updateQuantity(sanPham.getQuantity() - cart.getAmount(), sanPham.getId());
                                if (slb == null) {
                                    dao.insertSoLuongBan(sanPham.getId(), cart.getAmount());
                                } else {
                                    dao.updateSoLuongBan(slb.getSoLuongDaBan() + cart.getAmount(), sanPham.getId());
                                }
                                dao.updateTongChiTieu(accInfo.getTongChiTieu() + (cart.getAmount()* (sanPham.getPrice()*(1-sanPham.getSale()/100.0))), accountID);
                                dao.removeProductIdInCart(cart.getProductID(), accountID);
                                break;
                                }
                            }
                        }
                        
                        session.setAttribute("checkMaHoaDonTo",  String.valueOf(vnp_TxnRef));
                        session.setAttribute("checkMaThanhToanTrucTiep", "none");
                                
                        response.sendRedirect("thankyou");
                        out.print("{\"RspCode\":\"00\",\"Message\":\"Confirm Success\"}");
                        //Xử lý/Cập nhật tình trạng giao dịch thanh toán "Thành công"
                        out.print("GD Thanh cong");
                    } else {
                        //Xử lý/Cập nhật tình trạng giao dịch thanh toán "Không thành công"                      
                        out.print("GD Khong thanh cong do bi huy");
                        response.sendRedirect("checkout");
                    }
                } else {
                    //Trạng thái giao dịch đã được cập nhật trước đó                 
                    out.print("{\"RspCode\":\"02\",\"Message\":\"Order already confirmed\"}");
                    response.sendRedirect("checkout");
                }
            } else {
                //Số tiền không trùng khớp
                out.print("{\"RspCode\":\"04\",\"Message\":\"Invalid Amount\"}");
                response.sendRedirect("checkout");
            }
        } else {
            out.print("{\"RspCode\":\"01\",\"Message\":\"Order not Found\"}");
            response.sendRedirect("checkout");
        }

    } else {
        // Sai checksum
        out.print("{\"RspCode\":\"97\",\"Message\":\"Invalid Checksum\"}");
        response.sendRedirect("checkout");
    }
%>

