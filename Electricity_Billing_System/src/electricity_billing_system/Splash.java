
package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable {
    Thread t;
    Splash(){
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2=i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        setVisible(true);
        int x=2;
        int i;
        for (i=2;i<600;i+=4,x+=1){
            setSize(i + x,i);
            setLocation(950-((i+x)/2), 500-(i/2));
            try{
                Thread.sleep(5);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        t=new Thread(this);
        t.start();
        setVisible(true); 
    }
    public void run(){
        try{
            Thread.sleep(3000);
            setVisible(false);
            
            //login frame
            new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Splash();
    }
}

