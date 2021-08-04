<%-- 
    Document   : volunteerlogin
    Created on : 15 Jan, 2020, 4:15:39 PM
    Author     : Mradul
--%>

<%@page import="DAO.EmployeeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/donation.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <title>Volunteer Page</title>
    </head>
    <%
        String email=null,name=null;
        try
        {
            if(session ==null || !session.getAttribute("etype").equals("volunteer"))
            {
                response.sendRedirect("login.html");
            }
            else
            {
                session.setMaxInactiveInterval(150);
                email=session.getAttribute("email").toString();
                
                name=EmployeeDAO.firstName(email);
                session.setAttribute("email", email);
                session.setAttribute("etype", "volunteer");                
            }
        }
        catch(Exception e)
        {
            System.out.println("Error Occurred " + e.getMessage());
            request.getRequestDispatcher("login.html").include(request, response);
        %>
        <h1>You must login first</h1>
    
    <%
        }
        
    %>
    <body style="background-color: rgb(54, 153, 148);">
        <header class="header">
      <h1 class="logo"><a href="#">Rope Of Hope</a></h1>
      <h3 style="color: white;">Hello <%=name%></h3>
        <ul class="main-nav">
            <li><a href="#profile">Profile</a></li>
            <li><a href="LogoutAdmin">Log Out</a></li>
        </ul>
    </header> 
        <section>
        <div>
            <h2>Search Employee and Donor</h2>
        <form action="VolunteerSearch">
            <input  style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search All Employee"/> 
            <input type="hidden" name="searchAll" value="1"> 
        </form>
            <hr>
            <br>
            <form action="VolunteerSearch">
            <input  type="text" name="fname" placeholder="First Name"/>
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By FirstName"/> 
            <input type="hidden" name="searchAll" value="8"> 
        </form>
            <br>
            
        <!-- Search Employee Record by First Name and Last Name-->
        <form action="VolunteerSearch">
            <input type="text" name="fname" placeholder="First Name">
            <input type="text" name="lname" placeholder="Last Name">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By Name"/> 
            <input type="hidden" name="searchAll" value="2"> 
        </form>
            <br>
            
        <!-- Search Employee Record By Skills-->
        <form action="VolunteerSearch">
            <input type="text" name="skill" placeholder="Enter Skill">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By Skill"/> 
            <input type="hidden" name="searchAll" value="3"> 
        </form>
            <br>
            
        <!-- Search Employee Record By Category-->    
        <form action="VolunteerSearch">
            <input type="text" name="category" placeholder="Enter the Category">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By Category"/> 
            <input type="hidden" name="searchAll" value="4"> 
        </form>
            <br>
            
        <!-- Search Employee Record BY City Name-->    
        <form action="VolunteerSearch">
            <input type="text" name="city" placeholder="Enter the City Name">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By City"/> 
            <input type="hidden" name="searchAll" value="5"> 
        </form>
            <hr>
            <br>
            
       
        <!-- Search Inventory Record using INVENTORY NAME AND INVENTORY TYPE-->
        <h2>Search Inventories</h2>
        <form action="VolunteerSearch">
            <input type="text" placeholder="Invetory Name" name="Iname">
            <input type="text" placeholder="Invetory Type" name="Itype">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Inventory"/> 
            <input type="hidden" name="searchAll" value="7"> 
        </form>
        <hr>
        <div id="profile">
        <a href="Change.html">Change Password</a>
        </div>
     </div>
        <hr>
        </div>
    </body>
</html>
