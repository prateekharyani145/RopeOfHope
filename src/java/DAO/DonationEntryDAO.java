/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.Mycon;
import Model.DonationStatus;
import Model.ItemInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;



import java.util.List;

/**
 *
 * @author Mradul
 */
public class DonationEntryDAO 
{
    //This methid is used to add entry of each donation in donation table.
    public boolean addDonation(String Email,List<ItemInfo> Id)throws Exception
    {
        int donorid;
        Connection con=Mycon.getConnection();
        //Fetching the donor_id to add Donation in Donation Table
        String sql="select donor_id from donor where Email_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        
        System.out.println(Email);
        
        ResultSet rs=ps.executeQuery();
        
        
        if(rs.next())
        {
            donorid=rs.getInt("donor_id");
            System.out.println(donorid);
            
            LocalDate Date=LocalDate.now();
            String date=Date.toString();
            sql="insert into donation values(0,?,?)";
            
            ps=con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setInt(2,donorid);
            
            int status=ps.executeUpdate();
            if(status==0)
                return false;
            //Now Insert data into inventory donation table using item object
            
            for(int i=0;i<Id.size();i++)
            {
                sql="select donation_id from donation order by donation_id desc limit 1";
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                int donation_id=0;
                
                if(rs.next())
                    donation_id=rs.getInt("donation_id");
                else
                    return false;
                System.out.println("Donation_id "+donation_id);
                
                //now fetch itemid using ITEM object from database
                sql="select item_id from iteminfo where Name=? and Type=?";
                ps=con.prepareStatement(sql);
                System.out.println("prepares statement for fetching item_id and item name:"+Id.get(i).getItemName()+ "item_type:"+ Id.get(i).getItemType()+" QTY "+Id.get(i).getQuantity());
                ps.setString(1,Id.get(i).getItemName());
                ps.setString(2,Id.get(i).getItemType());
                
                rs=ps.executeQuery();
                
                if(rs.next())
                {
                    int qty=Id.get(i).getQuantity();
                    System.out.println("Quantity "+ qty);
                    int item_id=rs.getInt("Item_id");
                    sql="insert into itemdonation values(?,?,?,?,0)";
                    ps=con.prepareStatement(sql);
                    ps.setInt(1,item_id);
                    ps.setInt(2,qty);
                    ps.setInt(3, donation_id);
                    ps.setInt(4,donorid);
                    ps.executeUpdate();
                    
                }else   return false;
                
            }
            
            System.out.println("DonationEntryDAO");
            
            return true;
        }
        
        System.out.println("Item not added");
        return false;
    }
    
    public List donationVerify()throws Exception
    {
        List<DonationStatus> donationVerify= new ArrayList<DonationStatus>();
        Connection con=Mycon.getConnection();
        String sql="select * from itemdonation where verify=0";
        PreparedStatement ps=con.prepareStatement(sql);
        boolean flag=false;
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            flag=true;
            DonationStatus d=new DonationStatus();
            int itemid=rs.getInt("item_id");
            int donationid=rs.getInt("donation_id");
            int qty=rs.getInt("QTY");
            int donorid=rs.getInt("donor_id");
             
            //now defining one more connection to the database
           
            PreparedStatement tempps=null;
            String tempsql=null;
            
            //now fetching itemname
            tempsql="select Name,Type from iteminfo where item_id=?";
            tempps=con.prepareStatement(tempsql);
            tempps.setInt(1, itemid);
            ResultSet temprs=tempps.executeQuery();
            
            if(temprs.next())//item donation name and type
            {
                d.setItemName(temprs.getString("Name"));
                d.setItemType(temprs.getString("Type"));               
            }
            
            //Now fetching donation date
            tempsql="select Date from donation where donation_id=?";
            tempps=con.prepareStatement(tempsql);
            tempps.setInt(1, donationid);
            temprs=tempps.executeQuery();
            
            if(temprs.next())//item donation date , donationid , qty
            {
                d.setDonationDate(temprs.getString("Date"));
                d.setDonationId(donationid);
                d.setQuantity(qty);
            }
            
            //Now fetching the firstname of the donor
            
            tempsql="select First_Name from donor where donor_id=?";
            tempps=con.prepareStatement(tempsql);
            tempps.setInt(1, donorid);
            temprs=tempps.executeQuery();
            
            if(temprs.next())//setting donor firstname
            {
                d.setDonorFirstName(temprs.getString("First_Name"));
            }
            if(d!=null)
                donationVerify.add(d);
            
            d=null;           
        }
        if(flag)
            return donationVerify;
        return null;
    }
    
}
