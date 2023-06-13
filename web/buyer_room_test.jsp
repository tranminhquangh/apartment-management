<%-- 
    Document   : buyer_room_test
    Created on : May 31, 2022, 10:21:38 AM
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
                </br>
                Room Title: ${requestScope.DETAIL_ROOM.roomTitle}</br>
                Room Number:  ${requestScope.DETAIL_ROOM.roomNumber}</br>
                <input type="hidden" name="roomNumber" value="${requestScope.DETAIL_ROOM.roomNumber}"/>
                Room Type:  ${requestScope.DETAIL_ROOM.roomType}</br>
                Room Description: ${requestScope.DETAIL_ROOM.roomDescription}</br>               
                Room Size: ${requestScope.DETAIL_ROOM.roomSize}</br>
                Price: ${requestScope.DETAIL_ROOM.roomPrice}</br>
                Building:  ${requestScope.DETAIL_ROOM.buildingID}</br>
                Image: ${requestScope.DETAIL_ROOM.roomImg}</br></br>


                <input type="submit" name="action" value="Buy"/>     
                <input type="submit" name="action" value="Return"/></br></br>
                <a href="MainController?action=Find&searchRoom=">Room List</a>
            </form>
             </c:if>
        </c:if>
        
       
    </body>
</html>
