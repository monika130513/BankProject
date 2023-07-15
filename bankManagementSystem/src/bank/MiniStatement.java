/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author MY PC
 */
public class MiniStatement extends JFrame {
    String pin;
    public MiniStatement(String pin){
        this.pin = pin;
        setTitle("Mini Statement");
        setVisible(true);
        setLayout(null);
        setLocation(300, 0);
        getContentPane().setBackground(Color.WHITE);

        JLabel bank_name = new JLabel("Indian bank");
        bank_name.setBounds(150, 20 ,100, 20);
        JLabel mini = new JLabel();
        mini.setBounds(20, 100, 300, 20);
        add(mini);
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 30);
        add(card);
        setSize(400, 600);
        JLabel balance = new JLabel();
        balance.setBounds(40, 350, 400, 400 );
        add(balance);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from login where pinNumber = '"+pin+"'");
           while(rs.next()) {
            card.setText("Card number : "+rs.getString("cardNumber").substring(0,4)+"xxxxxxxx"+rs.getString("cardNumber"));    
            
            }
        }
        catch(Exception e){
            System.out.println(e);
            
        }
        try {
            int bal = 0;
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()) {
                mini.setText("<html>"+rs.getString("Date") +"     "
                        +rs.getString("type")+"      "
                        +rs.getString("amount")+"<br></br></html>");
                if(rs.getString("type").equals("deposite")) {
                        bal += Integer.parseInt(rs.getString("amount"));
                 }
                 else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                 }
                
            }
            balance.setText(" Balance is "+bal);
        }
        catch(Exception e) {
            
        } 
       mini.setBounds(40, 100, 300, 20);
    }
    public static void main(String[] args) {
        new MiniStatement("3704");
                
    }
    
}
