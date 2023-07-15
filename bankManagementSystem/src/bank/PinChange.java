/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author MY PC
 */
public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinText, repinText;
    JButton change, back;
    String pin;
    PinChange(String pin){
        this.pin = pin;
        setVisible(true);
        setTitle("Change PIn");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 800);
        add(image);
        setLocation(300,0 );
        setSize(900, 800);
        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setBounds(250, 250,150, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(text);
        JLabel newpin = new JLabel( "New pin");
        newpin.setBounds(170, 300, 200, 30);
        newpin.setFont(new Font("Ralway", Font.BOLD, 15));
        newpin.setForeground(Color.WHITE);
        image.add(newpin);
        
        pinText = new JPasswordField();
        pinText.setBounds(300, 300, 150, 25);
        image.add(pinText);
        
        JLabel repin = new JLabel("Re-Enter Pin");
        repin.setBounds(170, 350, 200, 30);
        repin.setFont(new Font("Ralway", Font.BOLD, 15));
        repin.setForeground(Color.WHITE);
        image.add(repin);
        
        repinText = new JPasswordField();
        repinText.setBounds(300, 350, 150, 25);
        image.add(repinText);
        
        change = new JButton("Change");
        change.setBounds(355, 400, 100, 30);
        change.setForeground(Color.BLACK);
        image.add(change);
        change.addActionListener(this);
        back = new JButton("Back");
        back.setBounds(170, 400, 100, 30);
        back.setForeground(Color.BLACK);
        image.add(back);
        back.addActionListener(this);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else if(ae.getSource() == change) {
            String newpin = pinText.getText();
            if(newpin.equals("") || !newpin.equals(repinText.getText())) {
                JOptionPane.showConfirmDialog(null, "Pin is not matched or you did not enter the pin number");
            }
            else {
                Conn c = new Conn();
                try{
                String q1 = "update bank set pin = '"+newpin+"' where pin = '"+pin+"'";
                String q2 = "update login set pinNumber  ='"+newpin+"' where pinNumber ='"+pin+"'";
                String q3 = "update signupThree set pinNumber ='"+newpin+"' where pinNumber = '"+pin+"'";
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "Successfully updated");
                setVisible(false);
                new Transactions(newpin).setVisible(true);
                
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
