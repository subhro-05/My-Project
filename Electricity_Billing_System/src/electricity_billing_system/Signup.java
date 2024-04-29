
package electricity_billing_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    Choice accounttype;
    JTextField metar,user,name,pass;
    
    Signup(){
        setBounds(600,300,700,400);  // age location tarpor size thake
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel=new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null, new Color(173,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        
        JLabel heading=new JLabel("Creat Account As");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(heading);
        
        accounttype=new Choice();
        accounttype.add("Admin");
        accounttype.add("Customar");
        accounttype.setBounds(260,50,150,20);
        panel.add(accounttype);
        
        // metar Number
        JLabel lblmetar=new JLabel("Metar Number");
        lblmetar.setBounds(100,90,140,20);
        lblmetar.setForeground(Color.GRAY);
        lblmetar.setFont(new Font("Tahoma", Font.BOLD,14));
        lblmetar.setVisible(false);
        panel.add(lblmetar);
        
        metar=new JTextField();
        metar.setBounds(260,90,150,20);
        metar.setVisible(false);
        panel.add(metar);
        
        //username
        JLabel lbluser=new JLabel("Username");
        lbluser.setBounds(100,130,140,20);
        lbluser.setForeground(Color.GRAY);
        lbluser.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(lbluser);
        
        user=new JTextField();
        user.setBounds(260,130,150,20);
        panel.add(user);
        
        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(lblname);
        
        name=new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);
        
        metar.addFocusListener(new FocusListener() {
              @Override
              public void focusGained(FocusEvent fe) {}
              
              @Override
              public void focusLost(FocusEvent fe) {
                  try{
                      Conn c = new Conn();
                      ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+metar.getText()+"'");
                      while(rs.next()){
                          name.setText(rs.getString("name"));
                      }
                  }catch(Exception e){
                      e.printStackTrace();
                  }
              }
        });
        
        //password
        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(100,210,140,20);
        lblpass.setForeground(Color.GRAY);
        lblpass.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(lblpass);
        
        pass=new JTextField();
        pass.setBounds(260,210,150,20);
        panel.add(pass);
        
        accounttype.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                String user = accounttype.getSelectedItem();
                if (user.equals("Customar")){
                    lblmetar.setVisible(true);
                    metar.setVisible(true);
                    name.setEditable(false);
                }else{
                    lblmetar.setVisible(false);
                    metar.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        // create buuton
        create=new JButton("Create");
        create.setBounds(120,260,120,25);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        panel.add(create);
        
        // back button
        back=new JButton("Back");
        back.setBounds(290,260,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==create){
            String atype=accounttype.getSelectedItem();
            String suser=user.getText();
            String sname=name.getText();
            String spass=pass.getText();
            String smetar=metar.getText();
            
            try{
                Conn c= new Conn();
                String query= null;
                if (atype.equals("Admin")){      
                    query="insert into login values('"+smetar+"','"+suser+"','"+sname+"','"+spass+"','"+atype+"')";
                }else{
                    query="update login set username = '"+suser+"', password = '"+spass+"', user = '"+atype+"' where meter_no = '"+smetar+"'"; 
                }
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new Signup();
    }
}
