package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.rooms.RoomDTO;
import sample.buildings.BuildingDTO;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Apart &mdash; Colorlib Website Template</title>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900|Oswald:400,700\"> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\"> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js\"> \r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"> \r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/icomoon/style.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/mediaelementplayer.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/animate.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/flaticon/font/flaticon.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/fl-bigmug-line.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/aos.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Poppins\" rel=\"stylesheet\" />\r\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");


            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"site-wrap\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"site-navbar mt-4\">\r\n");
      out.write("                <div class=\"container py-1\">\r\n");
      out.write("                    <div class=\"row align-items-center\">\r\n");
      out.write("                        <div class=\"col-8 col-md-8 col-lg-4\">\r\n");
      out.write("                            <h1 class=\"mb-0\"><a href=\"index.html\" class=\"text-white h2 mb-0\"><strong>DIPBRO<span class=\"text-primary\">.</span></strong></a></h1>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-4 col-md-4 col-lg-8\">\r\n");
      out.write("                            <nav class=\"site-navigation text-right text-md-right\" role=\"navigation\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"d-inline-block d-lg-none ml-md-0 mr-auto py-3\"><a href=\"#\" class=\"site-menu-toggle js-menu-toggle text-white\"><span class=\"icon-menu h3\"></span></a></div>\r\n");
      out.write("\r\n");
      out.write("                                <ul class=\"site-menu js-clone-nav d-none d-lg-block\">\r\n");
      out.write("                                    <li class=\"active\">\r\n");
      out.write("                                        <a href=\"index.html\">Home</a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <li><a href=\"guest_apartment.jsp\">Apartments</a></li>\r\n");
      out.write("                                    <li class=\"has-children\">\r\n");
      out.write("                                        <a href=\"apartments.html\">Login &nbsp; &nbsp;</a>\r\n");
      out.write("                                        <ul class=\"dropdown arrow-top\">\r\n");
      out.write("\r\n");
      out.write("                                            <li><a href=\"login.jsp\">Login Admin</a></li>\r\n");
      out.write("                                            <li><a href=\"loginUser.jsp\">Login Guest</a></li>\r\n");
      out.write("\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </nav>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"site-mobile-menu\">\r\n");
      out.write("            <div class=\"site-mobile-menu-header\">\r\n");
      out.write("                <div class=\"site-mobile-menu-close mt-3\">\r\n");
      out.write("                    <span class=\"icon-close2 js-menu-toggle\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"site-mobile-menu-body\"></div>\r\n");
      out.write("        </div> <!-- .site-mobile-menu -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"site-blocks-cover overlay\" style=\"background-image: url('https://wallpaperaccess.com/full/1408504.jpg');\" data-aos=\"fade\" data-stellar-background-ratio=\"0.5\" data-aos=\"fade\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row align-items-center justify-content-center\">\r\n");
      out.write("                    <div class=\"col-md-8 text-center\" data-aos=\"fade-up\" data-aos-delay=\"400\" style=\"padding-top: 300px\">\r\n");
      out.write("                        <h1 class=\"mb-4\">Excellent Space For Your Next Home</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <p><a href=\"#\" class=\"btn btn-primary px-5 py-3\" style=\"background-color:  #6777ef;border-color:  #6777ef\">Take a Tour</a></p>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"s131\" >\r\n");
      out.write("                            <form action=\"MainController\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"inner-form\">\r\n");
      out.write("                                    <div class=\"input-field first-wrap\">\r\n");
      out.write("                                        <input name=\"searchRoom\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.searchRoom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"search\" type=\"text\" placeholder=\"What are you looking for?\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"input-field second-wrap\"  >\r\n");
      out.write("                                        <div class=\"input-select\">\r\n");
      out.write("                                            <select  id=\"sampleSelect\" onchange=\"location = this.value;\" data-trigger=\"\" name=\"choices-single-defaul\">\r\n");
      out.write("                                                <option>Building</option>\r\n");
      out.write("                                                <option value=\"MainController?action=Filter&buildingID=1\"> Block A</option>\r\n");
      out.write("                                                <option value=\"MainController?action=Filter&buildingID=2\"> Block B</a></option>\r\n");
      out.write("                                                <option value=\"MainController?action=Filter&buildingID=3\"> Block C</option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                            \r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                         \r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"input-field third-wrap\">\r\n");
      out.write("                                        <button class=\"btn-search\" type=\"submit\" name=\"action\" value=\"Find\" style=\"background-color:  #6777ef;border-color:  #6777ef\">SEARCH</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"site-section\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"site-section-heading text-center mb-5 w-border col-md-6 mx-auto\">\r\n");
      out.write("                        <h2 class=\"mb-5\">Browse Apartments</h2>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-12 text-center mt-5\" data-aos=\"fade-up\">\r\n");
      out.write("                    <a href=\"#\" class=\"btn btn-primary\" style=\" background-color:  #6777ef;border-color: #6777ef\">Browse All Apartments</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"site-section\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"site-section-heading text-center mb-5 w-border col-md-6 mx-auto\" data-aos=\"fade-up\">\r\n");
      out.write("                    <h2 class=\"mb-5\">Featured Apartments</h2>\r\n");
      out.write("                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eveniet, fugit nam obcaecati fuga itaque deserunt officia, error reiciendis ab quod?</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"site-block-retro d-block d-md-flex\">\r\n");
      out.write("\r\n");
      out.write("                <a href=\"#\" class=\"col1 unit-9 no-height\" data-aos=\"fade-up\" data-aos-delay=\"100\">\r\n");
      out.write("                    <div class=\"image\" style=\"background-image: url('images/img_2.jpg');\">\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"unit-9-content\">\r\n");
      out.write("                        <h2>Baltimore Apartment</h2>\r\n");
      out.write("                        <span>$600/night</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </a>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col2 ml-auto\">\r\n");
      out.write("\r\n");
      out.write("                    <a href=\"#\" class=\"col2-row1 unit-9 no-height\" data-aos=\"fade-up\" data-aos-delay=\"200\">\r\n");
      out.write("                        <div class=\"image\" style=\"background-image: url('images/img_3.jpg');\"></div>\r\n");
      out.write("                        <div class=\"unit-9-content\">\r\n");
      out.write("                            <h2>Austin Apartment</h2>\r\n");
      out.write("                            <span>$290/night</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("\r\n");
      out.write("                    <a href=\"#\" class=\"col2-row2 unit-9 no-height\" data-aos=\"fade-up\" data-aos-delay=\"300\">\r\n");
      out.write("                        <div class=\"image\" style=\"background-image: url('images/img_1.jpg');\"></div>\r\n");
      out.write("                        <div class=\"unit-9-content\">\r\n");
      out.write("                            <h2>Atlanta Apartment</h2>\r\n");
      out.write("                            <span>$1,290/night</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"bg-primary\" data-aos=\"fade\"style=\"background-color: #6777ef !important;\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <a href=\"#\" class=\"col-2 text-center py-4 social-icon d-block\"><span class=\"icon-facebook text-white\"></span></a>\r\n");
      out.write("                <a href=\"#\" class=\"col-2 text-center py-4 social-icon d-block\"><span class=\"icon-twitter text-white\"></span></a>\r\n");
      out.write("                <a href=\"#\" class=\"col-2 text-center py-4 social-icon d-block\"><span class=\"icon-instagram text-white\"></span></a>\r\n");
      out.write("                <a href=\"#\" class=\"col-2 text-center py-4 social-icon d-block\"><span class=\"icon-linkedin text-white\"></span></a>\r\n");
      out.write("                <a href=\"#\" class=\"col-2 text-center py-4 social-icon d-block\"><span class=\"icon-pinterest text-white\"></span></a>\r\n");
      out.write("                <a href=\"#\" class=\"col-2 text-center py-4 social-icon d-block\"><span class=\"icon-youtube text-white\"></span></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <footer class=\"site-footer\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-4\">\r\n");
      out.write("                    <div class=\"mb-5\">\r\n");
      out.write("                        <h3 class=\"footer-heading mb-4\">About Apart</h3>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe pariatur reprehenderit vero atque, consequatur id ratione, et non dignissimos culpa? Ut veritatis, quos illum totam quis blanditiis, minima minus odio!</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"mb-5\">\r\n");
      out.write("                        <h3 class=\"footer-heading mb-4\">Subscribe</h3>\r\n");
      out.write("                        <form action=\"#\" method=\"post\" class=\"site-block-subscribe\">\r\n");
      out.write("                            <div class=\"input-group mb-3\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control border-secondary bg-transparent\" placeholder=\"Enter your email\"\r\n");
      out.write("                                       aria-label=\"Enter Email\" aria-describedby=\"button-addon2\">\r\n");
      out.write("                                <div class=\"input-group-append\">\r\n");
      out.write("                                    <button class=\"btn btn-primary rounded-top-right-0\" type=\"button\" id=\"button-addon2\">Subscribe</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 mb-5 mb-lg-0\">\r\n");
      out.write("                    <div class=\"row mb-5\">\r\n");
      out.write("                        <div class=\"col-md-12\">\r\n");
      out.write("                            <h3 class=\"footer-heading mb-4\">Navigations</h3>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-6 col-lg-6\">\r\n");
      out.write("                            <ul class=\"list-unstyled\">\r\n");
      out.write("                                <li><a href=\"#\">Home</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Apartments</a></li>\r\n");
      out.write("                                <li><a href=\"#\">News</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Featured Apartment</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-6 col-lg-6\">\r\n");
      out.write("                            <ul class=\"list-unstyled\">\r\n");
      out.write("                                <li><a href=\"#\">About Us</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Privacy Policy</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Membership</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-12\">\r\n");
      out.write("                            <h3 class=\"footer-heading mb-4\">Follow Us</h3>\r\n");
      out.write("\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <a href=\"#\" class=\"pl-0 pr-3\"><span class=\"icon-facebook\"></span></a>\r\n");
      out.write("                                <a href=\"#\" class=\"pl-3 pr-3\"><span class=\"icon-twitter\"></span></a>\r\n");
      out.write("                                <a href=\"#\" class=\"pl-3 pr-3\"><span class=\"icon-instagram\"></span></a>\r\n");
      out.write("                                <a href=\"#\" class=\"pl-3 pr-3\"><span class=\"icon-linkedin\"></span></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-lg-4 mb-5 mb-lg-0\">\r\n");
      out.write("                    <div class=\"mb-5\">\r\n");
      out.write("                        <h3 class=\"footer-heading mb-4\">Watch Live Streaming</h3>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"block-16\">\r\n");
      out.write("                            <figure>\r\n");
      out.write("                                <img src=\"images/img_1.jpg\" alt=\"Image placeholder\" class=\"img-fluid rounded\">\r\n");
      out.write("                                <a href=\"https://vimeo.com/channels/staffpicks/93951774\" class=\"play-button popup-vimeo\"><span class=\"icon-play\"></span></a>\r\n");
      out.write("                            </figure>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row pt-5 mt-5 text-center\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("                        Copyright &copy;<script data-cfasync=\"false\" src=\"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"icon-heart text-danger\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\" >Group 3</a>\r\n");
      out.write("                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-migrate-3.0.1.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-ui.js\"></script>\r\n");
      out.write("<script src=\"js/popper.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("<script src=\"js/mediaelement-and-player.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.stellar.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.countdown.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap-datepicker.min.js\"></script>\r\n");
      out.write("<script src=\"js/aos.js\"></script>\r\n");
      out.write("<script src=\"js/circleaudioplayer.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/main.js\"></script>\r\n");
      out.write("<script src=\"js/extention/choices.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("                                            const choices = new Choices('[data-trigger]',\r\n");
      out.write("                                                    {\r\n");
      out.write("                                                        searchEnabled: false\r\n");
      out.write("                                                    });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ROOM_LIST_SEARCH !=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                        ");
        if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
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

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty requestScope.ROOM_LIST_SEARCH }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        out.write("                        ");
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

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_forEach_0.setVar("room");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ROOM_LIST_SEARCH}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                <div class=\"col-md-6 col-lg-3\" data-aos=\"fade-up\" data-aos-delay=\"400\">\r\n");
          out.write("                                    <a href=\"MainController?action=ViewRoom&contractID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.contractID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"unit-9\">\r\n");
          out.write("                                        <div class=\"image\" style=\"background-image: url('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomImg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("');\"></div>\r\n");
          out.write("                                        <div class=\"unit-9-content\">\r\n");
          out.write("                                            <h2>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h2>\r\n");
          out.write("                                            <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("$</span>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                    </a>\r\n");
          out.write("                                </div>\r\n");
          out.write("\r\n");
          out.write("                            ");
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
