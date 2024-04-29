
package electricity_billing_system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Customar_details extends JFrame implements ActionListener{
    Choice metarnumber,month;
    JTable table;
    JButton search,print;
    Customar_details(){
        super("Customar Details");
        setSize(1200,650);
        setLocation(200,150);
        
        //Adding data from the ebs database to this table
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from customar");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        print = new JButton("Print");
        print.addActionListener(this);
        add(print,"South");
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        // Now all details print
        try{
            table.print();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Customar_details();
    }
}
