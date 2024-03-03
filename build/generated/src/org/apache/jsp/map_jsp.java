package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class map_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>/* \n");
      out.write(" * Always set the map height explicitly to define the size of the div element\n");
      out.write(" * that contains the map. \n");
      out.write(" */\n");
      out.write("            #map {\n");
      out.write("                height: 100%;\n");
      out.write("            }\n");
      out.write("          \n");
      out.write("            html,\n");
      out.write("            body {\n");
      out.write("                height: 100%;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }</style>\n");
      out.write("        <script async\n");
      out.write("                src=\"https://maps.googleapis.com/maps/api/js?key=&loading=async&callback=initMap\">\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"map\"></div>\n");
      out.write("\n");
      out.write("        <!-- prettier-ignore -->\n");
      out.write("        <script>(g => {\n");
      out.write("                var h, a, k, p = \"The Google Maps JavaScript API\", c = \"google\", l = \"importLibrary\", q = \"__ib__\", m = document, b = window;\n");
      out.write("                b = b[c] || (b[c] = {});\n");
      out.write("                var d = b.maps || (b.maps = {}), r = new Set, e = new URLSearchParams, u = () => h || (h = new Promise(async(f, n) => {\n");
      out.write("                        await (a = m.createElement(\"script\"));\n");
      out.write("                        e.set(\"libraries\", [...r] + \"\");\n");
      out.write("                        for (k in g)\n");
      out.write("                            e.set(k.replace(/[A-Z]/g, t => \"_\" + t[0].toLowerCase()), g[k]);\n");
      out.write("                        e.set(\"callback\", c + \".maps.\" + q);\n");
      out.write("                        a.src = `https://maps.");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("apis.com/maps/api/js?` + e;\n");
      out.write("                        d[q] = f;\n");
      out.write("                        a.onerror = () => h = n(Error(p + \" could not load.\"));\n");
      out.write("                        a.nonce = m.querySelector(\"script[nonce]\")?.nonce || \"\";\n");
      out.write("                        m.head.append(a)\n");
      out.write("                    }));\n");
      out.write("                d[l] ? console.warn(p + \" only loads once. Ignoring:\", g) : d[l] = (f, ...n) => r.add(f) && u().then(() => d[l](f, ...n))\n");
      out.write("            })\n");
      out.write("                    ({key: \"AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg\", v: \"weekly\"});</script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<script>\n");
      out.write("    let map;\n");
      out.write("\n");
      out.write("    async function initMap() {\n");
      out.write("        const {Map} = await google.maps.importLibrary(\"maps\");\n");
      out.write("\n");
      out.write("        map = new Map(document.getElementById(\"map\"), {\n");
      out.write("            center: {lat: 21.0278, lng:  105.8342},\n");
      out.write("            zoom: 8,\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    initMap();\n");
      out.write("</script>\n");
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
