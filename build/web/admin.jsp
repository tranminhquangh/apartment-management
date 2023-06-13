<%-- 
    Document   : admin
    Created on : May 18, 2022, 9:11:47 PM
    Author     : KN
--%>

<%@page import="sample.accounts.AccountDTO"%>
<%@page import="sample.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            UserDTO loginUser=(UserDTO)session.getAttribute("USER_INFO");
            if(loginAccount==null || !loginAccount.getRoleID().equals("AD")){
                response.sendRedirect("login.jsp");
                //loginUser=new UserDTO();
                return;
            }
            
            
        %>
        Welcome: <h1><%= loginUser.getFullName() %></h1>
        
    </body>
</html>
