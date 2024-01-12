package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <h4 class=\"pb-4 border-bottom\">Account settings</h4>\n");
      out.write("    <div class=\"d-flex align-items-start py-3 border-bottom\">\n");
      out.write("        <img src=\"https://images.pexels.com/photos/1037995/pexels-photo-1037995.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500\"\n");
      out.write("            class=\"img\" alt=\"\">\n");
      out.write("        <div class=\"pl-sm-4 pl-2\" id=\"img-section\">\n");
      out.write("            <b>Profile Photo</b>\n");
      out.write("            <p>Accepted file type .png. Less than 1MB</p>\n");
      out.write("            <button class=\"btn button border\"><b>Upload</b></button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"py-2\">\n");
      out.write("        <div class=\"row py-2\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <label for=\"firstname\">First Name</label>\n");
      out.write("                <input type=\"text\" class=\"bg-light form-control\" placeholder=\"Steve\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6 pt-md-0 pt-3\">\n");
      out.write("                <label for=\"lastname\">Last Name</label>\n");
      out.write("                <input type=\"text\" class=\"bg-light form-control\" placeholder=\"Smith\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row py-2\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <label for=\"email\">Email Address</label>\n");
      out.write("                <input type=\"text\" class=\"bg-light form-control\" placeholder=\"steve_@email.com\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6 pt-md-0 pt-3\">\n");
      out.write("                <label for=\"phone\">Phone Number</label>\n");
      out.write("                <input type=\"tel\" class=\"bg-light form-control\" placeholder=\"+1 213-548-6015\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row py-2\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <label for=\"country\">Country</label>\n");
      out.write("                <select name=\"country\" id=\"country\" class=\"bg-light\">\n");
      out.write("                    <option value=\"india\" selected>India</option>\n");
      out.write("                    <option value=\"usa\">USA</option>\n");
      out.write("                    <option value=\"uk\">UK</option>\n");
      out.write("                    <option value=\"uae\">UAE</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6 pt-md-0 pt-3\" id=\"lang\">\n");
      out.write("                <label for=\"language\">Language</label>\n");
      out.write("                <div class=\"arrow\">\n");
      out.write("                    <select name=\"language\" id=\"language\" class=\"bg-light\">\n");
      out.write("                        <option value=\"english\" selected>English</option>\n");
      out.write("                        <option value=\"english_us\">English (United States)</option>\n");
      out.write("                        <option value=\"enguk\">English UK</option>\n");
      out.write("                        <option value=\"arab\">Arabic</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"py-3 pb-4 border-bottom\">\n");
      out.write("            <button class=\"btn btn-primary mr-3\">Save Changes</button>\n");
      out.write("            <button class=\"btn border button\">Cancel</button>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"d-sm-flex align-items-center pt-3\" id=\"deactivate\">\n");
      out.write("            <div>\n");
      out.write("                <b>Deactivate your account</b>\n");
      out.write("                <p>Details about your company account and password</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ml-auto\">\n");
      out.write("                <button class=\"btn danger\">Deactivate</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("\n");
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
