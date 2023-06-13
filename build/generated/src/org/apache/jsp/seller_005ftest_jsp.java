package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import sample.rooms.RoomDTO;

public final class seller_005ftest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("          <link href=\"https://fonts.googleapis.com/css?family=Poppins\" rel=\"stylesheet\" />\r\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Hello World!</h1>\r\n");
      out.write("        \r\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("         ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write(" <div class=\"s131\">\r\n");
      out.write("      <form action=\"MainController\">\r\n");
      out.write("           <input type=\"text\" name=\"searchRoom\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.searchRoom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/> \r\n");
      out.write("                <input type=\"submit\" name=\"action\" value=\"Find\"/>\r\n");
      out.write("        <div class=\"inner-form\">\r\n");
      out.write("          <div class=\"input-field first-wrap\">\r\n");
      out.write("            <input id=\"search\" type=\"text\" placeholder=\"What are you looking for?\" />\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"input-field second-wrap\">\r\n");
      out.write("            <div class=\"input-select\">\r\n");
      out.write("                <select id=\"sample-select\" data-trigger=\"\" name=\"choices-single-defaul\">\r\n");
      out.write("                <option>CATEGORY</option>\r\n");
      out.write("                <option value=\"MainController?action=Filter&buildingID=1\">Block A</option>\r\n");
      out.write("                <option> <a href=\"MainController?action=Filter&buildingID=2\">Block B</a></option>\r\n");
      out.write("                <option>Subject C</option>\r\n");
      out.write("              </select>\r\n");
      out.write("                <a href=\"MainController?action=Filter&buildingID=1\">Block A</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"input-field third-wrap\">\r\n");
      out.write("            <button class=\"btn-search\" type=\"button\">SEARCH</button>\r\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Filter\"/></br></br>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("        <div class=\"searchBar\">\r\n");
      out.write("            <form action=\"MainController\">\r\n");
      out.write("                <input type=\"text\" name=\"searchRoom\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.searchRoom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/> \r\n");
      out.write("                <input type=\"submit\" name=\"action\" value=\"Find\"/>\r\n");
      out.write("                </br>\r\n");
      out.write("                Filter by building :\r\n");
      out.write("                        <a href=\"MainController?action=Filter&buildingID=1\">Block A</a> |\r\n");
      out.write("                        <a href=\"MainController?action=Filter&buildingID=2\">Block B</a> |\r\n");
      out.write("                        <a href=\"MainController?action=Filter&buildingID=3\">Block C</a>\r\n");
      out.write("           \r\n");
      out.write("                </br>\r\n");
      out.write("                Filter by price \r\n");
      out.write("                <a href=\"MainController?action=Filter&priceRange=Low\">Below 1000</a> |\r\n");
      out.write("                <a href=\"MainController?action=Filter&priceRange=Mid\">From 1,000 to 1,000,000</a> |      \r\n");
      out.write("                <a href=\"MainController?action=Filter&priceRange=High\">Above 1,000,000</a>           \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </br>\r\n");
      out.write("                Filter by room type :\r\n");
      out.write("                    <a href=\"MainController?action=Filter&roomType=Causal\">Casual</a> |\r\n");
      out.write("                    <a href=\"MainController?action=Filter&roomType=Normal\">Normal</a> |    \r\n");
      out.write("                    <a href=\"MainController?action=Filter&roomType=Deluxe\">Deluxe</a>    \r\n");
      out.write("\r\n");
      out.write("                </br>\r\n");
      out.write("                 <input type=\"submit\" name=\"action\" value=\"Filter\"/></br></br>\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("            </br>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
  String message = (String) request.getAttribute("MESSAGE");
    if (message == null) {
        message = "";
    }

      out.write("\r\n");
      out.write("<div class=\"message\">\r\n");
      out.write("    ");
      out.print( message);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"js/extention/choices.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("      const choices = new Choices('[data-trigger]',\r\n");
      out.write("      {\r\n");
      out.write("        searchEnabled: false\r\n");
      out.write("      });\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(\"select\").click(function() {\r\n");
      out.write("  var open = $(this).data(\"isopen\");\r\n");
      out.write("  if(open) {\r\n");
      out.write("    window.location.href = $(this).val()\r\n");
      out.write("  }\r\n");
      out.write("  //set isopen to opposite so next time when use clicked select box\r\n");
      out.write("  //it wont trigger this event\r\n");
      out.write("  $(this).data(\"isopen\", !open);\r\n");
      out.write("});\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LOGIN_ACCOUNT != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <a href=\"seller_info_test.jsp\">Profile</a>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LOGIN_ACCOUNT == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <a href=\"loginUser.jsp\">Login</a>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.EMPTY_ROOM_LIST_SEARCH !=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            ");
        if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty requestScope.EMPTY_ROOM_LIST_SEARCH }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <table border=\"1\" class=\"tableCenter\">\r\n");
        out.write("                    <thead>\r\n");
        out.write("                        <tr>\r\n");
        out.write("                            <th>Title</th>\r\n");
        out.write("                            <th>Number</th>\r\n");
        out.write("                            <th>Type</th>\r\n");
        out.write("                            <th>Price</th>\r\n");
        out.write("                            <th>Image</th>\r\n");
        out.write("                            <th>Status</th>\r\n");
        out.write("                            <th></th>\r\n");
        out.write("                        </tr>\r\n");
        out.write("                    </thead>\r\n");
        out.write("                    <tbody>\r\n");
        out.write("\r\n");
        out.write("                        ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("            </tbody>\r\n");
        out.write("        </table>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
    _jspx_th_c_forEach_0.setVar("room");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.EMPTY_ROOM_LIST_SEARCH}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("        \r\n");
          out.write("                            <tr>\r\n");
          out.write("                        <form action=\"MainController\" method=\"POST\">    \r\n");
          out.write("                            <td>\r\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                                <input type=\"hidden\" name=\"contractID\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.contractID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"/>\r\n");
          out.write("                            </td>\r\n");
          out.write("                            <td>\r\n");
          out.write("\r\n");
          out.write("                                <a href=\"MainController?action=ViewRoom&contractID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.contractID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </a>  \r\n");
          out.write("\r\n");
          out.write("                            </td>\r\n");
          out.write("                            <td>\r\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                            </td>\r\n");
          out.write("                            <td>\r\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                            </td>\r\n");
          out.write("                            <td>\r\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomImg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" \r\n");
          out.write("                            </td>\r\n");
          out.write("                            <td>\r\n");
          out.write("                                <input type=\"hidden\" name=\"roomSellStatus\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomSellStatus}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"/>\r\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomSellStatus}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("                            </td>\r\n");
          out.write("                            <td>\r\n");
          out.write("                                <input type=\"submit\" name=\"action\" value=\"Sell\"/>\r\n");
          out.write("                                <input type=\"hidden\" name=\"search\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.search}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"/>\r\n");
          out.write("                            </td>\r\n");
          out.write("\r\n");
          out.write("                        </form>         \r\n");
          out.write("                    </tr>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
