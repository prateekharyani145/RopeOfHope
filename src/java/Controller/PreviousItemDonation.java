/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DonorDAO;
import Model.PreviousDonation;
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
public class PreviousItemDonation extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            String Email=null;
            
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            if(session!=null)
            {
                Email=session.getAttribute("Email").toString();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>PreviousItemDonation</title>");            
                out.println("</head>");
                out.println("<body >");
                request.getRequestDispatcher("DonorProfile.jsp").include(request, response);
                out.println("<h2 style='margin-left:35%; color:blue'>Your Previous Donation Details Are!!!</h2>");
                
                List<PreviousDonation> details = new ArrayList<PreviousDonation>();
                try
                {
                    details=DonorDAO.prevItemDonation(Email);
                    out.println("<h4 style='margin-left:30%; color:'><table width=50% height=50%></h4>");
                    for(int i=0;i<details.size();i++)
                    {
                       
                        out.println("<tr><td style='margin-left:35%; color:green'>Donation Date:  "+details.get(i).getDonation_date()+"</td></tr>");
                        
       
                        for(int j=0;j<details.get(i).getArraySize();j++)
                            out.println("<tr style='margin-left:35%; '><td>Item Name:  " +details.get(i).getItem_Name()[j]+"</td><td> Item Type:  " +details.get(i).getItem_Type()[j]+"</td><td> Quantity: "+details.get(i).getQTY()[j]+"</td></tr>\n");
                        out.println("<td><br></td>");
                    }
                
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                    System.out.println("Exception in details "+E.getMessage());
                }
                out.println("</body>");
                out.println("</html>");
            }
            else
            {
                request.getRequestDispatcher("login.html").include(request, response);
                out.println("<h2 style=\"background:whitesmoke; border-radius:15%; width:22%; text-align:center;padding:0.5%; margin-left:69%;\">You Must Login First</h2>");
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
            System.out.println("Exception in previousitemdonation servlet");
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
