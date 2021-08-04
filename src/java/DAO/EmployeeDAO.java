/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.Mycon;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mradul
 */
public class EmployeeDAO 
{
    public boolean insertEmployee(Employee E)throws Exception
    {
        PreparedStatement ps=null;
        Connection con=Mycon.getConnection();
        String sql=null;
        /*
            1.Employee_id
            2.First_Name, 3.Last_Name
            4.Email_id, 5.Mobile
            6.password, 7.Profession, 8.Education, 
            9.Street,10.City, 11.State,   12.Postal
            13.Category
            14.skill_type
            15.gender
        */
        sql="insert into Employee values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        ps=con.prepareStatement(sql);
        ps.setString(1, E.getFirstname());
        ps.setString(2, E.getLastname());
        ps.setString(3, E.getEmail());
        ps.setString(4, E.getMobile());
        ps.setString(5, E.getPassword());
        ps.setString(6, E.getProfession());
        ps.setString(7, E.getEducation());
        ps.setString(8, E.getStreet());
        ps.setString(9, E.getCity());
        ps.setString(10, E.getState());
        ps.setString(11, E.getPostal());
        ps.setString(12, E.getCategory());
        ps.setString(13, E.getSkill());
        ps.setString(14, E.getGender());
        
       
        
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;
    }
    //search all information operation on the employee table
    public List searchAll()throws Exception
    {
        PreparedStatement ps=null;
        Connection con=Mycon.getConnection();
        String sql=null;
        
        sql="select * from Employee;";
        ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Employee>Elist=new ArrayList<Employee>();
        byte f=0;
         /*
            1.Employee_id
            2.First_Name, 3.Last_Name
            4.Email_id, 5.Mobile
            6.password, 7.Profession, 8.Education, 
            9.Street,10.City, 11.State,   12.Postal
            13.Category
            14.skill_type
            15.gender
        */
        
        while(rs.next())
        {
            f=1;
            Employee E=new Employee();
            E.setFirstname(rs.getString(2));
            E.setLastname(rs.getString(3));
            E.setEmail(rs.getString(4));
            E.setMobile(rs.getString(5));
         // E.setPassword(rs.getString(6));
            E.setProfession(rs.getString(7));
            E.setEducation(rs.getString(8));
            E.setStreet(rs.getString(9));
            E.setCity(rs.getString(10));
            E.setState(rs.getString(11));
            E.setPostal(rs.getString(12));
            E.setCategory(rs.getString(13));
            E.setSkill(rs.getString(14));
            E.setGender(rs.getString(15));
            Elist.add(E);
            E=null;
        }
        if(f==1)
            return Elist;
        else
        {
            Elist=null;
            return Elist;
        }
   
    }
    
    //Search Employee by using both First-Name and Last-Name
    public List searchEmployeeByName(String fname,String lname)throws Exception
    {
        Connection con=Mycon.getConnection();
        
        String sql="select * from Employee where First_Name=? and Last_Name=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1, fname);
        ps.setString(2, lname);
        
        ResultSet rs=ps.executeQuery();
        List<Employee> Elist=new ArrayList<Employee>();
        
        byte f=0;
        while(rs.next())
        {
            f=1;
            Employee E=new Employee();
            E.setFirstname(rs.getString(2));
            E.setLastname(rs.getString(3));
            E.setEmail(rs.getString(4));
            E.setMobile(rs.getString(5));
          //E.setPassword(rs.getString(6));
            E.setProfession(rs.getString(7));
            E.setEducation(rs.getString(8));
            E.setStreet(rs.getString(9));
            E.setCity(rs.getString(10));
            E.setState(rs.getString(11));
            E.setPostal(rs.getString(12));
            E.setCategory(rs.getString(13));
            E.setSkill(rs.getString(14));
            E.setGender(rs.getString(15));
            Elist.add(E);
            E=null;
        }
        if(f==1)
            return Elist;
        else
        {
            Elist=null;
            return Elist;
        }
    }
    
    
    public List searchEmployeeBySkill(String skill)throws Exception
    {
        Connection con=Mycon.getConnection();
        
        String sql="select * from Employee where skill_type=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1, skill);
        
        ResultSet rs=ps.executeQuery();
        List<Employee> Elist=new ArrayList<Employee>();
        
        byte f=0;
        while(rs.next())
        {
            f=1;
            Employee E=new Employee();
            E.setFirstname(rs.getString(2));
            E.setLastname(rs.getString(3));
            E.setEmail(rs.getString(4));
            E.setMobile(rs.getString(5));
          //E.setPassword(rs.getString(6));
            E.setProfession(rs.getString(7));
            E.setEducation(rs.getString(8));
            E.setStreet(rs.getString(9));
            E.setCity(rs.getString(10));
            E.setState(rs.getString(11));
            E.setPostal(rs.getString(12));
            E.setCategory(rs.getString(13));
            E.setSkill(rs.getString(14));
            E.setGender(rs.getString(15));
            Elist.add(E);
            E=null;
        }
        if(f==1)
            return Elist;
        else
        {
            Elist=null;
            return Elist;
        }
    }
    
