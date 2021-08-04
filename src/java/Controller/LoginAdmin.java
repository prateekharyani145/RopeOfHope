/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mradul
 */
public class LoginAdmin extends HttpServlet {

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
            out.println("<title>Invalid Entry</title>");            
            out.println("</head>");
            out.println("<body>");
           
            out.println("</body>");
            out.println("</html>");
            
            String Email=request.getParameter("vemail");
            String pass=request.getParameter("pass");
            String etype=null;
            if(Email.equalsIgnoreCase("NanaktheLegend@gmail.com") && pass.equalsIgnoreCase("NanakRopeofHope"))
            {
                etype="admin";
                HttpSession session=request.getSession();
                session.setAttribute("email", Email);
                session.setAttribute("etype", etype);
                response.sendRedirect("admin.jsp");
            }
            else
            {
                LoginDAO d1=new LoginDAO();
                try
                {
                    if(d1.checkEmployeeLogin(Email, pass))
                    {   
                        etype="volunteer";
                        HttpSession session=request.getSession();
                        session.setAttribute("email", Email);
                        session.setAttribute("etype", etype);
                        response.sendRedirect("volunteerlogin.jsp");
                    }
                    else
                    {
                        request.getRequestDispatcher("login.html").include(request, response);
                       out.println("<h2 style=\"background:whitesmoke; border-radius:15%; width:22%; text-align:center;padding:0.5%; margin-left:69%;\">Enter Correct User Credentials</h2>");
                       // out.println("<script>alert(\"Enter the Correct User Credentials. \")</script>");
                    }
                }
                catch(Exception E)
                {
                    System.out.println("Exception occured During Login "+E.getMessage());
                    response.sendRedirect("Error.html");
                }
            }
            
            
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
