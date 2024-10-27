/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQLConnection;
import java.sql.*;

/**
 *
 * @author pinmonyvichea
 */
public class ConnectionProvider {
    public static Connection getCon()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management_system","root","VicheaSQL@010");
            return con;
        }
            catch(Exception e)
            {
            System.out.println(e);
            return null;
            }
    }
    
}