    public List searchEmployeeByCategory(String category)throws Exception
    {
        Connection con=Mycon.getConnection();
        
        String sql="select * from Employee where Category=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1, category);
        
        ResultSet rs=ps.executeQuery();
        List<Employee> Elist=new ArrayList<Employee>();
        
        byte f=0;
        while(rs.next())
        {
            f=1;
            Employee E=new Employee();
            E.setFirstname(rs.getString(2));
            E.setLastname(rs.getString(3));
            E.setEmail(rs.getString(4));
            E.setMobile(rs.getString(5));
          //E.setPassword(rs.getString(6));
            E.setProfession(rs.getString(7));
            E.setEducation(rs.getString(8));
            E.setStreet(rs.getString(9));
            E.setCity(rs.getString(10));
            E.setState(rs.getString(11));
            E.setPostal(rs.getString(12));
            E.setCategory(rs.getString(13));
            E.setSkill(rs.getString(14));
            E.setGender(rs.getString(15));
            Elist.add(E);
            E=null;
        }
        if(f==1)
            return Elist;
        else
        {
            Elist=null;
            return Elist;
        }
    }
    
    
    public List searchEmployeeByCity(String city)throws Exception
    {
        Connection con=Mycon.getConnection();
        
        String sql="select * from Employee where City=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1, city);
        
        ResultSet rs=ps.executeQuery();
        List<Employee> Elist=new ArrayList<Employee>();
        
        byte f=0;
        while(rs.next())
        {
            f=1;
            Employee E=new Employee();
            E.setFirstname(rs.getString(2));
            E.setLastname(rs.getString(3));
            E.setEmail(rs.getString(4));
            E.setMobile(rs.getString(5));
          //E.setPassword(rs.getString(6));
            E.setProfession(rs.getString(7));
            E.setEducation(rs.getString(8));
            E.setStreet(rs.getString(9));
            E.setCity(rs.getString(10));
            E.setState(rs.getString(11));
            E.setPostal(rs.getString(12));
            E.setCategory(rs.getString(13));
            E.setSkill(rs.getString(14));
            E.setGender(rs.getString(15));
            Elist.add(E);
            E=null;
        }
        if(f==1)
            return Elist;
        else
        {
            Elist=null;
            return Elist;
        }   
    }
    
    /*
    Table iteminfo
        1.item_id
        2.Name
        3.Type    
    */
    //Search for the quantity of the particular item from inventory.
    public int searchInventory(String Iname,String Itype)throws Exception
    {
        Connection con=Mycon.getConnection();
        int item_id=0;
        String sql="select item_id from iteminfo where Name=? and Type=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1, Iname);
        ps.setString(2, Itype);
        ResultSet rs=ps.executeQuery();
        
        if(rs.next())
        {
            item_id=rs.getInt("item_id");
            sql="select QTY from inventory where item_id=?;";
            ps=con.prepareStatement(sql);
            ps.setInt(1, item_id);
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                item_id=rs.getInt("QTY");
                System.out.println("Item QTY:"+item_id);
                return item_id;
            }
            else
                return 0;
        }
        
