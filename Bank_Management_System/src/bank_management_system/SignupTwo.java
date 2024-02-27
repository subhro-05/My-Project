
package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    
    long random;
    JTextField nametxtfield,fnametxtfield,emailtxtfield,addresstxtfield,citytxtfield,statetxtfield,pincodetxtfield;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datechooser;
    SignupTwo(){
        setLayout(null);
        setTitle("New Account Application From-Page 2:");
        
        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,26));
        additionaldetails.setBounds(230,70,400,30);
        add(additionaldetails);
        
        JLabel religion=new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String  valreligion[]={"Hindu","Muslim","Sikh","Other"};
        JComboBox Religion=new JComboBox(valreligion); 
        Religion.setBounds(300,140,400,30);
        Religion.setBackground(Color.WHITE);
        add(Religion);
        
        JLabel catagory=new JLabel("Catagory: ");
        catagory.setFont(new Font("Raleway",Font.BOLD,20));
        catagory.setBounds(100,190,150,30);
        add(catagory);
        
        String  valcatagory[]={"Generel","SC","ST","OBC","Other"};
        JComboBox Catagory=new JComboBox(valcatagory);
        Catagory.setBounds(300,190,400,30);
        Catagory.setBackground(Color.WHITE);
        add(Catagory);
        
        JLabel income=new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String  valincome[]={"Null","<60,000","<1,00,000","<1,50,000","2,00,000","<2,50,000","3,00,000","Upto 5,00,000"};
        JComboBox Income=new JComboBox(valincome);
        Income.setBounds(300,240,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);
        
        JLabel educational=new JLabel("Educational: ");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,300,200,30);
        add(educational);
        
        String  valeducational[]={"Non Graduation","Graduation","Post Graduation","Doctorate","B.tech","M.tech","BCA","MCA"};
        JComboBox Educational=new JComboBox(valeducational);
        Educational.setBounds(300,310,400,30);
        Educational.setBackground(Color.WHITE);
        add(Educational);
        
        JLabel qualification=new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,325,200,30);
        add(qualification);
      
        JLabel occupation=new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
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
        
        JLabel pan=new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        addresstxtfield=new JTextField();
        addresstxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        addresstxtfield.setBounds(300,440,400,30);
        add(addresstxtfield);
        
        JLabel addhar=new JLabel("Addhar Number: ");
        addhar.setFont(new Font("Raleway",Font.BOLD,20));
        addhar.setBounds(100,490,200,30);
        add(addhar);
        
        citytxtfield=new JTextField();
        citytxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        citytxtfield.setBounds(300,490,400,30);
        add(citytxtfield);
        
        JLabel senior_citizen=new JLabel("Senior Citizen: ");
        senior_citizen.setFont(new Font("Raleway",Font.BOLD,20));
        senior_citizen.setBounds(100,540,200,30);
        add(senior_citizen);
        
        statetxtfield=new JTextField();
        statetxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        statetxtfield.setBounds(300,540,400,30);
        add(statetxtfield);
        
        JLabel existing_account=new JLabel("Existing Account: ");
        existing_account.setFont(new Font("Raleway",Font.BOLD,20));
        existing_account.setBounds(100,590,200,30);
        add(existing_account);
        
        pincodetxtfield=new JTextField();
        pincodetxtfield.setFont(new Font("Raleway",Font.BOLD,20));
        pincodetxtfield.setBounds(300,590,400,30);
        add(pincodetxtfield);
        
        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
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
                String sql="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                con.s.executeUpdate(sql);
            }
        }catch(Exception e){
            System.out.println(e);
            //e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new SignupTwo();
    }
}
