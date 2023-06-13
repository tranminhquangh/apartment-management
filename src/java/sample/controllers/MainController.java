/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KN
 */
public class MainController extends HttpServlet {

    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGIN1 = "Login1";
    private static final String LOGIN_CONTROLLER1 = "LoginUserController";
    private static final String USER_VIEW = "View Profile";
    private static final String USER_VIEW_CONTROLLER = "ViewUserController";
    private static final String USER_UPDATE = "Update";
    private static final String USER_UPDATE_CONTROLLER = "UpdateUserController";
    private static final String CHANGE_PASSWORD = "Change Password";
    private static final String CHANGE_PASSWORD_CONTROLLER = "ChangePasswordController";
    private static final String SIGN_UP = "signup";
    private static final String SIGN_UP_CONTROLLER = "SignUpController";
    private static final String SIGN_UP_USER = "signupuser";
    private static final String SIGN_UP_USER_CONTROLLER = "SignUpUserController";


    
    //for Admin
    private static final String CONTRACT_SEARCH = "Search";
    private static final String CONTRACT_SEARCH_CONTROLLER = "SearchContractController";
    private static final String CONTRACT_VIEW = "View";
    private static final String CONTRACT_VIEW_CONTROLLER = "ViewContractController";
    private static final String CONTRACT_EDIT_VIEW = "Edit";
    private static final String CONTRACT_EDIT_VIEW_CONTROLLER = "ViewEditContractController";
    private static final String CONTRACT_UPDATE = "Save";
    private static final String CONTRACT_UPDATE_CONTROLLER = "UpdateContractController";
    private static final String CONTRACT_REMOVE = "Remove";
    private static final String CONTRACT_REMOVE_CONTROLLER = "RemoveContractController";
    private static final String CONTRACT_APPROVE = "Approve";
    private static final String CONTRACT_APPROVE_CONTROLLER = "ApproveContractController";
    
    //for customer (both Buyer & Seller)
    private static final String DISPLAY = "Building";
    private static final String DISPLAY_CONTROLLER = "BuildingController";
    private static final String SEARCH_ROOM = "Find";
    private static final String SEARCH_ROOM_CONTROLLER = "SearchRoomController";
    private static final String VIEW_ROOM = "ViewRoom";
    private static final String VIEW_ROOM_CONTROLLER = "ViewRoomController";
    private static final String FILTER_ROOM = "Filter";
    private static final String FILTER_ROOM_CONTROLLER = "FilterRoomController";
    
    //for Seller
    private static final String EDIT_ROOM = "Save info";
    private static final String EDIT_ROOM_CONTROLLER = "EditRoomController";
    private static final String SELL_ROOM = "Sell";
    private static final String SELL_ROOM_CONTROLLER = "SellRoomController";
    
     //for Buyer
    private static final String BUY_ROOM = "Buy";
    private static final String BUY_ROOM_CONTROLLER = "BuyRoomController";
    
    //for Both
    private static final String SIGN_CONTRACT = "Sign";
    private static final String SIGN_CONTRACT_CONTROLLER = "SignContractController";
    private static final String CANCELL_CONTRACT = "Cancell";
    private static final String CANCELL_CONTRACT_CONTROLLER = "CancellContractController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (LOGIN1.equals(action)) {
                url = LOGIN_CONTROLLER1;
            } else if(LOGOUT.equals(action)){
                url=LOGOUT_CONTROLLER;
            } else if (SIGN_UP.equals(action)) {
                url = SIGN_UP_CONTROLLER;
            } else if (SIGN_UP_USER.equals(action)) {
                url = SIGN_UP_USER_CONTROLLER;
            } 
            //for User profile
            else if(USER_VIEW.equals(action)){
                url=USER_VIEW_CONTROLLER;
            }else if(USER_UPDATE.equals(action)){
                url=USER_UPDATE_CONTROLLER;
            }else if(CHANGE_PASSWORD.equals(action)){
                url=CHANGE_PASSWORD_CONTROLLER;
            }          
            //for Contract
            else if (CONTRACT_SEARCH.equals(action)) {
                url = CONTRACT_SEARCH_CONTROLLER;
            } else if (CONTRACT_VIEW.equals(action)) {
                url = CONTRACT_VIEW_CONTROLLER;
            } else if (CONTRACT_EDIT_VIEW.equals(action)) {
                url = CONTRACT_EDIT_VIEW_CONTROLLER;
            } else if (CONTRACT_UPDATE.equals(action)) {
                url = CONTRACT_UPDATE_CONTROLLER;
            } else if (CONTRACT_REMOVE.equals(action)) {
                url = CONTRACT_REMOVE_CONTROLLER;
            } else if (CONTRACT_APPROVE.equals(action)) {
                url = CONTRACT_APPROVE_CONTROLLER;
            } //for customer
            else if (DISPLAY.equals(action)) {
                url = DISPLAY_CONTROLLER;
            } else if (SEARCH_ROOM.equals(action)) {
                url = SEARCH_ROOM_CONTROLLER;
            } else if(VIEW_ROOM.equals(action)){
                url = VIEW_ROOM_CONTROLLER;
            } else if(FILTER_ROOM.equals(action)){
                url = FILTER_ROOM_CONTROLLER;
            }
            //for Seller
            else if (EDIT_ROOM.equals(action)) {
                url = EDIT_ROOM_CONTROLLER;
            } else if (SELL_ROOM.equals(action)) {
                url = SELL_ROOM_CONTROLLER;
            }
            //for Buyer
            else if(BUY_ROOM.equals(action)){
                url = BUY_ROOM_CONTROLLER;
            }
          
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
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
