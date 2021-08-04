/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DonorDAO;
import DAO.EmployeeDAO;
import DAO.PinDAO;
import Model.Donor;
import Model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mradul
 */
public class UserSignup extends HttpServlet {

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
            out.println("<title>Servlet UserSignup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserSignup at " + request.getContextPath()  + "</h1>");
           
            int vtype=Integer.parseInt(request.getParameter("vtype"));
            System.out.println("vtype" +vtype);
            out.println("<h1>Servlet UserSignup at " + request.getContextPath()+" vtype"+vtype  + "</h1>");
            switch(vtype)
            {
                case 1:
                try
                {
                    String email=request.getParameter("vemail"); 
                    String password=request.getParameter("vcpass");                    
                    String fname=request.getParameter("vfname");                                       
                    String lname=request.getParameter("vlname");                    
                    String mob=request.getParameter("vmob");                    
                    String qualification=request.getParameter("quali");                    
                    String profession=request.getParameter("prof");                   
                    String gender=request.getParameter("gender");                   
                    String category=request.getParameter("Category");  
                    String skill=request.getParameter("skill");
                    String State=request.getParameter("volstate");                   
                    String city=request.getParameter("volcity");                    
                    String street=request.getParameter("vstreet");                    
                    String postal=request.getParameter("vpostal");                   
                    
                    System.out.println("Value Fetched Succesfully");
                    Employee E=new Employee();
                    
                    E.setEmail(email);
                    E.setFirstname(fname);
                    E.setLastname(lname);
                    E.setPassword(password);
                    E.setMobile("+91-"+mob);
                    E.setCity(city);
                    E.setCategory(category);
                    E.setEducation(qualification);
                    E.setStreet(street);
                    E.setState(State);
                    E.setGender(gender);
                    E.setSkill(skill);
                    E.setPostal(postal);
                    E.setProfession(profession);
                    
                    EmployeeDAO Ed=new EmployeeDAO();
                    if(Ed.insertEmployee(E))
                    {
                        PinDAO.pinDelete(email);
                        response.sendRedirect("Success.html");
                    }
                    else
                    {
                        response.sendRedirect("Error.html");
                    }
                }
                catch(Exception Ex)
                {
                    System.out.println("Error in UserSignup in Volunteer Signup Form "+ Ex.getMessage());
                    response.sendRedirect("Error.html");

                }
                break;
                
                //FETCHING THE DATA OF THE DONOR FORM FROM THE SIGNUP>HTML
            case 2:
            
                try
                {
                    String email=request.getParameter("demail");
                    String fname=request.getParameter("dfname");
                    String lname=request.getParameter("dlname");
                    String mob=request.getParameter("dmob");
                    String State=request.getParameter("donorstate");
                    String city=request.getParameter("donorcity");
                    String street=request.getParameter("dstreet");
                    String postal=request.getParameter("dpost");
                    
                    Donor D=new Donor();
                    
                    D.setDonorEmail(email);
                    D.setDonorFirstName(fname);
                    D.setDonorLastName(lname);
                    D.setDonorMobile("+91-"+mob);
                    D.setDonorCity(city);
                    D.setDonorStreet(street);
                    D.setDonorState(State);
                    D.setDonorPostal(postal);
                    
                    DonorDAO DDAO=new DonorDAO();
                    if(DDAO.insertDonor(D))
                    {
                        PinDAO.pinDelete(email);
                        response.sendRedirect("Success.html");
                    }
                    else
                    {
                        response.sendRedirect("Error.html");
                    }
                }
                catch(Exception Ex)
                {
                    System.out.println("Error in UserSignup in Donor Signup Form "+ Ex.getMessage());
                    response.sendRedirect("Error.html");
                }   
                break;
                
                default: response.sendRedirect("Error.html");            
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
