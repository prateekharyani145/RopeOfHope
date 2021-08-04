/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.Mycon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
/**
 *
 * @author Mradul
 */
public class PinDAO 
{
    //THIS FUNCTION IS USED TO GENERATE THE OTP or PIN.
    public static String pinGenerate()
    {
        String numbers = "0123456789"; 
        Random rndm_method = new Random(); 
        char[] otp = new char[6]; 
  
        for (int i = 0; i < 6; i++) 
        { 
            otp[i] =numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return String.valueOf(otp); 
    }
    //THIS FUNCTION MAKES ENTRY OF PIN CORRESPONDING TO THE EMAIL.
    public boolean pinEntry(String Email,String Pin)
    {
        Connection con=Mycon.getConnection();
        try{
        PreparedStatement ps=null;
        String sql="insert into verifyuser values(?,?)";
        
        ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        ps.setString(2, Pin);
        int i=ps.executeUpdate();
        con.close();
        if(i>0)
            return true;  
        }
        catch(Exception E)
        {
            System.out.println("Exception in PinDAO " + E.getMessage());
            return false;
        }
        
        return false;
    }
    
    //THIS FUNCTION MAKES ENTRY OF PIN CORRESPONDING TO THE EMAIL FOR THE CHANGING PASSWORD REQUEST.
    public boolean pinEntry2(String Email,String Pin)
    {
        Connection con=Mycon.getConnection();
        try{
        PreparedStatement ps=null;
        String sql="insert into forgotpass values(?,?)";
        
        ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        ps.setString(2, Pin);
        int i=ps.executeUpdate();
        con.close();
        if(i>0)
            return true;  
        }
        catch(Exception E)
        {
            System.out.println("Exception in PinDAO " + E.getMessage());
            return false;
        }
        
        return false;
    }
    //THIS FUNCTION CHECKS ENTERED PIN IS CORRECT OR NOT.
    public static String checkPin(String Pin)throws Exception
    {
        String Email=null;
        Connection con=Mycon.getConnection();
        PreparedStatement ps =null;
        String sql="select Email from verifyuser where Pin=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, Pin);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            Email=rs.getString("Email");
            con.close();
            return Email;
        }
        con.close();
        return null;            
    }
    
    //THIS FUNCTION CHECKS ENTERED PIN IS CORRECT OR NOT.
    public static String checkPin2(String Pin)throws Exception
    {
        String Email=null;
        Connection con=Mycon.getConnection();
        PreparedStatement ps =null;
        String sql="select Email from forgotpass where Pin=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, Pin);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            Email=rs.getString("Email");
            con.close();
            return Email;
        }
        con.close();
        return null;            
    }
    
    public static  boolean pinDelete(String Email)throws Exception
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=null;
        String sql="delete from verifyuser where Email=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        if(ps.executeUpdate()>0)
        {
            con.close();
            return true;
        }
        con.close();
        return false;
    }
    
     public static  boolean pinDelete2(String Email)throws Exception
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=null;
        String sql="delete from forgotpass where Email=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        if(ps.executeUpdate()>0)
        {
            con.close();
            return true;
        }
        con.close();
        return false;
    }
    
}