            return 0;
    }
    //Update the ITEMS IN THE INVENTORY THIS IS THE OPERATION PERFORMED ONLY BY ADMIN
    public int AddInventory(String Iname,String Itype, int QTY)throws Exception
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=con.prepareStatement("select item_id from iteminfo where Name=? and Type=?");
        ps.setString(1, Iname);
        ps.setString(2,Itype);
        
        ResultSet rs=ps.executeQuery();
        int itemid=0;
        if(rs.next())
        {
            itemid=rs.getInt(1);
        }
        
              
        ps=con.prepareStatement("update inventory set QTY=QTY+? where item_id =?");
         
        ps.setInt(1,QTY);
        ps.setInt(2, itemid);
        
        int resp=ps.executeUpdate();
        
        return resp;
    }
    
    public int RemoveInventory(String Iname,String Itype, int QTY)throws Exception
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=con.prepareStatement("select item_id from iteminfo where Name=? and Type=?");
        ps.setString(1, Iname);
        ps.setString(2,Itype);
        
        ResultSet rs=ps.executeQuery();
        int itemid=0;
        if(rs.next())
        {
            itemid=rs.getInt("item_id");
        }
             
        System.out.println("item_id is :"+itemid);
        ps=con.prepareStatement("select QTY from inventory where item_id=?;");
        ps.setInt(1,itemid);
        rs=ps.executeQuery();
        
        int presentqty=0;
        
        if(rs.next())
            presentqty=rs.getInt("QTY");
        
        if(presentqty>10 && presentqty>QTY)
        {
            ps=con.prepareStatement("update inventory set QTY=QTY-? where item_id =?");
            ps.setInt(1,QTY);
            ps.setInt(2, itemid);
            return ps.executeUpdate();
        }
        return -1;
    }
    
    //SEARCH EMPLOYEE BY FIRST NAME 
    public List searchEmployeeByFirstName(String fname)throws Exception
    {
        Connection con=Mycon.getConnection();
        
        String sql="select * from Employee where First_Name=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        
        ps.setString(1, fname);
   
        
        ResultSet rs=ps.executeQuery();
        List<Employee> Elist=new ArrayList<Employee>();
        
        byte f=0;
        while(rs.next())
        {
            f=1;
            Employee E=new Employee();
            E.setFirstname(rs.getString(2));
            E.setLastname(rs.getString(3));
            E.setEmail(rs.getString(4));
            E.setMobile(rs.getString(5));
          //E.setPassword(rs.getString(6));
            E.setProfession(rs.getString(7));
            E.setEducation(rs.getString(8));
            E.setStreet(rs.getString(9));
            E.setCity(rs.getString(10));
            E.setState(rs.getString(11));
            E.setPostal(rs.getString(12));
            E.setCategory(rs.getString(13));
            E.setSkill(rs.getString(14));
            E.setGender(rs.getString(15));
            Elist.add(E);
            E=null;
        }
        if(f==1)
            return Elist;
        else
        {
            Elist=null;
            return Elist;
        }
    }
    
    //THIS IS TO CHECK EXISTING USER.
    public boolean isValid(String Email) throws Exception
    {
        Connection con=Mycon.getConnection();
        String sql="select * from Employee where Email_id=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
           return true;
        
        return false;   
    }   
    //THIS IS TO change PASSWORD.
     public boolean changePass(String Mob, String newPass)throws Exception
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=con.prepareStatement("update employee set password=? where Mobile=?");
        ps.setString(1,newPass);
        ps.setString(2,"+91-"+Mob);
        
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;          
    }
    
     //THIS IS TO change PASSWORD.
     public boolean ForgotPass(String Email, String newPass)throws Exception
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=con.prepareStatement("update employee set password=? where Email_id=?");
        ps.setString(1,newPass);
         ps.setString(2,Email);
        
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;          
    }
    
    //searching the user by EMAIL
    
    public boolean searchEmail(String Email)throws Exception
    {
        Connection con=Mycon.getConnection();
        String sql="select Email_id from Employee where Email_id=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return true;//The User Exists 
        
        sql="select Email_id from Donor where Email_id=?;";
        ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        rs=ps.executeQuery();
        if(rs.next())
            return true;//The User Exists 
        
        return false;        //The user Doesnot Exists
    }
    //Search Temporary table for data.
    public boolean alreadySent(String Email)throws Exception
    {
        Connection con=Mycon.getConnection();
        String sql="select * from verifyuser where Email=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return true;
        return false;
    }
    
    //Search Temporary table for data.
    public boolean ForgotSent(String Email)throws Exception
    {
        Connection con=Mycon.getConnection();
        String sql="select Email from forgotpass where Email=?;";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return true;
        return false;
    }

    //Get the First name of the Employee.
    
    public static String firstName(String Email)throws Exception
    {
        PreparedStatement ps=null;
        Connection con=Mycon.getConnection();
        String sql="select First_Name from employee where email_id=?";
        ps=con.prepareStatement(sql);
        
        ps.setString(1, Email);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return rs.getString("First_Name");
        return "";
        
    }
  
    
    
}
