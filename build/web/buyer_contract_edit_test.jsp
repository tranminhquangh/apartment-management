<%-- 
    Document   : buyer_contract_edit_test
    Created on : Jun 2, 2022, 10:26:00 AM
    Author     : tranp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${requestScope.BUYER_CONTRACT !=null}">
            <c:if test="${not empty requestScope.BUYER_CONTRACT }">
                <form action="MainController">

                    ID: ${requestScope.BUYER_CONTRACT.contractID}
                    <input type="hidden" name="contractID" value="${requestScope.BUYER_CONTRACT.contractID}" required=""/>
                    </br>
                    Contract Title: <input type="text" name="contrTitle" value="${requestScope.BUYER_CONTRACT.contrTitle}" /></br>
                    Contract Description: <input type="text" name="contrDescription" value="${requestScope.BUYER_CONTRACT.contrDescription}"/></br>
                    Start Date: <input type="date" name="contrStartDate" value="${requestScope.BUYER_CONTRACT.contrStartDate}" /></br>
                    End Date: <input type="date" name="contrEndDate" value="${requestScope.BUYER_CONTRACT.contrEndDate}" /></br></br>
                    Fee: <input type="text" name="contrFee" value="${requestScope.BUYER_CONTRACT.contrFee}" /></br>

                    Fee Type:<select name="contrFeeType">
                        <option value="One time">One time</option>
                        <option value="Monthly">Monthly</option>
                        <option value="Annually">Annually</option>
                    </select>

                    Billing Date: <input type="date" name="contrBillingDate" value="${requestScope.BUYER_CONTRACT.contrBillingDate}" /></br>

                    </br></br>
                    Attachment: <input type="text" name="contrAttachment" value="${requestScope.BUYER_CONTRACT.contrAttachment}" /></br>
                    </br>
                    
                    Sign here:</br>
                    
                    Buyer: <input type="text" name="buyerSignature" value="${requestScope.BUYER_CONTRACT.buyerSignature}" /></br>
                    Seller: ${requestScope.SELLER_CONTRACT.sellerSignature}
                        

                    </br></br>

                    <input type="submit" name="action" value="Save"/></br></br>
                    <a href="contract_detail_test.jsp">Return</a>
                </form>


            </c:if>
        </c:if>
        
    </body>
</html>
