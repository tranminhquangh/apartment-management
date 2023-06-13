/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "FilterRoomController", urlPatterns = {"/FilterRoomController"})
public class FilterRoomController extends HttpServlet {

    private static final String ERROR_GS = "buyer_test.jsp";
    private static final String ERROR_SL = "seller_test.jsp";
    private static final String SUCCESS_GS = "home.jsp";
    private static final String SUCCESS_SL = "seller_test.jsp";
    private static final String GS = "GS";
    private static final String SL = "SL";

    //buyer
    private String getFilterListByBuilding(HttpServletRequest request, String buildingID) throws SQLException {
        String url = ERROR_GS;
        RoomDAO dao = new RoomDAO();

        List<RoomDTO> listRoom = dao.filterListRoomByBuilding(buildingID);
        if (listRoom.size() > 0) {
            request.setAttribute("ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
            url = SUCCESS_GS;
        } else {
            url = ERROR_GS;
        }

        return url;
    }

    private String getFilterListByPrice(HttpServletRequest request, String priceRange) throws SQLException {
        String url = ERROR_GS;
        RoomDAO dao = new RoomDAO();

        float min;
        float max;
        if (priceRange.equals("Low")) {
            min = 0;
            max = 1000;
            List<RoomDTO> listRoom = dao.filterListRoomByPrice(min, max);
            if (listRoom.size() > 0) {
                request.setAttribute("ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                url = SUCCESS_GS;
            } else {
                url = ERROR_GS;
            }
        } else if (priceRange.equals("Mid")) {
            min = 1000;
            max = 1000000;
            List<RoomDTO> listRoom = dao.filterListRoomByPrice(min, max);
            if (listRoom.size() > 0) {
                request.setAttribute("ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                url = SUCCESS_GS;
            } else {
                url = ERROR_GS;
            }
        } else if (priceRange.equals("High")) {
            min = 1000000;
            max = 2000000000;
            List<RoomDTO> listRoom = dao.filterListRoomByPrice(min, max);
            if (listRoom.size() > 0) {
                request.setAttribute("ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                url = SUCCESS_GS;
            } else {
                url = ERROR_GS;
            }
        }

        return url;
    }

    private String getFilterListByType(HttpServletRequest request, String roomType) throws SQLException {
        String url = ERROR_GS;
        RoomDAO dao = new RoomDAO();

        List<RoomDTO> listRoom = dao.filterListRoomByType(roomType);
        if (listRoom.size() > 0) {
            request.setAttribute("ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
            url = SUCCESS_GS;
        } else {
            url = ERROR_GS;
        }

        return url;
    }
    
    //seller
    private String getSellerFilterListByBuilding(HttpServletRequest request, String buildingID, String userName) throws SQLException {
        String url = ERROR_SL;
        RoomDAO dao = new RoomDAO();

        List<RoomDTO> listRoom = dao.filterListRoomByBuilding(buildingID);
        if (listRoom.size() > 0) {
            request.setAttribute("EMPTY_ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
            url = SUCCESS_SL;
        } else {
            url = ERROR_SL;
        }

        return url;
    }

    private String getSellerFilterListByPrice(HttpServletRequest request, String priceRange,String userName) throws SQLException {
        String url = ERROR_SL;
        RoomDAO dao = new RoomDAO();

        float min;
        float max;
        if (priceRange.equals("Low")) {
            min = 0;
            max = 1000;
            List<RoomDTO> listRoom = dao.filterListEmptyRoomByPrice(min, max, userName);
            if (listRoom.size() > 0) {
                request.setAttribute("EMPTY_ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                url = SUCCESS_SL;
            } else {
                url = ERROR_SL;
            }
        } else if (priceRange.equals("Mid")) {
            min = 1000;
            max = 1000000;
            List<RoomDTO> listRoom = dao.filterListEmptyRoomByPrice(min, max, userName);
            if (listRoom.size() > 0) {
                request.setAttribute("EMPTY_ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                url = SUCCESS_SL;
            } else {
                url = ERROR_SL;
            }
        } else if (priceRange.equals("High")) {
            min = 1000000;
            max = 2000000000;
            List<RoomDTO> listRoom = dao.filterListEmptyRoomByPrice(min, max, userName);
            if (listRoom.size() > 0) {
                request.setAttribute("EMPTY_ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
                url = SUCCESS_SL;
            } else {
                url = ERROR_SL;
            }
        }

        return url;
    }
    
    private String getSellerFilterListByType(HttpServletRequest request, String roomType, String userName) throws SQLException {
        String url = ERROR_SL;
        RoomDAO dao = new RoomDAO();

        List<RoomDTO> listRoom = dao.filterListEmptyRoomByType(roomType, userName);
        if (listRoom.size() > 0) {
            request.setAttribute("EMPTY_ROOM_LIST_SEARCH", listRoom); //a whole list of searched user
            url = SUCCESS_SL;
        } else {
            url = ERROR_SL;
        }

        return url;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR_GS;
        try {
            String buildingID = request.getParameter("buildingID");
            String priceRange = request.getParameter("priceRange");
            String roomType = request.getParameter("roomType");

            HttpSession session = request.getSession();
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (loginAccount == null) {
                if (buildingID != null) {
                    url = getFilterListByBuilding(request, buildingID);
                } else if (priceRange != null) {
                    url = getFilterListByPrice(request, priceRange);
                } else if (roomType != null) {
                    url = getFilterListByType(request, roomType);
                }

            } else {

                String roleID = loginAccount.getRoleID();
                String userName = loginAccount.getUsername();

                if (GS.equals(roleID)) {
                    if (buildingID != null) {
                        url = getFilterListByBuilding(request, buildingID);
                    } else if (priceRange != null) {
                        url = getFilterListByPrice(request, priceRange);
                    } else if (roomType != null) {
                        url = getFilterListByType(request, roomType);
                    }
                } else if (SL.equals(roleID)) {
                    if (buildingID != null) {
                        url = getSellerFilterListByBuilding(request, buildingID, userName);
                    } else if (priceRange != null) {
                        url = getSellerFilterListByPrice(request, priceRange, userName);
                    } else if (roomType != null) {
                        url = getSellerFilterListByType(request, roomType, userName);
                    }
                }

            }

        } catch (Exception e) {
            log("Error at Search Room Controller: " + e.toString());
        } finally {
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
