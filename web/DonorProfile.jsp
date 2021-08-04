<%--    
    Document   : DonorProfile
    Created on : 22 Jan, 2020, 6:52:54 PM
    Author     : Mradul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Donor Profile ROH Page</title>
        <link rel="stylesheet" href="css/donation.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    </head>
    <%
        String Email=null;
        String name=null;
        if(session==null)
            response.sendRedirect("login.html");
        try
        {
            Email=session.getAttribute("Email").toString();
            name=session.getAttribute("name").toString();
            if(Email==null)
            {
                session.invalidate();
                response.sendRedirect("login.html");
            }
            session.setAttribute("Email", Email);
        }
        catch(Exception E)
        {
            session.invalidate();
            System.out.println("Error in DonorProfile.jsp "+E.getMessage());
            E.getStackTrace();
            response.sendRedirect("Error.html");
        }
        
    %>
    <body>
         <header class="header">
      <h1 class="logo"><a href="donation.jsp">Rope Of Hope</a></h1>
      <h3 style="color: #eeee58;">Hello <%=name%></h3>
        <ul class="main-nav">
            <li><a href="DonorProfile.jsp">Profile</a></li>
            <li><a href="LogoutAdmin">Log Out</a></li>
        </ul>
    </header> 
        <form action="PreviousItemDonation" method="post">
            <button style=" margin-left:45%; background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="" class="btn btn-primary btn-lg">Previous Donation</button>
        </form>
        
    </body>
</html>
