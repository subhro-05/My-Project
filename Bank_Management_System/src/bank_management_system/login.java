
package bank_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardtxtfield;
    JPasswordField pintxtfield;
    login(){
        setTitle("Online Banking System");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text=new JLabel("Welcome To SS Bank");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(200,40,600,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(100,120,350,40);
        add(cardno);
        
        cardtxtfield=new JTextField();
        cardtxtfield.setBounds(300,130,250,30);
        cardtxtfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtxtfield);
        
        JLabel pin=new JLabel("Pin: ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(100,180,600,30);
        add(pin);
        
        pintxtfield=new JPasswordField();
        pintxtfield.setBounds(300,180,250,30);
        pintxtfield.setFont(new Font("Arial",Font.BOLD,14));
        add(pintxtfield);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,250,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("Clear");
        clear.setBounds(450,250,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("Register Now");
        signup.setBounds(300,300,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ac){
        if (ac.getSource() == clear){
            cardtxtfield.setText("");
            pintxtfield.setText("");
        }else if (ac.getSource()==login){
            
        }else if(ac.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args){
        new login();
    }
}
