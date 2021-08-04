<%-- 
    Document   : Form1
    Created on : 21 Jan, 2020, 10:36:37 AM
    Author     : Mradul
--%>

<%@page import="DAO.EmployeeDAO"%>
<%@page import="DAO.PinDAO"%>
<%@page import="java.lang.Exception"%>
<%@page import="DAO.MailDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email Validation Page</title>
        
        <link rel="stylesheet" href="css/loader.css">
        <script src="js/loader.js"></script>
    </head>
    <body style="background: url('img/stock.jpg'); ">
        <div id="loader" style="display:none;">
        </div>
      
        <h1 style="color:#3ba564;  text-align: center; text-decoration: blink">A verification Link has been sent to your mail.</h1>
    <%
        try
        {
            EmployeeDAO e=new EmployeeDAO();
            String Email=request.getParameter("Email");
            if(Email==null)
                response.sendRedirect("Error.html");
            
            String pin=PinDAO.pinGenerate();
            String verification_link = "http://localhost:8084/RopeofHopeFinal"+"/verifyuser.jsp?v="+pin+"&type=1";
            
            PinDAO p1=new PinDAO();
            if(e.searchEmail(Email) || e.alreadySent(Email))
                response.sendRedirect("AlreadyRegistered.html");
            else{                  
                if(!p1.pinEntry(Email, pin))
                {
                    response.sendRedirect("AlreadyRegistered.html");
                }
                else{
                    boolean mailSent = MailDAO.sendMail(Email, 
                        "Verification Mail From Rope Of Hope", 
                        "Verify yourself with Rope Of Hope "+verification_link);

                    if(mailSent)
                    {   
    %>
                <div id="loader" style="display:none;">
                </div>
                <h2  align="center"> Click here for G-mail<a onclick="myFunction()" href="https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"><img src="https://img.icons8.com/color/48/000000/gmail.png"></a></h2>
                <br>
                <h2  align="center"> Click here for Yahoo<a onclick="myFunction()" href="https://login.yahoo.com/?.intl=in"><img src="https://img.icons8.com/doodle/48/000000/yahoo--v1.png"></a></h2>
                <br>
                <h2  align="center"> Click here for Outlook<a onclick="myFunction()" href="https://outlook.live.com/owa/"><img src="https://img.icons8.com/dusk/48/000000/ms-outlook.png"></a></h2>
                <br>
                <h2  align="center"> Click here for Other<a onclick="myFunction()" href="https://google.co.in/"><img src="https://img.icons8.com/color/64/000000/google-logo.png"></a></h2>

                <br> 
                <h2 align="center"> A verification mail has been sent to Email: <%=Email%></h2>
                    <%
                    }
                    else
                    {%>
                   <h1>Error in verification.Please Enter Valid Information.</h1>
                   <a href="signup1.html">Try Again.</a>
                    <% System.out.println("Verification mail has not been sent to "+Email);
                    }
                }   
            }
        }
        catch(Exception e)
        {
           response.sendRedirect("Error.html");
           System.out.println("Error in Form1.jsp "+e.getMessage());
        }
        
    %>
    
    
    </body>
    
</html>
