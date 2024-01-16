package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class OrderDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"description\" content=\"Ashion Template\">\n");
      out.write("    <meta name=\"keywords\" content=\"Ashion, unica, creative, html\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <title>Ashion | Template</title>\n");
      out.write("\n");
      out.write("    <!-- Google Font -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Cookie&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap\"\n");
      out.write("    rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Css Styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/jquery-ui.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/magnific-popup.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/usersetting.css\" type=\"text/css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"wrapper bg-white mt-sm-5\">\n");
      out.write("    <h4 class=\"pb-4 border-bottom\">Order details</h4>\n");
      out.write("        <div class=\"d-flex align-items-start py-3 border-bottom\">\n");
      out.write("        <img src=\"https://images.pexels.com/photos/1037995/pexels-photo-1037995.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500\" class=\"img\" alt=\"\">\n");
      out.write("            <div class=\"pl-sm-4 pl-2\" id=\"img-section\">\n");
      out.write("            <b>Profile Photo</b>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("  <!-- Title -->\n");
      out.write("  <div class=\"d-flex justify-content-between align-items-center py-3\">\n");
      out.write("    <h2 class=\"h5 mb-0\"><a href=\"#\" class=\"text-muted\"></a> Order #16123222</h2>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Main content -->\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-lg-8\">\n");
      out.write("      <!-- Details -->\n");
      out.write("      <div class=\"card mb-4\">\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("          <div class=\"mb-3 d-flex justify-content-between\">\n");
      out.write("            <div>\n");
      out.write("              <span class=\"me-3\">22-11-2021</span>\n");
      out.write("              <span class=\"me-3\">#16123222</span>\n");
      out.write("              <span class=\"me-3\">Visa -1234</span>\n");
      out.write("              <span class=\"badge rounded-pill bg-info\">SHIPPING</span>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"d-flex\">\n");
      out.write("              <button class=\"btn btn-link p-0 me-3 d-none d-lg-block btn-icon-text\"><i class=\"bi bi-download\"></i> <span class=\"text\">Invoice</span></button>\n");
      out.write("              <div class=\"dropdown\">\n");
      out.write("                <button class=\"btn btn-link p-0 text-muted\" type=\"button\" data-bs-toggle=\"dropdown\">\n");
      out.write("                  <i class=\"bi bi-three-dots-vertical\"></i>\n");
      out.write("                </button>\n");
      out.write("                <ul class=\"dropdown-menu dropdown-menu-end\">\n");
      out.write("                  <li><a class=\"dropdown-item\" href=\"#\"><i class=\"bi bi-pencil\"></i> Edit</a></li>\n");
      out.write("                  <li><a class=\"dropdown-item\" href=\"#\"><i class=\"bi bi-printer\"></i> Print</a></li>\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <table class=\"table table-borderless\">\n");
      out.write("            <tbody>\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <div class=\"d-flex mb-2\">\n");
      out.write("                    <div class=\"flex-shrink-0\">\n");
      out.write("                      <img src=\"https://www.bootdey.com/image/280x280/87CEFA/000000\" alt=\"\" width=\"35\" class=\"img-fluid\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"flex-lg-grow-1 ms-3\">\n");
      out.write("                      <h6 class=\"small mb-0\"><a href=\"#\" class=\"text-reset\">Wireless Headphones with Noise Cancellation Tru Bass Bluetooth HiFi</a></h6>\n");
      out.write("                      <span class=\"small\">Color: Black</span>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </td>\n");
      out.write("                <td>1</td>\n");
      out.write("                <td class=\"text-end\">$79.99</td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <div class=\"d-flex mb-2\">\n");
      out.write("                    <div class=\"flex-shrink-0\">\n");
      out.write("                      <img src=\"https://www.bootdey.com/image/280x280/FF69B4/000000\" alt=\"\" width=\"35\" class=\"img-fluid\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"flex-lg-grow-1 ms-3\">\n");
      out.write("                      <h6 class=\"small mb-0\"><a href=\"#\" class=\"text-reset\">Smartwatch IP68 Waterproof GPS and Bluetooth Support</a></h6>\n");
      out.write("                      <span class=\"small\">Color: White</span>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </td>\n");
      out.write("                <td>1</td>\n");
      out.write("                <td class=\"text-end\">$79.99</td>\n");
      out.write("              </tr>\n");
      out.write("            </tbody>\n");
      out.write("            <tfoot>\n");
      out.write("              <tr>\n");
      out.write("                <td colspan=\"2\">Subtotal</td>\n");
      out.write("                <td class=\"text-end\">$159,98</td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td colspan=\"2\">Shipping</td>\n");
      out.write("                <td class=\"text-end\">$20.00</td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td colspan=\"2\">Discount (Code: NEWYEAR)</td>\n");
      out.write("                <td class=\"text-danger text-end\">-$10.00</td>\n");
      out.write("              </tr>\n");
      out.write("              <tr class=\"fw-bold\">\n");
      out.write("                <td colspan=\"2\">TOTAL</td>\n");
      out.write("                <td class=\"text-end\">$169,98</td>\n");
      out.write("              </tr>\n");
      out.write("            </tfoot>\n");
      out.write("          </table>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- Payment -->\n");
      out.write("      <div class=\"card mb-4\">\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("          <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-6\">\n");
      out.write("              <h3 class=\"h6\">Payment Method</h3>\n");
      out.write("              <p>Visa -1234 <br>\n");
      out.write("              Total: $169,98 <span class=\"badge bg-success rounded-pill\">PAID</span></p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-6\">\n");
      out.write("              <h3 class=\"h6\">Billing address</h3>\n");
      out.write("              <address>\n");
      out.write("                <strong>John Doe</strong><br>\n");
      out.write("                1355 Market St, Suite 900<br>\n");
      out.write("                San Francisco, CA 94103<br>\n");
      out.write("                <abbr title=\"Phone\">P:</abbr> (123) 456-7890\n");
      out.write("              </address>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-lg-4\">\n");
      out.write("      <!-- Customer Notes -->\n");
      out.write("      <div class=\"card mb-4\">\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("          <h3 class=\"h6\">Customer Notes</h3>\n");
      out.write("          <p>Sed enim, faucibus litora velit vestibulum habitasse. Cras lobortis cum sem aliquet mauris rutrum. Sollicitudin. Morbi, sem tellus vestibulum porttitor.</p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"card mb-4\">\n");
      out.write("        <!-- Shipping information -->\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("          <h3 class=\"h6\">Shipping Information</h3>\n");
      out.write("          <strong>FedEx</strong>\n");
      out.write("          <span><a href=\"#\" class=\"text-decoration-underline\" target=\"_blank\">FF1234567890</a> <i class=\"bi bi-box-arrow-up-right\"></i> </span>\n");
      out.write("          <hr>\n");
      out.write("          <h3 class=\"h6\">Address</h3>\n");
      out.write("          <address>\n");
      out.write("            <strong>John Doe</strong><br>\n");
      out.write("            1355 Market St, Suite 900<br>\n");
      out.write("            San Francisco, CA 94103<br>\n");
      out.write("            <abbr title=\"Phone\">P:</abbr> (123) 456-7890\n");
      out.write("          </address>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("  </div>\n");
      out.write("    <!-- Js Plugins -->\n");
      out.write("    <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("    <script src=\"js/mixitup.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.countdown.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.slicknav.js\"></script>\n");
      out.write("    <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.nicescroll.min.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
