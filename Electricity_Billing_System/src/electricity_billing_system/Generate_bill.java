
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Generate_bill extends JFrame implements ActionListener{
    Choice month;
    JTextArea area;
    String metar;
    JButton bill;
    Generate_bill(String metar){
        this.metar=metar;
        setSize(520,1000);
        setLocation(600,10);
        
        
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        
        JLabel heading = new JLabel("Generate Bill");
        
        JLabel metarno = new JLabel(metar);
        
        month = new Choice();
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
        
        
        area = new JTextArea(50,15);
        area.setText("\n\n\t-----------Click on the-----------\n\t Generate bill button to get\n\t the of the selected month.");
        area.setFont((new Font("Senserif", Font.ITALIC,20)));
        
        JScrollPane pane = new JScrollPane(area);
        
        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        
        panel.add(heading);
        panel.add(metarno);
        panel.add(month);
        add(panel,"North");
        add(pane,"Center");
        add(bill,"South");
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            String cmonth = month.getSelectedItem();
            
            area.setText("\tSubhro Power Limited\n ELECTRICITY BILL GENERATE FOR THE MONTH\n\tOF "+cmonth+", 2023");
            ResultSet rs = c.s.executeQuery("select * from customar where metar_no = '"+metar+"'");
            if (rs.next()){
                area.append("\n   Customar Name     : "+ rs.getString("name"));
                area.append("\n   Metar No          : "+ rs.getString("metar_no"));
                area.append("\n   Address           : "+ rs.getString("address"));
                area.append("\n   city              : "+ rs.getString("city"));
                area.append("\n   State             : "+ rs.getString("state"));
                area.append("\n   Email             : "+ rs.getString("email"));
                area.append("\n   Phone             : "+ rs.getString("phone"));
                area.append("\n-----------------------------------------------");
                area.append("\n");
            }
            
            rs = c.s.executeQuery("select * from metar_info where metar_no = '"+metar+"'");
            if (rs.next()){
                area.append("\n   Metar Location    : "+ rs.getString("m_location"));
                area.append("\n   metar Type        : "+ rs.getString("m_type"));
                area.append("\n   Phase Code        : "+ rs.getString("phase_code"));
                area.append("\n   Bill Type         : "+ rs.getString("bill_type"));
                area.append("\n   Days              : "+ rs.getString("days"));
                area.append("\n-----------------------------------------------");
                area.append("\n");
            }
            
//            rs = c.s.executeQuery("select * from metar_info where metar_no = '126836'");
//            if (rs.next()){
//                area.append("\n   Metar Location    : "+ rs.getString("m_location"));
//                area.append("\n   metar Type        : "+ rs.getString("m_type"));
//                area.append("\n   Phase Code        : "+ rs.getString("phase_code"));
//                area.append("\n   Bill Type         : "+ rs.getString("bill_type"));
//                area.append("\n   Days              : "+ rs.getString("days"));
//                area.append("\n-----------------------------------------------");
//                area.append("\n");
//            }
            
            rs = c.s.executeQuery("select * from tax");
            if (rs.next()){
                area.append("\n");
                area.append("\n   Cost Per Unit                : "+ rs.getString("cost_per_unit"));
                area.append("\n   Metar Rent                   : "+ rs.getString("meter_rent"));
                area.append("\n   Service Charge               : "+ rs.getString("service_charge"));
                area.append("\n   Sevice Tax                   : "+ rs.getString("service_tax"));
                area.append("\n   Swacch Bhatar Cess           : "+ rs.getString("swacch_bharat_cess"));
                area.append("\n   Fixed Tax                    : "+ rs.getString("fixed_tax"));
                area.append("\n-----------------------------------------------");
                area.append("\n");
            }
            
            rs = c.s.executeQuery("select * from bill where metar_no = '"+metar+"' and month = '"+cmonth+"'");
            if (rs.next()){
                area.append("\n");
                area.append("\n   Current Month                : "+ rs.getString("month"));
                area.append("\n   Units Consumed                   : "+ rs.getString("units"));
                area.append("\n   Total Charges               : "+ rs.getString("totalbill"));
                area.append("\n----------------------------------------------------");
                area.append("\n   Total Payable                    : "+ rs.getString("totalbill"));
                area.append("\n-----------------------------------------------");
                area.append("\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Generate_bill("");
    } 
}
