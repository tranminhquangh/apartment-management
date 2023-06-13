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
import sample.rooms.RoomDAO;
import sample.rooms.RoomDTO;

/**
 *
 * @author tranp
 */
@WebServlet(name = "ViewRoomController", urlPatterns = {"/ViewRoomController"})
public class ViewRoomController extends HttpServlet {

    private static final String ERROR_GS="guest_apartment_detail.jsp";
    private static final String ERROR_SL="seller_apartment_detail.jsp";
    private static final String SUCCESS_GS="guest_apartment_detail.jsp";
    private static final String SUCCESS_SL="seller_apartment_detail.jsp";

    private static final String GS="GS";
    private static final String SL="SL";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR_GS;
        try{
            String id = request.getParameter("contractID");
            HttpSession session = request.getSession();
            
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if(loginAccount==null){
                RoomDAO dao = new RoomDAO();
                RoomDTO room = dao.getRoomDetail(id);

                if(room!=null){
                    request.setAttribute("DETAIL_ROOM", room); 
                    url=SUCCESS_GS;
                }else{
                    url=ERROR_GS;
                }
//                response.sendRedirect("loginUser.jsp");
//                return;
            }
            String roleID=loginAccount.getRoleID();
           
            if(SL.equals(roleID)){
                RoomDAO dao = new RoomDAO();
                RoomDTO room = dao.getEmptyRoomDetail(id);

                if(room!=null){
                    request.setAttribute("DETAIL_ROOM", room); 
                    url=SUCCESS_SL;
                }else{
                    url=ERROR_SL;
                }
            }if(GS.equals(roleID)){
               RoomDAO dao = new RoomDAO();
                RoomDTO room = dao.getRoomDetail(id);

                if(room!=null){
                    request.setAttribute("DETAIL_ROOM", room); 
                    url=SUCCESS_GS;
                }else{
                    url=ERROR_GS;
                }
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
