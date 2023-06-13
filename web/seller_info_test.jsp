<%-- 
    Document   : seller_info_test
    Created on : Jun 3, 2022, 9:22:30 AM
    Author     : tranp
--%>

<%@page import="sample.users.UserDTO"%>
<%@page import="sample.accounts.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            UserDTO loginUser=(UserDTO)session.getAttribute("USER_INFO");
            if(loginAccount==null ){
                response.sendRedirect("loginUser.jsp");
                //loginUser=new UserDTO();
                return;
            }
            
            
        %>
        Full name: <h1><%= loginUser.getFullName() %></h1>
        <a href="MainController?action=Find&searchRoom=">Room List</a>
    </body>
</html>
