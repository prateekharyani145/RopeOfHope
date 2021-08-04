/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.*;

/**
 *
 * @author Mradul
 */
public class Mycon 
{
    static Connection con=null;
    
    public static Connection getConnection()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roh", "root", "root");
            System.out.println("Connection Successful");
        } 
        catch (Exception ex) 
        {
            System.out.println(" Error Occured " + ex.getMessage());
        }
        return con;
    }
}
