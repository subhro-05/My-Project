
package electricity_billing_system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Update_info extends JFrame implements ActionListener{
    JTextField txtaddress,txtcity,txtstate,txtemail,txtphone;
    JButton update,cancel;
    String metar;
    JLabel name;
    Update_info(String metar){
        this.metar=metar;
        setBounds(400,200,1050,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(200,0,500,40);
        heading.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(heading);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(30,70,100,20);
        add(lblname);
        
        name = new JLabel("");
        name.setBounds(230,70,200,20);
        add(name);
        
        JLabel lblmetarno = new JLabel("Metar No :");
        lblmetarno.setBounds(30,110,100,20);
        add(lblmetarno);
        
        JLabel metarno = new JLabel("");
        metarno.setBounds(230,110,100,20);
        add(metarno);
        
        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(30,150,100,20);
        add(lbladdress);
        
        txtaddress = new JTextField();
        txtaddress.setBounds(230,150,200,20);
        add(txtaddress);
        
        JLabel lblcity = new JLabel("City :");
        lblcity.setBounds(30,190,100,20);
        add(lblcity);
        
        txtcity = new JTextField("");
        txtcity.setBounds(230,190,200,20);
        add(txtcity);
        
        JLabel lblstate = new JLabel("State :");
        lblstate.setBounds(30,230,100,20);
        add(lblstate);
        
        txtstate = new JTextField("");
        txtstate.setBounds(230,230,200,20);
        add(txtstate);
        
        JLabel lblemail = new JLabel("Email :");
        lblemail.setBounds(30,270,100,20);
        add(lblemail);
        
        txtemail = new JTextField("");
        txtemail.setBounds(230,270,200,20);
        add(txtemail);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(30,310,100,20);
        add(lblphone);
        
        txtphone = new JTextField("");
        txtphone.setBounds(230,310,200,20);
        add(txtphone);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customar where metar_no = '"+metar+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                txtaddress.setText(rs.getString("address"));
                txtcity.setText(rs.getString("city"));
                txtstate.setText(rs.getString("state"));
                txtemail.setText(rs.getString("email"));
                txtphone.setText(rs.getString("phone"));
                metarno.setText(rs.getString("metar_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        update= new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70,360,100,25);
        update.addActionListener(this);
        add(update);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(280,360,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(550,50,400,300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== update){
            String address = txtaddress.getText();
            String city = txtcity.getText();
            String state = txtstate.getText();
            String email = txtemail.getText();
            String phone = txtphone.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customar set address = '"+address+"', city = '"+city+"', state = '"+state+"', email = '"+email+"', phone = '"+phone+"'where metar_no = '"+metar+"'");
                
                JOptionPane.showMessageDialog(null, "User information updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Update_info("");
    }
}
