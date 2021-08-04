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
import java.sql.SQLException;

/**
 *
 * @author Mradul
 */
public class LoginDAO 
{
    public boolean checkEmployeeLogin(String Email,String Pass)throws Exception
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=null;
        String sql="select * from Employee where Email_id=? and password=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, Email);
        ps.setString(2, Pass);
        ResultSet rs=ps.executeQuery();
        
        if(rs.next())
            return true;
        else
            return false;
    }
    
    public boolean checkDonorLogin(String Email) throws SQLException
    {
        Connection con=Mycon.getConnection();
        PreparedStatement ps=null;
        
        String sql="select * from Donor where Email_id=?";        
        ps=con.prepareStatement(sql);
        ps.setString(1,Email);
        
        ResultSet rs=ps.executeQuery();
        
        if(rs.next())
            return true;
        else
            return false;
    }
}
