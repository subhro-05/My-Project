
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton btnlogin,btncancel,btnsignup;
    JTextField txtuser,txtpass;
    Choice logininas;
    Login(){
        
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // username
        JLabel lbluser=new JLabel("Username :");
        lbluser.setBounds(300,20,100,30);
        add(lbluser);
        
        txtuser=new JTextField();
        txtuser.setBounds(400,20,150,30);
        add(txtuser);
        
        //password
        JLabel lblpass=new JLabel("Password :");
        lblpass.setBounds(300,60,100,30);
        add(lblpass);
        
        txtpass=new JTextField();
        txtpass.setBounds(400,60,150,30);
        add(txtpass);
        
        //login in as
        JLabel loginas=new JLabel("Login In As :");
        loginas.setBounds(300,100,100,30);
        add(loginas);
        
        logininas=new Choice();
        logininas.add("Admin");
        logininas.add("Customar");
        logininas.setBounds(400,105,150,30);
        add(logininas);
        
        // login button
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        btnlogin=new JButton("Login", new ImageIcon(i2));
        btnlogin.setBounds(300,160,100,30);
        btnlogin.addActionListener(this);
        add(btnlogin);
        
        // cencel button
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        btncancel=new JButton("Cencel",new ImageIcon(i4));
        btncancel.setBounds(450,160,100,30);
        btncancel.addActionListener(this);
        add(btncancel);
        
        // Signup button
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        btnsignup=new JButton("Sign up", new ImageIcon(i6));
        btnsignup.setBounds(375,200,100,30);
        btnsignup.addActionListener(this);
        add(btnsignup);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image=new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);
        
        setSize(640,300);
        setLocation(600,350);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==btnlogin){
            String susername=txtuser.getText();
            String spassword=txtpass.getText();
            String slogininas=logininas.getSelectedItem();
            try{
                Conn c=new Conn();
                String sql="select * from login where username ='"+susername+"' and password ='"+spassword+"' and user ='"+slogininas+"'";
                ResultSet rs = c.s.executeQuery(sql);
                
                if (rs.next()){
                    String metar=rs.getString("meter_no");
                    setVisible(false);
                    new Project(slogininas, metar);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==btncancel){
            setVisible(false);
        }else if(ae.getSource()==btnsignup){
            setVisible(false);
            new Signup();
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
