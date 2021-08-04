<%-- 
    Document   : donation
    Created on : 14 Jan, 2020, 5:46:25 PM
    Author     : Mradul
--%>

<%@page import="DAO.DonorDAO"%>
<%@page import="javax.websocket.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Donation Page</title>
        <link rel="stylesheet" href="css/donation.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    </head>
    <%
        String email=null;
        String name=null;
        try
        {   
            if(session.getAttribute("email")==null || !session.getAttribute("etype").equals("Donor"))
            {
                response.sendRedirect("login.html");
            }
            else
            {
                email=session.getAttribute("email").toString();
                name=DonorDAO.firstName(email);
                
                session.setAttribute("Email", email);
                session.setAttribute("etype", "Donor"); 
                session.setAttribute("name", name);
                session.setMaxInactiveInterval(260);
            }
        }
        catch(Exception E)
        {
            session.invalidate();
            response.sendRedirect("Error.html");
            System.out.println("Error in donation.jsp "+ E.getMessage());
        }
        
    %>
    <body style="background: #9DC183">
    <header class="header">
      <h1 class="logo"><a href="#">Rope Of Hope</a></h1>
      <h3 style="color: #eeee58;">Hello <%=name%></h3>
        <ul class="main-nav">
            <li><a href="DonorProfile.jsp">Profile</a></li>
            <li><a href="LogoutAdmin">Log Out</a></li>
        </ul>
    </header> 
        
    <section>
      <div class="services-grid"> 
        <div class="service" style="background:darkgray;">
          <img style="width: 20%; box-shadow: 3px 3px black;" src="img/i1.jpg" alt="">
        </div>

        <div class="service">
          <h1> "Superheroes:They are ordinary people who do uncommon things in conventional ways".</h1>
          <br>
          <h4> -Pratik Uppal</h4>
        </div>
        <div class="service" style="background: darkgray;">
          <img style="width: 20%; box-shadow: 3px 3px black;" src="img/i3.jpg" alt="">
        </div>

      </div> 

    </section>
    <hr>
    <section>
      <h3>What We Take</h3>
      <p class="section-lead"></p>
      
        <div class="service service1">
          <i class="fas fa-handshake"></i>
          <h4>Help Us</h4>
          <p>Each cent helps improving the experience of learning for the students at Rope of Hope and build the<br> <u> Dream School </u>they seek.</p>
        </div>
      <div class="services-grid">
        <div class="service service2">
          <i class="fas fa-shopping-cart"></i>
          <h4>Inventory Donation</h4>
          <p>In Inventory Donation we take all types of stationery products which are primary need  of a school student.</p>
          <form action="InventoryDonation.jsp">
            <input class="btn-success1" type="submit" value="Donate">
          </form>
        </div>
        
        <div class="service service3">
          <i class="fas fa-hand-holding-usd"></i>
          <h4>Money Donation</h4>
          <p>In Money Donation we seek your financial support for upliftment of children and society.For there bright Future
              
          </p>
          <form action="https://www.payumoney.com/paybypayumoney/#/43F28A23F5AE419AE300648399CD0AE8">
            <input class="btn-success2" type="submit" value="Donate">
          </form>

        </div>
    
      </div>
    </section>
       
    </body>
</html>
