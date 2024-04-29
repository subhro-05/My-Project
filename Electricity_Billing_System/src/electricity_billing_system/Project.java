
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
    String atype,metar;
    Project(String atype, String metar){
        this.atype=atype;
        this.metar=metar;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel Image=new JLabel(i3);
        add(Image);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master=new JMenu("Master");
        master.setForeground(Color.blue);
        
        
        JMenuItem newcustomar=new JMenuItem("New Customar");
        newcustomar.setFont(new Font("monospaced", Font.PLAIN, 12));
        newcustomar.setBackground(Color.WHITE);
        newcustomar.addActionListener(this);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        master.add(newcustomar);
        
        JMenuItem custo_details=new JMenuItem("Customar Details");
        custo_details.setFont(new Font("monospaced", Font.PLAIN, 12));
        custo_details.setBackground(Color.WHITE);
        custo_details.addActionListener(this);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        master.add(custo_details);
        
        JMenuItem diposit_details=new JMenuItem("Deposit Details");
        diposit_details.setFont(new Font("monospaced", Font.PLAIN, 12));
        diposit_details.setBackground(Color.WHITE);
        diposit_details.addActionListener(this);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        master.add(diposit_details);
        
        
        JMenuItem calculatebil=new JMenuItem("Calculate Bill");
        calculatebil.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculatebil.setBackground(Color.WHITE);
        calculatebil.addActionListener(this);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        master.add(calculatebil);
        
        
        JMenu info=new JMenu("Information");
        info.setForeground(Color.red);
        
        
        JMenuItem updateinfo=new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateinfo.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        updateinfo.addActionListener(this);
        info.add(updateinfo);
        
        JMenuItem viewinfo=new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewinfo.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        viewinfo.addActionListener(this);
        info.add(viewinfo);
        
        
        JMenu user=new JMenu("User");
        user.setForeground(Color.blue);
        
        
        JMenuItem paybil=new JMenuItem("Pay Bill");
        paybil.setFont(new Font("monospaced", Font.PLAIN, 12));
        paybil.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        paybil.addActionListener(this);
        user.add(paybil);
        
        JMenuItem bil_details=new JMenuItem("Bill Details");
        bil_details.setFont(new Font("monospaced", Font.PLAIN, 12));
        bil_details.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        bil_details.addActionListener(this);
        user.add(bil_details);
        
        JMenu report=new JMenu("Report");
        report.setForeground(Color.red);
        
        
        JMenuItem genaratebil=new JMenuItem("Genarate Bill");
        genaratebil.setFont(new Font("monospaced", Font.PLAIN, 12));
        genaratebil.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        genaratebil.addActionListener(this);
        report.add(genaratebil);
        
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.blue);
        
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculator.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.red);
        
        
        JMenuItem Exit=new JMenuItem("Exit");
        Exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        Exit.setBackground(Color.WHITE);
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
//        Image i5=i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
//        newcustomar.setIcon(new ImageIcon(i5));
//        newcustomar.setMnemonic('D');
//        newcustomar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK);
        Exit.addActionListener(this);
        exit.add(Exit);
        
        setLayout(new FlowLayout());
        
        if (atype.equals("Admin")){
            mb.add(master);
        }else{
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(exit);
 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equals("New Customar")){
            new New_customar();
        }else if (msg.equals("Customar Details")){
            new Customar_details();
        }else if (msg.equals("Deposit Details")){
            new Diposit_details();
        }else if (msg.equals("Calculate Bill")){
            new Calculate_bill();
        }else if(msg.equals("View Information")){
            new View_info(metar);
        }else if(msg.equals("Update Information")){
            new Update_info(metar);
        }else if(msg.equals("Bill Details")){
            new Bill_details(metar);
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }else if(msg.equals("Pay Bill")){
            new Pay_bill(metar);
        }else if(msg.equals("Genarate Bill")){
            new Generate_bill(metar);
        }
    }
    
    public static void main(String[] args){
        
        
        new Project("", "");
            
    }
}
