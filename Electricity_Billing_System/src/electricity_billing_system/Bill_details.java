
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Bill_details extends JFrame{
    String metar;
    JTable table;
    Bill_details(String metar){
        this.metar = metar;
        setSize(700,650);
        setLocation(600,150);
        getContentPane().setBackground(Color.WHITE);
        table = new JTable();
        
        try{
            Conn c = new Conn();
            String query = "select * from bill where metar_no = '"+metar+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);
        
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        new Bill_details("");
    }
}
