/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author MY PC
 */
public class FastCash extends JFrame implements ActionListener{
    JButton op1, op2, op3, op4, op5, op6, back;
    String pinNumber;
    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setVisible(true);
        setTitle("Fast Cash");
        setLocation(300,0 );
        setSize(900, 800);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900, 800);
        add(image);
        JLabel text = new JLabel("Select Withdrowl amount");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("raleway",Font.BOLD, 22));      
        image.add(text);
        
        op1 = new JButton("Rs 100");
        op1.setForeground(Color.BLACK);
        op1.setBounds(170,350,150,30);
        image.add(op1);
        op1.addActionListener(this);
        op2 = new JButton("Rs 500");
        op2.setForeground(Color.BLACK);
        op2.setBounds(335,350,150,30);
        image.add(op2);
        op2.addActionListener(this);
        
        op3 = new JButton("Rs 1000");
        op3.setBounds(170, 375, 150, 30);
        op3.setForeground(Color.BLACK);
        image.add(op3);
        op3.addActionListener(this);
        
        op4 = new JButton("2000");
        op4.setBounds(335, 375, 150, 30);
        op4.setForeground(Color.BLACK);
        image.add(op4);
        op4.addActionListener(this);
         
        op5 = new JButton("5000");
        op5.setBounds(170, 405, 150, 30);
        op5.setForeground(Color.BLACK);
        image.add(op5);
        op5.addActionListener(this);
        
        op6 = new JButton("10000");
        op6.setBounds(335, 405, 150, 30);
        op6.setForeground(Color.BLACK);
        image.add(op6);
        op6.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(335, 435, 150, 30);
        back.setForeground(Color.BLACK);
        image.add(back);
        back.addActionListener(this);
        setUndecorated(true);   
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            new Transactions(pinNumber).setVisible(true);
        }
        else {
            String amt = ((JButton)ae.getSource()).getText().substring(3); //rs 500
            Conn c = new Conn();
            try {
                ResultSet rslt = c.s.executeQuery("select *from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rslt.next()) {
                    if(rslt.getString("type").equals("Deposite")) {
                        balance += Integer.parseInt(rslt.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rslt.getString("amount"));
                    }
                    if(ae.getSource()!= back && balance < Integer.parseInt(amt)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    Date date = new Date();
                    String q = "insert into bank values('"+pinNumber+"','"+date+"', 'Withdraw','"+amt+"')";
                    c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Rs "+amt+ " Debited successfully");
                    setVisible(false);
                    new Transactions(pinNumber);
                }
            }
            catch(Exception e){
                System.out.println("");
            }
            
        }
       
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
