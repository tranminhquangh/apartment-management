/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "BuyRoomController", urlPatterns = {"/BuyRoomController"})
public class BuyRoomController extends HttpServlet {

  private static String ERROR = "buyer_room_test.jsp";
    private static String SUCCESS = "buyer_room_test.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String contractID = request.getParameter("contractID");
            String roomNumber = request.getParameter("roomNumber");
            HttpSession session = request.getSession();
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (loginAccount == null) {
                session.setAttribute("CONTRACT_ID", contractID);
                url = "loginUser.jsp";
            } else {

                //get Buyer Username
                String buyerUserName = loginAccount.getUsername();

                //CONTRACT
                String newBuyerContractID = "";
                String newSellerContractID = "";
                int newContrNumber = 0;
                String newCreateDate = "";

                //generate ID
                newBuyerContractID = "CONTR" + roomNumber + "GS";
                newSellerContractID = "CONTR" + roomNumber + "SL";
                //generate contr Number
                char buildingA = 'A';
                char buildingB = 'B';
                char buildingC = 'C';
                String asciiA = Integer.toString((int) buildingA);
                String asciiB = Integer.toString((int) buildingB);
                String asciiC = Integer.toString((int) buildingC);

                String tempRoomNumber;
                String numberStr;
                //check the room number string
                if (roomNumber.contains("A")) {
                    numberStr = roomNumber.replace("A", "");
                    if (numberStr.length() == 1) {
                        numberStr = "0" + numberStr;
                    }
                    tempRoomNumber = asciiA + numberStr;
                    newContrNumber = Integer.parseInt(tempRoomNumber);
                } else if (roomNumber.contains("B")) {
                    numberStr = roomNumber.replace("B", "");
                    if (numberStr.length() == 1) {
                        numberStr = "0" + numberStr;
                    }
                    tempRoomNumber = asciiB + numberStr;
                    newContrNumber = Integer.parseInt(tempRoomNumber);
                } else if (roomNumber.contains("C")) {
                    numberStr = roomNumber.replace("C", "");
                    if (numberStr.length() == 1) {
                        numberStr = "0" + numberStr;
                    }
                    tempRoomNumber = asciiC + numberStr;
                    newContrNumber = Integer.parseInt(tempRoomNumber);
                }

                //genrate create date
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LLLL-dd");
                newCreateDate = date.format(formatter);

                //create new contract
                ContractDTO contractBuyer = new ContractDTO(newBuyerContractID, "Recent Buyer Contract", newContrNumber, newCreateDate, "", "", 0, "", "", "", "", "", "", "", "", "", "");
                ContractDTO contractSeller = new ContractDTO(newSellerContractID, "Recent Seller Contract", newContrNumber, newCreateDate, "", "", 0, "", "", "", "", "", "", "", "", "", "");

                ContractDAO contractDao = new ContractDAO();

                //insert Buyer's
                boolean checkBuyerContract = contractDao.insertBuyerContract(contractBuyer, buyerUserName);
                //insert Seller's
                String sellerUserName = contractDao.getSeller(contractID);
                boolean checkSellerContract = contractDao.insertSellerContract(contractSeller, sellerUserName);

                //ROOM
                RoomDTO room = new RoomDTO();
                RoomDAO roomDao = new RoomDAO();

                //Update room status, create new contract
                boolean checkUpdateStatus = roomDao.updateRoomStatus(contractID);
                boolean checkRoomContractID = roomDao.updateRoomContractID(newBuyerContractID,roomNumber);

                if (checkUpdateStatus & checkRoomContractID & checkBuyerContract & checkSellerContract) {
                    request.setAttribute("MESSAGE", "Successfuly! Please check your contract in the Contracts page.");
                    request.setAttribute("BUYER_CONTRACT", contractBuyer);
                    request.setAttribute("SELLER_CONTRACT", contractSeller);
                    SUCCESS = "MainController?action=ViewRoom&contractID=" + contractID;
                    url = SUCCESS;
                } else {
                    request.setAttribute("MESSAGE", "Cannot buy room!");
                    ERROR = "MainController?action=ViewRoom&contractID=" + contractID;
                    url = ERROR;
                }
            }
        } catch (Exception e) {
            log("Error at Update Controller" + e.toString());
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
