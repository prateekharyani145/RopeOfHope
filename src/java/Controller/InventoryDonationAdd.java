/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DonationEntryDAO;
import DAO.MailDAO;
import Model.ItemInfo;
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
public class InventoryDonationAdd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * THIS SERVLET IS ACCESSED FROM INVENTORYDONATION.JSP AND IN THIS SERVLET WE WILL SET ALL ITEM DETAILS AND WILL FORWARD IT TO DONATION ENTRY DAO.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InventoryDonationAdd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>InventoryDonationAdd </h1>");
            HttpSession session=request.getSession(false);
            if(session.getAttribute("Email")==null || !session.getAttribute("etype").equals("Donor"))
            {
                response.sendRedirect("login.html");
            }
            
            
            String Email=session.getAttribute("Email").toString();
            
            
            
            List<ItemInfo>Item=new ArrayList<ItemInfo>();
            DonationEntryDAO Id=new DonationEntryDAO();
            try
            {
                String Pencil=request.getParameter("Pencil");
                String Drawing=request.getParameter("Drawing");
                String Copy=request.getParameter("Copy");
                String Color=request.getParameter("Color");
                String Pen=request.getParameter("Pen");
                String Scale=request.getParameter("Scale");
                String Erasers=request.getParameter("Eraser");
                String Sharpners=request.getParameter("Sharpener");
                String Board=request.getParameter("Board");
                String Chalk=request.getParameter("Chalk");
                String Duster=request.getParameter("Duster");
                String StudyTable=request.getParameter("StudyTable");
                
                System.out.println("Pencil "+ Pencil);
                System.out.println("Drawing "+ Drawing);
                System.out.println("Copy "+ Copy);
                System.out.println("Color "+ Color);
                System.out.println("Pen "+Pen);
                System.out.println("Scale "+ Scale);
                System.out.println("Eraser "+ Erasers);
                System.out.println("Sharpners "+ Sharpners);
                System.out.println("Board "+ Board);
                System.out.println("Chalk "+ Chalk);
                System.out.println("Duster "+ Duster);
                System.out.println("StudyTable "+ StudyTable);
                
                String PencilType=request.getParameter("penciltype");
                String DrawingType=request.getParameter("drawingtype");
                String CopyType=request.getParameter("copytype");
                String ColorType=request.getParameter("colortype");
                String PenType=request.getParameter("pentype");
                String ScaleType=request.getParameter("scaletype");
                String ErasersType=request.getParameter("erasertype");
                String SharpnersType=request.getParameter("sharpenertype");
                String BoardType=request.getParameter("boardtype");
                String ChalkType=request.getParameter("chalktype");
                String DusterType=request.getParameter("dustertype");
                String StudyTableType=request.getParameter("studytabletype");
                int flag=0;
                
                if(Pencil != null && PencilType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                
                if(Drawing!=null && DrawingType.equalsIgnoreCase("none") )
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(Copy!=null && CopyType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(Color!=null &&  ColorType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(Pen!=null && PenType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(Scale!=null && ScaleType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(Erasers!=null && ErasersType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(Sharpners!=null && SharpnersType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(Board!=null &&  BoardType.equalsIgnoreCase("none"))
                {
                    
                }
                if(Chalk!=null &&  ChalkType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                
                if(Duster!=null && DusterType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                if(StudyTable!=null && StudyTableType.equalsIgnoreCase("none"))
                {
                    flag=-1;
                    System.out.println("None Condition");
                    response.sendRedirect("Error.html");
                }
                
                if(flag==0)
                {
                    boolean flag2=false;
                        if(Pencil!=null && Pencil.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            
                            int pencilQty=Integer.parseInt(request.getParameter("PencilQTY"));

                            temp.setItemName("Pencil");
                            temp.setItemType(PencilType);
                            temp.setQuantity(pencilQty);

                            Item.add(temp);
                            System.out.println("Pencil "+"Type: "+PencilType+" Quantity: "+pencilQty);
                        }

                        if(Drawing!=null && Drawing.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int DrawingQty=Integer.parseInt(request.getParameter("DrawingQTY"));

                            temp.setItemName("Drawing");
                            temp.setItemType(DrawingType);
                            temp.setQuantity(DrawingQty);

                            Item.add(temp);


                            System.out.println("Drawing"+"Type: "+DrawingType+" Quantity: "+DrawingQty);
                        }

                        if(Copy!=null && Copy.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int CopyQty=Integer.parseInt(request.getParameter("CopyQTY"));

                            temp.setItemName("Copy");
                            temp.setItemType(CopyType);
                            temp.setQuantity(CopyQty);

                            Item.add(temp);


                            System.out.println("Copy"+"Type: "+CopyType+" Quantity: "+CopyQty);
                        }


                        if(Color!=null && Color.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int ColorQty=Integer.parseInt(request.getParameter("ColorQTY"));

                            temp.setItemName("Colour");
                            temp.setItemType(ColorType);
                            temp.setQuantity(ColorQty);

                            Item.add(temp);


                            System.out.println("Color"+"Type: "+ColorType+" Quantity: "+ColorQty);
                        }

                        if(Pen!=null && Pen.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int PenQty=Integer.parseInt(request.getParameter("PenQTY"));

                            temp.setItemName("Pen");
                            temp.setItemType(PenType);
                            temp.setQuantity(PenQty);

                            Item.add(temp);


                            System.out.println("Pen"+"Type: "+PenType+" Quantity: "+PenQty);
                        }

                        if(Scale!=null && Scale.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                           

                            int ScaleQty=Integer.parseInt(request.getParameter("ScaleQTY"));

                            temp.setItemName("Scale");
                            temp.setItemType(ScaleType);
                            temp.setQuantity(ScaleQty);

                            Item.add(temp);


                            System.out.println("Scale"+"Type: "+ScaleType+" Quantity: "+ScaleQty);
                        }

                        if(Erasers!=null && Erasers.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                           

                            int ErasersQty=Integer.parseInt(request.getParameter("EraserQTY"));

                            temp.setItemName("Eraser");
                            temp.setItemType(ErasersType);
                            temp.setQuantity(ErasersQty);

                            Item.add(temp);


                            System.out.println("Eraser"+"Type: "+ErasersType+" Quantity: "+ErasersQty);
                        }

                        if(Sharpners!=null && Sharpners.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int SharpnersQty=Integer.parseInt(request.getParameter("SharpenerQTY"));

                            temp.setItemName("Sharpener");
                            temp.setItemType(SharpnersType);
                            temp.setQuantity(SharpnersQty);

                            Item.add(temp);


                            System.out.println("Sharpner"+"Type: "+SharpnersType+" Quantity: "+SharpnersQty);
                        }

                        if(Board!=null && Board.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int BoardQty=Integer.parseInt(request.getParameter("BoardQTY"));

                            temp.setItemName("Board");
                            temp.setItemType(BoardType);
                            temp.setQuantity(BoardQty);

                            Item.add(temp);


                            System.out.println("Board"+"Type: "+BoardType+" Quantity: "+BoardQty);
                        }

                        if(Chalk!=null && Chalk.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int ChalkQty=Integer.parseInt(request.getParameter("ChalkQTY"));

                            temp.setItemName("Chalk");
                            temp.setItemType(ChalkType);
                            temp.setQuantity(ChalkQty);

                            Item.add(temp);


                            System.out.println("Chalk"+"Type: "+ChalkType+" Quantity: "+ChalkQty);
                        }


                        if(Duster!=null && Duster.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                            

                            int DusterQty=Integer.parseInt(request.getParameter("DusterQTY"));

                            temp.setItemName("Duster");
                            temp.setItemType(DusterType);
                            temp.setQuantity(DusterQty);

                            Item.add(temp);


                            System.out.println("Duster"+"Type: "+DusterType+" Quantity: "+DusterQty);
                        }


                        if(StudyTable!=null && StudyTable.equals("on"))
                        {
                            flag2=true;
                            ItemInfo temp=new ItemInfo();
                           

                            int StudyTableQty=Integer.parseInt(request.getParameter("StudyTableQTY"));

                            temp.setItemName("StudyTable");
                            temp.setItemType(StudyTableType);
                            temp.setQuantity(StudyTableQty);

                            Item.add(temp);


                            System.out.println("StudyTable"+"Type: "+StudyTableType+" Quantity: "+StudyTableQty);
                        }


                        //ADDING DONATION IN DATABASE
                        if(flag2 && Id.addDonation(Email,Item))
                        {
                            MailDAO.sendMail(Email,"Donation Request Received","Dear Hope,<br>" +"We have received your donation request,<br> our volunteer will be reviewing this and will contact you personally soon for further donation process.<br><br><h3>For Further Queries Please Call Us +91-9109104350.<br>Regards Rope Of Hope.</h3>");
                            response.sendRedirect("DonationSuccess.html");
                        }
                        else
                        {
                            response.sendRedirect("Error.html");
                        }
            }//else of the none if.. 
            }
            catch(Exception E)
            {
                System.out.println("Error in InventoryDonationAdd.java "+ E.getMessage() );
                E.printStackTrace();
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
