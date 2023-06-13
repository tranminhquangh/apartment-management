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
import javax.servlet.http.HttpSession;
import sample.accounts.AccountDTO;
import sample.contracts.ContractDAO;
import sample.contracts.ContractDTO;

/**
 *
 * @author tranp
 */
@WebServlet(name = "ViewContractController", urlPatterns = {"/ViewContractController"})
public class ViewContractController extends HttpServlet {

    private static final String ERROR_AD="admin.jsp";
    private static final String ERROR_US="employee.jsp";
    private static final String SUCCESS_AD="admin_contract_detail.jsp";
    private static final String SUCCESS_US="employee_contract_detail.jsp";
    private static final String AD="AD";
    private static final String US="US";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR_AD;
        try{
            String id = request.getParameter("contractID");
            HttpSession session = request.getSession();
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            String roleID=loginAccount.getRoleID();
           
           if(AD.equals(roleID)){
                ContractDAO dao = new ContractDAO();
                ContractDTO contract = dao.getContract(id);

                if(contract!=null){
                    request.setAttribute("DETAIL_CONTRACT", contract); 
                    url=SUCCESS_AD;
                }else{
                    url=ERROR_AD;
                }
           }if(US.equals(roleID)){
               ContractDAO dao = new ContractDAO();
                ContractDTO contract = dao.getContract(id);

                if(contract!=null){
                    request.setAttribute("DETAIL_CONTRACT", contract); 
                    url=SUCCESS_US;
                }else{
                    url=ERROR_US;
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
