
package electricity_billing_system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class Diposit_details extends JFrame implements ActionListener{
    Choice metarnumber,month;
    JTable table;
    JButton search,print;
    Diposit_details(){
        super("Deposit Details");
        setSize(700,700);
        setLocation(600,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblmetarno = new JLabel("Search by Metar No");
        lblmetarno.setBounds(20,20,150,20);
        add(lblmetarno);
        
        metarnumber= new Choice();
        metarnumber.setBounds(180,20,90,20);
        add(metarnumber);
        
        try{
            Conn c =new Conn();
            ResultSet rs =c.s.executeQuery("select * from customar");
            while(rs.next()){
                metarnumber.add(rs.getString("metar_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblmonth = new JLabel("Search by Metar No");
        lblmonth.setBounds(300,20,150,20);
        add(lblmonth);
        
        month= new Choice();
        month.setBounds(450,20,150,20);
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
        
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,700,600);
        add(sp);
        
        search = new JButton("Search");
        search.setBounds(180,70,100,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(390,70,100,20);
        print.addActionListener(this);
        add(print);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== search){
            String query="select * from bill where metar_no = '"+metarnumber.getSelectedItem()+"' and month = '"+month.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new Diposit_details();
    }
}
