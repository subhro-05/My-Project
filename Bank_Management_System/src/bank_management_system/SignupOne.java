
package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nametxtfield,fnametxtfield,emailtxtfield,addresstxtfield,citytxtfield,statetxtfield,pincodetxtfield;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datechooser;
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("Application From No: "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel perdetails=new JLabel("Page 1: Personal Details");
        perdetails.setFont(new Font("Raleway",Font.BOLD,26));
        perdetails.setBounds(230,70,400,30);
        add(perdetails);
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametxtfield=new JTextField();
        nametxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        nametxtfield.setBounds(300,140,400,30);
        add(nametxtfield);
        
        JLabel fname=new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,150,30);
        add(fname);
        
        fnametxtfield=new JTextField();
        fnametxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        fnametxtfield.setBounds(300,190,400,30);
        add(fnametxtfield);
        
        JLabel dob=new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        datechooser=new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);
        
        JLabel gender=new JLabel("Gerder: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("FeMale");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtxtfield=new JTextField();
        emailtxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        emailtxtfield.setBounds(300,340,400,30);
        add(emailtxtfield);
        
        JLabel marital=new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other=new JRadioButton("Others");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addresstxtfield=new JTextField();
        addresstxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        addresstxtfield.setBounds(300,440,400,30);
        add(addresstxtfield);
        
        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        citytxtfield=new JTextField();
        citytxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        citytxtfield.setBounds(300,490,400,30);
        add(citytxtfield);
        
        JLabel state=new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        statetxtfield=new JTextField();
        statetxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        statetxtfield.setBounds(300,540,400,30);
        add(statetxtfield);
        
        JLabel pincode=new JLabel("Pin code: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodetxtfield=new JTextField();
        pincodetxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        pincodetxtfield.setBounds(300,590,400,30);
        add(pincodetxtfield);
        
        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("A",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(500,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno="",random;
        String name=nametxtfield.getText();
        String fname=fnametxtfield.getText();
        String dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if (male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emailtxtfield.getText();
        String marital=null;
        if (married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if (other.isSelected()){
            marital="Other";
        }
        String address=addresstxtfield.getText();
        String city=citytxtfield.getText();
        String state=statetxtfield.getText();
        String pincode=pincodetxtfield.getText();
        
        
        try{
            conn con=new conn();
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                conn c=new conn();
                String sql="insert into signup (`formno`, `name`, `fname`, `dob`, `gender`, `email`, `marital`, `address`, `city`, `state`, `pincode`) values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                con.s.executeUpdate(sql);
            }
        }catch(Exception e){
            System.out.println(e);
            //e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new SignupOne();
    }
}
