/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.accounts.AccountDTO;
import sample.users.UserDAO;
import sample.users.UserDTO;

/**
 *
 * @author tranp
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordController extends HttpServlet {

    private static final String AD="AD";
    private static final String US="US";
    private static final String GS="GS";
    private static final String SL="SL";   
    
    private static final String ERROR_AD="admin_profile_test.jsp";
    private static final String ERROR_US="employee_profile_test.jsp";
    private static final String ERROR_GS="buyer_profile_test.jsp";
    private static final String ERROR_SL="seller_profile_test.jsp";
    
    private static final String SUCCESS_AD="admin_profile_test.jsp";
    private static final String SUCCESS_US="employee_profile_test.jsp";
    private static final String SUCCESS_GS="buyer_profile_test.jsp";
    private static final String SUCCESS_SL="seller_profile_test.jsp";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR_AD;
        try {

            //String search = request.getParameter("search");
            String userName = request.getParameter("userName");
            String fullName = request.getParameter("fullName");
            
            
            HttpSession session = request.getSession();
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            String roleID=loginAccount.getRoleID();
            
            
            UserDTO contract=new UserDTO();
            UserDAO dao=new UserDAO();
            boolean check=dao.updateUser(contract);
            if(check){
                request.setAttribute("MESSAGE", "Successfuly!");
                UserDTO updatedUser = dao.getUserInfo(userName);
                request.setAttribute("DETAIL_USER", updatedUser); 
                if(AD.equals(roleID)){               
                    url=SUCCESS_AD;  
                }else if(US.equals(roleID)){                   
                    url=SUCCESS_US;    
                }else if(GS.equals(roleID)){                  
                    url=SUCCESS_GS;  
                }else if(SL.equals(roleID)){                  
                    url=SUCCESS_SL;
                }
            }else{
                if(AD.equals(roleID)){               
                    url=ERROR_AD;  
                }else if(US.equals(roleID)){                   
                    url=ERROR_US;    
                }else if(GS.equals(roleID)){                  
                    url=ERROR_GS;  
                }else if(SL.equals(roleID)){                  
                    url=ERROR_SL;
                }
            }
           
            
        }catch(Exception e){
            log("Error at Update Controller"+e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
