<%-- 
    Document   : buyer_info_test
    Created on : Jun 3, 2022, 9:22:19 AM
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
        
        Full name: <h1>${sessionScope.USER_INFO.fullName}</h1>
        <a href="MainController?action=Find&searchRoom=">Room List</a>
    </body>
</html>
