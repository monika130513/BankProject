/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Withdraw extends JFrame implements ActionListener {
    String pinNumber;
    JTextField amount;
    JButton withdraw, back;
    public Withdraw(String pinNumber) {
        this.pinNumber = pinNumber;
        setVisible(true);
        setLocation(300, 0);
        setLayout(null);
        setSize(900, 800);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel bground = new JLabel(i1);
        bground.setBounds(0, 0, 900, 800);
        add(bground);
        JLabel  text = new JLabel("Enter the amount you want withdraw");
        text.setForeground(Color.WHITE);
        text.setBounds(170,250, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        bground.add(text);
        amount= new JTextField();
        amount.setBounds(170, 300, 300, 30);
        bground.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(170, 370, 150, 30);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        bground.add(withdraw);
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(350, 370, 150, 30);
        bground.add(back);
        back.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String number = "";
        if(ae.getSource() == withdraw){
            number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the amount");
            }
            else {
                try{
                    Conn con = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"','Withdrawl', '"+number+"')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, " rs "+amount+ "Withdrawl successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.print(e);
                }
            }
        }
        else if(ae.getSource() == back ){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
}
