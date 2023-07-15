/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox j1, j2, j3, j4, j5, j6, j7;
    JButton submit, cancel;
    String formno;
    SignUpThree(String formno){
        this.formno = formno;
        setVisible(true);
        setLayout(null);
        setSize(850,820);
        getContentPane().setBackground(Color.WHITE);
        
        setLocation(350, 0);
        JLabel l1 = new JLabel("Page 3 : Account Deatails");
        l1.setFont(new Font("Raleway" , Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Raleway", Font.BOLD,22));
        accType.setBounds(100, 100, 200, 30);
        add(accType);
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100, 150, 150, 16);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit");
        r2.setBounds(300, 150, 150, 16);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100, 180, 150, 16);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Amount");
        r4.setBounds(300, 180, 250, 16);
        r4.setBackground(Color.WHITE);
        add(r4);
        ButtonGroup  accBtnGrp = new ButtonGroup();
        accBtnGrp.add(r1);
        accBtnGrp.add(r2);
        accBtnGrp.add(r3);
        accBtnGrp.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD, 20));
        card.setBounds(100, 220, 200, 30);
        add(card);
        JLabel number = new JLabel("xxxx-xxxx-xxxx-4138");
        number.setFont(new Font("Raleway",Font.BOLD, 16));
        number.setBounds(330, 220, 300, 30);
        add(number);
        
        JLabel cardDetails = new JLabel("Your 16 digit card number");
        cardDetails.setBounds(100, 240, 200, 30);
        add(cardDetails);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,290, 200, 30);
        add(pin);
        
        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        pnumber.setBounds(330,290,300, 30);
        add(pnumber);
        
        JLabel pinDetails = new JLabel("Pin details");
        pinDetails.setBounds(100, 320, 200, 30);
        add(pinDetails);
        
        JLabel srvcRequired = new JLabel("Service Required");
        srvcRequired.setBounds(100, 360, 300, 30);
        srvcRequired.setFont(new Font("Raleway", Font.BOLD, 20));
        add(srvcRequired);
        j1 = new JCheckBox("ATM Card");
        j1.setBounds(100, 400, 200, 30);
        j1.setBackground(Color.WHITE);
        //j1.setFont(new Font("Raleway", Font.BOLD, 10));
        add(j1);
        
        j2 = new JCheckBox("Internet Banking");
        j2.setBounds(350, 400, 200, 30);
        j2.setBackground(Color.WHITE);
        add(j2);
        j3 = new JCheckBox("Mobile Banking");
        j3.setBounds(100, 450, 200, 30);
        j3.setBackground(Color.WHITE);
        add(j3);
        j4 = new JCheckBox("Sms and Email Alert");
        j4.setBounds(350, 450, 200, 30);
        j4.setBackground(Color.WHITE);
        add(j4);
        j5 = new JCheckBox("Cheque Book");
        j5.setBounds(100, 500, 200, 30);
        j5.setBackground(Color.WHITE);
        add(j5);
        j6 = new JCheckBox("E-statement");
        j6.setBounds(350, 500, 200, 30);
        j6.setBackground(Color.WHITE);
        add(j6); 
        j7 = new JCheckBox("I here by declare that the entered details are correct to the best of knowledge.");
        j7.setBounds(100, 550, 600, 30);
        j7.setBackground(Color.WHITE);
        add(j7);
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 18));
        submit.setBounds(350, 600, 150, 30);
        add(submit);
        submit.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(550, 600, 150, 30);
        add(cancel);
        cancel.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = "";
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposite";
            }
            else if(r3.isSelected()){
                accountType = "Current Account";
            }
            else if(r4.isSelected()){
                accountType = "Recurring Depostite Account";
            }
            Random rand = new Random();
            String cardNumber = ""+ Math.abs(rand.nextLong() % 90000000L) + 504093600000000L;
            String pinNumber = (Math.abs(rand.nextLong() % 9000L) + 1000L)+"";
            String facility ="";
            if(j1.isSelected()){
                facility = facility + "ATM CARd";
            }
            if(j2.isSelected()){
                facility += " Internet Banking";
            }
            if( j3.isSelected()){
                facility += " Mobile Banking";
            }
            if(j4.isSelected()){
                facility += " Sms and Email Alert";
            }
            if(j5.isSelected()) {
                facility += " Cheque Book";
                
            }
            if(j6.isSelected()){
                facility += " E-statement";
            }
            try{
                if(accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Account is required");
                }
                else {
                    Conn c = new Conn();
                    String query = "insert into signupThree values('"+formno+"', '"+accountType+"',"
                + "'"+cardNumber+"','"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"card Number : " +cardNumber+"\n Pin : "+pinNumber);
                    setVisible(false);
                    new Deposite(pinNumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }        
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
