package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UpdateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!DOCTYPE html>\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <title>JSP Page</title>\n");
      out.write("            <style>\n");
      out.write("                body {\n");
      out.write("        font-family: 'Arial', sans-serif;\n");
      out.write("        background-color: #f4f4f4;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the modal */\n");
      out.write("    .modal {\n");
      out.write("        background-color: #fff;\n");
      out.write("        border-radius: 8px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the modal content */\n");
      out.write("    .modal-content {\n");
      out.write("        border: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the modal header */\n");
      out.write("    .modal-header {\n");
      out.write("        background-color: #007bff;\n");
      out.write("        color: #fff;\n");
      out.write("        padding: 15px;\n");
      out.write("        border-bottom: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the modal body */\n");
      out.write("    .modal-body {\n");
      out.write("        padding: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the form labels */\n");
      out.write("    .control-label {\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the form inputs and selects */\n");
      out.write("    .form-control {\n");
      out.write("        width: 100%;\n");
      out.write("        padding: 8px;\n");
      out.write("        margin-bottom: 15px;\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("        border-radius: 4px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the save and cancel buttons */\n");
      out.write("    .btn-save {\n");
      out.write("        background-color: #28a745;\n");
      out.write("        color: #fff;\n");
      out.write("        border: none;\n");
      out.write("        padding: 10px 20px;\n");
      out.write("        border-radius: 4px;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-cancel {\n");
      out.write("        background-color: #ea0000;\n");
      out.write("        color: #fff;\n");
      out.write("        border: none;\n");
      out.write("        padding: 10px 20px;\n");
      out.write("        border-radius: 4px;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style the link for advanced editing */\n");
      out.write("    a {\n");
      out.write("        text-decoration: none;\n");
      out.write("        color: #007bff;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    a:hover {\n");
      out.write("        text-decoration: underline;\n");
      out.write("        color: #0056b3;\n");
      out.write("    }\n");
      out.write("            </style>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("            <div class=\"modal fade\" id=\"ModalUP\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\" data-backdrop=\"static\"\n");
      out.write("                 data-keyboard=\"false\">\n");
      out.write("                <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"form-group  col-md-12\">\n");
      out.write("                                    <span class=\"thong-tin-thanh-toan\">\n");
      out.write("                                        <h5>Chỉnh sửa thông tin sản phẩm cơ bản</h5>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"form-group col-md-6\">\n");
      out.write("                                    <label class=\"control-label\">Mã sản phẩm </label>\n");
      out.write("                                    <input class=\"form-control\" type=\"number\" value=\"71309005\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-6\">\n");
      out.write("                                    <label class=\"control-label\">Tên sản phẩm</label>\n");
      out.write("                                    <input class=\"form-control\" type=\"text\" required value=\"Bàn ăn gỗ Theresa\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group  col-md-6\">\n");
      out.write("                                    <label class=\"control-label\">Số lượng</label>\n");
      out.write("                                    <input class=\"form-control\" type=\"number\" required value=\"20\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-6 \">\n");
      out.write("                                    <label for=\"exampleSelect1\" class=\"control-label\">Tình trạng sản phẩm</label>\n");
      out.write("                                    <select class=\"form-control\" id=\"exampleSelect1\">\n");
      out.write("                                        <option>Còn hàng</option>\n");
      out.write("                                        <option>Hết hàng</option>\n");
      out.write("                                        <option>Đang nhập hàng</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-6\">\n");
      out.write("                                    <label class=\"control-label\">Giá bán</label>\n");
      out.write("                                    <input class=\"form-control\" type=\"text\" value=\"5.600.000\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-6\">\n");
      out.write("                                    <label for=\"exampleSelect1\" class=\"control-label\">Danh mục</label>\n");
      out.write("                                    <select class=\"form-control\" id=\"exampleSelect1\">\n");
      out.write("                                        <option>Bàn ăn</option>\n");
      out.write("                                        <option>Bàn thông minh</option>\n");
      out.write("                                        <option>Tủ</option>\n");
      out.write("                                        <option>Ghế gỗ</option>\n");
      out.write("                                        <option>Ghế sắt</option>\n");
      out.write("                                        <option>Giường người lớn</option>\n");
      out.write("                                        <option>Giường trẻ em</option>\n");
      out.write("                                        <option>Bàn trang điểm</option>\n");
      out.write("                                        <option>Giá đỡ</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <BR>\n");
      out.write("                            <a href=\"#\" style=\"    float: right;\n");
      out.write("                               font-weight: 600;\n");
      out.write("                               color: #ea0000;\">Chỉnh sửa sản phẩm nâng cao</a>\n");
      out.write("                            <BR>\n");
      out.write("                            <BR>\n");
      out.write("                            <button class=\"btn btn-save\" type=\"button\">Lưu lại</button>\n");
      out.write("                            <a class=\"btn btn-cancel\" data-dismiss=\"modal\" href=\"#\">Hủy bỏ</a>\n");
      out.write("                            <BR>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
