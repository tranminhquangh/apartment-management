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
import sample.users.UserDAO;
import sample.users.UserDTO;

/**
 *
 * @author tranp
 */
@WebServlet(name = "ViewUserController", urlPatterns = {"/ViewUserController"})
public class ViewUserController extends HttpServlet {

    private static final String AD="AD";
    private static final String US="US";
    private static final String GS="GS";
    private static final String SL="SL";   
    
    private static final String ERROR_AD="admin_info_test.jsp";
    private static final String ERROR_US="employee_info_test.jsp";
    private static final String ERROR_GS="buyer_info_test.jsp";
    private static final String ERROR_SL="seller_info_test.jsp";
    
    private static final String SUCCESS_AD="admin_info_test.jsp";
    private static final String SUCCESS_US="employee_info_test.jsp";
    private static final String SUCCESS_GS="buyer_info_test.jsp";
    private static final String SUCCESS_SL="seller_info_test.jsp";
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR_AD;
        try{
           String userName = request.getParameter("userName");
           UserDAO dao = new UserDAO();
           UserDTO user = dao.getUserInfo(userName);
           
           if(user!=null){
               request.setAttribute("DETAIL_USER", user); 
               url=SUCCESS_AD;
           }
        }catch(Exception e){
            log("Error at Search Controller: "+e.toString());
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
