package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.users.UserDTO;
import sample.accounts.AccountDTO;
import java.util.List;
import sample.rooms.RoomDTO;

public final class buyer_005ftest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Hello World!</h1>\r\n");
      out.write("\r\n");
      out.write("               \r\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("   \r\n");
      out.write("        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("     \r\n");
      out.write("\r\n");
      out.write("        </br>\r\n");
      out.write("       \r\n");
      out.write("         ");

            
            
            String search=request.getParameter("search");
                if(search==null){
                    search="";
                }
                
        
      out.write("\r\n");
      out.write("        <div class=\"searchBar\">\r\n");
      out.write("            <form action=\"MainController\">\r\n");
      out.write("                <input type=\"text\" name=\"searchRoom\" placeholder=\"Search\" required=\"\" value=\"");
      out.print( search);
      out.write("\"/> \r\n");
      out.write("                <input type=\"submit\" name=\"action\" value=\"Find\"/></br></br>\r\n");
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
      out.write("                <input type=\"submit\" name=\"action\" value=\"Filter\"/></br></br>\r\n");
      out.write("                \r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("            </br>\r\n");
      out.write("        </div>\r\n");
      out.write("       ");


            List<RoomDTO> listRoom=(List<RoomDTO>)request.getAttribute("ROOM_LIST_SEARCH");
            if(listRoom!=null){
                if(listRoom.size()>0){
        
      out.write("\r\n");
      out.write("                <table border=\"1\" class=\"tableCenter\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Title</th>\r\n");
      out.write("                        <th>Number</th>\r\n");
      out.write("                        <th>Type</th>\r\n");
      out.write("                        <th>Price</th>\r\n");
      out.write("                        <th>Image</th>\r\n");
      out.write("                        <th></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    ");

                       
                        int count=1;
                        for(RoomDTO room:listRoom){
                            
                            
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                    <form action=\"MainController\" method=\"POST\">    \r\n");
      out.write("                        <td>\r\n");
      out.write("                             ");
      out.print( room.getRoomTitle() );
      out.write("\r\n");
      out.write("                            <input type=\"hidden\" name=\"contractID\" value=\"");
      out.print(room.getContractID());
      out.write("\"/>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <a href=\"MainController?action=ViewRoom&contractID=");
      out.print(room.getContractID());
      out.write('"');
      out.write('>');
      out.print( room.getRoomNumber() );
      out.write(" </a>  \r\n");
      out.write("                              \r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print( room.getRoomType() );
      out.write("   \r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print( room.getRoomPrice() );
      out.write("   \r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print( room.getRoomImg() );
      out.write("   \r\n");
      out.write("                        </td>\r\n");
      out.write("                        \r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"submit\" name=\"action\" value=\"ViewRoom\"/>\r\n");
      out.write("                            <input type=\"hidden\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"/>\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("                    </form>         \r\n");
      out.write("                    </tr>\r\n");
      out.write("   \r\n");
      out.write("                    ");
        
                        }
                    
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        ");
    
                }
            }
                
        
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
        out.write("            <a href=\"buyer_info_test.jsp\">Profile</a>\r\n");
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
}
