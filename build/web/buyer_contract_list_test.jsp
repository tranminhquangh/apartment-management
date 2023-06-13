<%-- 
    Document   : buyer_contracts_test
    Created on : Jun 2, 2022, 4:51:29 PM
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
        <h1>Hello World!</h1>
        <div class="searchBar">
            <form action="MainController">
                <input type="text" name="search" placeholder="Search" required="" value="${param.search}"/> 
                <input type="submit" name="action" value="Search"/>
            </form>

            </br>
        </div>
                
        <a href="admin.jsp">Dashboard</a>        
                
        
        <c:if test="${requestScope.CONTRACT_LIST_SEARCH !=null}">
            <c:if test="${not empty requestScope.CONTRACT_LIST_SEARCH }">
                
                <table border="1" class="tableCenter">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Fee</th>
                        <th>Status</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                   
                    <c:forEach var="contract" items="${requestScope.CONTRACT_LIST_SEARCH}">
                        <tr>
                        <form action="MainController" method="POST">    
                            <td>

                                <button type="submit" name="action" value="View">
                                    ${contract.contractID}   
                                </button>

                                <input type="hidden" name="contractID" value="${contract.contractID}"/>
                            </td>

                            <td>${contract.contrTitle}</td>

                            <td>${contract.contrFee}</td>

                            <td>${contract.contrFeeStatus}</td>
                            <td>
                                <input type="submit" name="action" value="Edit"/>
                                <input type="hidden" name="search" value="${param.search}"/>
                            </td>

                            <td>
                                <input type="submit" name="action" value="Remove"/>
                                <input type="hidden" name="search" value="${param.search}"/>

                            </td>

                        </form>         
                        </tr>
                    </c:forEach>
                   
                    
                </tbody>
            </table>
                    
                    
            </c:if>
            
        </c:if>
    </body>
</html>
