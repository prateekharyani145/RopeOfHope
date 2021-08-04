<%-- 
    Document   : admin
    Created on : 15 Jan, 2020, 4:42:12 PM
    Author     : Mradul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin  Page</title>
       <link rel="stylesheet" href="css/donation.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <script src="js/Item.js"></script>
        <script src="js/qty.js"></script>
     
    </head>
    <%
        String email=null;
        try
        {
            if(session.getAttribute("email")==null || !session.getAttribute("etype").equals("admin"))
            {
                response.sendRedirect("login.html");
            }
            else
            {
                session.setMaxInactiveInterval(150);
                email=session.getAttribute("email").toString();
                session.setAttribute("email", email);
                session.setAttribute("etype", "admin");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in admin.jsp "+e.getMessage());
        }
    %>
    
    <body style="background-color: rgb(54, 153, 148);">
         <header class="header">
      <h1 class="logo"><a href="#">Rope Of Hope</a></h1>
      <h3 style="color: white;">Hello Nanak!!!!</h3>
        <ul class="main-nav">
            
            <li><a href="LogoutAdmin">Log Out</a></li>
        </ul>
    </header>
        <section>
        <div>
            <h2>Get Donation Status!!!</h2>
            <form action="InventoryDonationStatus" method="post">
            <button  style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="" class="btn btn-primary btn-lg">Get Status</button>
            <hr>
            </form> 
                
            <h2>Search Employee!!!</h2>
            <form action="EmployeeSearch" method="post">
            <input  style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search All Employee"/> 
            <input type="hidden" name="searchAll" value="1"> 
        </form>
            <hr>
            <br>
            <form action="EmployeeSearch" method="post">
            <input  type="text" name="fname" placeholder="First Name"/>
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By FirstName"/> 
            <input type="hidden" name="searchAll" value="8"> 
        </form>
            <br>
            
        <!-- Search Employee Record by First Name and Last Name-->
        <form action="EmployeeSearch" method="post">
            <input type="text" name="fname" placeholder="First Name">
            <input type="text" name="lname" placeholder="Last Name">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By Name"/> 
            <input type="hidden" name="searchAll" value="2"> 
        </form>
            <br>
            
            <!-- Search Employee Record BY City Name-->    
        <form action="EmployeeSearch" method="post">
            <input type="text" name="city" placeholder="Enter the City Name">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By City"/> 
            <input type="hidden" name="searchAll" value="5"> 
        </form>
            <br>
            <hr>
            <br>
        <!-- Search Employee Record By Skills-->
        <form action="EmployeeSearch" method="post">
           <label for="Skill" style="margin-left:5px;margin-right:10px; font-family: Arial; font-size: 15px;"> Skills: </label>
          					<select style="font-size:15px; font-family:Arial;" name="skill">
              					<option value="Music">Music</option>
              					<option value="Dance">Dance</option>
              					<option value="Craft">Craft</option>
            					</select>
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By Skill"/> 
            <input type="hidden" name="searchAll" value="3"> 
        </form>
            <br>
            
        <!-- Search Employee Record By Category-->    
        <form action="EmployeeSearch" method="post">
            <label style="font-size:15px; font-family:Arial"for="Category" style="margin-right:10px; margin-left:10px;"> Category:   </label>

                    <select style="font-size:14px; font-family:Arial; margin-left: 9px;" name="category">
                        <option value="Daily">Daily</option>
                        <option value="Sunday">Sunday</option>
                        <option value="Creative Saturday">Creative Saturday</option>
                      </select>
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Employee By Category"/> 
            <input type="hidden" name="searchAll" value="4"> 
        </form>
            <br>
            <hr>
            <br>
            
            
        <!-- Search Donor Record-->
        <h2>Search Donor!!!</h2>
        <form action="EmployeeSearch" method="post">
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search All Donor"/> 
            <input type="hidden" name="searchAll" value="6"> 
        </form>
        <hr>
        <br>   
        <!-- Search Inventory Record using INVENTORY NAME AND INVENTORY TYPE-->
        <h2>Search Inventories</h2>
        <form action="EmployeeSearch" method="post">
            <label for="Iname">Item name:</label>
            <select style="font-size:15px; font-family:Arial" onchange="print_type('Sitem', this.selectedIndex);" id="Sitem_id" name ="Iname" required></select>

            <label for="Type" style=" font-size:15px; font-family:Arial;">Type:</label>
            <select style="margin-left: 10px; font-size:15px; font-family:Arial" id ="Sitem" name="Itype" class="form-model" required></select>
            
            <input style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="Search Inventory"/> 
            <input type="hidden" name="searchAll" value="7"> 
        </form>
     </div>
        <hr>
        <div>
            <h2>Add or Remove Inventories</h2>
            <!-- ADD the DONATED items in the INVENTORY-->
            <form action="UpdateInventory" method="post">
            <label for="Iname">Item name:</label>
            <select style="font-size:15px; font-family:Arial" onchange="print_type('Aitem', this.selectedIndex);" id="Aitem_id" name ="Iname" required></select>

            <label for="Type" style=" font-size:15px; font-family:Arial;">Type:</label>
            <select style="margin-left: 10px; font-size:15px; font-family:Arial" id ="Aitem" name="Itype" class="form-model" required></select>
            
            <input type="number" step="1" min="1" max="" name="QTY" value="1" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:5%">
            <input type="hidden" name="Update" value="1"> 
            <br>
            <br>
            <div class="text-center"><button style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="AddInventory" class="btn btn-primary btn-lg">Add
                Inventory</button></div>
             </form>
        </div>
        <!-- Remove the items from the INVENTORY-->
            <br>
            <br>
            <form action="UpdateInventory" method="post">
            <label for="Item Name">Item name:</label>
            <select style="font-size:15px; font-family:Arial" onchange="print_type('Ritem', this.selectedIndex);" id="Ritem_id" name ="Iname" required></select>

            <label for="Type" style=" font-size:15px; font-family:Arial;">Type:</label>
            <select style="margin-left: 10px; font-size:15px; font-family:Arial" id ="Ritem" name="Itype" class="form-model" required></select>
            
            <input type="number" step="" min="1" max="" name="QTY" value="1" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:5%">
            <input type="hidden" name="Update" value="2"> 
            <br>
            <br>
            <div class="text-center">
            <button  style="background-color:#272727; color:#eeee58; border:none; border-radius: 5px;" type="submit" value="RemoveInventory" class="btn btn-primary btn-lg">Remove Inventory</button></div>
            </form>                        
            
                   
        </div>
        
        <br>
        <hr>

     
        
    </body>
    <script language="javascript">
    print_item("Sitem_id");    
    print_item("Aitem_id");
    print_item("Ritem_id");
    </script>
</html>
