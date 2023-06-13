<%-- 
    Document   : seller_test
    Created on : May 31, 2022, 9:28:03 AM
    Author     : tranp
--%>

<%@page import="java.util.List"%>
<%@page import="sample.rooms.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
        <link href="css/main.css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <c:if test="${sessionScope.LOGIN_ACCOUNT != null}">
            <a href="seller_info_test.jsp">Profile</a>
        </c:if> 
         <c:if test="${sessionScope.LOGIN_ACCOUNT == null}">
            <a href="loginUser.jsp">Login</a>
        </c:if> 

        <div class="searchBar">
            <form action="MainController">
                <input type="text" name="searchRoom" required="" value="${param.searchRoom}"/> 
                <input type="submit" name="action" value="Find"/>
                </br>
                Filter by building :
                        <a href="MainController?action=Filter&buildingID=1">Block A</a> |
                        <a href="MainController?action=Filter&buildingID=2">Block B</a> |
                        <a href="MainController?action=Filter&buildingID=3">Block C</a>
           
                </br>
                Filter by price 
                <a href="MainController?action=Filter&priceRange=Low">Below 1000</a> |
                <a href="MainController?action=Filter&priceRange=Mid">From 1,000 to 1,000,000</a> |      
                <a href="MainController?action=Filter&priceRange=High">Above 1,000,000</a>           


                </br>
                Filter by room type :
                    <a href="MainController?action=Filter&roomType=Causal">Casual</a> |
                    <a href="MainController?action=Filter&roomType=Normal">Normal</a> |    
                    <a href="MainController?action=Filter&roomType=Deluxe">Deluxe</a>    

                </br>
                 <input type="submit" name="action" value="Filter"/></br></br>
            </form>

            </br>
        </div>

        <c:if test="${requestScope.EMPTY_ROOM_LIST_SEARCH !=null}">
            <c:if test="${not empty requestScope.EMPTY_ROOM_LIST_SEARCH }">
                <table border="1" class="tableCenter">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Number</th>
                            <th>Type</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="room" items="${requestScope.EMPTY_ROOM_LIST_SEARCH}">        
                            <tr>
                        <form action="MainController" method="POST">    
                            <td>
                                ${room.roomTitle}
                                <input type="hidden" name="contractID" value="${room.contractID}"/>
                            </td>
                            <td>

                                <a href="MainController?action=ViewRoom&contractID=${room.contractID}">${room.roomNumber} </a>  

                            </td>
                            <td>
                                ${room.roomType}
                            </td>
                            <td>
                                ${room.roomPrice}
                            </td>
                            <td>
                                ${room.roomImg} 
                            </td>
                            <td>
                                <input type="hidden" name="roomSellStatus" value="${room.roomSellStatus}"/>
                                ${room.roomSellStatus}
                            </td>
                            <td>
                                <input type="submit" name="action" value="Sell"/>
                                <input type="hidden" name="search" value="${param.search}"/>
                            </td>

                        </form>         
                    </tr>
                </c:forEach>


            </tbody>
        </table>
    </c:if>

</c:if>

<%  String message = (String) request.getAttribute("MESSAGE");
    if (message == null) {
        message = "";
    }
%>
<div class="message">
    <%= message%>
</div>
<script src="js/extention/choices.js"></script>
    <script>
      const choices = new Choices('[data-trigger]',
      {
        searchEnabled: false
      });

    </script>
    <script>
        $("select").click(function() {
  var open = $(this).data("isopen");
  if(open) {
    window.location.href = $(this).val()
  }
  //set isopen to opposite so next time when use clicked select box
  //it wont trigger this event
  $(this).data("isopen", !open);
});

    </script>
</body>
</html>
