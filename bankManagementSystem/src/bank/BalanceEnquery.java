/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BalanceEnquery extends JFrame implements ActionListener  {
    String pin;
    JButton back;
    BalanceEnquery(String pin){
        this.pin = pin;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(0,0, 900, 800);
        add(image);
        back = new JButton("Back");
        back.setBounds(355, 400, 100 , 25);
        image.add(back);
        back.addActionListener(this);
        Conn c = new Conn();
        JLabel text = new JLabel();
        
        try{
            int balance = 0;
            ResultSet rs = c.s.executeQuery("select *from bank where pin ='"+pin+"'");
            while(rs.next()){
                if(rs.getString("type").equals("deposite")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
            }
            text.setText("Your account current balance is : "+balance);
            text.setFont(new Font("raleway", Font.BOLD, 18));
            text.setBounds(170, 300, 400, 30);
            text.setForeground(Color.WHITE);
            image.add(text);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        setSize(900, 800);
        setVisible(true);
        setLocation(300, 0);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions("pin").setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        new BalanceEnquery("");
    }
}
