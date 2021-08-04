/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DonationEntryDAO;
import Model.DonationStatus;
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
public class InventoryDonationStatus extends HttpServlet {

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
            out.println("<title>InventoryDonationStatus</title>");            
            out.println("</head>");
            out.println("<body style='background:#7ED5EA;'>");
            out.println("<h1 style='text-align:center;'><img src=\"https://img.icons8.com/material-outlined/48/000000/data-pending.png\"> Inventory Donation Status   "+ "</h1>");
            HttpSession session=request.getSession();
        
            try
            {
                if(session.getAttribute("email")==null || !session.getAttribute("etype").equals("admin"))
                {
                    response.sendRedirect("login.html");
                }
                else
                {
                    //Here we will call DonationEntryDAO and will Display the Verify Button for the itemdonation.
                    session.setMaxInactiveInterval(560);
                    List<DonationStatus> donationVerify=new ArrayList<DonationStatus>();
                    DonationEntryDAO D=new DonationEntryDAO();
                    donationVerify=D.donationVerify();
                    
                    if(donationVerify!=null)
                    {
                        for(int i=0;i<donationVerify.size();i++)
                        {   
                            int j=i;
                            int k=0;
                            
                            out.println("<h2 style='text-align:center; color:#e272727;'>Item Donation Details for DonationId: "+donationVerify.get(j).getDonationId()+"</h2>");
                            out.println("<br>");                            
                            out.println("<table border=1 width=100%;>");                            
                            out.println("<tr style='background:#3FD2C7;'><th>Donor Name</th> <th>Donation Date</th> <th>Item Name</th> <th>Item Type</th> <th>Item Quantity</th> </tr>"); 
                            do{ 
                                k++;
                                if(k>=2)
                                    i++;
                            
                                
                            out.println("<tr style='background:#DDEDF4'> <td style='text-align:center; font-size:20px'>"+donationVerify.get(j).getDonorFirstName()+"</td> <td style='text-align:center; font-size:20px'>"+donationVerify.get(j).getDonationDate()+"</td>");
                            out.println("<td style='text-align:center; font-size:20px'>"+ donationVerify.get(j).getItemName()+ "</td><td style='text-align:center; font-size:20px'>"+ donationVerify.get(j).getItemType()+"</td>"); 
                            out.println("<td style='text-align:center; font-size:20px'>"+donationVerify.get(j).getQuantity()+"</td></tr>");
                            if(j+1!=donationVerify.size())
                                j++;
                            else
                                break;
                            
                            }while(donationVerify.get(j).getDonationId()==donationVerify.get(i).getDonationId());
                            
                            out.println("<table><br>");
                            //Form and hidden field
                            out.println("<div align='center'><form action='AddingItemDonation' method='post'><button type='submit'  style='background-color:#272727; color:#eeee58; border:none; border-radius: 5px; font-size:18px;'>Verify The Donation</button>");
                            out.println("<input type='hidden' name='donation_id' value='"+donationVerify.get(i).getDonationId() +"'>");
                            
                            out.println("</form></div>");
                            
                            out.println("<br><hr>");
                        }                    
                    }
                    else
                    {
                        out.println("<br><br><h2 style='text-align:center;'><img src=\"https://img.icons8.com/pastel-glyph/64/000000/empty-box.png\">Oops!! No Current Donation For Verification</h2>");
                    }
                    out.println("<br><br><div><a href='admin.jsp'><img src=\"https://img.icons8.com/android/24/000000/circled-left.png\"> BACK</a></div>");
                }
            }
            catch(Exception Exc)
            {
                System.out.println("Error in  InventoryDonationStatus Servlet in session management "+Exc.getMessage());
                Exc.printStackTrace();
                response.sendRedirect("Error.html");
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
