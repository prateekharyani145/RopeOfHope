/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
function myLoader() 
{
  var x = document.forms["myForm"]["Email"].value;
  var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid E-mail address");  
  return false; 
  }
  else{
    var x=document.getElementById("e");
    document.getElementById("loader").style.display="block";
  return true;
}
}






