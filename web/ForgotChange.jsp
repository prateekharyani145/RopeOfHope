<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Change Password ROH</title>
    <link rel="stylesheet" href="css/form.css">
    <link rel="stylesheet" href="css/loader.css">
    <script src="js/loader.js"></script>
    <style>
        body
        {
            background: url('img/14.jpg');
            -webkit-background-size: auto;
            -moz-background-size: auto;
            -o-background-size: auto;
            background-size: cover;
            background-repeat: no-repeat;
            height: 100%;
        }

    </style>
  </head>
  <%
    String Email=null;
    try{
         Email=session.getAttribute("Email").toString();
        if(Email==null)        
        {
            out.println("Error in ForgotChange.jsp" + Email);
            response.sendRedirect("Error.html");
        }
    }
    catch(Exception E)
    {
        System.out.println("Exception in signup.jsp "+ E.getMessage());
        E.printStackTrace();
        response.sendRedirect("Error.html");
    }
%>
  <body>
       <div id="loader" style="display:none;">
        
            </div>
      
        <div style="opacity:75%; width:26%" class="form-modal">
           
        <br>
            <h1 style="text-align: center; font-size:large; font-family: Arial, Helvetica, sans-serif;">
                Enter Your New Password
            </h1>
        <form  action="ForgotPass" method="post">
            
        <input style="font-family: Arial;" type="text"  name="Email" readonly required value="<%=Email%>"/>
        <input type="password" required name="newPass" style="font-family: Arial;" autofocus placeholder="Enter Your New Password"/>
        <button style="margin-left:160px" type="submit" class="btn login">Change</button>
        </form>
        </div>
  </body>
</html>
