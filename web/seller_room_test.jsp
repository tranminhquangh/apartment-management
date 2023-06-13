<%-- 
    Document   : seller_room_test
    Created on : May 31, 2022, 10:23:54 AM
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
        <c:if test="${requestScope.DETAIL_ROOM !=null}">
            <c:if test="${not empty requestScope.DETAIL_ROOM }">
            <form action="MainController">

                <input type="hidden" name="contractID" value="${requestScope.DETAIL_ROOM.contractID}"/>
                <input type="hidden" name="roomSellStatus" value="${requestScope.DETAIL_ROOM.roomSellStatus}"/>
                </br>
                Room Title: <input type="text" name="roomTitle" value="${requestScope.DETAIL_ROOM.roomTitle}"/></br>
                Room Number: ${requestScope.DETAIL_ROOM.roomNumber}</br>
                Room Type:  ${requestScope.DETAIL_ROOM.roomType}</br>
                Room Description: <input type="text" name="roomDescription" value="${requestScope.DETAIL_ROOM.roomDescription}"/></br>               
                Room Size: ${requestScope.DETAIL_ROOM.roomSize}</br>
                Price: <input type="number" name="roomPrice" value="${requestScope.DETAIL_ROOM.roomPrice}" min="0" max="2000000000"/></br>
                Building:  ${requestScope.DETAIL_ROOM.buildingID}</br>
                Image: ${requestScope.DETAIL_ROOM.roomImg}</br></br>
                Sell Status: ${requestScope.DETAIL_ROOM.roomSellStatus}</br></br>


                <input type="submit" name="action" value="Save info"/></br></br>
                
                <input type="submit" name="action" value="Sell"/>
            </form>
             </c:if>
        </c:if>
        
        <a href="MainController?action=Find&searchRoom=">Room List</a>
         <%
                String message=(String)request.getAttribute("MESSAGE");
                if(message==null){
                    message="";
                }
            %>
        <div class="message">
            <%= message %>
        </div>
    </body>
</html>
