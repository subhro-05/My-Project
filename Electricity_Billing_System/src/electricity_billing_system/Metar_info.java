
package electricity_billing_system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Metar_info extends JFrame implements ActionListener{
    
    JTextField txtname,txtadress,txtstate,txtemail,txtphone,txtcity;
    JButton Submit, next;
    JLabel lblmetar;
    Choice metarlocation,metartype,phasecode,billtype;
    String metarnumber;
    Metar_info(String metarno){
        this.metarnumber=metarno;
        setSize(700,500);
        setLocation(600,260);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("Metar Information");
        heading.setBounds(250,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblmetarNumber =new JLabel("Metar No :");
        lblmetarNumber.setBounds(100,80,100,20);
        p.add(lblmetarNumber);
        
        JLabel lblmetarno =new JLabel(metarno);
        lblmetarno.setBounds(250,80,100,20);
        p.add(lblmetarno);
        
        
        JLabel lblmetarlocation =new JLabel("Metar Location :");
        lblmetarlocation.setBounds(100,120,100,20);
        p.add(lblmetarlocation);
        
        metarlocation=new Choice();
        metarlocation.add("Outside");
        metarlocation.add("Inside");
        metarlocation.setBounds(250,120,200,25);
        p.add(metarlocation);
        
        JLabel lblmetartype =new JLabel("Mertar Type :");
        lblmetartype.setBounds(100,160,100,20);
        p.add(lblmetartype);
        
        metartype=new Choice();
        metartype.add("Electric Metar ");
        metartype.add("Solar Metar");
        metartype.add("Smart Metar");
        metartype.setBounds(250,160,200,25);
        p.add(metartype);
        
        JLabel lblphasecode =new JLabel("Phase Code :");
        lblphasecode.setBounds(100,200,100,20);
        p.add(lblphasecode);
        
        phasecode=new Choice();
        phasecode.add("011");
        phasecode.add("o22");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");        
        phasecode.setBounds(250,200,200,25);
        p.add(phasecode);
        
        JLabel lblbilltype =new JLabel("Bill Type :");
        lblbilltype.setBounds(100,240,100,20);
        p.add(lblbilltype);
        
        billtype=new Choice();
        billtype.add("Normal");
        billtype.add("Industial");
        billtype.setBounds(250,240,200,25);
        p.add(billtype);
        
        JLabel lbldays =new JLabel("Days :");
        lbldays.setBounds(100,280,100,20);
        p.add(lbldays);
        
        JLabel days =new JLabel("30 Days :");
        days.setBounds(250,280,100,20);
        p.add(days);;
        
        JLabel lblnote =new JLabel("Note :");
        lblnote.setBounds(100,320,100,20);
        p.add(lblnote);
        
        JLabel note =new JLabel("By default bill is calculated for 30 days only");
        note.setBounds(250,320,500,20);
        p.add(note);
        
        next=new JButton("Submit");
        next.setBounds(220,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
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
            String metar=metarnumber;
            String mlocation=metarlocation.getSelectedItem();
            String mtype=metartype.getSelectedItem();
            String code=phasecode.getSelectedItem();
            String btype=billtype.getSelectedItem();
            String days="30";
            
            String query="insert into metar_info values('"+metar+"', '"+mlocation+"', '"+mtype+"', '"+code+"', '"+btype+"', '"+days+"')";

            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Metar Information Added Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Metar_info("");
    }
}
