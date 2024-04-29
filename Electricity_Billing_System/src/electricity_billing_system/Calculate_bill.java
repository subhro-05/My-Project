
package electricity_billing_system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class Calculate_bill extends JFrame implements ActionListener{
    
    JTextField txtname,txtadress,txtstate,txtemail,txtphone,txtunits;
    JButton next, cancel;
    JLabel lblname,lbladdress;
    Choice metarnumber,month;
    Calculate_bill(){
        setSize(700,500);
        setLocation(600,260);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(150,10,300,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblmetarno =new JLabel("Metar No :");
        lblmetarno.setBounds(100,80,100,20);
        p.add(lblmetarno);
        
        metarnumber=new Choice();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customar");
            while(rs.next()){
                metarnumber.add(rs.getString("metar_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        metarnumber.setBounds(250,80,200,20);
        p.add(metarnumber);
        
        
        JLabel lbl_name =new JLabel("Name :");
        lbl_name.setBounds(100,120,100,20);
        p.add(lbl_name);
        
        lblname =new JLabel();
        lblname.setBounds(250,120,200,25);
        p.add(lblname);
        
        JLabel lbl_address =new JLabel("Address :");
        lbl_address.setBounds(100,160,100,20);
        p.add(lbl_address);
        
        lbladdress =new JLabel();
        lbladdress.setBounds(250,160,200,25);
        p.add(lbladdress);
        
        
        
        metarnumber.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select * from customar where metar_no = '"+metarnumber.getSelectedItem()+"'");
                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lbladdress.setText(rs.getString("address"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lbl_unit =new JLabel("Units Consumed :");
        lbl_unit.setBounds(100,200,100,20);
        p.add(lbl_unit);
        
        txtunits=new JTextField();
        txtunits.setBounds(250,200,200,25);
        p.add(txtunits);
        
        JLabel lbl_month =new JLabel("Month :");
        lbl_month.setBounds(100,240,100,20);
        p.add(lbl_month);
        
        month=new Choice();
        month.setBounds(250,240,200,25);
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        p.add(month);
        
        next=new JButton("Submit");
        next.setBounds(120,350,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(300,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p, "Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2= i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image, "West");
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==next){
            String metar=metarnumber.getSelectedItem();
            String units=txtunits.getText();
            String m_month=month.getSelectedItem();
            
            int totalbill = 0;
            int unit_consumed = Integer.parseInt(units);
            
            
            String query = "select *from tax";

            try{
                Conn c=new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    totalbill =totalbill+ unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            String query2 = "insert into bill values('"+metar+"', '"+m_month+"', '"+units+"', '"+totalbill+"','Not Paid')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Cutomar bill updated successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Calculate_bill();
    }
}
