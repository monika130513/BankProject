/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import java.sql.*;
/**
 *
 * @author MY PC
 */
public class Conn {
    Connection c;
    Statement s;
    public Conn () {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","monika@123456");
            s = c.createStatement();
        }
        catch (Exception e) {
           System.out.println(e);
        }
    
}
    
}
