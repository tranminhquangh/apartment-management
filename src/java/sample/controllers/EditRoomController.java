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
import sample.rooms.RoomDAO;
import sample.rooms.RoomDTO;


/**
 *
 * @author tranp
 */
@WebServlet(name = "EditRoomController", urlPatterns = {"/EditRoomController"})
public class EditRoomController extends HttpServlet {

    private static String ERROR="seller_room_test.jsp";
    private static String SUCCESS="seller_room_test.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {

            //String search = request.getParameter("search");
            String contractID = request.getParameter("contractID");
            //for old info
            String roomNumber = request.getParameter("roomNumber");
            String roomType = request.getParameter("roomType");
            String roomSize = request.getParameter("roomType");
            String roomImg = request.getParameter("roomImg");
            String BuildingID = request.getParameter("buildingID");
            String roomSellStatus = request.getParameter("roomSellStatus");
            //for new edit
            String roomTitle = request.getParameter("roomTitle");
            float roomPrice = Float.parseFloat(request.getParameter("roomPrice"));
            String roomDescription = request.getParameter("roomDescription");
            
            
            RoomDTO room = new RoomDTO(contractID,roomTitle,roomNumber,roomType,roomPrice,roomSize,roomImg,BuildingID,false,roomDescription,roomSellStatus);
            RoomDAO dao=new RoomDAO();
            boolean check=dao.editEmptyRoom(room);

            if(check){
                request.setAttribute("MESSAGE", "Successfuly!");
                RoomDTO updatedRoom = dao.getEmptyRoomDetail(contractID);
                request.setAttribute("DETAIL_ROOM", updatedRoom); 
                SUCCESS="MainController?action=ViewRoom&contractID="+contractID;   
                url=SUCCESS;
            }else{
                ERROR="MainController?action=ViewRoom&contractID="+contractID;
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
