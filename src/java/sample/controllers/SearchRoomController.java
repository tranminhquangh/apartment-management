/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "SearchRoomController", urlPatterns = {"/SearchRoomController"})
public class SearchRoomController extends HttpServlet {

    //private static final String ERROR="home.jsp";
    
    //private static final String SUCCESS="home.jsp";
    private static final String ERROR_GS="guest.jsp";
    private static final String ERROR_SL="seller.jsp";
    private static final String ERROR_HƠME="home.jsp";
    private static final String SUCCESS_GS="guest.jsp";
    private static final String SUCCESS_SL="seller.jsp";
    private static final String SUCCESS_HOME="home.jsp";
    
    private static final String GS="GS";
    private static final String SL="SL";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR_GS;
        try{
            String search = request.getParameter("searchRoom");
            HttpSession session = request.getSession();
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if(loginAccount==null){
                RoomDAO dao = new RoomDAO();
                List<RoomDTO> listRoom = dao.getSearchListRoom(search); 
                if(listRoom.size()>0){
                    request.setAttribute("ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                    url=SUCCESS_GS;
                }else{
                    url=ERROR_GS;
                }
            }else{
                
                String roleID=loginAccount.getRoleID();
                String userName = loginAccount.getUsername();

                if(GS.equals(roleID)){
                    RoomDAO dao = new RoomDAO();
                    List<RoomDTO> listRoom = dao.getSearchListRoom(search); 
                    if(listRoom.size()>0){
                        request.setAttribute("ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                        url=SUCCESS_GS;
                    }else{
                        url=ERROR_GS;
                    }      
                }else if(SL.equals(roleID)){
                    RoomDAO dao = new RoomDAO();

                    List<RoomDTO> listRoom = dao.getEmptySearchListRoom(search,userName); 
                    if(listRoom.size()>0){
                        request.setAttribute("EMPTY_ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                        url=SUCCESS_SL;
                    }else{
                        url=ERROR_SL;
                    }
                }
                
            }
            
           
           
        }catch(Exception e){
            log("Error at Search Room Controller: "+e.toString());
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
