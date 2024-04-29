
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class New_customar extends JFrame implements ActionListener{
    
    JTextField txtname,txtadress,txtstate,txtemail,txtphone,txtcity;
    JButton next, cancel;
    JLabel lblmetar;
    New_customar(){
        setSize(700,500);
        setLocation(600,260);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("New Customar");
        heading.setBounds(250,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname =new JLabel("Customar Name :");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        txtname=new JTextField();
        txtname.setBounds(250,80,200,25);
        p.add(txtname);
        
        
        JLabel lblmetarno =new JLabel("Metar No :");
        lblmetarno.setBounds(100,120,100,20);
        p.add(lblmetarno);
        
        lblmetar =new JLabel("");
        lblmetar.setBounds(250,120,200,25);
        p.add(lblmetar);
        
        Random ran=new Random();
        long number = ran.nextLong() % 1000000;
        lblmetar.setText(""+Math.abs(number));
        
        JLabel lbladdress =new JLabel("Address :");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        
        txtadress=new JTextField();
        txtadress.setBounds(250,160,200,25);
        p.add(txtadress);
        
        JLabel lblcity =new JLabel("City :");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);
        
        txtcity=new JTextField();
        txtcity.setBounds(250,200,200,25);
        p.add(txtcity);
        
        JLabel lblstate =new JLabel("State :");
        lblstate.setBounds(100,240,100,20);
        p.add(lblstate);
        
        txtstate=new JTextField();
        txtstate.setBounds(250,240,200,25);
        p.add(txtstate);
        
        JLabel lblemail =new JLabel("Email :");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
        
        txtemail=new JTextField();
        txtemail.setBounds(250,280,200,25);
        p.add(txtemail);
        
        JLabel lblphone =new JLabel("Phone No :");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);
        
        txtphone=new JTextField();
        txtphone.setBounds(250,320,200,25);
        p.add(txtphone);
        
        next=new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(300,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p, "Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2= i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image, "West");
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==next){
            String sname=txtname.getText();
            String smetar=lblmetar.getText();
            String saddress=txtadress.getText();
            String scity=txtcity.getText();
            String sstate=txtstate.getText();
            String semail=txtemail.getText();
            String sphone=txtphone.getText();
            
            String query="insert into customar values('"+sname+"', '"+smetar+"', '"+saddress+"', '"+sstate+"', '"+semail+"', '"+sphone+"','"+scity+"')";
            String query1="insert into login values('"+smetar+"', '', '"+sname+"', '', '')";
//            Conn c=new Conn();
//            c.s.executeUpdate(query);
//            c.s.executeUpdate(query1);
            try{
                Conn c=new Conn();
//                String query="insert into customar values('"+sname+"', '"+smetar+"', '"+saddress+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+sphone+"')";
//                String query1="insert into login values('"+smetar+"', '', "+sname+"', '', '')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null, "Customar Details Added Successfully");
                setVisible(false);
                
                // new Frame
                new Metar_info(smetar);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new New_customar();
    }
}
