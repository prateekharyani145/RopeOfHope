/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.Mycon;
import Model.Donor;
import Model.PreviousDonation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mradul
 */
public class DonorDAO 
{
    public boolean insertDonor(Donor d)throws Exception
    {
        
        PreparedStatement ps=null;
        Connection con=Mycon.getConnection();
        String sql=null;
        /*
            1.Donor_id
            2.First_Name, 3.Last_Name
            4.Email_id, 5.Mobile
            6.Street,7.city,8.State,9.Postal
            10.gender
        */
        sql="insert into donor values(0,?,?,?,?,?,?,?,?);";
        ps=con.prepareStatement(sql);
        
        ps.setString(1, d.getDonorFirstName());
        ps.setString(2, d.getDonorLastName());
        ps.setString(3, d.getDonorEmail());
        ps.setString(4, d.getDonorMobile());
        ps.setString(5, d.getDonorStreet());
        ps.setString(6, d.getDonorCity());
        ps.setString(7, d.getDonorState());
        ps.setString(8, d.getDonorPostal());
        
        if(ps.executeUpdate()>0)
            return true;
        else
        return false;
    }
    
    //This is for Taking the Entry of the MONEY DONATED BY THE DONOR..
    public boolean donorMoneyDonation()throws Exception
    {
        return false;
    }
    
    //This is for showing the record of the previous Money donation to each logged in Donor.
    public List prevMoneyDonation(Donor d)throws Exception
    {
        Connection con=Mycon.getConnection();
        String sql=" ";
        PreparedStatement ps=con.prepareStatement(sql);
        return null;
    }
    
    //This is for the ADMIN who can search record of all DONOR in the Organisation.
    public List<Donor> searchAll()throws Exception
    {
        PreparedStatement ps=null;
        Connection con=Mycon.getConnection();
        String sql=null;
        
        sql="select * from donor";
        ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Donor>Dlist=new ArrayList<Donor>();
        int f=0;
         /*
            1.First_Name, 2.Last_Name
            3.Email_id, 4.Mobile
            5.Street, 6.City, 7.State, 
            8.Postal.
        */
         while(rs.next())
        {
            f=1;
            Donor d=new Donor();
            d.setDonorFirstName(rs.getString(2));
            d.setDonorLastName(rs.getString(3));
            d.setDonorEmail(rs.getString(4));
            d.setDonorMobile(rs.getString(5));
            d.setDonorStreet(rs.getString(6));
            d.setDonorCity(rs.getString(7));
            d.setDonorState(rs.getString(8));
            d.setDonorPostal(rs.getString(9));
            Dlist.add(d);
            d=null;
        }
        if(f==1)
            return Dlist;
        else
        {
            Dlist=null;
            return Dlist;
        }
    }
    
    //This is for ADMIN who verify the Donation and Item is added in inventory.
    
    public boolean updateItemDonation(int donationid)throws Exception
    {
        Connection con=Mycon.getConnection();
        String sql="select * from itemdonation where donation_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, donationid);
        ResultSet rs=ps.executeQuery();
        int did=0;
        while(rs.next())
        {
            System.out.println(" In While Loop IN DONOR DAO "+ rs.getInt("donation_id"));
            int itemid=rs.getInt("item_id");
            int qty=rs.getInt("QTY");
            did=rs.getInt("donor_id");
                   
            String tempsql="update inventory set QTY=QTY+? where item_id=?";
            PreparedStatement tempps=con.prepareStatement(tempsql);
            tempps.setInt(1, qty);
            tempps.setInt(2, itemid);
            
            tempps.executeUpdate();                       
        }
        
        sql="update itemdonation set verify=1 where donation_id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1, donationid);
        ps.executeUpdate();
        
        //Fetching the donor Email id to send verification email for the donation.
        String demail=null;
        sql="select Email_id from donor where donor_id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1, did);
        rs=ps.executeQuery();
        if(rs.next())
            demail=rs.getString("Email_id");
        else
        {
            System.out.println("Error in sending mail for received donation.");
            return false;
        }
        if(MailDAO.sendMail(demail, "Donation Received Successfully", "Dear 'Hope', <br>" +
"<br>" +
"We've received your recent donation  for our organization Rope of Hope. <br>" +
"<br>" +
"As you know each cent helps in improving the experience of learning and life for the students at Rope Of Hope and build the dream school they seek.<br> Smallest of contribution will help them to rise from an under privileged lifestyle teaching them desire and will to facilitate equality and fairness for themselves and others.<br>" +
"<br>" +
"Best regards, <br>" +
"Rope Of Hope<br>" +
"\"Be someone's smile keeper.\" "))
            System.out.println("Mail Sent Succesfully to donor for item donation");
        con.close();
        return true;
    }
    
    
    
