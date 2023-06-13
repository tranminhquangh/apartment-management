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
import sample.contracts.ContractDAO;
import sample.contracts.ContractDTO;
import sample.rooms.RoomDAO;
import sample.rooms.RoomDTO;

/**
 *
 * @author tranp
 */
@WebServlet(name = "SellRoomController", urlPatterns = {"/SellRoomController"})
public class SellRoomController extends HttpServlet {

    private static String ERROR="seller_apartment_detail.jsp";
    private static String SUCCESS="seller_apartment_detail.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            
            String contractID = request.getParameter("contractID");
            String roomSellStatus = request.getParameter("roomSellStatus");
            //room
            RoomDTO room = new RoomDTO();
            RoomDAO roomDao = new RoomDAO();
            
            //when Sell is pressed, system updates room and displays on Buyer's webpage
            if(roomSellStatus.equals("Haven't been sold")){
                boolean check=roomDao.updateRoomSellStatus(contractID);
                if(check){
                    request.setAttribute("MESSAGE", "Successfuly!");
                    SUCCESS="MainController?action=ViewRoom&contractID&search="+contractID;
                    url=SUCCESS;
                }
            } else {
                request.setAttribute("MESSAGE", "You already sold this room!");
                ERROR="MainController?action=ViewRoom&contractID&search="+contractID;
                url=ERROR;
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
