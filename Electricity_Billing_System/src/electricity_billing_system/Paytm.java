
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Paytm extends JFrame implements ActionListener{
    String metar;
    JButton back;
    Paytm(String metar){
        this.metar=metar;
        JEditorPane ep = new JEditorPane();
        ep.setEditable(false);
        
        try{
            ep.setPage("https://paytm.com/online-payments");
        }catch(Exception e){
            ep.setContentType("text/html");
            ep.setText("<html>Could not load</html>");
        }
        
        JScrollPane pane = new JScrollPane(ep);
        add(pane);
        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
        
        back = new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        ep.add(back);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(true);
        new Pay_bill(metar);
    }
    public static void main(String[] args){
        new Paytm("");
    }
}
