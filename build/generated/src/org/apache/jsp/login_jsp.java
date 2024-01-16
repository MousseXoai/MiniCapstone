package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Đăng nhập ngay đi! </h2>\n");
      out.write("        <div class=\"container\" id=\"container\">\n");
      out.write("            <div class=\"form-container sign-up-container\">\n");
      out.write("                <form action=\"RegisterCustomerController\" method=\"post\">\n");
      out.write("                    <h1>Create Account</h1>\n");
      out.write("                    <div class=\"social-container\">\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <span>or use your email for registration</span>\n");
      out.write("                    <input type=\"text\" placeholder=\"Account\" name=\"user_name\" required=\"true\" />\n");
      out.write("                    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("                    <input type=\"password\" name=\"password\" placeholder=\"Password\" required=\"true\" />\n");
      out.write("                    <input type=\"password\" name=\"Re-password\" placeholder=\"Re-password\" required=\"true\" />\n");
      out.write("                    <button type=\"submit\">Sign Up</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div  class=\"form-container sign-in-container\">  <!-- dang nhap -->\n");
      out.write("                <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <div style=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                </c:if>\n");
      out.write("                <form action=\"Login\" method=\"post\">\n");
      out.write("                    <h1>Sign in</h1>\n");
      out.write("                    <div class=\"social-container\">\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <span>or use your account</span>\n");
      out.write("                    <input type=\"text\" placeholder=\"Account\" name=\"user\" />\n");
      out.write("                    <input type=\"password\" placeholder=\"Password\" name=\"pass\" />\n");
      out.write("                    <a href=\"ForgotPass.jsp\">Forgot your password?</a>\n");
      out.write("                    <button type=\"submit\">Sign In</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"overlay-container\">\n");
      out.write("                <div class=\"overlay\">\n");
      out.write("                    <div class=\"overlay-panel overlay-left\">\n");
      out.write("                        <h1>Welcome Back!</h1>\n");
      out.write("                        <p>To keep connected with us please login with your personal info</p>\n");
      out.write("                        <button class=\"ghost\" id=\"signIn\">Sign In</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"overlay-panel overlay-right\">\n");
      out.write("                        <h1>Hello, Friend!</h1>\n");
      out.write("                        <p>Enter your personal details and start journey with us</p>\n");
      out.write("                        <button class=\"ghost\" id=\"signUp\">Sign Up</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <p>\n");
      out.write("                Created with <i class=\"fa fa-heart\"></i> by\n");
      out.write("                <a target=\"_blank\" href=\"https://www.facebook.com/profile.php?id=100006695251254\">Nhật Minh</a>\n");
      out.write("                - Read how I created this and how you can join the challenge\n");
      out.write("                <a target=\"_blank\" href=\"https://www.facebook.com/tien.ta.311\">here</a>.\n");
      out.write("            </p>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            const signUpButton = document.getElementById('signUp');\n");
      out.write("            const signInButton = document.getElementById('signIn');\n");
      out.write("            const container = document.getElementById('container');\n");
      out.write("\n");
      out.write("            signUpButton.addEventListener('click', () => {\n");
      out.write("                container.classList.add(\"right-panel-active\");\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            signInButton.addEventListener('click', () => {\n");
      out.write("                container.classList.remove(\"right-panel-active\");\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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
