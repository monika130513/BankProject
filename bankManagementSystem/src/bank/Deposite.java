/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author MY PC
 */
public class Deposite extends JFrame implements ActionListener {
    String pinNumber;
    JTextField amount;
    JButton deposite, back;
    public Deposite(String pinNumber) {
        this.pinNumber = pinNumber;
        setVisible(true);
        setLocation(300, 0);
        setSize(900, 800);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel bground = new JLabel(i1);
        bground.setBounds(0, 0, 900, 800);
        add(bground);
        JLabel  text = new JLabel("Enter the amount you want to deposite");
        text.setForeground(Color.WHITE);
        text.setBounds(170,250, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        bground.add(text);
        amount= new JTextField();
        amount.setBounds(170, 300, 300, 30);
        bground.add(amount);
        
        deposite = new JButton("deposite");
        deposite.setBounds(170, 370, 150, 30);
        deposite.setForeground(Color.BLACK);
        deposite.addActionListener(this);
        bground.add(deposite);
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(350, 370, 150, 30);
        bground.add(back);
        back.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String number = "";
        if(ae.getSource() == deposite){
            number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the amount");
            }
            else {
                try{
                    Conn con = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', "
                            + "'"+date+"','deposite', '"+number+"')";
                    con.s.executeUpdate(query);
                     setVisible(false);
                    //JOptionPane.showMessageDialog(null, " rs "+amount+ "Deposited successfully");
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
        new Deposite("");
    }
    
}
