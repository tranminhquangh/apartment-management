<%-- 
    Document   : room_test
    Created on : May 27, 2022, 7:53:09 PM
    Author     : tranp
--%>

<%@page import="sample.users.UserDTO"%>
<%@page import="sample.accounts.AccountDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.rooms.RoomDTO"%>
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

               
        <c:if test="${sessionScope.LOGIN_ACCOUNT != null}">
            <a href="buyer_info_test.jsp">Profile</a>
        </c:if>   
          

        </br>
       
         <%
            
            
            String search=request.getParameter("search");
                if(search==null){
                    search="";
                }
                
        %>
        <div class="searchBar">
            <form action="MainController">
                <input type="text" name="searchRoom" placeholder="Search" required="" value="<%= search%>"/> 
                <input type="submit" name="action" value="Find"/></br></br>
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
       <%

            List<RoomDTO> listRoom=(List<RoomDTO>)request.getAttribute("ROOM_LIST_SEARCH");
            if(listRoom!=null){
                if(listRoom.size()>0){
        %>
                <table border="1" class="tableCenter">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Number</th>
                        <th>Type</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                       
                        int count=1;
                        for(RoomDTO room:listRoom){
                            
                            
                    %>
                    <tr>
                    <form action="MainController" method="POST">    
                        <td>
                             <%= room.getRoomTitle() %>
                            <input type="hidden" name="contractID" value="<%=room.getContractID()%>"/>
                        </td>
                        <td>
                            <a href="MainController?action=ViewRoom&contractID=<%=room.getContractID()%>"><%= room.getRoomNumber() %> </a>  
                              
                        </td>
                        <td>
                            <%= room.getRoomType() %>   
                        </td>
                        <td>
                            <%= room.getRoomPrice() %>   
                        </td>
                        <td>
                            <%= room.getRoomImg() %>   
                        </td>
                        
                        <td>
                            <input type="submit" name="action" value="ViewRoom"/>
                            <input type="hidden" name="search" value="<%= search%>"/>
                        </td>

                    </form>         
                    </tr>
   
                    <%        
                        }
                    %>
                    
                </tbody>
            </table>
        <%    
                }
            }
                
        %>
    </body>
</html>

