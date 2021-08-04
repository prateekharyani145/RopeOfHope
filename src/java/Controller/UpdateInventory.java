/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class UpdateInventory extends HttpServlet {

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
            out.println("<title>Servlet UpdateInventory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateInventory at " + request.getContextPath() + "</h1>");
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
                    session.setMaxInactiveInterval(320);
                    email=session.getAttribute("email").toString();
                    session.setAttribute("email", email);
                    session.setAttribute("etype", "admin");
                }       
            }
            catch(Exception Exc)
            {
                System.out.println("Error in EmployeeSearch Servlet in session management "+Exc.getMessage());
                response.sendRedirect("error.html");
            }
      
             int Update=Integer.parseInt(request.getParameter("Update")) ;
             
            try
            {
                if(Update==1)//ADD DONATED ITEM IN INVENTORY.THIS would be done by ADMIN
                {
                    EmployeeDAO e=new EmployeeDAO();
                    String Iname=request.getParameter("Iname");  
                    String Itype=request.getParameter("Itype");
                    int QTY=Integer.parseInt(request.getParameter("QTY")) ;

                    out.println(Iname+" "+Itype+" "+QTY);
                    out.println("<br>");
                    out.println("Inventory Added Successfully!!!");
                    out.println("</body>");
                    out.println("</html>");
           
                 
                    e.AddInventory(Iname, Itype,QTY);
                 
                }
                else if(Update==2)//REMOVE ITEM FROM INVENTORY
                {
                    EmployeeDAO e=new EmployeeDAO();
                    String Iname=request.getParameter("Iname");  
                    String Itype=request.getParameter("Itype");
                    int QTY=Integer.parseInt(request.getParameter("QTY")) ;

                    out.println(Iname+" "+Itype+" "+QTY);
                    out.println("<br>");
                    out.println("Inventory Remove Successfully!!!");
                    out.println("</body>");
                    out.println("</html>");
    
                    int status=e.RemoveInventory(Iname, Itype,QTY);
                    if(status==-1)
                        System.out.println("Error in inventory removal");
                    else
                        System.out.println("inventory removal successfull");
                  
                }
            }
              catch(Exception e1)
            {
                System.out.println("Exception in UpdateInventory Servlet "+ e1.getMessage());
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
