<%-- 
    Document   : MoneyDonation
    Created on : 22 Jan, 2020, 6:51:01 PM
    Author     : Mradul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Money Donation  ROH Page</title>
    </head>
    <%
        String Email=session.getAttribute("Email").toString();
        if(session==null)
            response.sendRedirect("login.html");
        if(Email==null)
        {
            response.sendRedirect("login.html");
            session.invalidate();
        }
        
        
    %>
    <body>
        <h1>Donate Money Here</h1>
    </body>
</html>
