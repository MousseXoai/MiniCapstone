/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccInfo;
import model.Account;
import model.Cart;
import model.Config;
import model.SanPham;
import model.SoLuongBan;

/**
 *
 * @author Tosaka
 */
public class CustomerPaymentControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerPaymentControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerPaymentControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname").replaceAll("\\s+", " ").trim();
        String address = request.getParameter("address").replaceAll("\\s+", " ").trim();
        String phonenum = request.getParameter("phonenum").replaceAll("\\s", "").trim();
        String email = request.getParameter("email").replaceAll("\\s", "").trim();
        String note = request.getParameter("note").replaceAll("\\s", " ");
        String payment_option = request.getParameter("payment_option");

        DAO dao = new DAO();

        int paymentid = 0;
        String err = "", err2 = "", err3 = "", err4 = "", err5 = "";

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();

            ArrayList<Cart> list = dao.getProductInCartByAccId(accountID);
            ArrayList<SanPham> listSP = dao.getAllProduct();
            AccInfo accInfo = dao.getAccInfo(accountID);

            if (fullname.isEmpty() || address.isEmpty() || phonenum.isEmpty() || email.isEmpty()) {
                err = getServletContext().getInitParameter("messErrorEditProfileCustomer");
            } else if (!fullname.matches("[\\p{L}\\s]+")) {
                err2 = getServletContext().getInitParameter("messErrorInvalidName");
            } else if (phonenum.length() != 10 || !phonenum.matches("\\d+")) {
                err3 = getServletContext().getInitParameter("messErrorPhoneNum");
            } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                err4 = getServletContext().getInitParameter("messErrorInvalidEmail");
            } else if (fullname.length() > 50 || email.length() > 50) {
                err5 = getServletContext().getInitParameter("messErrorNameAndEmail");
            }

            if (!err.isEmpty() || !err2.isEmpty() || !err3.isEmpty() || !err4.isEmpty() || !err5.isEmpty()) {
                request.setAttribute("err", err);
                request.setAttribute("err2", err2);
                request.setAttribute("err3", err3);
                request.setAttribute("err4", err4);
                request.setAttribute("err5", err5);
                request.getRequestDispatcher("checkout").forward(request, response);
            } else {
                if (payment_option.equals("vnpay")) {

                    String vnp_Version = "2.1.0";
                    String vnp_Command = "pay";
                    String orderType = "other";
                    long amount = Long.parseLong(request.getParameter("totalprice")) * 100;

                    String vnp_TxnRef = Config.getRandomNumber(8);
                    String vnp_IpAddr = Config.getIpAddress(request);

                    String vnp_TmnCode = Config.vnp_TmnCode;

                    Map<String, String> vnp_Params = new HashMap<>();
                    vnp_Params.put("vnp_Version", vnp_Version);
                    vnp_Params.put("vnp_Command", vnp_Command);
                    vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
                    vnp_Params.put("vnp_Amount", String.valueOf(amount));
                    vnp_Params.put("vnp_CurrCode", "VND");
                    String bank_code = request.getParameter("bankcode");
                    if (bank_code != null && !bank_code.isEmpty()) {
                        vnp_Params.put("vnp_BankCode", bank_code);
                    }
                    vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
                    vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
                    vnp_Params.put("vnp_OrderType", orderType);

                    String locate = request.getParameter("language");
                    if (locate != null && !locate.isEmpty()) {
                        vnp_Params.put("vnp_Locale", locate);
                    } else {
                        vnp_Params.put("vnp_Locale", "vn");
                    }
                    vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
                    vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

                    Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                    String vnp_CreateDate = formatter.format(cld.getTime());
                    vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

                    cld.add(Calendar.MINUTE, 15);
                    String vnp_ExpireDate = formatter.format(cld.getTime());
                    vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

                    List fieldNames = new ArrayList(vnp_Params.keySet());
                    Collections.sort(fieldNames);
                    StringBuilder hashData = new StringBuilder();
                    StringBuilder query = new StringBuilder();
                    Iterator itr = fieldNames.iterator();
                    while (itr.hasNext()) {
                        String fieldName = (String) itr.next();
                        String fieldValue = (String) vnp_Params.get(fieldName);
                        if ((fieldValue != null) && (fieldValue.length() > 0)) {
                            //Build hash data
                            hashData.append(fieldName);
                            hashData.append('=');
                            hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                            //Build query
                            query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                            query.append('=');
                            query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                            if (itr.hasNext()) {
                                query.append('&');
                                hashData.append('&');
                            }
                        }
                    }
                    String queryUrl = query.toString();
                    String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
                    queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
                    String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
                    com.google.gson.JsonObject job = new JsonObject();
                    job.addProperty("code", "00");
                    job.addProperty("message", "success");
                    job.addProperty("data", paymentUrl);
//                    Gson gson = new Gson();
//                    response.getWriter().write(gson.toJson(job));
                    session.setAttribute("ssFullname", fullname);
                    session.setAttribute("ssAddress", address);
                    session.setAttribute("ssPhonenum", phonenum);
                    session.setAttribute("ssEmail", email);
                    session.setAttribute("ssNote", note);
                    response.sendRedirect(paymentUrl);
                }
                if (payment_option.equals("momo")) {
                    paymentid = 1;
                }

                if (payment_option.equals("cod")) {
                    long tonggia = Long.parseLong(request.getParameter("totalprice"));

                    Calendar calender = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
                    SimpleDateFormat formatterCOD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String ngayXuat = formatterCOD.format(calender.getTime());

                    paymentid = 3;
                    int maHD = Integer.parseInt(Config.getRandomNumber(8));  
                    session.setAttribute("checkMaHoaDonTo", "none");
                    session.setAttribute("checkMaThanhToanTrucTiep", String.valueOf(maHD));
                    for (Cart cart : list) {
                        for (SanPham sanPham : listSP) {
                            if (cart.getProductID() == sanPham.getId()) {
                                dao.insertBillCOD(accountID, tonggia, ngayXuat, 1, 1, paymentid, maHD);
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

                    response.sendRedirect("thankyou");

                }
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public String getValue(){
        return "aasdfasd";
    }

}
