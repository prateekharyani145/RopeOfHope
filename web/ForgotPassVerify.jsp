<%-- 
    Document   : ForgotPassVerify
    Created on : Feb 21, 2020, 12:40:50 PM
    Author     : DELL
--%>

<%@page import="DAO.PinDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Verifying</h1>
        
        <%
            String Pin=request.getParameter("f");
            String type=request.getParameter("type");
            
            String Email=PinDAO.checkPin2(Pin);
            
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
                    response.sendRedirect("ForgotChange.jsp");
                    System.out.println("Way To change");
                }
            }
        %>
    </body>
</html>
