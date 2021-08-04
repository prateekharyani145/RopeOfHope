/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DonorDAO;
import DAO.EmployeeDAO;
import Model.Donor;
import Model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mradul
 */
public class EmployeeSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EmployeeSearch</title>");
            out.println("</head>");
            out.println("<body style='background:#7ED5EA;'>");
            out.println("<h1 style='font-family:B612-Bold;'>Search Result:</h1>");
            
            HttpSession session=request.getSession();
            String email=null;
            try
            {
                if(session.getAttribute("email")==null || !session.getAttribute("etype").equals("admin"))
                {
                    response.sendRedirect("login.html");
                }
                else
                {
                    session.setMaxInactiveInterval(60);
                    email=session.getAttribute("email").toString();
                    session.setAttribute("email", email);
                    session.setAttribute("etype", "admin");
                }
            }
            catch(Exception Exc)
            {
                System.out.println("Error in EmployeeSearch Servlet in session management "+Exc.getMessage());
                response.sendRedirect("Error.html");
            }


            EmployeeDAO e=new EmployeeDAO();
            List<Employee> Elist=new ArrayList<Employee>();
            int searchAll=Integer.parseInt(request.getParameter("searchAll")) ;
            try
            {
                if(searchAll==1)
                {
                    Elist=e.searchAll();
                    out.println("<h2></h2><table border=1 width=100% height=%>");
                    out.println("<tr style='background:#3FD2C7;'><th>S.no</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><th>Profession</th><th>Education</th><th>Skill</th><th>Street</th><th>City</th><th>State</th><th>Postal</th><th>Gender</th><tr>");

                    for(int i=0;i<Elist.size();i++)
                    {
                        out.println("<tr style='background:#DDEDF4'><td>" + (i+1) + "</td><td>" + Elist.get(i).getFirstname() + "</td><td>" + Elist.get(i).getLastname() + "</td><td>"+ Elist.get(i).getEmail() + "</td><td>"+ Elist.get(i).getMobile() + "</td><td>"+ Elist.get(i).getProfession() + "</td><td>"+ Elist.get(i).getEducation() + "</td><td>"+ Elist.get(i).getSkill() + "</td><td>"+ Elist.get(i).getStreet() + "</td><td>"+ Elist.get(i).getCity() + "</td> <td>"+ Elist.get(i).getState() + "</td><td>"+ Elist.get(i).getPostal() + "</td> <td>"+ Elist.get(i).getGender() +"</td></tr>");
                    }
                    out.println("</table>");
                    out.println("<br>");
                }
                else if(searchAll==2)
                {
                    String fname=request.getParameter("fname");
                    String lname=request.getParameter("lname");
                    Elist=e.searchEmployeeByName(fname, lname);

                    if(Elist!=null)
                    {
                        out.println("<table border=1 width=100% height=100%>");
                        out.println("<tr  style='background:#3FD2C7;'><th>S.no</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><th>Profession</th><th>Education</th><th>Category</th><th>Skill</th><th>Street</th><th>city</th><th>State</th><th>Postal</th><th>Gender</th><tr>");

                        for(int i=0;i<Elist.size();i++)
                        {
                           out.println("<tr style='background:#DDEDF4'><td>" + (i+1) + "</td><td>" + Elist.get(i).getFirstname() + "</td><td>" + Elist.get(i).getLastname() + "</td><td>"+ Elist.get(i).getEmail() + "</td><td>"+ Elist.get(i).getMobile() + "</td><td>"+ Elist.get(i).getProfession() + "</td><td>"+ Elist.get(i).getEducation() + "</td><td>"+ Elist.get(i).getCategory() + "</td><td>"+ Elist.get(i).getSkill() + "</td><td>"+ Elist.get(i).getStreet() + "</td><td>"+ Elist.get(i).getCity() + "</td> <td>"+ Elist.get(i).getState() + "</td><td>"+ Elist.get(i).getPostal() + "</td> <td>"+ Elist.get(i).getGender() +"</td></tr>");

                        }
                        out.println("</table>");
                    out.println("<br>");
                    }
                    else
                    {
                        out.println("<br><h3>Employee Record Not Found.Try Again.</h3>");
                    }
                }
                else if(searchAll==3)
                {
                    String skill=request.getParameter("skill");
                    Elist=e.searchEmployeeBySkill(skill);

                    if(Elist!=null)
                    {
                        out.println("<table border=1 width=100% height=100%>");
                        out.println("<tr  style='background:#3FD2C7;'><th>S.no</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><th>Category</th><th>Street</th><th>City</th><th>State</th><th>Postal</th><th>Gender</th><tr>");

                        for(int i=0;i<Elist.size();i++)
                        {
                            out.println("<tr style='background:#DDEDF4'><td>" + (i+1) + "</td><td>" + Elist.get(i).getFirstname() + "</td><td>" + Elist.get(i).getLastname() + "</td><td>"+ Elist.get(i).getEmail() + "</td><td>"+ Elist.get(i).getMobile() + "</td><td>"+ Elist.get(i).getCategory() + "</td><td>"+ Elist.get(i).getStreet() + "</td><td>"+ Elist.get(i).getCity() + "</td> <td>"+ Elist.get(i).getState() + "</td><td>"+ Elist.get(i).getPostal() + "</td> <td>"+ Elist.get(i).getGender() +"</td></tr>");
                        }
                        out.println("</table>");
                    out.println("<br>");
                    }
                    else
                    {
                        out.println("<br><h3>Employee Record Not Found.Try Again</h3>");
                    }
                }
                else if(searchAll==4)
                {

                    String category=request.getParameter("category");
                    Elist=e.searchEmployeeByCategory(category);

                    if(Elist!=null)
                    {
                         out.println("<table border=1 width=100% height=100%>");
                        out.println("<tr  style='background:#3FD2C7;'><th>S.no</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><th>Skill</th><th>Street</th><th>City</th><th>State</th><th>Postal</th><th>Gender</th><tr>");

                        for(int i=0;i<Elist.size();i++)
                        {
                            out.println("<tr style='background:#DDEDF4'><td>" + (i+1) + "</td><td>" + Elist.get(i).getFirstname() + "</td><td>" + Elist.get(i).getLastname() + "</td><td>"+ Elist.get(i).getEmail() + "</td><td>"+ Elist.get(i).getMobile() + "</td><td>"+ Elist.get(i).getSkill() + "</td><td>"+ Elist.get(i).getStreet() + "</td><td>"+ Elist.get(i).getCity() + "</td> <td>"+ Elist.get(i).getState() + "</td><td>"+ Elist.get(i).getPostal() + "</td> <td>"+ Elist.get(i).getGender() +"</td></tr>");
                        }
                        out.println("</table>");
                    out.println("<br>");
                    }
                    else
                    {
                        out.println("<br><h3>Employee Record Not Found.Try Again.</h3>");
                    }
                }
                else if(searchAll==5)
                {
                    String city=request.getParameter("city");
                    System.out.println("In EmployeeSearchServlet:"+city);
                    Elist=e.searchEmployeeByCity(city);

                    if(Elist!=null)
                    {
                        out.println("<table border=1 width=100% height=100%>");
                        out.println("<tr  style='background:#3FD2C7;'><th>S.no</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><th>Skill</th><th>Category</<th><th>Gender</th><tr>");

                        for(int i=0;i<Elist.size();i++)
                        {
                            out.println("<tr style='background:#DDEDF4'><td>" + (i+1) + "</td><td>" + Elist.get(i).getFirstname() + "</td><td>" + Elist.get(i).getLastname() + "</td><td>"+ Elist.get(i).getEmail() + "</td><td>"+ Elist.get(i).getMobile() + "</td><td>"+ Elist.get(i).getSkill() + "</td><td>"+ Elist.get(i).getCategory() + "</td> <td>"+ Elist.get(i).getGender() +"</td></tr>");

                        }
                        out.println("</table>");
                    out.println("<br>");
                    }
                    else
                    {
                        out.println("<br><h3>Employee Record Not Found.Try Again.</h3>");
                    }
                }
                else if(searchAll==6)
                {
                    DonorDAO d=new DonorDAO();
                    List<Donor> Dlist=new ArrayList<Donor>();
                    try
                    {
                        Dlist=d.searchAll();
                        out.println("<table border=1 width=100% height=%>");
                        out.println("<tr style='background:#3FD2C7;'><th>S.no</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><<th>Street</th><th>City</th><th>State</th><th>Postal</th></tr>");

                        for(int i=0;i<Dlist.size();i++)
                        {
                            out.println("<tr style='background:#DDEDF4'><td>" + (i+1) + "</td><td>" + Dlist.get(i).getDonorFirstName() + "</td><td>" + Dlist.get(i).getDonorLastName() + "</td><td>"+ Dlist.get(i).getDonorEmail() + "</td><td>"+ Dlist.get(i).getDonorMobile() + "</td><td>"+Dlist.get(i).getDonorStreet()+"</td><td>"+Dlist.get(i).getDonorCity()+"</td><td>"+Dlist.get(i).getDonorState()+"</td><td>"+Dlist.get(i).getDonorPostal()+"</td></tr>");
                        }
                        out.println("</table>");
                    out.println("<br>");

                    }
                    catch(Exception e1)
                    {
                        System.out.println("Exception in DonorSearch Servlet "+ e1.getMessage());
                    }
                }
                else if(searchAll==7)
               {
                   String Iname=request.getParameter("Iname");
                   String Itype=request.getParameter("Itype");
                   int num=e.searchInventory(Iname ,Itype);
                   out.println("<table border=1 width=30% height=30%>");
                   out.println("<tr  style='background:#3FD2C7;'><th>Item</th><th>Type</th><th>QTY</th></tr>");
                   out.println("<tr style='background:#DDEDF4'><td>" + Iname + "</td><td>" + Itype + "</td><td>" + num + "</td></tr>");
                   out.println("</table>");
                    out.println("<br>");

               }

                else if(searchAll==8)
                {
                    String fname=request.getParameter("fname");
                    Elist=e.searchEmployeeByFirstName(fname);

                    if(Elist!=null)
                    {
                        out.println("<table border=1 width=100% height=100%>");
                        out.println("<tr  style='background:#3FD2C7;'><th>S.no</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile</th><th>Profession</th><th>Education</th><th>Category</th><th>Skill</th><th>Street</th><th>city</th><th>State</th><th>Postal</th><th>Gender</th><tr>");

                        for(int i=0;i<Elist.size();i++)
                        {
                           out.println("<tr style='background:#DDEDF4'><td>" + (i+1) + "</td><td>" + Elist.get(i).getFirstname() + "</td><td>" + Elist.get(i).getLastname() + "</td><td>"+ Elist.get(i).getEmail() + "</td><td>"+ Elist.get(i).getMobile() + "</td><td>"+ Elist.get(i).getProfession() + "</td><td>"+ Elist.get(i).getEducation() + "</td><td>"+ Elist.get(i).getCategory() + "</td><td>"+ Elist.get(i).getSkill() + "</td><td>"+ Elist.get(i).getStreet() + "</td><td>"+ Elist.get(i).getCity() + "</td> <td>"+ Elist.get(i).getState() + "</td><td>"+ Elist.get(i).getPostal() + "</td> <td>"+ Elist.get(i).getGender() +"</td></tr>");
                        }
                        out.println("</table>");
                    out.println("<br>");
                    }
                    else
                    {
                        out.println("<br><h3>Employee Record Not Found.Try Again.</h3>");
                    }
                }

                 out.println("<button><a href='admin.jsp'>Back</a></button>");

            }
            catch(Exception e1)
            {
                System.out.println("Exception in EmployeeSearch Servlet "+ e1.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
