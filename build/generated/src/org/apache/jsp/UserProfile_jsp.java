package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_currencySymbol_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatNumber_value_type_currencySymbol_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatNumber_value_type_currencySymbol_nobody.release();
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
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
      out.write("        <div class=\"d-flex align-items-start py-3 border-bottom\">\n");
      out.write("        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.getAvatar()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"img\" alt=\"\">\n");
      out.write("            <div class=\"pl-sm-4 pl-2\" id=\"img-section\">\n");
      out.write("            <b>Profile Photo</b>\n");
      out.write("            <p>Accepted file type .png. Less than 1MB</p>\n");
      out.write("            <button class=\"btn button border\"><b>Upload</b></button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ml-auto\">\n");
      out.write("                <label for=\"language\"><b>Total spend</b></label> \n");
      out.write("                <div class=\"arrow\">\n");
      out.write("                <p type=\"text\" class=\"ml-auto\" readonly>\n");
      out.write("                    ");
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    ");
      if (_jspx_meth_fmt_formatNumber_0(_jspx_page_context))
        return;
      out.write("             \n");
      out.write("                </p>\n");
      out.write("                </div>\n");
      out.write("            </div>          \n");
      out.write("        </div>\n");
      out.write("        <div class=\"py-2\">\n");
      out.write("            <form action=\"editcustomerinfo\" method=\"post\">\n");
      out.write("            <div class=\"row py-2\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                <label for=\"firstname\">Full Name</label>\n");
      out.write("                <input name=\"fullname\" type=\"text\" class=\"bg-light form-control\" placeholder=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                <label for=\"email\">Address</label>\n");
      out.write("                <input name=\"address\" type=\"text\" class=\"bg-light form-control\" placeholder=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.getAddress()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row py-2\">               \n");
      out.write("                <div class=\"col-md-6 pt-md-0 pt-3\">\n");
      out.write("                <label for=\"phone\">Phone Number</label>\n");
      out.write("                <input name=\"phonenum\" type=\"tel\" class=\"bg-light form-control\" placeholder=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.getPhonenumber()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                <label for=\"email\">Email Address</label>\n");
      out.write("                <input name=\"email\" type=\"text\" class=\"bg-light form-control\" placeholder=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.getEmail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"py-3 pb-4 border-bottom\">\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary mr-3\">Save Changes</button>\n");
      out.write("                <button class=\"btn border button\">Cancel</button>\n");
      out.write("            </div>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"d-sm-flex align-items-center pt-3\" id=\"deactivate\">\n");
      out.write("                <div>\n");
      out.write("                    <b>Order history</b>\n");
      out.write("                    <p>View your order</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"ml-auto\">\n");
      out.write("                    <button class=\"btn danger\">Order history</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"d-sm-flex align-items-center pt-3\" id=\"deactivate\">\n");
      out.write("                <div>\n");
      out.write("                    <b>Reset Password</b>\n");
      out.write("                    <p>Reset your password immediately</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"ml-auto\">\n");
      out.write("                    <button class=\"btn danger\">Reset password</button>\n");
      out.write("                </div>\n");
      out.write("            </div>            \n");
      out.write("            <div class=\"d-sm-flex align-items-center pt-3\" id=\"deactivate\">\n");
      out.write("                <div>\n");
      out.write("                    <b>Change Password</b>\n");
      out.write("                    <p>Change your password</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"ml-auto\">\n");
      out.write("                    <button class=\"btn danger\">Change password</button>\n");
      out.write("                </div>\n");
      out.write("            </div>            \n");
      out.write("            <div class=\"d-sm-flex align-items-center pt-3\" id=\"deactivate\">\n");
      out.write("                <div>\n");
      out.write("                    <b>Deactivate your account</b>\n");
      out.write("                    <p>Details about your company account and password</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"ml-auto\">\n");
      out.write("                    <button class=\"btn danger\">Deactivate</button>\n");
      out.write("                </div>\n");
      out.write("            </div>            \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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

  private boolean _jspx_meth_fmt_setLocale_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_setLocale_0 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _jspx_tagPool_fmt_setLocale_value_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_setLocale_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_setLocale_0.setParent(null);
    _jspx_th_fmt_setLocale_0.setValue(new String("vi_VN"));
    int _jspx_eval_fmt_setLocale_0 = _jspx_th_fmt_setLocale_0.doStartTag();
    if (_jspx_th_fmt_setLocale_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
      return true;
    }
    _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_currencySymbol_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent(null);
    _jspx_th_fmt_formatNumber_0.setType("currency");
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.getTongChiTieu()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatNumber_0.setCurrencySymbol("₫");
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_currencySymbol_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_currencySymbol_nobody.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }
}
