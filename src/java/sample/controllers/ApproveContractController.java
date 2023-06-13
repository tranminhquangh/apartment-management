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
import sample.contracts.ContractDAO;
import sample.contracts.ContractDTO;
import sample.rooms.RoomDAO;
import sample.rooms.RoomDTO;

/**
 *
 * @author tranp
 */
@WebServlet(name = "ApproveContractController", urlPatterns = {"/ApproveContractController"})
public class ApproveContractController extends HttpServlet {

    private static final String ERROR="employee_contract_list.jsp";
    private static String SUCCESS="MainController?action=Search&search=";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {

            //String search = request.getParameter("search");
            String contractID = request.getParameter("contractID");

            ContractDAO contractDao=new ContractDAO();
            boolean check=contractDao.approveContract(contractID);
            
             //room
            RoomDTO room = new RoomDTO();
            RoomDAO roomDao = new RoomDAO();
            
            boolean checkRoomSellStatus = roomDao.updateRoomSellStatus(contractID);
            boolean checkRoomStatus = roomDao.updateRoomStatus(contractID);
            if(check){
                request.setAttribute("MESSAGE", "Successfuly!");
                //SUCCESS="MainController?action=AdminSearch&search="+search;
                url=SUCCESS;
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
