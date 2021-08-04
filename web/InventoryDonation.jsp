<%-- 
    Document   : InventoryDonation
    Created on : 22 Jan, 2020, 6:50:38 PM
    Author     : Mradul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Donation ROH Page</title>
        <link rel="stylesheet" href="css/donation.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <script src="js/qty.js"></script>
        <script src="js/Inventory.js"></script>
        
    </head>
    <%
        if(session.getAttribute("email")==null || !session.getAttribute("etype").equals("Donor"))
        {
            response.sendRedirect("login.html");
        }
        else
            {
                String email=session.getAttribute("email").toString();
                session.setAttribute("Email", email);
                session.setAttribute("etype", "Donor");
                session.setMaxInactiveInterval(260);
            }
    
    %>
    <body style="background: #9DC183">
        <header class="header">
      <h1 class="logo"><a href="index.html">Rope Of Hope</a></h1>
        <ul class="main-nav">
            <li><a href="DonorProfile.jsp">Profile</a></li>
            <li><a href="LogoutAdmin">Log Out</a></li>
        </ul>
    </header> 
        <section>
        
            <h1 style="font-size: 30px">Donate Inventory Here</h1><br>
      <img src="https://img.icons8.com/dusk/64/000000/list.png">
      <h3 style="font-size: 25px;">Choose Items from List</h3>
      <br>
     <form action="InventoryDonationAdd" method="post">
         <!-------Pencil-------->
         <table align="center">
            <tr><td> <img src="https://img.icons8.com/metro/34/000000/pencil.png"> Pencil:<input type="checkbox" id="myCheck" name="Pencil" onclick="myFunction1()"></td>
            <td> <div id="Pencil" style="display:none">
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="penciltype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Plain" >Plain</option>
                <option value="Colour">Colour</option>
                <option value="Other">Other</option>
            </select>
             <label for="QTY" style="font-family: Arial;">Qty:</label>
                <input type="number" step="" min="0" max="" name="PencilQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>
            
        
             </tr>
        </table>
        <hr>
           <!-------Drawing-------->
         <table align="center">
        <tr><td><img src="https://img.icons8.com/ios/50/000000/easel.png">  Drawing: <input type="checkbox" id="myCheck2" name="Drawing" onclick="myFunction2()"></td>
         <td><div id="Drawing" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
                <select name="drawingtype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                    <option value="None" selected="None">None</option> 
                    <option value="Book" >Book</option>
                    <option value="Sheet">Sheet</option>
                    <option value="Other">Other</option>
                </select> 
            
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            
            <input type="number" step="" min="1" max="" name="DrawingQTY" value="1" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td> 
        
        </tr>
             </table>
        
        <hr>
           <!-------Copy-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/material/34/000000/spiral-bound-booklet.png"> Copy: <input type="checkbox" id="myCheck4" name="Copy" onclick="myFunction4()"></td>
                <td><div id="Copy" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
                <select name="copytype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                    <option value="None" selected="None">None</option> 
                    <option value="Fair" >Fair</option>
                    <option value="Rough">Rough</option>
                    <option value="Other">Other</option>
                </select> 
            
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="CopyQTY" value="0" title="copyQty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
               </div>
            </td>  
        
        </tr>
</table>
        
        <hr>
           <!-------Color-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/android/40/000000/fill-color.png"> Colour: <input type="checkbox" id="myCheck3" name="Color" onclick="myFunction3()"></td>
                <td><div id="Colour" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            
            <select name="colortype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Water" >Water</option>
                <option value="Sketch">Sketch</option>
                <option value="Crayons">Crayon</option>
                <option value="Other">Other</option>
            </select> 
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="ColorQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
        </div>  
            </td>  

    </tr>
</table>
        <hr>
           <!-------Pen-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/dotty/44/000000/hand-with-pen.png"> Pen: <input type="checkbox" id="myCheck5" name="Pen" onclick="myFunction5()"></td>
                <td><div id="Pen" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="pentype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Ball" >Ball</option>
                <option value="Gel">Gel</option>
                <option value="Ink">Ink</option>
                <option value="Other">Other</option>
            </select> 
            
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            
            <input type="number" step="" min="0" max="" name="PenQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>  
    </tr>
</table>
        <hr>
           <!-------Scale-------->
        <table align="center">
        <tr> <td><td><img src="https://img.icons8.com/ios-filled/34/000000/ruler.png"> Scale: <input type="checkbox" id="myCheck6" name="Scale" onclick="myFunction6()"></td>
            <td><div id="Scale" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            
            <select name="scaletype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Small" >Small</option>
                <option value="Large">Large</option>
                <option value="Other">Other</option>
            </select> 
            
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="ScaleQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>  
        
    </tr>
    </table>
        <hr>
           <!-------Erasers-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/wired/34/000000/eraser.png"> Erasers: <input type="checkbox" id="myCheck7" name="Eraser" onclick="myFunction7()"></td>
                <td><div id="Eraser" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="erasertype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Default">Default</option>
            </select> 
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="EraserQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>  
        
    </tr>
</table>
        <hr>
           <!-------Sharpener-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/ios/34/000000/pencil-sharpener.png"> Sharpener: <input type="checkbox" id="myCheck8" name="Sharpener" onclick="myFunction8()"></td>
                <td><div id="Sharpener" style="display:none">
        <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="sharpenertype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Default">Default</option>
            </select> 
            
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="SharpenerQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>
    </tr>
</table>
<hr>       <!-------Board-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/wired/44/000000/classroom.png"> Board: <input type="checkbox" id="myCheck9" name="Board" onclick="myFunction9()"></td>
                <td><div id="Board" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="boardtype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Black">Black</option>
                <option value="White">White</option>
            </select> 
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="BoardQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>
    </tr>
</table>
<hr>       <!-------Chalk-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/dotty/34/000000/border-color.png"> Chalk: <input type="checkbox" id="myCheck10" name="Chalk" onclick="myFunction10()"></td>
                <td><div id="Chalk" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="chalktype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Default">Default</option>
            </select> 
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="ChalkQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>  
        
    </tr>
</table>
<hr>       <!-------Duster-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/ios/34/000000/wooden-hand-plane.png"> Duster: <input type="checkbox" id="myCheck11" name="Duster" onclick="myFunction11()"></td>
                <td><div id="Duster" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="dustertype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Default">Default</option>
            </select> 
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="DusterQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>  
        
    </tr>
</table>
<hr>       <!-------Study Table-------->
        <table align="center">
            <tr><td><img src="https://img.icons8.com/ios-glyphs/40/000000/table.png"> Study Table: <input type="checkbox" id="myCheck12" name="StudyTable" onclick="myFunction12()"></td>
                <td><div id="Study Table" style="display:none">
        
            <label for="Type:" style=" font-family: Arial;">Type:</label>
            <select name="studytabletype" style="margin-right:60px; font-size:13px; font-family:Arial;" required>
                <option value="None" selected="None">None</option> 
                <option value="Default">Default</option>
            </select> 
            <label for="QTY" style="font-family: Arial;">Qty:</label>
            <input type="number" step="" min="0" max="" name="StudyTableQTY" value="0" title="Qty" class="input-text qty text" size="4" placeholder="QTY" style="width:15%">
            </div>
            </td>  
        
    </tr>
</table>
            <br>
            <br>
            <div class="text-center">
                
            <button  style="background-color:#272727; color:#eeee58; padding: 10px; width: 10%; border: none;" type="submit" value="" class="btn btn-primary btn-lg">Donate</button>
            </div>
      </form>  
      
          
      
      
        </section>> 
    </body>
    
</html>
