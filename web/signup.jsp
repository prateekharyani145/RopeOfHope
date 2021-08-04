<%-- 
    Document   : signup
    Created on : 21 Jan, 2020, 9:50:47 PM
    Author     : Mradul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Sign-up</title>
    <link rel="stylesheet" href="css/form.css">
    <script src="js/cities.js"></script>
     <link rel="stylesheet" href="css/loader.css">
    <script src="js/loader.js"></script>

    <style>
        body
        {
            background: url('img/banner-1.jpg');
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size:cover;
            background-repeat: no-repeat;
            background-position: center;
            
        }
    </style>
</head>
<%
    String Email=null;
    try{
         Email=session.getAttribute("Email").toString();
        if(Email==null)        
        {
            out.println("Error in signup.jsp" + Email);
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

    <div style="width:35%; opacity:85%;" class="form-modal" style="margin-left: 20%;">
        <h1 style="text-align: center;">
            Sign-up Become Member
        </h1>
        <div class="form-toggle">
            
            
            <button id="login-toggle" onclick="toggleLogin()">Donor</button>
            <button id="signup-toggle" onclick="toggleSignup()">Volunteer</button>
        </div>



        <div id="donor-form">
          <h2 style="text-align: center;">Volunteers Sign-up</h2>
            <form onsubmit="return validpass()" action="UserSignup" method="post">
                
                <input type="hidden" name="vtype" value="1">
                <input type="text" name="vemail" readonly required value="<%=Email%>"/>

                <input type="password" autofocus name="vpass" id="pass"  required placeholder="Enter password"/>

                <input type="password"  name="vcpass" id="cpass" required placeholder="Confirm password"/>
                <p style="display:none;" id="cpasserr"></p>

                <input type="text" id="vmob" name="vmob" required placeholder="Enter Mobile Number"/>
                <p style="display: none;" id=moberr></p>

                <table>
                    <tr>
                        <td><input size="30%;" type="text" id="vfname1" name="vfname" required placeholder="Enter First Name"/></td>
                        <td><input  size="30%;" type="text" id="vlname1" name="vlname" required placeholder="Enter Last Name"/></td>
                        <td> <p style="display: none;" id="lnameerr"></p> </td>
                    </tr>
                </table>

                <table>
                    <tr>
                        <td>   <input size="100" type="text" id="vs" name="vstreet" required placeholder="Street"/> </td>
                        <td> <p style="display: none;" id="streeterr"></p> </td>
                    </tr>
                    <tr>
                        <td>  <input size="100" type="text" id="pcode" name="vpostal" required placeholder="Postal Code"/></td>
                        <td> <p style="display: none;" id="pcodeerr"></p> </td>
                    </tr>

                </table>
                <br>
                <label for="State" style="margin-left:8px;margin-right:10px;font-size:15px; font-family:Arial"> State:</label>
                <select style="font-size:15px; font-family:Arial" onchange="print_city('vstate', this.selectedIndex);" id="vcity" name ="volstate" class="form-model" required></select>

                <label for="city" style=" font-size:15px; font-family:Arial; margin-right:8px; margin-left: 10px"> City:</label>
                <select style="margin-left: 10px; font-size:15px; font-family:Arial" id ="vstate" name="volcity" class="form-model" required></select>

                <br>


                <table>
                    <tr>
                        <td> <br><label for="Qualification:" style="margin-left:5px;margin-right:5px; font-family: Arial; font-size: 14px;">Qualification:</label>
                        <select style="margin-right:5px; font-size:13px; font-family:Arial;" name="quali" required>
                        <option value="Higher Secondary" selected>H.S.S</option>
                        <option value="Graduate" selected>Graduate</option>
                        <option value="Post Graduate">Post Graduate</option>
                        <option value="PhD">Ph.D</option>
                        <option value="Other">Other</option></td>

                        <td>  <br><label for="Proffession:" style="margin-left:5px;margin-right:5px; font-family: Arial; font-size: 14px;">Profession:</label>
                            <select style="margin-right:43px; font-size:14px; font-family:Arial;" name="prof" required>
                        <option value="Doctor" selected>Doctor</option>
                        <option value="Lawyer" selected>Lawyer</option>
                        <option value="Teacher" selected>Teacher</option>
                        <option value="Artist" selected>Artist</option>
                        <option value="Activist" selected>Activist</option>
                        <option value="Buisness" selected>Business</option>
                        <option value="Govt Job" selected>Government Job</option>
                        <option value="Private Job">Private Job</option>
                        <option value="Student">Student</option>
                        <option value="Other" selected>Other</option></td>
                    </tr>
                </table>
                <table>
                    <tr>
                    <td><br><label for="Gender:" style="margin-left:5px;margin-right:10px; font-family: Arial; font-size: 15px;">Gender:</label>
                        <select style="margin-right:65px; font-size:15px; font-family:Arial;" name="gender" required>
                    <option value="M" selected>Male</option>
                    <option value="F">Female</option>
                    </select></td>
                    <td>
                      <br><label style="font-size:15px; font-family:Arial"for="Category" style="margin-right:10px; margin-left:10px;"> Category:   </label>

                    <select style="font-size:14px; font-family:Arial; margin-left: 9px;" name="Category">
                        <option value="Daily">Daily</option>
                        <option value="Sunday">Sunday</option>
                        <option value="Creative Saturday">Creative Saturday</option>
                      </select></td>
                    </tr>
                </table>
                <table>
                  <tr>
                    <td>
                      <br><label for="Skill" style="margin-left:5px;margin-right:30px; font-family: Arial; font-size: 15px;"> Skill:   </label>
          					<select style="font-size:15px; font-family:Arial;" name="skill">
              					<option value="Music">Music</option>
              					<option value="Dance">Dance</option>
              					<option value="Craft">Craft</option>
            					</select></td>
                              </tr>
                </table>


                <button onclick="myFunction()" type="submit" class="btn login">Sign-up</button>
                <p><a href="login.html">Already Have account</a></p>
                <hr/>
                <h3 style="text-align: center; font-weight: bold ;"><a href="index.html"> Home</a></h3>
            </form>
        </div>
<!--
    DONOR FORM BEGINS
-->
        <div id="login-form">
            <h2 style="text-align: center;">Donor Sign-up</h2>
            <form action="UserSignup" method="post">
              
                <input type="hidden" name="vtype" value="2">
                <input type="text" readonly required name="demail" value="<%=Email%>"/>
                <input type="text" name="dmob" required placeholder="Enter Mobile Number"/>
                <table>
                  <tr>
                    <td><input  type="text" size="30" name="dfname" placeholder="Enter First Name"/></td>
                    <td><input  type="text" size="30" name="dlname" placeholder="Enter Last Name"/></td>
                  </tr>
                </table>
                <br>
                <label for="State" style="margin-left:8px;margin-right:10px;font-size:17px; font-family:Arial"> State:</label>
                <select style="font-size:15px; font-family:Arial" onchange="print_city('dstate', this.selectedIndex);" id="dcity" name ="donorstate" class="form-model" required></select>
                <label for="city" style="font-size:15px; font-family:Arial; margin-right:10px; margin-left: 10px"> City:</label>
                <select style="margin-left: 10px; font-size:15px; font-family:Arial" name="donorcity" id ="dstate" class="form-model" required></select>
                <br>
                <br>
                <table>
                    <tr>
                        <td>   <input type="text" name="dstreet" size="100" required placeholder="Street for Inventory pick up"/> </td>
                    </tr>
                    <tr>
                        <td>  <input type="text" name="dpost" size="100" required placeholder="Postal Code"/></td>
                    </tr>
                </table>


                <button onclick="myFunction()" type="submit" value="DonorReg" class="btn signup">Sign-up</button>
                <p><a href="login.html">Already Have Account</a></p>
                <hr/>
                <h3 style="text-align: center; font-weight: bold;"><a href="index.html" > Home</a></h3>
            </form>
        </div>
    </div>


</body>

<script>
    function toggleSignup(){
        document.getElementById("login-toggle").style.backgroundColor="#fff";
         document.getElementById("login-toggle").style.color="#222";
         document.getElementById("signup-toggle").style.backgroundColor="#eeee58";
         document.getElementById("signup-toggle").style.color="272727";
         document.getElementById("login-form").style.display="none";
         document.getElementById("donor-form").style.display="block";
     }

       function toggleLogin(){
           document.getElementById("login-toggle").style.backgroundColor="#eeee58";
           document.getElementById("login-toggle").style.color="#272727";
           document.getElementById("signup-toggle").style.backgroundColor="#fff";
           document.getElementById("signup-toggle").style.color="#222";
           document.getElementById("donor-form").style.display="none";
           document.getElementById("login-form").style.display="block";
       }
</script>

<script language="javascript">
    print_state("vcity");
    print_state("dcity");
</script>
</html>

