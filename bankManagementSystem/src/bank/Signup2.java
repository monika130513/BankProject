/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.EventQueue;
import javax.swing.JTextField;

/**
 *
 * @author MY PC
 */
public class Signup2 extends JFrame implements ActionListener{
    JTextField qlf, aadhar, pan_no;
    JComboBox relegionBox, occBox, incomeBox, eduBox, catBox;
    JButton next;
    String formno;
    
    JRadioButton scYes, scNo, a_yes, a_no;
     public Signup2(String formno){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
        this.formno = formno;
        setTitle("New Account Application form - 2");
        JLabel additionalDetails = new JLabel("Page 2 : Addtional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        additionalDetails.setBounds(290, 80, 300,50);
        add(additionalDetails);
        
        JLabel relegion =  new JLabel("Relegion");
        relegion.setFont(new Font("Raleway", Font.BOLD, 18));
        relegion.setBounds(140, 140, 200, 20);
        add(relegion);
        
        String valRelegion[] = {"Hindu", "Sikh", "Muslim","Chirsten", "Other"};
        relegionBox = new JComboBox(valRelegion);
        relegionBox.setBounds(340,140,300,22);
        relegionBox.setBackground(Color.WHITE);
        add(relegionBox);
        
        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(140, 180, 200, 22);
        add(category);       
        
        String[] valCat = {"Gen", "OBC", "SC","ST"};
        catBox = new JComboBox(valCat);
        catBox.setBounds(340, 180, 300, 22);
        catBox.setBackground(Color.WHITE);
        add(catBox);
     
        JLabel income = new JLabel("Income");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(140, 220, 200, 22);
        add(income);
        
        String valIncome[] = {"null", " <1,50,000", " <2,50,0000 ","5,00,000","10,00,00"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(340, 220, 300, 22);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        
        JLabel edct = new JLabel("Educational");
        edct.setFont(new Font("Raleway", Font.BOLD, 18));
        edct.setBounds(140,260, 200, 20);
        edct.setBackground(Color.WHITE);
        add(edct);
        
        String valedu[] = {"non-graduates", "Graduate", "Post Graduate", "Doctrate"};
        eduBox = new JComboBox(valedu);
        eduBox.setBounds(340,260, 300, 22);
        eduBox.setBackground(Color.WHITE);
        add(eduBox);
                
        JLabel qlfL = new JLabel("Qualification");
        qlfL.setFont(new Font("Raleway", Font.BOLD, 18));
        qlfL.setBounds(140,300, 200,20);
        add(qlfL);
        
        qlf = new JTextField();
        qlf.setBounds(340, 300, 300, 22);
        qlf.setBackground(Color.WHITE);
        add(qlf);
        
        JLabel occptn = new JLabel("Occupation");
        occptn.setFont(new Font("Raleway", Font.BOLD, 18));
        occptn.setBounds(140,340,200,20);
        add(occptn);
         
        String valocc[] = {"Salaried", "Self-Employed", "Business", "Student","Retired"};
        occBox = new JComboBox(valocc);
        occBox.setBounds(340,340,300,22);
        occBox.setBackground(Color.WHITE);
        add(occBox);

        JLabel pan = new JLabel("Pan Number");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(140, 380, 200, 20); 
        add(pan); 
        pan_no = new JTextField();
        pan_no.setBounds(340, 380, 300, 22);
        pan_no.setBackground(Color.WHITE);
        add(pan_no);
        
        JLabel aadharno = new JLabel("Aadhar no.");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharno.setBounds(140, 420, 200, 20);
        add(aadharno); 
        
        aadhar = new JTextField();
        aadhar.setBounds(340, 420, 270, 22);
        aadhar.setBackground(Color.WHITE);
        add(aadhar);
        
        JLabel sc = new JLabel("Senior citizen");
        sc.setFont(new Font("Raleway", Font.BOLD, 18));
        sc.setBounds(140, 460, 200, 20);
        add(sc);
        
        scYes  = new JRadioButton("Yes");
        scYes.setBounds(340, 460, 60, 30);
        scYes.setBackground(Color.WHITE);
        add(scYes);
        
        scNo = new JRadioButton("No");
        scNo.setBounds(400, 460, 60 , 30);
        scNo.setBackground(Color.WHITE);
        add(scNo);
        ButtonGroup scGrp = new  ButtonGroup();
        scGrp.add(scYes);
        scGrp.add(scNo);
        
        JLabel accEx = new JLabel("Account Existing");
        accEx.setFont(new Font("Raleway", Font.BOLD, 18));
        accEx.setBounds(140, 500, 200, 20);
        add(accEx);
        a_yes = new JRadioButton("Yes");
        a_yes.setBounds(340, 500, 60, 30);
        a_yes.setBackground(Color.WHITE);
        add(a_yes);
        a_no = new JRadioButton("No");
        a_no.setBounds(400, 500, 60, 30);
        a_no.setBackground(Color.WHITE);
        add(a_no);
        
        
        ButtonGroup accGrp = new ButtonGroup();
        accGrp.add(a_yes);
        accGrp.add(a_no);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(540, 540, 70, 30);
        next.addActionListener(this);
        add(next);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String s_relegion = (String)relegionBox.getSelectedItem();
        String s_category = (String)catBox.getSelectedItem();
        String s_edu = (String)eduBox.getSelectedItem();
        String s_income = (String)incomeBox.getSelectedItem();
        String s_occupation = (String)occBox.getSelectedItem();
        String s_citizen = null;
        if(scYes.isSelected()) {
            s_citizen = "Yes";
        }
        else if(scNo.isSelected()) {
            s_citizen = "No";
        }
        String acc_ex = null;
        if(a_yes.isSelected()) {
            acc_ex = "Yes";
        }
        else if(a_no.isSelected()){
            acc_ex = "No";
        }
        String s_aadhar = aadhar.getText();
        String s_pan = pan_no.getText();
        //String s_qlf = qlf.getText();
        try {
            Conn c = new Conn();
        String query = "insert into signupTwo values('"+formno+"', '"+s_relegion+"',"
                + "'"+s_category+"','"+s_edu+"', '"+s_income+"', '"+s_occupation+"', '"+s_pan+"',"
                + "'"+s_aadhar+"','"+s_citizen+"','"+acc_ex+"')";
        c.s.executeUpdate(query);
        setVisible(false);
        new SignUpThree(formno).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Signup2("");
        
    }
    
}
