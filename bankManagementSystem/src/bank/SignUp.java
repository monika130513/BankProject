/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fatherNameTextField,emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JRadioButton male, female, other, married, unmarried;
    JButton next;
    JDateChooser choosedate;
    public SignUp(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        Random ran = new Random();
        
        random = Math.abs(ran.nextLong()) % 9999;
        JLabel formno = new JLabel("APPLICATION FORM NO "+ random);
        formno.setBounds(140, 20, 600,40);
        formno.setFont(new Font("Raleway", Font.BOLD, 22));
        add(formno);
  
        JLabel personDetails = new JLabel("Page 1 : personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        personDetails.setBounds(290, 80, 400,50);
        add(personDetails);
        
        JLabel name =  new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(140, 140, 200, 20);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(340, 140 , 270, 22);
        add(nameTextField);
        
        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 18));
        fatherName.setBounds(140, 180, 200, 20);
        add(fatherName);
        
        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(340, 180, 270, 22);
        add(fatherNameTextField);
           
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(140, 220, 200, 20);
        add(dob);
        
        choosedate = new JDateChooser();
        choosedate.setBounds( 340, 220, 270, 22);
        add(choosedate);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(140,260, 200, 20);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(340, 260, 60, 30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400, 260, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        
        ButtonGroup gendarGrp = new  ButtonGroup();
        gendarGrp.add(male);
        gendarGrp.add(female);
  
        JLabel email = new JLabel("email Address");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(140,300, 200,20);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(340, 300, 270, 22);
        add(emailTextField);
        
        JLabel maritalStaus = new JLabel("Marital Status");
        maritalStaus.setFont(new Font("Raleway", Font.BOLD, 18));
        maritalStaus.setBounds(140,340,200,20);
        add(maritalStaus);
        
        married = new JRadioButton("Married");
        married.setBounds(340, 340, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420 , 340, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(520, 340, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup marriedStatusGrp = new  ButtonGroup();
        marriedStatusGrp.add(married);
        marriedStatusGrp.add(unmarried);
        marriedStatusGrp.add(other);
       
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(140, 380, 200, 20);
        add(address); 
        
        addressTextField = new JTextField();
        addressTextField.setBounds(340, 380, 270, 22);
        add(addressTextField);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(140, 420, 200, 20);
        add(city); 
        
        cityTextField = new JTextField();
        cityTextField.setBounds(340, 420, 270, 22);
        add(cityTextField);
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(140, 460, 200, 20);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setBounds(340, 460, 270, 22);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(140, 500, 200, 20);
        add(pincode);
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(340, 500, 270, 22);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(540, 540, 70, 30);
        next.addActionListener(this);
        add(next);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next) {
            String form = ""+random;
            String name = nameTextField.getText();
            String fathername = fatherNameTextField.getText();
            String email = emailTextField.getText();
            String dob = ((JTextField)choosedate.getDateEditor().getUiComponent()).getText();
            String gendar = null;
            if(male.isSelected()) {
                gendar = "male";
            }
            else if(female.isSelected()) {
                gendar = "female";
            }
            else if(other.isSelected()) {
                gendar = "other";
            }
            String maritalStatus = null;
            if(married.isSelected()) {
                maritalStatus = "married";
            }
            else if(unmarried.isSelected()) {
                maritalStatus = "unmarried";
            }
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String pin = pincodeTextField.getText();
            try {
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name is required");
                }
                else {
                    Conn c = new Conn();
                    String query = "insert into signup values('"+form+"', '"+name+"', '"+fathername+"',"
                         + "'"+dob+"','"+gendar+"','"+email+"','"+maritalStatus+"','"+address+"', '"+city+"','"+pin+"', '"+state+"')"; 
                        c.s.executeUpdate(query);
                        setVisible(false);
                        new Signup2(form).setVisible(true);
                }
            }
            catch(Exception e) {
            System.out.println("e");
            }   
        } 
    }
    public static void main(String[] args) {
        new SignUp();
        
    }
    
}