    //THIS FUNCTION TAKES THE EMAIL OF DONOR AND RETURN FIRST NAME.
    public static String firstName(String Email)throws Exception
    {
        Connection con=Mycon.getConnection();
        String sql="select * from donor where Email_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        
        ResultSet rs=ps.executeQuery();
        
        if(rs.next())
            return rs.getString("First_Name");
      
        return null;
    }
    
    //THIS FUNCTION TAKES THE EMAIL OF THE DONOR AND SENDS THE LIST OF ALL PRVIOUS ITEM DONATION HE HAS PERFORMED.
    public static List prevItemDonation(String Email)throws Exception
    {
        Connection con=Mycon.getConnection();
        
        //FETHCHING DONOR ID FROM DONOR TABLE..
        String sql="select donor_id from donor where Email_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        
        ResultSet rs=ps.executeQuery();
        int did=0;
        
        if(rs.next())
            did=rs.getInt("donor_id");
        else
        {
            System.out.println("In else block where we are fetching the donor_id");
            return null;
        }
        System.out.println("DID:"+did);
        
        //NOW WE WILL FETCH DONATION_ID AND DONATION_DATE USING DONOR_ID.
        List<PreviousDonation> details=new ArrayList<PreviousDonation>();
        
        sql="select * from donation where donor_id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1, did);
        rs=ps.executeQuery();
        
        while(rs.next())//Firsr rs
        {
            //System.out.println("In while loop of first rs");
            String temp_date=rs.getString("Date");
            int temp_donation_id=rs.getInt("donation_id");
            
            PreviousDonation temp=new PreviousDonation();
            temp.setDonation_id(temp_donation_id);
            temp.setDonation_date(temp_date);
            details.add(temp);
            
        }
        if(did==0)
            return null;
        
        //Fetching item details from iteminfo table using donation_id stored in the ArrayList.
        int j=0;
        int[] qty;
        String[] item_name;
        String[] item_type;
        for(int i=0;i<details.size();i++)
        {
            
            qty = new int[12];
            item_name=new String[12];
            item_type = new String[12];
            
            sql="select item_id,QTY from itemdonation where donation_id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, details.get(i).getDonation_id());
            rs=ps.executeQuery();
            j=0;
            System.out.println("DonationId:"+details.get(i).getDonation_id());
            //Here we have multiple item_id. second rs
            while(rs.next())
            {
                System.out.println("In while of second rs");
                int item_id=rs.getInt(1);
                
                qty[j]=rs.getInt(2);//Entering the quantity into array.
                
                String sql2="select name,type from iteminfo where item_id=?";
                
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1, item_id);
                
                ResultSet rs2=ps2.executeQuery();
                if(rs2.next())
                {
                    item_name[j]=rs2.getString(1);
                    item_type[j]=rs2.getString(2);
                }
                else
                {
                    System.out.println("In else block rs2.next()");
                    return null;
                }
                j++;    
            }
            details.get(i).setArraySize(j);
            System.out.println("length of item_name:"+item_name.length+"The value of j:"+j+" length of item_type:"+item_type.length+"\n------\n");
            details.get(i).setQTY(qty);
            details.get(i).setItem_Name(item_name);
            details.get(i).setItem_Type(item_type);
        }
        con.close();
       return details;
    }
}
