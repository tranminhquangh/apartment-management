/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import sample.accounts.AccountDAO;
import sample.users.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.accounts.AccountDTO;
import sample.users.UserDAO;

/**
 *
 * @author KN
 */
public class LoginUserController extends HttpServlet {
    private static String ERROR="error.jsp";
    private static final String GS="GS";
    private static String GUEST_PAGE="/MainController?action=Find&searchRoom=";
    private static final String SL="SL";
    private static String SELL_PAGE="/MainController?action=Find&searchRoom=";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try  {
            String userName = request.getParameter("userName1"); //param userid is still there 
            String password = request.getParameter("password1"); //param password is still there
            
            AccountDAO accDao = new AccountDAO();
            AccountDTO loginAccount = accDao.checkLogin(userName, password);
            
            UserDAO usrDao = new UserDAO();
            UserDTO loginUser = usrDao.getUserInfo(userName);
            //reCaptcha
            String gRecaptchaResponse = request
				.getParameter("g-recaptcha-response");
		System.out.println(gRecaptchaResponse);
		
            if(loginAccount!=null && loginUser!=null ){
                HttpSession session=request.getSession(); 
                String roleID=loginAccount.getRoleID();
                String contractID = (String) session.getAttribute("CONTRACT_ID");
                if(GS.equals(roleID)){
                    session.setAttribute("LOGIN_ACCOUNT", loginAccount); 
                    session.setAttribute("USER_INFO", loginUser);
                    if(contractID!=null){
                        GUEST_PAGE = "MainController?action=ViewRoom&contractID="+contractID; 
                        url=GUEST_PAGE;
                    }else{
                        url=GUEST_PAGE;
                    }
                    
                    session.removeAttribute("CONTRACT_ID");
                }else if(SL.equals(roleID)){
                     session.setAttribute("LOGIN_ACCOUNT", loginAccount); 
                     session.setAttribute("USER_INFO", loginUser);
                     url=SELL_PAGE;
                     
                     
                  
                    
                }else{
                    request.setAttribute("ERROR", "Please try login again!"); //used in login.jsp
                }

            }else{
                request.setAttribute("ERROR", "Incorrect User Name or Password"); //used in login.jsp
                // co 3 param, 1 ERROR attribute
            }
            
        }catch(Exception e){
            log("Exception at LoginController: "+e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response); //the old param will still be there
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
