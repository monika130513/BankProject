/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author MY PC
 */
public class Transactions extends JFrame implements ActionListener{
    JButton deposite, withdrawl, fastcash, ministatement, pinChange, balanceEnqry,exit;
    String pinNumber;
    public Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        setVisible(true);
        setTitle("ATM Machine");
        setLocation(300,0 );
        setSize(900, 800);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900, 800);
        add(image);
        JLabel text = new JLabel("Please Select your transction");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("raleway",Font.BOLD, 22));      
        image.add(text);
        
        deposite = new JButton("Deposite");
        deposite.setForeground(Color.BLACK);
        deposite.setBounds(170,350,150,30);
        image.add(deposite);
        deposite.addActionListener(this);
        withdrawl = new JButton("Money Withdrawl");
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setBounds(335,350,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 375, 150, 30);
        fastcash.setForeground(Color.BLACK);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        ministatement = new JButton("Mini statement");
        ministatement.setBounds(335, 375, 150, 30);
        ministatement.setForeground(Color.BLACK);
        image.add(ministatement);
        ministatement.addActionListener(this);
         
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 405, 150, 30);
        pinChange.setForeground(Color.BLACK);
        image.add(pinChange);
        pinChange.addActionListener(this);
        
        balanceEnqry = new JButton("Balance Enquery");
        balanceEnqry.setBounds(335, 405, 150, 30);
        balanceEnqry.setForeground(Color.BLACK);
        image.add(balanceEnqry);
        balanceEnqry.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.setBounds(335, 435, 150, 30);
        exit.setForeground(Color.BLACK);
        image.add(exit);
        exit.addActionListener(this);
        setUndecorated(true);       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposite){
            setVisible(false);
            new Deposite(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdraw(pinNumber);
        }
        else if(ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balanceEnqry) {
            setVisible(false);
            new BalanceEnquery(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == ministatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
