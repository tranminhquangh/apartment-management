<%-- 
    Document   : seller_contract_edit_test
    Created on : Jun 2, 2022, 10:26:19 AM
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
        <c:if test="${requestScope.SELLER_CONTRACT !=null}">
            <c:if test="${not empty requestScope.SELLER_CONTRACT }">
                <form action="MainController">

                    ID: ${requestScope.SELLER_CONTRACT.contractID}
                    <input type="hidden" name="contractID" value="${requestScope.SELLER_CONTRACT.contractID}" required=""/>
                    </br>
                    Contract Title: <input type="text" name="contrTitle" value="${requestScope.SELLER_CONTRACT.contrTitle}" /></br>
                    Contract Description: <input type="text" name="contrDescription" value="${requestScope.SELLER_CONTRACT.contrDescription}"/></br>
                    Start Date: <input type="date" name="contrStartDate" value="${requestScope.SELLER_CONTRACT.contrStartDate}" /></br>
                    End Date: <input type="date" name="contrEndDate" value="${requestScope.SELLER_CONTRACT.contrEndDate}" /></br></br>
                    Fee: <input type="text" name="contrFee" value="${requestScope.SELLER_CONTRACT.contrFee}" /></br>

                    Fee Type:<select name="contrFeeType">
                        <option value="One time">One time</option>
                        <option value="Monthly">Monthly</option>
                        <option value="Annually">Annually</option>
                    </select>

                    Billing Date: <input type="date" name="contrBillingDate" value="${requestScope.SELLER_CONTRACT.contrBillingDate}" /></br>

                    </br></br>
                    Attachment: <input type="text" name="contrAttachment" value="${requestScope.SELLER_CONTRACT.contrAttachment}" /></br>
                    </br>
                    
                    Sign here:</br>
                    
                    Buyer: ${requestScope.BUYER_CONTRACT.buyerSignature}</br>
                    Seller: <input type="text" name="sellerSignature" value="${requestScope.SELLER_CONTRACT.sellerSignature}" />
                    </br></br>

                    <input type="submit" name="action" value="Save"/>
                </form>


            </c:if>
        </c:if>
        <a href="contract_detail_test.jsp">Cancel</a>
    </body>
</html>
