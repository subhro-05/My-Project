
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Pay_bill extends JFrame implements ActionListener{
    Choice month;
    String metar;
    JButton pay,back;
    Pay_bill(String metar){
        this.metar=metar;
        setLayout(null);
        setBounds(500,150,900,600);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Bill Payment");
        heading.setFont(new Font("Tahoma", Font.PLAIN,24));
        heading.setBounds(120,5,400,30);
        add(heading);
        
        JLabel lblmetarno = new JLabel("Metar No :");
        lblmetarno.setBounds(35,80,200,20);
        add(lblmetarno);
        
        JLabel metarno = new JLabel("");
        metarno.setBounds(300,80,200,20);
        add(metarno);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(35,140,200,20);
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setBounds(300,140,200,20);
        add(name);
        
        JLabel lblmonth = new JLabel("Month :");
        lblmonth.setBounds(35,200,200,20);
        add(lblmonth);
        
        month= new Choice();
        month.setBounds(300,200,200,20);
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
        add(month);
        
        JLabel lblunit = new JLabel("Units :");
        lblunit.setBounds(35,260,200,20);
        add(lblunit);
        
        JLabel unit = new JLabel("");
        unit.setBounds(300,260,200,20);
        add(unit);
        
        JLabel lbltotalbill = new JLabel("Total Bill :");
        lbltotalbill.setBounds(35,320,200,20);
        add(lbltotalbill);
        
        JLabel total_bill = new JLabel("");
        total_bill.setBounds(300,320,200,20);
        add(total_bill);
        
        JLabel lblstatus = new JLabel("Status :");
        lblstatus.setBounds(35,380,200,20);
        add(lblstatus);
        
        JLabel status = new JLabel("");
        status.setBounds(300,380,200,20);
        status.setForeground(Color.red);
        add(status);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customar where metar_no = '"+metar+"'");
            while(rs.next()){
                metarno.setText(metar);
                name.setText(rs.getString("name"));
            }
            
            rs = c.s.executeQuery("select * from bill where metar_no = '"+metar+"' and month = '"+month.getSelectedItem()+"'");
            while(rs.next()){
                unit.setText(rs.getString("units"));
                total_bill.setText(rs.getString("totalbill"));
                status.setText(rs.getString("status"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        month.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
               try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where metar_no = '"+metar+"' and month = '"+month.getSelectedItem()+"'");
                    while(rs.next()){
                        unit.setText(rs.getString("units"));
                        total_bill.setText(rs.getString("totalbill"));
                        status.setText(rs.getString("status"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                } 
            }
        });
        
        
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,460,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,120,600,300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==pay){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where metar_no = '"+metar+"' and month = '"+month.getSelectedItem()+"'");
            }catch(Exception e){
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(metar);
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Pay_bill("");
    }
}
