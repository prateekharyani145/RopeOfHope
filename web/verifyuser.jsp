<%-- 
    Document   : verifyuser
    Created on : 21 Jan, 2020, 10:56:35 AM
    Author     : Mradul
--%>

<%@page import="DAO.PinDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify User Page</title>
    </head>
    <body>
        <h1>Verifying</h1>
        
        <%
            String Pin=request.getParameter("v");
            String type=request.getParameter("type");
            
            String Email=PinDAO.checkPin(Pin);
            
            if(Email==null)
            {
                System.out.println("Verifyjsp In Email "+Email+" Pin"+Pin);
                response.sendRedirect("Error.html");
            }//Send to Different Error Page.
            else
            {
                if(type.equalsIgnoreCase("1"))
                { 
                    session.setAttribute("Email", Email);
                    response.sendRedirect("signup.jsp");
                    System.out.println("Way To Signup");
                }
            }
        %>
    </body>
</html>
