/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author MY PC
 */
public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signUp;
    JTextField cardTextField, pinTextField;
    Login() {
        
        setLayout(null);
        setTitle("AUTOMATIC TELLER MACHINE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100,100);
        add(label);
        // page title
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card no.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 400, 30);
        add(cardno);
        
        JLabel pinNo = new JLabel("Pin no.");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 28));
        pinNo.setBounds(120, 220, 400, 30);
        add(pinNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,155, 230, 30);
        add(cardTextField);
        
        pinTextField = new JTextField();
        pinTextField.setBounds(300, 225, 230, 30);
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300, 340, 230, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);       
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource() == login) {
            Conn c =new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"
                    +pinNumber+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else { 
                    JOptionPane.showMessageDialog(null, "Incorrect card or pin number");
                }
            }
            catch(Exception e){
                System.out.println();
            } 
        }
        else if(ae.getSource() == signUp){
            setVisible(false);
            new SignUp().setVisible(true);
        }
    }
        
    public static void main(String[] args) {
        new Login();
        
    }
    
}
