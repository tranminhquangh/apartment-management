/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.contracts.ContractDAO;
import sample.contracts.ContractDTO;

/**
 *
 * @author tranp
 */
@WebServlet(name = "UpdateContractController", urlPatterns = {"/UpdateContractController"})
public class UpdateContractController extends HttpServlet {

    private static final String ERROR="admin.jsp";
    private static String SUCCESS="admin_contract_detail.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {

            //String search = request.getParameter("search");
            String contractID = request.getParameter("contractID");
            String contractTitle = request.getParameter("contrTitle");
            int contrNumber = Integer.parseInt(request.getParameter("contrNumber"));
            String contrCreateDate = request.getParameter("contrCreateDate");
            String contrStartDate = request.getParameter("contrStartDate");
            String contrEndDate = request.getParameter("contrEndDate");
            float contrFee = Float.parseFloat(request.getParameter("contrFee"));
            String contrFeeType = request.getParameter("contrFeeType");
            String contrDescription = request.getParameter("contrDescription");
            String contrBillingDate = request.getParameter("contrBillingDate");
            String contrFeeStatus = request.getParameter("contrFeeStatus");
            String contrAttachment = request.getParameter("contrAttachment");
            String contrStatus = request.getParameter("contrStatus");
        
            ContractDTO contract=new ContractDTO(contractID,contractTitle,contrNumber,contrCreateDate,contrStartDate,contrEndDate,contrFee,contrFeeType,contrDescription,"Signed",contrBillingDate,contrFeeStatus,contrAttachment,contrStatus,"","","");
            ContractDAO dao=new ContractDAO();
            boolean check=dao.updateContract(contract);

            if(check){
                request.setAttribute("MESSAGE", "Successfuly!");
                ContractDTO updatedContract = dao.getContract(contractID);
                request.setAttribute("DETAIL_CONTRACT", updatedContract); 
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
